/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

/*
 * @(#)SharedInputStream.java 1.2 02/03/27
 */



package com.sun.xml.internal.messaging.saaj.packaging.mime.internet;

import java.io.InputStream;
import java.io.OutputStream;

// SAAJ doesn't utilize this, but I think it should.
/**
 * An InputStream that is backed by data that can be shared by multiple
 * readers may implement this interface.  This allows users of such an
 * InputStream to determine the current positionin the InputStream, and
 * to create new InputStreams representing a subset of the data in the
 * original InputStream.  The new InputStream will access the same
 * underlying data as the original, without copying the data.
 *
 * @version 1.2, 02/03/27
 * @author  Bill Shannon
 * @since JavaMail 1.2
 */

public interface SharedInputStream {
    /**
     * Return the current position in the InputStream, as an
     * offset from the beginning of the InputStream.
     *
     * @return  the current position
     */
    public long getPosition();

    /**
     * Return a new InputStream representing a subset of the data
     * from this InputStream, starting at <code>start</code> (inclusive)
     * up to <code>end</code> (exclusive).  <code>start</code> must be
     * non-negative.  If <code>end</code> is -1, the new stream ends
     * at the same place as this stream.  The returned InputStream
     * will also implement the SharedInputStream interface.
     *
     * @param   start   the starting position
     * @param   end     the ending position + 1
     * @return          the new stream
     */
    public InputStream newStream(long start, long end);

    /**
     * Writes the specified region to another {@link OutputStream}.
     * @param   start   the starting position
     * @param   end     the ending position + 1
     * @param   out     output stream
     */
    public void writeTo(long start,long end, OutputStream out);
}
