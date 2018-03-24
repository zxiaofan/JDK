/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.binformat.macho;

import java.nio.ByteOrder;
import jdk.tools.jaotc.binformat.macho.MachO.mach_header_64;

/**
 * Class that abstracts MACH-O target details.
 *
 */
final class MachOTargetInfo {
    /**
     * Target architecture and subtype.
     */
    private static final int arch;
    private static final int subarch;

    /**
     * Architecture endian-ness.
     */
    private static final int endian = mach_header_64.CPU_SUBTYPE_LITTLE_ENDIAN;

    /**
     * Target OS string.
     */
    private static final String osName;

    static {
        // Find the target arch details
        String archStr = System.getProperty("os.arch").toLowerCase();

        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) {
            System.out.println("Only Little Endian byte order supported!");
        }

        if (archStr.equals("amd64") || archStr.equals("x86_64")) {
            arch = mach_header_64.CPU_TYPE_X86_64;
            subarch = mach_header_64.CPU_SUBTYPE_I386_ALL;
        } else {
            System.out.println("Unsupported architecture " + archStr);
            arch = mach_header_64.CPU_TYPE_ANY;
            subarch = 0;
        }

        osName = System.getProperty("os.name").toLowerCase();
    }

    static int getMachOArch() {
        return arch;
    }

    static int getMachOSubArch() {
        return subarch;
    }

    static int getMachOEndian() {
        return endian;
    }

    static String getOsName() {
        return osName;
    }
}
