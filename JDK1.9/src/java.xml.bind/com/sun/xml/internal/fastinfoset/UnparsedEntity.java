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

public class UnparsedEntity extends Notation {
    public final String notationName;

    /** Creates a new instance of UnparsedEntityDeclaration */
    public UnparsedEntity(String _name, String _systemIdentifier, String _publicIdentifier, String _notationName) {
        super(_name, _systemIdentifier, _publicIdentifier);
        notationName = _notationName;
    }

}
