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

abstract class WatchpointSpec extends EventRequestSpec {
    final String fieldId;

    WatchpointSpec(ReferenceTypeSpec refSpec, String fieldId)
                                       throws MalformedMemberNameException {
        super(refSpec);
        this.fieldId = fieldId;
        if (!isJavaIdentifier(fieldId)) {
            throw new MalformedMemberNameException(fieldId);
        }
    }

    @Override
    public int hashCode() {
        return refSpec.hashCode() + fieldId.hashCode() +
            getClass().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof WatchpointSpec) {
            WatchpointSpec watchpoint = (WatchpointSpec)obj;

            return fieldId.equals(watchpoint.fieldId) &&
                   refSpec.equals(watchpoint.refSpec) &&
                   getClass().equals(watchpoint.getClass());
        } else {
            return false;
        }
    }

    @Override
    String errorMessageFor(Exception e) {
        if (e instanceof NoSuchFieldException) {
            return (MessageOutput.format("No field in",
                                         new Object [] {fieldId, refSpec.toString()}));
        } else {
            return super.errorMessageFor(e);
        }
    }
}
