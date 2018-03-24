/*
 * Copyright (c) 2015, 2015, Oracle and/or its affiliates. All rights reserved.
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

import static java.lang.Thread.currentThread;

public class Management {

    private static final com.sun.management.ThreadMXBean threadMXBean = Management.initThreadMXBean();

    /**
     * The amount of memory allocated by
     * {@link com.sun.management.ThreadMXBean#getThreadAllocatedBytes(long)} itself.
     */
    private static final long threadMXBeanOverhead = -getCurrentThreadAllocatedBytes() + getCurrentThreadAllocatedBytes();

    public static long getCurrentThreadAllocatedBytes() {
        return threadMXBean.getThreadAllocatedBytes(currentThread().getId()) - threadMXBeanOverhead;
    }

    private static com.sun.management.ThreadMXBean initThreadMXBean() {
        try {
            return (com.sun.management.ThreadMXBean) java.lang.management.ManagementFactory.getThreadMXBean();
        } catch (Error err) {
            return new UnimplementedBean();
        }
    }

    public static java.lang.management.ThreadMXBean getThreadMXBean() {
        return threadMXBean;
    }

    private static class UnimplementedBean implements java.lang.management.ThreadMXBean, com.sun.management.ThreadMXBean {

        @Override
        public javax.management.ObjectName getObjectName() {
            return null;
        }

        @Override
        public long getThreadAllocatedBytes(long arg0) {
            return 0;
        }

        @Override
        public long[] getThreadAllocatedBytes(long[] arg0) {
            return null;
        }

        @Override
        public long[] getThreadCpuTime(long[] arg0) {
            return null;
        }

        @Override
        public long[] getThreadUserTime(long[] arg0) {
            return null;
        }

        @Override
        public boolean isThreadAllocatedMemoryEnabled() {
            return false;
        }

        @Override
        public boolean isThreadAllocatedMemorySupported() {
            return false;
        }

        @Override
        public void setThreadAllocatedMemoryEnabled(boolean arg0) {
        }

        @Override
        public int getThreadCount() {
            return 0;
        }

        @Override
        public int getPeakThreadCount() {
            return 0;
        }

        @Override
        public long getTotalStartedThreadCount() {
            return 0;
        }

        @Override
        public int getDaemonThreadCount() {
            return 0;
        }

        @Override
        public long[] getAllThreadIds() {
            return null;
        }

        @Override
        public java.lang.management.ThreadInfo getThreadInfo(long id) {
            return null;
        }

        @Override
        public java.lang.management.ThreadInfo[] getThreadInfo(long[] ids) {
            return null;
        }

        @Override
        public java.lang.management.ThreadInfo getThreadInfo(long id, int maxDepth) {
            return null;
        }

        @Override
        public java.lang.management.ThreadInfo[] getThreadInfo(long[] ids, int maxDepth) {
            return null;
        }

        @Override
        public boolean isThreadContentionMonitoringSupported() {
            return false;
        }

        @Override
        public boolean isThreadContentionMonitoringEnabled() {
            return false;
        }

        @Override
        public void setThreadContentionMonitoringEnabled(boolean enable) {
        }

        @Override
        public long getCurrentThreadCpuTime() {
            return 0;
        }

        @Override
        public long getCurrentThreadUserTime() {
            return 0;
        }

        @Override
        public long getThreadCpuTime(long id) {
            return 0;
        }

        @Override
        public long getThreadUserTime(long id) {
            return 0;
        }

        @Override
        public boolean isThreadCpuTimeSupported() {
            return false;
        }

        @Override
        public boolean isCurrentThreadCpuTimeSupported() {
            return false;
        }

        @Override
        public boolean isThreadCpuTimeEnabled() {
            return false;
        }

        @Override
        public void setThreadCpuTimeEnabled(boolean enable) {
        }

        @Override
        public long[] findMonitorDeadlockedThreads() {
            return null;
        }

        @Override
        public void resetPeakThreadCount() {
        }

        @Override
        public long[] findDeadlockedThreads() {
            return null;
        }

        @Override
        public boolean isObjectMonitorUsageSupported() {
            return false;
        }

        @Override
        public boolean isSynchronizerUsageSupported() {
            return false;
        }

        @Override
        public java.lang.management.ThreadInfo[] getThreadInfo(long[] ids, boolean lockedMonitors, boolean lockedSynchronizers) {
            return null;
        }

        @Override
        public java.lang.management.ThreadInfo[] dumpAllThreads(boolean lockedMonitors, boolean lockedSynchronizers) {
            return null;
        }
    }
}
