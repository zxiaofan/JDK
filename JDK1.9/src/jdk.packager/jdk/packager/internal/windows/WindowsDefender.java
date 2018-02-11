/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.packager.internal.windows;

import com.oracle.tools.packager.Platform;
import java.util.List;

public final class WindowsDefender {

    private WindowsDefender() {}

    public static final boolean isThereAPotentialWindowsDefenderIssue() {
        boolean result = false;

        if (Platform.getPlatform() == Platform.WINDOWS &&
            Platform.getMajorVersion() == 10) {

            // If DisableRealtimeMonitoring is not enabled then there
            // may be a problem.
            if (!WindowsRegistry.readDisableRealtimeMonitoring() &&
                !isTempDirectoryInExclusionPath()) {
                result = true;
            }
        }

        return result;
    }

    private static final boolean isTempDirectoryInExclusionPath() {
        boolean result = false;
        // If the user temp directory is not found in the exclusion
        // list then there may be a problem.
        List<String> paths = WindowsRegistry.readExclusionsPaths();
        String tempDirectory = getUserTempDirectory();

        for (String s : paths) {
            if (s.equals(tempDirectory)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public static final String getUserTempDirectory() {
        String tempDirectory = System.getProperty("java.io.tmpdir");
        return tempDirectory;
    }
}
