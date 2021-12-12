/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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
@Label("Threshold")
@Name(Type.SETTINGS_PREFIX + "Threshold")
@Description("Record event with duration above or equal to threshold")
@Timespan
public final class ThresholdSetting extends JDKSettingControl {
    private static final long typeId = Type.getTypeId(ThresholdSetting.class);
    private String value = "0 ns";
    private final PlatformEventType eventType;

    public ThresholdSetting(PlatformEventType eventType) {
       this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {
        Long min = null;
        String text = null;
        for (String value : values) {
            long l = Utils.parseTimespanWithInfinity(value);
            // always accept first value
            if (min == null) {
                min = l;
                text = value;
            } else {
                if (l < min) {
                    text = value;
                    min = l;
                }
            }
        }
        return text == null ? "0 ns" : text;
    }

    @Override
    public void setValue(String value) {
        long l = Utils.parseTimespanWithInfinity(value);
        this.value = value;
        eventType.setThreshold(l);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static boolean isType(long typeId) {
        return ThresholdSetting.typeId == typeId;
    }
}
