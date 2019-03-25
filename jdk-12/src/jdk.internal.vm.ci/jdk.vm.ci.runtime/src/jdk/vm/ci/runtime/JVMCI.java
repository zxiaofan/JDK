/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

public class JVMCI {

    private static final JVMCIRuntime runtime;

    private static native JVMCIRuntime initializeRuntime();

    public static void initialize() {
        // force static initializer
    }

    /**
     * Gets the singleton {@link JVMCIRuntime} instance available to the application.
     *
     * @throws UnsupportedOperationException if JVMCI is not supported
     */
    public static JVMCIRuntime getRuntime() {
        if (runtime == null) {
            String javaHome = System.getProperty("java.home");
            String vmName = System.getProperty("java.vm.name");
            Formatter errorMessage = new Formatter();
            errorMessage.format("The VM does not support the JVMCI API.%n");
            errorMessage.format("Currently used Java home directory is %s.%n", javaHome);
            errorMessage.format("Currently used VM configuration is: %s", vmName);
            throw new UnsupportedOperationException(errorMessage.toString());
        }
        return runtime;
    }

    static {
        JVMCIRuntime rt = null;
        try {
            rt = initializeRuntime();
        } catch (UnsatisfiedLinkError e) {
        }
        runtime = rt;
    }
}
