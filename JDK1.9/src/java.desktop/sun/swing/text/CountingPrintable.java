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


import java.awt.print.*;

/**
 * Printable which counts the number of pages.
 *
 * @author Igor Kushnirskiy
 *
 * @since 1.6
 */

public interface CountingPrintable extends Printable {
    /**
     * Returns the number of pages in this printable.
     * <p>
     * This number is defined only after {@code print} returns NO_SUCH_PAGE.
     *
     * @return the number of pages.
     */
    int getNumberOfPages();
}
