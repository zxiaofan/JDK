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

package com.sun.tools.internal.xjc.generator.bean.field;

import java.util.ArrayList;

import com.sun.tools.internal.xjc.generator.bean.ClassOutlineImpl;
import com.sun.tools.internal.xjc.model.CPropertyInfo;
import com.sun.tools.internal.xjc.model.CReferencePropertyInfo;
import com.sun.tools.internal.xjc.outline.FieldOutline;
import java.io.Serializable;

/**
 * Default implementation of the FieldRendererFactory
 * that faithfully implements the semantics demanded by the JAXB spec.
 *
 * <p>
 * This class is just a facade --- it just determines which
 * {@link FieldRenderer} to use and just delegate the work.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
final class DefaultFieldRenderer implements FieldRenderer {

    private final FieldRendererFactory frf;

    /**
     * Use {@link FieldRendererFactory#getDefault()}.
     */
    DefaultFieldRenderer(FieldRendererFactory frf) {
        this.frf = frf;
    }

    public DefaultFieldRenderer(FieldRendererFactory frf, FieldRenderer defaultCollectionFieldRenderer ) {
        this.frf = frf;
        this.defaultCollectionFieldRenderer = defaultCollectionFieldRenderer;
    }

    private FieldRenderer defaultCollectionFieldRenderer;


    public FieldOutline generate(ClassOutlineImpl outline, CPropertyInfo prop) {
        return decideRenderer(outline,prop).generate(outline,prop);
    }

    private FieldRenderer decideRenderer(ClassOutlineImpl outline, CPropertyInfo prop) {

        if (prop instanceof CReferencePropertyInfo) {
            CReferencePropertyInfo p = (CReferencePropertyInfo)prop;
            if (p.isDummy()) {
                return frf.getDummyList(outline.parent().getCodeModel().ref(ArrayList.class));
            }
            if (p.isContent() && (p.isMixedExtendedCust())) {
                return frf.getContentList(outline.parent().getCodeModel().ref(ArrayList.class).narrow(Serializable.class));
            }
        }

        if(!prop.isCollection()) {
            // non-collection field

            // TODO: check for bidning info for optionalPrimitiveType=boxed or
            // noHasMethod=false and noDeletedMethod=false
            if(prop.isUnboxable())
                // this one uses a primitive type as much as possible
                return frf.getRequiredUnboxed();
            else
                // otherwise use the default non-collection field
                return frf.getSingle();
        }

        if( defaultCollectionFieldRenderer==null ) {
            return frf.getList(outline.parent().getCodeModel().ref(ArrayList.class));
        }

        // this field is a collection field.
        // use untyped list as the default. This is consistent
        // to the JAXB spec.
        return defaultCollectionFieldRenderer;
    }
}
