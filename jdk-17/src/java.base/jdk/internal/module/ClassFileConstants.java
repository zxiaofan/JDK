/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.module;


// Constants in module-info.class files

public class ClassFileConstants {

    private ClassFileConstants() { }

    // Attribute names
    public static final String MODULE             = "Module";
    public static final String SOURCE_FILE        = "SourceFile";
    public static final String SDE                = "SourceDebugExtension";

    public static final String MODULE_PACKAGES    = "ModulePackages";
    public static final String MODULE_MAIN_CLASS  = "ModuleMainClass";
    public static final String MODULE_TARGET      = "ModuleTarget";
    public static final String MODULE_HASHES      = "ModuleHashes";
    public static final String MODULE_RESOLUTION  = "ModuleResolution";

    // access, requires, exports, and opens flags
    public static final int ACC_MODULE        = 0x8000;
    public static final int ACC_OPEN          = 0x0020;
    public static final int ACC_TRANSITIVE    = 0x0020;
    public static final int ACC_STATIC_PHASE  = 0x0040;
    public static final int ACC_SYNTHETIC     = 0x1000;
    public static final int ACC_MANDATED      = 0x8000;

    // ModuleResolution_attribute resolution flags
    public static final int DO_NOT_RESOLVE_BY_DEFAULT   = 0x0001;
    public static final int WARN_DEPRECATED             = 0x0002;
    public static final int WARN_DEPRECATED_FOR_REMOVAL = 0x0004;
    public static final int WARN_INCUBATING             = 0x0008;

}
