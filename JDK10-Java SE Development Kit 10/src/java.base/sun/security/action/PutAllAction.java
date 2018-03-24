/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.action;

import java.util.Map;

import java.security.Provider;
import java.security.PrivilegedAction;

/**
 * A convenience PrivilegedAction class for setting the properties of
 * a provider. See the SunRsaSign provider for a usage example.
 *
 * @see sun.security.rsa.SunRsaSign
 * @author  Andreas Sterbenz
 * @since   1.5
 */
public class PutAllAction implements PrivilegedAction<Void> {

    private final Provider provider;
    private final Map<?, ?> map;

    public PutAllAction(Provider provider, Map<?, ?> map) {
        this.provider = provider;
        this.map = map;
    }

    public Void run() {
        provider.putAll(map);
        return null;
    }

}
