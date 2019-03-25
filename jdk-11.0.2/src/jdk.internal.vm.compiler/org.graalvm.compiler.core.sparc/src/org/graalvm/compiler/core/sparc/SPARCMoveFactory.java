/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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



package org.graalvm.compiler.core.sparc;

import static org.graalvm.compiler.lir.LIRValueUtil.asConstant;
import static org.graalvm.compiler.lir.LIRValueUtil.isConstantValue;
import static org.graalvm.compiler.lir.LIRValueUtil.isStackSlotValue;

import org.graalvm.compiler.asm.sparc.SPARCAssembler;
import org.graalvm.compiler.core.common.type.DataPointerConstant;
import org.graalvm.compiler.core.sparc.SPARCLIRGenerator.ConstantTableBaseProvider;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.LIRInstruction;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool.MoveFactory;
import org.graalvm.compiler.lir.sparc.SPARCAddressValue;
import org.graalvm.compiler.lir.sparc.SPARCMove;
import org.graalvm.compiler.lir.sparc.SPARCMove.LoadAddressOp;
import org.graalvm.compiler.lir.sparc.SPARCMove.Move;

import jdk.vm.ci.meta.AllocatableValue;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.Value;

public class SPARCMoveFactory implements MoveFactory {

    protected final ConstantTableBaseProvider constantTableBaseProvider;

    public SPARCMoveFactory(ConstantTableBaseProvider constantTableBaseProvider) {
        this.constantTableBaseProvider = constantTableBaseProvider;
    }

    @Override
    public LIRInstruction createMove(AllocatableValue dst, Value src) {
        boolean srcIsSlot = isStackSlotValue(src);
        boolean dstIsSlot = isStackSlotValue(dst);
        if (isConstantValue(src)) {
            return createLoad(dst, asConstant(src));
        } else if (src instanceof SPARCAddressValue) {
            return new LoadAddressOp(dst, (SPARCAddressValue) src);
        } else {
            assert src instanceof AllocatableValue;
            if (srcIsSlot && dstIsSlot) {
                throw GraalError.shouldNotReachHere(src.getClass() + " " + dst.getClass());
            } else {
                return new Move(dst, (AllocatableValue) src);
            }
        }
    }

    @Override
    public LIRInstruction createStackMove(AllocatableValue result, AllocatableValue input) {
        return new SPARCMove.Move(result, input);
    }

    @Override
    public LIRInstruction createLoad(AllocatableValue dst, Constant src) {
        if (src instanceof JavaConstant) {
            JavaConstant javaConstant = (JavaConstant) src;
            if (canInlineConstant(javaConstant)) {
                return new SPARCMove.LoadInlineConstant(javaConstant, dst);
            } else {
                return new SPARCMove.LoadConstantFromTable(javaConstant, constantTableBaseProvider.getConstantTableBase(), dst);
            }
        } else if (src instanceof DataPointerConstant) {
            return new SPARCMove.LoadDataAddressOp(dst, (DataPointerConstant) src);
        } else {
            throw GraalError.shouldNotReachHere(src.getClass().toString());
        }
    }

    @Override
    public LIRInstruction createStackLoad(AllocatableValue result, Constant input) {
        if (input instanceof DataPointerConstant) {
            throw GraalError.shouldNotReachHere("unsupported constant for stack load: " + input);
        }
        return createLoad(result, input);
    }

    @Override
    public boolean canInlineConstant(Constant con) {
        if (con instanceof JavaConstant) {
            JavaConstant c = (JavaConstant) con;
            switch (c.getJavaKind()) {
                case Boolean:
                case Byte:
                case Char:
                case Short:
                case Int:
                    return SPARCAssembler.isSimm13(c.asInt());
                case Long:
                    return SPARCAssembler.isSimm13(c.asLong());
                case Object:
                    return c.isNull();
                default:
                    return false;
            }
        }
        return false;
    }

    @Override
    public boolean allowConstantToStackMove(Constant value) {
        return false;
    }

}
