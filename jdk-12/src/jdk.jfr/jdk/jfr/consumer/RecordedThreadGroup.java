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
 * A recorded Java thread group.
 *
 * @since 9
 */
public final class RecordedThreadGroup extends RecordedObject {

    static ObjectFactory<RecordedThreadGroup> createFactory(Type type, TimeConverter timeConverter) {
        return new ObjectFactory<RecordedThreadGroup>(type) {
            @Override
            RecordedThreadGroup createTyped(List<ValueDescriptor> desc, long id, Object[] object) {
                return new RecordedThreadGroup(desc, object, timeConverter);
            }
        };
    }

    private RecordedThreadGroup(List<ValueDescriptor> descriptors, Object[] objects, TimeConverter timeConverter) {
        super(descriptors, objects, timeConverter);
    }

    /**
     * Returns the name of the thread group, or {@code null} if doesn't exist.
     *
     * @return the thread group name, or {@code null} if doesn't exist
     */
    public String getName() {
        return getTyped("name", String.class, null);
    }

    /**
     * Returns the parent thread group, or {@code null} if it doesn't exist.
     *
     * @return parent thread group, or {@code null} if it doesn't exist.
     */
    public RecordedThreadGroup getParent() {
        return getTyped("parent", RecordedThreadGroup.class, null);
    }
}
