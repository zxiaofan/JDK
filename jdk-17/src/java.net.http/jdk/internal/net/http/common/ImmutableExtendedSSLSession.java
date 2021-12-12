/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.common;

import java.security.Principal;
import java.util.List;
import javax.net.ssl.SSLSession;
import javax.net.ssl.ExtendedSSLSession;
import javax.net.ssl.SSLSessionContext;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SNIServerName;

/**
 * All mutating methods throw UnsupportedOperationException
 */
public class ImmutableExtendedSSLSession extends ExtendedSSLSession {
    private final ExtendedSSLSession delegate;

    ImmutableExtendedSSLSession(ExtendedSSLSession session) {
        this.delegate = session;
    }

    public byte[] getId() {
        return delegate.getId();
    }

    public SSLSessionContext getSessionContext() {
        return delegate.getSessionContext();
    }

    public long getCreationTime() {
        return delegate.getCreationTime();
    }

    public long getLastAccessedTime() {
        return delegate.getLastAccessedTime();
    }

    public void invalidate() {
        throw new UnsupportedOperationException("session is not mutable");
    }

    public boolean isValid() {
        return delegate.isValid();
    }

    public void putValue(String name, Object value) {
        throw new UnsupportedOperationException("session is not mutable");
    }

    public Object getValue(String name) {
        return delegate.getValue(name);
    }

    public void removeValue(String name) {
        throw new UnsupportedOperationException("session is not mutable");
    }

    public String [] getValueNames() {
        return delegate.getValueNames();
    }

    public java.security.cert.Certificate [] getPeerCertificates()
            throws SSLPeerUnverifiedException {
        return delegate.getPeerCertificates();
    }

    public java.security.cert.Certificate [] getLocalCertificates() {
        return delegate.getLocalCertificates();
    }

    public Principal getPeerPrincipal()
            throws SSLPeerUnverifiedException {
        return delegate.getPeerPrincipal();
    }

    public Principal getLocalPrincipal() {
        return delegate.getLocalPrincipal();
    }

    public String getCipherSuite() {
        return delegate.getCipherSuite();
    }

    public String getProtocol() {
        return delegate.getProtocol();
    }

    public String getPeerHost() {
        return delegate.getPeerHost();
    }

    public int getPeerPort() {
        return delegate.getPeerPort();
    }

    public int getPacketBufferSize() {
        return delegate.getPacketBufferSize();
    }

    public int getApplicationBufferSize() {
        return delegate.getApplicationBufferSize();
    }

    public String[] getLocalSupportedSignatureAlgorithms() {
        return delegate.getLocalSupportedSignatureAlgorithms();
    }

    public String[] getPeerSupportedSignatureAlgorithms() {
        return delegate.getPeerSupportedSignatureAlgorithms();
    }

    public List<SNIServerName> getRequestedServerNames()  {
        return delegate.getRequestedServerNames();
    }

    public List<byte[]> getStatusResponses() {
        return delegate.getStatusResponses();
    }
}
