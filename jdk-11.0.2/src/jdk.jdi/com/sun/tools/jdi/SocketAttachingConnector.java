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
package com.sun.tools.jdi;

import java.io.IOException;
import java.util.Map;

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.connect.Transport;

/*
 * An AttachingConnector that uses the SocketTransportService
 */
public class SocketAttachingConnector extends GenericAttachingConnector {

    static final String ARG_PORT = "port";
    static final String ARG_HOST = "hostname";

    public SocketAttachingConnector() {
        super(new SocketTransportService());

        String defaultHostName = "localhost";

        addStringArgument(
            ARG_HOST,
            getString("socket_attaching.host.label"),
            getString("socket_attaching.host"),
            defaultHostName,
            false);

        addIntegerArgument(
            ARG_PORT,
            getString("socket_attaching.port.label"),
            getString("socket_attaching.port"),
            "",
            true,
            0, Integer.MAX_VALUE);

        transport = new Transport() {
            public String name() {
                return "dt_socket";     // for compatibility reasons
            }
        };
    }

    /*
     * Create an "address" from the hostname and port connector
     * arguments and attach to the target VM.
     */
    public VirtualMachine
        attach(Map<String, ? extends Connector.Argument> arguments)
        throws IOException, IllegalConnectorArgumentsException
    {
        String host = argument(ARG_HOST, arguments).value();
        if (host.length() > 0) {
            host = host + ":";
        }
        String address = host + argument(ARG_PORT, arguments).value();
        return super.attach(address, arguments);
    }

    public String name() {
       return "com.sun.jdi.SocketAttach";
    }

    public String description() {
       return getString("socket_attaching.description");
    }
}
