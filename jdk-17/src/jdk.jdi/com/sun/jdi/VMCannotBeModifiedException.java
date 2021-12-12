/*
 * Copyright (c) 2003, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jdi;

/**
 * Thrown to indicate that the operation is invalid because it would
 * modify the VM and the VM is read-only.  See {@link VirtualMachine#canBeModified()}.
 *
 * @author Jim Holmlund
 * @since  1.5
 */
public class VMCannotBeModifiedException extends UnsupportedOperationException {

    private static final long serialVersionUID = -4063879815130164009L;

    public VMCannotBeModifiedException() {
        super();
    }

    public VMCannotBeModifiedException(String s) {
        super(s);
    }
}
