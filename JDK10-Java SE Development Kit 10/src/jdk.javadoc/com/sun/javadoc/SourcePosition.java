/*
 * Copyright (c) 2001, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

import java.io.File;

/**
 * This interface describes a source position: filename, line number,
 * and column number.
 *
 * @since 1.4
 * @author Neal M Gafter
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated
public interface SourcePosition {
    /** The source file. Returns null if no file information is
     *  available.
     *
     *  @return the source file as a File.
     */
    File file();

    /** The line in the source file. The first line is numbered 1;
     *  0 means no line number information is available.
     *
     *  @return the line number in the source file as an integer.
     */
    int line();

    /** The column in the source file. The first column is
     *  numbered 1; 0 means no column information is available.
     *  Columns count characters in the input stream; a tab
     *  advances the column number to the next 8-column tab stop.
     *
     *  @return the column on the source line as an integer.
     */
    int column();

    /** Convert the source position to the form "Filename:line". */
    String toString();
}
