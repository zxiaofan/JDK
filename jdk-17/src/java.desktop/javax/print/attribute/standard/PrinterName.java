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
 * Class {@code PrinterName} is a printing attribute class, a text attribute,
 * that specifies the name of a printer. It is a name that is more end-user
 * friendly than a {@code URI}. An administrator determines a printer's name and
 * sets this attribute to that name. This name may be the last part of the
 * printer's {@code URI} or it may be unrelated. In non-US-English locales, a
 * name may contain characters that are not allowed in a {@code URI}.
 * <p>
 * <b>IPP Compatibility:</b> The string value gives the IPP name value. The
 * locale gives the IPP natural language. The category name returned by
 * {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class PrinterName extends TextSyntax
        implements PrintServiceAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 299740639137803127L;

    /**
     * Constructs a new printer name attribute with the given name and locale.
     *
     * @param  printerName printer name
     * @param  locale natural language of the text string. {@code null} is
     *         interpreted to mean the default locale as returned by
     *         {@code Locale.getDefault()}
     * @throws NullPointerException if {@code printerName} is {@code null}
     */
    public PrinterName(String printerName, Locale locale) {
        super (printerName, locale);
    }

    /**
     * Returns whether this printer name attribute is equivalent to the passed
     * in object. To be equivalent, all of the following conditions must be
     * true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code PrinterName}.
     *   <li>This printer name attribute's underlying string and
     *   {@code object}'s underlying string are equal.
     *   <li>This printer name attribute's locale and {@code object}'s locale
     *   are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this printer name
     *         attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals(object) && object instanceof PrinterName);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code PrinterName}, the category is class
     * {@code PrinterName} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return PrinterName.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code PrinterName}, the category name is
     * {@code "printer-name"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "printer-name";
    }
}
