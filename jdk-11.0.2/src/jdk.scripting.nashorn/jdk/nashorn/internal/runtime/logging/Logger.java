/*
 * Copyright (c) 2010, 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.nashorn.internal.runtime.logging;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * This annotation is associated with a class that has a logger.
 * It contains a name property of the logger name. e.g. a class
 * whose logger can be initialized by --log:fields, should be
 * annotated @Logger(name="fields"). Multiple classes can have
 * the same annotation, which will make them use the same logger
 * object. Usually a class with this annotation is also a Loggable,
 * but it is not a hard demand
 *
 * @see Loggable
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Logger {
    /**
     * Get the name of the logger
     * @return logger name
     */
    public String name() default "";
}
