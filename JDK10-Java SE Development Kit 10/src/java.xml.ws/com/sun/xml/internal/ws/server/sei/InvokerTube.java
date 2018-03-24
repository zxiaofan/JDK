/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.server.sei;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.TubeCloner;
import com.sun.xml.internal.ws.api.pipe.helper.AbstractTubeImpl;

/**
 * Base class for {@link com.sun.xml.internal.ws.server.InvokerTube} restored
 * to allow for containers to specify alternate implementations of SEI-based
 * invoking.
 */
public abstract class InvokerTube<T extends Invoker>
        extends AbstractTubeImpl implements InvokerSource<T> {

    protected final T invoker;

    protected InvokerTube(T invoker) {
        this.invoker = invoker;
    }

    /**
     * Copy constructor.
     */
    protected InvokerTube(InvokerTube<T> that, TubeCloner cloner) {
        cloner.add(that,this);
        this.invoker = that.invoker;
    }

    /**
     * Returns the {@link Invoker} object that serves the request.
     */
    public @NotNull T getInvoker(Packet request) {
        return invoker;
    }
}
