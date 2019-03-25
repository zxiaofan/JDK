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
package jdk.tools.jlink.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Objects;
import java.util.stream.Stream;

/**
 * An Archive of all content, classes, resources, configuration files, and
 * other, for a module.
 */
public interface Archive {

    /**
     * Entry is contained in an Archive
     */
    public abstract class Entry {

        public static enum EntryType {
            MODULE_NAME,
            CLASS_OR_RESOURCE,
            CONFIG,
            NATIVE_LIB,
            NATIVE_CMD,
            HEADER_FILE,
            LEGAL_NOTICE,
            MAN_PAGE,
            SERVICE;
        }

        private final String name;
        private final EntryType type;
        private final Archive archive;
        private final String path;

        /**
         * Constructs an entry of the given archive
         * @param archive archive
         * @param path
         * @param name an entry name that does not contain the module name
         * @param type
         */
        public Entry(Archive archive, String path, String name, EntryType type) {
            this.archive = Objects.requireNonNull(archive);
            this.path = Objects.requireNonNull(path);
            this.name = Objects.requireNonNull(name);
            this.type = Objects.requireNonNull(type);
        }

        public final Archive archive() {
            return archive;
        }

        public final EntryType type() {
            return type;
        }

        /**
         * Returns the name of this entry.
         */
        public final String name() {
            return name;
        }

        /**
         * Returns the name representing a ResourcePoolEntry in the form of:
         *    /$MODULE/$ENTRY_NAME
         */
        public final String getResourcePoolEntryName() {
            return "/" + archive.moduleName() + "/" + name;
        }

        @Override
        public String toString() {
            return "type " + type.name() + " path " + path;
        }

        /*
         * Returns the number of uncompressed bytes for this entry.
         */
        public abstract long size();

        public abstract InputStream stream() throws IOException;
    }

    /*
     * The module name.
     */
    String moduleName();

    /*
     * Returns the path to this module's content
     */
    Path getPath();

    /*
     * Stream of Entry.
     * The stream of entries needs to be closed after use
     * since it might cover lazy I/O based resources.
     * So callers need to use a try-with-resources block.
     */
    Stream<Entry> entries();

    /*
     * Open the archive
     */
    void open() throws IOException;

    /*
     * Close the archive
     */
    void close() throws IOException;
}
