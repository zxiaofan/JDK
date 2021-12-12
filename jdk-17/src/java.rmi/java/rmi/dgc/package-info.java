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
 * Provides classes and interface for RMI distributed
 * garbage-collection (DGC).  When the RMI server returns an object to
 * its client (caller of the remote method), it tracks the remote
 * object's usage in the client. When there are no more references to the
 * remote object on the client, or if the reference's ``lease'' expires and
 * not renewed, the server garbage-collects the remote object.
 *
 *
 * @since 1.1
 */
package java.rmi.dgc;
