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
 *
 *
 */

package jdk.packager.services.singleton;

import java.util.Arrays;

// This class is used for notifying Single Instance for Java Packager.

public class SingleInstanceNewActivation {

    public static void main(String[] args) {

        if (args.length < 2) {
            // no user args specified
            return;
        }

        // the first arg is process id of the single instance
        String appId = SingleInstanceService.APP_ID_PREFIX + args[0];

        if (SingleInstanceService.isServerRunning(appId)) {
            String[] newArgs = Arrays.copyOfRange(args, 1, args.length);
            SingleInstanceService.connectToServer(newArgs);
        }
    }
}
