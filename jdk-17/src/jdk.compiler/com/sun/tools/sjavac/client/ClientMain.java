/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.client;

import java.io.OutputStreamWriter;
import java.io.Writer;

import com.sun.tools.javac.main.Main;
import com.sun.tools.javac.main.Main.Result;
import com.sun.tools.sjavac.AutoFlushWriter;
import com.sun.tools.sjavac.Log;
import com.sun.tools.sjavac.Util;
import com.sun.tools.sjavac.comp.SjavacImpl;
import com.sun.tools.sjavac.options.Options;
import com.sun.tools.sjavac.server.Sjavac;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ClientMain {

    public static int run(String[] args) {
        return run(args,
                   new AutoFlushWriter(new OutputStreamWriter(System.out)),
                   new AutoFlushWriter(new OutputStreamWriter(System.err)));
    }

    public static int run(String[] args, Writer out, Writer err) {

        Log.setLogForCurrentThread(new Log(out, err));

        Options options;
        try {
            options = Options.parseArgs(args);
        } catch (IllegalArgumentException e) {
            Log.error(e.getMessage());
            return Result.CMDERR.exitCode;
        }

        Log.setLogLevel(options.getLogLevel());

        Log.debug("==========================================================");
        Log.debug("Launching sjavac client with the following parameters:");
        Log.debug("    " + options.getStateArgsString());
        Log.debug("==========================================================");

        // Prepare sjavac object
        boolean useServer = options.getServerConf() != null;
        Sjavac sjavac = useServer ? new SjavacClient(options) : new SjavacImpl();

        // Perform compilation
        Result result = sjavac.compile(args);

        // If sjavac is running in the foreground we should shut it down at this point
        if (!useServer) {
            sjavac.shutdown();
        }

        return result.exitCode;
    }
}
