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
     * Accesses the current stack, providing {@link InspectedFrame}s to the visitor that can be used
     * to inspect the stack frames' contents. Iteration continues as long as
     * {@link InspectedFrameVisitor#visitFrame}, which is invoked for every {@link InspectedFrame},
     * returns null. Any non-null result of the visitor indicates that frame iteration should stop.
     *
     * @param initialMethods if this is non-{@code null}, then the stack trace will start at these
     *            methods
     * @param matchingMethods if this is non-{@code null}, then only matching stack frames are
     *            returned
     * @param initialSkip the number of matching methods to skip (including the initial method)
     * @param visitor the visitor that is called for every matching method
     * @return the last result returned by the visitor (which is non-null to indicate that iteration
     *         should stop), or null if the whole stack was iterated.
     */
    <T> T iterateFrames(ResolvedJavaMethod[] initialMethods, ResolvedJavaMethod[] matchingMethods, int initialSkip, InspectedFrameVisitor<T> visitor);
}
