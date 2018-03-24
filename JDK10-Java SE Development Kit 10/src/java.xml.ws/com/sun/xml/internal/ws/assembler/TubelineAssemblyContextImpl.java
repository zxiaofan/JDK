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

package com.sun.xml.internal.ws.assembler;

import com.sun.istack.internal.logging.Logger;
import com.sun.xml.internal.ws.api.pipe.Pipe;
import com.sun.xml.internal.ws.api.pipe.Tube;
import com.sun.xml.internal.ws.api.pipe.helper.PipeAdapter;
import com.sun.xml.internal.ws.assembler.dev.TubelineAssemblyContext;
import java.text.MessageFormat;

import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;

/**
 * A base tubeline assembly context class providing common methods for both
 * client and server assembly context classes.
 *
 * @author Marek Potociar (marek.potociar at sun.com)
 */
class TubelineAssemblyContextImpl implements TubelineAssemblyContext {
    private static final Logger LOGGER = Logger.getLogger(TubelineAssemblyContextImpl.class);

    private Tube head;
    private Pipe adaptedHead;
    private List<Tube> tubes = new LinkedList<Tube>();

    @Override
    public Tube getTubelineHead() {
        return head;
    }

    @Override
    public Pipe getAdaptedTubelineHead() {
        if (adaptedHead == null) {
            adaptedHead = PipeAdapter.adapt(head);
        }
        return adaptedHead;
    }

    boolean setTubelineHead(Tube newHead) {
        if (newHead == head || newHead == adaptedHead) {
            return false;
        }

        head = newHead;
        tubes.add(head);
        adaptedHead = null;

        if (LOGGER.isLoggable(Level.FINER)) {
            LOGGER.finer(MessageFormat.format("Added '{0}' tube instance to the tubeline.", (newHead == null) ? null : newHead.getClass().getName()));
        }

        return true;
    }

    @Override
    public <T> T getImplementation(Class<T> type) {
        for (Tube tube : tubes) {
            if (type.isInstance(tube)) {
                return type.cast(tube);
            }
        }
        return null;
    }
}
