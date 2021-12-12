/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.settings;

import java.util.Set;

/**
 * Helper class for settings that use boolean numbers
 *
 */
final class BooleanValue  {
    private String value = "false";
    private boolean booleanValue;

    private BooleanValue(boolean b) {
        booleanValue = b;
        value = b ? "true" : "false";
    }

    public String union(Set<String> values) {
        for (String v : values) {
            if ("true".equals(v)) {
                return "true";
            }
        }
        return "false";
    }

    public void setValue(String value) {
        this.value = value;
        this.booleanValue = Boolean.valueOf(value);
    }

    public final String getValue() {
        return this.value;
    }

    public boolean getBoolean() {
        return booleanValue;
    }

    public static BooleanValue valueOf(String defaultValue) {
        if ("true".equals(defaultValue)) {
            return new BooleanValue(true);
        }
        if ("false".equals(defaultValue)) {
            return new BooleanValue(false);
        }
        throw new InternalError("Unknown default value for settings '" + defaultValue + "'");
    }
}
