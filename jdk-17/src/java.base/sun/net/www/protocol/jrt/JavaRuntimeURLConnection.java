/*
 * Copyright (c) 2014, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.www.protocol.jrt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.security.PrivilegedAction;

import jdk.internal.jimage.ImageLocation;
import jdk.internal.jimage.ImageReader;
import jdk.internal.jimage.ImageReaderFactory;

import jdk.internal.loader.URLClassPath;
import jdk.internal.loader.Resource;
import sun.net.www.ParseUtil;
import sun.net.www.URLConnection;

/**
 * URLConnection implementation that can be used to connect to resources
 * contained in the runtime image.
 */
@SuppressWarnings("removal")
public class JavaRuntimeURLConnection extends URLConnection {

    // ImageReader to access resources in jimage
    private static final ImageReader reader;
    static {
        PrivilegedAction<ImageReader> pa = ImageReaderFactory::getImageReader;
        reader = AccessController.doPrivileged(pa);
    }

    // the module and resource name in the URL
    private final String module;
    private final String name;

    // the Resource when connected
    private volatile Resource resource;

    JavaRuntimeURLConnection(URL url) throws IOException {
        super(url);
        String path = url.getPath();
        if (path.isEmpty() || path.charAt(0) != '/')
            throw new MalformedURLException(url + " missing path or /");
        if (path.length() == 1) {
            this.module = null;
            this.name = null;
        } else {
            int pos = path.indexOf('/', 1);
            if (pos == -1) {
                this.module = path.substring(1);
                this.name = null;
            } else {
                this.module = path.substring(1, pos);
                this.name = ParseUtil.decode(path.substring(pos+1));
            }
        }
    }

    /**
     * Finds a resource in a module, returning {@code null} if the resource
     * is not found.
     */
    private static Resource findResource(String module, String name) {
        if (reader != null) {
            URL url = toJrtURL(module, name);
            ImageLocation location = reader.findLocation(module, name);
            if (location != null && URLClassPath.checkURL(url) != null) {
                return new Resource() {
                    @Override
                    public String getName() {
                        return name;
                    }
                    @Override
                    public URL getURL() {
                        return url;
                    }
                    @Override
                    public URL getCodeSourceURL() {
                        return toJrtURL(module);
                    }
                    @Override
                    public InputStream getInputStream() throws IOException {
                        byte[] resource = reader.getResource(location);
                        return new ByteArrayInputStream(resource);
                    }
                    @Override
                    public int getContentLength() {
                        long size = location.getUncompressedSize();
                        return (size > Integer.MAX_VALUE) ? -1 : (int) size;
                    }
                };
            }
        }
        return null;
    }

    @Override
    public synchronized void connect() throws IOException {
        if (!connected) {
            if (name == null) {
                String s = (module == null) ? "" : module;
                throw new IOException("cannot connect to jrt:/" + s);
            }
            resource = findResource(module, name);
            if (resource == null)
                throw new IOException(module + "/" + name + " not found");
            connected = true;
        }
    }

    @Override
    public InputStream getInputStream() throws IOException {
        connect();
        return resource.getInputStream();
    }

    @Override
    public long getContentLengthLong() {
        try {
            connect();
            return resource.getContentLength();
        } catch (IOException ioe) {
            return -1L;
        }
    }

    @Override
    public int getContentLength() {
        long len = getContentLengthLong();
        return len > Integer.MAX_VALUE ? -1 : (int)len;
    }

    @Override
    public Permission getPermission() {
        return new RuntimePermission("accessSystemModules");
    }

    /**
     * Returns a jrt URL for the given module and resource name.
     */
    private static URL toJrtURL(String module, String name) {
        try {
            return new URL("jrt:/" + module + "/" + name);
        } catch (MalformedURLException e) {
            throw new InternalError(e);
        }
    }

    /**
     * Returns a jrt URL for the given module.
     */
    private static URL toJrtURL(String module) {
        try {
            return new URL("jrt:/" + module);
        } catch (MalformedURLException e) {
            throw new InternalError(e);
        }
    }
}
