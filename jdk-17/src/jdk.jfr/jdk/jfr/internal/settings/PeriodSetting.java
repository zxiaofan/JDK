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
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.Utils;

@MetadataDefinition
@Label("Period")
@Description("Record event at interval")
@Name(Type.SETTINGS_PREFIX + "Period")
public final class PeriodSetting extends JDKSettingControl {
    private static final long typeId = Type.getTypeId(PeriodSetting.class);

    public static final String EVERY_CHUNK = "everyChunk";
    public static final String BEGIN_CHUNK = "beginChunk";
    public static final String END_CHUNK = "endChunk";
    public static final String NAME = "period";
    private final PlatformEventType eventType;
    private String value = EVERY_CHUNK;

    public PeriodSetting(PlatformEventType eventType) {
        this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {

        boolean beginChunk = false;
        boolean endChunk = false;
        Long min = null;
        String text = null;
        for (String value : values) {
            switch (value) {
            case EVERY_CHUNK:
                beginChunk = true;
                endChunk = true;
                break;
            case BEGIN_CHUNK:
                beginChunk = true;
                break;
            case END_CHUNK:
                endChunk = true;
                break;
            default:
                long l = Utils.parseTimespanWithInfinity(value);
                // Always accept first specified value
                if (min == null) {
                    text = value;
                    min = l;
                } else {
                    if (l < min) {
                        text = value;
                        min = l;
                    }
                }
            }
        }
        // A specified interval trumps *_CHUNK
        if (min != null) {
            return text;
        }
        if (beginChunk && !endChunk) {
            return BEGIN_CHUNK;
        }
        if (!beginChunk && endChunk) {
            return END_CHUNK;
        }
        return EVERY_CHUNK; // also default
    }

    @Override
    public void setValue(String value) {
        switch (value) {
        case EVERY_CHUNK:
            eventType.setPeriod(0, true, true);
            break;
        case BEGIN_CHUNK:
            eventType.setPeriod(0, true, false);
            break;
        case END_CHUNK:
            eventType.setPeriod(0, false, true);
            break;
        default:
            long nanos = Utils.parseTimespanWithInfinity(value);
            if (nanos != Long.MAX_VALUE) {
                eventType.setPeriod(nanos / 1_000_000, false, false);
            } else {
                eventType.setPeriod(Long.MAX_VALUE, false, false);
            }
        }
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    public static boolean isType(long typeId) {
        return PeriodSetting.typeId == typeId;
    }
}
