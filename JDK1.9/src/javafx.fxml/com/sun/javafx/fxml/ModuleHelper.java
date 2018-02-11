/*
 * Copyright (c) 2015, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.fxml;

import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ModuleHelper {
    private static final Method getModuleMethod;
    private static final Method getResourceAsStreamMethod;

    private static final boolean verbose;

    static {
        verbose = AccessController.doPrivileged((PrivilegedAction<Boolean>) () ->
                Boolean.getBoolean("javafx.verbose"));

        if (verbose) {
            System.err.println("" + ModuleHelper.class.getName() + " : <clinit>");
        }
        Method mGetModule = null;
        Method mGetResourceAsStream = null;
        try {
            mGetModule = Class.class.getMethod("getModule");
            Class<?> moduleClass = mGetModule.getReturnType();
            mGetResourceAsStream = moduleClass.getMethod("getResourceAsStream", String.class);
        } catch (NoSuchMethodException e) {
            // ignore
        }
        getModuleMethod = mGetModule;
        getResourceAsStreamMethod = mGetResourceAsStream;
        if (verbose) {
            System.err.println("getModuleMethod = " + getModuleMethod);
            System.err.println("getResourceAsStreamMethod = " + getResourceAsStreamMethod);
        }
    }

    public static Object getModule(Class clazz) {
        if (getModuleMethod != null) {
            try {
                return getModuleMethod.invoke(clazz);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    // FIXME: JIGSAW -- remove this method if not needed
    public static InputStream getResourceAsStream(Object thisModule, String name) {
        if (getResourceAsStreamMethod != null) {
            try {
                return (InputStream)getResourceAsStreamMethod.invoke(thisModule, name);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }
        return null;
    }

    public static Object invoke(Method m, Object obj, Object[] params)
            throws InvocationTargetException, IllegalAccessException
    {
        Object thisModule = getModule(ModuleHelper.class);
        Object methodModule = getModule(m.getDeclaringClass());
        if (verbose) {
            System.out.println("thisModule = " + thisModule);
            System.out.println("methodModule = " + methodModule);
            System.out.println("m = " + m);
        }
        if (methodModule != thisModule) {
            return MethodHelper.invoke(m, obj, params);
        } else {
            return m.invoke(obj, params);
        }
    }
}
