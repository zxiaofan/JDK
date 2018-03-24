/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.server.log;

import com.sun.tools.sjavac.Log;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class LazyInitFileLog extends Log {

    String baseFilename;
    Path destination = null;

    public LazyInitFileLog(String baseFilename) {
        super(null, null);
        this.baseFilename = baseFilename;
    }

    protected void printLogMsg(Level msgLevel, String msg) {
        try {
            // Lazily initialize out/err
            if (out == null && isLevelLogged(msgLevel)) {
                destination = getAvailableDestination();
                out = err = new PrintWriter(new FileWriter(destination.toFile()), true);
            }
            // Proceed to log the message
            super.printLogMsg(msgLevel, msg);
        } catch (IOException e) {
            // This could be bad. We might have run into an error and we can't
            // log it. Resort to printing on stdout.
            System.out.println("IO error occurred: " + e.getMessage());
            System.out.println("Original message: [" + msgLevel + "] " + msg);
        }
    }

    /**
     * @return The first available path of baseFilename, baseFilename.1,
     * basefilename.2, ...
     */
    private Path getAvailableDestination() {
        Path p = Paths.get(baseFilename);
        int i = 1;
        while (Files.exists(p)) {
            p = Paths.get(baseFilename + "." + i++);
        }
        return p;
    }

    public Path getLogDestination() {
        return destination;
    }
}
