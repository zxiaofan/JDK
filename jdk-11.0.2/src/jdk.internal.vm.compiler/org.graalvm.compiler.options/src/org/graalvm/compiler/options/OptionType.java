/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Classifies Graal options in several categories depending on who this option is relevant for.
 *
 */
public enum OptionType {
    /**
     * An option common for users to apply.
     */
    User,

    /**
     * An option only relevant in corner cases and for fine-tuning.
     */
    Expert,

    /**
     * An option only relevant when debugging the compiler.
     */
    Debug
}
