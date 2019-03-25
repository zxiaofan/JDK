/*
 * Copyright (c) 2004, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.monitor.event;

import java.util.EventObject;
import sun.jvmstat.monitor.MonitoredHost;

/**
 * Base class for events emitted by a {@link MonitoredHost}.
 *
 * @author Brian Doherty
 * @since 1.5
 */
@SuppressWarnings("serial") // JDK implementation class
public class HostEvent extends EventObject {

    /**
     * Construct a new HostEvent instance.
     *
     * @param host the MonitoredHost source of the event.
     */
    public HostEvent(MonitoredHost host) {
        super(host);
    }

    /**
     * Return the MonitoredHost source of this event.
     *
     * @return MonitoredHost - the source of this event.
     */
    public MonitoredHost getMonitoredHost() {
        return (MonitoredHost)source;
    }
}
