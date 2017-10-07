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

package com.sun.tools.internal.xjc.reader.xmlschema.ct;

import java.util.Collections;

import static com.sun.tools.internal.xjc.reader.xmlschema.ct.ComplexTypeBindingMode.NORMAL;
import com.sun.xml.internal.xsom.XSComplexType;
import com.sun.xml.internal.xsom.XSModelGroup;
import com.sun.xml.internal.xsom.XSParticle;

/**
 * Binds a complex type whose immediate child is a choice
 * model group to a choice content interface.
 *
 * @author Kohsuke Kawaguchi
 */
final class ChoiceContentComplexTypeBuilder extends CTBuilder {

    public boolean isApplicable(XSComplexType ct) {
        if( !bgmBuilder.getGlobalBinding().isChoiceContentPropertyEnabled() )
            return false;

        if( ct.getBaseType()!=schemas.getAnyType() )
            // My reading of the spec is that if a complex type is
            // derived from another complex type by extension,
            // its top level model group is always a sequence
            // that combines the base type content model and
            // the extension defined in the new complex type.
            return false;

        XSParticle p = ct.getContentType().asParticle();
        if(p==null)
            return false;

        XSModelGroup mg = getTopLevelModelGroup(p);

        if( mg.getCompositor()!=XSModelGroup.CHOICE )
            return false;

        if( p.isRepeated() )
            return false;

        return true;
    }



    private XSModelGroup getTopLevelModelGroup(XSParticle p) {
        XSModelGroup mg = p.getTerm().asModelGroup();
        if( p.getTerm().isModelGroupDecl() )
            mg = p.getTerm().asModelGroupDecl().getModelGroup();
        return mg;
    }

    public void build(XSComplexType ct) {
        XSParticle p = ct.getContentType().asParticle();

        builder.recordBindingMode(ct,NORMAL);

        bgmBuilder.getParticleBinder().build(p,Collections.singleton(p));

        green.attContainer(ct);
    }


}
