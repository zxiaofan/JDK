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
 * Class {@code HashPrintJobAttributeSet} provides an attribute set which
 * inherits its implementation from class
 * {@link HashAttributeSet HashAttributeSet} and enforces the semantic
 * restrictions of interface {@link PrintJobAttributeSet PrintJobAttributeSet}.
 *
 * @author Alan Kaminsky
 */
public class HashPrintJobAttributeSet extends HashAttributeSet
    implements PrintJobAttributeSet, Serializable {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -4204473656070350348L;

    /**
     * Construct a new, empty hash print job attribute set.
     */
    public HashPrintJobAttributeSet() {
        super(PrintJobAttribute.class);
    }

    /**
     * Construct a new hash print job attribute set, initially populated with
     * the given value.
     *
     * @param  attribute attribute value to add to the set
     * @throws NullPointerException if {@code attribute} is {@code null}
     */
    public HashPrintJobAttributeSet(PrintJobAttribute attribute) {
        super(attribute, PrintJobAttribute.class);
    }

    /**
     * Construct a new hash print job attribute set, initially populated with
     * the values from the given array. The new attribute set is populated by
     * adding the elements of {@code attributes} array to the set in sequence,
     * starting at index 0. Thus, later array elements may replace earlier array
     * elements if the array contains duplicate attribute values or attribute
     * categories.
     *
     * @param  attributes array of attribute values to add to the set. If
     *         {@code null}, an empty attribute set is constructed.
     * @throws NullPointerException if any element of {@code attributes} is
     *         {@code null}
     */
    public HashPrintJobAttributeSet(PrintJobAttribute[] attributes) {
        super (attributes, PrintJobAttribute.class);
    }

    /**
     * Construct a new attribute set, initially populated with the values from
     * the given set where the members of the attribute set are restricted to
     * the {@code PrintJobAttribute} interface.
     *
     * @param  attributes set of attribute values to initialise the set. If
     *         {@code null}, an empty attribute set is constructed.
     * @throws ClassCastException if any element of {@code attributes} is not an
     *         instance of {@code PrintJobAttribute}
     */
    public HashPrintJobAttributeSet(PrintJobAttributeSet attributes) {
        super(attributes, PrintJobAttribute.class);
    }
}
