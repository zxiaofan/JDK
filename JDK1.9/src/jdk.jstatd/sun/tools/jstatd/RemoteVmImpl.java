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

package sun.tools.jstatd;

import sun.jvmstat.monitor.*;
import sun.jvmstat.monitor.remote.*;

/**
 * Concrete implementation of the RemoteVm interface for the HotSpot PerfData
 * shared memory implementation of the jvmstat monitoring APIs. This class
 * providing remote access to the instrumentation exported by a local HotSpot
 * Java Virtual Machine. The instrumentation buffer is shipped in whole to
 * the remote machine, which is responsible for parsing and provide access
 * to the contained data.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class RemoteVmImpl implements RemoteVm {

    private BufferedMonitoredVm mvm;

    RemoteVmImpl(BufferedMonitoredVm mvm) {
        this.mvm = mvm;
    }

    public byte[] getBytes() {
        return mvm.getBytes();
    }

    public int getCapacity() {
        return mvm.getCapacity();
    }

    public void detach() {
        mvm.detach();
    }

    public int getLocalVmId() {
        return mvm.getVmIdentifier().getLocalVmId();
    }
}
