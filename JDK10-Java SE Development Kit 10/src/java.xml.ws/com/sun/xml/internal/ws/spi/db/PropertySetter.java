/*
 * Copyright (c) 1997, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.ws.spi.db;

/**
 * PropertySetter
 *
 * @author shih-chang.chen@oracle.com
 * @exclude
 */
public interface PropertySetter {

    public Class getType();

    public <A> A getAnnotation(Class<A> annotationType);

    public void set(Object instance, Object resource);
}
