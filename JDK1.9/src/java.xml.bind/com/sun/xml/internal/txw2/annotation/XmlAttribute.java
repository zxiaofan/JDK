/*
 * Copyright (c) 2005, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.txw2.annotation;

import com.sun.xml.internal.txw2.TypedXmlWriter;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Specifies that the invocation of the method will produce an attribute.
 *
 * <p>
 * The method signature has to match the form {@code R foo(DT1,DT2,..)}
 *
 * <p>
 * R is either {@code void} or the type to which the interface that declares
 * this method is assignable. In the case of the latter, the method will return
 * {@code this} object, allowing you to chain the multiple attribute method
 * invocations like {@link StringBuffer}.
 *
 * <p>
 * DTi must be datatype objects.
 *
 * <p>
 * When this method is called, a new attribute is added to the current element,
 * whose value is whitespace-separated text from each of the datatype objects.
 *
 * @author Kohsuke Kawaguchi
 */
@Retention(RUNTIME)
@Target({METHOD})
public @interface XmlAttribute {
    /**
     * The local name of the attribute.
     *
     * <p>
     * If left unspecified, the method name is used as the attribute name.
     *
     */
    String value() default "";

    /**
     * The namespace URI of the attribute.
     */
    String ns() default "";
}
