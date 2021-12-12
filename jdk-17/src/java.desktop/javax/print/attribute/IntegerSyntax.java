/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
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

package javax.print.attribute;

import java.io.Serial;
import java.io.Serializable;

/**
 * Class {@code IntegerSyntax} is an abstract base class providing the common
 * implementation of all attributes with integer values.
 * <p>
 * Under the hood, an integer attribute is just an integer. You can get an
 * integer attribute's integer value by calling {@link #getValue() getValue()}.
 * An integer attribute's integer value is established when it is constructed
 * (see {@link #IntegerSyntax(int) IntegerSyntax(int)}). Once constructed, an
 * integer attribute's value is immutable.
 *
 * @author David Mendenhall
 * @author Alan Kaminsky
 */
public abstract class IntegerSyntax implements Serializable, Cloneable {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 3644574816328081943L;

    /**
     * This integer attribute's integer value.
     *
     * @serial
     */
    private int value;

    /**
     * Construct a new integer attribute with the given integer value.
     *
     * @param  value Integer value
     */
    protected IntegerSyntax(int value) {
        this.value = value;
    }

    /**
     * Construct a new integer attribute with the given integer value, which
     * must lie within the given range.
     *
     * @param  value Integer value
     * @param  lowerBound Lower bound
     * @param  upperBound Upper bound
     * @throws IllegalArgumentException if {@code value} is less than
     *         {@code lowerBound} or greater than {@code upperBound}
     */
    protected IntegerSyntax(int value, int lowerBound, int upperBound) {
        if (lowerBound > value || value > upperBound) {
            throw new IllegalArgumentException("Value " + value +
                                               " not in range " + lowerBound +
                                               ".." + upperBound);
        }
        this.value = value;
    }

    /**
     * Returns this integer attribute's integer value.
     *
     * @return the integer value
     */
    public int getValue() {
        return value;
    }

    /**
     * Returns whether this integer attribute is equivalent to the passed in
     * object. To be equivalent, all of the following conditions must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code IntegerSyntax}.
     *   <li>This integer attribute's value and {@code object}'s value are
     *   equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this integer
     *         attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {

        return (object != null && object instanceof IntegerSyntax &&
                value == ((IntegerSyntax) object).value);
    }

    /**
     * Returns a hash code value for this integer attribute. The hash code is
     * just this integer attribute's integer value.
     */
    public int hashCode() {
        return value;
    }

    /**
     * Returns a string value corresponding to this integer attribute. The
     * string value is just this integer attribute's integer value converted to
     * a string.
     */
    public String toString() {
        return "" + value;
    }
}
