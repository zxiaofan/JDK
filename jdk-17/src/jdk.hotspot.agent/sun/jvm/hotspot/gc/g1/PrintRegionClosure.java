/*
 * Copyright (c) 2018, 2019, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.gc.g1;

import java.io.PrintStream;
import sun.jvm.hotspot.gc.g1.HeapRegion;

public class PrintRegionClosure implements HeapRegionClosure {
    private PrintStream tty;

    public PrintRegionClosure(PrintStream tty) {
        this.tty = tty;
    }

    public void doHeapRegion(HeapRegion hr) {
        hr.printOn(tty);
    }
}
