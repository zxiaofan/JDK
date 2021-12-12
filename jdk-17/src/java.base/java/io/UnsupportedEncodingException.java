/*
 * Copyright (c) 1996, 2019, Oracle and/or its affiliates. All rights reserved.
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
package java.io;

/**
 * The Character Encoding is not supported.
 *
 * @author  Asmus Freytag
 * @since   1.1
 */
public class UnsupportedEncodingException
    extends IOException
{
    @java.io.Serial
    private static final long serialVersionUID = -4274276298326136670L;

    /**
     * Constructs an UnsupportedEncodingException without a detail message.
     */
    public UnsupportedEncodingException() {
        super();
    }

    /**
     * Constructs an UnsupportedEncodingException with a detail message.
     * @param s Describes the reason for the exception.
     */
    public UnsupportedEncodingException(String s) {
        super(s);
    }
}
