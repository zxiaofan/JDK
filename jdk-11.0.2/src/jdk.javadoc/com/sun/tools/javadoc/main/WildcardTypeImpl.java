/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javadoc.main;

import com.sun.javadoc.*;

import com.sun.tools.javac.code.Symbol.ClassSymbol;
import com.sun.tools.javac.code.Type;
import com.sun.tools.javac.util.List;


/**
 * Implementation of <code>WildcardType</code>, which
 * represents a wildcard type.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 *
 * @author Scott Seligman
 * @since 1.5
 */
@Deprecated(since="9", forRemoval=true)
@SuppressWarnings("removal")
public class WildcardTypeImpl extends AbstractTypeImpl implements WildcardType {

    WildcardTypeImpl(DocEnv env, Type.WildcardType type) {
        super(env, type);
    }

    /**
     * Return the upper bounds of this wildcard type argument
     * as given by the <i>extends</i> clause.
     * Return an empty array if no such bounds are explicitly given.
     */
    public com.sun.javadoc.Type[] extendsBounds() {
        return TypeMaker.getTypes(env, getExtendsBounds((Type.WildcardType)type));
    }

    /**
     * Return the lower bounds of this wildcard type argument
     * as given by the <i>super</i> clause.
     * Return an empty array if no such bounds are explicitly given.
     */
    public com.sun.javadoc.Type[] superBounds() {
        return TypeMaker.getTypes(env, getSuperBounds((Type.WildcardType)type));
    }

    /**
     * Return the ClassDoc of the erasure of this wildcard type.
     */
    @Override
    public ClassDoc asClassDoc() {
        return env.getClassDoc((ClassSymbol)env.types.erasure(type).tsym);
    }

    @Override
    public WildcardType asWildcardType() {
        return this;
    }

    @Override
    public String typeName()            { return "?"; }
    @Override
    public String qualifiedTypeName()   { return "?"; }
    @Override
    public String simpleTypeName()      { return "?"; }

    @Override
    public String toString() {
        return wildcardTypeToString(env, (Type.WildcardType)type, true);
    }


    /**
     * Return the string form of a wildcard type ("?") along with any
     * "extends" or "super" clause.  Delimiting brackets are not
     * included.  Class names are qualified if "full" is true.
     */
    static String wildcardTypeToString(DocEnv env,
                                       Type.WildcardType wildThing, boolean full) {
        if (env.legacyDoclet) {
            return TypeMaker.getTypeName(env.types.erasure(wildThing), full);
        }
        StringBuilder s = new StringBuilder("?");
        List<Type> bounds = getExtendsBounds(wildThing);
        if (bounds.nonEmpty()) {
            s.append(" extends ");
        } else {
            bounds = getSuperBounds(wildThing);
            if (bounds.nonEmpty()) {
                s.append(" super ");
            }
        }
        boolean first = true;   // currently only one bound is allowed
        for (Type b : bounds) {
            if (!first) {
                s.append(" & ");
            }
            s.append(TypeMaker.getTypeString(env, b, full));
            first = false;
        }
        return s.toString();
    }

    private static List<Type> getExtendsBounds(Type.WildcardType wild) {
        return wild.isSuperBound()
                ? List.nil()
                : List.of(wild.type);
    }

    private static List<Type> getSuperBounds(Type.WildcardType wild) {
        return wild.isExtendsBound()
                ? List.nil()
                : List.of(wild.type);
    }
}
