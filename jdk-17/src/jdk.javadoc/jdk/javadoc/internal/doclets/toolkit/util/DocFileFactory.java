/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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

package jdk.javadoc.internal.doclets.toolkit.util;

import java.nio.file.Path;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileManager.Location;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;

import jdk.javadoc.internal.doclets.toolkit.BaseConfiguration;
import jdk.javadoc.internal.doclets.toolkit.DocletException;

/**
 * Factory for DocFile objects.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 */
public abstract class DocFileFactory {
    /**
     * Get the appropriate factory, based on the file manager given in the
     * configuration.
     *
     * @param configuration the configuration for this doclet
     * @return the factory associated with this configuration
     */
    public static synchronized DocFileFactory getFactory(BaseConfiguration configuration) {
        DocFileFactory f = configuration.docFileFactory;
        if (f == null) {
            JavaFileManager fm = configuration.getFileManager();
            if (fm instanceof StandardJavaFileManager) {
                f = new StandardDocFileFactory(configuration);
            } else {
                throw new IllegalStateException();
            }
            configuration.docFileFactory = f;
        }
        return f;
    }

    protected BaseConfiguration configuration;

    protected DocFileFactory(BaseConfiguration configuration) {
        this.configuration = configuration;
    }

    public abstract void setDestDir(String dir) throws DocletException;

    /** Create a DocFile for a directory. */
    abstract DocFile createFileForDirectory(String file);

    /** Create a DocFile for a file that will be opened for reading. */
    abstract DocFile createFileForInput(String file);

    /** Create a DocFile for a file that will be opened for reading. */
    abstract DocFile createFileForInput(Path file);

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
