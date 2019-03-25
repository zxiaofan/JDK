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
 */


package org.graalvm.compiler.phases.tiers;

import org.graalvm.compiler.lir.phases.LIRSuites;
import org.graalvm.compiler.options.OptionValues;

/**
 * Interface used for composing {@link SuitesProvider}s.
 */
public interface SuitesCreator extends SuitesProvider {
    /**
     * Create a new set of phase suites based on {@code options}.
     */
    Suites createSuites(OptionValues options);

    /**
     * Create a new set of low-level phase suites based on {@code options}.
     */
    LIRSuites createLIRSuites(OptionValues options);
}
