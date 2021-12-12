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
 * Class {@code HashPrintServiceAttributeSet} provides an attribute set which
 * inherits its implementation from class
 * {@link HashAttributeSet HashAttributeSet} and enforces the semantic
 * restrictions of interface
 * {@link PrintServiceAttributeSet PrintServiceAttributeSet}.
 *
 * @author Alan Kaminsky
 */
public class HashPrintServiceAttributeSet extends HashAttributeSet
    implements PrintServiceAttributeSet, Serializable {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 6642904616179203070L;

    /**
     * Construct a new, empty hash print service attribute set.
     */
    public HashPrintServiceAttributeSet() {
        super (PrintServiceAttribute.class);
    }

    /**
     * Construct a new hash print service attribute set, initially populated
     * with the given value.
     *
     * @param  attribute attribute value to add to the set
     * @throws NullPointerException if {@code attribute} is {@code null}
     */
    public HashPrintServiceAttributeSet(PrintServiceAttribute attribute) {
        super (attribute, PrintServiceAttribute.class);
    }

    /**
     * Construct a new print service attribute set, initially populated with the
     * values from the given array. The new attribute set is populated by adding
     * the elements of {@code attributes} array to the set in sequence, starting
     * at index 0. Thus, later array elements may replace earlier array elements
     * if the array contains duplicate attribute values or attribute categories.
     *
     * @param  attributes array of attribute values to add to the set. If
     *         {@code null}, an empty attribute set is constructed.
     * @throws NullPointerException if any element of {@code attributes} is
     *         {@code null}
     */
    public HashPrintServiceAttributeSet(PrintServiceAttribute[] attributes) {
        super (attributes, PrintServiceAttribute.class);
    }

    /**
     * Construct a new attribute set, initially populated with the values from
     * the given set where the members of the attribute set are restricted to
     * the {@code PrintServiceAttribute} interface.
     *
     * @param  attributes set of attribute values to initialise the set. If
     *         {@code null}, an empty attribute set is constructed.
     * @throws ClassCastException if any element of {@code attributes} is not an
     *         instance of {@code PrintServiceAttribute}
     */
    public HashPrintServiceAttributeSet(PrintServiceAttributeSet attributes)
    {
        super(attributes, PrintServiceAttribute.class);
    }
}
