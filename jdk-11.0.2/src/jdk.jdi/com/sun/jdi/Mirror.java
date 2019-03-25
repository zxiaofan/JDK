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

import com.sun.jdi.request.BreakpointRequest;

/**
 * A proxy used by a debugger to examine or manipulate some entity
 * in another virtual machine. Mirror is the root of the
 * interface hierarchy for this package. Mirrors can be proxies for objects
 * in the target VM ({@link ObjectReference}), primitive values
 * (for example, {@link IntegerValue}), types (for example,
 * {@link ReferenceType}), dynamic application state (for example,
 * {@link StackFrame}), and even debugger-specific constructs (for example,
 * {@link BreakpointRequest}).
 * The {@link VirtualMachine} itself is also considered a mirror,
 * representing the composite state of the target VM.
 * <P>
 * There is no guarantee that a particular entity in the target VM will map
 * to a single instance of Mirror. Implementors are free to decide
 * whether a single mirror will be used for some or all mirrors. Clients
 * of this interface should always use <code>equals</code> to compare
 * two mirrors for equality.
 * <p>
 * Any method on a {@link Mirror} that takes a <code>Mirror</code> as an
 * parameter directly or indirectly (e.g., as a element in a <code>List</code>) will
 * throw {@link VMMismatchException} if the mirrors are from different
 * virtual machines.
 *
 * @see VirtualMachine
 *
 * @author Robert Field
 * @author Gordon Hirsch
 * @author James McIlree
 * @since  1.3
 */
public interface Mirror {

    /**
     * Gets the VirtualMachine to which this
     * Mirror belongs. A Mirror must be associated
     * with a VirtualMachine to have any meaning.
     *
     * @return the {@link VirtualMachine} for which this mirror is a proxy.
     */
    VirtualMachine virtualMachine();

    /**
     * Returns a String describing this mirror
     *
     * @return a string describing this mirror.
     */
    String toString();
}
