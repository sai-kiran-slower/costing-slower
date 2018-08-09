package com.slower.lulu.model;

import com.google.common.base.Optional;
import com.slower.lulu.utils.Functions;
import io.swagger.model.Attribute;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicTransform {
    private static final Logger logger = LoggerFactory.getLogger(DynamicTransform.class);

    private final String outputField;
    private final int length;
    private final Optional<String> fieldIfEmpty;
    private final Optional<String> useLookupTable;
    private final boolean isAttachment;
    private final boolean isAlwaysIncluded;
    private final Optional<String> builderList; // Some interfaces, e.g. artwork, have multiple builders with only a subset of data included in each, this handles that differentiation

    public DynamicTransform(final String outputField,
                            final int length,
                            final Optional<String> fieldIfEmpty,
                            final Optional<String> useLookupTable,
                            final boolean isAttachment,
                            final boolean isAlwaysIncluded,
                            final Optional<String> builderList) {
        this.outputField = outputField;
        this.length = length;
        this.fieldIfEmpty = fieldIfEmpty;
        this.useLookupTable = useLookupTable;
        this.isAttachment = isAttachment;
        this.isAlwaysIncluded = isAlwaysIncluded;
        this.builderList = builderList;
    }

    public String getOutputField() {
        return outputField;
    }

    public int getLength() {
        return length;
    }

    public Optional<String> getFieldIfEmpty() {
        return fieldIfEmpty;
    }

    public Optional<String> getUseLookupTable() {
        return useLookupTable;
    }

    public boolean isAttachment() {
        return isAttachment;
    }

    public boolean isAlwaysIncluded() {
        return isAlwaysIncluded;
    }

    public Optional<String> getBuilderList() {
        return builderList;
    }

    /**
     *
     * Either do a lookup or a getFieldIfEmpty / Empty lookup
     * This doesn't care about the field name
     */
    public String resolveValue(final Attribute attribute) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        final String flexValue = attribute.getFIELDVALUEKEY();
        return resolveValue(attribute, flexValue);
    }

    public String resolveValue(final Attribute attribute, final String flexValue) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        if (getFieldIfEmpty().isPresent() && (flexValue == null || flexValue.trim().isEmpty())) {
            final Method getMethod;
            final String getMethodName = "get" + getFieldIfEmpty().get().toUpperCase();
            try {

                getMethod = attribute.getClass().getMethod(getMethodName);
                return (String) getMethod.invoke(attribute);
            } catch (NoSuchMethodException e) {
                logger.error("Failed to find method with name: " + getMethodName + ". Check field_if_empty definition to ensure it matches a FlexPLM field in dynamic mapping configuration file.");
                throw e;
            }
        } else if (useLookupTable.isPresent()) {
            return StringUtils.left(Functions.getBRCodeReflected(useLookupTable.get(), flexValue), getLength());
        } else {
            return StringUtils.left(flexValue, getLength());
        }
    }

    public static Map getTransformations(final String configSpec) {
        Yaml yaml = new Yaml();

        InputStream resource = Thread.currentThread().getContextClassLoader().getResourceAsStream(configSpec);

        // Convert to lower case keys // Hideous map manipulation due to nested maps
        Map<String, Map> returnMap = ((Map<String, Map>) yaml.load(resource)).entrySet()
                .stream()
                .collect(
                        Collectors.toMap(x -> x.getKey().toLowerCase(),
                                y -> ((Map<String, Map>) y.getValue())
                                        .entrySet()
                                        .stream()
                                        .collect(Collectors.toMap(
                                             f -> f.getKey().toLowerCase(), Map.Entry::getValue
                                        )))
                );
        return returnMap;
    }

    public static DynamicTransform getDynamicTransform(final Map transformations, final String fieldName) {
        Map dynamicLookups = (Map) transformations.get("dynamic");
        Map fieldAttributes = (Map) dynamicLookups.get(fieldName.toLowerCase());

        if (fieldAttributes == null) {
            throw new IllegalArgumentException("Failed to match field name: " + fieldName);
        }

        String outputField = (String) fieldAttributes.get("output");
        int length = (int) fieldAttributes.get("length");
        Optional<String> fieldIfEmpty = Optional.fromNullable((String) fieldAttributes.getOrDefault("field_if_empty", null));

        Optional<String> lookupTable =
                Optional.fromNullable((String) fieldAttributes.getOrDefault("lookup", null));

        boolean isAttachment  =
                ((boolean) fieldAttributes.getOrDefault("is_attachment", false));

        boolean isAlwaysIncluded  =
                ((boolean) fieldAttributes.getOrDefault("always_included", false));

        Optional<String> builderList =
                Optional.fromNullable((String) fieldAttributes.getOrDefault("builder_list", null));

        return new DynamicTransform(outputField, length, fieldIfEmpty, lookupTable, isAttachment, isAlwaysIncluded, builderList);
    }

    public static List<Map.Entry<String, String>> getStaticDefaults(final Map transformations) {
        Map<String, String> staticDefaults = (Map<String, String>) transformations.get("static_defaults");

        return staticDefaults.entrySet().stream().collect(Collectors.toList());
    }

    // Dynamic value etting with camel case conversion
    public static void setValue(final Object builder,
                                final String fieldName,
                                final String value) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        final Method setMethod;
        final String setMethodName = Functions.setToCamelCase(fieldName);
        try {
            setMethod = builder.getClass().getMethod(setMethodName, String.class);
            setMethod.invoke(builder, value);
        } catch (NoSuchMethodException e) {
            logger.error("Failed to find method with name: " + setMethodName + ". Check output field name and/or static field name in dynamic mapping configuration file.");
            throw e;
        }
    }
}
