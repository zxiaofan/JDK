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

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Launcher class for JFR tools
 *
 */
public final class Execute {

    public static void main(String... args) {
        Deque<String> argList = new LinkedList<>(Arrays.asList(args));
        if (argList.isEmpty()) {
            System.out.println();
            Command.displayHelp();
            return;
        }
        String command = argList.remove();
        for (Command c : Command.getCommands()) {
            if (c.getName().equals(command)) {
                try {
                    c.execute(argList);
                } catch (IllegalArgumentException iae) {
                    return; // already handled by command
                } catch (Throwable e) {
                    System.out.println();
                    System.out.println(e.getMessage());
                    System.out.println();
                }
                return;
            }
        }
        System.out.println();
        System.out.println("Unknown command " + command + ".");
        System.out.println();
        Command.displayHelp();
    }
}
