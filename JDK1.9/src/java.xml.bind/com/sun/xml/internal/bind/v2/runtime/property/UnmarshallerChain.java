/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.property;

import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Scope;


/**
 * Pass around a 'ticket dispenser' when creating new
 * unmarshallers. This controls the index of the slot
 * allocated to the chain of handlers.

 *
 * <p>
 * A ticket dispenser also maintains the offset for handlers
 * to access state slots. A handler records this value when it's created.
 *
 *
 */
public final class UnmarshallerChain {
    /**
     * This offset allows child unmarshallers to have its own {@link Scope} without colliding with siblings.
     */
    private int offset = 0;

    public final JAXBContextImpl context;

    public UnmarshallerChain(JAXBContextImpl context) {
        this.context = context;
    }

    /**
     * Allocates a new {@link Scope} offset.
     */
    public int allocateOffset() {
        return offset++;
    }

    /**
     * Gets the number of total scope offset allocated.
     */
    public int getScopeSize() {
        return offset;
    }
}
