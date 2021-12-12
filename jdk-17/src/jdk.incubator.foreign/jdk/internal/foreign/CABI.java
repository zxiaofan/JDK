/*
 *  Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
 *  ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
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
 *
 */
package jdk.internal.foreign;

import sun.security.action.GetPropertyAction;

import static jdk.incubator.foreign.MemoryLayouts.ADDRESS;
import static sun.security.action.GetPropertyAction.privilegedGetProperty;

public enum CABI {
    SysV,
    Win64,
    LinuxAArch64,
    MacOsAArch64;

    private static final CABI current;

    static {
        String arch = privilegedGetProperty("os.arch");
        String os = privilegedGetProperty("os.name");
        long addressSize = ADDRESS.bitSize();
        // might be running in a 32-bit VM on a 64-bit platform.
        // addressSize will be correctly 32
        if ((arch.equals("amd64") || arch.equals("x86_64")) && addressSize == 64) {
            if (os.startsWith("Windows")) {
                current = Win64;
            } else {
                current = SysV;
            }
        } else if (arch.equals("aarch64")) {
            if (os.startsWith("Mac")) {
                current = MacOsAArch64;
            } else {
                // The Linux ABI follows the standard AAPCS ABI
                current = LinuxAArch64;
            }
        } else {
            throw new ExceptionInInitializerError(
                "Unsupported os, arch, or address size: " + os + ", " + arch + ", " + addressSize);
        }
    }

    public static CABI current() {
        return current;
    }
}
