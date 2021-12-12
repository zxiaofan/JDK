/*
 *  Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
 *
 *
 *
 */
package jdk.incubator.foreign;

import java.lang.constant.Constable;
import java.lang.constant.ConstantDescs;
import java.lang.constant.DynamicConstantDesc;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * A padding layout. A padding layout specifies the size of extra space which is typically not accessed by applications,
 * and is typically used for aligning member layouts around word boundaries.
 * <p>
 * This is a <a href="{@docRoot}/java.base/java/lang/doc-files/ValueBased.html">value-based</a>
 * class; programmers should treat instances that are
 * {@linkplain #equals(Object) equal} as interchangeable and should not
 * use instances for synchronization, or unpredictable behavior may
 * occur. For example, in a future release, synchronization may fail.
 * The {@code equals} method should be used for comparisons.
 *
 * <p> Unless otherwise specified, passing a {@code null} argument, or an array argument containing one or more {@code null}
 * elements to a method in this class causes a {@link NullPointerException NullPointerException} to be thrown. </p>
 *
 * @implSpec
 * This class is immutable and thread-safe.
 */
/* package-private */ final class PaddingLayout extends AbstractLayout implements MemoryLayout {

    PaddingLayout(long size) {
        this(size, 1, Map.of());
    }

    PaddingLayout(long size, long alignment, Map<String, Constable> attributes) {
        super(OptionalLong.of(size), alignment, attributes);
    }

    @Override
    public String toString() {
        return decorateLayoutString("x" + bitSize());
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!super.equals(other)) {
            return false;
        }
        if (!(other instanceof PaddingLayout)) {
            return false;
        }
        PaddingLayout p = (PaddingLayout)other;
        return bitSize() == p.bitSize();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), bitSize());
    }

    @Override
    PaddingLayout dup(long alignment, Map<String, Constable> attributes) {
        return new PaddingLayout(bitSize(), alignment, attributes);
    }

    @Override
    public boolean hasNaturalAlignment() {
        return true;
    }

    @Override
    public Optional<DynamicConstantDesc<MemoryLayout>> describeConstable() {
        return Optional.of(decorateLayoutConstant(DynamicConstantDesc.ofNamed(ConstantDescs.BSM_INVOKE, "padding",
                CD_MEMORY_LAYOUT, MH_PADDING, bitSize())));
    }

    //hack: the declarations below are to make javadoc happy; we could have used generics in AbstractLayout
    //but that causes issues with javadoc, see JDK-8224052

    /**
     * {@inheritDoc}
     */
    @Override
    public PaddingLayout withName(String name) {
        return (PaddingLayout)super.withName(name);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaddingLayout withBitAlignment(long alignmentBits) {
        return (PaddingLayout)super.withBitAlignment(alignmentBits);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PaddingLayout withAttribute(String name, Constable value) {
        return (PaddingLayout)super.withAttribute(name, value);
    }
}
