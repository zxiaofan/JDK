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

package jdk.jshell.execution;

import java.util.Map;
import jdk.jshell.spi.ExecutionControl;
import jdk.jshell.spi.ExecutionControlProvider;
import jdk.jshell.spi.ExecutionEnv;

/**
 * A provider of execution engines which run in the same process as JShell.
 *
 * @author Robert Field
 * @since 9
 */
public class LocalExecutionControlProvider implements ExecutionControlProvider{

    /**
     * Create an instance.  An instance can be used to
     * {@linkplain  #generate generate} an {@link ExecutionControl} instance
     * that executes code in the same process.
     */
    public LocalExecutionControlProvider() {
    }

    /**
     * The unique name of this {@code ExecutionControlProvider}.
     *
     * @return "local"
     */
    @Override
    public String name() {
        return "local";
    }

    /**
     * Create and return the default parameter map for
     * {@code LocalExecutionControlProvider}.
     * {@code LocalExecutionControlProvider} has no parameters.
     *
     * @return an empty parameter map
     */
    @Override
    public Map<String,String> defaultParameters() {
        return ExecutionControlProvider.super.defaultParameters();
    }

    /**
     * Create and return a locally executing {@code ExecutionControl} instance.
     *
     * @param env the execution environment, provided by JShell
     * @param parameters the {@linkplain #defaultParameters()  default} or
     * modified parameter map.
     * @return the execution engine
     */
    @Override
    public ExecutionControl generate(ExecutionEnv env, Map<String, String> parameters) {
        return new LocalExecutionControl();
    }

}
