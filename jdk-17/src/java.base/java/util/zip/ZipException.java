/*
 * Copyright (c) 1995, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.util.zip;

import java.io.IOException;

/**
 * Signals that a Zip exception of some sort has occurred.
 *
 * @see     java.io.IOException
 * @since   1.1
 */

public class ZipException extends IOException {
    @java.io.Serial
    private static final long serialVersionUID = 8000196834066748623L;

    /**
     * Constructs a {@code ZipException} with {@code null}
     * as its error detail message.
     */
    public ZipException() {
        super();
    }

    /**
     * Constructs a {@code ZipException} with the specified detail
     * message.
     *
     * @param   s   the detail message.
     */

    public ZipException(String s) {
        super(s);
    }
}
