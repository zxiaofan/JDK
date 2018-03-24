/*
 * Copyright (c) 2009, 2013, Oracle and/or its affiliates. All rights reserved.
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



package com.sun.org.glassfish.external.statistics;

/**
 * The Statistic model and its sub-models specify the data models which are requried to be used to provide the performance data described by the specific attributes in the Stats models.
 */
public interface Statistic {
    /**
     * The name of this Statistic.
     */
    String getName();

    /**
     * The unit of measurement for this Statistic.
     * Valid values for TimeStatistic measurements are "HOUR", "MINUTE", "SECOND", "MILLISECOND", "MICROSECOND" and "NANOSECOND".
     */
    String getUnit();

    /**
     * A human-readable description of the Statistic.
     */
    String getDescription();

    /**
     * The time of the first measurement represented as a long, whose value is the number of milliseconds since January 1, 1970, 00:00:00.
     */
    long getStartTime();

    /**
     * The time of the last measurement represented as a long, whose value is the number of milliseconds since January 1, 1970, 00:00:00.
     */
    long getLastSampleTime();
}
