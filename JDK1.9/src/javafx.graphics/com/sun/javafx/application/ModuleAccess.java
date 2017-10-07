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

package com.sun.javafx.application;

import java.lang.module.ModuleDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Optional;

public final class ModuleAccess {

    private final Object module;
    private ModuleAccess(Object m) {
        this.module = m;
    }

    ModuleDescriptor getDescriptor() {
        try {
            return (ModuleDescriptor) getDescriptorMethod.invoke(module);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    String getName() {
        try {
            return (String) getModuleNameMethod.invoke(module);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    Class<?> classForName(String name) {
        try {
            return (Class<?>) classForNameMethod.invoke(null, module, name);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    static ModuleAccess load(String moduleName) {
        // main module is in the boot layer
        try {
            Object layer = bootLayerMethod.invoke(null);

            Optional<?> om =
                (Optional<?>)findModuleMethod.invoke(layer, moduleName);
            if (!om.isPresent()) {
                // should not happen
                throw new
                   InternalError("Module " + moduleName + " not in boot Layer");
            }
            return new ModuleAccess(om.get());
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new InternalError(e);
        }
    }

    private static final Method bootLayerMethod;
    private static final Method getModuleNameMethod;
    private static final Method findModuleMethod;
    private static final Method getDescriptorMethod;
    private static final Method classForNameMethod;

    static {
        Class<?> cModuleClass = null;
        Method mGetModule = null;
        Method mGetLayer = null;
        Method mGetDescriptor = null;
        Method mGetName = null;
        Method mBootLayers = null;
        Method mfindModule = null;
        Method mClassForName = null;

        try {
            mGetModule = Class.class.getMethod("getModule");
            cModuleClass = mGetModule.getReturnType();
            mGetLayer = cModuleClass.getMethod("getLayer");
            mGetDescriptor = cModuleClass.getMethod("getDescriptor");
            mGetName = cModuleClass.getMethod("getName");

            Class<?> layerClass = mGetLayer.getReturnType();
            mBootLayers = layerClass.getMethod("boot");
            mfindModule = layerClass.getMethod("findModule", String.class);

            mClassForName =
                Class.class.getMethod("forName", cModuleClass, String.class);

        } catch (NoSuchMethodException e) {
            throw new InternalError("Module reflection failed", e);
        }

        bootLayerMethod = mBootLayers;
        getModuleNameMethod = mGetName;
        getDescriptorMethod = mGetDescriptor;
        findModuleMethod = mfindModule;
        classForNameMethod = mClassForName;
    }
}
