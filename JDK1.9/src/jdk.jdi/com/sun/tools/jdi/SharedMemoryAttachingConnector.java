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

import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.*;
import com.sun.jdi.connect.spi.*;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;

/*
 * An AttachingConnector that uses the SharedMemoryTransportService
 */
public class SharedMemoryAttachingConnector extends GenericAttachingConnector {

    static final String ARG_NAME = "name";

    public SharedMemoryAttachingConnector() {
        super(new SharedMemoryTransportService());

        addStringArgument(
            ARG_NAME,
            getString("memory_attaching.name.label"),
            getString("memory_attaching.name"),
            "",
            true);

        transport = new Transport() {
            public String name() {
                return "dt_shmem";              // for compatibility reasons
            }
        };
    }

    public VirtualMachine
        attach(Map<String, ? extends Connector.Argument> arguments)
        throws IOException, IllegalConnectorArgumentsException
    {
        String name = argument(ARG_NAME, arguments).value();
        return super.attach(name, arguments);
    }

    public String name() {
        return "com.sun.jdi.SharedMemoryAttach";
    }

    public String description() {
       return getString("memory_attaching.description");
    }
}
