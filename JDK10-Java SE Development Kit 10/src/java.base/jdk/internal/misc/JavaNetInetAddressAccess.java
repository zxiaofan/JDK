/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

import java.net.InetAddress;
import java.net.UnknownHostException;

public interface JavaNetInetAddressAccess {
    /**
     * Return the original application specified hostname of
     * the given InetAddress object.
     */
    String getOriginalHostName(InetAddress ia);

    /**
     * Get the InetAddress of the provided host. If an InetAddress is provided
     * then it will be the default address returned for all calls to either
     * form of getByName. This is required to maintain consistency when
     * caching addresses and hostnames.
     */
    InetAddress getByName(String hostName, InetAddress hostAddress)
            throws UnknownHostException;
}
