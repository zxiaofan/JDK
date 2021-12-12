/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.jgss.wrapper;

import org.ietf.jgss.*;
import javax.security.auth.kerberos.ServicePermission;

/**
 * This class is an utility class for Kerberos related stuff.
 * @author Valerie Peng
 * @since 1.6
 */
class Krb5Util {

    // Return the Kerberos TGS principal name using the domain
    // of the specified <code>name</code>
    static String getTGSName(GSSNameElement name)
        throws GSSException {
        String krbPrinc = name.getKrbName();
        int atIndex = krbPrinc.indexOf('@');
        String realm = krbPrinc.substring(atIndex + 1);
        StringBuilder sb = new StringBuilder("krbtgt/");
        sb.append(realm).append('@').append(realm);
        return sb.toString();
    }

    // Perform the Service Permission check using the specified
    // <code>target</code> and <code>action</code>
    static void checkServicePermission(String target, String action) {
        @SuppressWarnings("removal")
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            SunNativeProvider.debug("Checking ServicePermission(" +
                                    target + ", " + action + ")");
            ServicePermission perm =
                new ServicePermission(target, action);
            sm.checkPermission(perm);
        }
    }
}
