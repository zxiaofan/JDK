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
 * A recorded Java thread group.
 *
 * @since 9
 */
public final class RecordedThreadGroup extends RecordedObject {
    // package private
    RecordedThreadGroup(ObjectContext objectContext, Object[] values) {
        super(objectContext, values);
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
     * @return parent thread group, or {@code null} if it doesn't exist
     */
    public RecordedThreadGroup getParent() {
        return getTyped("parent", RecordedThreadGroup.class, null);
    }
}
