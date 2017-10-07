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
import jdk.nashorn.internal.runtime.JSType;
import jdk.nashorn.internal.runtime.PropertyMap;
import jdk.nashorn.internal.runtime.ScriptObject;
import jdk.nashorn.internal.runtime.ScriptRuntime;
import jdk.nashorn.internal.runtime.Undefined;

import static jdk.nashorn.internal.runtime.ECMAErrors.typeError;

@ScriptClass("ArrayIterator")
public class ArrayIterator extends AbstractIterator {

    // initialized by nasgen
    private static PropertyMap $nasgenmap$;

    private ScriptObject iteratedObject;
    private long nextIndex = 0L;
    private final IterationKind iterationKind;
    private final Global global;


    private ArrayIterator(final Object iteratedObject, final IterationKind iterationKind, final Global global) {
        super(global.getArrayIteratorPrototype(), $nasgenmap$);
        this.iteratedObject = iteratedObject instanceof ScriptObject ? (ScriptObject) iteratedObject : null;
        this.iterationKind = iterationKind;
        this.global = global;
    }

    static ArrayIterator newArrayValueIterator(final Object iteratedObject) {
        return new ArrayIterator(Global.toObject(iteratedObject), IterationKind.VALUE, Global.instance());
    }

    static ArrayIterator newArrayKeyIterator(final Object iteratedObject) {
        return new ArrayIterator(Global.toObject(iteratedObject), IterationKind.KEY, Global.instance());
    }

    static ArrayIterator newArrayKeyValueIterator(final Object iteratedObject) {
        return new ArrayIterator(Global.toObject(iteratedObject), IterationKind.KEY_VALUE, Global.instance());
    }

    /**
     * 22.1.5.2.1 %ArrayIteratorPrototype%.next()
     *
     * @param self the self reference
     * @param arg the argument
     * @return the next result
     */
    @Function
    public static Object next(final Object self, final Object arg) {
        if (!(self instanceof ArrayIterator)) {
            throw typeError("not.a.array.iterator", ScriptRuntime.safeToString(self));
        }
        return ((ArrayIterator)self).next(arg);
    }

    @Override
    public String getClassName() {
        return "Array Iterator";
    }

    @Override
    protected IteratorResult next(final Object arg) {
        final long index = nextIndex;

        if (iteratedObject == null || index >= JSType.toUint32(iteratedObject.getLength())) {
            // ES6 22.1.5.2.1 step 10
            iteratedObject = null;
            return makeResult(Undefined.getUndefined(), Boolean.TRUE, global);
        }

        nextIndex++;

        if (iterationKind == IterationKind.KEY_VALUE) {
            final NativeArray value = new NativeArray(
                    new Object[] {JSType.toNarrowestNumber(index), iteratedObject.get((double) index)});
            return makeResult(value, Boolean.FALSE, global);
        }

        final Object value = iterationKind == IterationKind.KEY ?
                JSType.toNarrowestNumber(index) : iteratedObject.get((double) index);
        return makeResult(value, Boolean.FALSE, global);
    }

}
