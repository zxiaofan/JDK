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

package com.sun.xml.internal.ws.wsdl.parser;

import com.sun.xml.internal.stream.buffer.XMLStreamBufferResult;
import com.sun.xml.internal.ws.api.server.SDDocumentSource;
import com.sun.xml.internal.ws.api.wsdl.parser.XMLEntityResolver;
import com.sun.xml.internal.ws.util.JAXWSUtils;
import com.sun.xml.internal.ws.util.xml.XmlUtil;
import org.xml.sax.SAXException;

import javax.xml.stream.XMLStreamException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.ws.WebServiceException;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Entity resolver that works on MEX Metadata
 *
 * @author Vivek Pandey
 */
public final class MexEntityResolver implements XMLEntityResolver {
    private final Map<String, SDDocumentSource> wsdls = new HashMap<String, SDDocumentSource>();

    public MexEntityResolver(List<? extends Source> wsdls) throws IOException {
        Transformer transformer = XmlUtil.newTransformer();
        for (Source source : wsdls) {
            XMLStreamBufferResult xsbr = new XMLStreamBufferResult();
            try {
                transformer.transform(source, xsbr);
            } catch (TransformerException e) {
                throw new WebServiceException(e);
            }
            String systemId = source.getSystemId();

            //TODO: can we do anything if the given mex Source has no systemId?
            if(systemId != null){
                SDDocumentSource doc = SDDocumentSource.create(JAXWSUtils.getFileOrURL(systemId), xsbr.getXMLStreamBuffer());
                this.wsdls.put(systemId, doc);
            }
        }
    }

    public Parser resolveEntity(String publicId, String systemId) throws SAXException, IOException, XMLStreamException {
        if (systemId != null) {
            SDDocumentSource src = wsdls.get(systemId);
            if (src != null)
                return new Parser(src);
        }
        return null;
    }
}
