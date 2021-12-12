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
 * Thrown when a serious Abstract Window Toolkit error has occurred.
 *
 * @author      Arthur van Hoff
 */
public class AWTError extends Error {

    /**
     * Use serialVersionUID from JDK 1.1 for interoperability.
     */
     @Serial
     private static final long serialVersionUID = -1819846354050686206L;

    /**
     * Constructs an instance of {@code AWTError} with the specified
     * detail message.
     * @param   msg   the detail message.
     * @since   1.0
     */
    public AWTError(String msg) {
        super(msg);
    }
}
