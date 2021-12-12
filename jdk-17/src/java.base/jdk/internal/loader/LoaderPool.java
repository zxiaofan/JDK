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

package jdk.internal.loader;

import java.lang.module.Configuration;
import java.lang.module.ResolvedModule;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * A pool of class loaders.
 *
 * @see ModuleLayer#defineModulesWithManyLoaders
 */

public final class LoaderPool {

    // maps module names to class loaders
    private final Map<String, Loader> loaders;


    /**
     * Creates a pool of class loaders. Each module in the given configuration
     * is mapped to its own class loader in the pool. The class loader is
     * created with the given parent class loader as its parent.
     */
    public LoaderPool(Configuration cf,
                      List<ModuleLayer> parentLayers,
                      ClassLoader parentLoader)
    {
        Map<String, Loader> loaders = new HashMap<>();
        for (ResolvedModule resolvedModule : cf.modules()) {
            Loader loader = new Loader(resolvedModule, this, parentLoader);
            String mn = resolvedModule.name();
            loaders.put(mn, loader);
        }
        this.loaders = loaders;

        // complete the initialization
        loaders.values().forEach(l -> l.initRemotePackageMap(cf, parentLayers));
    }


    /**
     * Returns the class loader for the named module
     */
    public Loader loaderFor(String name) {
        Loader loader = loaders.get(name);
        assert loader != null;
        return loader;
    }

    /**
     * Returns a stream of the loaders in this pool.
     */
    public Stream<Loader> loaders() {
        return loaders.values().stream();
    }

}
