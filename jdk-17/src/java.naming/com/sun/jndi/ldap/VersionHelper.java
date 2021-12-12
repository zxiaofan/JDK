/*
 * Copyright (c) 1999, 2021, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.access.SharedSecrets;

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

    /**
     * Determines whether objects may be deserialized from the content of
     * 'javaSerializedData' attribute.
     */
    private static final boolean trustSerialData;

    static {
        // System property to control whether classes may be loaded from an
        // arbitrary URL code base
        String trust = getPrivilegedProperty(
                "com.sun.jndi.ldap.object.trustURLCodebase", "false");
        trustURLCodebase = "true".equalsIgnoreCase(trust);

        // System property to control whether classes is allowed to be loaded from
        // 'javaSerializedData' attribute
        String trustSerialDataSp = getPrivilegedProperty(
                "com.sun.jndi.ldap.object.trustSerialData", "true");
        trustSerialData = "true".equalsIgnoreCase(trustSerialDataSp);
    }

    @SuppressWarnings("removal")
    private static String getPrivilegedProperty(String propertyName, String defaultVal) {
        PrivilegedAction<String> action = () -> System.getProperty(propertyName, defaultVal);
        if (System.getSecurityManager() == null) {
            return action.run();
        } else {
            return AccessController.doPrivileged(action);
        }
    }

    private VersionHelper() {
    }

    static VersionHelper getVersionHelper() {
        return helper;
    }

    /**
     * Returns true if deserialization of objects from 'javaSerializedData'
     * and 'javaReferenceAddress' LDAP attributes is allowed.
     *
     * @return true if deserialization is allowed; false - otherwise
     */
    public static boolean isSerialDataAllowed() {
        return trustSerialData;
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

    @SuppressWarnings("removal")
    Thread createThread(Runnable r) {
        AccessControlContext acc = AccessController.getContext();
        // 4290486: doPrivileged is needed to create a thread in
        // an environment that restricts "modifyThreadGroup".
        PrivilegedAction<Thread> act =
                () -> SharedSecrets.getJavaLangAccess().newThreadWithAcc(r, acc);
        return AccessController.doPrivileged(act);
    }

    @SuppressWarnings("removal")
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
