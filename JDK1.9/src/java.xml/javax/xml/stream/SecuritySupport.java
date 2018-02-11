/*
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
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

package javax.xml.stream;

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


    ClassLoader getContextClassLoader() throws SecurityException{
        return AccessController.doPrivileged((PrivilegedAction<ClassLoader>) () -> {
            ClassLoader cl = Thread.currentThread().getContextClassLoader();

            if (cl == null)
                cl = ClassLoader.getSystemClassLoader();

            return cl;
        });
    }

    String getSystemProperty(final String propName) {
        return AccessController.doPrivileged((PrivilegedAction<String>) () ->
                System.getProperty(propName));
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
        try {
            return AccessController.doPrivileged((PrivilegedExceptionAction<FileInputStream>) ()
                    -> new FileInputStream(file));
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException)e.getException();
        }
    }

    boolean doesFileExist(final File f) {
        return AccessController.doPrivileged((PrivilegedAction<Boolean>) () -> f.exists());
    }

}
