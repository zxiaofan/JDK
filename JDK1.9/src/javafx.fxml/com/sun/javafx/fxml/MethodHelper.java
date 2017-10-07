/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.javafx.reflect.MethodUtil;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;
import sun.reflect.misc.ReflectUtil;

/**
 * Utility class to wrap method invocation.
 */
public class MethodHelper {
    private static final boolean logAccessErrors
            = AccessController.doPrivileged((PrivilegedAction<Boolean>) ()
                    -> Boolean.getBoolean("sun.reflect.debugModuleAccessChecks"));

    private static final Module trampolineModule = MethodUtil.getTrampolineModule();

    public static Object invoke(Method m, Object obj, Object[] params)
            throws InvocationTargetException, IllegalAccessException {

        // Check that the class in question is in a package that is open to
        // this module (or exported unconditionally). If so, then we will open
        // the containing package to the unnamed trampoline module. If not,
        // we will throw an IllegalAccessException in order to generate a
        // clearer error message.
        final Class<?> clazz = m.getDeclaringClass();
        final String packageName = clazz.getPackage().getName();
        final Module module = clazz.getModule();
        final Module thisModule = MethodHelper.class.getModule();
        try {
            // Verify that the module being called either exports the package
            // in question unconditionally or opens the package in question to
            // this module.
            if (!module.isExported(packageName)) {
                if (!module.isOpen(packageName, thisModule)) {
                    throw new IllegalAccessException(
                            "module " + thisModule.getName()
                            + " cannot access class " + clazz.getName()
                            + " (in module " + module.getName()
                            + ") because module " + module.getName()
                            + " does not open " + packageName
                            + " to " + thisModule.getName());
                }
                if (!module.isOpen(packageName, trampolineModule)) {
                    ReflectUtil.checkPackageAccess(packageName);
                    module.addOpens(packageName, trampolineModule);
                }
            }
        } catch (IllegalAccessException ex) {
            if (logAccessErrors) {
                ex.printStackTrace(System.err);
            }
            throw ex;
        }

        return MethodUtil.invoke(m, obj, params);
    }

    // Utility class, do not instantiate
    private MethodHelper() {
    }

}
