/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt.print;

import java.io.Serial;

/**
 * The {@code PrinterAbortException} class is a subclass of
 * {@link PrinterException} and is used to indicate that a user
 * or application has terminated the print job while it was in
 * the process of printing.
 */

public class PrinterAbortException extends PrinterException {

    /**
     * Use serialVersionUID from JDK 9 for interoperability.
     */
    @Serial
    private static final long serialVersionUID = 4725169026278854136L;

    /**
     * Constructs a new {@code PrinterAbortException} with no
     * detail message.
     */
    public PrinterAbortException() {
        super();
    }

    /**
     * Constructs a new {@code PrinterAbortException} with
     * the specified detail message.
     * @param msg the message to be generated when a
     * {@code PrinterAbortException} is thrown
     */
    public PrinterAbortException(String msg) {
        super(msg);
    }

}
