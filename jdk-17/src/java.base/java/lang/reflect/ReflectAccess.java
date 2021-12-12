/*
 * Copyright (c) 2001, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.reflect;

import jdk.internal.reflect.MethodAccessor;
import jdk.internal.reflect.ConstructorAccessor;

/** Package-private class implementing the
    jdk.internal.access.JavaLangReflectAccess interface, allowing the java.lang
    package to instantiate objects in this package. */

class ReflectAccess implements jdk.internal.access.JavaLangReflectAccess {
    public <T> Constructor<T> newConstructor(Class<T> declaringClass,
                                             Class<?>[] parameterTypes,
                                             Class<?>[] checkedExceptions,
                                             int modifiers,
                                             int slot,
                                             String signature,
                                             byte[] annotations,
                                             byte[] parameterAnnotations)
    {
        return new Constructor<>(declaringClass,
                                  parameterTypes,
                                  checkedExceptions,
                                  modifiers,
                                  slot,
                                  signature,
                                  annotations,
                                  parameterAnnotations);
    }

    public MethodAccessor getMethodAccessor(Method m) {
        return m.getMethodAccessor();
    }

    public void setMethodAccessor(Method m, MethodAccessor accessor) {
        m.setMethodAccessor(accessor);
    }

    public ConstructorAccessor getConstructorAccessor(Constructor<?> c) {
        return c.getConstructorAccessor();
    }

    public void setConstructorAccessor(Constructor<?> c,
                                       ConstructorAccessor accessor)
    {
        c.setConstructorAccessor(accessor);
    }

    public int getConstructorSlot(Constructor<?> c) {
        return c.getSlot();
    }

    public String getConstructorSignature(Constructor<?> c) {
        return c.getSignature();
    }

    public byte[] getConstructorAnnotations(Constructor<?> c) {
        return c.getRawAnnotations();
    }

    public byte[] getConstructorParameterAnnotations(Constructor<?> c) {
        return c.getRawParameterAnnotations();
    }

    public byte[] getExecutableTypeAnnotationBytes(Executable ex) {
        return ex.getTypeAnnotationBytes();
    }

    public Class<?>[] getExecutableSharedParameterTypes(Executable ex) {
        return ex.getSharedParameterTypes();
    }

    //
    // Copying routines, needed to quickly fabricate new Field,
    // Method, and Constructor objects from templates
    //
    public Method      copyMethod(Method arg) {
        return arg.copy();
    }
    public Method      leafCopyMethod(Method arg) {
        return arg.leafCopy();
    }

    public Field       copyField(Field arg) {
        return arg.copy();
    }

    public <T> Constructor<T> copyConstructor(Constructor<T> arg) {
        return arg.copy();
    }

    @SuppressWarnings("unchecked")
    public <T extends AccessibleObject> T getRoot(T obj) {
        return (T) obj.getRoot();
    }

    public boolean isTrustedFinalField(Field f) {
        return f.isTrustedFinal();
    }

    public <T> T newInstance(Constructor<T> ctor, Object[] args, Class<?> caller)
        throws IllegalAccessException, InstantiationException, InvocationTargetException
    {
        return ctor.newInstanceWithCaller(args, true, caller);
    }
}
