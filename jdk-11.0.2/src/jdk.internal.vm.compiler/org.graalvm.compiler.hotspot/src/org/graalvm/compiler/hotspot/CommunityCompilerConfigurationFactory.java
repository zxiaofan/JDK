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

import org.graalvm.compiler.core.phases.CommunityCompilerConfiguration;
import org.graalvm.compiler.phases.tiers.CompilerConfiguration;
import org.graalvm.compiler.serviceprovider.ServiceProvider;

/**
 * Factory for creating the default configuration for the community edition of Graal.
 */
@ServiceProvider(CompilerConfigurationFactory.class)
public class CommunityCompilerConfigurationFactory extends CompilerConfigurationFactory {

    public static final String NAME = "community";

    /**
     * Must be greater than {@link EconomyCompilerConfigurationFactory#AUTO_SELECTION_PRIORITY}.
     */
    public static final int AUTO_SELECTION_PRIORITY = 2;

    public CommunityCompilerConfigurationFactory() {
        super(NAME, AUTO_SELECTION_PRIORITY);
        assert AUTO_SELECTION_PRIORITY > EconomyCompilerConfigurationFactory.AUTO_SELECTION_PRIORITY;
    }

    @Override
    public CompilerConfiguration createCompilerConfiguration() {
        return new CommunityCompilerConfiguration();
    }
}
