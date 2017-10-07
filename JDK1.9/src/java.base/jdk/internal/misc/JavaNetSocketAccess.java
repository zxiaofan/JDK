/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.net.ServerSocket;
import java.net.SocketImpl;

public interface JavaNetSocketAccess {
    /**
     * Creates a ServerSocket associated with the given SocketImpl.
     */
    ServerSocket newServerSocket(SocketImpl impl);

    /*
     * Constructs a SocketImpl instance of the given class.
     */
    SocketImpl newSocketImpl(Class<? extends SocketImpl> implClass);
}
