/*
 * Copyright (c) 2005, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.file;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Context.Factory;

/**
 * Caching implementation of FSInfo.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public class CacheFSInfo extends FSInfo {

    /**
     * Register a Context.Factory to create a CacheFSInfo.
     */
    public static void preRegister(Context context) {
        context.put(FSInfo.class, (Factory<FSInfo>)c -> {
                FSInfo instance = new CacheFSInfo();
                c.put(FSInfo.class, instance);
                return instance;
            });
    }

    public void clearCache() {
        cache.clear();
    }

    @Override
    public Path getCanonicalFile(Path file) {
        Entry e = getEntry(file);
        return e.canonicalFile;
    }

    @Override
    public boolean exists(Path file) {
        Entry e = getEntry(file);
        return e.exists;
    }

    @Override
    public boolean isDirectory(Path file) {
        Entry e = getEntry(file);
        return e.isDirectory;
    }

    @Override
    public boolean isFile(Path file) {
        Entry e = getEntry(file);
        return e.isFile;
    }

    @Override
    public List<Path> getJarClassPath(Path file) throws IOException {
        // don't bother to lock the cache, because it is thread-safe, and
        // because the worst that can happen would be to create two identical
        // jar class paths together and have one overwrite the other.
        Entry e = getEntry(file);
        if (e.jarClassPath == null)
            e.jarClassPath = super.getJarClassPath(file);
        return e.jarClassPath;
    }

    private Entry getEntry(Path file) {
        // don't bother to lock the cache, because it is thread-safe, and
        // because the worst that can happen would be to create two identical
        // entries together and have one overwrite the other.
        Entry e = cache.get(file);
        if (e == null) {
            e = new Entry();
            e.canonicalFile = super.getCanonicalFile(file);
            e.exists = super.exists(file);
            e.isDirectory = super.isDirectory(file);
            e.isFile = super.isFile(file);
            cache.put(file, e);
        }
        return e;
    }

    // could also be a Map<File,SoftReference<Entry>> ?
    private final Map<Path,Entry> cache = new ConcurrentHashMap<>();

    private static class Entry {
        Path canonicalFile;
        boolean exists;
        boolean isFile;
        boolean isDirectory;
        List<Path> jarClassPath;
    }
}
