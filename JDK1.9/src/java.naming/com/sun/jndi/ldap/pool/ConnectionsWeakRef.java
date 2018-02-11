/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap.pool;

import java.lang.ref.WeakReference;
import java.lang.ref.ReferenceQueue;

/*
 * This class defines a WeakReference to the ConnectionRef (the referent).
 *
 * The ConnectionRef enables to break the reference
 * cycle between Connection, LdapClient, Connections and ConnectionDesc,
 * shown in the figure below.
 *
 *        -------> Connections -----> ConnectionDesc
 *        |              ^                  |
 *        |              |                  |
 *        |              |                  |
 * ConnectionsRef    LdapClient <------------
 *        ^              |   ^
 *        :              |   |
 *        :              v   |
 * ConnectionsWeakRef  Connection
 *
 * The ConnectionsRef is for cleaning up the resources held by the
 * Connection thread by making them available to the GC. The pool
 * uses ConnectionRef to hold the pooled resources.
 *
 * This class in turn holds a WeakReference with a ReferenceQueue to the
 * ConnectionRef to track when the ConnectionRef becomes ready
 * for getting GC'ed. It extends from WeakReference in order to hold a
 * reference to Connections used for closing (which in turn terminates
 * the Connection thread) it by monitoring the ReferenceQueue.
 */
class ConnectionsWeakRef extends WeakReference<ConnectionsRef> {

    private final Connections conns;

    ConnectionsWeakRef (ConnectionsRef connsRef,
                        ReferenceQueue<? super ConnectionsRef> queue) {
        super(connsRef, queue);
        this.conns = connsRef.getConnections();
    }

    Connections getConnections() {
        return conns;
    }
}
