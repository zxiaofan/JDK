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

package com.sun.xml.internal.xsom.impl;

import com.sun.xml.internal.xsom.XSElementDecl;
import com.sun.xml.internal.xsom.XSIdentityConstraint;
import com.sun.xml.internal.xsom.XSXPath;
import com.sun.xml.internal.xsom.impl.parser.SchemaDocumentImpl;
import com.sun.xml.internal.xsom.visitor.XSFunction;
import com.sun.xml.internal.xsom.visitor.XSVisitor;
import org.xml.sax.Locator;

import java.util.Collections;
import java.util.List;

/**
 * {@link XSIdentityConstraint} implementation.
 *
 * @author Kohsuke Kawaguchi
 */
public class IdentityConstraintImpl extends ComponentImpl implements XSIdentityConstraint, Ref.IdentityConstraint {

    private XSElementDecl parent;
    private final short category;
    private final String name;
    private final XSXPath selector;
    private final List<XSXPath> fields;
    private final Ref.IdentityConstraint refer;

    public IdentityConstraintImpl(SchemaDocumentImpl _owner, AnnotationImpl _annon, Locator _loc,
        ForeignAttributesImpl fa, short category, String name, XPathImpl selector,
        List<XPathImpl> fields, Ref.IdentityConstraint refer) {

        super(_owner, _annon, _loc, fa);
        this.category = category;
        this.name = name;
        this.selector = selector;
        selector.setParent(this);
        this.fields = (List<XSXPath>) Collections.unmodifiableList((List<? extends XSXPath>)fields);
        for( XPathImpl xp : fields )
            xp.setParent(this);
        this.refer = refer;
    }


    @Override
    public void visit(XSVisitor visitor) {
        visitor.identityConstraint(this);
    }

    @Override
    public <T> T apply(XSFunction<T> function) {
        return function.identityConstraint(this);
    }

    public void setParent(ElementDecl parent) {
        this.parent = parent;
        parent.getOwnerSchema().addIdentityConstraint(this);
    }

    @Override
    public XSElementDecl getParent() {
        return parent;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getTargetNamespace() {
        return getParent().getTargetNamespace();
    }

    @Override
    public short getCategory() {
        return category;
    }

    @Override
    public XSXPath getSelector() {
        return selector;
    }

    @Override
    public List<XSXPath> getFields() {
        return fields;
    }

    @Override
    public XSIdentityConstraint getReferencedKey() {
        if(category==KEYREF)
            return refer.get();
        else
            throw new IllegalStateException("not a keyref");
    }

    @Override
    public XSIdentityConstraint get() {
        return this;
    }
}
