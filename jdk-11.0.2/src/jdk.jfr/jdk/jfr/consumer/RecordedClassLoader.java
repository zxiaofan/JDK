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

package jdk.jfr.consumer;

import java.util.List;

import jdk.jfr.ValueDescriptor;
import jdk.jfr.internal.Type;

/**
 * A recorded Java class loader.
 *
 * @since 9
 */
public final class RecordedClassLoader extends RecordedObject {

    static ObjectFactory<RecordedClassLoader> createFactory(Type type, TimeConverter timeConverter) {
        return new ObjectFactory<RecordedClassLoader>(type) {
            @Override
            RecordedClassLoader createTyped(List<ValueDescriptor> desc, long id, Object[] object) {
                return new RecordedClassLoader(desc, id, object, timeConverter);
            }
        };
    }

    private final long uniqueId;

    // package private
    private RecordedClassLoader(List<ValueDescriptor> descriptors, long id, Object[] values, TimeConverter timeConverter) {
        super(descriptors, values, timeConverter);
        this.uniqueId = id;
    }

    /**
     * Returns the class of the class loader.
     * <P>
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
