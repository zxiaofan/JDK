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
import java.io.*;

import javax.activation.*;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.MimeUtility;
import com.sun.xml.internal.messaging.saaj.packaging.mime.internet.ContentType;

/**
 * JAF data content handler for text/plain --&gt; String
 *
 */
public class StringDataContentHandler implements DataContentHandler {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(
        java.lang.String.class,
        "text/plain",
        "Text String");

    protected ActivationDataFlavor getDF() {
        return myDF;
    }

    /**
     * Return the DataFlavors for this <code>DataContentHandler</code>.
     *
     * @return The DataFlavors
     */
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return new DataFlavor[] { getDF() };
    }

    /**
     * Return the Transfer Data of type DataFlavor from InputStream.
     *
     * @param df The DataFlavor
     * @param ds The DataSource corresponding to the data
     * @return String object
     */
    @Override
    public Object getTransferData(DataFlavor df, DataSource ds)
                        throws IOException {
        // use myDF.equals to be sure to get ActivationDataFlavor.equals,
        // which properly ignores Content-Type parameters in comparison
        if (getDF().equals(df))
            return getContent(ds);
        else
            return null;
    }

    @Override
    public Object getContent(DataSource ds) throws IOException {
        String enc = null;
        InputStreamReader is = null;

        try {
            enc = getCharset(ds.getContentType());
            is = new InputStreamReader(ds.getInputStream(), enc);
        } catch (IllegalArgumentException iex) {
            /*
             * An unknown charset of the form ISO-XXX-XXX will cause
             * the JDK to throw an IllegalArgumentException.  The
             * JDK will attempt to create a classname using this string,
             * but valid classnames must not contain the character '-',
             * and this results in an IllegalArgumentException, rather than
             * the expected UnsupportedEncodingException.  Yikes.
             */
            throw new UnsupportedEncodingException(enc);
        }

        try {
            int pos = 0;
            int count;
            char buf[] = new char[1024];

            while ((count = is.read(buf, pos, buf.length - pos)) != -1) {
                pos += count;
                if (pos >= buf.length) {
                    int size = buf.length;
                    if (size < 256*1024)
                        size += size;
                    else
                        size += 256*1024;
                    char tbuf[] = new char[size];
                    System.arraycopy(buf, 0, tbuf, 0, pos);
                    buf = tbuf;
                }
            }
            return new String(buf, 0, pos);
        } finally {
            try {
                is.close();
            } catch (IOException ex) { }
        }
    }

    /**
     * Write the object to the output stream, using the specified MIME type.
     */
    @Override
    public void writeTo(Object obj, String type, OutputStream os)
                        throws IOException {
        if (!(obj instanceof String))
            throw new IOException("\"" + getDF().getMimeType() +
                "\" DataContentHandler requires String object, " +
                "was given object of type " + obj.getClass().toString());

        String enc = null;
        OutputStreamWriter osw = null;

        try {
            enc = getCharset(type);
            osw = new OutputStreamWriter(os, enc);
        } catch (IllegalArgumentException iex) {
            /*
             * An unknown charset of the form ISO-XXX-XXX will cause
             * the JDK to throw an IllegalArgumentException.  The
             * JDK will attempt to create a classname using this string,
             * but valid classnames must not contain the character '-',
             * and this results in an IllegalArgumentException, rather than
             * the expected UnsupportedEncodingException.  Yikes.
             */
            throw new UnsupportedEncodingException(enc);
        }

        String s = (String)obj;
        osw.write(s, 0, s.length());
        osw.flush();
    }

    private String getCharset(String type) {
        try {
            ContentType ct = new ContentType(type);
            String charset = ct.getParameter("charset");
            if (charset == null)
                // If the charset parameter is absent, use US-ASCII.
                charset = "us-ascii";
            return MimeUtility.javaCharset(charset);
        } catch (Exception ex) {
            return null;
        }
    }

}
