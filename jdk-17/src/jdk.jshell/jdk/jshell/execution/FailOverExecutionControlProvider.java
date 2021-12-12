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

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdk.jshell.spi.ExecutionControl;
import jdk.jshell.spi.ExecutionControlProvider;
import jdk.jshell.spi.ExecutionEnv;

/**
 * Tries other providers in sequence until one works.
 *
 * @since 9
 */
public class FailOverExecutionControlProvider  implements ExecutionControlProvider{

    private Logger logger = null;

    /**
     * Create an instance. The instance can be used to start and return an
     * {@link ExecutionControl} instance by attempting to start a series of
     * {@code ExecutionControl} specs, until one is successful.
     *
     * @see #generate(jdk.jshell.spi.ExecutionEnv, java.util.Map)
     */
    public FailOverExecutionControlProvider() {
    }

    /**
     * The unique name of this {@code ExecutionControlProvider}.
     *
     * @return "failover"
     */
    @Override
    public String name() {
        return "failover";
    }

    /**
     * Create and return the default parameter map for this
     * {@code ExecutionControlProvider}. There are ten parameters, "0" through
     * "9", their values are {@code ExecutionControlProvider} specification
     * strings, or empty string.
     *
     * @return a default parameter map
     */
    @Override
    public Map<String, String> defaultParameters() {
        Map<String, String> dp = new HashMap<>();
        dp.put("0", "jdi");
        for (int i = 1; i <= 9; ++i) {
            dp.put("" + i, "");
        }
        return dp;
    }

    /**
     * Create and return a locally executing {@code ExecutionControl} instance.
     * At least one parameter should have a spec.
     *
     * @param env the execution environment, provided by JShell
     * @param parameters the modified parameter map.
     * @return the execution engine
     * @throws Throwable if all the given providers fail, the exception that
     * occurred on the first attempt to create the execution engine.
     */
    @Override
    public ExecutionControl generate(ExecutionEnv env, Map<String, String> parameters)
            throws Throwable {
        Throwable thrown = null;
        StringWriter dumpsw = new StringWriter();
        PrintWriter dump = new PrintWriter(dumpsw);
        for (int i = 0; i <= 9; ++i) {
            String param = parameters.get("" + i);
            if (param != null && !param.isEmpty()) {
                try {
                    ExecutionControl ec =  ExecutionControl.generate(env, param);
                    logger().finest(
                            String.format("FailOverExecutionControlProvider: Success %s -- %d = %s\n",
                                    name(), i, param));
                    return ec;
                } catch (Throwable ex) {
                    logger().warning(
                            String.format("FailOverExecutionControlProvider: Failure %s -- %d = %s -- %s\n",
                                    name(), i, param, ex.toString()));
                    StringWriter writer = new StringWriter();
                    PrintWriter log = new PrintWriter(writer);
                    log.println("FailOverExecutionControlProvider:");
                    ex.printStackTrace(log);
                    log.flush();
                    logger().fine(writer.toString());
                    // if they all fail, use the last as cause and include info about prior in message
                    dump.printf("FailOverExecutionControlProvider: FAILED: %d:%s --%n", i, param);
                    dump.printf("  Exception: %s%n", ex);
                    var st = ex.getStackTrace();
                    for (int k = 0; k < 5 && k < st.length; ++k) {
                        dump.printf("                  %s%n", st[k]);
                    }
                    if (ex.getCause() != null) {
                        dump.printf("      cause: %s%n", ex.getCause());
                    }
                    thrown = ex;
                }
            }

        }
        logger().severe("FailOverExecutionControlProvider: Terminating, failovers exhausted");
        if (thrown == null) {
            throw new IllegalArgumentException("All least one parameter must be set to a provider.");
        }
        throw new RuntimeException(dumpsw.toString(), thrown);
    }

    private Logger logger() {
        if (logger == null) {
            logger = Logger.getLogger("jdk.jshell.execution");
            if (logger.getLevel() == null) {
                // Logging has not been specifically requested, turn it off
                logger.setLevel(Level.OFF);
            }
        }
        return logger;
    }

}
