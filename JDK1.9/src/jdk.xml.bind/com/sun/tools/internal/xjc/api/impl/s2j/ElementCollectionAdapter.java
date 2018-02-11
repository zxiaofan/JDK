/*
 * Copyright (c) 1997, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBElement;

import com.sun.codemodel.internal.JBlock;
import com.sun.codemodel.internal.JClass;
import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JConditional;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JForEach;
import com.sun.codemodel.internal.JType;
import com.sun.codemodel.internal.JVar;
import com.sun.tools.internal.xjc.model.CElementInfo;
import static com.sun.tools.internal.xjc.outline.Aspect.EXPOSED;
import com.sun.tools.internal.xjc.outline.FieldAccessor;
import com.sun.tools.internal.xjc.outline.FieldOutline;

/**
 * {@link ElementAdapter} that works with a collection
 * of {@link JAXBElement}.
 *
 * @author Kohsuke Kawaguchi
 */
final class ElementCollectionAdapter extends ElementAdapter {
    public ElementCollectionAdapter(FieldOutline core, CElementInfo ei) {
        super(core, ei);
    }

    public JType getRawType() {
        return codeModel().ref(List.class).narrow(itemType().boxify());
    }

    private JType itemType() {
        return ei.getContentInMemoryType().toType(outline(), EXPOSED);
    }

    public FieldAccessor create(JExpression targetObject) {
        return new FieldAccessorImpl(targetObject);
    }

    final class FieldAccessorImpl extends ElementAdapter.FieldAccessorImpl {
        public FieldAccessorImpl(JExpression target) {
            super(target);
        }

        public void toRawValue(JBlock block, JVar $var) {
            JCodeModel cm = outline().getCodeModel();
            JClass elementType = ei.toType(outline(),EXPOSED).boxify();

            // [RESULT]
            // $var = new ArrayList();
            // for( JAXBElement e : [core.toRawValue] ) {
            //   if(e==null)
            //     $var.add(null);
            //   else
            //     $var.add(e.getValue());
            // }

            block.assign($var,JExpr._new(cm.ref(ArrayList.class).narrow(itemType().boxify())));
            JVar $col = block.decl(core.getRawType(), "col" + hashCode());
            acc.toRawValue(block,$col);
            JForEach loop = block.forEach(elementType, "v" + hashCode()/*unique string handling*/, $col);

            JConditional cond = loop.body()._if(loop.var().eq(JExpr._null()));
            cond._then().invoke($var,"add").arg(JExpr._null());
            cond._else().invoke($var,"add").arg(loop.var().invoke("getValue"));
        }

        public void fromRawValue(JBlock block, String uniqueName, JExpression $var) {
            JCodeModel cm = outline().getCodeModel();
            JClass elementType = ei.toType(outline(),EXPOSED).boxify();

            // [RESULT]
            // $t = new ArrayList();
            // for( Type e : $var ) {
            //     $var.add(new JAXBElement(e));
            // }
            // [core.fromRawValue]

            JClass col = cm.ref(ArrayList.class).narrow(elementType);
            JVar $t = block.decl(col,uniqueName+"_col",JExpr._new(col));

            JForEach loop = block.forEach(itemType(), uniqueName+"_i", $t);
            loop.body().invoke($var,"add").arg(createJAXBElement(loop.var()));

            acc.fromRawValue(block, uniqueName, $t);
        }
    }
}
