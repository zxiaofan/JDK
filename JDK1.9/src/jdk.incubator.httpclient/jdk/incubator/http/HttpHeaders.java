/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;

/**
 * A read-only view of a set of HTTP headers.
 * {@Incubating}
 *
 * @since 9
 */
public interface HttpHeaders {

    /**
     * Returns an {@link java.util.Optional} containing the first value of the
     * given named (and possibly multi-valued) header. If the header is not
     * present, then the returned {@code Optional} is empty.
     *
     * @param name the header name
     * @return an {@code Optional<String>} for the first named value
     */
    public Optional<String> firstValue(String name);

    /**
     * Returns an {@link java.util.OptionalLong} containing the first value of the
     * named header field. If the header is not
     * present, then the Optional is empty. If the header is present but
     * contains a value that does not parse as a {@code Long} value, then an
     * exception is thrown.
     *
     * @param name the header name
     * @return  an {@code OptionalLong}
     * @throws NumberFormatException if a value is found, but does not parse as
     *                               a Long
     */
    public OptionalLong firstValueAsLong(String name);

    /**
     * Returns an unmodifiable List of all of the values of the given named
     * header. Always returns a List, which may be empty if the header is not
     * present.
     *
     * @param name the header name
     * @return a List of String values
     */
    public List<String> allValues(String name);

    /**
     * Returns an unmodifiable multi Map view of this HttpHeaders. This
     * interface should only be used when it is required to iterate over the
     * entire set of headers.
     *
     * @return the Map
     */
    public Map<String,List<String>> map();
}
