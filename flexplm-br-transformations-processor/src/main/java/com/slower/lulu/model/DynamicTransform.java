package com.slower.lulu.model;

import com.google.common.base.Optional;
import com.slower.lulu.utils.Functions;
import org.apache.commons.lang3.StringUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DynamicTransform {
    private final String outputField;
    private final int length;
    private final boolean useObjectIdIfEmpty;
    private final Optional<String> useLookupTable;
    private final boolean isAttachment;
    private final boolean isAlwaysIncluded;

    public DynamicTransform(final String outputField,
                            final int length,
                            boolean useObjectIdIfEmpty,
                            final Optional<String> useLookupTable,
                            final boolean isAttachment,
                            final boolean isAlwaysIncluded) {
        this.outputField = outputField;
        this.length = length;
        this.useObjectIdIfEmpty = useObjectIdIfEmpty;
        this.useLookupTable = useLookupTable;
        this.isAttachment = isAttachment;
        this.isAlwaysIncluded = isAlwaysIncluded;
    }

    public String getOutputField() {
        return outputField;
    }

    public int getLength() {
        return length;
    }

    public boolean getUseObjectIdIfEmpty() {
        return useObjectIdIfEmpty;
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

    /**
     *
     * Either do a lookup or a useObjectIdIfEmpty / Empty lookup
     * This doesn't care about the field name
     */
    public String resolveValue(final Attribute attribute) {
        final String flexValue = attribute.getFIELDVALUEKEY();

        if (getUseObjectIdIfEmpty() && (flexValue == null || flexValue.trim().isEmpty())) {
            return attribute.getOBJECTID();
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
        boolean fieldIfNull = (boolean) fieldAttributes.getOrDefault("object_id_if_empty", false);

        Optional<String> lookupTable =
                Optional.fromNullable((String) fieldAttributes.getOrDefault("lookup", null));

        boolean isAttachment  =
                ((boolean) fieldAttributes.getOrDefault("is_attachment", false));

        boolean isAlwaysIncluded  =
                ((boolean) fieldAttributes.getOrDefault("always_included", false));

        return new DynamicTransform(outputField, length, fieldIfNull, lookupTable, isAttachment, isAlwaysIncluded);
    }

    public static List<Map.Entry<String, String>> getStaticDefaults(final Map transformations) {
        Map<String, String> staticDefaults = (Map<String, String>) transformations.get("static_defaults");

        return staticDefaults.entrySet().stream().collect(Collectors.toList());
    }
}
