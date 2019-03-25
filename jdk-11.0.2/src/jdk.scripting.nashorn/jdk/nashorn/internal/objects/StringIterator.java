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
 * ECMA6 21.1.5 String Iterator Objects
 */
@ScriptClass("StringIterator")
public class StringIterator extends AbstractIterator {

    // initialized by nasgen
    private static PropertyMap $nasgenmap$;

    private String iteratedString;
    private int nextIndex = 0;
    private final Global global;

    StringIterator(final String iteratedString, final Global global) {
        super(global.getStringIteratorPrototype(), $nasgenmap$);
        this.iteratedString = iteratedString;
        this.global = global;
    }

    /**
     * ES6 21.1.5.2.1 %StringIteratorPrototype%.next()
     *
     * @param self the self reference
     * @param arg the argument
     * @return the next result
     */
    @Function
    public static Object next(final Object self, final Object arg) {
        if (!(self instanceof StringIterator)) {
            throw typeError("not.a.string.iterator", ScriptRuntime.safeToString(self));
        }
        return ((StringIterator)self).next(arg);
    }

    @Override
    public String getClassName() {
        return "String Iterator";
    }

    @Override
    protected IteratorResult next(final Object arg) {
        final int index = nextIndex;
        final String string = iteratedString;

        if (string == null || index >= string.length()) {
            // ES6 21.1.5.2.1 step 8
            iteratedString = null;
            return makeResult(Undefined.getUndefined(), Boolean.TRUE, global);
        }

        final char first = string.charAt(index);
        if (first >= 0xd800 && first <= 0xdbff && index < string.length() - 1) {
            final char second = string.charAt(index + 1);
            if (second >= 0xdc00 && second <= 0xdfff) {
                nextIndex += 2;
                return makeResult(String.valueOf(new char[] {first, second}), Boolean.FALSE, global);
            }
        }

        nextIndex++;
        return makeResult(String.valueOf(first), Boolean.FALSE, global);
    }
}
