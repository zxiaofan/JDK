/*
 * Copyright (c) 2016, 2021, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Launcher class for the JDK_HOME\bin\jfr tool
 *
 */
public final class Main {

    private static final int EXIT_OK = 0;
    private static final int EXIT_FAILED = 1;
    private static final int EXIT_WRONG_ARGUMENTS = 2;

    public static void main(String... args) {
        Deque<String> argList = new LinkedList<>(Arrays.asList(args));
        if (argList.isEmpty()) {
            System.out.println(Command.title);
            System.out.println();
            System.out.println("Before using this tool, you must have a recording file.");
            System.out.println("A file can be created by starting a recording from command line:");
            System.out.println();
            System.out.println(" java -XX:StartFlightRecording:filename=recording.jfr,duration=30s ... ");
            System.out.println();
            System.out.println("A recording can also be started on already running Java Virtual Machine:");
            System.out.println();
            System.out.println(" jcmd (to list available pids)");
            System.out.println(" jcmd <pid> JFR.start");
            System.out.println();
            System.out.println("Recording data can be dumped to file using the JFR.dump command:");
            System.out.println();
            System.out.println(" jcmd <pid> JFR.dump filename=recording.jfr");
            System.out.println();
            System.out.println("The contents of the recording can then be printed, for example:");
            System.out.println();
            System.out.println(" jfr print recording.jfr");
            System.out.println();
            System.out.println(" jfr print --events CPULoad,GarbageCollection recording.jfr");
            System.out.println();
            System.out.println(" jfr print --json --events CPULoad recording.jfr");
            System.out.println();
            char q = Print.quoteCharacter();
            System.out.println(" jfr print --categories " + q + "GC,JVM,Java*" + q + " recording.jfr");
            System.out.println();
            System.out.println(" jfr print --events " + q + "jdk.*" + q + " --stack-depth 64 recording.jfr");
            System.out.println();
            System.out.println(" jfr summary recording.jfr");
            System.out.println();
            System.out.println(" jfr metadata recording.jfr");
            System.out.println();
            System.out.println(" jfr metadata --categories GC,Detailed");
            System.out.println();
            System.out.println("For more information about available commands, use 'jfr help'");
            System.exit(EXIT_OK);
        }
        String command = argList.remove();
        for (Command c : Command.getCommands()) {
            if (c.matches(command)) {
                try {
                    c.execute(argList);
                    System.exit(EXIT_OK);
                } catch (UserDataException ude) {
                    System.err.println("jfr " + c.getName() + ": " + ude.getMessage());
                    System.exit(EXIT_FAILED);
                } catch (UserSyntaxException use) {
                    System.err.println("jfr " + c.getName() + ": " + use.getMessage());
                    System.err.println();
                    System.err.println("Usage:");
                    System.err.println();
                    c.displayUsage(System.err);
                    System.exit(EXIT_WRONG_ARGUMENTS);
                } catch (Throwable e) {
                    System.err.println("jfr " + c.getName() + ": unexpected internal error, " + e.getMessage());
                    e.printStackTrace();
                    System.exit(EXIT_FAILED);
                }
            }
        }
        System.err.println("jfr: unknown command '" + command + "'");
        System.err.println();
        System.err.println("List of available commands:");
        System.err.println();
        Command.displayAvailableCommands(System.err);
        System.exit(EXIT_WRONG_ARGUMENTS);
    }
}
