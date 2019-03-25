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
package jdk.internal.jrtfs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.attribute.FileAttributeView;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.FileStoreAttributeView;
import java.util.Objects;

/**
 * File store implementation for jrt file systems.
 *
 * @implNote This class needs to maintain JDK 8 source compatibility.
 *
 * It is used internally in the JDK to implement jimage/jrtfs access,
 * but also compiled and delivered as part of the jrtfs.jar to support access
 * to the jimage file provided by the shipped JDK by tools running on JDK 8.
 */
final class JrtFileStore extends FileStore {

    protected final FileSystem jrtfs;

    JrtFileStore(JrtPath jrtPath) {
        this.jrtfs = jrtPath.getFileSystem();
    }

    @Override
    public String name() {
        return jrtfs.toString() + "/";
    }

    @Override
    public String type() {
        return "jrtfs";
    }

    @Override
    public boolean isReadOnly() {
        return jrtfs.isReadOnly();
    }

    @Override
    public boolean supportsFileAttributeView(String name) {
        return name.equals("basic") || name.equals("jrt");
    }

    @Override
    @SuppressWarnings("unchecked")
    public <V extends FileStoreAttributeView> V getFileStoreAttributeView(Class<V> type) {
        Objects.requireNonNull(type, "type");
        return (V) null;
    }

    @Override
    public long getTotalSpace() throws IOException {
        throw new UnsupportedOperationException("getTotalSpace");
    }

    @Override
    public long getUsableSpace() throws IOException {
        throw new UnsupportedOperationException("getUsableSpace");
    }

    @Override
    public long getUnallocatedSpace() throws IOException {
        throw new UnsupportedOperationException("getUnallocatedSpace");
    }

    @Override
    public Object getAttribute(String attribute) throws IOException {
        throw new UnsupportedOperationException("does not support " + attribute);
    }

    @Override
    public boolean supportsFileAttributeView(Class<? extends FileAttributeView> type) {
        return type == BasicFileAttributeView.class ||
               type == JrtFileAttributeView.class;
    }
}
