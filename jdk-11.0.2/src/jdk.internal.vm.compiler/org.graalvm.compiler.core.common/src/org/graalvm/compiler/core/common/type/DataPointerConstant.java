/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.type;

import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.SerializableConstant;

/**
 * Base class for {@link Constant constants} that represent a pointer to the data section.
 */
public abstract class DataPointerConstant implements SerializableConstant {

    private final int alignment;

    protected DataPointerConstant(int alignment) {
        this.alignment = alignment;
    }

    /**
     * Get the minimum alignment of the data in the data section.
     */
    public final int getAlignment() {
        return alignment;
    }

    @Override
    public boolean isDefaultForKind() {
        return false;
    }
}
