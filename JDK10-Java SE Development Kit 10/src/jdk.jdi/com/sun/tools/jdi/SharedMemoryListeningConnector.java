/*
 * Copyright (c) 1999, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * A ListeningConnector based on the SharedMemoryTransportService
 */
public class SharedMemoryListeningConnector extends GenericListeningConnector {

    static final String ARG_NAME = "name";

    public SharedMemoryListeningConnector() {
        super(new SharedMemoryTransportService());

        addStringArgument(
            ARG_NAME,
            getString("memory_listening.name.label"),
            getString("memory_listening.name"),
            "",
            false);

        transport = new Transport() {
            public String name() {
                return "dt_shmem";              // compatibility
            }
        };
    }

    // override startListening so that "name" argument can be
    // converted into "address" argument

    public String
        startListening(Map<String, ? extends Connector.Argument> args)
        throws IOException, IllegalConnectorArgumentsException
    {
        String name = argument(ARG_NAME, args).value();

        // if the name argument isn't specified then we use the default
        // address for the transport service.
        if (name.length() == 0) {
            assert transportService instanceof SharedMemoryTransportService;
            SharedMemoryTransportService ts = (SharedMemoryTransportService)transportService;
            name = ts.defaultAddress();
        }

        return super.startListening(name, args);
    }

    public String name() {
        return "com.sun.jdi.SharedMemoryListen";
    }

    public String description() {
       return getString("memory_listening.description");
    }
}
