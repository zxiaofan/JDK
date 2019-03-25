/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.jshell.tool;

import java.io.IOException;

/**
 * Interface for defining user interaction with the shell.
 * @author Robert Field
 */
abstract class IOContext implements AutoCloseable {

    @Override
    public abstract void close() throws IOException;

    public abstract String readLine(String prompt, String prefix) throws IOException, InputInterruptedException;

    public abstract boolean interactiveOutput();

    public abstract Iterable<String> history(boolean currentSession);

    public abstract  boolean terminalEditorRunning();

    public abstract void suspend();

    public abstract void resume();

    public abstract void beforeUserCode();

    public abstract void afterUserCode();

    public abstract void replaceLastHistoryEntry(String source);

    public abstract int readUserInput() throws IOException;

    class InputInterruptedException extends Exception {
        private static final long serialVersionUID = 1L;
    }
}

