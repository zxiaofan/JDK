/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import jdk.vm.ci.meta.JavaKind;
import org.graalvm.compiler.api.replacements.Snippet;
import org.graalvm.compiler.core.common.spi.ForeignCallDescriptor;
import org.graalvm.compiler.hotspot.HotSpotForeignCallLinkage;
import org.graalvm.compiler.hotspot.meta.HotSpotProviders;
import org.graalvm.compiler.hotspot.stubs.SnippetStub;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.replacements.amd64.AMD64ArrayIndexOfNode;
import jdk.internal.vm.compiler.word.Pointer;

public class AMD64ArrayIndexOfStub extends SnippetStub {

    public AMD64ArrayIndexOfStub(ForeignCallDescriptor foreignCallDescriptor, OptionValues options, HotSpotProviders providers, HotSpotForeignCallLinkage linkage) {
        super(foreignCallDescriptor.getName(), options, providers, linkage);
    }

    @Snippet
    private static int indexOfTwoConsecutiveBytes(Pointer arrayPointer, int arrayLength, int searchValue) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Byte, true, arrayPointer, arrayLength, searchValue);
    }

    @Snippet
    private static int indexOfTwoConsecutiveChars(Pointer arrayPointer, int arrayLength, int searchValue) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Char, true, arrayPointer, arrayLength, searchValue);
    }

    @Snippet
    private static int indexOf1Byte(Pointer arrayPointer, int arrayLength, byte b) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Byte, arrayPointer, arrayLength, b);
    }

    @Snippet
    private static int indexOf2Bytes(Pointer arrayPointer, int arrayLength, byte b1, byte b2) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Byte, arrayPointer, arrayLength, b1, b2);
    }

    @Snippet
    private static int indexOf3Bytes(Pointer arrayPointer, int arrayLength, byte b1, byte b2, byte b3) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Byte, arrayPointer, arrayLength, b1, b2, b3);
    }

    @Snippet
    private static int indexOf4Bytes(Pointer arrayPointer, int arrayLength, byte b1, byte b2, byte b3, byte b4) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Byte, arrayPointer, arrayLength, b1, b2, b3, b4);
    }

    @Snippet
    private static int indexOf1Char(Pointer arrayPointer, int arrayLength, char c) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Char, arrayPointer, arrayLength, c);
    }

    @Snippet
    private static int indexOf2Chars(Pointer arrayPointer, int arrayLength, char c1, char c2) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Char, arrayPointer, arrayLength, c1, c2);
    }

    @Snippet
    private static int indexOf3Chars(Pointer arrayPointer, int arrayLength, char c1, char c2, char c3) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Char, arrayPointer, arrayLength, c1, c2, c3);
    }

    @Snippet
    private static int indexOf4Chars(Pointer arrayPointer, int arrayLength, char c1, char c2, char c3, char c4) {
        return AMD64ArrayIndexOfNode.optimizedArrayIndexOf(JavaKind.Char, arrayPointer, arrayLength, c1, c2, c3, c4);
    }
}
