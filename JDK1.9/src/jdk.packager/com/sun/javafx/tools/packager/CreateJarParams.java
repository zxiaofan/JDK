/*
 * Copyright (c) 2011, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager;

import com.sun.javafx.tools.resource.PackagerResource;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateJarParams extends CommonParams {

    final List<PackagerResource> resources = new ArrayList<PackagerResource>();

    String applicationClass;
    String fallbackClass;
    String preloader;
    String classpath;
    Map<String, String> manifestAttrs;
    boolean embedLauncher = true;
    boolean css2bin = true;
    String outfile;
    String fxVersion = PackagerLib.JAVAFX_VERSION;
    Boolean allPermissions = false;
    String codebase;

    List<String> arguments;
    List<Param> params;

    public void setArguments(List<String> args) {
        this.arguments = args;
    }

    public void setParams(List<Param> params) {
        this.params = params;
    }

    public void setApplicationClass(String applicationClass) {
        this.applicationClass = applicationClass;
    }

    public void setPreloader(String preloader) {
        this.preloader = preloader;
    }

    public void setFallback(String fallback) {
        this.fallbackClass = fallback;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public void setCss2bin(boolean css2bin) {
        this.css2bin = css2bin;
    }

    /**
     * In JKD8/FX8 launcher is never embedded,
     * app must use main to call Application launcher()
     * @deprecated
     * @param embedLauncher
     */
    public void setEmbedLauncher(boolean embedLauncher) {
        this.embedLauncher = embedLauncher;
    }

    public void setOutfile(String outfile) {
        this.outfile = outfile;
    }

    public void setManifestAttrs(Map<String, String> manifestAttrs) {
        this.manifestAttrs = manifestAttrs;
    }

    public void setFxVersion(String fxVersion) {
        this.fxVersion = fxVersion;
    }

    public void setAllPermissions(Boolean allPermissions) {
        this.allPermissions = allPermissions;
    }

    public void setCodebase(String codebase) {
        this.codebase = codebase;
    }

    @Override
    public void addResource(File baseDir, String path) {
        resources.add(new PackagerResource(baseDir, path));
    }

    @Override
    public void addResource(File baseDir, File file) {
        resources.add(new PackagerResource(baseDir, file));
    }

    @Override
    public String toString() {
        return "CreateJarParams{" + "applicationClass=" + applicationClass
                + " preloader=" + preloader + " classpath=" + classpath
                + " manifestAttrs=" + manifestAttrs
                + " embedLauncher=deprecated" + " css2bin=" + css2bin
                + " outfile=" + outfile + " sdkHome=" + fxVersion + '}'
                + "            CommonParams{" + "outdir=" + outdir
                + " verbose=" + verbose + " resources=" + resources + '}';
    }

    @Override
    public void validate() throws PackagerException {
        if (outfile == null) {
            throw new PackagerException("ERR_MissingArgument", "-outfile");
        }
        if (resources.isEmpty()) {
            throw new PackagerException("ERR_MissingArgument", "-srcfiles (-srcdir)");
        }
        //otherwise it could be special case of "update jar"
        if (resources.size() != 1 && applicationClass == null) {
            throw new PackagerException("ERR_MissingArgument", "-appclass");
        }
    }
}
