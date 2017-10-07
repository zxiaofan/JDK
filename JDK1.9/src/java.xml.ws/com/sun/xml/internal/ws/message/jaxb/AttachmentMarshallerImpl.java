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

package com.sun.xml.internal.ws.message.jaxb;

import com.sun.istack.internal.logging.Logger;
import com.sun.xml.internal.ws.api.message.Attachment;
import com.sun.xml.internal.ws.api.message.AttachmentSet;
import com.sun.xml.internal.ws.message.DataHandlerAttachment;

import javax.activation.DataHandler;
import javax.xml.bind.attachment.AttachmentMarshaller;
import javax.xml.ws.WebServiceException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.UUID;
import java.util.logging.Level;

/**
 * Implementation of {@link AttachmentMarshaller}, its used from JAXBMessage to marshall swaref type
 *
 * @author Vivek Pandey
 * @see JAXBMessage
 */
final class AttachmentMarshallerImpl extends AttachmentMarshaller {

    private static final Logger LOGGER = Logger.getLogger(AttachmentMarshallerImpl.class);

    private AttachmentSet attachments;

    public AttachmentMarshallerImpl(AttachmentSet attachemnts) {
        this.attachments = attachemnts;
    }

    /**
     * Release a reference to user objects to avoid keeping it in memory.
     */
    void cleanup() {
        attachments = null;
    }

    @Override
    public String addMtomAttachment(DataHandler data, String elementNamespace, String elementLocalName) {
        // We don't use JAXB for handling XOP
        throw new IllegalStateException();
    }

    @Override
    public String addMtomAttachment(byte[] data, int offset, int length, String mimeType, String elementNamespace, String elementLocalName) {
        // We don't use JAXB for handling XOP
        throw new IllegalStateException();
    }

    @Override
    public String addSwaRefAttachment(DataHandler data) {
        String cid = encodeCid(null);
        Attachment att = new DataHandlerAttachment(cid, data);
        attachments.add(att);
        cid = "cid:" + cid;
        return cid;
    }

    private String encodeCid(String ns) {
        String cid = "example.jaxws.sun.com";
        String name = UUID.randomUUID() + "@";
        if (ns != null && (ns.length() > 0)) {
            try {
                URI uri = new URI(ns);
                cid = uri.toURL().getHost();
            } catch (URISyntaxException e) {
                if (LOGGER.isLoggable(Level.INFO)) {
                    LOGGER.log(Level.INFO, null, e);
                }
                return null;
            } catch (MalformedURLException e) {
                try {
                    cid = URLEncoder.encode(ns, "UTF-8");
                } catch (UnsupportedEncodingException e1) {
                    throw new WebServiceException(e);
                }
            }
        }
        return name + cid;
    }
}
