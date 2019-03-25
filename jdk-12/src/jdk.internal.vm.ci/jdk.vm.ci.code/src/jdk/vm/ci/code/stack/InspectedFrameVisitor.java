/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code.stack;

/**
 * Callback interface for {@link StackIntrospection#iterateFrames}. Implementations of
 * {@link #visitFrame} return null to indicate that frame iteration should continue and the next
 * caller frame should be visited; and return any non-null value to indicate that frame iteration
 * should stop.
 */
public interface InspectedFrameVisitor<T> {

    T visitFrame(InspectedFrame frame);
}
