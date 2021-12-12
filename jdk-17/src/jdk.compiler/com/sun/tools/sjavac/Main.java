/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac;

import static com.sun.tools.sjavac.options.Option.STARTSERVER;

import java.util.Arrays;

import com.sun.tools.sjavac.client.ClientMain;
import com.sun.tools.sjavac.server.ServerMain;

/**
 * The application entry point of the smart javac wrapper tool.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class Main {

    public static void main(String... args)  {
        System.exit(go(args));
    }

    public static int go(String[] args) {

        // Server or client mode?
        boolean serverMode = Arrays.asList(args)
                                   .stream()
                                   .anyMatch(arg -> arg.startsWith(STARTSERVER.arg));

        return serverMode ? ServerMain.run(args) : ClientMain.run(args);
    }
}
