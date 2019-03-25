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

import java.util.Objects;
import java.util.Set;

import jdk.jfr.Description;
import jdk.jfr.BooleanFlag;
import jdk.jfr.Label;
import jdk.jfr.MetadataDefinition;
import jdk.jfr.Name;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.Type;
import jdk.jfr.internal.Control;

@MetadataDefinition
@Label("Enabled")
@Description("Record event")
@Name(Type.SETTINGS_PREFIX + "Enabled")
@BooleanFlag
public final class EnabledSetting extends Control {
    private final BooleanValue booleanValue;
    private final PlatformEventType eventType;

    public EnabledSetting(PlatformEventType eventType, String defaultValue) {
        super(defaultValue);
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
        eventType.setEnabled(booleanValue.getBoolean());
        if (eventType.isEnabled() && !eventType.isJVM()) {
            if (!eventType.isInstrumented()) {
                eventType.markForInstrumentation(true);
            }
        }
    }

    @Override
    public String getValue() {
        return booleanValue.getValue();
    }
}
