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

package com.sun.xml.internal.ws.server;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.message.Packet;
import com.sun.xml.internal.ws.api.server.AbstractInstanceResolver;
import com.sun.xml.internal.ws.api.server.InstanceResolver;
import com.sun.xml.internal.ws.api.server.WSEndpoint;
import com.sun.xml.internal.ws.api.server.WSWebServiceContext;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * {@link InstanceResolver} that always returns a single instance.
 *
 * @author Kohsuke Kawaguchi
 */
public final class SingletonResolver<T> extends AbstractInstanceResolver<T> {
    private final @NotNull T singleton;

    public SingletonResolver(@NotNull T singleton) {
        this.singleton = singleton;
    }

    public @NotNull T resolve(Packet request) {
        return singleton;
    }

    public void start(WSWebServiceContext wsc, WSEndpoint endpoint) {
        getResourceInjector(endpoint).inject(wsc,singleton);
        // notify that we are ready to serve
        invokeMethod(findAnnotatedMethod(singleton.getClass(),PostConstruct.class),singleton);
    }

    public void dispose() {
        invokeMethod(findAnnotatedMethod(singleton.getClass(),PreDestroy.class),singleton);
    }
}
