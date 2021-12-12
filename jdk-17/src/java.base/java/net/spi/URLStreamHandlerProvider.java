/*
 * Copyright (c) 2015, 2021, Oracle and/or its affiliates. All rights reserved.
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

package java.net.spi;

import java.net.URLStreamHandlerFactory;

/**
 * URL stream handler service-provider class.
 *
 * <p> A URL stream handler provider is a concrete subclass of this class that
 * has a zero-argument constructor. URL stream handler providers may be
 * installed in an instance of the Java platform by adding them to the
 * application class path.
 *
 * <p> A URL stream handler provider identifies itself with a
 * provider-configuration file named java.net.spi.URLStreamHandlerProvider in
 * the resource directory META-INF/services. The file should contain a list of
 * fully-qualified concrete URL stream handler provider class names, one per
 * line.
 *
 * <p> URL stream handler providers are located at runtime, as specified in the
 * {@linkplain java.net.URL#URL(String,String,int,String) URL constructor}.
 *
 * @since 9
 */
public abstract class URLStreamHandlerProvider
    implements URLStreamHandlerFactory
{
    private static Void checkPermission() {
        @SuppressWarnings("removal")
        SecurityManager sm = System.getSecurityManager();
        if (sm != null)
            sm.checkPermission(new RuntimePermission("setFactory"));
        return null;
    }
    private URLStreamHandlerProvider(Void ignore) { }

    /**
     * Initializes a new URL stream handler provider.
     *
     * @throws  SecurityException
     *          If a security manager has been installed and it denies
     *          {@link RuntimePermission}{@code ("setFactory")}.
     */
    protected URLStreamHandlerProvider() {
        this(checkPermission());
    }
}
