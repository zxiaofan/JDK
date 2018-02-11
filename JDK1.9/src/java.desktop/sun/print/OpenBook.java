/*
 * Copyright (c) 1998, 2000, Oracle and/or its affiliates. All rights reserved.
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

package sun.print;

import java.awt.print.Pageable;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

/**
 * A Book with an unknown number of pages where each
 * page has the same format and painter. This class
 * is used by PrinterJob to print Pageable jobs.
 */

class OpenBook implements Pageable {

 /* Class Constants */

 /* Class Variables */

 /* Instance Variables */

    /**
     * The format of all of the pages.
     */
    private PageFormat mFormat;

    /**
     * The object that will render all of the pages.
     */
    private Printable mPainter;

 /* Instance Methods */

    /**
     * Create a  Pageable with an unknown number of pages
     * where every page shares the same format and
     * Printable.
     */
    OpenBook(PageFormat format, Printable painter) {
        mFormat = format;
        mPainter = painter;
    }

    /**
     * This object does not know the number of pages.
     */
    public int getNumberOfPages(){
        return UNKNOWN_NUMBER_OF_PAGES;
    }

    /**
     * Return the PageFormat of the page specified by 'pageIndex'.
     * @param pageIndex The zero based index of the page whose
     *                  PageFormat is being requested.
     * @return The PageFormat describing the size and orientation
     */
    public PageFormat getPageFormat(int pageIndex) {
        return mFormat;
    }

    /**
     * Return the Printable instance responsible for rendering
     * the page specified by 'pageIndex'.
     * @param pageIndex The zero based index of the page whose
     *                  Printable is being requested.
     * @return The Printable that will draw the page.
     */
    public Printable getPrintable(int pageIndex)
        throws IndexOutOfBoundsException
    {
        return mPainter;
    }
}
