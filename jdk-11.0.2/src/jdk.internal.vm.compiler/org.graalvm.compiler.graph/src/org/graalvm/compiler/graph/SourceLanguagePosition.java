/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.graph;

import java.net.URI;

/**
 * Provides a path to report information about a high level language source position to the Graph
 * Visualizer.
 */
public interface SourceLanguagePosition {

    /**
     * Produce a compact description of this position suitable for printing.
     */
    String toShortString();

    /** Mimics GraphLocations operation. */
    int getOffsetEnd();

    /** Mimics GraphLocations operation. */
    int getOffsetStart();

    /** Mimics GraphLocations operation. */
    int getLineNumber();

    /** Mimics GraphLocations operation. */
    URI getURI();

    /** Mimics GraphLocations operation. */
    String getLanguage();
}
