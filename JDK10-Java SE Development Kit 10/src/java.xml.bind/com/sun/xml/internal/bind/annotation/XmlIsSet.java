/*
 * Copyright (c) 1997, 2012, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlValue;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Designates a boolean field/property as a flag to indicate
 * whether another property is present or not.
 *
 * <p>
 * Sometimes you'd want to map a Java primitive type to an
 * optional element/attribute. Doing this makes it impossible
 * to represent the absence of the property, thus you always
 * end up producing the value when you marshal to XML.
 *
 * For example,
 * <pre>
 * {@link XmlElement}
 * class Foo {
 *      {@link XmlElement}
 *      int x;
 * }
 *
 * marshaller.marshal(new Foo());
 * </pre>
 * and you get:
 * <pre>{@code
 * <foo><x>0</x></foo>
 * }</pre>
 *
 * <p>
 * By creating a side boolean field/property that has this annotation,
 * you can indicate the absence of the property by setting this boolean
 * to false.
 * <pre>
 * {@link XmlElement}
 * class Foo {
 *      {@link XmlElement}
 *      int x;
 *      {@link XmlIsSet}("x")
 *      boolean xIsPresent;
 * }
 *
 * Foo f = new Foo();
 * f.x = 5;
 * f.xIsPresent = false;
 *
 * marshaller.marshal(f);
 *
 * {@code
 * <foo/>
 * }
 *
 * f.xIsPresent = true;
 * {@code
 * <foo><x>5</x></foo>
 * }
 * </pre>
 *
 * <p>
 * A property/field annotated with {@link XmlIsSet} itself will not show up in XML.
 * It is an error to use this annotation on the same property/field
 * as {@link XmlElement}, {@link XmlAttribute}, {@link XmlValue}, or {@link XmlElementRef},
 * ...<b>TBD</b>.
 *
 * @deprecated
 *      this hasn't been implemented in the RI, and this hasn't been speced yet.
 *      I believe Joe asked for this feature. I'd like to drop this.
 *
 * @author Kohsuke Kawaguchi
 */
@Retention(RUNTIME)
@Target({FIELD,METHOD})
public @interface XmlIsSet {
    /**
     * Specifies the name of the property to attach to.
     */
    String value();
}
