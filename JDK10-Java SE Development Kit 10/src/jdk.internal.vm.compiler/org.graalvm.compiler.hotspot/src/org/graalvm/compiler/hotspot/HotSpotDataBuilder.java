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
package org.graalvm.compiler.hotspot;

import static jdk.vm.ci.hotspot.HotSpotCompressedNullConstant.COMPRESSED_NULL;

import java.nio.ByteBuffer;

import org.graalvm.compiler.code.DataSection.Data;
import org.graalvm.compiler.code.DataSection.Patches;
import org.graalvm.compiler.code.DataSection.SerializableData;
import org.graalvm.compiler.code.DataSection.ZeroData;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.lir.asm.DataBuilder;

import jdk.vm.ci.code.TargetDescription;
import jdk.vm.ci.hotspot.HotSpotConstant;
import jdk.vm.ci.meta.Constant;
import jdk.vm.ci.meta.JavaConstant;
import jdk.vm.ci.meta.SerializableConstant;
import jdk.vm.ci.meta.VMConstant;

public class HotSpotDataBuilder extends DataBuilder {

    private final TargetDescription target;

    public HotSpotDataBuilder(TargetDescription target) {
        this.target = target;
    }

    @Override
    public boolean needDetailedPatchingInformation() {
        /* The HotSpot VM finds operands that need patching by decoding the instruction. */
        return false;
    }

    @Override
    public Data createDataItem(Constant constant) {
        int size;
        if (constant instanceof VMConstant) {
            VMConstant vmConstant = (VMConstant) constant;
            boolean compressed;
            if (constant instanceof HotSpotConstant) {
                HotSpotConstant c = (HotSpotConstant) vmConstant;
                compressed = c.isCompressed();
            } else {
                throw new GraalError(String.valueOf(constant));
            }

            size = compressed ? 4 : target.wordSize;
            if (size == 4) {
                return new Data(size, size) {

                    @Override
                    protected void emit(ByteBuffer buffer, Patches patches) {
                        patches.registerPatch(vmConstant);
                        buffer.putInt(0xDEADDEAD);
                    }
                };
            } else {
                return new Data(size, size) {

                    @Override
                    protected void emit(ByteBuffer buffer, Patches patches) {
                        patches.registerPatch(vmConstant);
                        buffer.putLong(0xDEADDEADDEADDEADL);
                    }
                };
            }
        } else if (JavaConstant.isNull(constant)) {
            boolean compressed = COMPRESSED_NULL.equals(constant);
            size = compressed ? 4 : target.wordSize;
            return ZeroData.create(size, size);
        } else if (constant instanceof SerializableConstant) {
            SerializableConstant s = (SerializableConstant) constant;
            return new SerializableData(s);
        } else {
            throw new GraalError(String.valueOf(constant));
        }
    }
}
