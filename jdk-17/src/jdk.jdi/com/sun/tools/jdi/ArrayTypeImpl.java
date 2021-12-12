/*
 * Copyright (c) 1998, 2021, Oracle and/or its affiliates. All rights reserved.
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
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sun.jdi.ArrayReference;
import com.sun.jdi.ArrayType;
import com.sun.jdi.ClassLoaderReference;
import com.sun.jdi.ClassNotLoadedException;
import com.sun.jdi.InterfaceType;
import com.sun.jdi.Method;
import com.sun.jdi.PrimitiveType;
import com.sun.jdi.ReferenceType;
import com.sun.jdi.Type;
import com.sun.jdi.VirtualMachine;

public class ArrayTypeImpl extends ReferenceTypeImpl
    implements ArrayType
{
    protected ArrayTypeImpl(VirtualMachine aVm, long aRef) {
        super(aVm, aRef);
    }

    public ArrayReference newInstance(int length) {
        try {
            return (ArrayReference)JDWP.ArrayType.NewInstance.
                                       process(vm, this, length).newArray;
        } catch (JDWPException exc) {
            throw exc.toJDIException();
        }
    }

    public String componentSignature() {
        JNITypeParser sig = new JNITypeParser(signature());
        return sig.componentSignature();
    }

    public String componentTypeName() {
        JNITypeParser parser = new JNITypeParser(componentSignature());
        return parser.typeName();
    }

    Type type() throws ClassNotLoadedException {
        return findType(componentSignature());
    }

    @Override
    void addVisibleMethods(Map<String, Method> map, Set<InterfaceType> seenInterfaces) {
        // arrays don't have methods
    }

    public List<Method> allMethods() {
        return new ArrayList<>(0);   // arrays don't have methods
    }

    public Type componentType() throws ClassNotLoadedException {
        return findType(componentSignature());
    }

    static boolean isComponentAssignable(Type destination, Type source) {
        if (source instanceof PrimitiveType) {
            // Assignment of primitive arrays requires identical
            // component types.
            return source.equals(destination);
        } else {
            if (destination instanceof PrimitiveType) {
                return false;
            }

            ReferenceTypeImpl refSource = (ReferenceTypeImpl)source;
            ReferenceTypeImpl refDestination = (ReferenceTypeImpl)destination;
            // Assignment of object arrays requires availability
            // of widening conversion of component types
            return refSource.isAssignableTo(refDestination);
        }
    }

    /*
     * Return true if an instance of the  given reference type
     * can be assigned to a variable of this type
     */
    boolean isAssignableTo(ReferenceType destType) {
        if (destType instanceof ArrayType) {
            try {
                Type destComponentType = ((ArrayType)destType).componentType();
                return isComponentAssignable(destComponentType, componentType());
            } catch (ClassNotLoadedException e) {
                // One or both component types has not yet been
                // loaded => can't assign
                return false;
            }
        } else if (destType instanceof InterfaceType) {
            // Only valid InterfaceType assignee is Cloneable
            return destType.name().equals("java.lang.Cloneable");
        } else {
            // Only valid ClassType assignee is Object
            return destType.name().equals("java.lang.Object");
        }
    }

    List<ReferenceType> inheritedTypes() {
        return new ArrayList<ReferenceType>(0);
    }

    void getModifiers() {
        if (modifiers != -1) {
            return;
        }
        /*
         * For object arrays, the return values for Interface
         * Accessible.isPrivate(), Accessible.isProtected(),
         * etc... are the same as would be returned for the
         * component type.  Fetch the modifier bits from the
         * component type and use those.
         *
         * For primitive arrays, the modifiers are always
         *   VMModifiers.FINAL | VMModifiers.PUBLIC
         *
         * Reference com.sun.jdi.Accessible.java.
         */
        try {
            Type t = componentType();
            if (t instanceof PrimitiveType) {
                modifiers = VMModifiers.FINAL | VMModifiers.PUBLIC;
            } else {
                ReferenceType rt = (ReferenceType)t;
                modifiers = rt.modifiers();
            }
        } catch (ClassNotLoadedException cnle) {
            cnle.printStackTrace();
        }
    }

    public String toString() {
       return "array class " + name() + " (" + loaderString() + ")";
    }

    /*
     * Save a pointless trip over the wire for these methods
     * which have undefined results for arrays.
     */
    public boolean isPrepared() { return true; }
    public boolean isVerified() { return true; }
    public boolean isInitialized() { return true; }
    public boolean failedToInitialize() { return false; }
    public boolean isAbstract() { return false; }

    /*
     * Defined always to be true for arrays
     */
    public boolean isFinal() { return true; }

    /*
     * Defined always to be false for arrays
     */
    public boolean isStatic() { return false; }
}
