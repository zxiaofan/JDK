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
 * Provides a class and two interfaces for the RMI registry.
 * A registry is a remote object that maps names to remote objects.  A
 * server registers its remote objects with the registry so that they can
 * be looked up.  When an object wants to invoke a method on a remote
 * object, it must first lookup the remote object using its name.  The
 * registry returns to the calling object a reference to the remote
 * object, using which a remote method can be invoked.
 *
 * @since 1.1
 */
package java.rmi.registry;
