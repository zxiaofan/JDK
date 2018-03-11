/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package java.net;

import java.security.AccessController;
import java.security.PrivilegedExceptionAction;

class NetUtil {

    // Value of jdk.net.revealLocalAddress
    private static boolean revealLocalAddress;

    // True if jdk.net.revealLocalAddress had been read
    private static volatile boolean propRevealLocalAddr;

    /*
     * Returns true if security check on localAddress is disabled
     */
    static boolean doRevealLocalAddress() {
        return propRevealLocalAddr ? revealLocalAddress
                                     : readRevealLocalAddr();

    }

    private static boolean readRevealLocalAddr() {
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            try {
                revealLocalAddress = Boolean.parseBoolean(
                      AccessController.doPrivileged(
                          new PrivilegedExceptionAction<String>() {
                              @Override
                              public String run() {
                                  return System.getProperty(
                                      "jdk.net.revealLocalAddress");
                              }
                          }));

            } catch (Exception e) {
                //revealLocalAddress is false
            }
            propRevealLocalAddr = true;
        }
        /*
         * No security manager, or security check passed or
         * jdk.net.revealLocalAddress set to true
         */
        return revealLocalAddress;
    }

}
