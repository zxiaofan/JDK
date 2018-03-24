/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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
package org.graalvm.compiler.hotspot;

import org.graalvm.compiler.core.phases.CoreCompilerConfiguration;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

@ServiceProvider(CompilerConfigurationFactory.class)
public class CoreCompilerConfigurationFactory extends CompilerConfigurationFactory {

    public static final String NAME = "core";

    public static final int AUTO_SELECTION_PRIORITY = 2;

    public CoreCompilerConfigurationFactory() {
        super(NAME, AUTO_SELECTION_PRIORITY);
    }

    @Override
    public CompilerConfiguration createCompilerConfiguration() {
        return new CoreCompilerConfiguration();
    }
}
