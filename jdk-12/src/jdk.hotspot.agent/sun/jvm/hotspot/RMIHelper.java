/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot;

import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import sun.jvm.hotspot.debugger.DebuggerException;

public class RMIHelper {
    private static final boolean startRegistry;
    private static int port;
    private static String serverNamePrefix;

    static {
        String tmp = System.getProperty("sun.jvm.hotspot.rmi.startRegistry");
        if (tmp != null && tmp.equals("false")) {
            startRegistry = false;
        } else {
            // by default, we attempt to start rmiregistry
            startRegistry = true;
        }

        port = Registry.REGISTRY_PORT;
        tmp = System.getProperty("sun.jvm.hotspot.rmi.port");
        if (tmp != null) {
            try {
                port = Integer.parseInt(tmp);
            } catch (NumberFormatException nfe) {
                System.err.println("invalid port supplied, assuming default");
            }
        }

        tmp = System.getProperty("sun.jvm.hotspot.rmi.serverNamePrefix");
        serverNamePrefix = (tmp != null)? serverNamePrefix : "SARemoteDebugger";
    }

    public static void rebind(String uniqueID, Remote object) throws DebuggerException {
        String name = getName(uniqueID);
        try {
            Naming.rebind(name, object);
        } catch (RemoteException re) {
            if (startRegistry) {
                // may be the user didn't start rmiregistry, try to start it
                try {
                    LocateRegistry.createRegistry(port);
                    Naming.rebind(name, object);
                } catch (Exception exp) {
                    throw new DebuggerException(exp);
                }
            } else {
                throw new DebuggerException(re);
            }
        } catch (Exception exp) {
            throw new DebuggerException(exp);
        }
    }

    public static void unbind(String uniqueID) throws DebuggerException {
        String name = getName(uniqueID);
        try {
            Naming.unbind(name);
        } catch (Exception exp) {
            throw new DebuggerException(exp);
        }
    }

    public static Remote lookup(String debugServerID) throws DebuggerException {
        // debugServerID follows the pattern [unique_id@]host[:port]
        // we have to transform this as //host[:port]/<serverNamePrefix>['_'<unique_id>]

        int index = debugServerID.indexOf('@');
        StringBuffer nameBuf = new StringBuffer("//");
        String uniqueID = null;
        if (index != -1) {
            nameBuf.append(debugServerID.substring(index + 1));
            uniqueID = debugServerID.substring(0, index);
        } else {
            nameBuf.append(debugServerID);
        }

        nameBuf.append('/');
        nameBuf.append(serverNamePrefix);
        if (uniqueID != null) {
            nameBuf.append('_');
            nameBuf.append(uniqueID);
        }

        try {
            return Naming.lookup(nameBuf.toString());
        } catch (Exception exp) {
            throw new DebuggerException(exp);
        }
    }

    private static String getName(String uniqueID) {
        String name = null;
        if (uniqueID != null) {
           name = serverNamePrefix + "_" + uniqueID;
        } else {
           name = serverNamePrefix;
        }
        if (port != Registry.REGISTRY_PORT) {
           name = "//localhost:" + port + "/" + name;
        }
        return name;
    }
}
