/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/**
 * SystemModules class will be generated at link time to create
 * ModuleDescriptor for the system modules directly to improve
 * the module descriptor reconstitution time.
 *
 * This will skip parsing of module-info.class file and validating
 * names such as module name, package name, service and provider type names.
 * It also avoids taking a defensive copy of any collection.
 *
 * @see jdk.tools.jlink.internal.plugins.SystemModulesPlugin
 */
public final class SystemModules {
    /**
     * Name of the system modules.
     *
     * This array provides a way for SystemModuleFinder to fallback
     * and read module-info.class from the run-time image instead of
     * the fastpath.
     */
    public static final String[] MODULE_NAMES = new String[0];

    /**
     * Number of packages in the boot layer from the installed modules.
     *
     * Don't make it final to avoid inlining during compile time as
     * the value will be changed at jlink time.
     */
    public static int PACKAGES_IN_BOOT_LAYER = 1024;

    /**
     * Return true if there are no split packages in the run-time image.
     */
    public static boolean hasSplitPackages() {
        return true;
    }

    /**
     * Returns a non-empty array of ModuleDescriptor objects in the run-time image.
     *
     * When running an exploded image it returns an empty array.
     */
    public static ModuleDescriptor[] descriptors() {
        throw new InternalError("expected to be overridden at link time");
    }

    /**
     * Returns a non-empty array of ModuleTarget objects in the run-time image.
     *
     * When running an exploded image it returns an empty array.
     */
    public static ModuleTarget[] targets() {
        throw new InternalError("expected to be overridden at link time");
    }

    /**
     * Returns a non-empty array of ModuleHashes recorded in each module
     * in the run-time image.
     *
     * When running an exploded image it returns an empty array.
     */
    public static ModuleHashes[] hashes() {
        throw new InternalError("expected to be overridden at link time");
    }

    /**
     * Returns a non-empty array of ModuleResolutions in the run-time image.
     */
    public static ModuleResolution[] moduleResolutions() {
        throw new InternalError("expected to be overridden at link time");
    }

    /**
     * Returns the map of module concealed packages to open. The map key is the
     * module name, the value is the set of concealed packages to open.
     */
    public static Map<String, Set<String>> concealedPackagesToOpen() {
        return Collections.emptyMap();
    }

    /**
     * Returns the map of module exported packages to open. The map key is the
     * module name, the value is the set of exported packages to open.
     */
    public static Map<String, Set<String>> exportedPackagesToOpen() {
        return Collections.emptyMap();
    }
}
