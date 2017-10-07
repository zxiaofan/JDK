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

package com.sun.tools.internal.xjc.api.impl.s2j;

import java.util.List;

import com.sun.tools.internal.xjc.api.Mapping;
import com.sun.tools.internal.xjc.api.Property;
import com.sun.tools.internal.xjc.api.TypeAndAnnotation;
import com.sun.tools.internal.xjc.model.CClassInfo;

/**
 * Partial implementation of {@link Mapping}
 * for bean classes.
 *
 * @author Kohsuke Kawaguchi
 */
final class BeanMappingImpl extends AbstractMappingImpl<CClassInfo> {

    private final TypeAndAnnotationImpl taa = new TypeAndAnnotationImpl(parent.outline,clazz);

    BeanMappingImpl(JAXBModelImpl parent, CClassInfo classInfo) {
        super(parent,classInfo);
        assert classInfo.isElement();
    }

    public TypeAndAnnotation getType() {
        return taa;
    }

    public final String getTypeClass() {
        return getClazz();
    }

    public List<Property> calcDrilldown() {
        if(!clazz.isOrdered())
            return null;    // all is not eligible for the wrapper style
        return buildDrilldown(clazz);
    }
}
