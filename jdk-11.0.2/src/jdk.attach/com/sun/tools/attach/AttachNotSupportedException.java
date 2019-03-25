/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.attach;

import com.sun.tools.attach.spi.AttachProvider;         // for javadoc

/**
 * Thrown by {@link com.sun.tools.attach.VirtualMachine#attach
 * VirtualMachine.attach} when attempting to attach to a Java virtual machine
 * for which a compatible {@link com.sun.tools.attach.spi.AttachProvider
 * AttachProvider} does not exist. It is also thrown by {@link
 * com.sun.tools.attach.spi.AttachProvider#attachVirtualMachine
 * AttachProvider.attachVirtualMachine} if the provider attempts to
 * attach to a Java virtual machine with which it not comptatible.
 */
public class AttachNotSupportedException extends Exception {

    /** use serialVersionUID for interoperability */
    static final long serialVersionUID = 3391824968260177264L;

    /**
     * Constructs an <code>AttachNotSupportedException</code> with
     * no detail message.
     */
    public AttachNotSupportedException() {
        super();

    }

    /**
     * Constructs an <code>AttachNotSupportedException</code> with
     * the specified detail message.
     *
     * @param   s   the detail message.
     */
    public AttachNotSupportedException(String s) {
        super(s);
    }

}
