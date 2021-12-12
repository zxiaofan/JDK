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

import javax.print.DocPrintJob;
import javax.print.attribute.AttributeSetUtilities;
import javax.print.attribute.PrintJobAttributeSet;

/**
 * Class {@code PrintJobAttributeEvent} encapsulates an event a
 * {@code PrintService} reports to let the client know that one or more printing
 * attributes for a {@code PrintJob} have changed.
 */
public class PrintJobAttributeEvent extends PrintEvent {

    /**
     * Use serialVersionUID from JDK 1.4 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = -6534469883874742101L;

    /**
     * The printing service attributes that changed.
     */
    @SuppressWarnings("serial") // Not statically typed as Serializable
    private PrintJobAttributeSet attributes;

    /**
     * Constructs a {@code PrintJobAttributeEvent} object.
     *
     * @param  source the print job generating this event
     * @param  attributes the attribute changes being reported
     * @throws IllegalArgumentException if {@code source} is {@code null}
     */
    public PrintJobAttributeEvent (DocPrintJob source,
                                   PrintJobAttributeSet attributes)  {
        super(source);

        this.attributes = AttributeSetUtilities.unmodifiableView(attributes);
    }

    /**
     * Determine the {@code PrintJob} to which this print job event pertains.
     *
     * @return {@code PrintJob} object
     */
    public DocPrintJob getPrintJob() {

        return (DocPrintJob) getSource();
    }

    /**
     * Determine the printing attributes that changed and their new values.
     *
     * @return attributes containing the new values for the print job attributes
     *         that changed. The returned set may not be modifiable.
     */
    public PrintJobAttributeSet getAttributes() {

        return attributes;
    }
}
