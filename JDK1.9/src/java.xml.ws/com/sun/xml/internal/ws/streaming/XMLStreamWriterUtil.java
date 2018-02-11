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

package com.sun.xml.internal.ws.streaming;

import com.sun.istack.internal.Nullable;
import com.sun.xml.internal.ws.encoding.HasEncoding;
import com.sun.xml.internal.ws.encoding.SOAPBindingCodec;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.XMLStreamException;
import java.util.Map;
import java.io.OutputStream;

/**
 * <p>XMLStreamWriterUtil provides some utility methods intended to be used
 * in conjunction with a StAX XMLStreamWriter. </p>
 *
 * @author Santiago.PericasGeertsen@sun.com
 */
public class XMLStreamWriterUtil {

    private XMLStreamWriterUtil() {
    }

    /**
     * Gives the underlying stream for XMLStreamWriter. It closes any start elements, and returns the stream so
     * that JAXB can write infoset directly to the stream.
     *
     * @param writer XMLStreamWriter for which stream is required
     * @return  underlying OutputStream, null if writer doesn't provide a way to get it
     * @throws XMLStreamException if any of writer operations throw the exception
     */
    public static @Nullable OutputStream getOutputStream(XMLStreamWriter writer) throws XMLStreamException {
        Object obj = null;

        // Hack for JDK6's SJSXP
        if (writer instanceof Map) {
            obj = ((Map) writer).get("sjsxp-outputstream");
        }

        // woodstox
        if (obj == null) {
            try {
                obj = writer.getProperty("com.ctc.wstx.outputUnderlyingStream");
            } catch(Exception ie) {
                // Catch all exceptions. SJSXP in JDK throws NPE
                // nothing to do here
            }
        }

        // SJSXP
        if (obj == null) {
            try {
                obj = writer.getProperty("http://java.sun.com/xml/stream/properties/outputstream");
            } catch(Exception ie) {
                // Catch all exceptions. SJSXP in JDK throws NPE
                // nothing to do here
            }
        }


        if (obj != null) {
            writer.writeCharacters("");  // Force completion of open elems
            writer.flush();
            return (OutputStream)obj;
        }
        return null;
    }

    /**
     * Gives the encoding with which XMLStreamWriter is created.
     *
     * @param writer XMLStreamWriter for which encoding is required
     * @return null if cannot be found, else the encoding
     */
    public static @Nullable String getEncoding(XMLStreamWriter writer) {
        /*
         * TODO Add reflection logic to handle woodstox writer
         * as it implements XMLStreamWriter2#getEncoding()
         * It's not that important since woodstox writer is typically wrapped
         * in a writer with HasEncoding
         */
        return (writer instanceof HasEncoding)
                ? ((HasEncoding)writer).getEncoding()
                : null;
    }

    public static String encodeQName(XMLStreamWriter writer, QName qname,
        PrefixFactory prefixFactory)
    {
        // NOTE: Here it is assumed that we do not serialize using default
        // namespace declarations and therefore that writer.getPrefix will
        // never return ""

        try {
            String namespaceURI = qname.getNamespaceURI();
            String localPart = qname.getLocalPart();

            if (namespaceURI == null || namespaceURI.equals("")) {
                return localPart;
            }
            else {
                String prefix = writer.getPrefix(namespaceURI);
                if (prefix == null) {
                    prefix = prefixFactory.getPrefix(namespaceURI);
                    writer.writeNamespace(prefix, namespaceURI);
                }
                return prefix + ":" + localPart;
            }
        }
        catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }
}
