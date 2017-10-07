/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.messaging.saaj.soap;

import java.awt.datatransfer.DataFlavor;
import java.io.IOException;
import java.io.OutputStream;

import javax.activation.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import com.sun.xml.internal.messaging.saaj.util.transform.EfficientStreamingTransformer;

/**
 * JAF data handler for XML content
 *
 * @author Anil Vijendran
 */
public class XmlDataContentHandler implements DataContentHandler {
    public static final String STR_SRC = "javax.xml.transform.stream.StreamSource";
    private static Class<?> streamSourceClass = null;

    public XmlDataContentHandler() throws ClassNotFoundException {
        if (streamSourceClass == null) {
            streamSourceClass = Class.forName(STR_SRC);
        }
    }

    /**
     * return the DataFlavors for this <code>DataContentHandler</code>
     * @return The DataFlavors.
     */
    @Override
    public DataFlavor[] getTransferDataFlavors() { // throws Exception;
        DataFlavor flavors[] = new DataFlavor[2];

        flavors[0] =
            new ActivationDataFlavor(streamSourceClass, "text/xml", "XML");
        flavors[1] =
            new ActivationDataFlavor(streamSourceClass, "application/xml", "XML");

        return flavors;
    }

    /**
     * return the Transfer Data of type DataFlavor from InputStream
     * @param flavor The DataFlavor.
     * @param dataSource The DataSource.
     * @return The constructed Object.
     */
    @Override
    public Object getTransferData(DataFlavor flavor, DataSource dataSource)
        throws IOException {
        if (flavor.getMimeType().startsWith("text/xml") ||
                flavor.getMimeType().startsWith("application/xml")) {
            if (flavor.getRepresentationClass().getName().equals(STR_SRC)) {
                return new StreamSource(dataSource.getInputStream());
            }
        }
        return null;
    }

    /**
     *
     */
    @Override
    public Object getContent(DataSource dataSource) throws IOException {
        return new StreamSource(dataSource.getInputStream());
    }

    /**
     * construct an object from a byte stream
     * (similar semantically to previous method, we are deciding
     *  which one to support)
     */
    @Override
    public void writeTo(Object obj, String mimeType, OutputStream os)
        throws IOException {
        if (!mimeType.startsWith("text/xml") && !mimeType.startsWith("application/xml"))
            throw new IOException(
                "Invalid content type \"" + mimeType + "\" for XmlDCH");


        try {
            Transformer transformer = EfficientStreamingTransformer.newTransformer();
            StreamResult result = new StreamResult(os);
            if (obj instanceof DataSource) {
                // Streaming transform applies only to javax.xml.transform.StreamSource
                transformer.transform((Source) getContent((DataSource)obj), result);
            } else {
                Source src=null;
                if (obj instanceof String) {
                     src= new StreamSource(new java.io.StringReader((String) obj));
                } else {
                    src=(Source) obj;
                }
                transformer.transform(src, result);
            }
        } catch (Exception ex) {
            throw new IOException(
                "Unable to run the JAXP transformer on a stream "
                    + ex.getMessage());
        }
    }
}
