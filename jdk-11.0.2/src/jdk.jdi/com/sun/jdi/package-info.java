/*
 * Copyright (c) 1998, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * This is the core package of the Java Debug
 * Interface (JDI), it defines mirrors for values, types, and the target
 * VirtualMachine itself - as well bootstrapping facilities.
 * {@link com.sun.jdi.VirtualMachine} mirrors the target virtual machine and
 * is the origin of all information provided by the JDI.  A VirtualMachine
 * is typically created by using the
 * {@link com.sun.jdi.VirtualMachineManager} to create
 * a connection to the target virtual machine (see the
 * {@link com.sun.jdi.connect} package).  In turn the
 * {@link com.sun.jdi.VirtualMachineManager} is typically created by calling
 * {@link com.sun.jdi.Bootstrap#virtualMachineManager()}.
 * <p>
 * Most of the methods within this package can throw the unchecked exception
 * {@link com.sun.jdi.VMDisconnectedException}.
 * <p>
 * Methods may be added to the interfaces in the JDI packages in future
 * releases. Existing packages may be renamed if the JDI becomes a standard
 * extension.
 */

package com.sun.jdi;
