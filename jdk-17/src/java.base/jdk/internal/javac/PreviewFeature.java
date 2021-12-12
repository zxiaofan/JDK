/*
 * Copyright (c) 2019, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.javac;

import java.lang.annotation.*;

/**
 * Indicates the API declaration in question is associated with a
 * <em>preview feature</em>. See JEP 12: "Preview Language and VM
 * Features" (http://openjdk.java.net/jeps/12).
 *
 * Note this internal annotation is handled specially by the javac compiler.
 * To work properly with {@code --release older-release}, it requires special
 * handling in {@code make/langtools/src/classes/build/tools/symbolgenerator/CreateSymbols.java}
 * and {@code src/jdk.compiler/share/classes/com/sun/tools/javac/jvm/ClassReader.java}.
 *
 * @since 14
 */
// Match the meaningful targets of java.lang.Deprecated, omit local
// variables and parameter declarations
@Target({ElementType.METHOD,
         ElementType.CONSTRUCTOR,
         ElementType.FIELD,
         ElementType.PACKAGE,
         ElementType.MODULE,
         ElementType.TYPE})
 // CLASS retention will hopefully be sufficient for the purposes at hand
@Retention(RetentionPolicy.CLASS)
// *Not* @Documented
public @interface PreviewFeature {
    /**
     * Name of the preview feature the annotated API is associated
     * with.
     */
    public Feature feature();

    public boolean reflective() default false;

    public enum Feature {
        /*
         * This one can only be removed after JDK 17
         */
        SEALED_CLASSES,
        SWITCH_PATTERN_MATCHING,
        /**
         * A key for testing.
         */
        TEST,
        ;
    }
}
