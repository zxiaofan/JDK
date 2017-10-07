/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import sun.security.jgss.GSSCredentialImpl;

class ExtendedGSSCredentialImpl extends GSSCredentialImpl
        implements ExtendedGSSCredential {

    public ExtendedGSSCredentialImpl(GSSCredentialImpl old) {
        super(old);
    }
}
