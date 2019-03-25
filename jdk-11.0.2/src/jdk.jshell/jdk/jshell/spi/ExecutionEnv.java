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

package jdk.jshell.spi;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;

/**
 * Functionality made available to a pluggable JShell execution engine.  It is
 * provided to the execution engine by the core JShell implementation.
 * <p>
 * This interface is designed to provide the access to core JShell functionality
 * needed to implement ExecutionControl.
 *
 * @since 9
 * @see ExecutionControl
 */
public interface ExecutionEnv {

    /**
     * Returns the user's input stream.
     *
     * @return the user's input stream
     */
    InputStream userIn();

    /**
     * Returns the user's output stream.
     *
     * @return the user's output stream
     */
    PrintStream userOut();

    /**
     * Returns the user's error stream.
     *
     * @return the user's error stream
     */
    PrintStream userErr();

    /**
     * Returns the additional VM options to be used when launching the remote
     * JVM. This is advice to the execution engine.
     * <p>
     * Note: an execution engine need not launch a remote JVM.
     *
     * @return the additional options with which to launch the remote JVM
     */
    List<String> extraRemoteVMOptions();

    /**
     * Reports that the execution engine has shutdown.
     */
    void closeDown();

}
