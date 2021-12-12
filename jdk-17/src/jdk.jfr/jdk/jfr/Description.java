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
 * Annotation that describes an element by using a sentence or two.
 * <p>
 * Use sentence-style capitalization, capitalize the first letter of the first
 * word, and any proper names such as the word Java. If the description is one
 * sentence, a period should not be included.
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Description {
    /**
     * Returns a sentence or two that describes the annotated element.
     *
     * @return a description, not {@code null}
     */
    String value();
}
