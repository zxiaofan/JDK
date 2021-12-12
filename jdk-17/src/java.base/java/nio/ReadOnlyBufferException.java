/*
 * Copyright (c) 2000, 2021, Oracle and/or its affiliates. All rights reserved.
 *
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
 *
 */

// -- This file was mechanically generated: Do not edit! -- //

package java.nio;


/**
 * Unchecked exception thrown when a content-mutation method such as
 * <code>put</code> or <code>compact</code> is invoked upon a read-only buffer.
 *
 * @since 1.4
 */

public class ReadOnlyBufferException
    extends UnsupportedOperationException
{

    @java.io.Serial
    private static final long serialVersionUID = -1210063976496234090L;

    /**
     * Constructs an instance of this class.
     */
    public ReadOnlyBufferException() { }

}
