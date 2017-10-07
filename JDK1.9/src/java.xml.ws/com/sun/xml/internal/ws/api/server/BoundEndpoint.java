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
import com.sun.xml.internal.ws.api.Component;

import java.net.URI;

/**
 * Represents the {@link WSEndpoint} bound to a particular transport.
 *
 * @see Module#getBoundEndpoints()
 * @author Kohsuke Kawaguchi
 */
public interface BoundEndpoint extends Component {
    /**
     * The endpoint that was bound.
     *
     * <p>
     * Multiple {@link BoundEndpoint}s may point to the same {@link WSEndpoint},
     * if it's bound to multiple transports.
     *
     * @return the endpoint
     */
    @NotNull WSEndpoint getEndpoint();

    /**
     * The address of the bound endpoint.
     *
     * <p>
     * For example, if this endpoint is bound to a servlet endpoint
     * "http://foobar/myapp/myservice", then this method should
     * return that address.
     *
     * @return address of the endpoint
     */
    @NotNull URI getAddress();

    /**
     * The address of the bound endpoint using the base address. Often
     * times, baseAddress is only avaialble during the request.
     *
     * <p>
     * If the endpoint is bound to a servlet endpoint, the base address
     * won't include the url-pattern, so the base address would be
     * "http://host:port/context". This method would include url-pattern
     * for the endpoint and return that address
     * for e.g. "http://host:port/context/url-pattern"
     *
     * @param baseAddress that is used in computing the full address
     * @return address of the endpoint
     */
    @NotNull URI getAddress(String baseAddress);
}
