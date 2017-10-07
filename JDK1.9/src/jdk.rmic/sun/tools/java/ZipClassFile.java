/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
import java.util.zip.*;

/**
 * This class is used to represent a file loaded from the class path, and
 * is a zip file entry.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
final
class ZipClassFile extends ClassFile {
    private final ZipFile zipFile;
    private final ZipEntry zipEntry;

    /**
     * Constructor for instance representing a zip file entry
     */
    public ZipClassFile(ZipFile zf, ZipEntry ze) {
        this.zipFile = zf;
        this.zipEntry = ze;
    }

    @Override
    public boolean isZipped() {
        return true;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        try {
            return zipFile.getInputStream(zipEntry);
        } catch (ZipException e) {
            throw new IOException(e.getMessage());
        }
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public boolean isDirectory() {
        return zipEntry.getName().endsWith("/");
    }

    @Override
    public long lastModified() {
        return zipEntry.getTime();
    }

    @Override
    public String getPath() {
        return zipFile.getName() + "(" + zipEntry.getName() + ")";
    }

    @Override
    public String getName() {
        return zipEntry.getName();
    }

//JCOV
    @Override
    public String getAbsoluteName() {
        return zipFile.getName() + "(" + zipEntry.getName() + ")";
    }
// end JCOV

    @Override
    public long length() {
        return zipEntry.getSize();
    }

    @Override
    public String toString() {
        return zipEntry.toString();
    }
}
