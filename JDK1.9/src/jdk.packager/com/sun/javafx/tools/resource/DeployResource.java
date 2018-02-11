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

package com.sun.javafx.tools.resource;

import java.io.File;

public class DeployResource extends PackagerResource {
    private final Type type;
    private final String mode;
    private final String os;
    private final String arch;

    public static enum Type {
        UNKNOWN, jnlp, jar, nativelib, icon, license, data
    };

    public static final String TYPE_LICENSE = "license";
    public static final String TYPE_DATA    = "data";

    public DeployResource(final File baseDir, final String path) {
        this(baseDir, path, "eager");
    }

    public DeployResource(final File baseDir, final File file) {
        this(baseDir, file, "eager");
    }

    public DeployResource(final File baseDir, final String path,
                          final String mode) {
        super(baseDir, path);
        this.mode = mode;
        this.type = null;
        this.os = null;
        this.arch = null;
    }

    public DeployResource(final File baseDir, final File file,
                          final String mode) {
        this(baseDir, file, mode, null, null, null);
    }

    public DeployResource(final File baseDir, final File file,
                          final String mode, final String type,
                          final String os, final String arch) {
        super(baseDir, file);
        if (type == null) {
           if (file.getName().endsWith(".jar")) {
               this.type = Type.jar;
           } else if (file.getName().endsWith(".jnlp")) {
               this.type = Type.jnlp;
           } else {
            this.type = Type.UNKNOWN;
           }
        } else {
              this.type = Type.valueOf(type);
        }
        this.os = os;
        this.arch = arch;
        this.mode = mode;
    }

    public String getMode() {
        return mode;
    }

    public Type getType() {
        return type;
    }

    public String getOs() {
        return os;
    }

    public String getArch() {
        return arch;
    }
}
