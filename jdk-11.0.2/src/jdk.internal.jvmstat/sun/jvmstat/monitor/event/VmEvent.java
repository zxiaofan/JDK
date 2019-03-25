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
import sun.jvmstat.monitor.MonitoredVm;

/**
 * Base class for events emitted by a {@link MonitoredVm}.
 *
 * @author Brian Doherty
 * @since 1.5
 */
@SuppressWarnings("serial") // JDK implementation class
public class VmEvent extends EventObject {

    /**
     * Construct a new VmEvent instance.
     *
     * @param vm the MonitoredVm source of the event.
     */
    public VmEvent(MonitoredVm vm) {
        super(vm);
    }

    /**
     * Return the MonitoredVm source of this event.
     *
     * @return MonitoredVm - the source of this event.
     */
    public MonitoredVm getMonitoredVm() {
      return (MonitoredVm)source;
    }
}
