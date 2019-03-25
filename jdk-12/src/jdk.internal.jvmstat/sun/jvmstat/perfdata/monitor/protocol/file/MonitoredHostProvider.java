/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor.protocol.file;

import sun.jvmstat.monitor.*;
import sun.jvmstat.monitor.event.HostListener;
import sun.jvmstat.perfdata.monitor.*;
import java.util.*;
import java.net.*;

/**
 * Concrete implementation of the MonitoredHost interface for the
 * <em>file:</em> protocol of the HotSpot PerfData monitoring implementation.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class MonitoredHostProvider extends MonitoredHost {

    /**
     * The default polling interval. Not used by the <em>file:</em> protocol.
     */
    public static final int DEFAULT_POLLING_INTERVAL = 0;

    /**
     * Create a MonitoredHostProvider instance using the given HostIdentifier.
     *
     * @param hostId the host identifier for this MonitoredHost
     */
    public MonitoredHostProvider(HostIdentifier hostId) {
        this.hostId = hostId;
    }

    /**
     * {@inheritDoc}
     */
    public MonitoredVm getMonitoredVm(VmIdentifier vmid)
                       throws MonitorException {
        return getMonitoredVm(vmid, DEFAULT_POLLING_INTERVAL);
    }

    /**
     * {@inheritDoc}.
     * <p>
     * Note - the <em>file:</em> protocol silently ignores the
     * {@code interval} parameter.
     */
    public MonitoredVm getMonitoredVm(VmIdentifier vmid, int interval)
                       throws MonitorException {
        // don't attempt to resolve 'file:' based vmid
        return new FileMonitoredVm(vmid, interval);
    }

    /**
     * {@inheritDoc}
     */
    public void detach(MonitoredVm vm) {
        vm.detach();
    }

    /**
     * {@inheritDoc}.
     * <p>
     * Note - the <em>file:</em> protocol currenly does not support
     * registration or notification of event listeners. This method
     * silently ignores the add request.
     */
    public void addHostListener(HostListener listener) {
        // no HostListener support for 'file:' based VmIdentifiers
    }

    /**
     * {@inheritDoc}.
     * <p>
     * Note - the <em>file:</em> protocol currenly does not support
     * registration or notification of event listeners. This method
     * silently ignores the remove request.
     */
    public void removeHostListener(HostListener listener) {
        // no HostListener support for 'file:' based VmIdentifiers
    }

    /**
     * {@inheritDoc}.
     * <p>
     * Note - the <em>file:</em> protocol currently does not support the
     * notion of tracking active or inactive Java Virtual Machines. This
     * method currently returns an empty set.
     */
    public Set<Integer> activeVms() {
        return new HashSet<Integer>(0);
    }
}
