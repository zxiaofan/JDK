/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstat;

import java.util.*;
import sun.jvmstat.monitor.*;

/**
 * Class to compare two Monitor objects by name in descending order.
 *
 * @author Brian Doherty
 * @since 1.5
 */
class DescendingMonitorComparator implements Comparator<Monitor> {
    public int compare(Monitor o1, Monitor o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();
        return name2.compareTo(name1);
    }
}
