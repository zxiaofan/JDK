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

package com.sun.tools.sjavac.server;

import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.Thread.UncaughtExceptionHandler;

import com.sun.tools.javac.main.Main;
import com.sun.tools.javac.main.Main.Result;
import com.sun.tools.sjavac.Log;
import com.sun.tools.sjavac.Log.Level;
import com.sun.tools.sjavac.server.log.LazyInitFileLog;
import com.sun.tools.sjavac.server.log.LoggingOutputStream;

import static com.sun.tools.sjavac.Log.Level.ERROR;
import static com.sun.tools.sjavac.Log.Level.INFO;

/**
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class ServerMain {

    // For logging server internal (non request specific) errors.
    private static LazyInitFileLog errorLog;

    public static int run(String[] args) {

        // Under normal operation, all logging messages generated server-side
        // are due to compilation requests. These logging messages should
        // be relayed back to the requesting client rather than written to the
        // server log. The only messages that should be written to the server
        // log (in production mode) should be errors,
        Log.setLogForCurrentThread(errorLog = new LazyInitFileLog("server.log"));
        Log.setLogLevel(ERROR); // should be set to ERROR.

        // Make sure no exceptions go under the radar
        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            Log.setLogForCurrentThread(errorLog);
            Log.error(e);
        });

        // Inevitably someone will try to print messages using System.{out,err}.
        // Make sure this output also ends up in the log.
        System.setOut(new PrintStream(new LoggingOutputStream(System.out, INFO, "[stdout] ")));
        System.setErr(new PrintStream(new LoggingOutputStream(System.err, ERROR, "[stderr] ")));

        // Any options other than --startserver?
        if (args.length > 1) {
            Log.error("When spawning a background server, only a single --startserver argument is allowed.");
            return Result.CMDERR.exitCode;
        }

        int exitCode;
        try {
            SjavacServer server = new SjavacServer(args[0]);
            exitCode = server.startServer();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
            exitCode = Result.ERROR.exitCode;
        }

        return exitCode;
    }

    public static LazyInitFileLog getErrorLog() {
        return errorLog;
    }
}
