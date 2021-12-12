/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.event.EventQueue;
import com.sun.jdi.event.VMDisconnectEvent;

/**
 * A module in the target VM.
 * <p>
 * Any method on {@code ModuleReference} which directly or indirectly takes
 * {@code ModuleReference} as a parameter may throw {@link VMDisconnectedException}
 * if the target VM is disconnected and the {@link VMDisconnectEvent} has been or is
 * available to be read from the {@link EventQueue}.
 * <p>
 * Any method on {@code ModuleReference} which directly or indirectly takes
 * {@code ModuleReference} as a parameter may throw {@link VMOutOfMemoryException}
 * if the target VM has run out of memory.
 * <p>
 * Any method on {@code ModuleReference} or which directly or indirectly takes
 * {@code ModuleReference} as a parameter may throw {@link InvalidModuleException}
 * if the mirrored module has been unloaded.
 *
 * Not all target virtual machines support this class.
 * Use {@link VirtualMachine#canGetModuleInfo()}
 * to determine if the class is supported.
 *
 * @since  9
 */
public interface ModuleReference extends ObjectReference {

    /**
     * Returns the module name.
     * This method returns {@code null}
     * if this module is an unnamed module.
     *
     * @return the name of this module.
     */
    String name();

    /**
     * Returns the {@link ClassLoaderReference} object for this module.
     *
     * @return the {@link ClassLoaderReference} object for this module.
     */
    ClassLoaderReference classLoader();
}
