/*
 * Copyright (c) 2009, Oracle and/or its affiliates. All rights reserved.
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

package sun.net;

import java.net.Proxy;
import java.net.SocketAddress;

/**
 * Proxy wrapper class so that we can determine application set
 * proxies by type.
 */
public final class ApplicationProxy extends Proxy {
    private ApplicationProxy(Proxy proxy) {
        super(proxy.type(), proxy.address());
    }

    public static ApplicationProxy create(Proxy proxy) {
        return new ApplicationProxy(proxy);
    }
}
