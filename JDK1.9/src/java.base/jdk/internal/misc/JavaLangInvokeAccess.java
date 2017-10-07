/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

import java.lang.invoke.MethodType;
import java.util.Map;

public interface JavaLangInvokeAccess {
    /**
     * Create a new MemberName instance. Used by {@see StackFrameInfo}.
     */
    Object newMemberName();

    /**
     * Returns the name for the given MemberName. Used by {@see StackFrameInfo}.
     */
    String getName(Object mname);

    /**
     * Returns {@code true} if the given MemberName is a native method. Used by
     * {@see StackFrameInfo}.
     */
    boolean isNative(Object mname);

    /**
     * Returns a {@code byte[]} representation of a class implementing
     * DirectMethodHandle of each pairwise combination of {@code MethodType} and
     * an {@code int} representing method type.  Used by
     * GenerateJLIClassesPlugin to generate such a class during the jlink phase.
     */
    byte[] generateDirectMethodHandleHolderClassBytes(String className,
            MethodType[] methodTypes, int[] types);

    /**
     * Returns a {@code byte[]} representation of a class implementing
     * DelegatingMethodHandles of each {@code MethodType} kind in the
     * {@code methodTypes} argument.  Used by GenerateJLIClassesPlugin to
     * generate such a class during the jlink phase.
     */
    byte[] generateDelegatingMethodHandleHolderClassBytes(String className,
            MethodType[] methodTypes);

    /**
     * Returns a {@code byte[]} representation of {@code BoundMethodHandle}
     * species class implementing the signature defined by {@code types}. Used
     * by GenerateBMHClassesPlugin to enable generation of such classes during
     * the jlink phase. Should do some added validation since this string may be
     * user provided.
     */
    Map.Entry<String, byte[]> generateConcreteBMHClassBytes(
            final String types);

    /**
     * Returns a {@code byte[]} representation of a class implementing
     * the zero and identity forms of all {@code LambdaForm.BasicType}s.
     */
    byte[] generateBasicFormsClassBytes(final String className);

    /**
     * Returns a {@code byte[]} representation of a class implementing
     * the invoker forms for the set of supplied {@code methodTypes}.
     */
    byte[] generateInvokersHolderClassBytes(String className,
            MethodType[] methodTypes);
}
