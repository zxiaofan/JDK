/*
 * Copyright (c) 2008, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.fs;

import java.nio.file.*;
import java.nio.file.attribute.*;
import java.nio.file.spi.FileTypeDetector;
import java.io.IOException;

import jdk.internal.util.StaticProperty;

/**
 * Linux implementation of FileSystemProvider
 */

class LinuxFileSystemProvider extends UnixFileSystemProvider {
    public LinuxFileSystemProvider() {
        super();
    }

    @Override
    LinuxFileSystem newFileSystem(String dir) {
        return new LinuxFileSystem(this, dir);
    }

    @Override
    LinuxFileStore getFileStore(UnixPath path) throws IOException {
        return new LinuxFileStore(path);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <V extends FileAttributeView> V getFileAttributeView(Path obj,
                                                                Class<V> type,
                                                                LinkOption... options)
    {
        if (type == DosFileAttributeView.class) {
            return (V) new LinuxDosFileAttributeView(UnixPath.toUnixPath(obj),
                                                     Util.followLinks(options));
        }
        if (type == UserDefinedFileAttributeView.class) {
            return (V) new LinuxUserDefinedFileAttributeView(UnixPath.toUnixPath(obj),
                                                             Util.followLinks(options));
        }
        return super.getFileAttributeView(obj, type, options);
    }

    @Override
    public DynamicFileAttributeView getFileAttributeView(Path obj,
                                                         String name,
                                                         LinkOption... options)
    {
        if (name.equals("dos")) {
            return new LinuxDosFileAttributeView(UnixPath.toUnixPath(obj),
                                                 Util.followLinks(options));
        }
        if (name.equals("user")) {
            return new LinuxUserDefinedFileAttributeView(UnixPath.toUnixPath(obj),
                                                         Util.followLinks(options));
        }
        return super.getFileAttributeView(obj, name, options);
    }

    @Override
    @SuppressWarnings("unchecked")
    public <A extends BasicFileAttributes> A readAttributes(Path file,
                                                            Class<A> type,
                                                            LinkOption... options)
        throws IOException
    {
        if (type == DosFileAttributes.class) {
            DosFileAttributeView view =
                getFileAttributeView(file, DosFileAttributeView.class, options);
            return (A) view.readAttributes();
        } else {
            return super.readAttributes(file, type, options);
        }
    }

    @Override
    FileTypeDetector getFileTypeDetector() {
        String userHome = StaticProperty.userHome();
        Path userMimeTypes = Path.of(userHome, ".mime.types");
        Path etcMimeTypes = Path.of("/etc/mime.types");

        return chain(new MimeTypesFileTypeDetector(userMimeTypes),
                     new MimeTypesFileTypeDetector(etcMimeTypes));
    }
}
