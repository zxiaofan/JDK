/*
 * Copyright (c) 1998, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.doclets.internal.toolkit.util;

import java.util.Map;
import java.util.WeakHashMap;

import javax.tools.JavaFileManager;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;

import com.sun.tools.doclets.internal.toolkit.Configuration;

/**
 * Factory for DocFile objects.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @since 1.8
 */
@Deprecated
abstract class DocFileFactory {
    private static final Map<Configuration, DocFileFactory> factories = new WeakHashMap<>();

    /**
     * Get the appropriate factory, based on the file manager given in the
     * configuration.
     */
    static synchronized DocFileFactory getFactory(Configuration configuration) {
        DocFileFactory f = factories.get(configuration);
        if (f == null) {
            JavaFileManager fm = configuration.getFileManager();
            if (fm instanceof StandardJavaFileManager) {
                f = new StandardDocFileFactory(configuration);
            } else {
                throw new IllegalStateException();
            }
            factories.put(configuration, f);
        }
        return f;
    }

    protected Configuration configuration;

    protected DocFileFactory(Configuration configuration) {
        this.configuration = configuration;
    }

    /** Create a DocFile for a directory. */
    abstract DocFile createFileForDirectory(String file);

    /** Create a DocFile for a file that will be opened for reading. */
    abstract DocFile createFileForInput(String file);

    /** Create a DocFile for a file that will be opened for writing. */
    abstract DocFile createFileForOutput(DocPath path);

    /**
     * List the directories and files found in subdirectories along the
     * elements of the given location.
     * @param location currently, only {@link StandardLocation#SOURCE_PATH} is supported.
     * @param path the subdirectory of the directories of the location for which to
     *  list files
     */
    abstract Iterable<DocFile> list(Location location, DocPath path);
}
