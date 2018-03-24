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

import java.lang.module.Configuration;
import java.lang.module.ResolvedModule;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import jdk.internal.loader.ClassLoaders;


/**
 * Supports the mapping of modules to class loaders. The set of modules mapped
 * to the boot and platform class loaders is generated at build time from
 * this source file.
 */
public final class ModuleLoaderMap {

    /**
     * Maps the system modules to the built-in class loaders.
     */
    public static final class Mapper implements Function<String, ClassLoader> {
        private final Map<String, ClassLoader> map;

        Mapper(Map<String, ClassLoader> map) {
            this.map = map; // defensive copy not needed
        }

        @Override
        public ClassLoader apply(String name) {
            return map.get(name);
        }
    }

    /**
     * Returns the names of the modules defined to the boot loader.
     */
    public static Set<String> bootModules() {
        // The list of boot modules generated at build time.
        String[] BOOT_MODULES = new String[] { "java.base",
            "java.datatransfer",
            "java.desktop",
            "java.instrument",
            "java.logging",
            "java.management",
            "java.management.rmi",
            "java.naming",
            "java.prefs",
            "java.rmi",
            "java.security.sasl",
            "java.xml",
            "jdk.internal.vm.ci",
            "jdk.jfr",
            "jdk.management",
            "jdk.management.agent",
            "jdk.management.cmm",
            "jdk.management.jfr",
            "jdk.management.resource",
            "jdk.naming.rmi",
            "jdk.net",
            "jdk.sctp",
            "jdk.snmp",
            "jdk.unsupported" };
        Set<String> bootModules = new HashSet<>(BOOT_MODULES.length);
        for (String mn : BOOT_MODULES) {
            bootModules.add(mn);
        }
        return bootModules;
    }

    /**
     * Returns the names of the modules defined to the platform loader.
     */
    public static Set<String> platformModules() {
        // The list of platform modules generated at build time.
        String[] PLATFORM_MODULES = new String[] { "java.activation",
            "java.compiler",
            "java.corba",
            "java.jnlp",
            "java.scripting",
            "java.se",
            "java.se.ee",
            "java.security.jgss",
            "java.smartcardio",
            "java.sql",
            "java.sql.rowset",
            "java.transaction",
            "java.xml.bind",
            "java.xml.crypto",
            "java.xml.ws",
            "java.xml.ws.annotation",
            "javafx.base",
            "javafx.controls",
            "javafx.deploy",
            "javafx.fxml",
            "javafx.graphics",
            "javafx.media",
            "javafx.swing",
            "javafx.web",
            "jdk.accessibility",
            "jdk.charsets",
            "jdk.crypto.cryptoki",
            "jdk.crypto.ec",
            "jdk.crypto.mscapi",
            "jdk.deploy",
            "jdk.dynalink",
            "jdk.httpserver",
            "jdk.incubator.httpclient",
            "jdk.internal.vm.compiler",
            "jdk.internal.vm.compiler.management",
            "jdk.javaws",
            "jdk.jsobject",
            "jdk.localedata",
            "jdk.naming.dns",
            "jdk.plugin",
            "jdk.plugin.dom",
            "jdk.plugin.server",
            "jdk.scripting.nashorn",
            "jdk.security.auth",
            "jdk.security.jgss",
            "jdk.xml.dom",
            "jdk.zipfs",
            "oracle.desktop",
            "oracle.net" };
        Set<String> platformModules = new HashSet<>(PLATFORM_MODULES.length);
        for (String mn : PLATFORM_MODULES) {
            platformModules.add(mn);
        }
        return platformModules;
    }

    /**
     * Returns the function to map modules in the given configuration to the
     * built-in class loaders.
     */
    static Function<String, ClassLoader> mappingFunction(Configuration cf) {
        Set<String> bootModules = bootModules();
        Set<String> platformModules = platformModules();

        ClassLoader platformClassLoader = ClassLoaders.platformClassLoader();
        ClassLoader appClassLoader = ClassLoaders.appClassLoader();

        Map<String, ClassLoader> map = new HashMap<>();
        for (ResolvedModule resolvedModule : cf.modules()) {
            String mn = resolvedModule.name();
            if (!bootModules.contains(mn)) {
                if (platformModules.contains(mn)) {
                    map.put(mn, platformClassLoader);
                } else {
                    map.put(mn, appClassLoader);
                }
            }
        }
        return new Mapper(map);
    }
}
