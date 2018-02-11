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

package com.sun.xml.internal.ws.message;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Attachment;
import com.sun.xml.internal.ws.util.ByteArrayBuffer;

import javax.activation.DataHandler;
import javax.xml.soap.AttachmentPart;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;

/**
 * @author Jitendra Kotamraju
 */
public final class DataHandlerAttachment implements Attachment {

    private final DataHandler dh;
    private final String contentId;
    String contentIdNoAngleBracket;

    /**
     * This will be constructed by {@link com.sun.xml.internal.ws.message.jaxb.AttachmentMarshallerImpl}
     */
    public DataHandlerAttachment(@NotNull String contentId, @NotNull DataHandler dh) {
        this.dh = dh;
        this.contentId = contentId;
    }

    public String getContentId() {
//        return contentId;
        if (contentIdNoAngleBracket == null) {
            contentIdNoAngleBracket = contentId;
            if (contentIdNoAngleBracket != null && contentIdNoAngleBracket.charAt(0) == '<')
                contentIdNoAngleBracket = contentIdNoAngleBracket.substring(1, contentIdNoAngleBracket.length()-1);
        }
        return contentIdNoAngleBracket;
    }

    public String getContentType() {
        return dh.getContentType();
    }

    public byte[] asByteArray() {
        try {
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            dh.writeTo(os);
            return os.toByteArray();
        } catch (IOException e) {
            throw new WebServiceException(e);
        }
    }

    public DataHandler asDataHandler() {
        return dh;
    }

    public Source asSource() {
        try {
            return new StreamSource(dh.getInputStream());
        } catch (IOException e) {
            throw new WebServiceException(e);
        }
    }

    public InputStream asInputStream() {
        try {
            return dh.getInputStream();
        } catch (IOException e) {
            throw new WebServiceException(e);
        }
    }

    public void writeTo(OutputStream os) throws IOException {
        dh.writeTo(os);
    }

    public void writeTo(SOAPMessage saaj) throws SOAPException {
        AttachmentPart part = saaj.createAttachmentPart();
        part.setDataHandler(dh);
        part.setContentId(contentId);
        saaj.addAttachmentPart(part);
    }
}
