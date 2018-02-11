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

import java.io.InputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * This class is used to represent a file loaded from the class path, and
 * is represented by nio Path.
 *
 * WARNING: The contents of this source file are not part of any
 * supported API.  Code that depends on them does so at its own risk:
 * they are subject to change or removal without notice.
 */
final
class PathClassFile extends ClassFile {
    private final Path path;
    private final BasicFileAttributes attrs;

    /**
     * Constructor for instance representing a Path
     */
    public PathClassFile(Path path) {
        this.path = path;
        try {
            this.attrs = Files.readAttributes(path, BasicFileAttributes.class);
        } catch (IOException ioExp) {
            throw new UncheckedIOException(ioExp);
        }
    }

    @Override
    public boolean isZipped() {
        return false;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return Files.newInputStream(path);
    }

    @Override
    public boolean exists() {
        return true;
    }

    @Override
    public boolean isDirectory() {
        return attrs.isDirectory();
    }

    @Override
    public long lastModified() {
        return attrs.lastModifiedTime().toMillis();
    }

    @Override
    public String getPath() {
        return path.toUri().toString();
    }

    @Override
    public String getName() {
        return path.getFileName().toString();
    }

//JCOV
    @Override
    public String getAbsoluteName() {
        return path.toAbsolutePath().toUri().toString();
    }
// end JCOV

    @Override
    public long length() {
        return attrs.size();
    }

    @Override
    public String toString() {
        return path.toString();
    }
}
