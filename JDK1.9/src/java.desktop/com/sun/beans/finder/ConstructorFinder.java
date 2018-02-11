/*
 * Copyright (c) 2008, 2014, Oracle and/or its affiliates. All rights reserved.
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
package com.sun.beans.finder;

import com.sun.beans.util.Cache;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import static com.sun.beans.util.Cache.Kind.SOFT;
import static sun.reflect.misc.ReflectUtil.isPackageAccessible;

/**
 * This utility class provides {@code static} methods
 * to find a public constructor with specified parameter types
 * in specified class.
 *
 * @since 1.7
 *
 * @author Sergey A. Malenkov
 */
public final class ConstructorFinder extends AbstractFinder<Constructor<?>> {
    private static final Cache<Signature, Constructor<?>> CACHE = new Cache<Signature, Constructor<?>>(SOFT, SOFT) {
        @Override
        public Constructor<?> create(Signature signature) {
            try {
                ConstructorFinder finder = new ConstructorFinder(signature.getArgs());
                return finder.find(signature.getType().getConstructors());
            }
            catch (Exception exception) {
                throw new SignatureException(exception);
            }
        }
    };

    /**
     * Finds public constructor
     * that is declared in public class.
     *
     * @param type  the class that can have constructor
     * @param args  parameter types that is used to find constructor
     * @return object that represents found constructor
     * @throws NoSuchMethodException if constructor could not be found
     *                               or some constructors are found
     */
    public static Constructor<?> findConstructor(Class<?> type, Class<?>...args) throws NoSuchMethodException {
        if (type.isPrimitive()) {
            throw new NoSuchMethodException("Primitive wrapper does not contain constructors: "
                + type.getName());
        }
        if (type.isInterface()) {
            throw new NoSuchMethodException("Interface does not contain constructors: "
                + type.getName());
        }
        if (!FinderUtils.isExported(type)) {
            throw new NoSuchMethodException("Class is not accessible: " + type.getName());
        }
        if (Modifier.isAbstract(type.getModifiers())) {
            throw new NoSuchMethodException("Abstract class cannot be instantiated: "
                + type.getName());
        }
        if (!Modifier.isPublic(type.getModifiers()) || !isPackageAccessible(type)) {
            throw new NoSuchMethodException("Class is not accessible: " + type.getName());
        }
        PrimitiveWrapperMap.replacePrimitivesWithWrappers(args);
        Signature signature = new Signature(type, args);

        try {
            return CACHE.get(signature);
        }
        catch (SignatureException exception) {
            throw exception.toNoSuchMethodException("Constructor is not found");
        }
    }

    /**
     * Creates constructor finder with specified array of parameter types.
     *
     * @param args  the array of parameter types
     */
    private ConstructorFinder(Class<?>[] args) {
        super(args);
    }
}
