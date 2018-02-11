/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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

import com.sun.jdi.*;
import java.util.*;

public class ClassLoaderReferenceImpl extends ObjectReferenceImpl
                  implements ClassLoaderReference, VMListener  {

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
        ArrayList<ReferenceType> definedClasses = new ArrayList<ReferenceType>();
        for (ReferenceType type :  vm.allClasses()) {
            if (type.isPrepared() &&
                equals(type.classLoader())) {
                definedClasses.add(type);
            }
        }
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
                classes = new ArrayList<ReferenceType>(jdwpClasses.length);
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
        Iterator<ReferenceType> iter = types.iterator();
        while (iter.hasNext()) {
            ReferenceType type = iter.next();
            if (type.signature().equals(signature)) {
                return type;
            }
        }
        JNITypeParser parser = new JNITypeParser(signature);
        throw new ClassNotLoadedException(parser.typeName(),
                                         "Class " + parser.typeName() + " not loaded");
    }

    byte typeValueKey() {
        return JDWP.Tag.CLASS_LOADER;
    }
}
