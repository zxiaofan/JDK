/*
 * Copyright (c) 1995, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.java;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.*;

/**
 * Abstract class to represent a class file.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
public
abstract class ClassFile {
    /**
     * Factory method to create a ClassFile backed by a File.
     *
     * @param file a File object
     * @return a new ClassFile
     */
    public static ClassFile newClassFile(File file) {
        return new FileClassFile(file);
    }

    /**
     * Factory method to create a ClassFile backed by a ZipEntry.
     *
     * @param zf a ZipFile
     * @param ze a ZipEntry within the zip file
     * @return a new ClassFile
     */
    public static ClassFile newClassFile(ZipFile zf, ZipEntry ze) {
        return new ZipClassFile(zf, ze);
    }

    /**
     * Factory method to create a ClassFile backed by a nio Path.
     *
     * @param path nio Path object
     * @return a new ClassFile
     */
    public static ClassFile newClassFile(Path path) {
        return Files.exists(path)? new PathClassFile(path) : null;
    }

    /**
     * Returns true if this is zip file entry
     */
    public abstract boolean isZipped();

    /**
     * Returns input stream to either regular file or zip file entry
     */
    public abstract InputStream getInputStream() throws IOException;

    /**
     * Returns true if file exists.
     */
    public abstract boolean exists();

    /**
     * Returns true if this is a directory.
     */
    public abstract boolean isDirectory();

    /**
     * Return last modification time
     */
    public abstract long lastModified();

    /**
     * Get file path. The path for a zip file entry will also include
     * the zip file name.
     */
    public abstract String getPath();

    /**
     * Get name of file entry excluding directory name
     */
    public abstract String getName();

    /**
     * Get absolute name of file entry
     */
    public abstract String getAbsoluteName();

    /**
     * Get length of file
     */
    public abstract long length();
}
