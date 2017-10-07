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
import com.sun.xml.internal.ws.api.pipe.Pipe;
import com.sun.xml.internal.ws.api.pipe.ServerPipeAssemblerContext;
import com.sun.xml.internal.ws.api.pipe.helper.AbstractFilterPipeImpl;

/**
 * Allow the container (primarily Glassfish) to inject
 * their own pipes into the pipeline.
 *
 * <p>
 * This interface has a rather ad-hoc set of methods, because
 * we didn't want to define an autonomous pipe-assembly process.
 * (We thought this is a smaller evil compared to that.)
 *
 * <p>
 * JAX-WS obtains this through {@link Container#getSPI(Class)}.
 *
 * @author Kohsuke Kawaguchi
 */
public abstract class ServerPipelineHook {
    /**
     * Called during the pipeline construction process once to allow a container
     * to register a pipe for monitoring.
     *
     * This pipe will be injected to a point very close to the transport, allowing
     * it to measure the time it takes for processing as well as detecting errors.
     *
     * @param ctxt
     *      Represents abstraction of SEI, WSDL abstraction etc. Context can be used
     *      whether add a new pipe to the head or not.
     *
     * @param tail
     *      Head of the partially constructed pipeline. If the implementation
     *      wishes to add new pipes, it should do so by extending
     *      {@link AbstractFilterPipeImpl} and making sure that this {@link Pipe}
     *      eventually processes messages.
     *
     * @return
     *      The default implementation just returns {@code tail}, which means
     *      no additional pipe is inserted. If the implementation adds
     *      new pipes, return the new head pipe.
     */
    public @NotNull Pipe createMonitoringPipe(ServerPipeAssemblerContext ctxt, @NotNull Pipe tail) {
        return tail;
    }

    /**
     * Called during the pipeline construction process once to allow a container
     * to register a pipe for security.
     *
     * This pipe will be injected to a point very close to the transport, allowing
     * it to do some security operations.
     *
     * @param ctxt
     *      Represents abstraction of SEI, WSDL abstraction etc. Context can be used
     *      whether add a new pipe to the head or not.
     *
     * @param tail
     *      Head of the partially constructed pipeline. If the implementation
     *      wishes to add new pipes, it should do so by extending
     *      {@link AbstractFilterPipeImpl} and making sure that this {@link Pipe}
     *      eventually processes messages.
     *
     * @return
     *      The default implementation just returns {@code tail}, which means
     *      no additional pipe is inserted. If the implementation adds
     *      new pipes, return the new head pipe.
     */
    public @NotNull Pipe createSecurityPipe(ServerPipeAssemblerContext ctxt, @NotNull Pipe tail) {
        return tail;
    }
}
