/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL.  Use is subject to license terms.
 */

package com.sun.mirror.util;


import java.io.File;


/**
 * Represents a position in a source file.
 *
 * @author Joseph D. Darcy
 * @author Scott Seligman
 * @version %I% %E%
 * @since 1.5
 */

public interface SourcePosition {

    /**
     * Returns the source file containing this position.
     *
     * @return the source file containing this position; never null
     */
    File file();

    /**
     * Returns the line number of this position.  Lines are numbered
     * starting with 1.
     *
     * @return the line number of this position, or 0 if the line
     * number is unknown or not applicable
     */
    int line();

    /**
     * Returns the column number of this position.  Columns are numbered
     * starting with 1.
     *
     * @return the column number of this position, or 0 if the column
     * number is unknown or not applicable
     */
    int column();
}
