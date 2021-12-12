/*
 * Copyright (c) 2002, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.jndi.ldap.pool;

/**
 * Thread that wakes up periodically and closes expired, unused connections.
 *
 * @author Rosanna Lee
 */
public final class PoolCleaner implements Runnable {
    private final Pool[] pools;
    private final long period;

    /**
     * @param period ms to wait between cleaning
     * @param pools non-null array of Pools to clean
     */
    public PoolCleaner(long period, Pool[] pools) {
        super();
        this.period = period;
        this.pools = pools.clone();
    }

    @Override
    public void run() {
        long threshold;
        while (true) {
            synchronized (this) {
                // Wait for duration of period ms
                try {
                    wait(period);
                } catch (InterruptedException ignore) {
                }

                // Connections idle since threshold have expired
                threshold = System.currentTimeMillis() - period;
                for (int i = 0; i < pools.length; i++) {
                    if (pools[i] != null) {
                        pools[i].expire(threshold);
                    }
                }
            }
        }
    }
}
