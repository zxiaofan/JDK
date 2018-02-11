/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

import org.xml.sax.SAXException;

/**
 * {@link Loader} that delegates the processing to another {@link Loader}
 * at {@link #startElement(UnmarshallingContext.State, TagName)}.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class ProxyLoader extends Loader {
    public ProxyLoader() {
        super(false);
    }

    @Override
    public final void startElement(UnmarshallingContext.State state, TagName ea) throws SAXException {
        Loader loader = selectLoader(state,ea);
        state.setLoader(loader);
        loader.startElement(state,ea);
    }

    /**
     * Picks the loader to delegate to.
     *
     * @return never null.
     */
    protected abstract Loader selectLoader(UnmarshallingContext.State state, TagName ea) throws SAXException;

    @Override
    public final void leaveElement(UnmarshallingContext.State state, TagName ea) {
        // this loader is used just to forward to another loader,
        // so we should never get this event.
        throw new IllegalStateException();
    }
}
