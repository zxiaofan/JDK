/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.amd64;

import static org.graalvm.compiler.lir.LIRValueUtil.asJavaConstant;
import static org.graalvm.compiler.lir.LIRValueUtil.isJavaConstant;
import static jdk.vm.ci.amd64.AMD64.rax;
import static jdk.vm.ci.amd64.AMD64.rbx;
import static jdk.vm.ci.code.ValueUtil.asRegister;
import static jdk.vm.ci.code.ValueUtil.isRegister;

import org.graalvm.compiler.asm.amd64.AMD64Address;
import org.graalvm.compiler.asm.amd64.AMD64MacroAssembler;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.hotspot.HotSpotCounterOp;
import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.meta.HotSpotRegistersProvider;
import org.graalvm.compiler.lir.LIRInstructionClass;
import org.graalvm.compiler.lir.Opcode;
import org.graalvm.compiler.lir.asm.CompilationResultBuilder;

import jdk.vm.ci.code.Register;
import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Value;

@Opcode("BenchMarkCounter")
public class AMD64HotSpotCounterOp extends HotSpotCounterOp {
    public static final LIRInstructionClass<AMD64HotSpotCounterOp> TYPE = LIRInstructionClass.create(AMD64HotSpotCounterOp.class);

    @Alive({OperandFlag.STACK, OperandFlag.UNINITIALIZED}) private AllocatableValue backupSlot;

    public AMD64HotSpotCounterOp(String name, String group, Value increment, HotSpotRegistersProvider registers, GraalHotSpotVMConfig config, AllocatableValue backupSlot) {
        super(TYPE, name, group, increment, registers, config);
        this.backupSlot = backupSlot;
    }

    public AMD64HotSpotCounterOp(String[] names, String[] groups, Value[] increments, HotSpotRegistersProvider registers, GraalHotSpotVMConfig config, AllocatableValue backupSlot) {
        super(TYPE, names, groups, increments, registers, config);
        this.backupSlot = backupSlot;
    }

    @Override
    public void emitCode(CompilationResultBuilder crb) {
        AMD64MacroAssembler masm = (AMD64MacroAssembler) crb.asm;
        TargetDescription target = crb.target;

        Register scratch;
        // It can happen that the rax register is the increment register, in this case we do not
        // want to spill it to the stack.
        if (!contains(increments, rax)) {
            scratch = rax;
        } else if (!contains(increments, rbx)) {
            scratch = rbx;
        } else {
            // In this case rax and rbx are used as increment. Either we implement a third register
            // or we implement a spillover the value from rax to rbx or vice versa during
            // emitIncrement().
            throw GraalError.unimplemented("RAX and RBX are increment registers at the same time, spilling over the scratch register is not supported right now");
        }

        // address for counters array
        AMD64Address countersArrayAddr = new AMD64Address(thread, config.jvmciCountersThreadOffset);
        Register countersArrayReg = scratch;

        // backup scratch register
        masm.movq((AMD64Address) crb.asAddress(backupSlot), scratch);

        // load counters array
        masm.movptr(countersArrayReg, countersArrayAddr);
        CounterProcedure emitProcedure = (counterIndex, increment, displacement) -> emitIncrement(masm, countersArrayReg, increment, displacement);
        forEachCounter(emitProcedure, target);

        // restore scratch register
        masm.movq(scratch, (AMD64Address) crb.asAddress(backupSlot));
    }

    /**
     * Tests if the array contains the register.
     */
    private static boolean contains(Value[] increments, Register register) {
        for (Value increment : increments) {
            if (isRegister(increment) && asRegister(increment).equals(register)) {
                return true;
            }
        }
        return false;
    }

    private static void emitIncrement(AMD64MacroAssembler masm, Register countersArrayReg, Value incrementValue, int displacement) {
        // address for counter value
        AMD64Address counterAddr = new AMD64Address(countersArrayReg, displacement);
        // increment counter (in memory)
        if (isJavaConstant(incrementValue)) {
            int increment = asInt(asJavaConstant(incrementValue));
            masm.incrementq(counterAddr, increment);
        } else {
            masm.addq(counterAddr, asRegister(incrementValue));
        }

    }
}
