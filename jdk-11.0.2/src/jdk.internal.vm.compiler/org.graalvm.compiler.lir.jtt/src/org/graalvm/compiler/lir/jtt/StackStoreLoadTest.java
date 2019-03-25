/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2017, Red Hat Inc. All rights reserved.
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

import org.junit.Before;
import org.junit.Test;

import org.graalvm.compiler.core.common.LIRKind;
import org.graalvm.compiler.lir.Variable;
import org.graalvm.compiler.lir.VirtualStackSlot;
import org.graalvm.compiler.lir.framemap.FrameMapBuilder;
import org.graalvm.compiler.lir.gen.LIRGeneratorTool;

import jdk.vm.ci.meta.JavaKind;
import jdk.vm.ci.meta.PlatformKind;
import jdk.vm.ci.meta.Value;
import jdk.vm.ci.meta.ValueKind;

public class StackStoreLoadTest extends LIRTest {
    private static PlatformKind byteKind;
    private static PlatformKind shortKind;

    @Before
    public void setUp() {
        byteKind = getBackend().getTarget().arch.getPlatformKind(JavaKind.Byte);
        shortKind = getBackend().getTarget().arch.getPlatformKind(JavaKind.Short);
    }

    private static class StackStoreLoadSpec extends LIRTestSpecification {
        @Override
        public void generate(LIRGeneratorTool gen, Value a) {
            FrameMapBuilder frameMapBuilder = gen.getResult().getFrameMapBuilder();
            ValueKind<?> valueKind = getValueKind(a);

            // create slots
            VirtualStackSlot s1 = frameMapBuilder.allocateSpillSlot(valueKind);
            VirtualStackSlot s2 = frameMapBuilder.allocateSpillSlot(valueKind);
            VirtualStackSlot s3 = frameMapBuilder.allocateSpillSlot(valueKind);

            // start emit
            gen.emitMove(s1, a);
            gen.emitMove(s2, a);
            gen.emitMove(s3, a);
            gen.append(gen.getSpillMoveFactory().createStackMove(s1, s3));
            Variable result = gen.emitMove(s2);
            Value slot1 = gen.emitMove(s1);
            Value slot3 = gen.emitMove(s3);
            // end emit

            // set output and result
            setResult(result);
            setOutput("slot1", slot1);
            setOutput("slot3", slot3);
        }

        protected ValueKind<?> getValueKind(Value value) {
            return value.getValueKind();
        }
    }

    /*
     * short
     */

    private static final LIRTestSpecification shortStackCopy = new StackStoreLoadSpec() {
        @Override
        protected ValueKind<?> getValueKind(Value value) {
            return LIRKind.value(shortKind);
        }
    };

    @SuppressWarnings("unused")
    @LIRIntrinsic
    public static short copyShort(LIRTestSpecification spec, short a) {
        return a;
    }

    public short[] testShort(short a, short[] out) {
        out[0] = copyShort(shortStackCopy, a);
        out[1] = getOutput(shortStackCopy, "slot1", a);
        out[2] = getOutput(shortStackCopy, "slot3", a);
        return out;
    }

    @Test
    public void runShort() throws Throwable {
        runTest("testShort", Short.MIN_VALUE, supply(() -> new short[3]));
        runTest("testShort", (short) -1, supply(() -> new short[3]));
        runTest("testShort", (short) 0, supply(() -> new short[3]));
        runTest("testShort", (short) 1, supply(() -> new short[3]));
        runTest("testShort", Short.MAX_VALUE, supply(() -> new short[3]));
    }

    /*
     * byte
     */

    private static final LIRTestSpecification byteStackCopy = new StackStoreLoadSpec() {
        @Override
        protected ValueKind<?> getValueKind(Value value) {
            return LIRKind.value(byteKind);
        }
    };

    @SuppressWarnings("unused")
    @LIRIntrinsic
    public static byte copyByte(LIRTestSpecification spec, byte a) {
        return a;
    }

    public byte[] testByte(byte a, byte[] out) {
        out[0] = copyByte(byteStackCopy, a);
        out[1] = getOutput(byteStackCopy, "slot1", a);
        out[2] = getOutput(byteStackCopy, "slot3", a);
        return out;
    }

    @Test
    public void runByte() throws Throwable {
        runTest("testByte", Byte.MIN_VALUE, supply(() -> new byte[3]));
        runTest("testByte", (byte) -1, supply(() -> new byte[3]));
        runTest("testByte", (byte) 0, supply(() -> new byte[3]));
        runTest("testByte", (byte) 1, supply(() -> new byte[3]));
        runTest("testByte", Byte.MAX_VALUE, supply(() -> new byte[3]));
    }
}
