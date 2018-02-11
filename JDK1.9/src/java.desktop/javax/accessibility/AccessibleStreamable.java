/*
 * Copyright (c) 2003, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javax.accessibility;

import java.awt.datatransfer.DataFlavor;
import java.io.InputStream;

/**
 * The {@code AccessibleStreamable} interface should be implemented by the
 * {@code AccessibleContext} of any component that presents the raw stream
 * behind a component on the display screen. Examples of such components are
 * HTML, bitmap images and MathML. An object that implements
 * {@code AccessibleStreamable} provides two things: a list of MIME types
 * supported by the object and a streaming interface for each MIME type to get
 * the data.
 *
 * @author Lynn Monsanto
 * @author Peter Korn
 * @see AccessibleContext
 * @since 1.5
 */
public interface AccessibleStreamable {

    /**
     * Returns an array of {@code DataFlavor} objects for the MIME types this
     * object supports.
     *
     * @return an array of {@code DataFlavor} objects for the MIME types this
     *         object supports
     */
    DataFlavor[] getMimeTypes();

    /**
     * Returns an {@code InputStream} for a {@code DataFlavor}.
     *
     * @param  flavor the {@code DataFlavor}
     * @return an {@code ImputStream} if an input stream for this
     *         {@code DataFlavor} exists. Otherwise, {@code null} is returned.
     */
    InputStream getStream(DataFlavor flavor);
}
