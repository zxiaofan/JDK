/*
 * Copyright (c) 2005, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Properties;

import com.sun.jdi.Bootstrap;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.connect.AttachingConnector;
import com.sun.jdi.connect.Connector;
import com.sun.jdi.connect.IllegalConnectorArgumentsException;
import com.sun.jdi.connect.Transport;
import com.sun.jdi.connect.spi.Connection;
import com.sun.jdi.connect.spi.TransportService;

/*
 * An AttachingConnector that connects to a debuggee by specifying the process
 * id (pid) as the connector argument. If the process is a debuggee listening
 * on a transport address then this connector reads the transport address
 * and attempts to attach to it using the appropriate transport.
 */

public class ProcessAttachingConnector
        extends ConnectorImpl implements AttachingConnector
{
    /*
     * The arguments that this connector supports
     */
    static final String ARG_PID = "pid";
    static final String ARG_TIMEOUT = "timeout";

    com.sun.tools.attach.VirtualMachine vm;
    Transport transport;

    public ProcessAttachingConnector() {
        addStringArgument(
            ARG_PID,
            getString("process_attaching.pid.label"),
            getString("process_attaching.pid"),
            "",
            true);

        addIntegerArgument(
            ARG_TIMEOUT,
            getString("generic_attaching.timeout.label"),       // use generic keys to keep
            getString("generic_attaching.timeout"),             // resource bundle small
            "",
            false,
            0, Integer.MAX_VALUE);

        transport = new Transport() {
            public String name() {
                return "local";
            }
        };
    }

    /**
     * Attach to a target VM using the specified address and Connector arguments.
     */
    public VirtualMachine attach(Map<String,? extends Connector.Argument> args)
                throws IOException, IllegalConnectorArgumentsException
    {
        String pid = argument(ARG_PID, args).value();
        String t = argument(ARG_TIMEOUT, args).value();
        int timeout = 0;
        if (t.length() > 0) {
            timeout = Integer.decode(t).intValue();
        }

        // Use Attach API to attach to target VM and read value of
        // sun.jdwp.listenAddress property.

        String address = null;
        com.sun.tools.attach.VirtualMachine vm = null;
        try {
            vm = com.sun.tools.attach.VirtualMachine.attach(pid);
            Properties props = vm.getAgentProperties();
            address = props.getProperty("sun.jdwp.listenerAddress");
        } catch (Exception x) {
            throw new IOException(x.getMessage());
        } finally {
            if (vm != null) vm.detach();
        }

        // check that the property value is formatted correctly

        if (address == null) {
            throw new IOException("Not a debuggee, or not listening for debugger to attach");
        }
        int pos = address.indexOf(':');
        if (pos < 1) {
            throw new IOException("Unable to determine transport endpoint");
        }

        // parse into transport library name and address

        final String lib = address.substring(0, pos);
        address = address.substring(pos+1, address.length());

        TransportService ts = null;
        if (lib.equals("dt_socket")) {
            ts = new SocketTransportService();
        } else {
            if (lib.equals("dt_shmem")) {
                try {
                    Class<?> c = Class.forName("com.sun.tools.jdi.SharedMemoryTransportService");
                    @SuppressWarnings("deprecation")
                    Object tmp = c.newInstance();
                    ts = (TransportService)tmp;
                } catch (Exception x) { }
            }
        }
        if (ts == null) {
            throw new IOException("Transport " + lib + " not recognized");
        }

        // connect to the debuggee

        Connection connection = ts.attach(address, timeout, 0);
        return Bootstrap.virtualMachineManager().createVirtualMachine(connection);
    }

    public String name() {
        return "com.sun.jdi.ProcessAttach";
    }

    public String description() {
        return getString("process_attaching.description");
    }

    public Transport transport() {
        if (transport == null) {
            return new Transport() {
                public String name() {
                    return "local";
                }
            };
        }
        return transport;
    }
}
