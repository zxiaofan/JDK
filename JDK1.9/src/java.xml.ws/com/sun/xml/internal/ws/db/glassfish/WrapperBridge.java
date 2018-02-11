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

package com.sun.xml.internal.ws.db.glassfish;

import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.bind.JAXBException;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.bind.attachment.AttachmentUnmarshaller;
import javax.xml.namespace.NamespaceContext;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.transform.Result;
import javax.xml.transform.Source;

import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;

import com.sun.xml.internal.bind.api.Bridge;
import com.sun.xml.internal.bind.api.CompositeStructure;
import com.sun.xml.internal.ws.spi.db.BindingContext;
import com.sun.xml.internal.ws.spi.db.XMLBridge;
import com.sun.xml.internal.ws.spi.db.TypeInfo;
import com.sun.xml.internal.ws.spi.db.WrapperComposite;

public class WrapperBridge<T> implements XMLBridge<T> {

    private JAXBRIContextWrapper parent;
    private com.sun.xml.internal.bind.api.Bridge<T> bridge;

    public WrapperBridge(JAXBRIContextWrapper p, com.sun.xml.internal.bind.api.Bridge<T> b) {
        parent = p;
        bridge = b;
    }

    @Override
    public BindingContext context() {
        return parent;
    }

    @Override
    public boolean equals(Object obj) {
        return bridge.equals(obj);
    }

    @Override
    public TypeInfo getTypeInfo() {
        return parent.typeInfo(bridge.getTypeReference());
    }

    @Override
    public int hashCode() {
        return bridge.hashCode();
    }

    static CompositeStructure convert(Object o) {
        WrapperComposite w = (WrapperComposite) o;
        CompositeStructure cs = new CompositeStructure();
        cs.values = w.values;
        cs.bridges = new Bridge[w.bridges.length];
        for (int i = 0; i < cs.bridges.length; i++) {
            cs.bridges[i] = ((BridgeWrapper) w.bridges[i]).getBridge();
        }
        return cs;
    }

    @Override
    public final void marshal(T object, ContentHandler contentHandler, AttachmentMarshaller am) throws JAXBException {
        bridge.marshal((T) convert(object), contentHandler, am);
//              bridge.marshal(object, contentHandler, am);
    }

    @Override
    public void marshal(T object, Node output) throws JAXBException {
        throw new UnsupportedOperationException();
//              bridge.marshal(object, output);
//              bridge.marshal((T) convert(object), output);
    }

    @Override
    public void marshal(T object, OutputStream output, NamespaceContext nsContext, AttachmentMarshaller am) throws JAXBException {
        bridge.marshal((T) convert(object), output, nsContext, am);
    }

    @Override
    public final void marshal(T object, Result result) throws JAXBException {
        throw new UnsupportedOperationException();
//              bridge.marshal(object, result);
    }

    @Override
    public final void marshal(T object, XMLStreamWriter output, AttachmentMarshaller am) throws JAXBException {
        bridge.marshal((T) convert(object), output, am);
    }

    @Override
    public String toString() {
        return BridgeWrapper.class.getName() + " : " + bridge.toString();
    }

    @Override
    public final T unmarshal(InputStream in) throws JAXBException {
        //EndpointArgumentsBuilder.RpcLit.readRequest
        throw new UnsupportedOperationException();
//              return bridge.unmarshal(in);
    }

    @Override
    public final T unmarshal(Node n, AttachmentUnmarshaller au) throws JAXBException {
        //EndpointArgumentsBuilder.RpcLit.readRequest
        throw new UnsupportedOperationException();
//              return bridge.unmarshal(n, au);
    }

    @Override
    public final T unmarshal(Source in, AttachmentUnmarshaller au) throws JAXBException {
        //EndpointArgumentsBuilder.RpcLit.readRequest
        throw new UnsupportedOperationException();
//              return bridge.unmarshal(in, au);
    }

    @Override
    public final T unmarshal(XMLStreamReader in, AttachmentUnmarshaller au) throws JAXBException {
        //EndpointArgumentsBuilder.RpcLit.readRequest
        throw new UnsupportedOperationException();
//              return bridge.unmarshal(in, au);
    }

    @Override
    public boolean supportOutputStream() {
        return true;
    }
}
