/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

import java.io.File;

public abstract class CommonParams {

    File outdir;
    boolean verbose;

    public void setOutdir(File outdir) {
        this.outdir = outdir;
    }

    public void setVerbose(boolean v) {
        verbose = v;
    }

    public abstract void addResource(File baseDir, String path);

    public abstract void addResource(File baseDir, File file);

    public abstract void validate() throws PackagerException;

    @Override
    public String toString() {
        return "CommonParams{" + "outdir=" + outdir + " verbose=" + verbose + '}';
    }

}
