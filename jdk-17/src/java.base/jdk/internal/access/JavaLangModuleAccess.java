/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.access;

import java.io.PrintStream;
import java.lang.module.Configuration;
import java.lang.module.ModuleDescriptor;
import java.lang.module.ModuleDescriptor.Exports;
import java.lang.module.ModuleDescriptor.Opens;
import java.lang.module.ModuleDescriptor.Requires;
import java.lang.module.ModuleDescriptor.Provides;
import java.lang.module.ModuleDescriptor.Version;
import java.lang.module.ModuleFinder;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Provides access to non-public methods in java.lang.module.
 */

public interface JavaLangModuleAccess {

    /**
     * Creates a builder for building a module with the given module name.
     *
     * @param strict
     *        Indicates whether module names are checked or not
     */
    ModuleDescriptor.Builder newModuleBuilder(String mn,
                                              boolean strict,
                                              Set<ModuleDescriptor.Modifier> ms);

    /**
     * Returns a snapshot of the packages in the module.
     */
    Set<String> packages(ModuleDescriptor.Builder builder);

    /**
     * Adds a dependence on a module with the given (possibly un-parsable)
     * version string.
     */
    void requires(ModuleDescriptor.Builder builder,
                  Set<Requires.Modifier> ms,
                  String mn,
                  String rawCompiledVersion);

    /**
     * Returns a {@code ModuleDescriptor.Requires} of the given modifiers
     * and module name.
     */
    Requires newRequires(Set<Requires.Modifier> ms, String mn, Version v);

    /**
     * Returns an unqualified {@code ModuleDescriptor.Exports}
     * of the given modifiers and package name source.
     */
    Exports newExports(Set<Exports.Modifier> ms,
                       String source);

    /**
     * Returns a qualified {@code ModuleDescriptor.Exports}
     * of the given modifiers, package name source and targets.
     */
    Exports newExports(Set<Exports.Modifier> ms,
                       String source,
                       Set<String> targets);

    /**
     * Returns an unqualified {@code ModuleDescriptor.Opens}
     * of the given modifiers and package name source.
     */
    Opens newOpens(Set<Opens.Modifier> ms, String source);

    /**
     * Returns a qualified {@code ModuleDescriptor.Opens}
     * of the given modifiers, package name source and targets.
     */
    Opens newOpens(Set<Opens.Modifier> ms, String source, Set<String> targets);

    /**
     * Returns a {@code ModuleDescriptor.Provides}
     * of the given service name and providers.
     */
    Provides newProvides(String service, List<String> providers);

    /**
     * Returns a new {@code ModuleDescriptor} instance.
     */
    ModuleDescriptor newModuleDescriptor(String name,
                                         Version version,
                                         Set<ModuleDescriptor.Modifier> ms,
                                         Set<Requires> requires,
                                         Set<Exports> exports,
                                         Set<Opens> opens,
                                         Set<String> uses,
                                         Set<Provides> provides,
                                         Set<String> packages,
                                         String mainClass,
                                         int hashCode);

    /**
     * Resolves a collection of root modules, with service binding
     * and the empty configuration as the parent.
     */
    Configuration resolveAndBind(ModuleFinder finder,
                                 Collection<String> roots,
                                 PrintStream traceOutput);

    /**
     * Creates a configuration from a pre-generated readability graph.
     */
    Configuration newConfiguration(ModuleFinder finder,
                                   Map<String, Set<String>> graph);

}
