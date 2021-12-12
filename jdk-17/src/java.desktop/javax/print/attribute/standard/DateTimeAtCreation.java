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
import java.util.Calendar;
import java.util.Date;

import javax.print.attribute.Attribute;
import javax.print.attribute.DateTimeSyntax;
import javax.print.attribute.PrintJobAttribute;

/**
 * Class {@code DateTimeAtCreation} is a printing attribute class, a date-time
 * attribute, that indicates the date and time at which the Print Job was
 * created.
 * <p>
 * To construct a {@code DateTimeAtCreation} attribute from separate values of
 * the year, month, day, hour, minute, and so on, use a
 * {@link Calendar Calendar} object to construct a {@link Date Date} object,
 * then use the {@link Date Date} object to construct the DateTimeAtCreation
 * attribute. To convert a {@code DateTimeAtCreation} attribute to separate
 * values of the year, month, day, hour, minute, and so on, create a
 * {@link Calendar Calendar} object and set it to the {@link Date Date} from the
 * {@code DateTimeAtCreation} attribute.
 * <p>
 * <b>IPP Compatibility:</b> The information needed to construct an IPP
 * "date-time-at-creation" attribute can be obtained as described above. The
 * category name returned by {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class DateTimeAtCreation   extends DateTimeSyntax
        implements PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -2923732231056647903L;

    /**
     * Construct a new date-time at creation attribute with the given
     * {@link Date Date} value.
     *
     * @param  dateTime {@link Date Date} value
     * @throws NullPointerException if {@code dateTime} is {@code null}
     */
    public DateTimeAtCreation(Date dateTime) {
        super (dateTime);
    }

    /**
     * Returns whether this date-time at creation attribute is equivalent to the
     * passed in object. To be equivalent, all of the following conditions must
     * be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code DateTimeAtCreation}.
     *   <li>This date-time at creation attribute's {@link Date Date}
     *   value and {@code object}'s {@link Date Date} value are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this date-time at
     *         creation attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return(super.equals (object) &&
               object instanceof DateTimeAtCreation);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code DateTimeAtCreation}, the category is class
     * {@code DateTimeAtCreation} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return DateTimeAtCreation.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code DateTimeAtCreation}, the category name is
     * {@code "date-time-at-creation"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "date-time-at-creation";
    }
}
