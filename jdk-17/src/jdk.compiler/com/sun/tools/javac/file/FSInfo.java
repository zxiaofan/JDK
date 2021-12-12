/*
 * Copyright (c) 2008, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOError;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.spi.FileSystemProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import com.sun.tools.javac.util.Context;

/**
 * Get meta-info about files. Default direct (non-caching) implementation.
 * @see CacheFSInfo
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public class FSInfo {

    /** Get the FSInfo instance for this context.
     *  @param context the context
     *  @return the Paths instance for this context
     */
    public static FSInfo instance(Context context) {
        FSInfo instance = context.get(FSInfo.class);
        if (instance == null)
            instance = new FSInfo();
        return instance;
    }

    protected FSInfo() {
    }

    protected FSInfo(Context context) {
        context.put(FSInfo.class, this);
    }

    public Path getCanonicalFile(Path file) {
        try {
            return file.toRealPath();
        } catch (IOException e) {
            return file.toAbsolutePath().normalize();
        }
    }

    public boolean exists(Path file) {
        return Files.exists(file);
    }

    public boolean isDirectory(Path file) {
        return Files.isDirectory(file);
    }

    public boolean isFile(Path file) {
        return Files.isRegularFile(file);
    }

    public List<Path> getJarClassPath(Path file) throws IOException {
        try (JarFile jarFile = new JarFile(file.toFile())) {
            Manifest man = jarFile.getManifest();
            if (man == null)
                return Collections.emptyList();

            Attributes attr = man.getMainAttributes();
            if (attr == null)
                return Collections.emptyList();

            String path = attr.getValue(Attributes.Name.CLASS_PATH);
            if (path == null)
                return Collections.emptyList();

            List<Path> list = new ArrayList<>();
            URL base = file.toUri().toURL();

            for (StringTokenizer st = new StringTokenizer(path);
                 st.hasMoreTokens(); ) {
                String elt = st.nextToken();
                try {
                    URL url = tryResolveFile(base, elt);
                    if (url != null) {
                        list.add(Path.of(url.toURI()));
                    }
                } catch (URISyntaxException ex) {
                    throw new IOException(ex);
                }
            }

            return list;
        }
    }

    /**
     * Attempt to return a file URL by resolving input against a base file
     * URL.
     *
     * @return the resolved URL or null if the input is an absolute URL with
     *         a scheme other than file (ignoring case)
     * @throws MalformedURLException
     */
    static URL tryResolveFile(URL base, String input) throws MalformedURLException {
        URL retVal = new URL(base, input);
        if (input.indexOf(':') >= 0 && !"file".equalsIgnoreCase(retVal.getProtocol())) {
            // 'input' contains a ':', which might be a scheme, or might be
            // a Windows drive letter.  If the resolved file has a protocol
            // that isn't "file:", it should be ignored.
            return null;
        }
        return retVal;
    }

    private FileSystemProvider jarFSProvider;

    public synchronized FileSystemProvider getJarFSProvider() {
        if (jarFSProvider != null) {
            return jarFSProvider;
        }
        for (FileSystemProvider provider: FileSystemProvider.installedProviders()) {
            if (provider.getScheme().equals("jar")) {
                return (jarFSProvider = provider);
            }
        }
        return null;
    }

}
