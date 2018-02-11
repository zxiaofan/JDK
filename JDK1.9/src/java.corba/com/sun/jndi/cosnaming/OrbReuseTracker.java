/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.cosnaming;

import org.omg.CORBA.ORB;

/**
 * This class keeps track of references to the shared ORB object
 * and destroys it when no more references are made to the ORB
 * object. This object is created for each ORB object that CNCtx
 * creates.
 */
class OrbReuseTracker {

    int referenceCnt;
    ORB orb;

    private static final boolean debug = false;

    OrbReuseTracker(ORB orb) {
        this.orb = orb;
        referenceCnt++;
        if (debug) {
             System.out.println("New OrbReuseTracker created");
        }
    }

    synchronized void incRefCount() {
        referenceCnt++;
        if (debug) {
             System.out.println("Increment orb ref count to:" + referenceCnt);
        }
    }

    synchronized void decRefCount() {
        referenceCnt--;
        if (debug) {
             System.out.println("Decrement orb ref count to:" + referenceCnt);
        }
        if ((referenceCnt == 0)) {
            if (debug) {
                System.out.println("Destroying the ORB");
            }
            orb.destroy();
        }
    }
}
