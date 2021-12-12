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
import javax.print.attribute.PrintJobAttribute;
import javax.print.attribute.TextSyntax;

/**
 * Class {@code OutputDeviceAssigned} is a printing attribute class, a text
 * attribute, that identifies the output device to which the service has
 * assigned this job. If an output device implements an embedded Print Service
 * instance, the printer need not set this attribute. If a print server
 * implements a Print Service instance, the value may be empty (zero- length
 * string) or not returned until the service assigns an output device to the
 * job. This attribute is particularly useful when a single service supports
 * multiple devices (so called "fan-out").
 * <p>
 * <b>IPP Compatibility:</b> The string value gives the IPP name value. The
 * locale gives the IPP natural language. The category name returned by
 * {@code getName()} gives the IPP attribute name.
 *
 * @author Alan Kaminsky
 */
public final class OutputDeviceAssigned extends TextSyntax
    implements PrintJobAttribute {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 5486733778854271081L;

    /**
     * Constructs a new output device assigned attribute with the given device
     * name and locale.
     *
     * @param  deviceName device name
     * @param  locale natural language of the text string. {@code null} is
     *         interpreted to mean the default locale as returned by
     *         {@code Locale.getDefault()}
     * @throws NullPointerException if {@code deviceName} is {@code null}
     */
    public OutputDeviceAssigned(String deviceName, Locale locale) {

        super (deviceName, locale);
    }

    // Exported operations inherited and overridden from class Object.

    /**
     * Returns whether this output device assigned attribute is equivalent to
     * the passed in object. To be equivalent, all of the following conditions
     * must be true:
     * <ol type=1>
     *   <li>{@code object} is not {@code null}.
     *   <li>{@code object} is an instance of class
     *   {@code OutputDeviceAssigned}.
     *   <li>This output device assigned attribute's underlying string and
     *   {@code object}'s underlying string are equal.
     *   <li>This output device assigned attribute's locale and {@code object}'s
     *   locale are equal.
     * </ol>
     *
     * @param  object {@code Object} to compare to
     * @return {@code true} if {@code object} is equivalent to this output
     *         device assigned attribute, {@code false} otherwise
     */
    public boolean equals(Object object) {
        return (super.equals (object) &&
                object instanceof OutputDeviceAssigned);
    }

    /**
     * Get the printing attribute class which is to be used as the "category"
     * for this printing attribute value.
     * <p>
     * For class {@code OutputDeviceAssigned}, the category is class
     * {@code OutputDeviceAssigned} itself.
     *
     * @return printing attribute class (category), an instance of class
     *         {@link Class java.lang.Class}
     */
    public final Class<? extends Attribute> getCategory() {
        return OutputDeviceAssigned.class;
    }

    /**
     * Get the name of the category of which this attribute value is an
     * instance.
     * <p>
     * For class {@code OutputDeviceAssigned}, the category name is
     * {@code "output-device-assigned"}.
     *
     * @return attribute category name
     */
    public final String getName() {
        return "output-device-assigned";
    }
}
