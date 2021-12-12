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
import java.util.Date;

/**
 * Class {@code DateTimeSyntax} is an abstract base class providing the common
 * implementation of all attributes whose value is a date and time.
 * <p>
 * Under the hood, a date-time attribute is stored as a value of class
 * {@code java.util.Date}. You can get a date-time attribute's {@code Date}
 * value by calling {@link #getValue() getValue()}. A date-time attribute's
 * {@code Date} value is established when it is constructed (see
 * {@link #DateTimeSyntax(Date) DateTimeSyntax(Date)}). Once constructed, a
 * date-time attribute's value is immutable.
 * <p>
 * To construct a date-time attribute from separate values of the year, month,
 * day, hour, minute, and so on, use a {@code java.util.Calendar} object to
 * construct a {@code java.util.Date} object, then use the
 * {@code java.util.Date} object to construct the date-time attribute. To
 * convert a date-time attribute to separate values of the year, month, day,
 * hour, minute, and so on, create a {@code java.util.Calendar} object and set
 * it to the {@code java.util.Date} from the date-time attribute. Class
 * {@code DateTimeSyntax} stores its value in the form of a
 * {@code java.util.Date} rather than a {@code java.util.Calendar} because it
 * typically takes less memory to store and less time to compare a
 * {@code java.util.Date} than a {@code java.util.Calendar}.
 *
 * @author Alan Kaminsky
 */
public abstract class DateTimeSyntax implements Serializable, Cloneable {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -1400819079791208582L;

    // Hidden data members.

    /**
     * This date-time attribute's {@code java.util.Date} value.
     *
     * @serial
     */
    private Date value;

    // Hidden constructors.

    /**
     * Construct a new date-time attribute with the given {@code java.util.Date}
     * value.
     *
     * @param  value {@code java.util.Date} value
     * @throws NullPointerException if {@code value} is {@code null}
     */
    protected DateTimeSyntax(Date value) {
        if (value == null) {
            throw new NullPointerException("value is null");
        }
        this.value = value;
    }

    // Exported operations.

    /**
     * Returns this date-time attribute's {@code java.util.Date} value.
     *
     * @return the {@code Date}
     */
    public Date getValue() {
        return new Date (value.getTime());
    }

    // Exported operations inherited and overridden from class Object.

    /**
     * Returns whether this date-time attribute is equivalent to the passed in
     * object. To be equivalent, all of the following conditions must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code DateTimeSyntax}.
     *   <li>This date-time attribute's {@code java.util.Date} value and
     *   {@code object}'s {@code java.util.Date} value are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this date-time
     *         attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (object != null &&
                object instanceof DateTimeSyntax &&
                value.equals(((DateTimeSyntax) object).value));
    }

    /**
     * Returns a hash code value for this date-time attribute. The hashcode is
     * that of this attribute's {@code java.util.Date} value.
     */
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Returns a string value corresponding to this date-time attribute. The
     * string value is just this attribute's {@code java.util.Date} value
     * converted to a string.
     */
    public String toString() {
        return "" + value;
    }
}
