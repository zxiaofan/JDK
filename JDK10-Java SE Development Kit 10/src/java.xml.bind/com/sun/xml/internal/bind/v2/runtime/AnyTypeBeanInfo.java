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

package com.sun.xml.internal.bind.v2.runtime;

import java.io.IOException;

import javax.xml.bind.annotation.W3CDomHandler;
import javax.xml.bind.helpers.ValidationEventImpl;
import javax.xml.bind.ValidationEvent;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

import com.sun.xml.internal.bind.v2.WellKnownNamespace;
import com.sun.xml.internal.bind.v2.model.runtime.RuntimeTypeInfo;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.UnmarshallingContext;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.DomLoader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiTypeLoader;

import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * {@link JaxBeanInfo} for handling {@code xs:anyType}.
 *
 * @author Kohsuke Kawaguchi
 */
final class AnyTypeBeanInfo extends JaxBeanInfo<Object> implements AttributeAccessor {

    private boolean nilIncluded = false;

    public AnyTypeBeanInfo(JAXBContextImpl grammar,RuntimeTypeInfo anyTypeInfo) {
        super(grammar, anyTypeInfo, Object.class, new QName(WellKnownNamespace.XML_SCHEMA,"anyType"), false, true, false);
    }

    public String getElementNamespaceURI(Object element) {
        throw new UnsupportedOperationException();
    }

    public String getElementLocalName(Object element) {
        throw new UnsupportedOperationException();
    }

    public Object createInstance(UnmarshallingContext context) {
        throw new UnsupportedOperationException();
        // return JAXBContextImpl.createDom().createElementNS("","noname");
    }

    public boolean reset(Object element, UnmarshallingContext context) {
        return false;
//        NodeList nl = element.getChildNodes();
//        while(nl.getLength()>0)
//            element.removeChild(nl.item(0));
//        NamedNodeMap al = element.getAttributes();
//        while(al.getLength()>0)
//            element.removeAttributeNode((Attr)al.item(0));
//        return true;
    }

    public String getId(Object element, XMLSerializer target) {
        return null;
    }

    public void serializeBody(Object element, XMLSerializer target) throws SAXException, IOException, XMLStreamException {
        NodeList childNodes = ((Element)element).getChildNodes();
        int len = childNodes.getLength();
        for( int i=0; i<len; i++ ) {
            Node child = childNodes.item(i);
            switch(child.getNodeType()) {
            case Node.CDATA_SECTION_NODE:
            case Node.TEXT_NODE:
                target.text(child.getNodeValue(),null);
                break;
            case Node.ELEMENT_NODE:
                target.writeDom((Element)child,domHandler,null,null);
                break;
            }
        }
    }

    public void serializeAttributes(Object element, XMLSerializer target) throws SAXException {
        NamedNodeMap al = ((Element)element).getAttributes();
        int len = al.getLength();
        for( int i=0; i<len; i++ ) {
            Attr a = (Attr)al.item(i);
            // work defensively
            String uri = a.getNamespaceURI();
            if(uri==null)   uri="";
            String local = a.getLocalName();
            String name = a.getName();
            if(local==null) local = name;
            if (uri.equals(WellKnownNamespace.XML_SCHEMA_INSTANCE) && ("nil".equals(local))) {
                isNilIncluded = true;
            }
            if(name.startsWith("xmlns")) continue;// DOM reports ns decls as attributes

            target.attribute(uri,local,a.getValue());
        }
    }

    public void serializeRoot(Object element, XMLSerializer target) throws SAXException {
        target.reportError(
                new ValidationEventImpl(
                        ValidationEvent.ERROR,
                        Messages.UNABLE_TO_MARSHAL_NON_ELEMENT.format(element.getClass().getName()),
                        null,
                        null));
    }

    public void serializeURIs(Object element, XMLSerializer target) {
        NamedNodeMap al = ((Element)element).getAttributes();
        int len = al.getLength();
        NamespaceContext2 context = target.getNamespaceContext();
        for( int i=0; i<len; i++ ) {
            Attr a = (Attr)al.item(i);
            if ("xmlns".equals(a.getPrefix())) {
                context.force(a.getValue(), a.getLocalName());
                continue;
            }
            if ("xmlns".equals(a.getName())) {
                if (element instanceof org.w3c.dom.Element) {
                    context.declareNamespace(a.getValue(), null, false);
                    continue;
                } else {
                    context.force(a.getValue(), "");
                    continue;
                }
            }
            String nsUri = a.getNamespaceURI();
            if(nsUri!=null && nsUri.length()>0)
                context.declareNamespace( nsUri, a.getPrefix(), true );
        }
    }

    public Transducer<Object> getTransducer() {
        return null;
    }

    public Loader getLoader(JAXBContextImpl context, boolean typeSubstitutionCapable) {
        if(typeSubstitutionCapable)
            return substLoader;
        else
            return domLoader;
    }

    private static final W3CDomHandler domHandler = new W3CDomHandler();
    private static final DomLoader domLoader = new DomLoader(domHandler);
    private final XsiTypeLoader substLoader = new XsiTypeLoader(this);

    }
