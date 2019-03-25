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

package jdk.tools.jaotc.binformat.pecoff;

import java.nio.ByteOrder;
import jdk.tools.jaotc.binformat.pecoff.PECoff.IMAGE_FILE_HEADER;

/**
 * Class that abstracts MACH-O target details.
 *
 */
final class PECoffTargetInfo {
    /**
     * Target architecture.
     */
    private static final char arch;

    /**
     * Target OS string.
     */
    private static String osName;

    static {
        // Find the target arch details
        String archStr = System.getProperty("os.arch").toLowerCase();
        if (ByteOrder.nativeOrder() != ByteOrder.LITTLE_ENDIAN) {
            System.out.println("Only Little Endian byte order supported!");
        }

        if (archStr.equals("amd64") || archStr.equals("x86_64")) {
            arch = IMAGE_FILE_HEADER.IMAGE_FILE_MACHINE_AMD64;
        } else {
            System.out.println("Unsupported architecture " + archStr);
            arch = IMAGE_FILE_HEADER.IMAGE_FILE_MACHINE_UNKNOWN;
        }

        osName = System.getProperty("os.name").toLowerCase();
        if (!osName.contains("windows")) {
            System.out.println("Unsupported Operating System " + osName);
            osName = "Unknown";
        }
    }

    static char getPECoffArch() {
        return arch;
    }

    static String getOsName() {
        return osName;
    }
}
