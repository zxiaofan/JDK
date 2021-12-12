/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdeps;

import java.io.IOException;
import java.lang.module.ModuleDescriptor;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Build the profile information.
 */
enum Profile {
    COMPACT1("compact1", 1, "java.logging",
                            "java.scripting"),
    COMPACT2("compact2", 2, "java.rmi",
                            "java.sql",
                            "java.xml",
                            "jdk.xml.dom",
                            "jdk.httpserver"),
    COMPACT3("compact3", 3, "java.smartcardio",
                            "java.compiler",
                            "java.instrument",
                            "java.management",
                            "java.naming",
                            "java.prefs",
                            "java.security.jgss",
                            "java.security.sasl",
                            "java.sql.rowset",
                            "java.xml.crypto",
                            "jdk.management",
                            "jdk.naming.dns",
                            "jdk.naming.rmi",
                            "jdk.sctp",
                            "jdk.security.auth");

    final String name;
    final int profile;
    final String[] mnames;
    final Map<String, Module> modules = new HashMap<>();

    Profile(String name, int profile, String... mnames) {
        this.name = name;
        this.profile = profile;
        this.mnames = mnames;
    }

    public String profileName() {
        return name;
    }

    @Override
    public String toString() {
        return mnames[0];
    }

    public static int getProfileCount() {
        return JDK.isEmpty() ? 0 : Profile.values().length;
    }

    /**
     * Returns the Profile for the given package name; null if not found.
     */
    public static Profile getProfile(String pn) {
        for (Profile p : Profile.values()) {
            for (Module m : p.modules.values()) {
                if (m.packages().contains(pn)) {
                    return p;
                }
            }
        }
        return null;
    }

    /*
     * Returns the Profile for a given Module; null if not found.
     */
    public static Profile getProfile(Module m) {
        for (Profile p : Profile.values()) {
            if (p.modules.containsValue(m)) {
                return p;
            }
        }
        return null;
    }

    private final static Set<Module> JDK = new HashSet<>();
    static synchronized void init(Map<String, Module> systemModules) {
        Arrays.stream(Profile.values()).forEach(p ->
            // this includes platform-dependent module that may not exist
            Arrays.stream(p.mnames)
                  .filter(systemModules::containsKey)
                  .map(systemModules::get)
                  .forEach(m -> p.addModule(systemModules, m)));

        // JDK modules should include full JRE plus other jdk.* modules
        // Just include all installed modules.  Assume jdeps is running
        // in JDK image
        JDK.addAll(systemModules.values());
    }

    private void addModule(Map<String, Module> systemModules, Module module) {
        modules.put(module.name(), module);
        module.descriptor().requires().stream()
              .map(ModuleDescriptor.Requires::name)
              .map(systemModules::get)
              .forEach(m -> modules.put(m.name(), m));
    }

    // for debugging
    public static void main(String[] args) throws IOException {
        // initialize Profiles
        new JdepsConfiguration.Builder().addmods(Set.of("ALL-SYSTEM")).build();

        // find platform modules
        if (Profile.getProfileCount() == 0) {
            System.err.println("No profile is present in this JDK");
        }
        for (Profile p : Profile.values()) {
            String profileName = p.name;
            System.out.format("%2d: %-10s  %s%n", p.profile, profileName, p.modules);
        }
        System.out.println("All JDK modules:-");
        JDK.stream().sorted(Comparator.comparing(Module::name))
           .forEach(System.out::println);
    }
}
