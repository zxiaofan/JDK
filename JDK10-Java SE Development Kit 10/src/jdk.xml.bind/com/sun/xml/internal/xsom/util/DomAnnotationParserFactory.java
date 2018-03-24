/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom.util;

import com.sun.xml.internal.xsom.XSAnnotation;
import com.sun.xml.internal.xsom.parser.AnnotationContext;
import com.sun.xml.internal.xsom.parser.AnnotationParser;
import com.sun.xml.internal.xsom.parser.AnnotationParserFactory;
import javax.xml.XMLConstants;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.ContentHandler;
import org.xml.sax.EntityResolver;
import org.xml.sax.ErrorHandler;

import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.dom.DOMResult;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;

/**
 * {@link AnnotationParserFactory} that parses annotations into a W3C DOM.
 *
 * <p>
 * If you use this parser factory, you'll get {@link Element} that represents
 * {@code <xs:annotation>} from {@link XSAnnotation#getAnnotation()}.
 *
 * <p>
 * When multiple {@code <xs:annotation>s} are found for the given schema component,
 * you'll see all {@code <xs:appinfo>s} and {@code <xs:documentation>s} combined under
 * one {@code <xs:annotation>} element.
 *
 * @author Kohsuke Kawaguchi
 */
public class DomAnnotationParserFactory implements AnnotationParserFactory {

    public AnnotationParser create() {
        return new AnnotationParserImpl();
    }

    public AnnotationParser create(boolean disableSecureProcessing) {
        return new AnnotationParserImpl(disableSecureProcessing);
    }

    private static final ContextClassloaderLocal<SAXTransformerFactory> stf = new ContextClassloaderLocal<SAXTransformerFactory>() {
        @Override
        protected SAXTransformerFactory initialValue() throws Exception {
            return (SAXTransformerFactory) SAXTransformerFactory.newInstance();
        }
    };

    private static class AnnotationParserImpl extends AnnotationParser {

        /**
         * Identity transformer used to parse SAX into DOM.
         */
        private final TransformerHandler transformer;
        private DOMResult result;

        AnnotationParserImpl() {
            this(false);
        }

        AnnotationParserImpl(boolean disableSecureProcessing) {
            try {
                SAXTransformerFactory factory = stf.get();
                factory.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, disableSecureProcessing);
                transformer = factory.newTransformerHandler();
            } catch (TransformerConfigurationException e) {
                throw new Error(e); // impossible
            }
        }

        public ContentHandler getContentHandler(AnnotationContext context, String parentElementName, ErrorHandler errorHandler, EntityResolver entityResolver) {
            result = new DOMResult();
            transformer.setResult(result);
            return transformer;
        }

        public Object getResult(Object existing) {
            Document dom = (Document)result.getNode();
            Element e = dom.getDocumentElement();
            if(existing instanceof Element) {
                // merge all the children
                Element prev = (Element) existing;
                Node anchor = e.getFirstChild();
                while(prev.getFirstChild()!=null) {
                    Node move = prev.getFirstChild();
                    e.insertBefore(e.getOwnerDocument().adoptNode(move), anchor );
                }
            }
            return e;
        }
    }
}
