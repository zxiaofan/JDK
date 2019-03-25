/*
 * Copyright (c) 2014, 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Map;
import java.util.Set;

import jdk.internal.misc.VM;

/**
 * Provides utilities needed by JVMCI clients.
 */
public final class Services {

    // This class must be compilable and executable on JDK 8 since it's used in annotation
    // processors while building JDK 9 so use of API added in JDK 9 is made via reflection.

    /**
     * Guards code that should be run when building a native image but should be excluded from
     * (being compiled into) the image. Such code must be directly guarded by an {@code if}
     * statement on this field - the guard cannot be behind a method call.
     */
    public static final boolean IS_BUILDING_NATIVE_IMAGE;

    /**
     * Guards code that should only be run in native image. Such code must be directly guarded by an
     * {@code if} statement on this field - the guard cannot be behind a method call.
     *
     * The value of this field seen during analysis and compilation of an SVM image must be
     * {@code true}.
     */
    public static final boolean IS_IN_NATIVE_IMAGE;

    static {
        /*
         * Prevents javac from constant folding use of this field. It is set to true in the SVM
         * image via substitution during image building.
         */
        IS_IN_NATIVE_IMAGE = false;
        IS_BUILDING_NATIVE_IMAGE = false;
    }

    private Services() {
    }

    static final Map<String, String> SAVED_PROPERTIES = VM.getSavedProperties();
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

    /**
     * Opens all JVMCI packages to {@code otherModule}.
     */
    static void openJVMCITo(Module otherModule) {
        Module jvmci = Services.class.getModule();
        if (jvmci != otherModule) {
            Set<String> packages = jvmci.getPackages();
            for (String pkg : packages) {
                boolean opened = jvmci.isOpen(pkg, otherModule);
                if (!opened) {
                    jvmci.addOpens(pkg, otherModule);
                }
            }
        }
    }
}
