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

import java.util.Collection;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.DatatypeConverterImpl;
import com.sun.xml.internal.bind.v2.WellKnownNamespace;
import com.sun.xml.internal.bind.v2.runtime.ClassBeanInfoImpl;
import com.sun.xml.internal.bind.v2.runtime.JaxBeanInfo;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public final class LeafPropertyXsiLoader extends Loader {

    private final Loader defaultLoader;
    private final TransducedAccessor xacc;
    private final Accessor acc;

    public LeafPropertyXsiLoader(Loader defaultLoader, TransducedAccessor xacc, Accessor acc) {
        this.defaultLoader = defaultLoader;
        this.expectText = true;
        this.xacc = xacc;
        this.acc = acc;
    }


    @Override
    public void startElement(UnmarshallingContext.State state, TagName ea) throws SAXException {
        final Loader loader = selectLoader(state, ea);
        state.setLoader(loader);
        loader.startElement(state, ea);
    }

    protected Loader selectLoader(UnmarshallingContext.State state, TagName ea) throws SAXException {

        UnmarshallingContext context = state.getContext();
        JaxBeanInfo beanInfo = null;

        // look for @xsi:type
        Attributes atts = ea.atts;
        int idx = atts.getIndex(WellKnownNamespace.XML_SCHEMA_INSTANCE, "type");

        if (idx >= 0) {
            String value = atts.getValue(idx);

            QName type = DatatypeConverterImpl._parseQName(value, context);

            if (type == null)
                return defaultLoader;

            beanInfo = context.getJAXBContext().getGlobalType(type);
            if (beanInfo == null)
                return defaultLoader;
            ClassBeanInfoImpl cbii;
            try {
                cbii = (ClassBeanInfoImpl) beanInfo;
            } catch (ClassCastException cce) {
                return defaultLoader;
            }

            if (null == cbii.getTransducer()) {
                return defaultLoader;
            }

            return new LeafPropertyLoader(
                    new TransducedAccessor.CompositeTransducedAccessorImpl(
                            state.getContext().getJAXBContext(),
                            cbii.getTransducer(),
                            acc));
        }

        return defaultLoader;
    }

    @Override
    public Collection<QName> getExpectedChildElements() {
        return defaultLoader.getExpectedChildElements();
    }

    @Override
    public Collection<QName> getExpectedAttributes() {
        return defaultLoader.getExpectedAttributes();
    }
}
