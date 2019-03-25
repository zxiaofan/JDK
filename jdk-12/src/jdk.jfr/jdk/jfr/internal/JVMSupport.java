/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal;

import java.io.IOException;

/**
 * Checks if the running VM supports Flight Recorder.
 *
 * Purpose of this helper class is to detect early and cleanly if the VM has
 * support for Flight Recorder, i.e. not throw {@link UnsatisfiedLinkError} in
 * unexpected places.
 * <p>
 * This is needed so a disabled-jfr.jar can be built for non Oracle JDKs.
 */
public final class JVMSupport {

    private static final String UNSUPPORTED_VM_MESSAGE = "Flight Recorder is not supported on this VM";
    private static final boolean notAvailable = !checkAvailability();

    private static boolean checkAvailability() {
        // set jfr.unsupported.vm to true to test API on an unsupported VM
        try {
            if (SecuritySupport.getBooleanProperty("jfr.unsupported.vm")) {
                return false;
            }
        } catch (NoClassDefFoundError cnfe) {
            // May happen on JDK 8, where jdk.internal.misc.Unsafe can't be found
            return false;
        }
        try {
            // Will typically throw UnsatisfiedLinkError if
            // there is no native implementation
            JVM.getJVM().isAvailable();
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

    public static void ensureWithInternalError() {
        if (notAvailable) {
            throw new InternalError(UNSUPPORTED_VM_MESSAGE);
        }
    }

    public static void ensureWithIOException() throws IOException {
        if (notAvailable) {
            throw new IOException(UNSUPPORTED_VM_MESSAGE);
        }
    }

    public static void ensureWithIllegalStateException() {
        if (notAvailable) {
            throw new IllegalStateException(UNSUPPORTED_VM_MESSAGE);
        }
    }

    public static boolean isNotAvailable() {
        return notAvailable;
    }

    public static void tryToInitializeJVM() {
    }
}
