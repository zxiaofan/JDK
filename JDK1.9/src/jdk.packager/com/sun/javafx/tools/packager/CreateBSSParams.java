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

import com.sun.javafx.tools.resource.PackagerResource;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreateBSSParams extends CommonParams {
    final List<PackagerResource> resources = new ArrayList<PackagerResource>();

    @Override
    public void addResource(File baseDir, String path) {
        resources.add(new PackagerResource(baseDir, path));
    }

    @Override
    public void addResource(File baseDir, File file) {
        resources.add(new PackagerResource(baseDir, file));
    }

    @Override
    public void validate() throws PackagerException {
        if (outdir == null) {
            throw new PackagerException("ERR_MissingArgument", "-outdir");
        }
    }
}
