package com.slower.lulu;

import com.google.common.collect.ImmutableList;
import io.swagger.client.model.ColorlibH;
import org.apache.commons.text.CaseUtils;
import org.junit.Test;

import java.util.List;

public class ColorTester {
    @Test
    public void testCamelCaseConversion() throws Exception {
        List<String> colorProps = ImmutableList.of("memo3", "color_name", "alt_name1", "memo2", "rgb_r", "rgb_g", "rgb_b");

        ColorlibH builder = new ColorlibH();
        for (String s : colorProps) {
            String methodName = CaseUtils.toCamelCase("set_" +
                    s, false, '_');

            builder.getClass().getMethod(methodName, String.class).invoke(builder, "colorwayCombination");

            // TODO Add test for attachment setting
        }
    }
}
