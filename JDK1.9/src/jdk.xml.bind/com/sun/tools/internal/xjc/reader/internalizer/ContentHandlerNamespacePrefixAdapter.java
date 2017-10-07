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

package com.sun.tools.internal.xjc.reader.internalizer;

import javax.xml.XMLConstants;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.AttributesImpl;
import org.xml.sax.helpers.XMLFilterImpl;

/**
 * {@link XMLReader} filter for supporting
 * {@code http://xml.org/sax/features/namespace-prefixes} feature.
 *
 * @author Kohsuke Kawaguchi
 */
final class ContentHandlerNamespacePrefixAdapter extends XMLFilterImpl {
    /**
     * True if {@code http://xml.org/sax/features/namespace-prefixes} is set to true.
     */
    private boolean namespacePrefixes = false;

    private String[] nsBinding = new String[8];
    private int len;

    public ContentHandlerNamespacePrefixAdapter() {
    }

    public ContentHandlerNamespacePrefixAdapter(XMLReader parent) {
        setParent(parent);
    }

    @Override
    public boolean getFeature(String name) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name.equals(PREFIX_FEATURE))
            return namespacePrefixes;
        return super.getFeature(name);
    }

    @Override
    public void setFeature(String name, boolean value) throws SAXNotRecognizedException, SAXNotSupportedException {
        if(name.equals(PREFIX_FEATURE)) {
            this.namespacePrefixes = value;
            return;
        }
        if(name.equals(NAMESPACE_FEATURE) && value)
            return;
        super.setFeature(name, value);
    }


    @Override
    public void startPrefixMapping(String prefix, String uri) throws SAXException {
        if (XMLConstants.XML_NS_URI.equals(uri)) return; //xml prefix shall not be declared based on jdk api javadoc
        if(len==nsBinding.length) {
            // reallocate
            String[] buf = new String[nsBinding.length*2];
            System.arraycopy(nsBinding,0,buf,0,nsBinding.length);
            nsBinding = buf;
        }
        nsBinding[len++] = prefix;
        nsBinding[len++] = uri;
        super.startPrefixMapping(prefix,uri);
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        if(namespacePrefixes) {
            this.atts.setAttributes(atts);
            // add namespace bindings back as attributes
            for( int i=0; i<len; i+=2 ) {
                String prefix = nsBinding[i];
                if(prefix.length()==0)
                    this.atts.addAttribute(XMLConstants.XML_NS_URI,"xmlns","xmlns","CDATA",nsBinding[i+1]);
                else
                    this.atts.addAttribute(XMLConstants.XML_NS_URI,prefix,"xmlns:"+prefix,"CDATA",nsBinding[i+1]);
            }
            atts = this.atts;
        }
        len=0;
        super.startElement(uri, localName, qName, atts);
    }

    private final AttributesImpl atts = new AttributesImpl();

    private static final String PREFIX_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    private static final String NAMESPACE_FEATURE = "http://xml.org/sax/features/namespaces";
}
