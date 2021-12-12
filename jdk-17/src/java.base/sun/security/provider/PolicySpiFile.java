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

package sun.security.provider;

import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Policy;
import java.security.PolicySpi;
import java.security.ProtectionDomain;
import java.security.URIParameter;

import java.net.MalformedURLException;

/**
 * This class wraps the PolicyFile subclass implementation of Policy
 * inside a PolicySpi implementation that is available from the SUN provider
 * via the Policy.getInstance calls.
 *
 */
@SuppressWarnings("removal")
public final class PolicySpiFile extends PolicySpi {

    private PolicyFile pf;

    public PolicySpiFile(Policy.Parameters params) {

        if (params == null) {
            pf = new PolicyFile();
        } else {
            if (!(params instanceof URIParameter)) {
                throw new IllegalArgumentException
                        ("Unrecognized policy parameter: " + params);
            }
            URIParameter uriParam = (URIParameter)params;
            try {
                pf = new PolicyFile(uriParam.getURI().toURL());
            } catch (MalformedURLException mue) {
                throw new IllegalArgumentException("Invalid URIParameter", mue);
            }
        }
    }

    protected PermissionCollection engineGetPermissions(CodeSource codesource) {
        return pf.getPermissions(codesource);
    }

    protected PermissionCollection engineGetPermissions(ProtectionDomain d) {
        return pf.getPermissions(d);
    }

    protected boolean engineImplies(ProtectionDomain d, Permission p) {
        return pf.implies(d, p);
    }

    protected void engineRefresh() {
        pf.refresh();
    }
}
