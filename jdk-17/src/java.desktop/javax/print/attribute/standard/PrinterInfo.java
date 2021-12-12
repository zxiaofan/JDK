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
 * Class {@code PrinterInfo} is a printing attribute class, a text attribute,
 * that provides descriptive information about a printer. This could include
 * things like: {@code "This printer can be used for printing color
 * transparencies for HR presentations"}, or {@code "Out of courtesy for others,
 * please print only small (1-5 page) jobs at this printer"}, or even
 * {@code "This printer is going away on July 1, 1997, please find a new
 * printer"}.
 * <p>
 * <b>IPP Compatibility:</b> The string value gives the IPP name value. The
 * locale gives the IPP natural language. The category name returned by {@code
 * getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class PrinterInfo extends TextSyntax
        implements PrintServiceAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 7765280618777599727L;

    /**
     * Constructs a new printer info attribute with the given information string
     * and locale.
     *
     * @param  info printer information string
     * @param  locale natural language of the text string. {@code null} is
     *         interpreted to mean the default locale as returned by
     *         {@code Locale.getDefault()}
     * @throws NullPointerException if {@code info} is {@code null}
     */
    public PrinterInfo(String info, Locale locale) {
        super (info, locale);
    }

    /**
     * Returns whether this printer info attribute is equivalent to the passed
     * in object. To be equivalent, all of the following conditions must be
     * true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class {@code PrinterInfo}.
     *   <li>This printer info attribute's underlying string and
     *   {@code object}'s underlying string are equal.
     *   <li>This printer info attribute's locale and {@code object}'s locale
     *   are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this printer info
     *         attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals(object) && object instanceof PrinterInfo);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code PrinterInfo}, the category is class
     * {@code PrinterInfo} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return PrinterInfo.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code PrinterInfo}, the category name is
     * {@code "printer-info"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "printer-info";
    }
}
