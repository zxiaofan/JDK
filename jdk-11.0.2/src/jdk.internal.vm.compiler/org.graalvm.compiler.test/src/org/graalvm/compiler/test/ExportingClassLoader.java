/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.test;

/**
 * A class loader that exports all packages in the module defining the class loader to all classes
 * in the unnamed module associated with the loader.
 */
public class ExportingClassLoader extends ClassLoader {
    public ExportingClassLoader() {
        if (!GraalTest.Java8OrEarlier) {
            JLModule.fromClass(getClass()).exportAllPackagesTo(JLModule.getUnnamedModuleFor(this));
        }
    }

    public ExportingClassLoader(ClassLoader parent) {
        super(parent);
        if (!GraalTest.Java8OrEarlier) {
            JLModule.fromClass(getClass()).exportAllPackagesTo(JLModule.getUnnamedModuleFor(this));
        }
    }
}
