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

package com.sun.tools.internal.xjc.model;

import javax.activation.MimeType;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.sun.codemodel.internal.JExpr;
import com.sun.codemodel.internal.JExpression;
import com.sun.codemodel.internal.JStringLiteral;
import com.sun.tools.internal.xjc.outline.Outline;
import com.sun.xml.internal.bind.v2.ClassFactory;
import com.sun.xml.internal.bind.v2.model.core.ID;
import com.sun.xml.internal.xsom.XmlString;


/**
 * General-purpose {@link TypeUse} implementation.
 *
 * @author Kohsuke Kawaguchi
 */
final class TypeUseImpl implements TypeUse {
    private final CNonElement coreType;
    private final boolean collection;
    private final CAdapter adapter;
    private final ID id;
    private final MimeType expectedMimeType;


    public TypeUseImpl(CNonElement itemType, boolean collection, ID id, MimeType expectedMimeType, CAdapter adapter) {
        this.coreType = itemType;
        this.collection = collection;
        this.id = id;
        this.expectedMimeType = expectedMimeType;
        this.adapter = adapter;
    }

    public boolean isCollection() {
        return collection;
    }

    public CNonElement getInfo() {
        return coreType;
    }

    public CAdapter getAdapterUse() {
        return adapter;
    }

    public ID idUse() {
        return id;
    }

    public MimeType getExpectedMimeType() {
        return expectedMimeType;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TypeUseImpl)) return false;

        final TypeUseImpl that = (TypeUseImpl) o;

        if (collection != that.collection) return false;
        if (this.id != that.id ) return false;
        if (adapter != null ? !adapter.equals(that.adapter) : that.adapter != null) return false;
        if (coreType != null ? !coreType.equals(that.coreType) : that.coreType != null) return false;

        return true;
    }

    public int hashCode() {
        int result;
        result = (coreType != null ? coreType.hashCode() : 0);
        result = 29 * result + (collection ? 1 : 0);
        result = 29 * result + (adapter != null ? adapter.hashCode() : 0);
        return result;
    }


    public JExpression createConstant(Outline outline, XmlString lexical) {
        if(isCollection())  return null;

        if(adapter==null)     return coreType.createConstant(outline, lexical);

        // [RESULT] new Adapter().unmarshal(CONSTANT);
        JExpression cons = coreType.createConstant(outline, lexical);
        Class<? extends XmlAdapter> atype = adapter.getAdapterIfKnown();

        // try to run the adapter now rather than later.
        if(cons instanceof JStringLiteral && atype!=null) {
            JStringLiteral scons = (JStringLiteral) cons;
            XmlAdapter a = ClassFactory.create(atype);
            try {
                Object value = a.unmarshal(scons.str);
                if(value instanceof String) {
                    return JExpr.lit((String)value);
                }
            } catch (Exception e) {
                // assume that we can't eagerly bind this
            }
        }

        return JExpr._new(adapter.getAdapterClass(outline)).invoke("unmarshal").arg(cons);
    }
}
