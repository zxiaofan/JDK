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

package com.sun.tools.internal.xjc.model;

import javax.xml.namespace.QName;

import com.sun.codemodel.internal.JType;
import com.sun.tools.internal.xjc.outline.Aspect;
import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import com.sun.tools.internal.xjc.model.nav.NClass;
import com.sun.tools.internal.xjc.model.nav.NType;
import com.sun.tools.internal.xjc.outline.Outline;
import com.sun.xml.internal.bind.v2.model.core.ArrayInfo;
import com.sun.xml.internal.xsom.XSComponent;

import org.xml.sax.Locator;

/**
 * Because XJC doesn't generate the array binding, this class will
 * never show up in the model constructed by XJC.
 *
 * <p>
 * This class is nevertheless defined to make the type checker happy.
 *
 * @author Kohsuke Kawaguchi
 */
public final class CArrayInfo extends AbstractCTypeInfoImpl implements ArrayInfo<NType,NClass>, CNonElement, NType {

    private final CNonElement itemType;

    private final QName typeName;

    public CArrayInfo(Model model,CNonElement itemType, XSComponent source, CCustomizations customizations) {
        super(model,source,customizations);
        this.itemType = itemType;
        assert itemType.getTypeName()!=null;
        this.typeName = ArrayInfoUtil.calcArrayTypeName(itemType.getTypeName());
    }

    public CNonElement getItemType() {
        return itemType;
    }

    public QName getTypeName() {
        return typeName;
    }

    public boolean isSimpleType() {
        return false;
    }

    @Deprecated // guaranteed to return this
    public CNonElement getInfo() {
        return this;
    }

    public JType toType(Outline o, Aspect aspect) {
        return itemType.toType(o,aspect).array();
    }

    public NType getType() {
        return this;
    }

    public boolean isBoxedType() {
        return false;
    }

    public String fullName() {
        return itemType.getType().fullName()+"[]";
    }

    public Locator getLocator() {
        return Model.EMPTY_LOCATOR;
    }
}
