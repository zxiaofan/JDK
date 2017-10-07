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

import jdk.nashorn.internal.objects.annotations.Function;
import jdk.nashorn.internal.objects.annotations.ScriptClass;
import jdk.nashorn.internal.runtime.PropertyMap;
import jdk.nashorn.internal.runtime.ScriptRuntime;
import jdk.nashorn.internal.runtime.Undefined;

import static jdk.nashorn.internal.runtime.ECMAErrors.typeError;

/**
 * ECMA6 23.2.5 Set Iterator Objects
 */
@ScriptClass("SetIterator")
public class SetIterator extends AbstractIterator {

    // initialized by nasgen
    private static PropertyMap $nasgenmap$;

    private LinkedMap.LinkedMapIterator iterator;

    private final IterationKind iterationKind;

    // Cached global needed for every iteration result
    private final Global global;

    SetIterator(final NativeSet set, final IterationKind iterationKind, final Global global) {
        super(global.getSetIteratorPrototype(), $nasgenmap$);
        this.iterator = set.getJavaMap().getIterator();
        this.iterationKind = iterationKind;
        this.global = global;
    }

    /**
     * ES6 23.2.5.2.1 %SetIteratorPrototype%.next()
     *
     * @param self the self reference
     * @param arg the argument
     * @return the next result
     */
    @Function
    public static Object next(final Object self, final Object arg) {
        if (!(self instanceof SetIterator)) {
            throw typeError("not.a.set.iterator", ScriptRuntime.safeToString(self));
        }
        return ((SetIterator)self).next(arg);
    }

    @Override
    public String getClassName() {
        return "Set Iterator";
    }

    @Override
    protected  IteratorResult next(final Object arg) {
        if (iterator == null) {
            return makeResult(Undefined.getUndefined(), Boolean.TRUE, global);
        }

        final LinkedMap.Node node = iterator.next();

        if (node == null) {
            iterator = null;
            return makeResult(Undefined.getUndefined(), Boolean.TRUE, global);
        }

        if (iterationKind == IterationKind.KEY_VALUE) {
            final NativeArray array = new NativeArray(new Object[] {node.getKey(), node.getKey()});
            return makeResult(array, Boolean.FALSE, global);
        }

        return makeResult(node.getKey(), Boolean.FALSE, global);
    }
}
