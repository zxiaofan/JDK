/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.services;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * Provides utilities needed by JVMCI clients.
 */
public final class Services {

    // This class must be compilable and executable on JDK 8 since it's used in annotation
    // processors while building JDK 9 so use of API added in JDK 9 is made via reflection.

    private Services() {
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String> initSavedProperties() throws InternalError {
        try {
            Class<?> vmClass = Class.forName("jdk.internal.misc.VM");
            Method m = vmClass.getMethod("getSavedProperties");
            return (Map<String, String>) m.invoke(null);
        } catch (Exception e) {
            throw new InternalError(e);
        }
    }

    static final Map<String, String> SAVED_PROPERTIES = initSavedProperties();
    static final boolean JVMCI_ENABLED = Boolean.parseBoolean(SAVED_PROPERTIES.get("jdk.internal.vm.ci.enabled"));

    /**
     * Checks that JVMCI is enabled in the VM and throws an error if it isn't.
     */
    static void checkJVMCIEnabled() {
        if (!JVMCI_ENABLED) {
            throw new Error("The EnableJVMCI VM option must be true (i.e., -XX:+EnableJVMCI) to use JVMCI");
        }
    }

    /**
     * Gets an unmodifiable copy of the system properties saved when {@link System} is initialized.
     */
    public static Map<String, String> getSavedProperties() {
        checkJVMCIEnabled();
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            sm.checkPermission(new JVMCIPermission());
        }
        return SAVED_PROPERTIES;
    }

    /**
     * Causes the JVMCI subsystem to be initialized if it isn't already initialized.
     */
    public static void initializeJVMCI() {
        checkJVMCIEnabled();
        try {
            Class.forName("jdk.vm.ci.runtime.JVMCI");
        } catch (ClassNotFoundException e) {
            throw new InternalError(e);
        }
    }
}
