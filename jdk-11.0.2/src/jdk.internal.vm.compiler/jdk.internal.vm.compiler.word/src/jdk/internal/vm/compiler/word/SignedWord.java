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
 */


package jdk.internal.vm.compiler.word;

/**
 * Represents a signed word-sized value.
 *
 * @since 1.0
 */
public interface SignedWord extends ComparableWord {

    /**
     * Returns a Signed whose value is {@code (this + val)}.
     *
     * @param val value to be added to this Signed.
     * @return {@code this + val}
     *
     * @since 1.0
     */
    SignedWord add(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this - val)}.
     *
     * @param val value to be subtracted from this Signed.
     * @return {@code this - val}
     *
     * @since 1.0
     */
    SignedWord subtract(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this Signed.
     * @return {@code this * val}
     *
     * @since 1.0
     */
    SignedWord multiply(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this / val)}.
     *
     * @param val value by which this Signed is to be divided.
     * @return {@code this / val}
     *
     * @since 1.0
     */
    SignedWord signedDivide(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this % val)}.
     *
     * @param val value by which this Signed is to be divided, and the remainder computed.
     * @return {@code this % val}
     *
     * @since 1.0
     */
    SignedWord signedRemainder(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this << n)}.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     *
     * @since 1.0
     */
    SignedWord shiftLeft(UnsignedWord n);

    /**
     * Returns a Signed whose value is {@code (this >> n)}. Sign extension is performed.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     *
     * @since 1.0
     */
    SignedWord signedShiftRight(UnsignedWord n);

    /**
     * Returns a Signed whose value is {@code (this & val)}. (This method returns a negative Signed
     * if and only if this and val are both negative.)
     *
     * @param val value to be AND'ed with this Signed.
     * @return {@code this & val}
     *
     * @since 1.0
     */
    SignedWord and(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this | val)}. (This method returns a negative Signed
     * if and only if either this or val is negative.)
     *
     * @param val value to be OR'ed with this Signed.
     * @return {@code this | val}
     *
     * @since 1.0
     */
    SignedWord or(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this ^ val)}. (This method returns a negative Signed
     * if and only if exactly one of this and val are negative.)
     *
     * @param val value to be XOR'ed with this Signed.
     * @return {@code this ^ val}
     *
     * @since 1.0
     */
    SignedWord xor(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (~this)}. (This method returns a negative value if and
     * only if this Signed is non-negative.)
     *
     * @return {@code ~this}
     *
     * @since 1.0
     */
    SignedWord not();

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this == val}
     *
     * @since 1.0
     */
    boolean equal(SignedWord val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this != val}
     *
     * @since 1.0
     */
    boolean notEqual(SignedWord val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this < val}
     *
     * @since 1.0
     */
    boolean lessThan(SignedWord val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this <= val}
     *
     * @since 1.0
     */
    boolean lessOrEqual(SignedWord val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this > val}
     *
     * @since 1.0
     */
    boolean greaterThan(SignedWord val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this >= val}
     *
     * @since 1.0
     */
    boolean greaterOrEqual(SignedWord val);

    /**
     * Returns a Signed whose value is {@code (this + val)}.
     *
     * @param val value to be added to this Signed.
     * @return {@code this + val}
     *
     * @since 1.0
     */
    SignedWord add(int val);

    /**
     * Returns a Signed whose value is {@code (this - val)}.
     *
     * @param val value to be subtracted from this Signed.
     * @return {@code this - val}
     *
     * @since 1.0
     */
    SignedWord subtract(int val);

    /**
     * Returns a Signed whose value is {@code (this * val)}.
     *
     * @param val value to be multiplied by this Signed.
     * @return {@code this * val}
     *
     * @since 1.0
     */
    SignedWord multiply(int val);

    /**
     * Returns a Signed whose value is {@code (this / val)}.
     *
     * @param val value by which this Signed is to be divided.
     * @return {@code this / val}
     *
     * @since 1.0
     */
    SignedWord signedDivide(int val);

    /**
     * Returns a Signed whose value is {@code (this % val)}.
     *
     * @param val value by which this Signed is to be divided, and the remainder computed.
     * @return {@code this % val}
     *
     * @since 1.0
     */
    SignedWord signedRemainder(int val);

    /**
     * Returns a Signed whose value is {@code (this << n)}.
     *
     * @param n shift distance, in bits.
     * @return {@code this << n}
     *
     * @since 1.0
     */
    SignedWord shiftLeft(int n);

    /**
     * Returns a Signed whose value is {@code (this >> n)}. Sign extension is performed.
     *
     * @param n shift distance, in bits.
     * @return {@code this >> n}
     *
     * @since 1.0
     */
    SignedWord signedShiftRight(int n);

    /**
     * Returns a Signed whose value is {@code (this & val)}. (This method returns a negative Signed
     * if and only if this and val are both negative.)
     *
     * @param val value to be AND'ed with this Signed.
     * @return {@code this & val}
     *
     * @since 1.0
     */
    SignedWord and(int val);

    /**
     * Returns a Signed whose value is {@code (this | val)}. (This method returns a negative Signed
     * if and only if either this or val is negative.)
     *
     * @param val value to be OR'ed with this Signed.
     * @return {@code this | val}
     *
     * @since 1.0
     */
    SignedWord or(int val);

    /**
     * Returns a Signed whose value is {@code (this ^ val)}. (This method returns a negative Signed
     * if and only if exactly one of this and val are negative.)
     *
     * @param val value to be XOR'ed with this Signed.
     * @return {@code this ^ val}
     *
     * @since 1.0
     */
    SignedWord xor(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this == val}
     *
     * @since 1.0
     */
    boolean equal(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this != val}
     *
     * @since 1.0
     */
    boolean notEqual(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this < val}
     *
     * @since 1.0
     */
    boolean lessThan(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this <= val}
     *
     * @since 1.0
     */
    boolean lessOrEqual(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this > val}
     *
     * @since 1.0
     */
    boolean greaterThan(int val);

    /**
     * Compares this Signed with the specified value.
     *
     * @param val value to which this Signed is to be compared.
     * @return {@code this >= val}
     *
     * @since 1.0
     */
    boolean greaterOrEqual(int val);
}
