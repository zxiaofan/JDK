/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://glassfish.dev.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 *
 *
 * This file incorporates work covered by the following copyright and
 * permission notice:
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sun.org.apache.xalan.internal.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * This class is duplicated for each subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of any API.
 * 
 * @xerces.internal
 */
public final class SecuritySupport {

    private static final SecuritySupport securitySupport = new SecuritySupport();

    /**
     * Return an instance of this class.
     */
    public static SecuritySupport getInstance() {
        return securitySupport;
    }

    static ClassLoader getContextClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader cl = null;
                try {
                    cl = Thread.currentThread().getContextClassLoader();
                } catch (SecurityException ex) {
                }
                return cl;
            }
        });
    }

    static ClassLoader getSystemClassLoader() {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader cl = null;
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (SecurityException ex) {
                }
                return cl;
            }
        });
    }

    static ClassLoader getParentClassLoader(final ClassLoader cl) {
        return (ClassLoader) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                ClassLoader parent = null;
                try {
                    parent = cl.getParent();
                } catch (SecurityException ex) {
                }

                // eliminate loops in case of the boot
                // ClassLoader returning itself as a parent
                return (parent == cl) ? null : parent;
            }
        });
    }

    public static String getSystemProperty(final String propName) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return System.getProperty(propName);
            }
        });
    }

    public static String getSystemProperty(final String propName, final String def) {
        return (String) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                return System.getProperty(propName, def);
            }
        });
    }

    static FileInputStream getFileInputStream(final File file)
            throws FileNotFoundException {
        try {
            return (FileInputStream) AccessController.doPrivileged(new PrivilegedExceptionAction() {
                public Object run() throws FileNotFoundException {
                    return new FileInputStream(file);
                }
            });
        } catch (PrivilegedActionException e) {
            throw (FileNotFoundException) e.getException();
        }
    }

    /**
     * Return resource using the same classloader for the ObjectFactory by
     * default or bootclassloader when Security Manager is in place
     */
    public static InputStream getResourceAsStream(final String name) {
        if (System.getSecurityManager() != null) {
            return getResourceAsStream(null, name);
        } else {
            return getResourceAsStream(ObjectFactory.findClassLoader(), name);
        }
    }

    public static InputStream getResourceAsStream(final ClassLoader cl,
            final String name) {
        return (InputStream) AccessController.doPrivileged(new PrivilegedAction() {
            public Object run() {
                InputStream ris;
                if (cl == null) {
                    ris = Object.class.getResourceAsStream("/" + name);
                } else {
                    ris = cl.getResourceAsStream(name);
                }
                return ris;
            }
        });
    }

    /**
     * Gets a resource bundle using the specified base name, the default locale, and the caller's class loader.
     * @param bundle the base name of the resource bundle, a fully qualified class name
     * @return a resource bundle for the given base name and the default locale
     */
    public static ListResourceBundle getResourceBundle(String bundle) {
        return getResourceBundle(bundle, Locale.getDefault());
    }

    /**
     * Gets a resource bundle using the specified base name and locale, and the caller's class loader.
     * @param bundle the base name of the resource bundle, a fully qualified class name
     * @param locale the locale for which a resource bundle is desired
     * @return a resource bundle for the given base name and locale
     */
    public static ListResourceBundle getResourceBundle(final String bundle, final Locale locale) {
        return AccessController.doPrivileged(new PrivilegedAction<ListResourceBundle>() {
            public ListResourceBundle run() {
                try {
                    return (ListResourceBundle)ResourceBundle.getBundle(bundle, locale);
                } catch (MissingResourceException e) {
                    try {
                        return (ListResourceBundle)ResourceBundle.getBundle(bundle, new Locale("en", "US"));
                    } catch (MissingResourceException e2) {
                        throw new MissingResourceException(
                                "Could not load any resource bundle by " + bundle, bundle, "");
                    }
                }
            }
        });
    }

    public static boolean getFileExists(final File f) {
        return ((Boolean) AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        return f.exists() ? Boolean.TRUE : Boolean.FALSE;
                    }
                })).booleanValue();
    }

    static long getLastModified(final File f) {
        return ((Long) AccessController.doPrivileged(new PrivilegedAction() {
                    public Object run() {
                        return new Long(f.lastModified());
                    }
                })).longValue();
    }


    private SecuritySupport() {
    }
}
