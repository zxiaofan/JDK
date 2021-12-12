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

import java.nio.file.Path;
import java.util.Objects;
import jdk.tools.jlink.plugin.ResourcePoolEntry;

public final class ResourcePoolEntryFactory {
    private ResourcePoolEntryFactory() {}

    public static ResourcePoolEntry create(String path,
            ResourcePoolEntry.Type type, byte[] content) {
        return new ByteArrayResourcePoolEntry(moduleFrom(path), path, type, content);
    }

    public static ResourcePoolEntry create(String path,
            ResourcePoolEntry.Type type, Path file) {
        return new PathResourcePoolEntry(moduleFrom(path), path, type, file);
    }

    public static ResourcePoolEntry create(ResourcePoolEntry original, byte[] content) {
        return new ByteArrayResourcePoolEntry(original.moduleName(),
                original.path(), original.type(), content);
    }

    public static ResourcePoolEntry create(ResourcePoolEntry original, Path file) {
        return new PathResourcePoolEntry(original.moduleName(),
                original.path(), original.type(), file);
    }

    public static ResourcePoolEntry createSymbolicLink(String path,
                                                       ResourcePoolEntry.Type type,
                                                       ResourcePoolEntry target) {
        return new SymLinkResourcePoolEntry(moduleFrom(path), path, type, target);
    }

    private static String moduleFrom(String path) {
        Objects.requireNonNull(path);
        if (path.isEmpty() || path.charAt(0) != '/') {
            throw new IllegalArgumentException(path + " must start with /");
        }
        String noRoot = path.substring(1);
        int idx = noRoot.indexOf('/');
        if (idx == -1) {
            throw new IllegalArgumentException("/ missing after module: " + path);
        }
        return noRoot.substring(0, idx);
    }
}
