/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.hotspot.meta;

import java.lang.module.ModuleDescriptor.Requires;

import jdk.internal.vm.compiler.collections.EconomicSet;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;

/**
 * Determines if methods in a given class can be intrinsified.
 *
 * Only classes loaded from the module defining the compiler configuration or any of its transitive
 * dependencies can be intrinsified.
 *
 * This version of the class must be used on JDK 9 or later.
 */
public final class IntrinsificationPredicate {
    /**
     * Set of modules composed of the module defining the compiler configuration and its transitive
     * dependencies.
     */
    private final EconomicSet<Module> trustedModules;

    IntrinsificationPredicate(CompilerConfiguration compilerConfiguration) {
        trustedModules = EconomicSet.create();
        Module compilerConfigurationModule = compilerConfiguration.getClass().getModule();
        if (compilerConfigurationModule.getDescriptor().isAutomatic()) {
            throw new IllegalArgumentException(String.format("The module '%s' defining the Graal compiler configuration class '%s' must not be an automatic module",
                            compilerConfigurationModule.getName(), compilerConfiguration.getClass().getName()));
        }
        trustedModules.add(compilerConfigurationModule);
        for (Requires require : compilerConfigurationModule.getDescriptor().requires()) {
            for (Module module : compilerConfigurationModule.getLayer().modules()) {
                if (module.getName().equals(require.name())) {
                    trustedModules.add(module);
                }
            }
        }
    }

    public boolean apply(Class<?> declaringClass) {
        Module module = declaringClass.getModule();
        return trustedModules.contains(module);
    }
}
