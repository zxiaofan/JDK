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
package com.sun.tools.jdi;

import com.sun.jdi.connect.*;
import com.sun.jdi.connect.spi.*;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

/*
 * An ListeningConnector that uses the SocketTransportService
 */
public class SocketListeningConnector extends GenericListeningConnector {

    static final String ARG_PORT = "port";
    static final String ARG_LOCALADDR = "localAddress";

    public SocketListeningConnector() {
        super(new SocketTransportService());

        addIntegerArgument(
            ARG_PORT,
            getString("socket_listening.port.label"),
            getString("socket_listening.port"),
            "",
            false,
            0, Integer.MAX_VALUE);

        addStringArgument(
            ARG_LOCALADDR,
            getString("socket_listening.localaddr.label"),
            getString("socket_listening.localaddr"),
            "",                                         // default is wildcard
            false);

        transport = new Transport() {
            public String name() {
                return "dt_socket";     // for compatibility reasons
            }
        };
    }


    public String
        startListening(Map<String,? extends Connector.Argument> args)
        throws IOException, IllegalConnectorArgumentsException
    {
        String port = argument(ARG_PORT, args).value();
        String localaddr = argument(ARG_LOCALADDR, args).value();

        // default to system chosen port
        if (port.length() == 0) {
            port = "0";
        }

        if (localaddr.length() > 0) {
           localaddr = localaddr + ":" + port;
        } else {
           localaddr = port;
        }

        return super.startListening(localaddr, args);
    }

    public String name() {
        return "com.sun.jdi.SocketListen";
    }

    public String description() {
        return getString("socket_listening.description");
    }
}
