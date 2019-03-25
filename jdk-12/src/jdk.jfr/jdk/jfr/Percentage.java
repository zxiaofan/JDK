/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Event field annotation to use on fractions, typically between {@code 0.0}
 * and {@code 1.0}, to specify that the value is a percentage.
 * <p>
 * For example, a field with the value {@code 0.5} annotated by this annotation,
 * should be interpreted as {@code 50%} and rendered in a graphical user
 * interface with a percentage sign to avoid confusion with {@code 0.005%}.
 *
 * @since 9
 */
@MetadataDefinition
@ContentType
@Label("Percentage")
@Description("Percentage, represented as a number between 0 and 1")
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
public @interface Percentage {
}
