/*
 * Copyright (c) 2002, 2013, Oracle and/or its affiliates. All rights reserved.
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

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.oops.*;
import sun.jvm.hotspot.runtime.*;

import java.io.PrintStream;

/** A sample tool which uses the Serviceability Agent's APIs to obtain
    an object histogram from a remote or crashed VM. */
public class ObjectHistogram extends Tool {

    public ObjectHistogram() {
        super();
    }

    public ObjectHistogram(JVMDebugger d) {
        super(d);
    }

    @Override
    public String getName() {
        return "objectHistogram";
    }

    public void run() {
        run(System.out, System.err);
    }

    public void run(PrintStream out, PrintStream err) {
        // Ready to go with the database...
        ObjectHeap heap = VM.getVM().getObjectHeap();
        sun.jvm.hotspot.oops.ObjectHistogram histogram =
        new sun.jvm.hotspot.oops.ObjectHistogram();
        err.println("Iterating over heap. This may take a while...");
        long startTime = System.currentTimeMillis();
        heap.iterate(histogram);
        long endTime = System.currentTimeMillis();
        histogram.printOn(out);
        float secs = (float) (endTime - startTime) / 1000.0f;
        err.println("Heap traversal took " + secs + " seconds.");
    }

    public static void main(String[] args) {
        ObjectHistogram oh = new ObjectHistogram();
        oh.execute(args);
    }
}
