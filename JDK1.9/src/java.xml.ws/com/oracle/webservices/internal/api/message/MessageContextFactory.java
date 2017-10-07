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

package com.oracle.webservices.internal.api.message;

import java.io.IOException;
import java.io.InputStream;

import com.oracle.webservices.internal.api.EnvelopeStyle;
import com.sun.xml.internal.ws.api.SOAPVersion; // TODO leaking RI APIs
import com.sun.xml.internal.ws.util.ServiceFinder;

import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.ws.WebServiceFeature;

public abstract class MessageContextFactory
{
    private static final MessageContextFactory DEFAULT = new com.sun.xml.internal.ws.api.message.MessageContextFactory(new WebServiceFeature[0]);

    protected com.sun.xml.internal.ws.api.message.saaj.SAAJFactory saajFactory = null;

    protected abstract MessageContextFactory newFactory(WebServiceFeature ... f);

    public abstract MessageContext createContext();

    public abstract MessageContext createContext(SOAPMessage m);

    public abstract MessageContext createContext(Source m);

    public abstract MessageContext createContext(Source m, EnvelopeStyle.Style envelopeStyle);

    public abstract MessageContext createContext(InputStream in, String contentType) throws IOException;

    /**
     * @deprecated http://java.net/jira/browse/JAX_WS-1077
     */
    @Deprecated
    public abstract MessageContext createContext(InputStream in, MimeHeaders headers) throws IOException;

    static public MessageContextFactory createFactory(WebServiceFeature ... f) {
        return createFactory(null, f);
    }

    static public MessageContextFactory createFactory(ClassLoader cl, WebServiceFeature ...f) {
        for (MessageContextFactory factory : ServiceFinder.find(MessageContextFactory.class, cl)) {
            MessageContextFactory newfac = factory.newFactory(f);
            if (newfac != null) return newfac;
        }
        return new com.sun.xml.internal.ws.api.message.MessageContextFactory(f);
    }

    @Deprecated
    public abstract MessageContext doCreate();

    @Deprecated
    public abstract MessageContext doCreate(SOAPMessage m);

    //public abstract MessageContext doCreate(InputStream x);

    @Deprecated
    public abstract MessageContext doCreate(Source x, SOAPVersion soapVersion);

    @Deprecated
    public static MessageContext create(final ClassLoader... classLoader) {
        return serviceFinder(classLoader,
                             new Creator() {
                                 public MessageContext create(final MessageContextFactory f) {
                                     return f.doCreate();
                                 }
                             });
    }

    @Deprecated
    public static MessageContext create(final SOAPMessage m, final ClassLoader... classLoader) {
        return serviceFinder(classLoader,
                             new Creator() {
                                 public MessageContext create(final MessageContextFactory f) {
                                     return f.doCreate(m);
                                 }
                             });
    }

    @Deprecated
    public static MessageContext create(final Source m, final SOAPVersion v, final ClassLoader... classLoader) {
        return serviceFinder(classLoader,
                             new Creator() {
                                 public MessageContext create(final MessageContextFactory f) {
                                     return f.doCreate(m, v);
                                 }
                             });
    }

    @Deprecated
    private static MessageContext serviceFinder(final ClassLoader[] classLoader, final Creator creator) {
        final ClassLoader cl = classLoader.length == 0 ? null : classLoader[0];
        for (MessageContextFactory factory : ServiceFinder.find(MessageContextFactory.class, cl)) {
            final MessageContext messageContext = creator.create(factory);
            if (messageContext != null)
                return messageContext;
        }
        return creator.create(DEFAULT);
    }

    @Deprecated
    private static interface Creator {
        public MessageContext create(MessageContextFactory f);
    }

    public void setSAAJFactory(com.sun.xml.internal.ws.api.message.saaj.SAAJFactory saajFactory) {
        this.saajFactory = saajFactory;
    }
}
