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
 * Annotation that sets a human-readable name for an element (for example,
 * {@code "Maximum Throughput"}).
 * <p>
 * Use headline-style capitalization, capitalize the first and last words, and
 * all nouns, pronouns, adjectives, verbs and adverbs. Do not include ending
 * punctuation.
 * <p>
 * The label should not be used as an identifier, see {@link Name}.
 *
 * @since 9
 */
@MetadataDefinition
@Target({ ElementType.TYPE, ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Label {
    /**
     * Returns a human-readable name for the annotated element.
     *
     * @return a human-readable name, not {@code null}
     */
    String value();
}
