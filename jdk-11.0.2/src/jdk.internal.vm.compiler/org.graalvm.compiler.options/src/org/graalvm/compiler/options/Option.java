/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.options;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describes the attributes of an option whose {@link OptionKey value} is in a static field
 * annotated by this annotation type.
 *
 * @see OptionDescriptor
 */
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.FIELD)
public @interface Option {

    /**
     * Gets a help message for the option.
     * <p>
     * The first element of the array is the short help message. This part of the help message is
     * subject to line wrapping when printed.
     * <p>
     * The remaining elements contain a more detailed expansion of the help message and will be
     * printed as is in a left-aligned block (i.e. leading spaces will be preserved).
     * <p>
     * If there is only one element and it starts with {@code "file:"<path>}, then the help message
     * is located in a file located by resolving {@code <path>} against the location of the package
     * in which the option is declared. The first line in the file is the short help message as
     * described above. The remaining lines are the help message expansion.
     */
    String[] help();

    /**
     * The name of the option. By default, the name of the annotated field should be used.
     */
    String name() default "";

    /**
     * Specifies the type of the option.
     */
    OptionType type() default OptionType.Debug;
}
