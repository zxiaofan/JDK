/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides the RMI package. RMI is Remote Method Invocation.  It is a
 * mechanism that enables an object on one Java virtual machine to invoke
 * methods on an object in another Java virtual machine.  Any object that
 * can be invoked this way must implement the Remote interface. When such
 * an object is invoked, its arguments are ``marshalled'' and sent from the
 * local virtual machine to the remote one, where the arguments are
 * ``unmarshalled.''  When the method terminates, the results are
 * marshalled from the remote machine and sent to the caller's virtual
 * machine.  If the method invocation results in an exception being
 * thrown, the exception is indicated to caller.
 *
 * @since 1.1
 */
package java.rmi;
