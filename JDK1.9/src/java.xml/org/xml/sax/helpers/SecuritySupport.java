/*
 * Copyright (c) 2004, 2016, Oracle and/or its affiliates. All rights reserved.
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

package org.xml.sax.helpers;

import java.io.*;
import java.security.*;

/**
 * This class is duplicated for each JAXP subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of the JAXP
 * API.
 *
 * Security related methods that only work on J2SE 1.2 and newer.
 */
class SecuritySupport  {

    /**
     * Returns the current thread's context class loader, or the system class loader
     * if the context class loader is null.
     * @return the current thread's context class loader, or the system class loader
     * @throws SecurityException
     */
    ClassLoader getClassLoader() throws SecurityException{
        return AccessController.doPrivileged((PrivilegedAction<ClassLoader>)() -> {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();
            if (cl == null) {
                cl = ClassLoader.getSystemClassLoader();
            }

            return cl;
        });
    }

    String getSystemProperty(final String propName) {
        return AccessController.doPrivileged((PrivilegedAction<String>)()
                -> System.getProperty(propName));
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<FileInputStream>)() ->
                    new FileInputStream(file));
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException)e.getException();
        }
    }


    InputStream getResourceAsStream(final ClassLoader cl, final String name)
    {
        return AccessController.doPrivileged((PrivilegedAction<InputStream>) () -> {
            InputStream ris;
            if (cl == null) {
                ris = SecuritySupport.class.getResourceAsStream(name);
            } else {
                ris = cl.getResourceAsStream(name);
            }
            return ris;
        });
    }

    boolean doesFileExist(final File f) {
        return (AccessController.doPrivileged((PrivilegedAction<Boolean>)() ->
                new Boolean(f.exists())));
    }

}
