/*
 * Copyright (c) 1999, 2002, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap;

import javax.naming.*;
import javax.naming.ldap.*;

class NameClassPairWithControls extends NameClassPair implements HasControls {
    private Control[] controls;

    public NameClassPairWithControls(String name, String className,
        Control[] controls) {
        super(name, className);
        this.controls = controls;
    }

    public Control[] getControls() throws NamingException {
        return controls;
    }

    private static final long serialVersionUID = 2010738921219112944L;
}
