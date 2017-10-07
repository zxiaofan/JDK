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

import com.sun.org.glassfish.external.statistics.TimeStatistic;
import java.util.Map;
import java.lang.reflect.*;

/**
 * @author Sreenivas Munnangi
 */
public final class TimeStatisticImpl extends StatisticImpl
    implements TimeStatistic, InvocationHandler {

    private long count = 0L;
    private long maxTime = 0L;
    private long minTime = 0L;
    private long totTime = 0L;
    private final long initCount;
    private final long initMaxTime;
    private final long initMinTime;
    private final long initTotTime;

    private final TimeStatistic ts =
            (TimeStatistic) Proxy.newProxyInstance(
            TimeStatistic.class.getClassLoader(),
            new Class[] { TimeStatistic.class },
            this);

    public synchronized final String toString() {
        return super.toString() + NEWLINE +
            "Count: " + getCount() + NEWLINE +
            "MinTime: " + getMinTime() + NEWLINE +
            "MaxTime: " + getMaxTime() + NEWLINE +
            "TotalTime: " + getTotalTime();
    }

    public TimeStatisticImpl(long counter, long maximumTime, long minimumTime,
                             long totalTime, String name, String unit,
                             String desc, long startTime, long sampleTime) {
        super(name, unit, desc, startTime, sampleTime);
        count = counter;
        initCount = counter;
        maxTime = maximumTime;
        initMaxTime = maximumTime;
        minTime = minimumTime;
        initMinTime = minimumTime;
        totTime = totalTime;
        initTotTime = totalTime;
    }

    public synchronized TimeStatistic getStatistic() {
        return ts;
    }

    public synchronized Map getStaticAsMap() {
        Map m = super.getStaticAsMap();
        m.put("count", getCount());
        m.put("maxtime", getMaxTime());
        m.put("mintime", getMinTime());
        m.put("totaltime", getTotalTime());
        return m;
    }

     public synchronized void incrementCount(long current) {
        if (count == 0) {
            totTime = current;
            maxTime = current;
            minTime = current;
        } else {
            totTime = totTime + current;
            maxTime = (current >= maxTime ? current : maxTime);
            minTime = (current >= minTime ? minTime : current);
        }
        count++;
        sampleTime = System.currentTimeMillis();
     }

    /**
     * Returns the number of times an operation was invoked
     */
    public synchronized long getCount() {
        return count;
    }

    /**
     * Returns the maximum amount of time that it took for one invocation of an
     * operation, since measurement started.
     */
    public synchronized long getMaxTime() {
        return maxTime;
    }

    /**
     * Returns the minimum amount of time that it took for one invocation of an
     * operation, since measurement started.
     */
    public synchronized long getMinTime() {
        return minTime;
    }

    /**
     * Returns the amount of time that it took for all invocations,
     * since measurement started.
     */
    public synchronized long getTotalTime() {
        return totTime;
    }

    @Override
    public synchronized void reset() {
        super.reset();
        count = initCount;
        maxTime = initMaxTime;
        minTime = initMinTime;
        totTime = initTotTime;
        sampleTime = -1L;
    }

    // todo: equals implementation
    public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
        checkMethod(m);

        Object result;
        try {
            result = m.invoke(this, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        } catch (Exception e) {
            throw new RuntimeException("unexpected invocation exception: " +
                       e.getMessage());
        }
        return result;
    }
}
