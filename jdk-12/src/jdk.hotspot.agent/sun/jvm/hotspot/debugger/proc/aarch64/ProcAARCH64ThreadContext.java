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

public class ProcAARCH64ThreadContext extends AARCH64ThreadContext {
    private ProcDebugger debugger;

    public ProcAARCH64ThreadContext(ProcDebugger debugger) {
        super();
        this.debugger = debugger;
    }

    public void setRegisterAsAddress(int index, Address value) {
        setRegister(index, debugger.getAddressValue(value));
    }

    public Address getRegisterAsAddress(int index) {
        return debugger.newAddress(getRegister(index));
    }
}
