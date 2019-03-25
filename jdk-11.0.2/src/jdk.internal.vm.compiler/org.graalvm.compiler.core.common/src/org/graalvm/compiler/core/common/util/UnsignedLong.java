/*
 * Copyright (c) 2018, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.core.common.util;

public final class UnsignedLong {
    private final long value;

    public UnsignedLong(long value) {
        this.value = value;
    }

    public long asLong() {
        return value;
    }

    public boolean equals(long unsignedValue) {
        return value == unsignedValue;
    }

    public boolean isLessThan(long unsignedValue) {
        return Long.compareUnsigned(value, unsignedValue) < 0;
    }

    public boolean isLessOrEqualTo(long unsignedValue) {
        return Long.compareUnsigned(value, unsignedValue) <= 0;
    }

    public UnsignedLong times(long unsignedValue) {
        if (unsignedValue != 0 && Long.compareUnsigned(value, Long.divideUnsigned(0xffff_ffff_ffff_ffffL, unsignedValue)) > 0) {
            throw new ArithmeticException();
        }
        return new UnsignedLong(value * unsignedValue);
    }

    public UnsignedLong minus(long unsignedValue) {
        if (Long.compareUnsigned(value, unsignedValue) < 0) {
            throw new ArithmeticException();
        }
        return new UnsignedLong(value - unsignedValue);
    }

    public UnsignedLong plus(long unsignedValue) {
        if (Long.compareUnsigned(0xffff_ffff_ffff_ffffL - unsignedValue, value) < 0) {
            throw new ArithmeticException();
        }
        return new UnsignedLong(value + unsignedValue);
    }

    public UnsignedLong wrappingPlus(long unsignedValue) {
        return new UnsignedLong(value + unsignedValue);
    }

    public UnsignedLong wrappingTimes(long unsignedValue) {
        return new UnsignedLong(value * unsignedValue);
    }

    @Override
    public String toString() {
        return "UnsignedLong(" + Long.toUnsignedString(value) + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UnsignedLong that = (UnsignedLong) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(value);
    }
}
