/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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
package sun.swing.text;

import java.util.*;
import java.awt.Graphics;
import java.awt.print.*;


/**
 * Printable to merge multiple printables into one.
 *
 * @author Igor Kushnirskiy
 *
 * @since 1.6
 */
class CompoundPrintable implements CountingPrintable {
    private final Queue<CountingPrintable> printables;
    private int offset = 0;

    public CompoundPrintable(List<CountingPrintable> printables) {
        this.printables = new LinkedList<CountingPrintable>(printables);
    }

    public int print(final Graphics graphics,
                     final PageFormat pf,
                     final int pageIndex) throws PrinterException {
        int ret = NO_SUCH_PAGE;
        while (printables.peek() != null) {
            ret = printables.peek().print(graphics, pf, pageIndex - offset);
            if (ret == PAGE_EXISTS) {
                break;
            } else {
                offset += printables.poll().getNumberOfPages();
            }
        }
        return ret;
    }

    /**
     * Returns the number of pages in this printable.
     * <p>
     * This number is defined only after {@code print} returns NO_SUCH_PAGE.
     *
     * @return the number of pages.
     */
    public int getNumberOfPages() {
        return offset;
    }

}
