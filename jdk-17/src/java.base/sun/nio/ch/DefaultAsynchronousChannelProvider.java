/*
 * Copyright (c) 2008, 2009, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.channels.spi.AsynchronousChannelProvider;

/**
 * Creates this platform's default asynchronous channel provider
 */

public class DefaultAsynchronousChannelProvider {
    private DefaultAsynchronousChannelProvider() { }

    /**
     * Returns the default AsynchronousChannelProvider.
     */
    public static AsynchronousChannelProvider create() {
        return new WindowsAsynchronousChannelProvider();
    }
}
