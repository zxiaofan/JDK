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

public interface Stats {

    /**
     * Get a Statistic by name.
     */
    Statistic getStatistic(String statisticName);

    /**
     * Returns an array of Strings which are the names of the attributes from the specific Stats submodel that this object supports. Attributes named in the list must correspond to attributes that will return a Statistic object of the appropriate type which contains valid performance data.  The return value of attributes in the Stats submodel that are not included in the statisticNames list must be null. For each name in the statisticNames list there must be one Statistic with the same name in the statistics list.
     */
    String [] getStatisticNames();

    /**
     * Returns an array containing all of the Statistic objects supported by this Stats object.
     */
    Statistic[] getStatistics();
}
