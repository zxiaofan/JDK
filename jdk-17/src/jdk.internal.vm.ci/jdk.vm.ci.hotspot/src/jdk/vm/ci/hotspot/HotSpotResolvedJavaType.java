/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
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

import static jdk.vm.ci.hotspot.HotSpotJVMCIRuntime.runtime;

import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.ResolvedJavaType;

public abstract class HotSpotResolvedJavaType extends HotSpotJavaType implements ResolvedJavaType {

    HotSpotResolvedObjectTypeImpl arrayOfType;

    HotSpotResolvedJavaType(String name) {
        super(name);
    }

    @Override
    public abstract boolean equals(Object obj);

    @Override
    public final int hashCode() {
        return getName().hashCode();
    }

    abstract JavaConstant getJavaMirror();

    @Override
    public HotSpotResolvedObjectType getArrayClass() {
        if (arrayOfType == null) {
            arrayOfType = runtime().compilerToVm.getArrayType(this);
        }
        return arrayOfType;
    }

    /**
     * Checks whether this type is currently being initialized. If a type is being initialized it
     * implies that it was {@link #isLinked() linked} and that the static initializer is currently
     * being run.
     *
     * @return {@code true} if this type is being initialized
     */
    abstract boolean isBeingInitialized();
}
