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

import java.util.Collections;
import java.util.Map;

/**
 * The provider used by JShell to generate the execution engine needed to
 * evaluate Snippets.  Alternate execution engines can be created by
 * implementing this interface, then configuring JShell with the provider or
 * the providers name and parameter specifier.
 *
 * @author Robert Field
 * @since 9
 */
public interface ExecutionControlProvider {

    /**
     * The unique name of this {@code ExecutionControlProvider}.  The name must
     * be a sequence of characters from the Basic Multilingual Plane which are
     * {@link Character#isJavaIdentifierPart(char) }.
     *
     * @return the ExecutionControlProvider's name
     */
    String name();

    /**
     * Create and return the default parameter map for this
     * {@code ExecutionControlProvider}. The map can optionally be modified;
     * Modified or unmodified it can be passed to
     * {@link #generate(jdk.jshell.spi.ExecutionEnv, java.util.Map) }.
     *
     * @return the default parameter map
     */
    default Map<String,String> defaultParameters() {
        return Collections.emptyMap();
    }

    /**
     * Create and return the {@code ExecutionControl} instance.
     *
     * @param env the execution environment, provided by JShell
     * @param parameters the {@linkplain #defaultParameters() default} or
     * modified parameter map.
     * @return the execution engine
     * @throws Throwable an exception that occurred attempting to create the
     * execution engine.
     */
    ExecutionControl generate(ExecutionEnv env, Map<String,String> parameters)
            throws Throwable;
}
