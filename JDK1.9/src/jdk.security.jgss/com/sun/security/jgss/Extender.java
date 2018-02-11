/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.security.jgss;

import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import sun.security.jgss.GSSContextImpl;
import sun.security.jgss.GSSCredentialImpl;
import sun.security.jgss.JgssExtender;

// The com.sun.security.jgss extension to JGSS-API
class Extender extends JgssExtender {

    static {
        JgssExtender.setExtender(new Extender());
    }

    public GSSCredential wrap(GSSCredential cred) {
        if (cred instanceof ExtendedGSSCredentialImpl) {
            return cred;
        } else {
            return new ExtendedGSSCredentialImpl((GSSCredentialImpl)cred);
        }
    }

    public GSSContext wrap(GSSContext ctxt) {
        if (ctxt instanceof ExtendedGSSContextImpl) {
            return ctxt;
        } else {
            return new ExtendedGSSContextImpl((GSSContextImpl)ctxt);
        }
    }
}
