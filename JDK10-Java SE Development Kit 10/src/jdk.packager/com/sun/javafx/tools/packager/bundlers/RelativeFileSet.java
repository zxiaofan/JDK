/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.tools.packager.bundlers;

import com.oracle.tools.packager.Log;

import java.io.File;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @deprecated use {@link ToolProvider} to locate the {@code "javapackager"} tool instead.
 */
@Deprecated(since="10", forRemoval=true)
public class RelativeFileSet extends com.oracle.tools.packager.RelativeFileSet {
    public RelativeFileSet(File base, Set<File> files) {
        super(base, files);
    }
}
