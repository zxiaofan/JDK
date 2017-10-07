/*
 * Copyright (c) 2009, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.code;

import static jdk.vm.ci.meta.MetaUtil.identityHashCodeString;

import jdk.vm.ci.meta.JavaKind;

/**
 * Represents the target machine for a compiler, including the CPU architecture, the size of
 * pointers and references, alignment of stacks, caches, etc.
 */
public class TargetDescription {

    public final Architecture arch;

    /**
     * Specifies if this is a multi-processor system.
     */
    public final boolean isMP;

    /**
     * Specifies if this target supports encoding objects inline in the machine code.
     */
    public final boolean inlineObjects;

    /**
     * The machine word size on this target.
     */
    public final int wordSize;

    /**
     * The {@link JavaKind} to be used for representing raw pointers and CPU registers in Java code.
     */
    public final JavaKind wordJavaKind;

    /**
     * The stack alignment requirement of the platform. For example, from Appendix D of
     * <a href="http://www.intel.com/Assets/PDF/manual/248966.pdf">Intel 64 and IA-32 Architectures
     * Optimization Reference Manual</a>:
     *
     * <pre>
     *     "It is important to ensure that the stack frame is aligned to a
     *      16-byte boundary upon function entry to keep local __m128 data,
     *      parameters, and XMM register spill locations aligned throughout
     *      a function invocation."
     * </pre>
     */
    public final int stackAlignment;

    /**
     * Maximum constant displacement at which a memory access can no longer be an implicit null
     * check.
     */
    public final int implicitNullCheckLimit;

    public TargetDescription(Architecture arch, boolean isMP, int stackAlignment, int implicitNullCheckLimit, boolean inlineObjects) {
        this.arch = arch;
        this.isMP = isMP;
        this.wordSize = arch.getWordSize();
        this.wordJavaKind = JavaKind.fromWordSize(wordSize);
        this.stackAlignment = stackAlignment;
        this.implicitNullCheckLimit = implicitNullCheckLimit;
        this.inlineObjects = inlineObjects;

        assert arch.getPlatformKind(wordJavaKind).equals(arch.getWordKind());
    }

    @Override
    public final int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TargetDescription) {
            TargetDescription that = (TargetDescription) obj;
            // @formatter:off
            if (this.implicitNullCheckLimit == that.implicitNullCheckLimit &&
                this.inlineObjects == that.inlineObjects &&
                this.isMP == that.isMP &&
                this.stackAlignment == that.stackAlignment &&
                this.wordJavaKind.equals(that.wordJavaKind) &&
                this.wordSize == that.wordSize &&
                this.arch.equals(that.arch)) {
                return true;
            }
            // @formatter:on
        }
        return false;
    }

    @Override
    public String toString() {
        return identityHashCodeString(this);
    }
}
