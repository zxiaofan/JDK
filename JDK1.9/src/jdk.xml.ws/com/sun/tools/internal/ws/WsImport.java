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

package com.sun.tools.internal.ws;

import com.sun.tools.internal.ws.wscompile.WsimportTool;

/**
 * WsImport tool entry point.
 *
 * @author Vivek Pandey
 * @author Kohsuke Kawaguchi
 */
public class WsImport {
    /**
     * CLI entry point. Use {@link Invoker} to load proper API version
     */
    public static void main(String[] args) throws Throwable {
        System.exit(Invoker.invoke("com.sun.tools.internal.ws.wscompile.WsimportTool", args));
    }

    /**
     * Entry point for tool integration.
     *
     * <p>
     * This does the same as {@link #main(String[])} except
     * it doesn't invoke {@link System#exit(int)}. This method
     * also doesn't play with classloaders. It's the caller's
     * responsibility to set up the classloader to load all jars
     * needed to run the tool.
     *
     * @return
     *      0 if the tool runs successfully.
     */
    public static int doMain(String[] args) throws Throwable {
        return new WsimportTool(System.out).run(args) ? 0 : 1;
    }
}
