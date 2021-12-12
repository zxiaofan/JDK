/*
 * Copyright (c) 2003, 2021, Oracle and/or its affiliates. All rights reserved.
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
import javax.print.attribute.PrintRequestAttribute;

/**
 * Class {@code DialogTypeSelection} is a printing attribute class, an
 * enumeration, that indicates the user dialog type to be used for specifying
 * printing options. If {@code NATIVE} is specified, then where available, a
 * native platform dialog is displayed. If {@code COMMON} is specified, a
 * cross-platform print dialog is displayed.
 * <p>
 * This option to specify a native dialog for use with an IPP attribute set
 * provides a standard way to reflect back of the setting and option changes
 * made by a user to the calling application, and integrates the native dialog
 * into the Java printing APIs. But note that some options and settings in a
 * native dialog may not necessarily map to IPP attributes as they may be
 * non-standard platform, or even printer specific options.
 * <p>
 * <b>IPP Compatibility:</b> This is not an IPP attribute.
 *
 * @since 1.7
 */
public final class DialogTypeSelection extends EnumSyntax
        implements PrintRequestAttribute {

    /**
     * Use serialVersionUID from JDK 1.7 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 7518682952133256029L;

    /**
     * The native platform print dialog should be used.
     */
    public static final DialogTypeSelection
        NATIVE = new DialogTypeSelection(0);

    /**
     * The cross-platform print dialog should be used.
     */
    public static final DialogTypeSelection
        COMMON = new DialogTypeSelection(1);

    /**
     * Constructs a new dialog type selection enumeration value with the given
     * integer value.
     *
     * @param  value Integer value
     */
    protected DialogTypeSelection(int value) {
                super(value);
    }

    /**
     * The string table for class {@code DialogTypeSelection}.
     */
    private static final String[] myStringTable = {
        "native", "common"};

    /**
     * The enumeration value table for class
     * {@code DialogTypeSelection}.
     */
    private static final DialogTypeSelection[] myEnumValueTable = {
        NATIVE,
        COMMON
    };

    /**
     * Returns the string table for class {@code DialogTypeSelection}.
     */
    protected String[] getStringTable() {
        return myStringTable;
    }

    /**
     * Returns the enumeration value table for class
     * {@code DialogTypeSelection}.
     */
    protected EnumSyntax[] getEnumValueTable() {
        return myEnumValueTable;
    }

    /**
     * Gets the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code DialogTypeSelection} the category is class
     * {@code DialogTypeSelection} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return DialogTypeSelection.class;
    }

    /**
     * Gets the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code DialogTypeSelection} the category name is
     * {@code "dialog-type-selection"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "dialog-type-selection";
    }
}
