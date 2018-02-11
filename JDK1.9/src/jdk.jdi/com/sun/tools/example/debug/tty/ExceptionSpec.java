/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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

/*
 * This source code is provided to illustrate the usage of a given feature
 * or technique and has been deliberately simplified. Additional steps
 * required for a production-quality application, such as security checks,
 * input validation and proper error handling, might not be present in
 * this sample code.
 */


package com.sun.tools.example.debug.tty;

import com.sun.jdi.ReferenceType;
import com.sun.jdi.request.*;

class ExceptionSpec extends EventRequestSpec {
    private boolean notifyCaught;
    private boolean notifyUncaught;

    private ExceptionSpec(ReferenceTypeSpec refSpec) {
        this(refSpec, true, true);
    }

    ExceptionSpec(ReferenceTypeSpec refSpec,
                  boolean notifyCaught,
                  boolean notifyUncaught) {
        super(refSpec);
        this.notifyCaught = notifyCaught;
        this.notifyUncaught = notifyUncaught;
    }

    /**
     * The 'refType' is known to match, return the EventRequest.
     */
    @Override
    EventRequest resolveEventRequest(ReferenceType refType) {
        EventRequestManager em = refType.virtualMachine().eventRequestManager();
        ExceptionRequest excReq = em.createExceptionRequest(refType,
                                                            notifyCaught,
                                                            notifyUncaught);
        excReq.enable();
        return excReq;
    }

    public boolean notifyCaught() {
        return notifyCaught;
    }

    public boolean notifyUncaught() {
        return notifyUncaught;
    }

    @Override
    public int hashCode() {
        //Reference: Effective Java[tm] (Bloch, 2001), Item 8
        int result = 17;
        result = (37 * result) + (notifyCaught() ? 0: 1);
        result = (37 * result) + (notifyUncaught() ? 0: 1);
        result = (37 * result) + refSpec.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ExceptionSpec) {
            ExceptionSpec es = (ExceptionSpec)obj;

            if (refSpec.equals(es.refSpec) &&
                (this.notifyCaught() == es.notifyCaught()) &&
                (this.notifyUncaught() == es.notifyUncaught())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        String s;
        if (notifyCaught && !notifyUncaught) {
            s = MessageOutput.format("exceptionSpec caught",
                                     refSpec.toString());
        } else if (notifyUncaught && !notifyCaught) {
            s = MessageOutput.format("exceptionSpec uncaught",
                                     refSpec.toString());
        } else {
            s = MessageOutput.format("exceptionSpec all",
                                     refSpec.toString());
        }
        return s;
    }
}
