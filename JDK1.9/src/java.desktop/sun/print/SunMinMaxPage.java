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

import javax.print.attribute.PrintRequestAttribute;
import javax.print.attribute.PrintRequestAttribute;

/*
 * A class used to determine minimum and maximum pages.
 */
@SuppressWarnings("serial") // JDK-implementation class
public final class SunMinMaxPage implements PrintRequestAttribute {
    private int page_max, page_min;

    public SunMinMaxPage(int min, int max) {
       page_min = min;
       page_max = max;
    }

    public Class<? extends PrintRequestAttribute> getCategory() {
        return SunMinMaxPage.class;
    }

    public int getMin() {
        return page_min;
    }

    public int getMax() {
        return page_max;
    }

    public String getName() {
        return "sun-page-minmax";
    }
}
