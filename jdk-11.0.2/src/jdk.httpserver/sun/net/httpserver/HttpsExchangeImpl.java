/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.httpserver;

import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.net.*;
import javax.net.ssl.*;
import java.util.*;
import com.sun.net.httpserver.*;
import com.sun.net.httpserver.spi.*;

class HttpsExchangeImpl extends HttpsExchange {

    ExchangeImpl impl;

    HttpsExchangeImpl (ExchangeImpl impl) throws IOException {
        this.impl = impl;
    }

    public Headers getRequestHeaders () {
        return impl.getRequestHeaders();
    }

    public Headers getResponseHeaders () {
        return impl.getResponseHeaders();
    }

    public URI getRequestURI () {
        return impl.getRequestURI();
    }

    public String getRequestMethod (){
        return impl.getRequestMethod();
    }

    public HttpContextImpl getHttpContext (){
        return impl.getHttpContext();
    }

    public void close () {
        impl.close();
    }

    public InputStream getRequestBody () {
        return impl.getRequestBody();
    }

    public int getResponseCode () {
        return impl.getResponseCode();
    }

    public OutputStream getResponseBody () {
        return impl.getResponseBody();
    }


    public void sendResponseHeaders (int rCode, long contentLen)
    throws IOException
    {
        impl.sendResponseHeaders (rCode, contentLen);
    }

    public InetSocketAddress getRemoteAddress (){
        return impl.getRemoteAddress();
    }

    public InetSocketAddress getLocalAddress (){
        return impl.getLocalAddress();
    }

    public String getProtocol (){
        return impl.getProtocol();
    }

    public SSLSession getSSLSession () {
        return impl.getSSLSession ();
    }

    public Object getAttribute (String name) {
        return impl.getAttribute (name);
    }

    public void setAttribute (String name, Object value) {
        impl.setAttribute (name, value);
    }

    public void setStreams (InputStream i, OutputStream o) {
        impl.setStreams (i, o);
    }

    public HttpPrincipal getPrincipal () {
        return impl.getPrincipal();
    }

    ExchangeImpl getExchangeImpl () {
        return impl;
    }
}
