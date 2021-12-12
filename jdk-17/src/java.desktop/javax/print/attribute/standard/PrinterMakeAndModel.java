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
import java.util.Locale;

import javax.print.attribute.Attribute;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.TextSyntax;

/**
 * Class {@code PrinterMakeAndModel} is a printing attribute class, a text
 * attribute, that the make and model of the printer.
 * <p>
 * <b>IPP Compatibility:</b> The string value gives the IPP name value. The
 * locale gives the IPP natural language. The category name returned by
 * {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class PrinterMakeAndModel extends TextSyntax
        implements PrintServiceAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 4580461489499351411L;

    /**
     * Constructs a new printer make and model attribute with the given make and
     * model string and locale.
     *
     * @param  makeAndModel printer make and model string
     * @param  locale natural language of the text string. {@code null} is
     *         interpreted to mean the default locale as returned by
     *         {@code Locale.getDefault()}
     * @throws NullPointerException if {@code makeAndModel} is {@code null}
     */
    public PrinterMakeAndModel(String makeAndModel, Locale locale) {
        super (makeAndModel, locale);
    }

    /**
     * Returns whether this printer make and model attribute is equivalent to
     * the passed in object. To be equivalent, all of the following conditions
     * must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code PrinterMakeAndModel}.
     *   <li>This printer make and model attribute's underlying string and
     *   {@code object}'s underlying string are equal.
     *   <li>This printer make and model attribute's locale and {@code object}'s
     *   locale are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this printer make
     *         and model attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals(object) &&
                object instanceof PrinterMakeAndModel);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code PrinterMakeAndModel}, the category is class
     * {@code PrinterMakeAndModel} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return PrinterMakeAndModel.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code PrinterMakeAndModel}, the category name is
     * {@code "printer-make-and-model"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "printer-make-and-model";
    }
}
