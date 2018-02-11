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

import com.sun.xml.internal.xsom.XSAttGroupDecl;
import com.sun.xml.internal.xsom.XSAttributeDecl;
import com.sun.xml.internal.xsom.XSComplexType;
import com.sun.xml.internal.xsom.XSContentType;
import com.sun.xml.internal.xsom.XSElementDecl;
import com.sun.xml.internal.xsom.XSIdentityConstraint;
import com.sun.xml.internal.xsom.XSSimpleType;
import com.sun.xml.internal.xsom.XSTerm;
import com.sun.xml.internal.xsom.XSType;

/**
 * Reference to other schema components.
 *
 * <p>
 * There are mainly two different types of references. One is
 * the direct reference, which is only possible when schema components
 * are already available when references are made.
 * The other is the lazy reference, which keeps references by names
 * and later look for the component by name.
 *
 * <p>
 * This class defines interfaces that define the behavior of such
 * references and classes that implement direct reference semantics.
 *
 * @author Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public abstract class Ref {

    public static interface Term {
        /** Obtains a reference as a term. */
        XSTerm getTerm();
    }

    public static interface Type {
        /** Obtains a reference as a type. */
        XSType getType();
    }

    public static interface ContentType {
        XSContentType getContentType();
    }

    public static interface SimpleType extends Ref.Type {
        public XSSimpleType getType();
    }

    public static interface ComplexType extends Ref.Type {
        public XSComplexType getType();
    }

    public static interface Attribute {
        XSAttributeDecl getAttribute();
    }

    public static interface AttGroup {
        XSAttGroupDecl get();
    }

    public static interface Element extends Term {
        XSElementDecl get();
    }

    public static interface IdentityConstraint {
        XSIdentityConstraint get();
    }
//
//
//    private static void _assert( boolean b ) {
//        if(!b)
//            throw new InternalError("assertion failed");
//    }
}
