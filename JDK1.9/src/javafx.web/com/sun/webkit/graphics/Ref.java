/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.webkit.graphics;

public class Ref {
    private final int id;
    private int count;

    public Ref() {
        count = 0;
        id = WCGraphicsManager.getGraphicsManager().createID();
    }

    public synchronized void ref() {
        if (count == 0) {
            WCGraphicsManager.getGraphicsManager().ref(this);
        }
        count ++;
    }

    public synchronized void deref() {
        if (count == 0) {
            throw new IllegalStateException("Object  " + id + " has no references.");
        }
        count --;
        if (count == 0) {
            WCGraphicsManager.getGraphicsManager().deref(this);
        }
    }

    public boolean hasRefs() {
        return count > 0;
    }

    public int getID() {
        return id;
    }
}
