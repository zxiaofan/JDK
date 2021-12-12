/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.javac.code;

import com.sun.source.util.ParameterNameProvider;
import com.sun.tools.javac.code.Symbol.ParamSymbol;
import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.Name;
import com.sun.tools.javac.util.Names;

/**
 * A Context class, that can return additional useful information for Symbols, currently
 * parameter names. It does so by calling user-supplied {@link ParameterNameProvider}.
 *
 * <p><b>This is NOT part of any supported API.
 * If you write code that depends on this, you do so at your own risk.
 * This code and its internal interfaces are subject to change or
 * deletion without notice.</b>
 */
public class MissingInfoHandler {
    protected static final Context.Key<MissingInfoHandler> missingInfoHandlerWrapperKey = new Context.Key<>();

    public static MissingInfoHandler instance(Context context) {
        MissingInfoHandler instance = context.get(missingInfoHandlerWrapperKey);
        if (instance == null)
            instance = new MissingInfoHandler(context);
        return instance;
    }

    private final Names names;
    private ParameterNameProvider parameterNameProvider;

    protected MissingInfoHandler(Context context) {
        context.put(missingInfoHandlerWrapperKey, this);
        names = Names.instance(context);
    }

    public Name getParameterName(ParamSymbol parameter) {
        if (parameterNameProvider != null) {
            CharSequence name = parameterNameProvider.getParameterName(parameter);
            if (name != null) {
                return names.fromString(name.toString());
            }
        }

        return null;
    }

    public void setDelegate(ParameterNameProvider delegate) {
        this.parameterNameProvider = delegate;
    }
}
