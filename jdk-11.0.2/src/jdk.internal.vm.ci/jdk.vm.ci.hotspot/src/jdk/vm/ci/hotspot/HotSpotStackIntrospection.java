/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

import jdk.vm.ci.code.stack.InspectedFrameVisitor;
import jdk.vm.ci.code.stack.StackIntrospection;
import jdk.vm.ci.meta.ResolvedJavaMethod;

public class HotSpotStackIntrospection implements StackIntrospection {

    protected final HotSpotJVMCIRuntime runtime;

    public HotSpotStackIntrospection(HotSpotJVMCIRuntime runtime) {
        this.runtime = runtime;
    }

    @Override
    public <T> T iterateFrames(ResolvedJavaMethod[] initialMethods, ResolvedJavaMethod[] matchingMethods, int initialSkip, InspectedFrameVisitor<T> visitor) {
        CompilerToVM compilerToVM = runtime.getCompilerToVM();
        return compilerToVM.iterateFrames(initialMethods, matchingMethods, initialSkip, visitor);
    }
}
