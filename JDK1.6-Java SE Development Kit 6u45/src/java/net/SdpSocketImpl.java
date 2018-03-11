/*
 * %W% %E%
 *
 * Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package java.net;

import java.io.IOException;
import java.io.FileDescriptor;

import sun.net.sdp.SdpSupport;
import sun.misc.SharedSecrets;

/**
 * SocketImpl that supports the SDP protocol
 */
class SdpSocketImpl extends PlainSocketImpl {
    SdpSocketImpl() { }

    @Override
    protected void create(boolean stream) throws IOException {
	if (!stream)
	    throw new UnsupportedOperationException("Must be a stream socket");
        fd = new FileDescriptor();
	int fdVal = SdpSupport.createSocket();
        // assume Unix
	SharedSecrets.getJavaIOFileDescriptorAccess().set(fd, fdVal);
	if (socket != null)
            socket.setCreated();
        if (serverSocket != null)
            serverSocket.setCreated();
    }
}
