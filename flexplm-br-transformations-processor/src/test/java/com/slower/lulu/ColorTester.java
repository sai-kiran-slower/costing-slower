package com.slower.lulu;

import com.google.common.collect.ImmutableList;
import com.slower.lulu.model.ColorlibHBuilder;
import com.slower.lulu.model.DynamicTransform;
import org.apache.commons.text.CaseUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ColorTester {
    @Test
    public void testCamelCaseConversion() throws Exception {
        List<String> colorProps = ImmutableList.of("memo3", "color_name", "alt_name1", "memo2", "rgb_r", "rgb_g", "rgb_b");

        ColorlibHBuilder builder = new ColorlibHBuilder();
        for (String s : colorProps) {
            String methodName = CaseUtils.toCamelCase("set_" +
                    s, false, '_');

            builder.getClass().getMethod(methodName, String.class).invoke(builder, "colorwayCombination");

            // TODO Add test for attachment setting
        }
    }

    @Test
    public void dynamicLoadTest() throws IOException {
        Map transformations = DynamicTransform.getTransformations("config/if_2_color_transforms.yaml");

    }


}
