/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.monitor;

public interface MonitoredHostService {

    /**
     * Construct a MonitoredHost instance to manage the
     * connection to the host indicated by {@code hostId}.
     *
     * @param hostId the identifier for the target host.
     * @return MonitoredHost - The MonitoredHost object needed to attach to
     *                         the target host.
     *
     * @throws MonitorException Thrown if monitoring errors occur.
     */
    public MonitoredHost getMonitoredHost(HostIdentifier hostId) throws MonitorException;

    /**
     * Get the scheme that this service supports.
     *
     * @return scheme name
     */
    public String getScheme();
}
