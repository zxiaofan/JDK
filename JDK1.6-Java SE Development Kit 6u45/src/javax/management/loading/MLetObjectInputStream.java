/*
 * %W% %E%
 * 
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package javax.management.loading;


// java import

import java.io.*;
import java.lang.reflect.Array;


/**
 * This subclass of ObjectInputStream delegates loading of classes to
 * an existing MLetClassLoader.
 * 
 * @since 1.5
 */
class MLetObjectInputStream extends ObjectInputStream {

    private MLet loader;
    
    /**
     * Loader must be non-null;
     */
    public MLetObjectInputStream(InputStream in, MLet loader)
        throws IOException, StreamCorruptedException {

        super(in);
        if (loader == null) {
            throw new IllegalArgumentException("Illegal null argument to MLetObjectInputStream");
        }
        this.loader = loader;
    }

    private Class primitiveType(char c) {
        switch(c) {
        case 66: /* 'B' */
            return Byte.TYPE;

        case 67: /* 'C' */
            return Character.TYPE;

        case 68: /* 'D' */
            return Double.TYPE;

        case 70: /* 'F' */
            return Float.TYPE;

        case 73: /* 'I' */
            return Integer.TYPE;

        case 74: /* 'J' */
            return Long.TYPE;

        case 83: /* 'S' */
            return Short.TYPE;

        case 90: /* 'Z' */
            return Boolean.TYPE;
        }
        return null;
    }

    /**
     * Use the given ClassLoader rather than using the system class
     */
    protected Class resolveClass(ObjectStreamClass objectstreamclass)
        throws IOException, ClassNotFoundException {

        String s = objectstreamclass.getName();
        if (s.startsWith("[")) {
            int i;
            for (i = 1; s.charAt(i) == '['; i++);
            Class class1;
            if (s.charAt(i) == 'L') {
                class1 = loader.loadClass(s.substring(i + 1, s.length() - 1));
            } else {
                if (s.length() != i + 1)
                    throw new ClassNotFoundException(s);
                class1 = primitiveType(s.charAt(i));
            }
            int ai[] = new int[i];
            for (int j = 0; j < i; j++)
                ai[j] = 0;

            return Array.newInstance(class1, ai).getClass();
        } else {
            return loader.loadClass(s);
        }
    }

    /**
     * Returns the ClassLoader being used
     */
    public ClassLoader getClassLoader() {
        return loader;
    }
}
