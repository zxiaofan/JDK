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

package javax.print.event;

import java.io.Serial;

import javax.print.PrintService;
import javax.print.attribute.AttributeSetUtilities;
import javax.print.attribute.PrintServiceAttributeSet;

/**
 * Class {@code PrintServiceAttributeEvent} encapsulates an event a Print
 * Service instance reports to let the client know of changes in the print
 * service state.
 */
public class PrintServiceAttributeEvent extends PrintEvent {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -7565987018140326600L;

    /**
     * The printing service attributes that changed.
     */
    @SuppressWarnings("serial") // Not statically typed as Serializable
    private PrintServiceAttributeSet attributes;

    /**
     * Constructs a {@code PrintServiceAttributeEvent} object.
     *
     * @param  source the print job generating this event
     * @param  attributes the attribute changes being reported
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public PrintServiceAttributeEvent(PrintService source,
                                      PrintServiceAttributeSet attributes) {

        super(source);
        this.attributes = AttributeSetUtilities.unmodifiableView(attributes);
    }

    /**
     * Returns the print service.
     *
     * @return {@code PrintService} object
     */
    public PrintService getPrintService() {

        return (PrintService) getSource();
    }

    /**
     * Determine the printing service attributes that changed and their new
     * values.
     *
     * @return attributes containing the new values for the service attributes
     *         that changed. The returned set may be unmodifiable.
     */
    public PrintServiceAttributeSet getAttributes() {

        return attributes;
    }
}
