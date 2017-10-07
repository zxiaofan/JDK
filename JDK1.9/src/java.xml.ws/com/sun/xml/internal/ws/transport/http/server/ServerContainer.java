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

package com.sun.xml.internal.ws.transport.http.server;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.server.BoundEndpoint;
import com.sun.xml.internal.ws.api.server.Container;
import com.sun.xml.internal.ws.api.server.Module;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jitendra Kotamraju
 */
class ServerContainer extends Container {

    private final Module module = new Module() {
        private final List<BoundEndpoint> endpoints = new ArrayList<BoundEndpoint>();

        public @NotNull List<BoundEndpoint> getBoundEndpoints() {
            return endpoints;
        }
    };

    public <T> T getSPI(Class<T> spiType) {
        T t = super.getSPI(spiType);
        if (t != null)
            return t;
        if (spiType == Module.class) {
            return spiType.cast(module);
        }
        return null;
    }

}
