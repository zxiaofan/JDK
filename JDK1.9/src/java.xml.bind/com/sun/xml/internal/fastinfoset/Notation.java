/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 *
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset;

public class Notation {
    public final String name;
    public final String systemIdentifier;
    public final String publicIdentifier;

    /** Creates a new instance of Notation */
    public Notation(String _name, String _systemIdentifier, String _publicIdentifier) {
        name = _name;
        systemIdentifier = _systemIdentifier;
        publicIdentifier = _publicIdentifier;
    }

}
