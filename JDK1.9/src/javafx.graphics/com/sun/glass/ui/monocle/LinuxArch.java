/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.glass.ui.monocle;

import java.security.AccessController;
import java.security.PrivilegedAction;

public class LinuxArch {

    private static final int bits;

    static {
        bits = AccessController.doPrivileged((PrivilegedAction<Integer>) () -> {
            LinuxSystem system = LinuxSystem.getLinuxSystem();
            return (int) system.sysconf(LinuxSystem._SC_LONG_BIT);
        });
    }

    static boolean is64Bit() {
        return bits == 64;
    }

    static int getBits() {
        return bits;
    }

}
