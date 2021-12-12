/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2020, Datadog, Inc. All rights reserved.
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
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.Utils;

@MetadataDefinition
@Label("Event Emission Throttle")
@Description("Throttles the emission rate for an event")
@Name(Type.SETTINGS_PREFIX + "Throttle")
public final class ThrottleSetting extends JDKSettingControl {
    private static final long typeId = Type.getTypeId(ThrottleSetting.class);
    private static final long OFF = -2;
    private String value = "0/s";
    private final PlatformEventType eventType;

    public ThrottleSetting(PlatformEventType eventType) {
       this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {
        long max = OFF;
        String text = "off";
        for (String value : values) {
            long l = parseValueSafe(value);
            if (l > max) {
                text = value;
                max = l;
            }
        }
        return text;
    }

    private static long parseValueSafe(String s) {
        long value = 0L;
        try {
            value = Utils.parseThrottleValue(s);
        } catch (NumberFormatException nfe) {
        }
        return value;
    }

    @Override
    public void setValue(String s) {
        long size = 0;
        long millis = 1000;
        try {
            size = Utils.parseThrottleValue(s);
            millis = Utils.parseThrottleTimeUnit(s);
            this.value = s;
        } catch (NumberFormatException nfe) {
        }
        eventType.setThrottle(size, millis);
    }

    @Override
    public String getValue() {
        return value;
    }

    public static boolean isType(long typeId) {
        return ThrottleSetting.typeId == typeId;
    }
}

