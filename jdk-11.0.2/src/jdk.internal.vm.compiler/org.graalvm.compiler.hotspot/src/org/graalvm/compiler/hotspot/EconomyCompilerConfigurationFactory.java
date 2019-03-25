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

import org.graalvm.compiler.core.phases.EconomyCompilerConfiguration;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

/**
 * Factory that creates a {@link EconomyCompilerConfiguration}.
 */
@ServiceProvider(CompilerConfigurationFactory.class)
public class EconomyCompilerConfigurationFactory extends CompilerConfigurationFactory {

    public static final String NAME = "economy";

    public static final int AUTO_SELECTION_PRIORITY = 1;

    public EconomyCompilerConfigurationFactory() {
        super(NAME, AUTO_SELECTION_PRIORITY);
    }

    @Override
    public CompilerConfiguration createCompilerConfiguration() {
        return new EconomyCompilerConfiguration();
    }

    @Override
    public BackendMap createBackendMap() {
        // the economy configuration only differs in the frontend, it reuses the "community" backend
        return new DefaultBackendMap(CommunityCompilerConfigurationFactory.NAME);
    }
}
