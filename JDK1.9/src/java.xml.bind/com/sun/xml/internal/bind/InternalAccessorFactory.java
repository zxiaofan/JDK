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

package com.sun.xml.internal.bind;

import java.lang.reflect.Field;
import com.sun.xml.internal.bind.v2.runtime.reflect.Accessor;
import javax.xml.bind.JAXBException;

/**
 * A means to allow the user to provide customized Accessor
 * to be used by JAXB. Adds ability to suppress warnings.
 */
public interface InternalAccessorFactory extends AccessorFactory {
    /**
     * Access a field of the class.
     *
     * @param bean the class to be processed.
     * @param f the field within the class to be accessed.
     * @param readOnly  the isStatic value of the field's modifier.
     * @param supressWarnings suppress reflection warnings
     * @return Accessor the accessor for this field
     *
     * @throws JAXBException reports failures of the method.
     */
    Accessor createFieldAccessor(Class bean, Field f, boolean readOnly, boolean supressWarnings) throws JAXBException;

}
