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
package org.graalvm.compiler.hotspot.stubs;

import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.api.replacements.Snippet.ConstantParameter;
import org.graalvm.compiler.debug.GraalError;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.nodes.AllocaNode;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.word.Word;

import jdk.vm.ci.code.Register;

/**
 * Stub to allocate an {@link ArrayIndexOutOfBoundsException} thrown by a bytecode.
 */
public class OutOfBoundsExceptionStub extends CreateExceptionStub {

    public OutOfBoundsExceptionStub(OptionValues options, HotSpotProviders providers, HotSpotForeignCallLinkage linkage) {
        super("createOutOfBoundsException", options, providers, linkage);
    }

    private static final int MAX_INT_STRING_SIZE = Integer.toString(Integer.MIN_VALUE).length();

    @Override
    protected Object getConstantParameterValue(int index, String name) {
        switch (index) {
            case 1:
                return providers.getRegisters().getThreadRegister();
            case 2:
                int wordSize = providers.getWordTypes().getWordKind().getByteCount();
                // (MAX_INT_STRING_SIZE + 1) / wordSize, rounded up
                return MAX_INT_STRING_SIZE / wordSize + 1;
            default:
                throw GraalError.shouldNotReachHere("unknown parameter " + name + " at index " + index);
        }
    }

    @Snippet
    private static Object createOutOfBoundsException(int idx, @ConstantParameter Register threadRegister, @ConstantParameter int bufferSizeInWords) {
        Word buffer = AllocaNode.alloca(bufferSizeInWords);

        long number = idx;
        if (number < 0) {
            number = -number;
        }

        Word ptr = buffer.add(MAX_INT_STRING_SIZE);
        ptr.writeByte(0, (byte) 0);
        do {
            long digit = number % 10;
            number /= 10;

            ptr = ptr.subtract(1);
            ptr.writeByte(0, (byte) ('0' + digit));
        } while (number > 0);

        if (idx < 0) {
            ptr = ptr.subtract(1);
            ptr.writeByte(0, (byte) '-');
        }

        return createException(threadRegister, ArrayIndexOutOfBoundsException.class, ptr);
    }
}
