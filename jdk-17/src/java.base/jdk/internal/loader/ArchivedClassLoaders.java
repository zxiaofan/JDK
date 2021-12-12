/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.internal.loader;

import java.util.Map;
import jdk.internal.misc.CDS;
import jdk.internal.module.ServicesCatalog;

/**
 * Used to archive the built-in class loaders, their services catalogs, and the
 * package-to-module map used by the built-in class loaders.
 */
class ArchivedClassLoaders {
    private static ArchivedClassLoaders archivedClassLoaders;

    private final ClassLoader bootLoader;
    private final ClassLoader platformLoader;
    private final ClassLoader appLoader;
    private final ServicesCatalog[] servicesCatalogs;
    private final Map<String, ?> packageToModule;

    private ArchivedClassLoaders() {
        bootLoader = ClassLoaders.bootLoader();
        platformLoader = ClassLoaders.platformClassLoader();
        appLoader = ClassLoaders.appClassLoader();

        servicesCatalogs = new ServicesCatalog[3];
        servicesCatalogs[0] = ServicesCatalog.getServicesCatalog(bootLoader);
        servicesCatalogs[1] = ServicesCatalog.getServicesCatalog(platformLoader);
        servicesCatalogs[2] = ServicesCatalog.getServicesCatalog(appLoader);

        packageToModule = BuiltinClassLoader.packageToModule();
    }

    ClassLoader bootLoader() {
        return bootLoader;
    }

    ClassLoader platformLoader() {
        return platformLoader;
    }

    ClassLoader appLoader() {
        return appLoader;
    }

    ServicesCatalog servicesCatalog(ClassLoader loader) {
        if (loader == bootLoader) {
            return servicesCatalogs[0];
        } else if (loader == platformLoader) {
            return servicesCatalogs[1];
        } else if (loader == appLoader) {
            return servicesCatalogs[2];
        } else {
            throw new InternalError();
        }
    }

    Map<String, ?> packageToModule() {
        return packageToModule;
    }

    static void archive() {
        archivedClassLoaders = new ArchivedClassLoaders();
    }

    static ArchivedClassLoaders get() {
        return archivedClassLoaders;
    }

    static {
        CDS.initializeFromArchive(ArchivedClassLoaders.class);
    }
}
