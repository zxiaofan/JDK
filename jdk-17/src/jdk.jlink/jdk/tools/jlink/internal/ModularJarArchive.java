/*
 * Copyright (c) 2014, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.tools.jlink.internal;

import java.nio.file.Path;
import java.util.Objects;
import java.util.zip.ZipEntry;

import jdk.tools.jlink.internal.Archive.Entry.EntryType;

/**
 * An Archive backed by a jar file.
 */
public class ModularJarArchive extends JarArchive {

    private static final String JAR_EXT = ".jar";

    public ModularJarArchive(String mn, Path jmod, Runtime.Version version) {
        super(mn, jmod, version);
        String filename = Objects.requireNonNull(jmod.getFileName()).toString();
        if (!filename.endsWith(JAR_EXT)) {
            throw new UnsupportedOperationException("Unsupported format: " + filename);
        }
    }

    @Override
    EntryType toEntryType(String section) {
        return EntryType.CLASS_OR_RESOURCE;
    }

    @Override
    Entry toEntry(ZipEntry ze) {
        String name = ze.getName();
        EntryType type = toEntryType(name);
        return new JarEntry(ze.getName(), getFileName(name), type, getJarFile(), ze);
    }

    @Override
    String getFileName(String entryName) {
        return entryName;
    }
}
