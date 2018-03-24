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

package sun.jvmstat.monitor;

import sun.jvmstat.monitor.*;

/**
 * Interface to support asynchronous polling of the exported
 * instrumentation of a target Java Virtual Machine.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public interface BufferedMonitoredVm extends MonitoredVm {

    /**
     * Interface to get the bytes associated with the instrumentation
     * for the target Java Virtual Machine.
     *
     * @return byte[] - a byte array containing the current bytes
     *                  for the instrumentation exported by the
     *                  target Java Virtual Machine.
     */
    byte[] getBytes();

    /**
     * Interface to get the size of the instrumentation buffer
     * for the target Java Virtual Machine.
     *
     * @return int - the size of the instrumentation buffer for the
     *               target Java Virtual Machine.
     */
    int getCapacity();
}
