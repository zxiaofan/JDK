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
import java.io.InputStream;

import javax.activation.*;
import javax.xml.transform.Source;

import com.sun.xml.internal.messaging.saaj.util.FastInfosetReflection;

/**
 * JAF data handler for Fast Infoset content
 *
 * @author Santiago Pericas-Geertsen
 */
public class FastInfosetDataContentHandler implements DataContentHandler {
    public static final String STR_SRC = "com.sun.xml.internal.org.jvnet.fastinfoset.FastInfosetSource";

    public FastInfosetDataContentHandler() {
    }

    /**
     * Return the DataFlavors for this <code>DataContentHandler</code>
     * @return The DataFlavors.
     */
    @Override
    public DataFlavor[] getTransferDataFlavors() { // throws Exception;
        DataFlavor flavors[] = new DataFlavor[1];
        flavors[0] = new ActivationDataFlavor(
                FastInfosetReflection.getFastInfosetSource_class(),
                "application/fastinfoset", "Fast Infoset");
        return flavors;
    }

    /**
     * Return the Transfer Data of type DataFlavor from InputStream
     * @param flavor The DataFlavor.
     * @param dataSource DataSource.
     * @return The constructed Object.
     * @exception IOException in case of an I/O error
     */
    @Override
    public Object getTransferData(DataFlavor flavor, DataSource dataSource)
        throws IOException
    {
        if (flavor.getMimeType().startsWith("application/fastinfoset")) {
            try {
                if (flavor.getRepresentationClass().getName().equals(STR_SRC)) {
                    return FastInfosetReflection.FastInfosetSource_new(
                        dataSource.getInputStream());
                }
            }
            catch (Exception e) {
                throw new IOException(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Object getContent(DataSource dataSource) throws IOException {
        try {
            return FastInfosetReflection.FastInfosetSource_new(
                dataSource.getInputStream());
        }
        catch (Exception e) {
            throw new IOException(e.getMessage());
        }
    }

    /**
     * Construct an object from a byte stream
     * (similar semantically to previous method, we are deciding
     *  which one to support)
     */
    @Override
    public void writeTo(Object obj, String mimeType, OutputStream os)
        throws IOException
    {
        if (!mimeType.equals("application/fastinfoset")) {
            throw new IOException("Invalid content type \"" + mimeType
                + "\" for FastInfosetDCH");
        }

        try {
            InputStream is = FastInfosetReflection.FastInfosetSource_getInputStream(
                (Source) obj);

            int n; byte[] buffer = new byte[4096];
            while ((n = is.read(buffer)) != -1) {
                os.write(buffer, 0, n);
            }
        }
        catch (Exception ex) {
            throw new IOException(
                "Error copying FI source to output stream " + ex.getMessage());
        }
    }
}
