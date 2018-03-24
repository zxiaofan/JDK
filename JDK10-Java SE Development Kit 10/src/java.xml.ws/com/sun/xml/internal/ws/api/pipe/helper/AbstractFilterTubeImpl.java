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

package com.sun.xml.internal.ws.api.pipe.helper;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.pipe.NextAction;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.pipe.TubeCloner;

/**
 * Convenient default implementation for filtering {@link Tube}.
 *
 * <p>
 * In this prototype, this is not that convenient, but in the real production
 * code where we have {@code preDestroy()} and {@code clone()}, this
 * is fairly handy.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class AbstractFilterTubeImpl extends AbstractTubeImpl {
    protected final Tube next;

    protected AbstractFilterTubeImpl(Tube next) {
        this.next = next;
    }

    protected AbstractFilterTubeImpl(AbstractFilterTubeImpl that, TubeCloner cloner) {
        super(that, cloner);
        if (that.next != null) {
            this.next = cloner.copy(that.next);
        } else {
            this.next = null;
        }
    }

    /**
     * Default no-op implementation.
     */
    public @NotNull NextAction processRequest(Packet request) {
        return doInvoke(next,request);
    }

    /**
     * Default no-op implementation.
     */
    public @NotNull NextAction processResponse(Packet response) {
        return doReturnWith(response);
    }

    /**
     * Default no-op implementation.
     */
    public @NotNull NextAction processException(Throwable t) {
        return doThrow(t);
    }

    public void preDestroy() {
        if (next != null) {
          next.preDestroy();
        }
    }
}
