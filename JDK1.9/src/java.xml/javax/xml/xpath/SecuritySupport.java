/*
 * Copyright (c) 2005, 2015, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.xpath;

import java.net.URL;
import java.security.*;
import java.io.*;

/**
 * This class is duplicated for each JAXP subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of the JAXP
 * API.
 *
 * Security related methods that only work on J2SE 1.2 and newer.
 */
class SecuritySupport  {


    ClassLoader getContextClassLoader() {
        return AccessController.doPrivileged(new PrivilegedAction<>() {
            @Override
            public ClassLoader run() {
                ClassLoader cl = null;
                try {
                    cl = Thread.currentThread().getContextClassLoader();
                } catch (SecurityException ex) { }
                return cl;
            }
        });
    }

    String getSystemProperty(final String propName) {
        return AccessController.doPrivileged(new PrivilegedAction<>() {
            @Override
            public String run() {
                return System.getProperty(propName);
            }
        });
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
        try {
            return AccessController.doPrivileged(
                new PrivilegedExceptionAction<>() {
                    @Override
                    public FileInputStream run() throws FileNotFoundException {
                        return new FileInputStream(file);
                    }
                });
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException)e.getException();
        }
    }

    // Used for debugging purposes
    String getClassSource(Class<?> cls) {
        return AccessController.doPrivileged(new PrivilegedAction<>() {
            @Override
            public String run() {
                CodeSource cs = cls.getProtectionDomain().getCodeSource();
                if (cs != null) {
                   URL loc = cs.getLocation();
                   return loc != null ? loc.toString() : "(no location)";
                } else {
                   return "(no code source)";
                }
            }
        });
    }

    boolean doesFileExist(final File f) {
        return AccessController.doPrivileged(new PrivilegedAction<>() {
            @Override
            public Boolean run() {
                return f.exists();
            }
        });
    }

}
