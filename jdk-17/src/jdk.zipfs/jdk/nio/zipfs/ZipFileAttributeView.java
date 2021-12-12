/*
 * Copyright (c) 2009, 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nio.zipfs;

import java.io.IOException;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.PosixFilePermission;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Xueming Shen, Rajendra Gutupalli, Jaya Hangal
 */
class ZipFileAttributeView implements BasicFileAttributeView {
    static enum AttrID {
        size,
        creationTime,
        lastAccessTime,
        lastModifiedTime,
        isDirectory,
        isRegularFile,
        isSymbolicLink,
        isOther,
        fileKey,
        compressedSize,
        crc,
        method,
        owner,
        group,
        permissions
    }

    final ZipPath path;
    private final boolean isZipView;

    ZipFileAttributeView(ZipPath path, boolean isZipView) {
        this.path = path;
        this.isZipView = isZipView;
    }

    @Override
    public String name() {
        return isZipView ? "zip" : "basic";
    }

    @Override
    public BasicFileAttributes readAttributes() throws IOException {
        return path.readAttributes();
    }

    @Override
    public void setTimes(FileTime lastModifiedTime,
                         FileTime lastAccessTime,
                         FileTime createTime)
        throws IOException
    {
        path.setTimes(lastModifiedTime, lastAccessTime, createTime);
    }

    public void setPermissions(Set<PosixFilePermission> perms) throws IOException {
        path.setPermissions(perms);
    }

    @SuppressWarnings("unchecked")
    void setAttribute(String attribute, Object value)
        throws IOException
    {
        try {
            if (AttrID.valueOf(attribute) == AttrID.lastModifiedTime)
                setTimes((FileTime)value, null, null);
            if (AttrID.valueOf(attribute) == AttrID.lastAccessTime)
                setTimes(null, (FileTime)value, null);
            if (AttrID.valueOf(attribute) == AttrID.creationTime)
                setTimes(null, null, (FileTime)value);
            if (AttrID.valueOf(attribute) == AttrID.permissions)
                setPermissions((Set<PosixFilePermission>)value);
        } catch (IllegalArgumentException x) {
            throw new UnsupportedOperationException("'" + attribute +
                "' is unknown or read-only attribute");
        }
    }

    Map<String, Object> readAttributes(String attributes)
        throws IOException
    {
        ZipFileAttributes zfas = (ZipFileAttributes)readAttributes();
        LinkedHashMap<String, Object> map = new LinkedHashMap<>();
        if ("*".equals(attributes)) {
            for (AttrID id : AttrID.values()) {
                try {
                    map.put(id.name(), attribute(id, zfas));
                } catch (IllegalArgumentException x) {}
            }
        } else {
            String[] as = attributes.split(",");
            for (String a : as) {
                try {
                    map.put(a, attribute(AttrID.valueOf(a), zfas));
                } catch (IllegalArgumentException x) {}
            }
        }
        return map;
    }

    Object attribute(AttrID id, ZipFileAttributes zfas) {
        switch (id) {
        case size:
            return zfas.size();
        case creationTime:
            return zfas.creationTime();
        case lastAccessTime:
            return zfas.lastAccessTime();
        case lastModifiedTime:
            return zfas.lastModifiedTime();
        case isDirectory:
            return zfas.isDirectory();
        case isRegularFile:
            return zfas.isRegularFile();
        case isSymbolicLink:
            return zfas.isSymbolicLink();
        case isOther:
            return zfas.isOther();
        case fileKey:
            return zfas.fileKey();
        case compressedSize:
            if (isZipView)
                return zfas.compressedSize();
            break;
        case crc:
            if (isZipView)
                return zfas.crc();
            break;
        case method:
            if (isZipView)
                return zfas.method();
            break;
        case permissions:
            if (isZipView) {
                return zfas.storedPermissions().orElse(null);
            }
            break;
        default:
            break;
        }
        return null;
    }
}
