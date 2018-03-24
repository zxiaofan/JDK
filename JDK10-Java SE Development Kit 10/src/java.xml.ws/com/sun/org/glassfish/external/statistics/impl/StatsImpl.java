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



package com.sun.org.glassfish.external.statistics.impl;
import com.sun.org.glassfish.external.statistics.Stats;
import com.sun.org.glassfish.external.statistics.Statistic;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Jennifer Chou
 */
public final class StatsImpl implements Stats {

    private final StatisticImpl[] statArray;

    protected StatsImpl(StatisticImpl[] statisticArray) {
        statArray = statisticArray;
    }

    public synchronized Statistic getStatistic(String statisticName) {
        Statistic stat = null;
        for (Statistic s : statArray) {
            if (s.getName().equals(statisticName)) {
                stat = s;
                break;
            }
        }
        return stat;
    }

    public synchronized String[] getStatisticNames() {
        ArrayList list = new ArrayList();
        for (Statistic s : statArray) {
            list.add(s.getName());
        }
        String[] strArray = new String[list.size()];
        return (String[])list.toArray(strArray);
    }

    public synchronized Statistic[] getStatistics() {
        return this.statArray;
    }

    /**
     * Call reset on all of the Statistic objects contained by this Stats object
     */
    public synchronized void reset() {
        for (StatisticImpl s : statArray) {
            s.reset();
        }
    };


}
