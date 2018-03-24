/*
 * Copyright (c) 2001, 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.reflect;

public class Reflection {

    private Reflection() { }

    /**
     * @deprecated This method is an internal API and will be removed.
     * Use {@link StackWalker} to walk the stack and obtain the caller class
     * with {@link StackWalker.StackFrame#getDeclaringClass} instead.
     */
    @Deprecated(forRemoval=true)
    @SuppressWarnings("removal") // Reflection.getCallerClass
    public static Class<?> getCallerClass(int depth) {
        if (depth < 0)
            throw new InternalError("depth must be positive");

        // increase depth to account for delegation to the internal impl
        return jdk.internal.reflect.Reflection.getCallerClass(depth + 1);
    }
}
