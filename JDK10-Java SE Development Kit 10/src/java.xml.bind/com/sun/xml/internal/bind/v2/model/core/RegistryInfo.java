/*
 * Copyright (c) 1997, 2017, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.bind.v2.model.core;

import java.util.Set;

import javax.xml.bind.annotation.XmlRegistry;

/**
 * Represents the information in a class with {@link XmlRegistry} annotaion.
 *
 * <p>
 * This interface is only meant to be used as a return type from
 * {@link com.sun.xml.internal.bind.v2.model.impl.ModelBuilderI}.
 *
 * @author Kohsuke Kawaguchi
 * @param <T>
 * @param <C>
 */
public interface RegistryInfo<T,C> {
    /**
     * Returns all the references to other types in this registry.
     * @return
     */
    Set<TypeInfo<T,C>> getReferences();

    /**
     * Returns the class with {@link XmlRegistry}.
     * @return
     */
    C getClazz();
}
