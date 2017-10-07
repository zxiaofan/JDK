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

import org.xml.sax.Locator;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;

/**
 * Marks a property that receives a location from which the object is unmarshalled.
 *
 * <h2>Usage</h2>
 * <p>
 * The @XmlLocation can be specified on:
 * <ul>
 *  <li>a field whose type is {@link Locator}, or
 *  <li>a method that takes a {@link Locator} as the sole parameter
 * </ul>
 *
 * <p>
 * When a class that contains such a field/method is unmarshalled by the JAXB RI,
 * such a field/method will receive an immutable {@link Locator} object that describes
 * the location in the XML document where the object is unmarshalled from.
 *
 * <p>
 * If the unmarshaller does not know the source location information, the locator
 * will not be set. For example, this happens when it is unmarshalling from a DOM tree.
 * This also happens if you use JAXB implementations other than the JAXB RI.
 *
 * <p>
 * This information can be used by applications, for example to provide user-friendly
 * error information.
 *
 *
 * @author Kohsuke Kawaguchi
 * @since JAXB RI 2.0 EA
 */
@Retention(RUNTIME) @Target({FIELD,METHOD})
public @interface XmlLocation {
}
