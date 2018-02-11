/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.model.runtime;

import java.lang.reflect.Type;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;

import com.sun.xml.internal.bind.v2.model.core.ClassInfo;
import com.sun.xml.internal.bind.v2.runtime.JAXBContextImpl;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import com.sun.xml.internal.bind.annotation.XmlLocation;

import org.xml.sax.Locator;

/**
 * @author Kohsuke Kawaguchi (kk@kohsuke.org)
 */
public interface RuntimeClassInfo extends ClassInfo<Type,Class>, RuntimeNonElement {
    RuntimeClassInfo getBaseClass();

    // refined to return RuntimePropertyInfo
    List<? extends RuntimePropertyInfo> getProperties();
    RuntimePropertyInfo getProperty(String name);

    Method getFactoryMethod();

    /**
     * If {@link #hasAttributeWildcard()} is true,
     * returns the accessor to access the property.
     *
     * @return
     *      unoptimized accessor.
     *      non-null iff {@link #hasAttributeWildcard()}==true.
     *
     * @see Accessor#optimize(JAXBContextImpl)
     */
    <BeanT> Accessor<BeanT,Map<QName,String>> getAttributeWildcard();

    /**
     * If this JAXB bean has a property annotated with {@link XmlLocation},
     * this method returns it.
     *
     * @return may be null.
     */
    <BeanT> Accessor<BeanT,Locator> getLocatorField();
}
