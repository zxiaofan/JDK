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

import com.sun.xml.internal.ws.api.pipe.Pipe;
import com.sun.xml.internal.ws.api.pipe.PipeCloner;

/**
 * Partial default implementation of {@link Pipe}.
 *
 * <p>
 * To be shielded from potentail changes in JAX-WS,
 * please consider extending from this class, instead
 * of implementing {@link Pipe} directly.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class AbstractPipeImpl implements Pipe {

    /**
     * Do-nothing constructor.
     */
    protected AbstractPipeImpl() {
    }

    /**
     * Basis for the copy constructor.
     *
     * <p>
     * This registers the newly created {@link Pipe} with the {@link PipeCloner}
     * through {@link PipeCloner#add(Pipe, Pipe)}.
     */
    protected AbstractPipeImpl(Pipe that, PipeCloner cloner) {
        cloner.add(that,this);
    }

    public void preDestroy() {
        // noop
    }
}
