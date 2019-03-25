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

import jdk.vm.ci.meta.ResolvedJavaMethod;

public interface StackIntrospection {

    /**
     * Walks the current stack, providing {@link InspectedFrame}s to the visitor that can be used to
     * inspect the stack frame's contents. Iteration continues as long as
     * {@link InspectedFrameVisitor#visitFrame}, which is invoked for every {@link InspectedFrame},
     * returns {@code null}. A non-null return value from {@link InspectedFrameVisitor#visitFrame}
     * indicates that frame iteration should stop.
     *
     * @param initialMethods if this is non-{@code null}, then the stack walk will start at the
     *            first frame whose method is one of these methods.
     * @param matchingMethods if this is non-{@code null}, then only frames whose methods are in
     *            this array are visited
     * @param initialSkip the number of matching methods to skip (including the initial method)
     * @param visitor the visitor that is called for every matching method
     * @return the last result returned by the visitor (which is non-null to indicate that iteration
     *         should stop), or null if the whole stack was iterated.
     */
    <T> T iterateFrames(ResolvedJavaMethod[] initialMethods, ResolvedJavaMethod[] matchingMethods, int initialSkip, InspectedFrameVisitor<T> visitor);
}
