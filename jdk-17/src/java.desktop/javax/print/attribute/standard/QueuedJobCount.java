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
import javax.print.attribute.PrintServiceAttribute;

/**
 * Class {@code QueuedJobCount} is an integer valued printing attribute that
 * indicates the number of jobs in the printer whose {@link JobState JobState}
 * is either {@code PENDING}, {@code PENDING_HELD}, {@code PROCESSING}, or
 * {@code PROCESSING_STOPPED}.
 * <p>
 * <b>IPP Compatibility:</b> The integer value gives the IPP integer value. The
 * category name returned by {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class QueuedJobCount extends IntegerSyntax
    implements PrintServiceAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 7499723077864047742L;

    /**
     * Construct a new queued job count attribute with the given integer value.
     *
     * @param  value Integer value
     * @throws IllegalArgumentException if {@code value} is negative
     */
    public QueuedJobCount(int value) {
        super (value, 0, Integer.MAX_VALUE);
    }

    /**
     * Returns whether this queued job count attribute is equivalent to the
     * passed in object. To be equivalent, all of the following conditions mus
     * be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code QueuedJobCount}.
     *   <li>This queued job count attribute's value and {@code object}'s value
     *   are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this queued job
     *         count attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals (object) &&
               object instanceof QueuedJobCount);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code QueuedJobCount}, the category is class
     * {@code QueuedJobCount} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return QueuedJobCount.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code QueuedJobCount}, the category name is
     * {@code "queued-job-count"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "queued-job-count";
    }
}
