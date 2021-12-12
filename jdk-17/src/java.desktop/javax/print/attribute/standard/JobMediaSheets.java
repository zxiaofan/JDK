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
import javax.print.attribute.PrintRequestAttribute;

/**
 * Class {@code JobMediaSheets} is an integer valued printing attribute class
 * that specifies the total number of media sheets to be produced for this job.
 * <p>
 * The {@code JobMediaSheets} attribute describes the size of the job. This
 * attribute is not intended to be a counter; it is intended to be useful
 * routing and scheduling information if known. The printer may try to compute
 * the {@code JobMediaSheets} attribute's value if it is not supplied in the
 * Print Request. Even if the client does supply a value for the
 * {@code JobMediaSheets} attribute in the Print Request, the printer may choose
 * to change the value if the printer is able to compute a value which is more
 * accurate than the client supplied value. The printer may be able to determine
 * the correct value for the {@code JobMediaSheets} attribute either right at
 * job submission time or at any later point in time.
 * <p>
 * Unlike the {@link JobKOctets JobKOctets} and
 * {@link JobImpressions JobImpressions} attributes, the {@code JobMediaSheets}
 * value must include the multiplicative factors contributed by the number of
 * copies specified by the {@link Copies Copies} attribute and a "number of
 * copies" instruction embedded in the document data, if any. This difference
 * allows the system administrator to control the lower and upper bounds of both
 * (1) the size of the document(s) with
 * {@link JobKOctetsSupported JobKOctetsSupported} and
 * {@link JobImpressionsSupported JobImpressionsSupported} and (2) the size of
 * the job with {@link JobMediaSheetsSupported JobMediaSheetsSupported}.
 * <p>
 * <b>IPP Compatibility:</b> The integer value gives the IPP integer value. The
 * category name returned by {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 * @see JobMediaSheetsSupported
 * @see JobMediaSheetsCompleted
 * @see JobKOctets
 * @see JobImpressions
 */
public class JobMediaSheets extends IntegerSyntax
        implements PrintRequestAttribute, PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 408871131531979741L;

    /**
     * Construct a new job media sheets attribute with the given integer value.
     *
     * @param  value Integer value
     * @throws IllegalArgumentException if {@code value} is negative
     */
    public JobMediaSheets(int value) {
        super (value, 0, Integer.MAX_VALUE);
    }

    /**
     * Returns whether this job media sheets attribute is equivalent to the
     * passed in object. To be equivalent, all of the following conditions must
     * be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code JobMediaSheets}.
     *   <li>This job media sheets attribute's value and {@code object}'s value
     *   are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this job media
     *         sheets attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return super.equals(object) && object instanceof JobMediaSheets;
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code JobMediaSheets} and any vendor-defined subclasses, the
     * category is class {@code JobMediaSheets} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return JobMediaSheets.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code JobMediaSheets} and any vendor-defined subclasses, the
     * category name is {@code "job-media-sheets"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "job-media-sheets";
    }
}
