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
import jdk.jfr.BooleanFlag;
import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;

@MetadataDefinition
@Label("Stack Trace")
@Name(Type.SETTINGS_PREFIX + "StackTrace")
@Description("Record stack traces")
@BooleanFlag
public final class StackTraceSetting extends JDKSettingControl {
    private static final long typeId =  Type.getTypeId(StackTraceSetting.class);
    private final BooleanValue booleanValue;
    private final PlatformEventType eventType;

    public StackTraceSetting(PlatformEventType eventType, String defaultValue) {
        this.booleanValue = BooleanValue.valueOf(defaultValue);
        this.eventType = Objects.requireNonNull(eventType);
    }

    @Override
    public String combine(Set<String> values) {
        return booleanValue.union(values);
    }

    @Override
    public void setValue(String value) {
        booleanValue.setValue(value);
        eventType.setStackTraceEnabled(booleanValue.getBoolean());
    }

    @Override
    public String getValue() {
        return booleanValue.getValue();
    }

    public static boolean isType(long typeId) {
        return StackTraceSetting.typeId == typeId;
    }
}
