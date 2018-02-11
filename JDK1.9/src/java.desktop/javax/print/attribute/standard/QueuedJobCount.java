/*
 * Copyright (c) 2000, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.print.attribute.Attribute;
import javax.print.attribute.IntegerSyntax;
import javax.print.attribute.PrintServiceAttribute;

/**
 * Class QueuedJobCount is an integer valued printing attribute that indicates
 * the number of jobs in the printer whose {@link JobState JobState} is either
 * PENDING, PENDING_HELD, PROCESSING, or PROCESSING_STOPPED.
 * <P>
 * <B>IPP Compatibility:</B> The integer value gives the IPP integer value.
 * The category name returned by {@code getName()} gives the IPP
 * attribute name.
 *
 * @author  Alan Kaminsky
 */
public final class QueuedJobCount extends IntegerSyntax
    implements PrintServiceAttribute {

    private static final long serialVersionUID = 7499723077864047742L;

    /**
     * Construct a new queued job count attribute with the given integer
     * value.
     *
     * @param  value  Integer value.
     *
     * @exception  IllegalArgumentException
     *   (Unchecked exception) Thrown if {@code value} is less than 0.
     */
    public QueuedJobCount(int value) {
        super (value, 0, Integer.MAX_VALUE);
    }

    /**
     * Returns whether this queued job count attribute is equivalent to the
     * passed in object. To be equivalent, all of the following conditions
     * mus  be true:
     * <OL TYPE=1>
     * <LI>
     * {@code object} is not null.
     * <LI>
     * {@code object} is an instance of class QueuedJobCount.
     * <LI>
     * This queued job count attribute's value and {@code object}'s
     * value are equal.
     * </OL>
     *
     * @param  object  Object to compare to.
     *
     * @return  True if {@code object} is equivalent to this queued job
     *          count attribute, false otherwise.
     */
    public boolean equals(Object object) {
        return (super.equals (object) &&
               object instanceof QueuedJobCount);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <P>
     * For class QueuedJobCount, the category is class QueuedJobCount itself.
     *
     * @return  Printing attribute class (category), an instance of class
     *          {@link java.lang.Class java.lang.Class}.
     */
    public final Class<? extends Attribute> getCategory() {
        return QueuedJobCount.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <P>
     * For class QueuedJobCount, the
     * category name is {@code "queued-job-count"}.
     *
     * @return  Attribute category name.
     */
    public final String getName() {
        return "queued-job-count";
    }

}
