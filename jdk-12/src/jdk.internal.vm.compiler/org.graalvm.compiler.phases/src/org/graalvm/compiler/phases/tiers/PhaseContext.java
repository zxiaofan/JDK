/*
 * Copyright (c) 2013, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.core.common.spi.ConstantFieldProvider;
import org.graalvm.compiler.nodes.spi.LoweringProvider;
import org.graalvm.compiler.nodes.spi.Replacements;
import org.graalvm.compiler.nodes.spi.StampProvider;
import org.graalvm.compiler.phases.util.Providers;

import jdk.vm.ci.meta.ConstantReflectionProvider;
import jdk.vm.ci.meta.MetaAccessProvider;
import org.graalvm.compiler.core.common.spi.ForeignCallsProvider;

public class PhaseContext {

    private final MetaAccessProvider metaAccess;
    private final ConstantReflectionProvider constantReflection;
    private final ConstantFieldProvider constantFieldProvider;
    private final LoweringProvider lowerer;
    private final Replacements replacements;
    private final StampProvider stampProvider;
    private final ForeignCallsProvider foreignCalls;

    public PhaseContext(MetaAccessProvider metaAccess, ConstantReflectionProvider constantReflection, ConstantFieldProvider constantFieldProvider, LoweringProvider lowerer, Replacements replacements,
                    StampProvider stampProvider, ForeignCallsProvider foreignCalls) {
        this.metaAccess = metaAccess;
        this.constantReflection = constantReflection;
        this.constantFieldProvider = constantFieldProvider;
        this.lowerer = lowerer;
        this.replacements = replacements;
        this.stampProvider = stampProvider;
        this.foreignCalls = foreignCalls;
    }

    public PhaseContext(Providers providers) {
        this(providers.getMetaAccess(), providers.getConstantReflection(), providers.getConstantFieldProvider(), providers.getLowerer(), providers.getReplacements(), providers.getStampProvider(),
                        providers.getForeignCalls());
    }

    public MetaAccessProvider getMetaAccess() {
        return metaAccess;
    }

    public ConstantReflectionProvider getConstantReflection() {
        return constantReflection;
    }

    public ConstantFieldProvider getConstantFieldProvider() {
        return constantFieldProvider;
    }

    public LoweringProvider getLowerer() {
        return lowerer;
    }

    public Replacements getReplacements() {
        return replacements;
    }

    public StampProvider getStampProvider() {
        return stampProvider;
    }

    public ForeignCallsProvider getForeignCalls() {
        return foreignCalls;
    }
}
