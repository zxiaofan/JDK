/*
 * Copyright (c) 2005, 2013, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.jgss.spnego;

import org.ietf.jgss.*;
import java.security.Provider;
import sun.security.jgss.GSSUtil;
import sun.security.jgss.spi.GSSNameSpi;
import sun.security.jgss.spi.GSSCredentialSpi;

/**
 * This class is the cred element implementation for SPNEGO mech.
 * NOTE: The current implementation can only support one mechanism.
 * This should be changed once multi-mechanism support is needed.
 *
 * @author Valerie Peng
 * @since 1.6
 */
public class SpNegoCredElement implements GSSCredentialSpi {

    private GSSCredentialSpi cred = null;

    public SpNegoCredElement(GSSCredentialSpi cred) throws GSSException {
        this.cred = cred;
    }

    Oid getInternalMech() {
        return cred.getMechanism();
    }

    // Used by GSSUtil.populateCredentials()
    public GSSCredentialSpi getInternalCred() {
        return cred;
    }

    public Provider getProvider() {
        return SpNegoMechFactory.PROVIDER;
    }

    public void dispose() throws GSSException {
        cred.dispose();
    }

    public GSSNameSpi getName() throws GSSException {
        return cred.getName();
    }

    public int getInitLifetime() throws GSSException {
        return cred.getInitLifetime();
    }

    public int getAcceptLifetime() throws GSSException {
        return cred.getAcceptLifetime();
    }

    public boolean isInitiatorCredential() throws GSSException {
        return cred.isInitiatorCredential();
    }

    public boolean isAcceptorCredential() throws GSSException {
        return cred.isAcceptorCredential();
    }

    public Oid getMechanism() {
        return GSSUtil.GSS_SPNEGO_MECH_OID;
    }

    @Override
    public GSSCredentialSpi impersonate(GSSNameSpi name) throws GSSException {
        return cred.impersonate(name);
    }
}
