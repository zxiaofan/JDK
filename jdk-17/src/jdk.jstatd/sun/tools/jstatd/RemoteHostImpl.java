/*
 * Copyright (c) 2004, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jstatd;

import java.util.*;
import java.nio.*;
import java.io.*;
import java.net.*;
import java.rmi.*;
import java.rmi.server.*;
import sun.jvmstat.monitor.*;
import sun.jvmstat.monitor.event.*;
import sun.jvmstat.monitor.remote.*;

/**
 * Concrete implementation of the RemoteHost interface for the HotSpot
 * PerfData <em>rmi:</em> protocol.
 * <p>
 * This class provides remote access to the instrumentation exported
 * by HotSpot Java Virtual Machines through the PerfData shared memory
 * interface.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class RemoteHostImpl implements RemoteHost, HostListener {

    private MonitoredHost monitoredHost;
    private Set<Integer> activeVms;
    private static RemoteVm rvm;
    private final int rmiPort;

    public RemoteHostImpl() throws MonitorException {
        this(0);
    }

    public RemoteHostImpl(int rmiPort) throws MonitorException {
        this.rmiPort = rmiPort;
        try {
            monitoredHost = MonitoredHost.getMonitoredHost("localhost");
        } catch (URISyntaxException e) { }

        activeVms = monitoredHost.activeVms();
        monitoredHost.addHostListener(this);
    }

    public RemoteVm attachVm(int lvmid, String mode)
                    throws RemoteException, MonitorException {
        Integer v = lvmid;
        RemoteVm stub = null;
        StringBuilder sb = new StringBuilder();

        sb.append("local://").append(lvmid).append("@localhost");
        if (mode != null) {
            sb.append("?mode=").append(mode);
        }

        String vmidStr = sb.toString();

        try {
            VmIdentifier vmid = new VmIdentifier(vmidStr);
            MonitoredVm mvm = monitoredHost.getMonitoredVm(vmid);
            rvm = new RemoteVmImpl((BufferedMonitoredVm)mvm);
            stub = (RemoteVm) UnicastRemoteObject.exportObject(rvm, rmiPort);
        }
        catch (URISyntaxException e) {
            throw new RuntimeException("Malformed VmIdentifier URI: "
                                       + vmidStr, e);
        }
        return stub;
    }

    public void detachVm(RemoteVm rvm) throws RemoteException {
        rvm.detach();
    }

    public int[] activeVms() throws MonitorException {
        Object[] vms = null;
        int[] vmids = null;

        vms = monitoredHost.activeVms().toArray();
        vmids = new int[vms.length];

        for (int i = 0; i < vmids.length; i++) {
            vmids[i] = ((Integer)vms[i]).intValue();
        }
        return vmids;
    }

    public void vmStatusChanged(VmStatusChangeEvent ev) {
        synchronized(this.activeVms) {
            activeVms.retainAll(ev.getActive());
        }
    }

    public void disconnected(HostEvent ev) {
        // we only monitor the local host, so this event shouldn't occur.
    }
}
