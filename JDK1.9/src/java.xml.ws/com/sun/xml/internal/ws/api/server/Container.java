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

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import com.sun.istack.internal.NotNull;
import com.sun.xml.internal.ws.api.Component;
import com.sun.xml.internal.ws.api.ComponentEx;
import com.sun.xml.internal.ws.api.ComponentRegistry;

/**
 * Root of the SPI implemented by the container
 * (such as application server.)
 *
 * <p>
 * Often technologies that are built on top of JAX-WS
 * (such as Tango) needs to negotiate private contracts between
 * them and the container. This interface allows such technologies
 * to query the negotiated SPI by using the {@link #getSPI(Class)}.
 *
 * <p>
 * For example, if a security pipe needs to get some information
 * from a container, they can do the following:
 * <ol>
 *  <li>Negotiate an interface with the container and define it.
 *      (let's call it {@code ContainerSecuritySPI}.)
 *  <li>The container will implement {@code ContainerSecuritySPI}.
 *  <li>At the runtime, a security pipe gets
 *      {@link WSEndpoint} and then to {@link Container}.
 *  <li>It calls {@code container.getSPI(ContainerSecuritySPI.class)}
 *  <li>The container returns an instance of {@code ContainerSecuritySPI}.
 *  <li>The security pipe talks to the container through this SPI.
 * </ol>
 *
 * <p>
 * This protects JAX-WS from worrying about the details of such contracts,
 * while still providing the necessary service of hooking up those parties.
 *
 * <p>
 * Technologies that run inside JAX-WS server runtime can access this object through
 * {@link WSEndpoint#getContainer()}. In the client runtime, it can be accessed from
 * {@link ContainerResolver#getContainer()}
 *
 * @author Kohsuke Kawaguchi
 * @see WSEndpoint
 */
public abstract class Container implements ComponentRegistry, ComponentEx {
        private final Set<Component> components = new CopyOnWriteArraySet<Component>();

    /**
     * For derived classes.
     */
    protected Container() {
    }

    /**
     * Constant that represents a "no {@link Container}",
     * which always returns null from {@link #getSPI(Class)}.
     */
    public static final Container NONE = new NoneContainer();

    private static final class NoneContainer extends Container {
    }

    public <S> S getSPI(Class<S> spiType) {
        if (components == null) return null;
        for (Component c : components) {
                S s = c.getSPI(spiType);
                if (s != null)
                        return s;
        }
        return null;
    }

        public Set<Component> getComponents() {
                return components;
        }

        public @NotNull <E> Iterable<E> getIterableSPI(Class<E> spiType) {
        E item = getSPI(spiType);
        if (item != null) {
                Collection<E> c = Collections.singletonList(item);
                return c;
        }
        return Collections.emptySet();
    }
}
