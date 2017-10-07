/*
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvmstat.perfdata.monitor;

import java.util.*;

/**
 * A TimerTask subclass that keeps a count of the number of executions
 * of the task.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class CountedTimerTask extends TimerTask {

    volatile long executionCount;

    public long executionCount() {
        return executionCount;
    }

    public void run() {
        executionCount++;
    }
}
