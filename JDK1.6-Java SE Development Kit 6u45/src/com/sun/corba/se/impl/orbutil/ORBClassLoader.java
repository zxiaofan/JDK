/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.corba.se.impl.orbutil;

/**
 * Based on feedback from bug report 4452016, all class loading
 * in the ORB is isolated here.  It is acceptable to use
 * Class.forName only when one is certain that the desired class
 * should come from the core JDK.
 */
public class ORBClassLoader
{
    public static Class loadClass(String className) 
        throws ClassNotFoundException
    {
        return ORBClassLoader.getClassLoader().loadClass(className);
    }

    public static ClassLoader getClassLoader() {
        if (Thread.currentThread().getContextClassLoader() != null)
            return Thread.currentThread().getContextClassLoader();
        else
            return ClassLoader.getSystemClassLoader();
    }
}
