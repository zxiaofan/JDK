/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.util;

import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.InetSocketAddress;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;

public final class SocketExceptions {
    private SocketExceptions() {}

    /**
     * Security or system property which specifies categories of
     * (potentially sensitive) information that may be included
     * in exception text. This class only defines one category:
     * "hostInfo" which represents the hostname and port number
     * of the remote peer relating to a socket exception.
     * The property value is a comma separated list of
     * case insignificant category names.
     */
    private static final String enhancedTextPropname = "jdk.includeInExceptions";

    private static final boolean enhancedExceptionText = initTextProp();

    private static boolean initTextProp() {
        return AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
            public Boolean run() {
                String val = System.getProperty(enhancedTextPropname);
                if (val == null) {
                    val = Security.getProperty(enhancedTextPropname);
                    if (val == null)
                        return false;
                }
                String[] tokens = val.split(",");
                for (String token : tokens) {
                    if (token.equalsIgnoreCase("hostinfo"))
                        return true;
                }
                return false;
            }
        });
    }


    /**
     * Utility which takes an exception and returns either the same exception
     * or a new exception of the same type with the same stack trace
     * and detail message enhanced with addressing information from the
     * given InetSocketAddress.
     *
     * If the system/security property "jdk.net.enhanceExceptionText" is not
     * set or is false, then the original exception is returned.
     *
     * Only specific IOException subtypes are supported.
     */
    public static IOException of(IOException e, InetSocketAddress address) {
        if (!enhancedExceptionText || address == null)
            return e;
        int port = address.getPort();
        String host = address.getHostString();
        StringBuilder sb = new StringBuilder();
        sb.append(e.getMessage());
        sb.append(": ");
        sb.append(host);
        sb.append(':');
        sb.append(Integer.toString(port));
        String enhancedMsg = sb.toString();
        return create(e, enhancedMsg);
    }

    // return a new instance of the same type with the given detail
    // msg, or if the type doesn't support detail msgs, return given
    // instance.

    private static IOException create(IOException e, String msg) {
        return AccessController.doPrivileged(new PrivilegedAction<IOException>() {
            public IOException run() {
                try {
                    Class<?> clazz = e.getClass();
                    Constructor<?> ctor = clazz.getConstructor(String.class);
                    IOException e1 = (IOException)(ctor.newInstance(msg));
                    e1.setStackTrace(e.getStackTrace());
                    return e1;
                } catch (Exception e0) {
                    // Some eg AsynchronousCloseException have no detail msg
                    return e;
                }
            }
        });
    }
}
