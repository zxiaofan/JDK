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
import sun.jvm.hotspot.debugger.proc.*;

public class ProcAARCH64ThreadFactory implements ProcThreadFactory {
    private ProcDebugger debugger;

    public ProcAARCH64ThreadFactory(ProcDebugger debugger) {
        this.debugger = debugger;
    }

    public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
        return new ProcAARCH64Thread(debugger, threadIdentifierAddr);
    }

    public ThreadProxy createThreadWrapper(long id) {
        return new ProcAARCH64Thread(debugger, id);
    }
}
