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

package com.sun.xml.internal.bind.v2.runtime.unmarshaller;

import javax.xml.bind.annotation.DomHandler;

import com.sun.xml.internal.bind.v2.model.core.WildcardMode;

import org.xml.sax.SAXException;

/**
 * Feed incoming events to {@link DomHandler} and builds a DOM tree.
 *
 * <p>
 * Note that the SAXException returned by the ContentHandler is
 * unreported. So we have to catch them and report it, then rethrow
 * it if necessary.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public final class WildcardLoader extends ProxyLoader {

    private final DomLoader dom;

    private final WildcardMode mode;

    public WildcardLoader(DomHandler dom, WildcardMode mode) {
        this.dom = new DomLoader(dom);
        this.mode = mode;
    }

    protected Loader selectLoader(UnmarshallingContext.State state, TagName tag) throws SAXException {
        UnmarshallingContext context = state.getContext();

        if(mode.allowTypedObject) {
            Loader l = context.selectRootLoader(state,tag);
            if(l!=null)
                return l;
        }
        if(mode.allowDom)
            return dom;

        // simply discard.
        return Discarder.INSTANCE;
    }

}
