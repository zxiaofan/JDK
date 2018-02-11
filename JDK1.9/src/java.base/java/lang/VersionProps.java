/*
 * Copyright (c) 1999, 2017, Oracle and/or its affiliates. All rights reserved.
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

package java.lang;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

class VersionProps {


    private static final String launcher_name =
        "java";

    private static final String java_version =
        "9";

    private static final String java_runtime_name =
        "Java(TM) SE Runtime Environment";

    private static final String java_runtime_version =
        "9+181";

    private static final String VERSION_NUMBER =
        "9";

    private static final String VERSION_BUILD =
        "181";

    private static final String VERSION_PRE =
        "";

    private static final String VERSION_OPT =
        "";

    static {
        init();
    }

    public static void init() {
        System.setProperty("java.version", java_version);
        System.setProperty("java.runtime.version", java_runtime_version);
        System.setProperty("java.runtime.name", java_runtime_name);
    }

    private static int parseVersionNumber(String version, int prevIndex, int index) {
        if (index - prevIndex > 1 &&
            Character.digit(version.charAt(prevIndex), 10) <= 0)
            throw new IllegalArgumentException("Leading zeros not supported (" +
                    version.substring(prevIndex, index) + ")");
        return Integer.parseInt(version, prevIndex, index, 10);
    }

    // This method is reflectively used by regression tests.
    static List<Integer> parseVersionNumbers(String version) {
        // Let's find the size of an array required to hold $VNUM components
        int size = 0;
        int prevIndex = 0;
        do {
            prevIndex = version.indexOf('.', prevIndex) + 1;
            size++;
        } while (prevIndex > 0);
        Integer[] verNumbers = new Integer[size];

        // Fill in the array with $VNUM components
        int n = 0;
        prevIndex = 0;
        int index = version.indexOf('.');
        while (index > -1) {
            verNumbers[n] = parseVersionNumber(version, prevIndex, index);
            prevIndex = index + 1; // Skip the period
            index = version.indexOf('.', prevIndex);
            n++;
        }
        verNumbers[n] = parseVersionNumber(version, prevIndex, version.length());

        if (verNumbers[0] == 0 || verNumbers[n] == 0)
            throw new IllegalArgumentException("Leading/trailing zeros not allowed (" +
                    Arrays.toString(verNumbers) + ")");

        return List.of(verNumbers);
    }

    static List<Integer> versionNumbers() {
        return parseVersionNumbers(VERSION_NUMBER);
    }

    static Optional<String> pre() {
        return optionalOf(VERSION_PRE);
    }

    static Optional<Integer> build() {
        return VERSION_BUILD.isEmpty() ?
                Optional.empty() :
                Optional.of(Integer.parseInt(VERSION_BUILD));
    }

    static Optional<String> optional() {
        return optionalOf(VERSION_OPT);
    }

    // Treat empty strings as value not being present
    private static Optional<String> optionalOf(String value) {
        if (!value.isEmpty()) {
            return Optional.of(value);
        } else {
            return Optional.empty();
        }
    }

    /**
     * In case you were wondering this method is called by java -version.
     */
    public static void print(boolean err) {
        print(err, false);
    }

    /**
     * This is the same as print except that it adds an extra line-feed
     * at the end, typically used by the -showversion in the launcher
     */
    public static void println(boolean err) {
        print(err, true);
    }

    /**
     * Print version info.
     */
    private static void print(boolean err, boolean newln) {
        boolean isHeadless = false;
        PrintStream ps = err ? System.err : System.out;

        /* Report that we're running headless if the property is true */
        String headless = System.getProperty("java.awt.headless");
        if ( (headless != null) && (headless.equalsIgnoreCase("true")) ) {
            isHeadless = true;
        }

        /* First line: platform version. */
        if (err) {
            ps.println(launcher_name + " version \"" + java_version + "\"");
        } else {
            /* Use a format more in line with GNU conventions */
            ps.println(launcher_name + " " + java_version);
        }

        /* Second line: runtime version (ie, libraries). */
        String jdk_debug_level = System.getProperty("jdk.debug", "release");
        /* Debug level is not printed for "release" builds */
        if ("release".equals(jdk_debug_level)) {
            jdk_debug_level = "";
        } else {
            jdk_debug_level = jdk_debug_level + " ";
        }

        ps.print(java_runtime_name + " (" + jdk_debug_level + "build " + java_runtime_version);

        ps.println(')');

        /* Third line: JVM information. */
        String java_vm_name    = System.getProperty("java.vm.name");
        String java_vm_version = System.getProperty("java.vm.version");
        String java_vm_info    = System.getProperty("java.vm.info");
        ps.println(java_vm_name + " (" + jdk_debug_level + "build " + java_vm_version + ", " +
                   java_vm_info + ")");
    }

}
