/*
 * Copyright (c) 1998, 2003, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.connect.*;
import com.sun.jdi.VirtualMachine;
import com.sun.jdi.VirtualMachineManager;
import java.io.IOException;

/**
 * VirtualMachineManager SPI
 */
public interface VirtualMachineManagerService extends VirtualMachineManager {
    /**
     * Replaces the default connector.
     *
     * @throws java.lang.IllegalArgumentException if the given
     * connector is not a member of the list returned by
     * {@link #launchingConnectors}
     *
     * @param connector the new default connector
     */
    void setDefaultConnector(LaunchingConnector connector);

    /**
     * Adds a connector to the list of known connectors.
     *
     * @param connector the connector to be added
     */
    void addConnector(Connector connector);

    /**
     * Removes a connector from the list of known connectors.
     *
     * @param connector the connector to be removed
     */
    void removeConnector(Connector connector);

}
