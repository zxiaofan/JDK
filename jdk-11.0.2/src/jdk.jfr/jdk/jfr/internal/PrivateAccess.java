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

package jdk.jfr.internal;

import java.util.List;
import java.util.Map;

import jdk.jfr.AnnotationElement;
import jdk.jfr.Configuration;
import jdk.jfr.EventType;
import jdk.jfr.FlightRecorderPermission;
import jdk.jfr.Recording;
import jdk.jfr.SettingDescriptor;
import jdk.jfr.ValueDescriptor;

/**
 * Provides access to package private function in jdk.jfr.
 * <p>
 * The static initializer in this class loads the Settings class, which will
 * call {@link #setPrivateAccess(PrivateAccess)} on this class, which can be
 * used call to package protected methods.
 *
 * This is similar to how java.lang accesses package private methods in
 * java.lang.reflect.
 */
public abstract class PrivateAccess {
    private volatile static PrivateAccess instance;

    public static PrivateAccess getInstance() {
        // Can't be initialized in <clinit> because it may
        // deadlock with FlightRecordeerPermission.<clinit>
        if (instance == null) {
            // Will trigger
            // FlightRecordeerPermission.<clinit>
            // which will call PrivateAccess.setPrivateAccess
            new FlightRecorderPermission(Utils.REGISTER_EVENT);
        }
        return instance;
    }

    public static void setPrivateAccess(PrivateAccess pa) {
        instance = pa;
    }

    public abstract Type getType(Object o);

    public abstract Configuration newConfiguration(String name, String label, String description, String provider, Map<String,String> settings, String contents);

    public abstract EventType newEventType(PlatformEventType eventTypes);

    public abstract AnnotationElement newAnnotation(Type annotationType, List<Object> values, boolean boot);

    public abstract ValueDescriptor newValueDescriptor(String name, Type fieldType, List<AnnotationElement> annotations, int dimension, boolean constantPool, String fieldName);

    public abstract PlatformRecording getPlatformRecording(Recording r);

    public abstract PlatformEventType getPlatformEventType(EventType eventType);

    public abstract boolean isConstantPool(ValueDescriptor v);

    public abstract String getFieldName(ValueDescriptor v);

    public abstract ValueDescriptor newValueDescriptor(Class<?> type, String name);

    public abstract SettingDescriptor newSettingDescriptor(Type type, String name, String def, List<AnnotationElement> aes);

    public abstract void setAnnotations(ValueDescriptor v, List<AnnotationElement> a);

    public abstract void setAnnotations(SettingDescriptor s, List<AnnotationElement> a);

    public abstract boolean isUnsigned(ValueDescriptor v);

    public abstract PlatformRecorder getPlatformRecorder();
}
