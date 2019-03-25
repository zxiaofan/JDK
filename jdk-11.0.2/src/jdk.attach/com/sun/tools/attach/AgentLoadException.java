/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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

/**
 * The exception thrown when an agent cannot be loaded into the target
 * Java virtual machine.
 *
 * <p> This exception is thrown by {@link
 * com.sun.tools.attach.VirtualMachine#loadAgent VirtualMachine.loadAgent} or
 * {@link com.sun.tools.attach.VirtualMachine#loadAgentLibrary
 * VirtualMachine.loadAgentLibrary}, {@link
 * com.sun.tools.attach.VirtualMachine#loadAgentPath loadAgentPath} methods
 * if the agent, or agent library, cannot be loaded.
 */
public class AgentLoadException extends Exception {

    /** use serialVersionUID for interoperability */
    static final long serialVersionUID = 688047862952114238L;

    /**
     * Constructs an <code>AgentLoadException</code> with
     * no detail message.
     */
    public AgentLoadException() {
        super();
    }

    /**
     * Constructs an <code>AgentLoadException</code> with
     * the specified detail message.
     *
     * @param   s   the detail message.
     */
    public AgentLoadException(String s) {
        super(s);
    }

}
