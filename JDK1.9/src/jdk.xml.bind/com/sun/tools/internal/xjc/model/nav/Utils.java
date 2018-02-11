/*
 * Copyright (c) 2013, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.internal.xjc.model.nav;

import com.sun.xml.internal.bind.v2.model.nav.Navigator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utils class.
 *
 * WARNING: If you are doing any changes don't forget to change other Utils classes in different packages.
 *
 * Has *package private* access to avoid inappropriate usage.
 */
final class Utils {

    private static final Logger LOGGER = Logger.getLogger(Utils.class.getName());

    /**
     * static ReflectionNavigator field to avoid usage of reflection every time we use it.
     */
    static final Navigator<Type, Class, Field, Method> REFLECTION_NAVIGATOR;

    static { // we statically initializing REFLECTION_NAVIGATOR property
        try {
            final Class refNav = Class.forName("com.sun.xml.internal.bind.v2.model.nav.ReflectionNavigator");

            // requires accessClassInPackage privilege
            final Method getInstance = AccessController.doPrivileged(
                    new PrivilegedAction<Method>() {
                        @Override
                        public Method run() {
                            try {
                                Method getInstance = refNav.getDeclaredMethod("getInstance");
                                getInstance.setAccessible(true);
                                return getInstance;
                            } catch (NoSuchMethodException e) {
                                throw new IllegalStateException("ReflectionNavigator.getInstance can't be found");
                            }
                        }
                    }
            );

            //noinspection unchecked
            REFLECTION_NAVIGATOR = (Navigator<Type, Class, Field, Method>) getInstance.invoke(null);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("Can't find ReflectionNavigator class");
        } catch (InvocationTargetException e) {
            throw new IllegalStateException("ReflectionNavigator.getInstance throws the exception");
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("ReflectionNavigator.getInstance method is inaccessible");
        } catch (SecurityException e) {
            LOGGER.log(Level.FINE, "Unable to access ReflectionNavigator.getInstance", e);
            throw e;
        }
    }

    /**
     * private constructor to avoid util class instantiating
     */
    private Utils() {
    }
}
