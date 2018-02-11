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

package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSFacet;
import com.sun.xml.internal.xsom.XSSimpleType;
import com.sun.xml.internal.xsom.XSUnionSimpleType;
import com.sun.xml.internal.xsom.XSVariety;
import com.sun.xml.internal.xsom.impl.parser.SchemaDocumentImpl;
import com.sun.xml.internal.xsom.visitor.XSSimpleTypeFunction;
import com.sun.xml.internal.xsom.visitor.XSSimpleTypeVisitor;
import org.xml.sax.Locator;

import java.util.Iterator;
import java.util.Set;
import java.util.List;
import java.util.Collections;

public class UnionSimpleTypeImpl extends SimpleTypeImpl implements XSUnionSimpleType
{
    public UnionSimpleTypeImpl( SchemaDocumentImpl _parent,
                                AnnotationImpl _annon, Locator _loc, ForeignAttributesImpl _fa,
                                String _name, boolean _anonymous, Set<XSVariety> finalSet,
                                Ref.SimpleType[] _members ) {

        super(_parent,_annon,_loc,_fa,_name,_anonymous, finalSet,
            _parent.getSchema().parent.anySimpleType);

        this.memberTypes = _members;
    }

    private final Ref.SimpleType[] memberTypes;
    public XSSimpleType getMember( int idx ) { return memberTypes[idx].getType(); }
    public int getMemberSize() { return memberTypes.length; }

    public Iterator<XSSimpleType> iterator() {
        return new Iterator<XSSimpleType>() {
            int idx=0;
            public boolean hasNext() {
                return idx<memberTypes.length;
            }

            public XSSimpleType next() {
                return memberTypes[idx++].getType();
            }

            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public void visit( XSSimpleTypeVisitor visitor ) {
        visitor.unionSimpleType(this);
    }
    public Object apply( XSSimpleTypeFunction function ) {
        return function.unionSimpleType(this);
    }

    public XSUnionSimpleType getBaseUnionType() {
        return this;
    }

    // union type by itself doesn't have any facet. */
    public XSFacet getFacet( String name ) { return null; }
    public List<XSFacet> getFacets( String name ) { return Collections.EMPTY_LIST; }

    public XSVariety getVariety() { return XSVariety.UNION; }

    public XSSimpleType getPrimitiveType() { return null; }

    public boolean isUnion() { return true; }
    public XSUnionSimpleType asUnion() { return this; }
}
