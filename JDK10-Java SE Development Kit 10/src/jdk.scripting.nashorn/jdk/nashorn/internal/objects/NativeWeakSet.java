/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.objects;

import java.util.Map;
import java.util.WeakHashMap;
import jdk.nashorn.internal.objects.annotations.Attribute;
import jdk.nashorn.internal.objects.annotations.Constructor;
import jdk.nashorn.internal.objects.annotations.Function;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import jdk.nashorn.internal.runtime.PropertyMap;
import jdk.nashorn.internal.runtime.ScriptObject;
import jdk.nashorn.internal.runtime.ScriptRuntime;
import jdk.nashorn.internal.runtime.Undefined;

import static jdk.nashorn.internal.objects.NativeWeakMap.checkKey;
import static jdk.nashorn.internal.runtime.ECMAErrors.typeError;
import static jdk.nashorn.internal.runtime.JSType.isPrimitive;

/**
 * This implements the ECMA6 WeakSet object.
 */
@ScriptClass("WeakSet")
public class NativeWeakSet extends ScriptObject {

    private final Map<Object, Boolean> map = new WeakHashMap<>();

    // initialized by nasgen
    private static PropertyMap $nasgenmap$;

    private NativeWeakSet(final ScriptObject proto, final PropertyMap map) {
        super(proto, map);
    }

    /**
     * ECMA6 23.3.1 The WeakSet Constructor
     *
     * @param isNew  whether the new operator used
     * @param self self reference
     * @param arg optional iterable argument
     * @return a new WeakSet object
     */
    @Constructor(arity = 0)
    public static Object construct(final boolean isNew, final Object self, final Object arg) {
        if (!isNew) {
            throw typeError("constructor.requires.new", "WeakSet");
        }
        final Global global = Global.instance();
        final NativeWeakSet weakSet = new NativeWeakSet(global.getWeakSetPrototype(), $nasgenmap$);
        populateWeakSet(weakSet.map, arg, global);
        return weakSet;
    }

    /**
     * ECMA6 23.4.3.1 WeakSet.prototype.add ( value )
     *
     * @param self the self reference
     * @param value the value to add
     * @return this Set object
     */
    @Function(attributes = Attribute.NOT_ENUMERABLE)
    public static Object add(final Object self, final Object value) {
        final NativeWeakSet set = getSet(self);
        set.map.put(checkKey(value), Boolean.TRUE);
        return self;
    }

    /**
     * ECMA6 23.4.3.4 WeakSet.prototype.has ( value )
     *
     * @param self the self reference
     * @param value the value
     * @return true if value is contained
     */
    @Function(attributes = Attribute.NOT_ENUMERABLE)
    public static boolean has(final Object self, final Object value) {
        final NativeWeakSet set = getSet(self);
        return !isPrimitive(value) && set.map.containsKey(value);
    }

    /**
     * ECMA6 23.4.3.3 WeakSet.prototype.delete ( value )
     *
     * @param self the self reference
     * @param value the value
     * @return true if value was deleted
     */
    @Function(attributes = Attribute.NOT_ENUMERABLE)
    public static boolean delete(final Object self, final Object value) {
        final Map<Object, Boolean> map = getSet(self).map;
        if (isPrimitive(value)) {
            return false;
        }
        final boolean returnValue = map.containsKey(value);
        map.remove(value);
        return returnValue;
    }

    @Override
    public String getClassName() {
        return "WeakSet";
    }

    static void populateWeakSet(final Map<Object, Boolean> set, final Object arg, final Global global) {
        if (arg != null && arg != Undefined.getUndefined()) {
            AbstractIterator.iterate(arg, global, value -> {
                    set.put(checkKey(value), Boolean.TRUE);
            });
        }
    }

    private static NativeWeakSet getSet(final Object self) {
        if (self instanceof NativeWeakSet) {
            return (NativeWeakSet) self;
        } else {
            throw typeError("not.a.weak.set", ScriptRuntime.safeToString(self));
        }
    }
}
