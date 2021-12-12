/*
 * Copyright (c) 2016, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.ClassLoaderReference;
import com.sun.jdi.ModuleReference;
import com.sun.jdi.VirtualMachine;

class ModuleReferenceImpl extends ObjectReferenceImpl implements ModuleReference {

    protected ModuleReferenceImpl(VirtualMachine aVm, long aRef) {
        super(aVm, aRef);
    }

    protected String description() {
        return "ModuleReference " + ref();
    }

    private String name;
    private ClassLoaderReference classLoader;

    private boolean cachedName = false;
    private boolean cachedClassLoader = false;


    public synchronized String name() {
        if (cachedName) {
            return name;
        }
        try {
            name = JDWP.ModuleReference.Name.process(this.vm, this).name;
            if (name != null && name.length() == 0) {
                // The JDWP returns empty name for unnamed modules
                name = null;
            }
            cachedName = true;
        } catch (JDWPException ex) {
            throw ex.toJDIException();
        }
        return name;
    }

    public synchronized ClassLoaderReference classLoader() {
        if (cachedClassLoader) {
            return classLoader;
        }
        try {
            classLoader = JDWP.ModuleReference.ClassLoader.
                process(this.vm, this).classLoader;
            cachedClassLoader = true;
        } catch (JDWPException ex) {
            throw ex.toJDIException();
        }
        return classLoader;
    }
}
