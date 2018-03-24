/*
 * Copyright (c) 1996, 1997, Oracle and/or its affiliates. All rights reserved.
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
/*
 * COPYRIGHT goes here
 */

package sun.applet;

import java.io.*;
import java.lang.reflect.Array;

/**
 * This subclass of ObjectInputStream delegates loading of classes to
 * an existing ClassLoader.
 *
 * @deprecated The Applet API is deprecated. See the
 * <a href="../../java/applet/package-summary.html"> java.applet package
 * documentation</a> for further information.
 */
@Deprecated(since = "9")
class AppletObjectInputStream extends ObjectInputStream
{
    private AppletClassLoader loader;

    /**
     * Loader must be non-null;
     */

    public AppletObjectInputStream(InputStream in, AppletClassLoader loader)
            throws IOException, StreamCorruptedException {

        super(in);
        if (loader == null) {
            throw new AppletIllegalArgumentException("appletillegalargumentexception.objectinputstream");

        }
        this.loader = loader;
    }

    /**
     * Make a primitive array class
     */

    private Class<?> primitiveType(char type) {
        switch (type) {
        case 'B': return byte.class;
        case 'C': return char.class;
        case 'D': return double.class;
        case 'F': return float.class;
        case 'I': return int.class;
        case 'J': return long.class;
        case 'S': return short.class;
        case 'Z': return boolean.class;
        default: return null;
        }
    }

    /**
     * Use the given ClassLoader rather than using the system class
     */
    protected Class<?> resolveClass(ObjectStreamClass classDesc)
        throws IOException, ClassNotFoundException {

        String cname = classDesc.getName();
        if (cname.startsWith("[")) {
            // An array
            Class<?> component;            // component class
            int dcount;                 // dimension
            for (dcount=1; cname.charAt(dcount)=='['; dcount++) ;
            if (cname.charAt(dcount) == 'L') {
                component = loader.loadClass(cname.substring(dcount+1,
                                                             cname.length()-1));
            } else {
                if (cname.length() != dcount+1) {
                    throw new ClassNotFoundException(cname);// malformed
                }
                component = primitiveType(cname.charAt(dcount));
            }
            int dim[] = new int[dcount];
            for (int i=0; i<dcount; i++) {
                dim[i]=0;
            }
            return Array.newInstance(component, dim).getClass();
        } else {
            return loader.loadClass(cname);
        }
    }
}
