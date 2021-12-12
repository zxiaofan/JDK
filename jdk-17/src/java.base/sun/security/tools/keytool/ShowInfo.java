/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.tools.keytool;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;

class ShowInfo {

    // verbose is not used yet.
    static void tls(boolean verbose) throws Exception {

        SSLSocket ssls = (SSLSocket)
                SSLContext.getDefault().getSocketFactory().createSocket();

        System.out.println("Enabled Protocols");
        System.out.println("-----------------");
        for (String s : ssls.getEnabledProtocols()) {
            System.out.println(s);
        }

        System.out.println();

        System.out.println("Enabled Cipher Suites");
        System.out.println("---------------------");
        for (String s : ssls.getEnabledCipherSuites()) {
            System.out.println(s);
        }
    }
}
