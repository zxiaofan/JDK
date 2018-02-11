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

import com.sun.codemodel.internal.JBlock;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JFieldVar;
import com.sun.codemodel.internal.JMod;
import com.sun.codemodel.internal.JPrimitiveType;
import com.sun.codemodel.internal.JType;
import com.sun.codemodel.internal.JVar;
import com.sun.tools.internal.xjc.generator.bean.ClassOutlineImpl;
import com.sun.tools.internal.xjc.model.CPropertyInfo;
import com.sun.tools.internal.xjc.outline.FieldAccessor;

/**
 * Realizes a property as a "public static final" property on the interface.
 * This class can handle both boxed/unboxed types and both
 * single/colllection.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
final class ConstField extends AbstractField {
//    /**
//     * Number of items in this property, when
//     * {@link #isCollection}==true.
//     */
//    private final int count=1;

    /** Generated constant property on the interface. */
    private final JFieldVar $ref;

    ConstField( ClassOutlineImpl outline, CPropertyInfo prop ) {
        super(outline,prop);

        // we only support value constraints for a single-value property.
        assert !prop.isCollection();

        JPrimitiveType ptype = implType.boxify().getPrimitiveType();

        // generate the constant
        JExpression defaultValue = null;
        if(prop.defaultValue!=null)
            defaultValue = prop.defaultValue.compute(outline.parent());

        $ref = outline.ref.field(JMod.PUBLIC|JMod.STATIC|JMod.FINAL,
            ptype!=null?ptype:implType, prop.getName(true), defaultValue );
        $ref.javadoc().append(prop.javadoc);

        annotate($ref);
    }

    public JType getRawType() {
//        if( isCollection )      return getInfo().array();
        return exposedType;
    }


    public FieldAccessor create(JExpression target) {
        return new Accessor(target);
    }

    private class Accessor extends AbstractField.Accessor {

        Accessor( JExpression $target ) {
            super($target);
        }

        public void unsetValues( JBlock body ) {
            ;   // can't unset values
        }
        public JExpression hasSetValue() {
            return null;    // can't generate the isSet/unset methods
        }
        public void toRawValue(JBlock block, JVar $var) {
            // TODO: rethink abstraction. Those constant fields
            // don't have "access" to them.
            throw new UnsupportedOperationException();
        }

        public void fromRawValue(JBlock block, String uniqueName, JExpression $var) {
            throw new UnsupportedOperationException();
        }
    }
}
