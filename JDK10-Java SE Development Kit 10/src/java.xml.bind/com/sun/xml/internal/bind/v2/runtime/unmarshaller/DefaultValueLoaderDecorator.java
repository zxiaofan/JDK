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
 * Decorates another {@link Loader} by setting a default value.
 *
 * @author Kohsuke Kawaguchi
 */
public final class DefaultValueLoaderDecorator extends Loader {
    private final Loader l;
    private final String defaultValue;

    public DefaultValueLoaderDecorator(Loader l, String defaultValue) {
        this.l = l;
        this.defaultValue = defaultValue;
    }

    @Override
    public void startElement(UnmarshallingContext.State state, TagName ea) throws SAXException {
        // install the default value, but don't override the one given by the parent loader
        if(state.getElementDefaultValue() == null)
            state.setElementDefaultValue(defaultValue);

        state.setLoader(l);
        l.startElement(state,ea);
    }
}
