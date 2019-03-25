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

/**
 * A connector which attaches to a previously running target VM.
 *
 * @author Gordon Hirsch
 * @since  1.3
 */
public interface AttachingConnector extends Connector {

    /**
     * Attaches to a running application and returns a
     * mirror of its VM.
     * <p>
     * The connector uses the given argument map in
     * attaching the application. These arguments will include addressing
     * information that identifies the VM.
     * The argument map associates argument name strings to instances
     * of {@link Connector.Argument}. The default argument map for a
     * connector can be obtained through {@link Connector#defaultArguments}.
     * Argument map values can be changed, but map entries should not be
     * added or deleted.
     *
     * @param arguments the argument map to be used in launching the VM.
     * @return the {@link VirtualMachine} mirror of the target VM.
     *
     * @throws TransportTimeoutException when the Connector encapsulates
     * a transport that supports a timeout when attaching, a
     * {@link Connector.Argument} representing a timeout has been set
     * in the argument map, and a timeout occurs when trying to attach
     * to the target VM.
     *
     * @throws java.io.IOException when unable to attach.
     * Specific exceptions are dependent on the Connector implementation
     * in use.
     * @throws IllegalConnectorArgumentsException when one of the
     * connector arguments is invalid.
     */
    VirtualMachine attach(Map<String,? extends Connector.Argument> arguments)
        throws IOException, IllegalConnectorArgumentsException;
}
