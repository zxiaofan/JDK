/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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

package java.awt;

/**
 * An abstract class which provides a print graphics context for a page.
 *
 * @author      Amy Fowler
 */
public interface PrintGraphics {

    /**
     * Returns the PrintJob object from which this PrintGraphics
     * object originated.
     *
     * @return the print job for this object
     */
    public PrintJob getPrintJob();

}
