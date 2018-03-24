/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */

package jdk.tools.jaotc.collect;

import java.io.IOException;
import java.net.*;
import java.nio.file.*;
import java.util.HashMap;

public class FileSupport {
    public boolean exists(Path path) {
        return Files.exists(path);
    }

    public boolean isDirectory(Path path) {
        return Files.isDirectory(path);
    }

    private static FileSystem makeJarFileSystem(Path path) {
        try {
            return FileSystems.newFileSystem(makeJarFileURI(path), new HashMap<>());
        } catch (IOException e) {
            throw new InternalError(e);
        }
    }

    private static URI makeJarFileURI(Path path) {
        try {
            String name = path.toAbsolutePath().toString();
            name = name.replace('\\', '/');
            return new URI("jar:file:///" + name + "!/");
        } catch (URISyntaxException e) {
            throw new InternalError(e);
        }
    }

    public ClassLoader createClassLoader(Path path, ClassLoader parent) {
        try {
            return URLClassLoader.newInstance(buildUrls(path), parent);
        } catch (MalformedURLException e) {
            throw new InternalError(e);
        }
    }

    public ClassLoader createClassLoader(Path path) throws MalformedURLException {
        return URLClassLoader.newInstance(buildUrls(path));
    }

    private static URL[] buildUrls(Path path) throws MalformedURLException {
        return new URL[]{path.toUri().toURL()};
    }

    public Path getJarFileSystemRoot(Path jarFile) {
        FileSystem fileSystem = makeJarFileSystem(jarFile);
        return fileSystem.getPath("/");
    }

    public boolean isAbsolute(Path entry) {
        return entry.isAbsolute();
    }

    public Path getSubDirectory(FileSystem fileSystem, Path root, Path path) throws IOException {
        DirectoryStream<Path> paths = fileSystem.provider().newDirectoryStream(root, null);
        for (Path entry : paths) {
            Path relative = root.relativize(entry);
            if (relative.equals(path)) {
                return entry;
            }
        }
        return null;
    }
}
