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

package com.sun.xml.internal.xsom.visitor;

import com.sun.xml.internal.xsom.XSWildcard;
import com.sun.xml.internal.xsom.XSModelGroupDecl;
import com.sun.xml.internal.xsom.XSModelGroup;
import com.sun.xml.internal.xsom.XSElementDecl;
import com.sun.xml.internal.xsom.XSTerm;

/**
 * Function object that works on {@link XSTerm}.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public interface XSTermFunctionWithParam<T,P> {
    T wildcard( XSWildcard wc, P param );
    T modelGroupDecl( XSModelGroupDecl decl, P param );
    T modelGroup( XSModelGroup group, P param );
    T elementDecl( XSElementDecl decl, P param );
}
