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

package com.sun.tools.internal.xjc.addon.sync;

import java.io.IOException;

import com.sun.codemodel.internal.JMethod;
import com.sun.tools.internal.xjc.BadCommandLineException;
import com.sun.tools.internal.xjc.Options;
import com.sun.tools.internal.xjc.Plugin;
import com.sun.tools.internal.xjc.outline.ClassOutline;
import com.sun.tools.internal.xjc.outline.Outline;

import org.xml.sax.ErrorHandler;

/**
 * Generates synchronized methods.
 *
 * @author
 *     Kohsuke Kawaguchi (kohsuke.kawaguchi@sun.com)
 */
public class SynchronizedMethodAddOn extends Plugin {

    public String getOptionName() {
        return "Xsync-methods";
    }

    public String getUsage() {
        return "  -Xsync-methods     :  generate accessor methods with the 'synchronized' keyword";
    }

    public int parseArgument(Options opt, String[] args, int i) throws BadCommandLineException, IOException {
        return 0;   // no option recognized
    }

    public boolean run( Outline model, Options opt, ErrorHandler errorHandler ) {

        for( ClassOutline co : model.getClasses() )
            augument(co);

        return true;
    }

    /**
     * Adds "synchoronized" to all the methods.
     */
    private void augument(ClassOutline co) {
        for (JMethod m : co.implClass.methods())
            m.getMods().setSynchronized(true);
    }

}
