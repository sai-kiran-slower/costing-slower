package com.slower.lulu.utils;

public class Functions {

    public static String charLimit(String attrValue, int attrLen) {
        if (attrValue.length() > attrLen) {
            return attrValue.substring(0, attrLen);
        }
        return attrValue;
    }
}
