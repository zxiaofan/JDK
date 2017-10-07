/*
 * Copyright (c) 2003, 2016, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.rsa;

import java.util.*;

import java.security.*;

import sun.security.action.PutAllAction;
import static sun.security.util.SecurityConstants.PROVIDER_VER;

/**
 * Provider class for the RSA signature provider. Supports RSA keyfactory,
 * keypair generation, and RSA signatures.
 *
 * @since   1.5
 * @author  Andreas Sterbenz
 */
public final class SunRsaSign extends Provider {

    private static final long serialVersionUID = 866040293550393045L;

    public SunRsaSign() {
        super("SunRsaSign", PROVIDER_VER, "Sun RSA signature provider");

        // if there is no security manager installed, put directly into
        // the provider. Otherwise, create a temporary map and use a
        // doPrivileged() call at the end to transfer the contents
        if (System.getSecurityManager() == null) {
            SunRsaSignEntries.putEntries(this);
        } else {
            // use LinkedHashMap to preserve the order of the PRNGs
            Map<Object, Object> map = new HashMap<>();
            SunRsaSignEntries.putEntries(map);
            AccessController.doPrivileged(new PutAllAction(this, map));
        }
    }

}
