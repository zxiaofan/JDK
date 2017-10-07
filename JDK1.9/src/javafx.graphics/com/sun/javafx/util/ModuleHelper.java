/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
 *
 */

package com.sun.javafx.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

public class ModuleHelper {
    private static final Method getModuleMethod;
    private static final Method addReadsMethod;
    private static final Method addExportsMethod;

    private static final boolean verbose;

    static {
        verbose = AccessController.doPrivileged((PrivilegedAction<Boolean>) () ->
                Boolean.getBoolean("javafx.verbose"));

        if (verbose) {
            System.err.println("" + ModuleHelper.class.getName() + " : <clinit>");
        }
        Method mGetModule = null;
        Method mAddReads = null;
        Method mAddExports = null;
        try {
            mGetModule = Class.class.getMethod("getModule");
            Class<?> moduleClass = mGetModule.getReturnType();
            mAddReads = moduleClass.getMethod("addReads", moduleClass);
            mAddExports = moduleClass.getMethod("addExports", String.class, moduleClass);
        } catch (NoSuchMethodException e) {
            // ignore
        }
        getModuleMethod = mGetModule;
        addReadsMethod = mAddReads;
        addExportsMethod = mAddExports;
        if (verbose) {
            System.err.println("getModuleMethod = " + getModuleMethod);
            System.err.println("addReadsMethod = " + addReadsMethod);
            System.err.println("addExportsMethod = " + addExportsMethod);
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

    public static void addReads(Object thisModule, Object targetModule) {
        if (addReadsMethod != null) {
            try {
                addReadsMethod.invoke(thisModule, targetModule);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void addExports(Object thisModule, String packageName, Object targetModule) {
        if (addExportsMethod != null) {
            try {
                addExportsMethod.invoke(thisModule, packageName, targetModule);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
