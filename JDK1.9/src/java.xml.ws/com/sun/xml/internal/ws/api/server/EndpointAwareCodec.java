/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.api.server;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.pipe.Codec;

/**
 * Implemented by {@link Codec}s that want to have access to
 * {@link WSEndpoint} object.
 *
 * @author Kohsuke Kawaguchi
 * @since 2.1.1
 */
public interface EndpointAwareCodec extends Codec {
    /**
     * Called by the {@link WSEndpoint} implementation
     * when the codec is associated with an endpoint.
     */
    void setEndpoint(@NotNull WSEndpoint endpoint);
}
