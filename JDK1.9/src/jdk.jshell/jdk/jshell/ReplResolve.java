/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jshell;

import com.sun.tools.javac.comp.AttrContext;
import com.sun.tools.javac.comp.Env;
import com.sun.tools.javac.comp.Resolve;
import com.sun.tools.javac.util.Context;

/**
 * Just need access to isStatic
 */
class ReplResolve extends Resolve {

    ReplResolve(Context context) {
        super(context);
    }

    public static boolean isStatic(Env<AttrContext> env) {
        return Resolve.isStatic(env);
    }
}
