/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.security.cert;

/**
 * Certificate is not yet valid exception. This is thrown whenever
 * the current <code>Date</code> or the specified <code>Date</code>
 * is before the <code>notBefore</code> date/time in the Certificate
 * validity period.
 *
 * @author Hemma Prafullchandra
 * %I%
 */
public class CertificateNotYetValidException extends CertificateException {

    static final long serialVersionUID = 4355919900041064702L;

    /**
     * Constructs a CertificateNotYetValidException with no detail message. A
     * detail message is a String that describes this particular
     * exception.
     */
    public CertificateNotYetValidException() {
        super();
    }

    /**
     * Constructs a CertificateNotYetValidException with the specified detail
     * message. A detail message is a String that describes this
     * particular exception.
     *   
     * @param message the detail message.
     */
    public CertificateNotYetValidException(String message) {
        super(message);
    }
}
