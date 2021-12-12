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

package javax.print.attribute.standard;

import java.io.Serial;

import javax.print.attribute.Attribute;
import javax.print.attribute.IntegerSyntax;
import javax.print.attribute.PrintJobAttribute;

/**
 * Class {@code NumberOfInterveningJobs} is an integer valued printing attribute
 * that indicates the number of jobs that are ahead of this job in the relative
 * chronological order of expected time to complete (i.e., the current scheduled
 * order).
 * <p>
 * <b>IPP Compatibility:</b> The integer value gives the IPP integer value. The
 * category name returned by {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class NumberOfInterveningJobs extends IntegerSyntax
    implements PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 2568141124844982746L;

    /**
     * Construct a new number of intervening jobs attribute with the given
     * integer value.
     *
     * @param  value Integer value
     * @throws IllegalArgumentException if {@code value} is negative
     */
    public NumberOfInterveningJobs(int value) {
        super(value, 0, Integer.MAX_VALUE);
    }

    /**
     * Returns whether this number of intervening jobs attribute is equivalent
     * to the passed in object. To be equivalent, all of the following
     * conditions must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class
     *   {@code NumberOfInterveningJobs}.
     *   <li>This number of intervening jobs attribute's value and
     *   {@code object}'s value are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this number of
     *         intervening jobs attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals (object) &&
                object instanceof NumberOfInterveningJobs);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code NumberOfInterveningJobs}, the category is class
     * {@code NumberOfInterveningJobs} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return NumberOfInterveningJobs.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code NumberOfInterveningJobs}, the category name is
     * {@code "number-of-intervening-jobs"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "number-of-intervening-jobs";
    }
}
