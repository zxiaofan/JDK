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

package jdk.jfr.internal.tool;

import java.io.PrintStream;
import java.util.Deque;
import java.util.List;

final class Help extends Command {

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public List<String> getOptionSyntax() {
        return List.of("[<command>]");
    }

    @Override
    protected List<String> getAliases() {
        return List.of("--help", "-h", "-?");
    }

    @Override
    public void displayOptionUsage(PrintStream stream) {
        println("  <command>   The name of the command to get help for");
    }

    @Override
    public String getDescription() {
        return "Display all available commands, or help about a specific command";
    }

    @Override
    public void execute(Deque<String> options) throws UserSyntaxException, UserDataException {
        if (options.isEmpty()) {
            Command.displayHelp();
            return;
        }
        ensureMaxArgumentCount(options, 1);
        String commandName = options.remove();
        Command c = Command.valueOf(commandName);
        if (c == null) {
            throw new UserDataException("unknown command '" + commandName + "'");
        }
        println(c.getTitle());
        println();
        c.displayUsage(System.out);
    }
}
