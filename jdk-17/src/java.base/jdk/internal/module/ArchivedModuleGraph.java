/*
 * Copyright (c) 2018, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.function.Function;
import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import jdk.internal.misc.CDS;

/**
 * Used by ModuleBootstrap for archiving the configuration for the boot layer,
 * and the system module finder.
 */
class ArchivedModuleGraph {
    private static ArchivedModuleGraph archivedModuleGraph;

    private final boolean hasSplitPackages;
    private final boolean hasIncubatorModules;
    private final ModuleFinder finder;
    private final Configuration configuration;
    private final Function<String, ClassLoader> classLoaderFunction;

    private ArchivedModuleGraph(boolean hasSplitPackages,
                                boolean hasIncubatorModules,
                                ModuleFinder finder,
                                Configuration configuration,
                                Function<String, ClassLoader> classLoaderFunction) {
        this.hasSplitPackages = hasSplitPackages;
        this.hasIncubatorModules = hasIncubatorModules;
        this.finder = finder;
        this.configuration = configuration;
        this.classLoaderFunction = classLoaderFunction;
    }

    ModuleFinder finder() {
        return finder;
    }

    Configuration configuration() {
        return configuration;
    }

    Function<String, ClassLoader> classLoaderFunction() {
        return classLoaderFunction;
    }

    boolean hasSplitPackages() {
        return hasSplitPackages;
    }

    boolean hasIncubatorModules() {
        return hasIncubatorModules;
    }

    /**
     * Returns the ArchivedModuleGraph for the given initial module.
     */
    static ArchivedModuleGraph get(String mainModule) {
        ArchivedModuleGraph graph = archivedModuleGraph;
        // We only allow the unnamed module (default) case for now
        if (mainModule == null) {
            return graph;
        } else {
            return null;
        }
    }

    /**
     * Archive the module graph for the given initial module.
     */
    static void archive(boolean hasSplitPackages,
                        boolean hasIncubatorModules,
                        ModuleFinder finder,
                        Configuration configuration,
                        Function<String, ClassLoader> classLoaderFunction) {
        archivedModuleGraph = new ArchivedModuleGraph(hasSplitPackages,
                                                      hasIncubatorModules,
                                                      finder,
                                                      configuration,
                                                      classLoaderFunction);
    }

    static {
        CDS.initializeFromArchive(ArchivedModuleGraph.class);
    }
}
