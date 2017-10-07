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
import javax.print.attribute.PrintJobAttribute;

/**
 * Class NumberOfDocuments is an integer valued printing attribute that
 * indicates the number of individual docs the printer has accepted for this
 * job, regardless of whether the docs' print data has reached the printer or
 * not.
 * <P>
 * <B>IPP Compatibility:</B> The integer value gives the IPP integer value. The
 * category name returned by {@code getName()} gives the IPP attribute
 * name.
 *
 * @author  Alan Kaminsky
 */
public final class NumberOfDocuments extends IntegerSyntax
    implements PrintJobAttribute {

    private static final long serialVersionUID = 7891881310684461097L;


    /**
     * Construct a new number of documents attribute with the given integer
     * value.
     *
     * @param  value  Integer value.
     *
     * @exception  IllegalArgumentException
     *   (Unchecked exception) Thrown if {@code value} is less than 0.
     */
    public NumberOfDocuments(int value) {
        super (value, 0, Integer.MAX_VALUE);
    }

    /**
     * Returns whether this number of documents attribute is equivalent to the
     * passed in object. To be equivalent, all of the following conditions
     * must be true:
     * <OL TYPE=1>
     * <LI>
     * {@code object} is not null.
     * <LI>
     * {@code object} is an instance of class NumberOfDocuments.
     * <LI>
     * This number of documents attribute's value and {@code object}'s
     * value are equal.
     * </OL>
     *
     * @param  object  Object to compare to.
     *
     * @return  True if {@code object} is equivalent to this number of
     *          documents attribute, false otherwise.
     */
    public boolean equals(Object object) {
        return (super.equals (object) &&
                object instanceof NumberOfDocuments);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <P>
     * For class NumberOfDocuments, the
     * category is class NumberOfDocuments itself.
     *
     * @return  Printing attribute class (category), an instance of class
     *          {@link java.lang.Class java.lang.Class}.
     */
    public final Class<? extends Attribute> getCategory() {
        return NumberOfDocuments.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <P>
     * For class NumberOfDocuments, the
     * category name is {@code "number-of-documents"}.
     *
     * @return  Attribute category name.
     */
    public final String getName() {
        return "number-of-documents";
    }

}
