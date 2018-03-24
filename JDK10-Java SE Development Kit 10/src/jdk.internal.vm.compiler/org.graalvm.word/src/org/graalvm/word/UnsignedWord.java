/*
 * Copyright (c) 2012, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 *
 */
package org.graalvm.word;

public interface UnsignedWord extends ComparableWord {

    /**
     * Returns a Unsigned whose value is {@code (this + val)}.
     *
     * @param val value to be added to this Unsigned.
     * @return {@code this + val}
     */
    UnsignedWord add(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this - val)}.
     *
     * @param val value to be subtracted from this Unsigned.
     * @return {@code this - val}
     */
    UnsignedWord subtract(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this Unsigned.
     * @return {@code this * val}
     */
    UnsignedWord multiply(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this / val)}.
     *
     * @param val value by which this Unsigned is to be divided.
     * @return {@code this / val}
     */
    UnsignedWord unsignedDivide(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this % val)}.
     *
     * @param val value by which this Unsigned is to be divided, and the remainder computed.
     * @return {@code this % val}
     */
    UnsignedWord unsignedRemainder(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this << n)}.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     */
    UnsignedWord shiftLeft(UnsignedWord n);

    /**
     * Returns a Unsigned whose value is {@code (this >>> n)}. No sign extension is performed.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     */
    UnsignedWord unsignedShiftRight(UnsignedWord n);

    /**
     * Returns a Unsigned whose value is {@code (this & val)}.
     *
     * @param val value to be AND'ed with this Unsigned.
     * @return {@code this & val}
     */
    UnsignedWord and(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this | val)}.
     *
     * @param val value to be OR'ed with this Unsigned.
     * @return {@code this | val}
     */
    UnsignedWord or(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this ^ val)}.
     *
     * @param val value to be XOR'ed with this Unsigned.
     * @return {@code this ^ val}
     */
    UnsignedWord xor(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (~this)}.
     *
     * @return {@code ~this}
     */
    UnsignedWord not();

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this == val}
     */
    boolean equal(UnsignedWord val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this != val}
     */
    boolean notEqual(UnsignedWord val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this < val}
     */
    boolean belowThan(UnsignedWord val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this <= val}
     */
    boolean belowOrEqual(UnsignedWord val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this > val}
     */
    boolean aboveThan(UnsignedWord val);

    /**
     * Compares this Unsigned with the specified value.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this >= val}
     */
    boolean aboveOrEqual(UnsignedWord val);

    /**
     * Returns a Unsigned whose value is {@code (this + val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be added to this Unsigned.
     * @return {@code this + val}
     */
    UnsignedWord add(int val);

    /**
     * Returns a Unsigned whose value is {@code (this - val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be subtracted from this Unsigned.
     * @return {@code this - val}
     */
    UnsignedWord subtract(int val);

    /**
     * Returns a Unsigned whose value is {@code (this * val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be multiplied by this Unsigned.
     * @return {@code this * val}
     */
    UnsignedWord multiply(int val);

    /**
     * Returns a Unsigned whose value is {@code (this / val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value by which this Unsigned is to be divided.
     * @return {@code this / val}
     */
    UnsignedWord unsignedDivide(int val);

    /**
     * Returns a Unsigned whose value is {@code (this % val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value by which this Unsigned is to be divided, and the remainder computed.
     * @return {@code this % val}
     */
    UnsignedWord unsignedRemainder(int val);

    /**
     * Returns a Unsigned whose value is {@code (this << n)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     */
    UnsignedWord shiftLeft(int n);

    /**
     * Returns a Unsigned whose value is {@code (this >>> n)}. No sign extension is performed.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     */
    UnsignedWord unsignedShiftRight(int n);

    /**
     * Returns a Unsigned whose value is {@code (this & val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be AND'ed with this Unsigned.
     * @return {@code this & val}
     */
    UnsignedWord and(int val);

    /**
     * Returns a Unsigned whose value is {@code (this | val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be OR'ed with this Unsigned.
     * @return {@code this | val}
     */
    UnsignedWord or(int val);

    /**
     * Returns a Unsigned whose value is {@code (this ^ val)}.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to be XOR'ed with this Unsigned.
     * @return {@code this ^ val}
     */
    UnsignedWord xor(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this == val}
     */
    boolean equal(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this != val}
     */
    boolean notEqual(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this < val}
     */
    boolean belowThan(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this <= val}
     */
    boolean belowOrEqual(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this > val}
     */
    boolean aboveThan(int val);

    /**
     * Compares this Unsigned with the specified value.
     * <p>
     * Note that the right operand is a signed value, while the operation is performed unsigned.
     * Therefore, the result is only well-defined for positive right operands.
     *
     * @param val value to which this Unsigned is to be compared.
     * @return {@code this >= val}
     */
    boolean aboveOrEqual(int val);
}
