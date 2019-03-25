/*
 * Copyright (c) 2011, 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.meta;

import jdk.vm.ci.code.Register;

public class HotSpotRegisters implements HotSpotRegistersProvider {

    private final Register threadRegister;
    private final Register heapBaseRegister;
    private final Register stackPointerRegister;

    public HotSpotRegisters(Register threadRegister, Register heapBaseRegister, Register stackPointerRegister) {
        this.threadRegister = threadRegister;
        this.heapBaseRegister = heapBaseRegister;
        this.stackPointerRegister = stackPointerRegister;
    }

    @Override
    public Register getThreadRegister() {
        assert !threadRegister.equals(Register.None) : "thread register is not defined";
        return threadRegister;
    }

    @Override
    public Register getHeapBaseRegister() {
        assert !heapBaseRegister.equals(Register.None) : "heap base register is not defined";
        return heapBaseRegister;
    }

    @Override
    public Register getStackPointerRegister() {
        assert !stackPointerRegister.equals(Register.None) : "stack pointer register is not defined";
        return stackPointerRegister;
    }
}
