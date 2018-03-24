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

package sun.jvmstat.monitor.event;

import java.util.EventListener;

/**
 * Interface for listeners of MonitoredHost events.
 *
 * @author Brian Doherty
 * @since 1.5
 * @see sun.jvmstat.monitor.MonitoredHost
 */
public interface HostListener extends EventListener {

    /**
     * Invoked when the status of Java Virtual Machine changes.
     *
     * @param event the object describing the event.
     */
    void vmStatusChanged(VmStatusChangeEvent event);

    /**
     * Invoked when the connection to the MonitoredHost has disconnected
     * due to communication errors.
     *
     * @param event the object describing the event.
     */
    void disconnected(HostEvent event);
}
