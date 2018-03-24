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
package org.graalvm.compiler.hotspot.amd64;

import static org.graalvm.compiler.hotspot.HotSpotBackend.Options.GraalArithmeticStubs;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotMathIntrinsicOp.IntrinsicOpcode.COS;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotMathIntrinsicOp.IntrinsicOpcode.LOG;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotMathIntrinsicOp.IntrinsicOpcode.LOG10;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotMathIntrinsicOp.IntrinsicOpcode.SIN;
import static org.graalvm.compiler.hotspot.amd64.AMD64HotSpotMathIntrinsicOp.IntrinsicOpcode.TAN;

import org.graalvm.compiler.core.amd64.AMD64ArithmeticLIRGenerator;
import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.Variable;

import jdk.vm.ci.meta.Value;

public class AMD64HotSpotArithmeticLIRGenerator extends AMD64ArithmeticLIRGenerator {

    @Override
    public Value emitMathLog(Value input, boolean base10) {
        if (GraalArithmeticStubs.getValue(getOptions())) {
            return super.emitMathLog(input, base10);
        }
        Variable result = getLIRGen().newVariable(LIRKind.combine(input));
        getLIRGen().append(new AMD64HotSpotMathIntrinsicOp(base10 ? LOG10 : LOG, result, getLIRGen().asAllocatable(input)));
        return result;
    }

    @Override
    public Value emitMathCos(Value input) {
        if (GraalArithmeticStubs.getValue(getOptions())) {
            return super.emitMathCos(input);
        }
        Variable result = getLIRGen().newVariable(LIRKind.combine(input));
        getLIRGen().append(new AMD64HotSpotMathIntrinsicOp(COS, result, getLIRGen().asAllocatable(input)));
        return result;
    }

    @Override
    public Value emitMathSin(Value input) {
        if (GraalArithmeticStubs.getValue(getOptions())) {
            return super.emitMathSin(input);
        }
        Variable result = getLIRGen().newVariable(LIRKind.combine(input));
        getLIRGen().append(new AMD64HotSpotMathIntrinsicOp(SIN, result, getLIRGen().asAllocatable(input)));
        return result;
    }

    @Override
    public Value emitMathTan(Value input) {
        if (GraalArithmeticStubs.getValue(getOptions())) {
            return super.emitMathTan(input);
        }
        Variable result = getLIRGen().newVariable(LIRKind.combine(input));
        getLIRGen().append(new AMD64HotSpotMathIntrinsicOp(TAN, result, getLIRGen().asAllocatable(input)));
        return result;
    }

}
