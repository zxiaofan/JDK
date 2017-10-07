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

/**
 * Created on Nov 19, 2002
 *
 * To change this generated comment edit the template variable "filecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of file comments go to
 * Window>Preferences>Java>Code Generation.
 */
package com.sun.xml.internal.messaging.saaj.soap;

import java.io.*;

import com.sun.xml.internal.messaging.saaj.SOAPExceptionImpl;

public class SOAPIOException extends IOException {
    SOAPExceptionImpl soapException;

    public SOAPIOException() {
        super();
        soapException = new SOAPExceptionImpl();
        soapException.fillInStackTrace();
    }

    public SOAPIOException(String s) {
        super();
        soapException = new SOAPExceptionImpl(s);
        soapException.fillInStackTrace();
    }

    public SOAPIOException(String reason, Throwable cause) {
        super();
        soapException = new SOAPExceptionImpl(reason, cause);
        soapException.fillInStackTrace();
    }

    public SOAPIOException(Throwable cause) {
        super(cause.toString());
        soapException = new SOAPExceptionImpl(cause);
        soapException.fillInStackTrace();
    }

    @Override
    public Throwable fillInStackTrace() {
        if (soapException != null) {
            soapException.fillInStackTrace();
        }
        return this;
    }

    @Override
    public String getLocalizedMessage() {
        return soapException.getLocalizedMessage();
    }

    @Override
    public String getMessage() {
        return soapException.getMessage();
    }

    @Override
    public void printStackTrace() {
        soapException.printStackTrace();
    }

    @Override
    public void printStackTrace(PrintStream s) {
        soapException.printStackTrace(s);
    }

    @Override
    public void printStackTrace(PrintWriter s) {
        soapException.printStackTrace(s);
    }

    @Override
    public String toString() {
        return soapException.toString();
    }

}
