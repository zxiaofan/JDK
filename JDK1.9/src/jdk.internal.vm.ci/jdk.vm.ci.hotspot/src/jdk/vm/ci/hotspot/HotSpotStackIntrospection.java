/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

    protected final HotSpotJVMCIRuntimeProvider runtime;

    public HotSpotStackIntrospection(HotSpotJVMCIRuntimeProvider runtime) {
        this.runtime = runtime;
    }

    @Override
    public <T> T iterateFrames(ResolvedJavaMethod[] initialMethods, ResolvedJavaMethod[] matchingMethods, int initialSkip, InspectedFrameVisitor<T> visitor) {
        CompilerToVM compilerToVM = runtime.getCompilerToVM();
        HotSpotStackFrameReference current = compilerToVM.getNextStackFrame(null, initialMethods, initialSkip);
        while (current != null) {
            T result = visitor.visitFrame(current);
            if (result != null) {
                return result;
            }
            current = compilerToVM.getNextStackFrame(current, matchingMethods, 0);
        }
        return null;
    }
}
