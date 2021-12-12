/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.util.List;

final class WindowsDefender {

    private WindowsDefender() {}

    static final boolean isThereAPotentialWindowsDefenderIssue(String dir) {
        boolean result = false;

        if (Platform.getPlatform() == Platform.WINDOWS &&
            Platform.getMajorVersion() == 10) {

            // If DisableRealtimeMonitoring is not enabled then there
            // may be a problem.
            if (!WindowsRegistry.readDisableRealtimeMonitoring() &&
                !isDirectoryInExclusionPath(dir)) {
                result = true;
            }
        }

        return result;
    }

    private static boolean isDirectoryInExclusionPath(String dir) {
        boolean result = false;
        // If the user temp directory is not found in the exclusion
        // list then there may be a problem.
        List<String> paths = WindowsRegistry.readExclusionsPaths();
        for (String s : paths) {
            if (WindowsRegistry.comparePaths(s, dir)) {
                result = true;
                break;
            }
        }

        return result;
    }

    static final String getUserTempDirectory() {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        return tempDirectory;
    }
}
