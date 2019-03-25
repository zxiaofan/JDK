/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.lir.framemap;

import org.graalvm.compiler.lir.VirtualStackSlot;

import jdk.vm.ci.meta.ValueKind;

/**
 * Represents a {@link VirtualStackSlot virtual stack slot} for a specific {@link ValueKind kind}.
 */
public class SimpleVirtualStackSlot extends VirtualStackSlot {

    public SimpleVirtualStackSlot(int id, ValueKind<?> kind) {
        super(id, kind);
    }

}
