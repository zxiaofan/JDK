/*
 * Copyright (c) 1996, 2012, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */


package com.sun.beans.editors;

import java.beans.*;

public class StringEditor extends PropertyEditorSupport {

    public String getJavaInitializationString() {
        Object value = getValue();
        if (value == null)
            return "null";

        String str = value.toString();
        int length = str.length();
        StringBuilder sb = new StringBuilder(length + 2);
        sb.append('"');
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            switch (ch) {
            case '\b': sb.append("\\b");  break;
            case '\t': sb.append("\\t");  break;
            case '\n': sb.append("\\n");  break;
            case '\f': sb.append("\\f");  break;
            case '\r': sb.append("\\r");  break;
            case '\"': sb.append("\\\""); break;
            case '\\': sb.append("\\\\"); break;
            default:
                if ((ch < ' ') || (ch > '~')) {
                    sb.append("\\u");
                    String hex = Integer.toHexString((int) ch);
                    for (int len = hex.length(); len < 4; len++) {
                        sb.append('0');
                    }
                    sb.append(hex);
                } else {
                    sb.append(ch);
                }
                break;
            }
        }
        sb.append('"');
        return sb.toString();
    }

    public void setAsText(String text) {
        setValue(text);
    }

}
