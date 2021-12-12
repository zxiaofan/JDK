/*
 * Copyright (c) 2015, 2019, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.runtime;

import java.util.Formatter;

import jdk.vm.ci.common.NativeImageReinitialize;
import jdk.vm.ci.services.Services;

public class JVMCI {

    /**
     * Singleton instance lazily initialized via double-checked locking.
     */
    @NativeImageReinitialize private static volatile JVMCIRuntime runtime;

    @NativeImageReinitialize private static boolean initializing;

    public static void initialize() {
        // force static initializer
    }

    private static native JVMCIRuntime initializeRuntime();

    /**
     * Gets the singleton {@link JVMCIRuntime} instance available to the application.
     *
     * @throws UnsupportedOperationException if JVMCI is not supported
     */
    public static JVMCIRuntime getRuntime() {
        JVMCIRuntime result = runtime;
        if (result == null) {
            synchronized (JVMCI.class) {
                result = runtime;
                if (result == null) {
                    if (initializing) {
                        // In recursive call from HotSpotJVMCIRuntime.runtime
                        // so no need to re-enter initializeRuntime below. This
                        // path is only entered if JVMCI initialization starts
                        // with JVMCI.getRuntime().
                        return null;
                    }
                    initializing = true;
                    try {
                        runtime = result = initializeRuntime();
                    } catch (UnsatisfiedLinkError e) {
                        String javaHome = Services.getSavedProperty("java.home");
                        String vmName = Services.getSavedProperty("java.vm.name");
                        Formatter errorMessage = new Formatter();
                        errorMessage.format("The VM does not support the JVMCI API.%n");
                        errorMessage.format("Currently used Java home directory is %s.%n", javaHome);
                        errorMessage.format("Currently used VM configuration is: %s", vmName);
                        throw new UnsupportedOperationException(errorMessage.toString());
                    } finally {
                        initializing = false;
                    }
                }
            }
        }
        return result;
    }
}
