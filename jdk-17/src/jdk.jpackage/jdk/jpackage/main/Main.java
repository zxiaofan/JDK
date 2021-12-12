/*
 * Copyright (c) 2011, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jpackage.main;

import jdk.jpackage.internal.Arguments;
import jdk.jpackage.internal.Log;
import jdk.jpackage.internal.CLIHelp;
import java.io.PrintWriter;
import java.util.ResourceBundle;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.MessageFormat;

public class Main {

    private static final ResourceBundle I18N = ResourceBundle.getBundle(
            "jdk.jpackage.internal.resources.MainResources");

    /**
     * main(String... args)
     * This is the entry point for the jpackage tool.
     *
     * @param args command line arguments
     */
    public static void main(String... args) throws Exception {

        PrintWriter out = new PrintWriter(System.out);
        PrintWriter err = new PrintWriter(System.err);
        int status = new jdk.jpackage.main.Main().execute(out, err, args);
        System.exit(status);
    }

    /**
     * execute() - this is the entry point for the ToolProvider API.
     *
     * @param out output stream
     * @param err error output stream
     * @param args command line arguments
     * @return an exit code. 0 means success, non-zero means an error occurred.
     */
    public int execute(PrintWriter out, PrintWriter err, String... args) {
        Log.setPrintWriter(out, err);

        try {
            String[] newArgs;
            try {
                newArgs = CommandLine.parse(args);
            } catch (FileNotFoundException fnfe) {
                Log.fatalError(MessageFormat.format(I18N.getString(
                        "ERR_CannotParseOptions"), fnfe.getMessage()));
                return 1;
            } catch (IOException ioe) {
                Log.fatalError(ioe.getMessage());
                return 1;
            }

            if (newArgs.length == 0) {
                CLIHelp.showHelp(true);
            } else if (hasHelp(newArgs)){
                if (hasVersion(newArgs)) {
                    Log.info(System.getProperty("java.version") + "\n");
                }
                CLIHelp.showHelp(false);
            } else if (hasVersion(newArgs)) {
                Log.info(System.getProperty("java.version"));
            } else {
                Arguments arguments = new Arguments(newArgs);
                if (!arguments.processArguments()) {
                    // processArguments() will log error message if failed.
                    return 1;
                }
            }
            return 0;
        } finally {
            Log.flush();
        }
    }

    private boolean hasHelp(String[] args) {
        for (String a : args) {
            if ("--help".equals(a) || "-h".equals(a)) {
                return true;
            }
        }
        return false;
    }

    private boolean hasVersion(String[] args) {
        for (String a : args) {
            if ("--version".equals(a)) {
                return true;
            }
        }
        return false;
    }

}
