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
import javax.print.attribute.DocAttribute;
import javax.print.attribute.EnumSyntax;
import javax.print.attribute.PrintJobAttribute;
import javax.print.attribute.PrintRequestAttribute;

/**
 * Class {@code Media} is a printing attribute class that specifies the medium
 * on which to print.
 * <p>
 * Media may be specified in different ways.
 * <ul>
 *   <li>it may be specified by paper source - eg paper tray
 *   <li>it may be specified by a standard size - eg "A4"
 *   <li>it may be specified by a name - eg "letterhead"
 * </ul>
 * Each of these corresponds to the IPP "media" attribute. The current API does
 * not support describing media by characteristics (eg colour, opacity). This
 * may be supported in a later revision of the specification.
 * <p>
 * A {@code Media} object is constructed with a value which represents one of
 * the ways in which the Media attribute can be specified.
 * <p>
 * <b>IPP Compatibility:</b> The category name returned by {@code getName()} is
 * the IPP attribute name. The enumeration's integer value is the IPP enum
 * value. The {@code toString()} method returns the IPP string representation of
 * the attribute value.
 *
 * @author Phil Race
 */
public abstract class Media extends EnumSyntax
    implements DocAttribute, PrintRequestAttribute, PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -2823970704630722439L;

    /**
     * Constructs a new media attribute specified by name.
     *
     * @param  value a value
     */
    protected Media(int value) {
           super (value);
    }

    /**
     * Returns whether this media attribute is equivalent to the passed in
     * object. To be equivalent, all of the following conditions must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is of the same subclass of {@code Media} as this
     *   object.
     *   <li>The values are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this media
     *         attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return(object != null && object instanceof Media &&
               object.getClass() == this.getClass() &&
               ((Media)object).getValue() == this.getValue());
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code Media} and any vendor-defined subclasses, the category
     * is class {@code Media} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return Media.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code Media} and any vendor-defined subclasses, the category
     * name is {@code "media"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "media";
    }
}
