/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.ch;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketImpl;
import java.net.SocketOption;
import java.util.Set;

/**
 * Dummy SocketImpl for use by the socket adaptors. All methods are overridden
 * to throw an error.
 */

class DummySocketImpl extends SocketImpl {
    private DummySocketImpl() { }

    static SocketImpl create() {
        return new DummySocketImpl();
    }

    private static <T> T shouldNotGetHere() {
        throw new InternalError("Should not get here");
    }

    @Override
    protected void create(boolean stream) {
        shouldNotGetHere();
    }

    @Override
    protected void connect(SocketAddress remote, int millis) {
        shouldNotGetHere();
    }

    @Override
    protected void connect(String host, int port) {
        shouldNotGetHere();
    }

    @Override
    protected void connect(InetAddress address, int port) {
        shouldNotGetHere();
    }

    @Override
    protected void bind(InetAddress host, int port) {
        shouldNotGetHere();
    }

    @Override
    protected void listen(int backlog) {
        shouldNotGetHere();
    }

    @Override
    protected void accept(SocketImpl si) {
        shouldNotGetHere();
    }

    @Override
    protected InputStream getInputStream() {
        return shouldNotGetHere();
    }
    @Override
    protected OutputStream getOutputStream() {
        return shouldNotGetHere();
    }
    @Override
    protected int available() {
        return shouldNotGetHere();
    }

    @Override
    protected void close() {
        shouldNotGetHere();
    }

    @Override
    protected Set<SocketOption<?>> supportedOptions() {
        return shouldNotGetHere();
    }

    @Override
    protected <T> void setOption(SocketOption<T> opt, T value) {
        shouldNotGetHere();
    }

    @Override
    protected <T> T getOption(SocketOption<T> opt) {
        return shouldNotGetHere();
    }

    @Override
    public void setOption(int opt, Object value) {
        shouldNotGetHere();
    }

    @Override
    public Object getOption(int opt) {
        return shouldNotGetHere();
    }

    @Override
    protected void shutdownInput() {
        shouldNotGetHere();
    }

    @Override
    protected void shutdownOutput() {
        shouldNotGetHere();
    }

    @Override
    protected boolean supportsUrgentData() {
        return shouldNotGetHere();
    }

    @Override
    protected void sendUrgentData(int data) {
        shouldNotGetHere();
    }
}
