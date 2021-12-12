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
 * Class {@code JobSheets} is a printing attribute class, an enumeration, that
 * determines which job start and end sheets, if any, must be printed with a
 * job. Class {@code JobSheets} declares keywords for standard job sheets
 * values. Implementation- or site-defined names for a job sheets attribute may
 * also be created by defining a subclass of class {@code JobSheets}.
 * <p>
 * The effect of a {@code JobSheets} attribute on multidoc print jobs (jobs with
 * multiple documents) may be affected by the
 * {@link MultipleDocumentHandling MultipleDocumentHandling} job attribute,
 * depending on the meaning of the particular {@code JobSheets} value.
 * <p>
 * <b>IPP Compatibility:</b> The category name returned by {@code getName()} is
 * the IPP attribute name. The enumeration's integer value is the IPP enum
 * value. The {@code toString()} method returns the IPP string representation of
 * the attribute value. For a subclass, the attribute value must be localized to
 * give the IPP name and natural language values.
 *
 * @author Alan Kaminsky
 */
public class JobSheets extends EnumSyntax
        implements PrintRequestAttribute, PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -4735258056132519759L;

    /**
     * No job sheets are printed.
     */
    public static final JobSheets NONE = new JobSheets(0);

    /**
     * One or more site specific standard job sheets are printed. e.g. a single
     * start sheet is printed, or both start and end sheets are printed.
     */
    public static final JobSheets STANDARD = new JobSheets(1);

    /**
     * Construct a new job sheets enumeration value with the given integer
     * value.
     *
     * @param  value Integer value
     */
    protected JobSheets(int value) {
        super (value);
    }

    /**
     * The string table for class {@code JobSheets}.
     */
    private static final String[] myStringTable = {
        "none",
        "standard"
    };

    /**
     * The enumeration value table for class {@code JobSheets}.
     */
    private static final JobSheets[] myEnumValueTable = {
        NONE,
        STANDARD
    };

    /**
     * Returns the string table for class {@code JobSheets}.
     */
    protected String[] getStringTable() {
        return myStringTable.clone();
    }

    /**
     * Returns the enumeration value table for class {@code JobSheets}.
     */
    protected EnumSyntax[] getEnumValueTable() {
        return (EnumSyntax[])myEnumValueTable.clone();
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code JobSheets} and any vendor-defined subclasses, the
     * category is class {@code JobSheets} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return JobSheets.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code JobSheets} and any vendor-defined subclasses, the
     * category name is {@code "job-sheets"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "job-sheets";
    }
}
