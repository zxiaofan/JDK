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

import java.util.concurrent.Executor;

/**
 * ContainerResolver based on {@link ThreadLocal}.
 * <p>
 * The ThreadLocalContainerResolver is the default implementation available
 * from the ContainerResolver using {@link ContainerResolver#getDefault()}.  Code
 * sections that run with a Container must use the following pattern:
 * <pre>
 *   public void m() {
 *     Container old = ContainerResolver.getDefault().enterContainer(myContainer);
 *     try {
 *       // ... method body
 *     } finally {
 *       ContainerResolver.getDefault().exitContainer(old);
 *     }
 *   }
 * </pre>
 * @since 2.2.7
 */
public class ThreadLocalContainerResolver extends ContainerResolver {
    private ThreadLocal<Container> containerThreadLocal = new ThreadLocal<Container>() {
        @Override
        protected Container initialValue() {
            return Container.NONE;
        }
    };

    public Container getContainer() {
        return containerThreadLocal.get();
    }

    /**
     * Enters container
     * @param container Container to set
     * @return Previous container; must be remembered and passed to exitContainer
     */
    public Container enterContainer(Container container) {
        Container old = containerThreadLocal.get();
        containerThreadLocal.set(container);
        return old;
    }

    /**
     * Exits container
     * @param old Container returned from enterContainer
     */
    public void exitContainer(Container old) {
        containerThreadLocal.set(old);
    }

    /**
     * Used by {@link com.sun.xml.internal.ws.api.pipe.Engine} to wrap asynchronous {@link com.sun.xml.internal.ws.api.pipe.Fiber} executions
     * @param container Container
     * @param ex Executor to wrap
     * @return an Executor that will set the container during executions of Runnables
     */
    public Executor wrapExecutor(final Container container, final Executor ex) {
        if (ex == null)
            return null;

        return new Executor() {
            @Override
            public void execute(final Runnable command) {
                ex.execute(new Runnable() {
                    @Override
                    public void run() {
                        Container old = enterContainer(container);
                        try {
                            command.run();
                        } finally {
                            exitContainer(old);
                        }
                    }
                });
            }
        };
    }
}
