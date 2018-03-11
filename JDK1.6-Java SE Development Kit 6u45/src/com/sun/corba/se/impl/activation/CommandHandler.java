/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.sun.corba.se.impl.activation;

import org.omg.CORBA.ORB;

import java.io.PrintStream;

/**
 * @version     %I%, %D%
 * @author      Rohit Garg
 * @since       JDK1.2
 */

public interface CommandHandler
{
    String getCommandName();

    public final static boolean shortHelp = true;
    public final static boolean longHelp  = false;

    void printCommandHelp(PrintStream out, boolean helpType);

    public final static boolean parseError = true;
    public final static boolean commandDone = false;

    boolean processCommand(String[] cmd, ORB orb, PrintStream out);
}
