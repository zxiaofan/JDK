/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.io;

import java.io.IOException;

/**
 * A <tt>Closeable</tt> is a source or destination of data that can be closed. 
 * The close method is invoked to release resources that the object is 
 * holding (such as open files).
 *
 * @version %I% %E%
 * @since 1.5
 */

public interface Closeable {

    /**
     * Closes this stream and releases any system resources associated
     * with it. If the stream is already closed then invoking this 
     * method has no effect. 
     *
     * @throws IOException if an I/O error occurs
     */
    public void close() throws IOException;

}
