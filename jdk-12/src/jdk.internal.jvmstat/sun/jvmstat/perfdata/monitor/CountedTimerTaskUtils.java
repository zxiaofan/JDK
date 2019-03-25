/*
 * Copyright (c) 2004, 2014, Oracle and/or its affiliates. All rights reserved.
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
 * Utility methods for use with {@link CountedTimerTask} instances.
 *
 * @author Brian Doherty
 * @since 1.5
 */
public class CountedTimerTaskUtils {

    // 8028357 removed old, inefficient debug logging

    /**
     * Reschedule a CountedTimeTask at a different interval. Probably not
     * named correctly. This method cancels the old task and computes the
     * delay for starting the new task based on the new interval and the
     * time at which the old task was last executed.
     *
     * @param timer the Timer for the task
     * @param oldTask the old Task
     * @param newTask the new Task
     * @param oldInterval the old interval; use for debugging output
     *                    purposes only.
     * @param newInterval scheduling interval in milliseconds
     */
    public static void reschedule(Timer timer, CountedTimerTask oldTask,
                                  CountedTimerTask newTask, int oldInterval,
                                  int newInterval) {

        long now = System.currentTimeMillis();
        long lastRun = oldTask.scheduledExecutionTime();
        long expired = now - lastRun;

        /*
         * check if original task ever ran - if not, then lastRun is
         * undefined and we simply set the delay to 0.
         */
        long delay = 0;
        if (oldTask.executionCount() > 0) {
            long remainder = newInterval - expired;
            delay = remainder >= 0 ? remainder : 0;
        }

        timer.schedule(newTask, delay, newInterval);
    }
}
