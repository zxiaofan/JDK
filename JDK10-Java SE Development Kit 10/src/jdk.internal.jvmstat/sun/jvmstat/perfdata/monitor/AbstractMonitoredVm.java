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

package sun.jvmstat.perfdata.monitor;

import java.util.List;

import sun.jvmstat.monitor.*;
import sun.jvmstat.monitor.event.VmListener;

/**
 * Base class for all MonitoredVm implementations that utilize the
 * HotSpot PerfData instrumentation buffer as the communications
 * mechanism to the target Java Virtual Machine.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public abstract class AbstractMonitoredVm implements BufferedMonitoredVm {

    /**
     * The VmIdentifier for the target.
     */
    protected VmIdentifier vmid;

    /**
     * The shared memory instrumentation buffer for the target.
     */
    protected AbstractPerfDataBuffer pdb;

    /**
     * The sampling interval, if the instrumentation buffer is acquired
     * by sampling instead of shared memory mechanisms.
     */
    protected int interval;

    /**
     * Create an AbstractMonitoredVm instance.
     *
     * @param vmid the VmIdentifier for the target
     * @param interval the initial sampling interval
     */
    public AbstractMonitoredVm(VmIdentifier vmid, int interval)
           throws MonitorException {
        this.vmid = vmid;
        this.interval = interval;
    }

    /**
     * {@inheritDoc}
     */
    public VmIdentifier getVmIdentifier() {
        return vmid;
    }

    /**
     * {@inheritDoc}
     */
    public Monitor findByName(String name) throws MonitorException {
        return pdb.findByName(name);
    }

    /**
     * {@inheritDoc}
     */
    public List<Monitor> findByPattern(String patternString) throws MonitorException {
        return pdb.findByPattern(patternString);
    }

    /**
     * {@inheritDoc}
     */
    public void detach() {
        /*
         * no default action required because the detach operation for the
         * native byte buffer is managed by the Perf class.
         */
    }


    /* ---- Methods to support polled MonitoredVm Implementations ----- */

    /**
     * {@inheritDoc}
     */
    public void setInterval(int interval) {
        this.interval = interval;
    }

    /**
     * {@inheritDoc}
     */
    public int getInterval() {
        return interval;
    }

    /**
     * {@inheritDoc}
     */
    public void setLastException(Exception e) {
        // XXX: implement
    }

    /**
     * {@inheritDoc}
     */
    public Exception getLastException() {
        // XXX: implement
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public void clearLastException() {
        // XXX: implement
    }

    /**
     * {@inheritDoc}
     */
    public boolean isErrored() {
        // XXX: implement
        return false;
    }

    /**
     * Get a list of the inserted and removed monitors since last called.
     *
     * @return MonitorStatus - the status of available Monitors for the
     *                         target Java Virtual Machine.
     * @throws MonitorException Thrown if communications errors occur
     *                          while communicating with the target.
     */
    public MonitorStatus getMonitorStatus() throws MonitorException {
        return pdb.getMonitorStatus();
    }


    /* --------------- Methods to support VmListeners ----------------- */

    /**
     * {@inheritDoc}
     */
    public abstract void addVmListener(VmListener l);

    /**
     * {@inheritDoc}
     */
    public abstract void removeVmListener(VmListener l);


    /* ---- Methods to support BufferedMonitoredVm Implementations ---- */

    /**
     * {@inheritDoc}
     */
    public byte[] getBytes() {
        return pdb.getBytes();
    }

    /**
     * {@inheritDoc}
     */
    public int getCapacity() {
        return pdb.getCapacity();
    }
}
