/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javadoc;

/**
 * Represents a member of a java class: field, constructor, or method.
 * This is an abstract class dealing with information common to
 * method, constructor and field members. Class members of a class
 * (innerclasses) are represented instead by ClassDoc.
 *
 * @see MethodDoc
 * @see FieldDoc
 * @see ClassDoc
 *
 * @author Kaiyang Liu (original)
 * @author Robert Field (rewrite)
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public interface MemberDoc extends ProgramElementDoc {

    /**
     * Returns true if this member was synthesized by the compiler.
     *
     * @return true if this member was synthesized by the compiler.
     */
    boolean isSynthetic();
}
