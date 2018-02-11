/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.vm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>An annotation expressing that a method is especially sensitive
 * to stack overflows. This is a hint the JVM can use to grant access to
 * extra stack space when executing this code if such feature is supported
 * by the JVM. The JVM is free to ignore this annotation.
 *
 * A possible way for the JVM to improve the execution context for methods
 * with this annotation is to reserve part of the thread's execution stack
 * for them. Access to this section of the stack would be denied by default
 * but could be granted if the JVM detects a possible stack overflow and
 * the thread's call stack includes at least one annotated method. Even if
 * access to this reserved area has been granted, the JVM might decide to
 * throw a delayed StackOverflowError when the thread exits the annotated
 * method.
 *
 * @since 9
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface ReservedStackAccess { }
