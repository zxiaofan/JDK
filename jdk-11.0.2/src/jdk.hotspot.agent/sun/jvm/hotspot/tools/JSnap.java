/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.tools;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import sun.jvm.hotspot.debugger.JVMDebugger;
import sun.jvm.hotspot.runtime.*;

public class JSnap extends Tool {

    private boolean all;

    public JSnap() {
        super();
    }

    public JSnap(JVMDebugger d) {
        super(d);
    }

    public void run() {
        final PrintStream out = System.out;
        if (PerfMemory.initialized()) {
            PerfDataPrologue prologue = PerfMemory.prologue();
            if (prologue.accessible()) {
                PerfMemory.iterate(new PerfMemory.PerfDataEntryVisitor() {
                        public boolean visit(PerfDataEntry pde) {
                            if (all || pde.supported()) {
                                out.print(pde.name());
                                out.print('=');
                                out.println(pde.valueAsString());
                            }
                            // goto next entry
                            return true;
                        }
                    });
            } else {
                out.println("PerfMemory is not accessible");
            }
        } else {
            out.println("PerfMemory is not initialized");
        }
    }

    @Override
    protected void printFlagsUsage() {
        System.out.println("    -a\tto print all performance counters");
        super.printFlagsUsage();
    }

    public static void main(String[] args) {
        JSnap js = new JSnap();
        js.all = Arrays.stream(args)
                       .anyMatch(s -> s.equals("-a"));

        if (js.all) {
            args = Arrays.stream(args)
                         .filter(s -> !s.equals("-a"))
                         .collect(Collectors.toList())
                         .toArray(new String[0]);
        }

        js.execute(args);
    }
}
