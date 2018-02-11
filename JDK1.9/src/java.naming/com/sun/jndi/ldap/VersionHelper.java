/*
 * Copyright (c) 1999, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap;

import jdk.internal.misc.SharedSecrets;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;

public final class VersionHelper {

    private static final VersionHelper helper = new VersionHelper();

    /**
     * Determines whether classes may be loaded from an arbitrary URL code base.
     */
    private static final boolean trustURLCodebase;

    static {
        // System property to control whether classes may be loaded from an
        // arbitrary URL code base
        PrivilegedAction<String> act =
                () -> System.getProperty("com.sun.jndi.ldap.object.trustURLCodebase", "false");
        String trust = AccessController.doPrivileged(act);
        trustURLCodebase = "true".equalsIgnoreCase(trust);
    }

    private VersionHelper() { }

    static VersionHelper getVersionHelper() {
        return helper;
    }

    ClassLoader getURLClassLoader(String[] url) throws MalformedURLException {
        ClassLoader parent = getContextClassLoader();
        /*
         * Classes may only be loaded from an arbitrary URL code base when
         * the system property com.sun.jndi.ldap.object.trustURLCodebase
         * has been set to "true".
         */
        if (url != null && trustURLCodebase) {
            return URLClassLoader.newInstance(getUrlArray(url), parent);
        } else {
            return parent;
        }
    }

    Class<?> loadClass(String className) throws ClassNotFoundException {
        return Class.forName(className, true, getContextClassLoader());
    }

    Thread createThread(Runnable r) {
        AccessControlContext acc = AccessController.getContext();
        // 4290486: doPrivileged is needed to create a thread in
        // an environment that restricts "modifyThreadGroup".
        PrivilegedAction<Thread> act =
                () -> SharedSecrets.getJavaLangAccess().newThreadWithAcc(r, acc);
        return AccessController.doPrivileged(act);
    }

    private ClassLoader getContextClassLoader() {
        PrivilegedAction<ClassLoader> act =
                Thread.currentThread()::getContextClassLoader;
        return AccessController.doPrivileged(act);
    }

    private static URL[] getUrlArray(String[] url) throws MalformedURLException {
        URL[] urlArray = new URL[url.length];
        for (int i = 0; i < urlArray.length; i++) {
            urlArray[i] = new URL(url[i]);
        }
        return urlArray;
    }
}
