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

import javax.xml.bind.JAXBElement;
import javax.xml.namespace.QName;

import com.sun.tools.internal.xjc.outline.FieldOutline;
import com.sun.tools.internal.xjc.outline.ClassOutline;
import com.sun.tools.internal.xjc.outline.FieldAccessor;
import com.sun.tools.internal.xjc.outline.Outline;
import com.sun.tools.internal.xjc.model.CPropertyInfo;
import com.sun.tools.internal.xjc.model.CElementInfo;
import com.sun.tools.internal.xjc.model.CReferencePropertyInfo;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JBlock;
import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JCodeModel;
import com.sun.codemodel.internal.JInvocation;

/**
 * {@link FieldOutline} that wraps another {@link FieldOutline}
 * and allows JAX-WS to access values without using about
 * {@link JAXBElement}.
 *
 * <p>
 * That means if a value is requested, we unwrap JAXBElement
 * and give it to them. If a value is set, we wrap that into
 * JAXBElement, etc.
 *
 * <p>
 * This can be used only with {@link CReferencePropertyInfo}
 * (or else it won't be {@link JAXBElement),
 * with one {@link CElementInfo} (or else we can't infer the tag name.)
 *
 * @author Kohsuke Kawaguchi
 */
abstract class ElementAdapter implements FieldOutline {
    protected final FieldOutline core;

    /**
     * The only one {@link CElementInfo} that can be in the property.
     */
    protected final CElementInfo ei;

    public ElementAdapter(FieldOutline core, CElementInfo ei) {
        this.core = core;
        this.ei = ei;
    }

    public ClassOutline parent() {
        return core.parent();
    }

    public CPropertyInfo getPropertyInfo() {
        return core.getPropertyInfo();
    }

    protected final Outline outline() {
        return core.parent().parent();
    }

    protected final JCodeModel codeModel() {
        return outline().getCodeModel();
    }

    protected abstract class FieldAccessorImpl implements FieldAccessor {
        final FieldAccessor acc;

        public FieldAccessorImpl(JExpression target) {
            acc = core.create(target);
        }

        public void unsetValues(JBlock body) {
            acc.unsetValues(body);
        }

        public JExpression hasSetValue() {
            return acc.hasSetValue();
        }

        public FieldOutline owner() {
            return ElementAdapter.this;
        }

        public CPropertyInfo getPropertyInfo() {
            return core.getPropertyInfo();
        }

        /**
         * Wraps a type value into a {@link JAXBElement}.
         */
        protected final JInvocation createJAXBElement(JExpression $var) {
            JCodeModel cm = codeModel();

            return JExpr._new(cm.ref(JAXBElement.class))
                .arg(JExpr._new(cm.ref(QName.class))
                    .arg(ei.getElementName().getNamespaceURI())
                    .arg(ei.getElementName().getLocalPart()))
                .arg(getRawType().boxify().erasure().dotclass())
                .arg($var);
        }
    }
}
