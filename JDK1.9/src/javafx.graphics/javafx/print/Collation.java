/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

package javafx.print;

/**
 * Collation specifies whether or not media sheets of each copy
 * of a printed document in a job are to be in sequence.
 * It has no effect or relevance unless multiple job copies are printed.
 *
 * @since JavaFX 8.0
 */
public enum Collation {

    /**
     * The same numbered pages are consecutive in the output,
     * For example: 2 copies of a document with 2 pages is printed :
     * Page 1, Page 1, Page 2, Page 2.
     */
    UNCOLLATED,

    /**
     * Each copy of a document is printed together.
     * FOr example: 2 copies of a document with 2 pages is printed :
     * Page 1, Page 2, Page 1, Page 2.
     */
    COLLATED
}
