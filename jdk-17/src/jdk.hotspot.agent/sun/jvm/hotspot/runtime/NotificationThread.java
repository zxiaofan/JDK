/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.runtime;


import sun.jvm.hotspot.debugger.Address;

public class NotificationThread extends JavaThread {
    public NotificationThread(Address addr) {
        super(addr);
    }

    public boolean isJavaThread() { return false; }

}
