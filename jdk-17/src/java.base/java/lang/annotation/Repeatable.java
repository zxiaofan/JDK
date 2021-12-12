/*
 * Copyright (c) 2012, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.annotation;

/**
 * The annotation interface {@code java.lang.annotation.Repeatable} is
 * used to indicate that the annotation interface whose declaration it
 * (meta-)annotates is <em>repeatable</em>. The value of
 * {@code @Repeatable} indicates the <em>containing annotation
 * interface</em> for the repeatable annotation interface.
 *
 * @since 1.8
 * @jls 9.6.3 Repeatable Annotation Interfaces
 * @jls 9.7.5 Multiple Annotations of the Same Interface
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface Repeatable {
    /**
     * Indicates the <em>containing annotation interface</em> for the
     * repeatable annotation interface.
     * @return the containing annotation interface
     */
    Class<? extends Annotation> value();
}
