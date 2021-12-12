/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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
import sun.jvmstat.monitor.event.VmListener;
import sun.jvmstat.perfdata.monitor.*;
import java.util.List;
import java.lang.reflect.*;
import java.io.*;

/**
 * Concrete implementation of the AbstractMonitoredVm class for the
 * <em>file:</em> protocol for the HotSpot PerfData monitoring implementation.
 * <p>
 * This class provides the ability to attach to the instrumentation buffer
 * (saved or live) of a target Java Virtual Machine by providing a
 * <em>file</em> URI to a file containing the instrmentation buffer data.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class FileMonitoredVm extends AbstractMonitoredVm {

    /**
     * Create a FileMonitoredVm instance.
     *
     * @param vmid the vm identifier referring to the file
     * @param interval sampling interval (unused in this protocol).
     */
    public FileMonitoredVm(VmIdentifier vmid, int interval)
           throws MonitorException {
        super(vmid, interval);
        this.pdb = new PerfDataBuffer(vmid);
    }

    /**
     * {@inheritDoc}.
     *<p>
     * Note - the <em>file:</em> protocol currently does not support
     * the registration or notification of listeners.
     */
    public void addVmListener(VmListener l) { }

    /**
     * {@inheritDoc}.
     *<p>
     * Note - the <em>file:</em> protocol currently does not support
     * the registration or notification of listeners.
     */
    public void removeVmListener(VmListener l) { }
}
