/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager;

public enum TemplatePlaceholders {

    //location of dtjava.js
    SCRIPT_URL("DT.SCRIPT.URL"),
    //script element to include dtjava.js
    SCRIPT_CODE("DT.SCRIPT.CODE"),
    //code to embed applet into given placeholder
    //need to be wrapped with function()
    EMBED_CODE_DYNAMIC("DT.EMBED.CODE.DYNAMIC"),
    //code needed to embed applet fron the onload hook (except inclusion of dtjava.js)
    EMBED_CODE_ONLOAD("DT.EMBED.CODE.ONLOAD"),
    //code need to launch application
    //need to be wrapped with function()
    LAUNCH_CODE("DT.LAUNCH.CODE"),

    EMBED_STATIC_HEADER("DT.EMBED.STATIC.HEADER"),
    EMBED_STATIC_FOOTER("DT.EMBED.STATIC.FOOTER"),
    EMBED_STATIC_CODE("DT.EMBED.STATIC.CODE");

    private String placeholder;

    private TemplatePlaceholders(String ph) {
        placeholder = ph;
    }
    public String getPlaceholder() {
        return placeholder;
    }

    public static TemplatePlaceholders fromString(String text) {
        if (text != null) {
            for (TemplatePlaceholders b : TemplatePlaceholders.values()) {
                if (text.equalsIgnoreCase(b.placeholder)) {
                    return b;
                }
            }
        }
        return null;
    }
}
