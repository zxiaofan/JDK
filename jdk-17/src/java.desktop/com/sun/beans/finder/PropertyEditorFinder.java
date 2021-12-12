/*
 * Copyright (c) 2009, 2012, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.finder;

import com.sun.beans.WeakCache;

import java.beans.PropertyEditor;

import com.sun.beans.editors.BooleanEditor;
import com.sun.beans.editors.ByteEditor;
import com.sun.beans.editors.DoubleEditor;
import com.sun.beans.editors.EnumEditor;
import com.sun.beans.editors.FloatEditor;
import com.sun.beans.editors.IntegerEditor;
import com.sun.beans.editors.LongEditor;
import com.sun.beans.editors.ShortEditor;

/**
 * This is utility class that provides functionality
 * to find a {@link PropertyEditor} for a JavaBean specified by its type.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public final class PropertyEditorFinder
        extends InstanceFinder<PropertyEditor> {

    private static final String DEFAULT = "sun.beans.editors";
    private static final String DEFAULT_NEW = "com.sun.beans.editors";

    private final WeakCache<Class<?>, Class<?>> registry;

    public PropertyEditorFinder() {
        super(PropertyEditor.class, false, "Editor", DEFAULT);

        this.registry = new WeakCache<Class<?>, Class<?>>();
        this.registry.put(Byte.TYPE, ByteEditor.class);
        this.registry.put(Short.TYPE, ShortEditor.class);
        this.registry.put(Integer.TYPE, IntegerEditor.class);
        this.registry.put(Long.TYPE, LongEditor.class);
        this.registry.put(Boolean.TYPE, BooleanEditor.class);
        this.registry.put(Float.TYPE, FloatEditor.class);
        this.registry.put(Double.TYPE, DoubleEditor.class);
    }

    public void register(Class<?> type, Class<?> editor) {
        synchronized (this.registry) {
            this.registry.put(type, editor);
        }
    }

    @Override
    public PropertyEditor find(Class<?> type) {
        Class<?> predefined;
        synchronized (this.registry) {
            predefined = this.registry.get(type);
        }
        PropertyEditor editor = instantiate(predefined, null);
        if (editor == null) {
            editor = super.find(type);
            if ((editor == null) && (null != type.getEnumConstants())) {
                editor = new EnumEditor(type);
            }
        }
        return editor;
    }

    @Override
    protected PropertyEditor instantiate(Class<?> type, String prefix, String name) {
        return super.instantiate(type, DEFAULT.equals(prefix) ? DEFAULT_NEW : prefix, name);
    }
}
