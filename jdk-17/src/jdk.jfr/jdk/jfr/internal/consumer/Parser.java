/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.consumer;

import java.io.IOException;

/**
 * Base class for parsing data from a {@link RecordingInput}.
 */
abstract class Parser {
    /**
     * Parses data from a {@link RecordingInput} and return an object.
     *
     * @param input input to read from
     * @return an object
     * @throws IOException if operation couldn't be completed due to I/O
     *         problems
     */
    public abstract Object parse(RecordingInput input) throws IOException;

    /**
     * Skips data that would usually be by parsed the {@link #parse(RecordingInput)} method.
     *
     * @param input input to read from
     * @throws IOException if operation couldn't be completed due to I/O
     *         problems
     */
    public abstract void skip(RecordingInput input) throws IOException;
}
