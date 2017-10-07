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

package com.sun.tools.internal.xjc.reader.xmlschema;

import java.util.Iterator;

import com.sun.xml.internal.xsom.XSWildcard;
import com.sun.xml.internal.xsom.visitor.XSWildcardFunction;

import com.sun.xml.internal.rngom.nc.AnyNameExceptNameClass;
import com.sun.xml.internal.rngom.nc.ChoiceNameClass;
import com.sun.xml.internal.rngom.nc.NameClass;
import com.sun.xml.internal.rngom.nc.NsNameClass;

/**
 * Builds a name class representation of a wildcard.
 *
 * <p>
 * Singleton. Use the build method to create a NameClass.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public final class WildcardNameClassBuilder implements XSWildcardFunction<NameClass> {
    private WildcardNameClassBuilder() {}

    private static final XSWildcardFunction<NameClass> theInstance =
        new WildcardNameClassBuilder();

    public static NameClass build( XSWildcard wc ) {
        return wc.apply(theInstance);
    }

    public NameClass any(XSWildcard.Any wc) {
        return NameClass.ANY;
    }

    public NameClass other(XSWildcard.Other wc) {
        return new AnyNameExceptNameClass(
            new ChoiceNameClass(
                new NsNameClass(""),
                new NsNameClass(wc.getOtherNamespace())));
    }

    public NameClass union(XSWildcard.Union wc) {
        NameClass nc = null;
        for (Iterator itr = wc.iterateNamespaces(); itr.hasNext();) {
            String ns = (String) itr.next();

            if(nc==null)    nc = new NsNameClass(ns);
            else
                nc = new ChoiceNameClass(nc,new NsNameClass(ns));
        }

        // there should be at least one.
        assert nc!=null;

        return nc;
    }

}
