/*
 * Copyright (c) 2014, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.internal;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * BasicBundlers
 *
 * A basic bundlers collection that loads the default bundlers.
 * Loads the common bundlers.
 * <UL>
 *     <LI>Windows file image</LI>
 *     <LI>Mac .app</LI>
 *     <LI>Linux file image</LI>
 *     <LI>Windows MSI</LI>
 *     <LI>Windows EXE</LI>
 *     <LI>Mac DMG</LI>
 *     <LI>Mac PKG</LI>
 *     <LI>Linux DEB</LI>
 *     <LI>Linux RPM</LI>
 *
 * </UL>
 */
public class BasicBundlers implements Bundlers {

    boolean defaultsLoaded = false;

    private final Collection<Bundler> bundlers = new CopyOnWriteArrayList<>();

    @Override
    public Collection<Bundler> getBundlers() {
        return Collections.unmodifiableCollection(bundlers);
    }

    @Override
    public Collection<Bundler> getBundlers(String type) {
        if (type == null) return Collections.emptySet();
        switch (type) {
            case "NONE":
                return Collections.emptySet();
            case "ALL":
                return getBundlers();
            default:
                return Arrays.asList(getBundlers().stream()
                        .filter(b -> type.equalsIgnoreCase(b.getBundleType()))
                        .toArray(Bundler[]::new));
        }
    }

    // Loads bundlers from the META-INF/services direct
    @Override
    public void loadBundlersFromServices(ClassLoader cl) {
        ServiceLoader<Bundler> loader = ServiceLoader.load(Bundler.class, cl);
        for (Bundler aLoader : loader) {
            bundlers.add(aLoader);
        }
    }
}
