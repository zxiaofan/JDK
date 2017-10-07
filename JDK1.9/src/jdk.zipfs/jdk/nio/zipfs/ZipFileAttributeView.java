/*
 * Copyright (c) 2009, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.nio.file.attribute.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/*
 * @author  Xueming Shen, Rajendra Gutupalli, Jaya Hangal
 */

class ZipFileAttributeView implements BasicFileAttributeView
{
    private static enum AttrID {
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
        method
    };

    private final ZipPath path;
    private final boolean isZipView;

    private ZipFileAttributeView(ZipPath path, boolean isZipView) {
        this.path = path;
        this.isZipView = isZipView;
    }

    @SuppressWarnings("unchecked") // Cast to V
    static <V extends FileAttributeView> V get(ZipPath path, Class<V> type) {
        if (type == null)
            throw new NullPointerException();
        if (type == BasicFileAttributeView.class)
            return (V)new ZipFileAttributeView(path, false);
        if (type == ZipFileAttributeView.class)
            return (V)new ZipFileAttributeView(path, true);
        return null;
    }

    static ZipFileAttributeView get(ZipPath path, String type) {
        if (type == null)
            throw new NullPointerException();
        if (type.equals("basic"))
            return new ZipFileAttributeView(path, false);
        if (type.equals("zip"))
            return new ZipFileAttributeView(path, true);
        return null;
    }

    @Override
    public String name() {
        return isZipView ? "zip" : "basic";
    }

    public ZipFileAttributes readAttributes() throws IOException
    {
        return path.getAttributes();
    }

    @Override
    public void setTimes(FileTime lastModifiedTime,
                         FileTime lastAccessTime,
                         FileTime createTime)
        throws IOException
    {
        path.setTimes(lastModifiedTime, lastAccessTime, createTime);
    }

    void setAttribute(String attribute, Object value)
        throws IOException
    {
        try {
            if (AttrID.valueOf(attribute) == AttrID.lastModifiedTime)
                setTimes ((FileTime)value, null, null);
            if (AttrID.valueOf(attribute) == AttrID.lastAccessTime)
                setTimes (null, (FileTime)value, null);
            if (AttrID.valueOf(attribute) == AttrID.creationTime)
                setTimes (null, null, (FileTime)value);
            return;
        } catch (IllegalArgumentException x) {}
        throw new UnsupportedOperationException("'" + attribute +
            "' is unknown or read-only attribute");
    }

    Map<String, Object> readAttributes(String attributes)
        throws IOException
    {
        ZipFileAttributes zfas = readAttributes();
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
        }
        return null;
    }
}
