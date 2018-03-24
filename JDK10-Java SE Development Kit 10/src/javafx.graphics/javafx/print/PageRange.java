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

import java.util.Arrays;

import javafx.beans.NamedArg;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ReadOnlyIntegerProperty;
import javafx.beans.property.ReadOnlyIntegerWrapper;

/**
 * A {@code PageRange} is used to select or constrain the job print
 * stream pages to print.
 * Page numbering starts from 1 to correspond to user expectations.
 * The <i>start</i> page must be greater than zero and less than or
 * equal to the <i>end</i>page.
 * If start and end are equal, the range refers to a single page.
 * Values that exceed the number of job pages are harmlessly ignored
 * during printing.
 * @since JavaFX 8.0
 */
public final class PageRange {

    private ReadOnlyIntegerWrapper startPage, endPage;

    /**
     * Create a new PageRange with the specified start and end page numbers.
     * @param startPage the first page in the range.
     * @param endPage the last page in the range.
     * @throws IllegalArgumentException if the page range is not valid
     */
    public PageRange(@NamedArg("startPage") int startPage, @NamedArg("endPage") int endPage) {
        if (startPage <= 0 || startPage > endPage) {
            throw new IllegalArgumentException("Invalid range : " +
                                               startPage + " -> " + endPage);
        }
        startPageImplProperty().set(startPage);
        endPageImplProperty().set(endPage);
    }

    /**
     * <code>IntegerProperty</code> representing the starting
     * page number of the range. See {@link #setStartPage setStartPage()}
     * for more information.
     */
    private ReadOnlyIntegerWrapper startPageImplProperty() {
        if (startPage == null) {
            startPage =
                new ReadOnlyIntegerWrapper(PageRange.this, "startPage", 1) {

                @Override
                public void set(int value) {
                    if ((value <= 0) ||
                        (endPage != null && value < endPage.get())) {
                        return;
                    }
                    super.set(value);
                }
            };
        }
        return startPage;
    }

    /**
     * <code>IntegerProperty</code> representing the starting
     * page number of the range. See {@link getStartPage getStartPage()}
     * for more information.
     * @return the starting page number of the range
     */
    public ReadOnlyIntegerProperty startPageProperty() {
        return startPageImplProperty().getReadOnlyProperty();
    }

    /**
     * @return the starting page of the range.
     */
    public int getStartPage() {
        return startPageProperty().get();
    }

    private ReadOnlyIntegerWrapper endPageImplProperty() {
        if (endPage == null) {
            endPage =
                new ReadOnlyIntegerWrapper(PageRange.this, "endPage", 9999) {

                @Override
                public void set(int value) {
                    if ((value <= 0) ||
                        (startPage != null && value < startPage.get())) {
                        return;
                    }
                    super.set(value);
                }

            };
        }
        return endPage;
    }

    /**
     * <code>IntegerProperty</code> representing the ending
     * page number of the range. See {@link #getEndPage getEndPage()}
     * for more information.
     * @return the ending page number of the range
     */
    public ReadOnlyIntegerProperty endPageProperty() {
        return endPageImplProperty().getReadOnlyProperty();
    }

    /**
     * @return the ending page of the range.
     */
    public int getEndPage() {
        return endPageProperty().get();
    }
}
