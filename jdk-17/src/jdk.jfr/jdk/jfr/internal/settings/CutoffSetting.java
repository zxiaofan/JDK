/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.Timespan;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.Utils;

@MetadataDefinition
@Label("Cutoff")
@Description("Limit running time of event")
@Name(Type.SETTINGS_PREFIX + "Cutoff")
@Timespan
public final class CutoffSetting extends JDKSettingControl {
    private static final long typeId = Type.getTypeId(CutoffSetting.class);

    private String value = "0 ns";
    private final PlatformEventType eventType;

    public CutoffSetting(PlatformEventType eventType) {
       this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {
        long max = 0;
        String text = "0 ns";
        for (String value : values) {
            long l =  Utils.parseTimespanWithInfinity(value);
            if (l > max) {
                text = value;
                max = l;
            }
        }
        return text;
    }

    @Override
    public void setValue(String value) {
        long l =  Utils.parseTimespanWithInfinity(value);
        this.value = value;
        eventType.setCutoff(l);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static boolean isType(long typeId) {
        return CutoffSetting.typeId == typeId;
    }

    public static long parseValueSafe(String value) {
        if (value == null) {
            return 0L;
        }
        try {
            return Utils.parseTimespanWithInfinity(value);
        } catch (NumberFormatException nfe) {
            return 0L;
        }
    }
}
