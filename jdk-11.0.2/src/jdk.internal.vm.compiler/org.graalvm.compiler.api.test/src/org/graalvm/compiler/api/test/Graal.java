/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.api.test;

import java.util.Formatter;

import org.graalvm.compiler.api.runtime.GraalJVMCICompiler;
import org.graalvm.compiler.api.runtime.GraalRuntime;

import jdk.vm.ci.runtime.JVMCI;
import jdk.vm.ci.runtime.JVMCICompiler;
import jdk.vm.ci.services.Services;

/**
 * Access point for {@linkplain #getRuntime() retrieving} the {@link GraalRuntime} instance of the
 * system compiler from unit tests.
 */
public class Graal {

    private static final GraalRuntime runtime = initializeRuntime();

    private static GraalRuntime initializeRuntime() {
        Services.initializeJVMCI();
        JVMCICompiler compiler = JVMCI.getRuntime().getCompiler();
        if (compiler instanceof GraalJVMCICompiler) {
            GraalJVMCICompiler graal = (GraalJVMCICompiler) compiler;
            return graal.getGraalRuntime();
        } else {
            return new InvalidGraalRuntime();
        }
    }

    /**
     * Gets the singleton {@link GraalRuntime} instance available to unit tests.
     */
    public static GraalRuntime getRuntime() {
        return runtime;
    }

    /**
     * Gets a capability provided by the {@link GraalRuntime} instance available to the application.
     *
     * @throws UnsupportedOperationException if the capability is not available
     */
    public static <T> T getRequiredCapability(Class<T> clazz) {
        T t = getRuntime().getCapability(clazz);
        if (t == null) {
            String javaHome = System.getProperty("java.home");
            String vmName = System.getProperty("java.vm.name");
            Formatter errorMessage = new Formatter();
            if (getRuntime().getClass() == InvalidGraalRuntime.class) {
                errorMessage.format("The VM does not support the Graal API.%n");
            } else {
                errorMessage.format("The VM does not expose required Graal capability %s.%n", clazz.getName());
            }
            errorMessage.format("Currently used Java home directory is %s.%n", javaHome);
            errorMessage.format("Currently used VM configuration is: %s", vmName);
            throw new UnsupportedOperationException(errorMessage.toString());
        }
        return t;
    }

    private static final class InvalidGraalRuntime implements GraalRuntime {

        @Override
        public String getName() {
            return "";
        }

        @Override
        public <T> T getCapability(Class<T> clazz) {
            return null;
        }
    }
}
