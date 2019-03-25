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

package com.sun.jdi.connect;

import java.io.IOException;
import java.util.Map;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.event.VMStartEvent;

/**
 * A connector which can launch a target VM before connecting to it.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public interface LaunchingConnector extends Connector {

    /**
     * Launches an application and connects to its VM. Properties
     * of the launch (possibly including options,
     * main class, and arguments) are specified in
     * <code>arguments</code>.
     * The argument map associates argument name strings to instances
     * of {@link Connector.Argument}. The default argument map for a
     * connector can be obtained through {@link Connector#defaultArguments}.
     * Argument map values can be changed, but map entries should not be
     * added or deleted.
     * <p>A target VM launched by a launching connector is not
     * guaranteed to be stable until after the {@link VMStartEvent} has been
     * received.
     * <p>
     * <b>Important note:</b> If a target VM is launched through this
     * funcctions, its output and error streams must be read as it
     * executes. These streams are available through the
     * {@link java.lang.Process Process} object returned by
     * {@link VirtualMachine#process}. If the streams are not periodically
     * read, the target VM will stop executing when the buffers for these
     * streams are filled.
     *
     * @param arguments the argument map to be used in launching the VM.
     * @return the {@link VirtualMachine} mirror of the target VM.
     * @throws java.io.IOException when unable to launch.
     * Specific exceptions are dependent on the Connector implementation
     * in use.
     * @throws IllegalConnectorArgumentsException when one of the
     * connector arguments is invalid.
     * @throws VMStartException when the VM was successfully launched, but
     * terminated with an error before a connection could be established.
     */
    VirtualMachine launch(Map<String,? extends Connector.Argument> arguments)
        throws IOException, IllegalConnectorArgumentsException,
               VMStartException;
}
