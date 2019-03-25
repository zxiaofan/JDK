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


package org.graalvm.compiler.lir.jtt;

import java.util.HashMap;

import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;

import jdk.vm.ci.meta.Value;

public abstract class LIRTestSpecification {
    private Value result;
    private final HashMap<String, Value> output = new HashMap<>();

    public void generate(LIRGeneratorTool gen) {
        defaultHandler(gen);
    }

    public void generate(LIRGeneratorTool gen, Value arg0) {
        defaultHandler(gen, arg0);
    }

    public void generate(LIRGeneratorTool gen, Value arg0, Value arg1) {
        defaultHandler(gen, arg0, arg1);
    }

    public void generate(LIRGeneratorTool gen, Value arg0, Value arg1, Value arg2) {
        defaultHandler(gen, arg0, arg1, arg2);
    }

    public void generate(LIRGeneratorTool gen, Value arg0, Value arg1, Value arg2, Value arg3) {
        defaultHandler(gen, arg0, arg1, arg2, arg3);
    }

    public void generate(LIRGeneratorTool gen, Value arg0, Value arg1, Value arg2, Value arg3, Value arg4) {
        defaultHandler(gen, arg0, arg1, arg2, arg3, arg4);
    }

    private static void defaultHandler(@SuppressWarnings("unused") LIRGeneratorTool gen, Value... args) {
        throw new GraalError("LIRTestSpecification cannot handle generate() with %d arguments", args.length);
    }

    void generate(LIRGeneratorTool gen, Value[] values) {
        if (values.length == 0) {
            generate(gen);
        } else if (values.length == 1) {
            generate(gen, values[0]);
        } else if (values.length == 2) {
            generate(gen, values[0], values[1]);
        } else if (values.length == 3) {
            generate(gen, values[0], values[1], values[2]);
        } else if (values.length == 4) {
            generate(gen, values[0], values[1], values[2], values[3]);
        } else if (values.length == 5) {
            generate(gen, values[0], values[1], values[2], values[3], values[4]);
        } else {
            GraalError.unimplemented();
        }

    }

    public void setOutput(String name, Value value) {
        output.put(name, value);
    }

    public Value getOutput(String name) {
        return output.get(name);
    }

    public void setResult(Value value) {
        result = value;
    }

    public Value getResult() {
        return result;
    }
}
