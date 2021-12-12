/*
 * Copyright (c) 2005, 2020, Oracle and/or its affiliates. All rights reserved.
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

package javax.annotation.processing;

import java.io.IOException;

/**
 * Indicates a {@link Filer} detected an attempt to open a file that
 * would violate the guarantees provided by the {@code Filer}.  Those
 * guarantees include not creating the same file more than once, not
 * creating multiple files corresponding to the same class or
 * interface or package, and not creating files for classes or
 * interfaces with invalid names.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @author Peter von der Ah&eacute;
 * @since 1.6
 */
public class FilerException extends IOException {
    static final long serialVersionUID = 8426423106453163293L;
    /**
     * Constructs an exception with the specified detail message.
     * @param s the detail message, which should include the name of
     * the file attempting to be opened; may be {@code null}
     */
    public FilerException(String s) {
        super(s);
    }
}
