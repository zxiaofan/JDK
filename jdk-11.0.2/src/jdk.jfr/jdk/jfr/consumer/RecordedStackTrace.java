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

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import jdk.jfr.ValueDescriptor;
import jdk.jfr.internal.Type;

/**
 * A recorded stack trace.
 *
 * @since 9
 */
public final class RecordedStackTrace extends RecordedObject {

    static ObjectFactory<RecordedStackTrace> createFactory(Type type, TimeConverter timeConverter) {
        return new ObjectFactory<RecordedStackTrace>(type) {
            @Override
            RecordedStackTrace createTyped(List<ValueDescriptor> desc, long id, Object[] object) {
                return new RecordedStackTrace(desc, object, timeConverter);
            }
        };
    }

    private RecordedStackTrace(List<ValueDescriptor> desc, Object[] values, TimeConverter timeConverter) {
        super(desc, values, timeConverter);
    }

    /**
     * Returns the frames in the stack trace.
     *
     * @return a list of Java stack frames, not {@code null}
     */
    @SuppressWarnings("unchecked")
    public List<RecordedFrame> getFrames() {
        Object[] array = getTyped("frames", Object[].class, null);
        if (array == null) {
            return Collections.EMPTY_LIST;
        }
        List<?> list = Arrays.asList(array);
        return (List<RecordedFrame>) list;
    }

    /**
     * Returns {@code true} if the stack trace is truncated due to its size,
     * {@code false} otherwise.
     *
     * @return {@code true} if the stack trace is truncated, {@code false}
     *         otherwise
     */
    public boolean isTruncated() {
        return getTyped("truncated", Boolean.class, true);
    }
}
