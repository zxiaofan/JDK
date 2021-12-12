/*
 * Copyright (c) 1998, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.sun.jdi.ClassLoaderReference;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public class ClassLoaderReferenceImpl extends ObjectReferenceImpl
                                      implements ClassLoaderReference
{
    // This is cached only while the VM is suspended
    private static class Cache extends ObjectReferenceImpl.Cache {
        List<ReferenceType> visibleClasses = null;
    }

    protected ObjectReferenceImpl.Cache newCache() {
        return new Cache();
    }

    ClassLoaderReferenceImpl(VirtualMachine aVm, long ref) {
        super(aVm, ref);
        vm.state().addListener(this);
    }

    protected String description() {
        return "ClassLoaderReference " + uniqueID();
    }

    public List<ReferenceType> definedClasses() {
        ArrayList<ReferenceType> definedClasses = new ArrayList<>();
        vm.forEachClass(type -> {
            if (type.isPrepared() &&
                    equals(type.classLoader())) {
                definedClasses.add(type);
            }
        });
        return definedClasses;
    }

    public List<ReferenceType> visibleClasses() {
        List<ReferenceType> classes = null;
        try {
            Cache local = (Cache)getCache();

            if (local != null) {
                classes = local.visibleClasses;
            }
            if (classes == null) {
                JDWP.ClassLoaderReference.VisibleClasses.ClassInfo[]
                  jdwpClasses = JDWP.ClassLoaderReference.VisibleClasses.
                                            process(vm, this).classes;
                classes = new ArrayList<>(jdwpClasses.length);
                for (int i = 0; i < jdwpClasses.length; ++i) {
                    classes.add(vm.referenceType(jdwpClasses[i].typeID,
                                                 jdwpClasses[i].refTypeTag));
                }
                classes = Collections.unmodifiableList(classes);
                if (local != null) {
                    local.visibleClasses = classes;
                    if ((vm.traceFlags & VirtualMachine.TRACE_OBJREFS) != 0) {
                        vm.printTrace(description() +
                           " temporarily caching visible classes (count = " +
                                      classes.size() + ")");
                    }
                }
            }
        } catch (JDWPException exc) {
            throw exc.toJDIException();
        }
        return classes;
    }

    Type findType(String signature) throws ClassNotLoadedException {
        List<ReferenceType> types = visibleClasses();

        // first check already loaded classes and possibly avoid massive signature retrieval later
        for (ReferenceType type : vm.classesBySignature(signature)) {
            if (types.contains(type)) {
                return type;
            }
        }

        for (ReferenceType type : types) {
            if (type.signature().equals(signature)) {
                return type;
            }
        }

        String typeName = new JNITypeParser(signature).typeName();
        throw new ClassNotLoadedException(typeName, "Class " + typeName + " not loaded");
    }

    byte typeValueKey() {
        return JDWP.Tag.CLASS_LOADER;
    }
}
