package com.slower.lulu.utils;

import com.slower.lulu.model.Attribute;

public class Functions {

    public static String charLimit(final String attrValue, final int attrLen) {
        if (attrValue.length() > attrLen) {
            return attrValue.substring(0, attrLen);
        }
        return attrValue;
    }

    public static boolean isChanged(final Attribute attribute) {
        return attribute.getCHANGEIND().equals("Y");
    }
}
