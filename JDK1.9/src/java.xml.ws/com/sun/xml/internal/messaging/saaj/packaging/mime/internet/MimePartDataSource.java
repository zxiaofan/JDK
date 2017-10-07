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

/*
 * @(#)MimePartDataSource.java        1.9 02/03/27
 */


package com.sun.xml.internal.messaging.saaj.packaging.mime.internet;

import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;

import javax.activation.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.UnknownServiceException;

/**
 * A utility class that implements a DataSource out of
 * a MimeBodyPart. This class is primarily meant for service providers.
 *
 * @author John Mani
 */

public final class MimePartDataSource implements DataSource {
    private final MimeBodyPart part;

    /**
     * Constructor, that constructs a DataSource from a MimeBodyPart.
     *
     * @param part body part
     */
    public MimePartDataSource(MimeBodyPart part) {
        this.part = part;
    }

    /**
     * Returns an input stream from this  MimeBodyPart. <p>
     *
     * This method applies the appropriate transfer-decoding, based
     * on the Content-Transfer-Encoding attribute of this MimeBodyPart.
     * Thus the returned input stream is a decoded stream of bytes.<p>
     *
     * This implementation obtains the raw content from the MimeBodyPart
     * using the <code>getContentStream()</code> method and decodes
     * it using the <code>MimeUtility.decode()</code> method.
     *
     * @return decoded input stream
     */
    @Override
    public InputStream getInputStream() throws IOException {

        try {
            InputStream is = part.getContentStream();

            String encoding = part.getEncoding();
            if (encoding != null)
                return MimeUtility.decode(is, encoding);
            else
                return is;
        } catch (MessagingException mex) {
            throw new IOException(mex.getMessage());
        }
    }

    /**
     * DataSource method to return an output stream. <p>
     *
     * This implementation throws the UnknownServiceException.
     */
    @Override
    public OutputStream getOutputStream() throws IOException {
        throw new UnknownServiceException();
    }

    /**
     * Returns the content-type of this DataSource. <p>
     *
     * This implementation just invokes the <code>getContentType</code>
     * method on the MimeBodyPart.
     */
    @Override
    public String getContentType() {
        return part.getContentType();
    }

    /**
     * DataSource method to return a name.  <p>
     *
     * This implementation just returns an empty string.
     */
    @Override
    public String getName() {
        try {
            return part.getFileName();
        } catch (MessagingException mex) {
            return "";
        }
    }
}
