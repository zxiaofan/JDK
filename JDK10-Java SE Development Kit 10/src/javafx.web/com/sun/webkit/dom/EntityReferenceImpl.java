/*
 * Copyright (c) 2013, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.dom;

import org.w3c.dom.EntityReference;

public class EntityReferenceImpl extends NodeImpl implements EntityReference {
    EntityReferenceImpl(long peer) {
        super(peer);
    }

    static EntityReference getImpl(long peer) {
        return (EntityReference)create(peer);
    }

}

