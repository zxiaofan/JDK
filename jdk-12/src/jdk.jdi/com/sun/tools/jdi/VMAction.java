/*
 * Copyright (c) 1999, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import java.util.EventObject;

import com.sun.jdi.ThreadReference;
import com.sun.jdi.VirtualMachine;

/*
 * The name "action" is used to avoid confusion
 * with JDI events.
 */
class VMAction extends EventObject {

    private static final long serialVersionUID = -1701944679310296090L;

    // Event ids
    static final int VM_SUSPENDED = 1;
    static final int VM_NOT_SUSPENDED = 2;

    int id;
    ThreadReference resumingThread;

    VMAction(VirtualMachine vm, int id) {
        this(vm, null, id);
    }

    // For id = VM_NOT_SUSPENDED, if resumingThread != null, then it is
    // the only thread that is being resumed.
     VMAction(VirtualMachine vm, ThreadReference resumingThread, int id) {
        super(vm);
        this.id = id;
        this.resumingThread = resumingThread;
    }

    VirtualMachine vm() {
        return (VirtualMachine)getSource();
    }

    int id() {
        return id;
    }

    ThreadReference resumingThread() {
        return resumingThread;
    }
}
