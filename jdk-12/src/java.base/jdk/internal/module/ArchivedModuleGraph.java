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
 *
 *
 */

package jdk.internal.module;

import java.lang.module.Configuration;
import java.lang.module.ModuleFinder;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import jdk.internal.misc.VM;

/**
 * Used by ModuleBootstrap to obtain the archived system modules and finder.
 */
final class ArchivedModuleGraph {
    private static ArchivedModuleGraph archivedModuleGraph;

    private final String mainModule;
    private final boolean hasSplitPackages;
    private final boolean hasIncubatorModules;
    private final ModuleFinder finder;
    private final Configuration configuration;
    private final Map<String, Set<String>> concealedPackagesToOpen;
    private final Map<String, Set<String>> exportedPackagesToOpen;

    private ArchivedModuleGraph(String mainModule,
                                boolean hasSplitPackages,
                                boolean hasIncubatorModules,
                                ModuleFinder finder,
                                Configuration configuration,
                                Map<String, Set<String>> concealedPackagesToOpen,
                                Map<String, Set<String>> exportedPackagesToOpen) {
        this.mainModule = mainModule;
        this.hasSplitPackages = hasSplitPackages;
        this.hasIncubatorModules = hasIncubatorModules;
        this.finder = finder;
        this.configuration = configuration;
        this.concealedPackagesToOpen = concealedPackagesToOpen;
        this.exportedPackagesToOpen = exportedPackagesToOpen;
    }

    ModuleFinder finder() {
        return finder;
    }

    Configuration configuration() {
        return configuration;
    }

    Map<String, Set<String>> concealedPackagesToOpen() {
        return concealedPackagesToOpen;
    }

    Map<String, Set<String>> exportedPackagesToOpen() {
        return exportedPackagesToOpen;
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
        if (graph != null && Objects.equals(mainModule, graph.mainModule)) {
            return graph;
        } else {
            return null;
        }
    }

    /**
     * Archive the module graph for the given initial module.
     */
    static void archive(String mainModule,
                        boolean hasSplitPackages,
                        boolean hasIncubatorModules,
                        ModuleFinder finder,
                        Configuration configuration,
                        Map<String, Set<String>> concealedPackagesToOpen,
                        Map<String, Set<String>> exportedPackagesToOpen) {
        if (mainModule != null) {
            throw new UnsupportedOperationException();
        }
        archivedModuleGraph = new ArchivedModuleGraph(mainModule,
                                                      hasSplitPackages,
                                                      hasIncubatorModules,
                                                      finder,
                                                      configuration,
                                                      concealedPackagesToOpen,
                                                      exportedPackagesToOpen);
    }

    static {
        VM.initializeFromArchive(ArchivedModuleGraph.class);
    }
}
