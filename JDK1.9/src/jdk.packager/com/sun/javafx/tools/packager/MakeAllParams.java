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

public class MakeAllParams {
    String appClass;
    String preloader;
    String classpath;
    String appName;
    int width;
    int height;
    boolean verbose = false;

    public void setAppClass(String appClass) {
        this.appClass = appClass;
    }

    public void setPreloader(String preloader) {
        this.preloader = preloader;
    }

    public void setClasspath(String classpath) {
        this.classpath = classpath;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setVerbose(boolean verbose) {
        this.verbose = verbose;
    }

    public void validate() throws PackagerException {
    }
}
