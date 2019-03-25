/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.cmd;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Deque;

final class PrintCommand extends Command {
    @Override
    public String getName() {
        return "print";
    }

    @Override
    public String getOptionSyntax() {
        return "[--xml|--json] <file>";
    }

    @Override
    public String getDescription() {
        return "Print contents of a recording file (.jfr)";
    }

    @Override
    public void displayOptionUsage() {
        println("  --xml    Print a recording in XML format");
        println();
        println("  --json   Print a recording in JSON format");
        println();
        println("  <file>   Location of the recording file (.jfr) to print");
    }

    @Override
    public void execute(Deque<String> options) {
        if (options.isEmpty()) {
            userFailed("Missing file");
        }
        ensureMaxArgumentCount(options, 2);

        Path file = Paths.get(options.removeLast());

        ensureFileExist(file);
        ensureJFRFile(file);
        ensureMaxArgumentCount(options, 1);

        String format = "--pretty";
        if (!options.isEmpty()) {
            format = options.remove();
        }
        try (PrintWriter pw = new PrintWriter(System.out)) {
            try {
                switch (format) {
                case "--pretty":
                    PrettyWriter prettyWriter = new PrettyWriter(pw);
                    prettyWriter.print(file);
                    break;
                case "--xml":
                    XMLWriter xmlPrinter = new XMLWriter(pw);
                    xmlPrinter.print(file);
                    break;
                case "--json":
                    JSONWriter jsonWriter = new JSONWriter(pw);
                    jsonWriter.print(file);
                    break;
                default:
                    userFailed("Unknown option " + format);
                    break;
                }
            } catch (IOException ioe) {
                userFailed("Could not read recording at " + file.toAbsolutePath() + ". " + ioe.getMessage());
            }
        }
    }
}
