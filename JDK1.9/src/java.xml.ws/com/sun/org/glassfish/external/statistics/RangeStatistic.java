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
 * Specifies standard measurements of the lowest and highest values an attribute has held as well as its current value.
 */
public interface RangeStatistic extends Statistic {
    /**
     * The highest value this attribute has held since the beginninYg of the measurement.
     */
    long getHighWaterMark();

    /**
     * The lowest value this attribute has held since the beginning of the measurement.
     */
    long getLowWaterMark();

    /**
     * The current value of this attribute.
     */
    long getCurrent();
}
