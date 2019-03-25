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

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

abstract class Command {

    private final static Command HELP = new HelpCommand();
    private final static List<Command> COMMANDS = createCommands();

    static void displayHelp() {
        System.out.println("Usage: java " + Execute.class.getName() + " <command> [<options>]");
        System.out.println();
        displayAvailableCommands();
    }

    static void displayAvailableCommands() {
        System.out.println("Available commands are:");
        System.out.println();
        boolean first = true;
        for (Command c : Command.COMMANDS) {
            if (!first) {
                System.out.println();
            }
            System.out.println("  " + c.getName() + " " + c.getOptionSyntax());
            System.out.println("    " + c.getDescription());
            first = false;
        }
    }

    public static List<Command> getCommands() {
        return COMMANDS;
    }

    public static Command valueOf(String commandName) {
        for (Command command : COMMANDS) {
            if (command.getName().equals(commandName)) {
                return command;
            }
        }
        return null;
    }

    abstract public String getOptionSyntax();

    abstract public String getName();

    abstract public String getDescription();

    abstract public void displayOptionUsage();

    abstract public void execute(Deque<String> options);

    final protected void userFailed(String message) {
        println();
        println(message);
        displayUsage();
        throw new IllegalArgumentException(message);
    }

    final protected void ensureMaxArgumentCount(Deque<String> options, int maxCount) {
        if (options.size() > maxCount) {
            userFailed("Too many arguments");
        }
    }

    final protected void ensureMinArgumentCount(Deque<String> options, int minCount) {
        if (options.size() < minCount) {
            userFailed("Too few arguments");
        }
    }

    final protected void ensureFileExist(Path file) {
        if (!Files.exists(file)) {
            userFailed("Could not find file " + file);
        }
    }

    final protected Path ensureFileDoesNotExist(Path file) {
        if (Files.exists(file)) {
            userFailed("File " + file + " already exists");
        }
        return file;
    }

    final protected void ensureJFRFile(Path path) {
        if (!path.toString().endsWith(".jfr")) {
            userFailed("Filename must end with .jfr");
        }
    }

    final protected void displayUsage() {
        String javaText = "java " + Execute.class.getName();
        println();
        println("Usage: " + javaText + " " + getName() + " " + getOptionSyntax());
        println();
        displayOptionUsage();
    }

    final protected void println() {
        System.out.println();
    }

    final protected void print(String text) {
        System.out.print(text);
    }

    final protected void println(String text) {
        System.out.println(text);
    }

    private static List<Command> createCommands() {
        List<Command> commands = new ArrayList<>();
        commands.add(new PrintCommand());
        commands.add(new SummaryCommand());
        commands.add(new ReconstructCommand());
        commands.add(new SplitCommand());
        commands.add(HELP);
        return Collections.unmodifiableList(commands);
    }
}
