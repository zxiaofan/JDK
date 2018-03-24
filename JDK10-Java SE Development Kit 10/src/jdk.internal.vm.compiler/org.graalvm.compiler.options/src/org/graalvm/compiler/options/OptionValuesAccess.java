/*
 * Copyright (c) 2017, Oracle and/or its affiliates. All rights reserved.
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
 */
package org.graalvm.compiler.options;

/**
 * Defines a service that supplies values for options. The values supplied may come from a source
 * such as system properties or a command line.
 *
 * This mechanism for obtaining option values must only be used if there is no other more local
 * context from which option values can be obtained.
 */
public interface OptionValuesAccess {

    /**
     * Gets the option values available via this service.
     */
    OptionValues getOptions();
}
