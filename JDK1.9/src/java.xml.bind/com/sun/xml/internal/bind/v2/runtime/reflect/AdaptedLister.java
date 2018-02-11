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

package com.sun.xml.internal.bind.v2.runtime.reflect;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.JAXBException;

import com.sun.xml.internal.bind.v2.runtime.Coordinator;
import com.sun.xml.internal.bind.v2.runtime.XMLSerializer;
import com.sun.xml.internal.bind.api.AccessorException;

import org.xml.sax.SAXException;

/**
 * {@link Lister} that adapts individual item types.
 */
final class AdaptedLister<BeanT,PropT,InMemItemT,OnWireItemT,PackT> extends Lister<BeanT,PropT,OnWireItemT,PackT> {
    private final Lister<BeanT,PropT,InMemItemT,PackT> core;
    private final Class<? extends XmlAdapter<OnWireItemT,InMemItemT>> adapter;

    /*package*/ AdaptedLister(
        Lister<BeanT,PropT,InMemItemT,PackT> core,
        Class<? extends XmlAdapter<OnWireItemT,InMemItemT>> adapter) {

        this.core = core;
        this.adapter = adapter;
    }

    private XmlAdapter<OnWireItemT,InMemItemT> getAdapter() {
        return Coordinator._getInstance().getAdapter(adapter);
    }

    public ListIterator<OnWireItemT> iterator(PropT prop, XMLSerializer context) {
        return new ListIteratorImpl( core.iterator(prop,context), context );
    }

    public PackT startPacking(BeanT bean, Accessor<BeanT, PropT> accessor) throws AccessorException {
        return core.startPacking(bean,accessor);
    }

    public void addToPack(PackT pack, OnWireItemT item) throws AccessorException {
        InMemItemT r;
        try {
            r = getAdapter().unmarshal(item);
        } catch (Exception e) {
            throw new AccessorException(e);
        }
        core.addToPack(pack,r);
    }

    public void endPacking(PackT pack, BeanT bean, Accessor<BeanT,PropT> accessor) throws AccessorException {
        core.endPacking(pack,bean,accessor);
    }

    public void reset(BeanT bean, Accessor<BeanT, PropT> accessor) throws AccessorException {
        core.reset(bean,accessor);
    }

    private final class ListIteratorImpl implements ListIterator<OnWireItemT> {
        private final ListIterator<InMemItemT> core;
        private final XMLSerializer serializer;

        public ListIteratorImpl(ListIterator<InMemItemT> core,XMLSerializer serializer) {
            this.core = core;
            this.serializer = serializer;
        }

        public boolean hasNext() {
            return core.hasNext();
        }

        public OnWireItemT next() throws SAXException, JAXBException {
            InMemItemT next = core.next();
            try {
                return getAdapter().marshal(next);
            } catch (Exception e) {
                serializer.reportError(null,e);
                return null; // recover this error by returning null
            }
        }
    }
}
