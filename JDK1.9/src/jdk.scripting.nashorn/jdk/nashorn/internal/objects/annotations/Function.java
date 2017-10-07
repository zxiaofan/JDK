/*
 * Copyright (c) 2010, 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.nashorn.internal.objects.annotations;

import static jdk.nashorn.internal.objects.annotations.Attribute.DEFAULT_ATTRIBUTES;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to specify a JavaScript "function" property.
 * Note that -1 means varargs. So, -2 is used as invalid arity.
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Function {
    /**
     * @return the name of the property. If empty, the name is inferred.
     */
    public String name() default "";

    /**
     * @return the attribute flags for this function.
     */
    public int attributes() default DEFAULT_ATTRIBUTES;

    /**
     * @return the arity of the function. By default computed from the method
     *         signature.
     */
    public int arity() default -2;

    /**
     * @return where this function lives.
     */
    public Where where() default Where.PROTOTYPE;
}
