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
import javax.print.attribute.EnumSyntax;
import javax.print.attribute.PrintJobAttribute;
import javax.print.attribute.PrintRequestAttribute;

/**
 * Class {@code Fidelity} is a printing attribute class, an enumeration, that
 * indicates whether total fidelity to client supplied print request attributes
 * is required. If {@code FIDELITY_TRUE} is specified and a service cannot print
 * the job exactly as specified it must reject the job. If
 * {@code FIDELITY_FALSE} is specified a reasonable attempt to print the job is
 * acceptable. If not supplied the default is {@code FIDELITY_FALSE}.
 * <p>
 * <b>IPP Compatibility:</b> The IPP boolean value is "true" for
 * {@code FIDELITY_TRUE} and "false" for {@code FIDELITY_FALSE}. The category
 * name returned by {@code getName()} is the IPP attribute name. The
 * enumeration's integer value is the IPP enum value. The {@code toString()}
 * method returns the IPP string representation of the attribute value. See
 * <a href="http://www.ietf.org/rfc/rfc2911.txt">RFC 2911</a> Section 15.1 for a
 * fuller description of the IPP fidelity attribute.
 */
public final class Fidelity extends EnumSyntax
        implements PrintJobAttribute, PrintRequestAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 6320827847329172308L;

    /**
     * The job must be printed exactly as specified. or else rejected.
     */
    public static final Fidelity
        FIDELITY_TRUE = new Fidelity(0);

    /**
     * The printer should make reasonable attempts to print the job, even if it
     * cannot print it exactly as specified.
     */
    public static final Fidelity
        FIDELITY_FALSE = new Fidelity(1);

    /**
     * Construct a new fidelity enumeration value with the given integer value.
     *
     * @param  value Integer value
     */
    protected Fidelity(int value) {
        super (value);
    }

    /**
     * The string table for class {@code Fidelity}.
     */
    private static final String[] myStringTable = {
        "true",
        "false"
    };

    /**
     * The enumeration value table for class {@code Fidelity}.
     */
    private static final Fidelity[] myEnumValueTable = {
        FIDELITY_TRUE,
        FIDELITY_FALSE
    };

    /**
     * Returns the string table for class {@code Fidelity}.
     */
    protected String[] getStringTable() {
        return myStringTable;
    }

    /**
     * Returns the enumeration value table for class {@code Fidelity}.
     */
    protected EnumSyntax[] getEnumValueTable() {
        return myEnumValueTable;
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code Fidelity} the category is class
     * {@code Fidelity} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return Fidelity.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code Fidelity} the category name is
     * {@code "ipp-attribute-fidelity"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "ipp-attribute-fidelity";
    }
}
