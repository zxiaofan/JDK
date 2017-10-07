/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.oracle.tools.packager;

import com.oracle.tools.packager.jnlp.JNLPBundler;
import com.oracle.tools.packager.linux.LinuxRpmBundler;
import com.oracle.tools.packager.mac.MacAppStoreBundler;
import com.oracle.tools.packager.mac.MacDmgBundler;
import com.oracle.tools.packager.mac.MacPkgBundler;
import com.oracle.tools.packager.linux.LinuxAppBundler;
import com.oracle.tools.packager.linux.LinuxDebBundler;
import com.oracle.tools.packager.mac.MacAppBundler;
import com.oracle.tools.packager.windows.WinAppBundler;
import com.oracle.tools.packager.windows.WinExeBundler;
import com.oracle.tools.packager.windows.WinMsiBundler;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.ServiceLoader;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * A basic bundlers collection that loads the OpenJFX default bundlers.
 * Loads the bundlers common to OpenJFX.
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

    private Collection<Bundler> bundlers = new CopyOnWriteArrayList<>();

    public Collection<Bundler> getBundlers() {
        return Collections.unmodifiableCollection(bundlers);
    }

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

    /**
     * A list of the "standard" parameters that bundlers should support
     * or fall back to when their specific parameters are not used.
     * @return an unmodifieable collection of the standard parameters.
     */
    public Collection<BundlerParamInfo> getStandardParameters() {
        //TODO enumerate the stuff in BundleParams
        return null;
    }

    public void loadDefaultBundlers() {
        // no-op.  We now load all bundlers from module system.
    }

    /**
     * Loads bundlers from the META-INF/services direct
     */
    public void loadBundlersFromServices(ClassLoader cl) {
        ServiceLoader<Bundler> loader = ServiceLoader.load(Bundler.class, cl);
        for (Bundler aLoader : loader) {
            bundlers.add(aLoader);
        }
    }

    public void loadBundler(Bundler bundler) {
        bundlers.add(bundler);
    }
}
