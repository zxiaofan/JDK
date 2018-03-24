/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2017, Red Hat Inc. All rights reserved.
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
package org.graalvm.compiler.hotspot.aarch64;

import org.graalvm.compiler.hotspot.GraalHotSpotVMConfig;
import org.graalvm.compiler.hotspot.HotSpotGraalRuntimeProvider;
import org.graalvm.compiler.hotspot.meta.HotSpotSuitesProvider;
import org.graalvm.compiler.options.OptionValues;
import org.graalvm.compiler.phases.BasePhase;
import org.graalvm.compiler.phases.common.AddressLoweringByUsePhase;
import org.graalvm.compiler.phases.common.ExpandLogicPhase;
import org.graalvm.compiler.phases.common.FixReadsPhase;
import org.graalvm.compiler.phases.common.PropagateDeoptimizeProbabilityPhase;
import org.graalvm.compiler.phases.tiers.LowTierContext;
import org.graalvm.compiler.phases.tiers.Suites;
import org.graalvm.compiler.phases.tiers.SuitesCreator;
import org.graalvm.compiler.replacements.aarch64.AArch64ReadReplacementPhase;

import java.util.ListIterator;

/**
 * Subclass to factor out management of address lowering.
 */
public class AArch64HotSpotSuitesProvider extends HotSpotSuitesProvider {

    private final AddressLoweringByUsePhase.AddressLoweringByUse addressLoweringByUse;

    public AArch64HotSpotSuitesProvider(SuitesCreator defaultSuitesCreator, GraalHotSpotVMConfig config, HotSpotGraalRuntimeProvider runtime,
                    AddressLoweringByUsePhase.AddressLoweringByUse addressLoweringByUse) {
        super(defaultSuitesCreator, config, runtime);
        this.addressLoweringByUse = addressLoweringByUse;
    }

    @Override
    public Suites createSuites(OptionValues options) {
        Suites suites = super.createSuites(options);

        ListIterator<BasePhase<? super LowTierContext>> findPhase = suites.getLowTier().findPhase(FixReadsPhase.class);
        if (findPhase == null) {
            findPhase = suites.getLowTier().findPhase(ExpandLogicPhase.class);
        }
        findPhase.add(new AddressLoweringByUsePhase(addressLoweringByUse));

        findPhase = suites.getLowTier().findPhase(PropagateDeoptimizeProbabilityPhase.class);
        findPhase.add(new AArch64ReadReplacementPhase());

        return suites;
    }
}
