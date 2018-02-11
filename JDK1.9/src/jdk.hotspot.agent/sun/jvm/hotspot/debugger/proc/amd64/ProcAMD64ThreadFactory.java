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
 */

package sun.jvm.hotspot.debugger.proc.amd64;

import sun.jvm.hotspot.debugger.*;
import sun.jvm.hotspot.debugger.proc.*;

public class ProcAMD64ThreadFactory implements ProcThreadFactory {
    private ProcDebugger debugger;

    public ProcAMD64ThreadFactory(ProcDebugger debugger) {
        this.debugger = debugger;
    }

    public ThreadProxy createThreadWrapper(Address threadIdentifierAddr) {
        return new ProcAMD64Thread(debugger, threadIdentifierAddr);
    }

    public ThreadProxy createThreadWrapper(long id) {
        return new ProcAMD64Thread(debugger, id);
    }
}
