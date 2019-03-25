/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.ClassNotPreparedException;
import com.sun.jdi.InconsistentDebugInfoException;
import com.sun.jdi.InternalException;
import com.sun.jdi.InvalidModuleException;
import com.sun.jdi.InvalidStackFrameException;
import com.sun.jdi.ObjectCollectedException;
import com.sun.jdi.VMDisconnectedException;
import com.sun.jdi.VMOutOfMemoryException;

class JDWPException extends Exception {

    private static final long serialVersionUID = -6321344442751299874L;

    short errorCode;

    JDWPException(short errorCode) {
        super();
        this.errorCode = errorCode;
    }

    short errorCode() {
        return errorCode;
    }

    RuntimeException toJDIException() {
        switch (errorCode) {
            case JDWP.Error.INVALID_OBJECT:
                return new ObjectCollectedException();
            case JDWP.Error.INVALID_MODULE:
                return new InvalidModuleException();
            case JDWP.Error.VM_DEAD:
                return new VMDisconnectedException();
            case JDWP.Error.OUT_OF_MEMORY:
                return new VMOutOfMemoryException();
            case JDWP.Error.CLASS_NOT_PREPARED:
                return new ClassNotPreparedException();
            case JDWP.Error.INVALID_FRAMEID:
            case JDWP.Error.NOT_CURRENT_FRAME:
                return new InvalidStackFrameException();
            case JDWP.Error.NOT_IMPLEMENTED:
                return new UnsupportedOperationException();
            case JDWP.Error.INVALID_INDEX:
            case JDWP.Error.INVALID_LENGTH:
                return new IndexOutOfBoundsException();
            case JDWP.Error.TYPE_MISMATCH:
                return new InconsistentDebugInfoException();
            case JDWP.Error.INVALID_THREAD:
                return new IllegalThreadStateException();
            default:
                return new InternalException("Unexpected JDWP Error: " + errorCode, errorCode);
        }
    }
}
