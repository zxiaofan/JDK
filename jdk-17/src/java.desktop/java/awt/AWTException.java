/*
 * Copyright (c) 1995, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

import java.io.Serial;

/**
 * Signals that an Abstract Window Toolkit exception has occurred.
 *
 * @author      Arthur van Hoff
 */
public class AWTException extends Exception {

    /**
     * Use serialVersionUID from JDK 1.1 for interoperability.
     */
     @Serial
     private static final long serialVersionUID = -1900414231151323879L;

    /**
     * Constructs an instance of {@code AWTException} with the
     * specified detail message. A detail message is an
     * instance of {@code String} that describes this particular
     * exception.
     * @param   msg     the detail message
     * @since   1.0
     */
    public AWTException(String msg) {
        super(msg);
    }
}
