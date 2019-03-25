/*
 * Copyright (c) 2003, 2014, Oracle and/or its affiliates. All rights reserved.
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

import javax.print.attribute.Attribute;
import javax.print.attribute.PrintRequestAttribute;

/*
 * A class used to determine the range of pages to be printed.
 */
@SuppressWarnings("serial") // JDK implementation class
public final class SunPageSelection implements PrintRequestAttribute {

    public static final SunPageSelection ALL = new SunPageSelection(0);
    public static final SunPageSelection RANGE = new SunPageSelection(1);
    public static final SunPageSelection SELECTION = new SunPageSelection(2);

    private int pages;

    public SunPageSelection(int value) {
        pages = value;
    }

    public Class<? extends Attribute> getCategory() {
        return SunPageSelection.class;
    }

    public String getName() {
        return "sun-page-selection";
    }

    public String toString() {
       return "page-selection: " + pages;
    }

}
