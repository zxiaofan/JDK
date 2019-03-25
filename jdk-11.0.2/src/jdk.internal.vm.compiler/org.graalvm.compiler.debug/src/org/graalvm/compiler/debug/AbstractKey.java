/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.debug;

/**
 * A name and index for a metric value.
 */
abstract class AbstractKey implements MetricKey {

    private final String nameFormat;
    private final Object nameArg1;
    private final Object nameArg2;

    private String name;
    private int index;
    private String doc;

    protected AbstractKey(String nameFormat, Object nameArg1, Object nameArg2) {
        this.nameFormat = nameFormat;
        this.nameArg1 = nameArg1;
        this.nameArg2 = nameArg2;
        this.index = -1;
    }

    protected void setDoc(String doc) {
        this.doc = doc;
    }

    @Override
    public String getDoc() {
        return doc;
    }

    @Override
    public String getDocName() {
        return getName();
    }

    public long getCurrentValue(DebugContext debug) {
        ensureInitialized();
        return debug.getMetricValue(index);
    }

    void setCurrentValue(DebugContext debug, long l) {
        ensureInitialized();
        debug.setMetricValue(index, l);
    }

    void ensureInitialized() {
        if (index == -1) {
            index = KeyRegistry.register(this);
        }
    }

    void addToCurrentValue(DebugContext debug, long value) {
        ensureInitialized();
        debug.setMetricValue(index, debug.getMetricValue(index) + value);
    }

    /**
     * Gets the globally unique index for the value represented by this object.
     */
    public int getIndex() {
        ensureInitialized();
        return index;
    }

    /**
     * Gets the globally unique name for the value represented by this object.
     */
    @Override
    public String getName() {
        if (name == null) {
            name = createName(nameFormat, nameArg1, nameArg2);
        }
        return name;
    }

    protected String createName(String format, Object arg1, Object arg2) {
        return DebugContext.formatDebugName(format, arg1, arg2);
    }

    @Override
    public String toString() {
        return getName() + "@" + index;
    }
}
