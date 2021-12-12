/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.util.Objects;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

/**
 * A ResourcePoolEntry backed by a given Archive Entry.
 */
final class ArchiveEntryResourcePoolEntry extends AbstractResourcePoolEntry {
    private final Archive.Entry entry;

    /**
     * Create a new ArchiveResourcePoolEntry.
     *
     * @param module The module name.
     * @param path The data path identifier.
     * @param entry The archive Entry.
     */
    ArchiveEntryResourcePoolEntry(String module, String path, Archive.Entry entry) {
        super(module, path, getImageFileType(Objects.requireNonNull(entry)));
        this.entry = entry;
    }

    @Override
    public InputStream content() {
        try {
            return entry.stream();
        } catch (IOException ex) {
            throw new UncheckedIOException(ex);
        }
    }

    @Override
    public long contentLength() {
        return entry.size();
    }

    private static ResourcePoolEntry.Type getImageFileType(Archive.Entry entry) {
        switch(entry.type()) {
            case CLASS_OR_RESOURCE:
                return Type.CLASS_OR_RESOURCE;
            case CONFIG:
                return Type.CONFIG;
            case HEADER_FILE:
                return Type.HEADER_FILE;
            case LEGAL_NOTICE:
                return Type.LEGAL_NOTICE;
            case MAN_PAGE:
                return Type.MAN_PAGE;
            case NATIVE_CMD:
                return Type.NATIVE_CMD;
            case NATIVE_LIB:
                return Type.NATIVE_LIB;
            default:
                throw new IllegalArgumentException("Unknown archive entry type: " + entry.type());
        }
    }
}
