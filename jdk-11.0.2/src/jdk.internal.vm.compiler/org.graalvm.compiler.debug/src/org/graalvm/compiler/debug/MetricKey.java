/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

import java.util.Comparator;

import jdk.internal.vm.compiler.collections.Pair;

/**
 * A key for a metric.
 */
public interface MetricKey {

    /**
     * Converts a given value for this key to a string, scaling it to a more useful unit of
     * measurement and appending a suffix indicating the unit where applicable. This representation
     * is intended for human consumption.
     */
    String toHumanReadableFormat(long value);

    /**
     * Converts a given value for this key to a CSV format intended for automated data processing.
     *
     * @param value
     * @return a pair where first is the {@code value} with any scaling conversion applied and
     *         second is the unit of measurement used for the first component (this will be the
     *         empty string for a simple counter)
     */
    Pair<String, String> toCSVFormat(long value);

    /**
     * Gets the name of this key.
     */
    String getName();

    /**
     * Comparator to sort keys by their names.
     */
    Comparator<MetricKey> NAME_COMPARATOR = new Comparator<MetricKey>() {

        @Override
        public int compare(MetricKey o1, MetricKey o2) {
            return o1.getName().compareTo(o2.getName());
        }

    };

    /**
     * Sets the documentation for this key.
     */
    MetricKey doc(String string);

    /**
     * Gets the name to use when listing keys. Note that this may be different from
     * {@link #getName()}.
     *
     * @return {@code null} if this key is derived from another key and so should not be listed
     */
    String getDocName();

    /**
     * Gets the documentation for this key.
     *
     * @return {@code null} if this key has no documentation
     */
    String getDoc();
}
