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

package jdk.jfr.consumer;

import jdk.jfr.internal.consumer.ObjectContext;

/**
 * A recorded Java class loader.
 *
 * @since 9
 */
public final class RecordedClassLoader extends RecordedObject {
    private final long uniqueId;

    // package private
    RecordedClassLoader(ObjectContext objectContext, long id, Object[] values) {
        super(objectContext, values);
        this.uniqueId = id;
    }

    /**
     * Returns the class of the class loader.
     * <p>
     * If the bootstrap class loader is represented as {@code null} in the Java
     * Virtual Machine (JVM), then {@code null} is also the return value of this
     * method.
     *
     * @return class of the class loader, can be {@code null}
     */
    public RecordedClass getType() {
        return getTyped("type", RecordedClass.class, null);
    }

    /**
     * Returns the name of the class loader (for example, "boot", "platform", and
     * "app").
     *
     * @return the class loader name, can be {@code null}
     */
    public String getName() {
        return getTyped("name", String.class, null);
    }

    /**
     * Returns a unique ID for the class loader.
     * <p>
     * The ID might not be the same between Java Virtual Machine (JVM) instances.
     *
     * @return a unique ID
     */
    public long getId() {
        return uniqueId;
    }
}
