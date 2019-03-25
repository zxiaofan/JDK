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
 * The exception thrown when an agent fails to initialize in the target
 * Java virtual machine.
 *
 * <p> This exception is thrown by
 * {@link com.sun.tools.attach.VirtualMachine#loadAgent VirtualMachine.loadAgent},
 * {@link com.sun.tools.attach.VirtualMachine#loadAgentLibrary
 * VirtualMachine.loadAgentLibrary},
 * {@link com.sun.tools.attach.VirtualMachine#loadAgentPath VirtualMachine.loadAgentPath}
 * methods if an agent, or agent library, cannot be initialized.
 * When thrown by {@code VirtualMachine.loadAgentLibrary}, or
 * {@code VirtualMachine.loadAgentPath} then the exception encapsulates
 * the error returned by the agent's {@code Agent_OnAttach} function.
 * This error code can be obtained by invoking the {@link #returnValue() returnValue} method.
 */
public class AgentInitializationException extends Exception {

    /** use serialVersionUID for interoperability */
    static final long serialVersionUID = -1508756333332806353L;

    private int returnValue;

    /**
     * Constructs an {@code AgentInitializationException} with
     * no detail message.
     */
    public AgentInitializationException() {
        super();
        this.returnValue = 0;
    }

    /**
     * Constructs an {@code AgentInitializationException} with
     * the specified detail message.
     *
     * @param   s   the detail message.
     */
    public AgentInitializationException(String s) {
        super(s);
        this.returnValue = 0;
    }

    /**
     * Constructs an {@code AgentInitializationException} with
     * the specified detail message and the return value from the
     * execution of the agent's {@code Agent_OnAttach} function.
     *
     * @param   s               the detail message.
     * @param   returnValue     the return value
     */
    public AgentInitializationException(String s, int returnValue) {
        super(s);
        this.returnValue = returnValue;
    }

    /**
     * If the exception was created with the return value from the agent
     * {@code Agent_OnAttach} function then this returns that value,
     * otherwise returns {@code 0}.
     *
     * @return  the return value
     */
    public int returnValue() {
        return returnValue;
    }

}
