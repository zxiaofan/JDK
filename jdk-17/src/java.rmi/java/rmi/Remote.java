/*
 * Copyright (c) 1996, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.rmi;

/**
 * The <code>Remote</code> interface serves to identify interfaces whose
 * methods may be invoked from a non-local virtual machine.  Any object that
 * is a remote object must directly or indirectly implement this interface.
 * Only those methods specified in a "remote interface", an interface that
 * extends <code>java.rmi.Remote</code> are available remotely.
 *
 * <p>Implementation classes can implement any number of remote interfaces and
 * can extend other remote implementation classes.  RMI provides a convenience
 * class {@link java.rmi.server.UnicastRemoteObject UnicastRemoteObject}
 * that remote object implementations can extend and that facilitates remote
 * object creation.
 *
 * <p>For complete details on RMI, see the <a
 * href="{@docRoot}/../specs/rmi/index.html">RMI Specification</a> which
 * describes the RMI API and system.
 *
 * @since   1.1
 * @author  Ann Wollrath
 */
public interface Remote {}
