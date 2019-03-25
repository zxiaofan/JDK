/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.runtime;

import static jdk.nashorn.internal.lookup.Lookup.MH;
import static jdk.nashorn.internal.runtime.ScriptRuntime.UNDEFINED;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import jdk.nashorn.internal.objects.Global;

/**
 * Instances of this class serve as "prototype" object for script functions.
 * The purpose is to expose "constructor" property from "prototype". Also, nasgen
 * generated prototype classes extend from this class.
 */
public class PrototypeObject extends ScriptObject {
    private static final PropertyMap map$;

    private Object constructor;

    private static final MethodHandle GET_CONSTRUCTOR = findOwnMH("getConstructor", Object.class, Object.class);
    private static final MethodHandle SET_CONSTRUCTOR = findOwnMH("setConstructor", void.class, Object.class, Object.class);

    static {
        final ArrayList<Property> properties = new ArrayList<>(1);
        properties.add(AccessorProperty.create("constructor", Property.NOT_ENUMERABLE, GET_CONSTRUCTOR, SET_CONSTRUCTOR));
        map$ = PropertyMap.newMap(properties);
    }

    private PrototypeObject(final Global global, final PropertyMap map) {
        super(global.getObjectPrototype(), map != map$? map.addAll(map$) : map$);
    }

    /**
     * Prototype constructor
     */
    protected PrototypeObject() {
        this(Global.instance(), map$);
    }

    /**
     * PropertyObject constructor
     *
     * @param map property map
     */
    protected PrototypeObject(final PropertyMap map) {
        this(Global.instance(), map);
    }

    /**
     * PropertyObject constructor
     *
     * @param func constructor function
     */
    protected PrototypeObject(final ScriptFunction func) {
        this(Global.instance(), map$);
        this.constructor = func;
    }

    /**
     * Get the constructor for this {@code PrototypeObject}
     * @param self self reference
     * @return constructor, probably, but not necessarily, a {@link ScriptFunction}
     */
    public static Object getConstructor(final Object self) {
        return (self instanceof PrototypeObject) ?
            ((PrototypeObject)self).getConstructor() :
            UNDEFINED;
    }

    /**
     * Reset the constructor for this {@code PrototypeObject}
     * @param self self reference
     * @param constructor constructor, probably, but not necessarily, a {@link ScriptFunction}
     */
    public static void setConstructor(final Object self, final Object constructor) {
        if (self instanceof PrototypeObject) {
            ((PrototypeObject)self).setConstructor(constructor);
        }
    }

    private Object getConstructor() {
        return constructor;
    }

    private void setConstructor(final Object constructor) {
        this.constructor = constructor;
    }

    private static MethodHandle findOwnMH(final String name, final Class<?> rtype, final Class<?>... types) {
        return MH.findStatic(MethodHandles.lookup(), PrototypeObject.class, name, MH.type(rtype, types));
    }
}
