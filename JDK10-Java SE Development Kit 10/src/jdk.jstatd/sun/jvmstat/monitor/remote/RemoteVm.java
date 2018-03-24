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

package sun.jvmstat.monitor.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for accessing the instrumentation exported by a
 * Java Virtual Machine running on a remote host.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public interface RemoteVm extends Remote {

    /**
     * Interface to get the bytes associated with the instrumentation
     * for the remote Java Virtual Machine.
     *
     * @return byte[] - a byte array containing the current bytes
     *                  for the instrumentation exported by the
     *                  remote Java Virtual Machine.
     * @throws RemoteException Thrown on any communication error
     */
    byte[] getBytes() throws RemoteException;

    /**
     * Interface to get the size of the instrumentation buffer
     * for the target Java Virtual Machine.
     *
     * @return int - the size of the instrumentation buffer for the
     *               remote Java Virtual Machine.
     * @throws RemoteException Thrown on any communication error
     */
    int getCapacity() throws RemoteException;

    /**
     * Interface to return the Local Virtual Machine Identifier for
     * the remote Java Virtual Machine. The Local Virtual Machine
     * Identifier is also know as the <em>lvmid</em>.
     *
     * @throws RemoteException Thrown on any communication error
     */
    int getLocalVmId() throws RemoteException;

    /**
     * Interface to detach from the remote Java Virtual Machine.
     *
     * @throws RemoteException Thrown on any communication error
     */
    void detach() throws RemoteException;
}
