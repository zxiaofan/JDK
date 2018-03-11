/*
 * The contents of this file are subject to the terms
 * of the Common Development and Distribution License
 * (the "License").  You may not use this file except
 * in compliance with the License.
 *
 * You can obtain a copy of the license at
 * https://jaxp.dev.java.net/CDDLv1.0.html.
 * See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * When distributing Covered Code, include this CDDL
 * HEADER in each file and include the License file at
 * https://jaxp.dev.java.net/CDDLv1.0.html
 * If applicable add the following below this CDDL HEADER
 * with the fields enclosed by brackets "[]" replaced with
 * your own identifying information: Portions Copyright
 * [year] [name of copyright owner]
 */

/*
 * $Id: SecuritySupport.java,v 1.3 2005/11/03 19:34:14 jeffsuttor Exp $
 * %W% %E%
 *
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
 */

package javax.xml.parsers;

import java.security.*;
import java.net.*;
import java.io.*;
import java.util.*;

/**
 * This class is duplicated for each JAXP subpackage so keep it in sync.
 * It is package private and therefore is not exposed as part of the JAXP
 * API.
 *
 * Security related methods that only work on J2SE 1.2 and newer.
 */
class SecuritySupport  {

    
    ClassLoader getContextClassLoader() throws SecurityException{
	return (ClassLoader)
		AccessController.doPrivileged(new PrivilegedAction() {
	    public Object run() {
                ClassLoader cl = null;
                //try {
                cl = Thread.currentThread().getContextClassLoader();
                //} catch (SecurityException ex) { }
                
                if (cl == null)
                    cl = ClassLoader.getSystemClassLoader();
                
                return cl;
            }
        });
    }

    String getSystemProperty(final String propName) {
	return (String)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return System.getProperty(propName);
                }
            });
    }

    FileInputStream getFileInputStream(final File file)
        throws FileNotFoundException
    {
	try {
            return (FileInputStream)
                AccessController.doPrivileged(new PrivilegedExceptionAction() {
                    public Object run() throws FileNotFoundException {
                        return new FileInputStream(file);
                    }
                });
	} catch (PrivilegedActionException e) {
	    throw (FileNotFoundException)e.getException();
	}
    }

    InputStream getResourceAsStream(final ClassLoader cl,
                                           final String name)
    {
        return (InputStream)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    InputStream ris;
                    if (cl == null) {
                        ris = ClassLoader.getSystemResourceAsStream(name);
                    } else {
                        ris = cl.getResourceAsStream(name);
                    }
                    return ris;
                }
            });
    }

    boolean doesFileExist(final File f) {
    return ((Boolean)
            AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return new Boolean(f.exists());
                }
            })).booleanValue();
    }

}
