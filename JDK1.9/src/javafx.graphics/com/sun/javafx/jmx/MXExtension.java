/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.jmx;

import com.sun.javafx.util.Logging;

public abstract class MXExtension {
    private static final String EXTENSION_CLASS_NAME =
            System.getProperty("javafx.debug.jmx.class",
                               "com.oracle.javafx.jmx.MXExtensionImpl");

    public abstract void intialize() throws Exception;

    public static void initializeIfAvailable() {
        try {
            final ClassLoader loader = MXExtension.class.getClassLoader();
            final Class<?> mxExtensionClass =
                    Class.forName(EXTENSION_CLASS_NAME, false, loader);
            if (!MXExtension.class.isAssignableFrom(mxExtensionClass)) {
                throw new IllegalArgumentException("Unrecognized MXExtension class: "
                        + EXTENSION_CLASS_NAME);
            }
            final MXExtension mxExtension = (MXExtension)mxExtensionClass.newInstance();
            mxExtension.intialize();
        } catch (final Exception e) {
            Logging.getJavaFXLogger().info(
                    "Failed to initialize management extension", e);
        }

    }
}
