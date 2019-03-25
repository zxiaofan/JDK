/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Java Programming Language version.  The constants of this enum
 * identify the JDK and J2SE releases containing language changes
 * relevant to doclets.
 * <p>
 * All doclets support at least the 1.1 language version.
 * The first release subsequent to this with language changes
 * affecting doclets is 1.5.
 *
 * @since 1.5
 *
 * @deprecated
 *   The declarations in this package have been superseded by those
 *   in the package {@code jdk.javadoc.doclet}.
 *   For more information, see the <i>Migration Guide</i> in the documentation for that package.
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public enum LanguageVersion {

    /** 1.1 added nested classes and interfaces. */
    JAVA_1_1,

    /** 1.5 added generic types, annotations, enums, and varArgs. */
    JAVA_1_5
}
