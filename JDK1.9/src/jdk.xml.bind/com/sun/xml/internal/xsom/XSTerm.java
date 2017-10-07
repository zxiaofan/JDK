/*
 * Copyright (c) 1997, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.xml.internal.xsom;

import com.sun.xml.internal.xsom.visitor.XSTermFunction;
import com.sun.xml.internal.xsom.visitor.XSTermVisitor;
import com.sun.xml.internal.xsom.visitor.XSTermFunctionWithParam;

/**
 * A component that can be referenced from {@link XSParticle}
 *
 * This interface provides a set of type check functions (<code>isXXX</code>),
 * which are essentially:
 *
 * <pre>
 * boolean isXXX() {
 *     return this instanceof XXX;
 * }
 * </pre>
 *
 * and a set of cast functions (<code>asXXX</code>), which are
 * essentially:
 *
 * <pre>
 * XXX asXXX() {
 *     if(isXXX())  return (XXX)this;
 *     else          return null;
 * }
 * </pre>
 */
public interface XSTerm extends XSComponent
{
    void visit( XSTermVisitor visitor );
    <T> T apply( XSTermFunction<T> function );
    <T,P> T apply( XSTermFunctionWithParam<T,P> function, P param );

    // cast functions
    boolean isWildcard();
    boolean isModelGroupDecl();
    boolean isModelGroup();
    boolean isElementDecl();

    XSWildcard asWildcard();
    XSModelGroupDecl asModelGroupDecl();
    XSModelGroup asModelGroup();
    XSElementDecl asElementDecl();
}
