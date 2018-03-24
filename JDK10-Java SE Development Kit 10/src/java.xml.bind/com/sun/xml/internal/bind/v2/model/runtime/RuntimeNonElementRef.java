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

package com.sun.xml.internal.bind.v2.model.runtime;

import java.lang.reflect.Type;

import com.sun.xml.internal.bind.v2.model.core.NonElementRef;
import com.sun.xml.internal.bind.v2.runtime.Transducer;

/**
 * Runtime version of {@link NonElementRef}.
 *
 * <p>
 * Inside the implementation, reference decorators implement this interface
 * and this interface is used for chaining. Also, every {@link RuntimeNonElement}
 * implementation implements this interface so that undecorated plain
 * reference can be represented without using a separate object.
 *
 * @author Kohsuke Kawaguchi
 */
public interface RuntimeNonElementRef extends NonElementRef<Type,Class> {
    // refinements
    RuntimeNonElement getTarget();
    RuntimePropertyInfo getSource();

    /**
     * If the XML representation of the referenced Java type is just a text,
     * return a transducer that converts between the bean and XML.
     */
    Transducer getTransducer();

    // TransducedAccessor should be created
}
