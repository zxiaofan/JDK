/*
 * Copyright (c) 2010, 2013, Oracle and/or its affiliates. All rights reserved.
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
 * Annotation to specify a JavaScript "data" property.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Property {
    /**
     * Name of the script property. If empty, the name is inferred.
     * @return name
     */
    public String name() default "";

    /**
     * Attribute flags for this function.
     * @return attribute
     */
    public int attributes() default DEFAULT_ATTRIBUTES;

    /**
     * Initialize this property with the object of given class.
     * @return class
     */
    public String clazz() default "";

    /**
     * Where this property lives?
     * @return location of property
     */
    public Where where() default Where.INSTANCE;
}
