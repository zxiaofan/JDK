/*
 * Copyright (c) 2017, 2021, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.module;

import java.lang.module.ModuleDescriptor;
import java.util.Map;
import java.util.Set;

/**
 * A dummy SystemModules for use with exploded builds or testing.
 */

class ExplodedSystemModules implements SystemModules {
    @Override
    public boolean hasSplitPackages() {
        return true;  // not known
    }

    @Override
    public boolean hasIncubatorModules() {
        return true;  // not known
    }

    @Override
    public ModuleDescriptor[] moduleDescriptors() {
        throw new InternalError();
    }

    @Override
    public ModuleTarget[] moduleTargets() {
        throw new InternalError();
    }

    @Override
    public ModuleHashes[] moduleHashes() {
        throw new InternalError();
    }

    @Override
    public ModuleResolution[] moduleResolutions() {
        throw new InternalError();
    }

    @Override
    public Map<String, Set<String>> moduleReads() {
        throw new InternalError();
    }
}
