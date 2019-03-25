/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Objects;
import java.util.Set;

import jdk.jfr.BooleanFlag;
import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.internal.Control;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.Utils;

@MetadataDefinition
@Label("Cutoff")
@Description("Limit running time of event")
@Name(Type.SETTINGS_PREFIX + "Cutoff")
@BooleanFlag
public final class CutoffSetting extends Control {
    private final static long typeId = Type.getTypeId(CutoffSetting.class);

    private String value = "0 ns";
    private final PlatformEventType eventType;

    public CutoffSetting(PlatformEventType eventType, String defaultValue) {
       super(defaultValue);
       this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {
        long max = 0;
        String text = "0 ns";
        for (String value : values) {
            long l = parseValue(value);
            if (l > max) {
                text = value;
                max = l;
            }
        }
        return text;
    }

    @Override
    public void setValue(String value) {
        long l = parseValue(value);
        this.value = value;
        eventType.setCutoff(l);
    }

    private long parseValue(String value) {
        return isInfinity(value) ? Long.MAX_VALUE : Utils.parseTimespan(value);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static boolean isType(long typeId) {
        return CutoffSetting.typeId == typeId;
    }

    private static boolean isInfinity(String s) {
        return s.equals("infinity");
    }

    public static long parseValueSafe(String value) {
        if (value == null) {
            return 0L;
        }
        try {
            return isInfinity(value) ? Long.MAX_VALUE : Utils.parseTimespan(value);
        } catch (NumberFormatException nfe) {
            return 0L;
        }
    }
}
