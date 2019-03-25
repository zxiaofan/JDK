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

package com.sun.jdi;

import com.sun.jdi.connect.Connector;
import com.sun.tools.jdi.VirtualMachineManagerImpl;

/**
 * Initial class that provides access to the default implementation
 * of JDI interfaces. A debugger application uses this class to access the
 * single instance of the {@link VirtualMachineManager} interface.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */

public class Bootstrap extends Object {

    /**
     * Returns the virtual machine manager.
     *
     * <p> May throw an unspecified error if initialization of the
     * {@link VirtualMachineManager} fails or if the virtual machine manager
     * is unable to locate or create any {@link Connector Connectors}.
     *
     * @throws java.lang.SecurityException if a security manager has been
     * installed and it denies {@link JDIPermission}
     * ("{@code virtualMachineManager}") or other unspecified
     * permissions required by the implementation.
     */
    static public synchronized VirtualMachineManager virtualMachineManager() {
        return VirtualMachineManagerImpl.virtualMachineManager();
    }
}
