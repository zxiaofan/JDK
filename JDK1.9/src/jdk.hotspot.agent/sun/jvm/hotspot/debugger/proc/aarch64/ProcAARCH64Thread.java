/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2015, Red Hat Inc.
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

package sun.jvm.hotspot.debugger.proc.aarch64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.aarch64.*;
import sun.jvm.hotspot.debugger.proc.*;
import sun.jvm.hotspot.utilities.*;

public class ProcAARCH64Thread implements ThreadProxy {
    private ProcDebugger debugger;
    private int         id;

    public ProcAARCH64Thread(ProcDebugger debugger, Address addr) {
        this.debugger = debugger;

        // FIXME: the size here should be configurable. However, making it
        // so would produce a dependency on the "types" package from the
        // debugger package, which is not desired.
        this.id       = (int) addr.getCIntegerAt(0, 4, true);
    }

    public ProcAARCH64Thread(ProcDebugger debugger, long id) {
        this.debugger = debugger;
        this.id = (int) id;
    }

    public ThreadContext getContext() throws IllegalThreadStateException {
        ProcAARCH64ThreadContext context = new ProcAARCH64ThreadContext(debugger);
        long[] regs = debugger.getThreadIntegerRegisterSet(id);
        if (Assert.ASSERTS_ENABLED) {
            Assert.that(regs.length == AARCH64ThreadContext.NPRGREG, "size mismatch");
        }
        for (int i = 0; i < regs.length; i++) {
            context.setRegister(i, regs[i]);
        }
        return context;
    }

    public boolean canSetContext() throws DebuggerException {
        return false;
    }

    public void setContext(ThreadContext context)
    throws IllegalThreadStateException, DebuggerException {
        throw new DebuggerException("Unimplemented");
    }

    public String toString() {
        return "t@" + id;
    }

    public boolean equals(Object obj) {
        if ((obj == null) || !(obj instanceof ProcAARCH64Thread)) {
            return false;
        }

        return (((ProcAARCH64Thread) obj).id == id);
    }

    public int hashCode() {
        return id;
    }
}
