/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.agent.spi;

import java.util.Properties;

/**
 * Service interface for management agent
 */
public abstract class AgentProvider {

    /**
     * Instantiates a new AgentProvider.
     *
     * @throws SecurityException if the subclass (and calling code) does not
     * have
     * {@code RuntimePermission("sun.management.spi.AgentProvider.subclass")}
     */
    protected AgentProvider() {
        this(checkSubclassPermission());
    }

    private AgentProvider(Void unused) {
    }

    private static Void checkSubclassPermission() {
        @SuppressWarnings("removal")
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new RuntimePermission(AgentProvider.class.getName() + ".subclass"));
        }
        return null;
    }

    /**
     * Gets the name of the agent provider.
     *
     * @return name of agent provider
     */
    public abstract String getName();

    /**
     * Initializes and starts the agent.
     *
     * @throws IllegalStateException if this agent has already been started.
     */
    public abstract void startAgent();

    /**
     * Initializes and starts the agent at given port and with given properties
     *
     * @param props environment variables for agent
     *
     * @throws IllegalStateException if this agent has already been started.
     */
    public abstract void startAgent(Properties props);

    /**
     * Checks if agent is started and not terminated.
     *
     * @return true if agent is running, false otherwise.
     */
    public abstract boolean isActive();

    /**
     * Stops this agent.
     *
     * @throws IllegalStateException if this agent is not started.
     */
    public abstract void stopAgent();
}
