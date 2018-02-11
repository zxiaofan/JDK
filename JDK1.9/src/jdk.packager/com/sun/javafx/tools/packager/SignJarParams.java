/*
 * Copyright (c) 2011, 2015, Oracle and/or its affiliates. All rights reserved.
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

public class SignJarParams extends CommonParams {

    final List<PackagerResource> resources = new ArrayList<PackagerResource>();

    File keyStore;
    String alias;
    String storePass;
    String keyPass;
    String storeType = "jks";
    Boolean verbose = false;

    public void setVerbose(boolean v) {
        verbose = v;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setKeyPass(String keyPass) {
        this.keyPass = keyPass;
    }

    public void setKeyStore(File keyStore) {
        this.keyStore = keyStore;
    }

    public void setStorePass(String storePass) {
        this.storePass = storePass;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
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
    public void validate() throws PackagerException {
        if (keyStore == null) {
            throw new PackagerException("ERR_InvalidStoreFile",
                    "null keystore");
        }
        if (!keyStore.isFile()) {
            throw new PackagerException("ERR_InvalidStoreFile", keyStore.getAbsolutePath());
        }
        if (alias == null) {
            throw new PackagerException("ERR_MissingArgument", "alias");
        }
        if (storeType == null) {
            storeType = "jks";
        }

        if (outdir != null) {
            outdir.mkdirs();
        }
    }

}
