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

import java.util.Deque;

final class HelpCommand extends Command {

    @Override
    public String getOptionSyntax() {
        return "[<command>]";
    }

    @Override
    public void displayOptionUsage() {
        println("  <command>   The name of the command to get help for");
        println();
        Command.displayAvailableCommands();
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Display help about a command";
    }

    @Override
    public void execute(Deque<String> options) {
        if (options.isEmpty()) {
            displayUsage();
        } else {
            ensureMaxArgumentCount(options, 1);
            String commandName = options.remove();
            Command c = Command.valueOf(commandName);
            if (c == null) {
                userFailed("Unknown command " + commandName);
            }
            c.displayUsage();
        }
    }
}
