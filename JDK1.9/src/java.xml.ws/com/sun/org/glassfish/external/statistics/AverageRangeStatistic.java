/*
 * Copyright (c) 2004, 2013, Oracle and/or its affiliates. All rights reserved.
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



/*
 * AverageRangeStatistic.java
 *
 * Created on May 11, 2004, 2:15 PM
 */

package com.sun.org.glassfish.external.statistics;

/**
 * An interface that Specifies standard measurements of the lowest and highest
 * values an attribute has held as well as its current value.
 * Extending RangeStatistic, it also provides the average value.
 */

public interface AverageRangeStatistic extends RangeStatistic {

    public long getAverage();

}
