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
 * Specifies standard timing measurements.
 */
public interface TimeStatistic extends Statistic {
    /**
     * Number of times the operation was invoked since the beginning of this measurement.
     */
    long getCount();

    /**
     * The maximum amount of time taken to complete one invocation of this operation since the beginning of this measurement.
     */
    long getMaxTime();

    /**
     * The minimum amount of time taken to complete one invocation of this operation since the beginning of this measurement.
     */
    long getMinTime();

    /**
     * This is the sum total of time taken to complete every invocation of this operation since the beginning of this measurement. Dividing totalTime by count will give you the average execution time for this operation.
     */
    long getTotalTime();
}
