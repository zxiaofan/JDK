/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.comp;

import java.util.Collection;
import java.util.HashMap;
import com.sun.tools.javac.code.Symbol.TypeSymbol;
import com.sun.tools.javac.util.Context;

/** This class contains the type environments used by Enter, MemberEnter,
 *  Attr, DeferredAttr, and Lower.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
class TypeEnvs {
    private static final long serialVersionUID = 571524752489954631L;

    protected static final Context.Key<TypeEnvs> typeEnvsKey = new Context.Key<>();
    public static TypeEnvs instance(Context context) {
        TypeEnvs instance = context.get(typeEnvsKey);
        if (instance == null)
            instance = new TypeEnvs(context);
        return instance;
    }

    private HashMap<TypeSymbol,Env<AttrContext>> map;
    protected TypeEnvs(Context context) {
        map = new HashMap<>();
        context.put(typeEnvsKey, this);
    }

    Env<AttrContext> get(TypeSymbol sym) { return map.get(sym); }
    Env<AttrContext> put(TypeSymbol sym, Env<AttrContext> env) { return map.put(sym, env); }
    Env<AttrContext> remove(TypeSymbol sym) { return map.remove(sym); }
    Collection<Env<AttrContext>> values() { return map.values(); }
    void clear() { map.clear(); }
}
