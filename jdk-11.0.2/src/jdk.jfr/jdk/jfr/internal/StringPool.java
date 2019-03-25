/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jfr.internal;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import jdk.internal.misc.Unsafe;

public final class StringPool {

    private static final Unsafe unsafe = Unsafe.getUnsafe();

    static final int MIN_LIMIT = 16;
    static final int MAX_LIMIT = 128; /* 0 MAX means disabled */
    private static final long epochAddress;
    private static final SimpleStringIdPool sp = new SimpleStringIdPool();
    static {
        epochAddress = JVM.getJVM().getEpochAddress();
        sp.reset();
    }
    public static long addString(String s) {
        return sp.addString(s);
    }
    private static boolean getCurrentEpoch() {
        return unsafe.getByte(epochAddress) == 1;
    }
    private static class SimpleStringIdPool {
        /* string id index */
        private final AtomicLong sidIdx = new AtomicLong();
        /* epoch of cached strings */
        private boolean poolEpoch;
        /* the cache */
        private final ConcurrentHashMap<String, Long> cache;
        /* max size */
        private final int MAX_SIZE = 32*1024;
        /* max size bytes*/
        private final long MAX_SIZE_UTF16 = 16*1024*1024;
        /* max size bytes*/
        private long currentSizeUTF16;

        /* looking at a biased data set 4 is a good value */
        private final String[] preCache = new String[]{"", "" , "" ,""};
        /* index of oldest */
        private int preCacheOld = 0;
        /* loop mask */
        private static final int preCacheMask = 0x03;

        SimpleStringIdPool() {
            cache = new ConcurrentHashMap<>(MAX_SIZE, 0.75f);
        }
        void reset() {
            reset(getCurrentEpoch());
        }
        private void reset(boolean epoch) {
            this.cache.clear();
            this.poolEpoch = epoch;
            this.currentSizeUTF16 = 0;
        }
        private long addString(String s) {
            boolean currentEpoch = getCurrentEpoch();
            if (poolEpoch == currentEpoch) {
                /* pool is for current chunk */
                Long lsid = this.cache.get(s);
                if (lsid != null) {
                    return lsid.longValue();
                }
            } else {
                /* pool is for an old chunk */
                reset(currentEpoch);
            }
            if (!preCache(s)) {
                /* we should not pool this string */
                return -1;
            }
            if (cache.size() > MAX_SIZE || currentSizeUTF16 > MAX_SIZE_UTF16) {
                /* pool was full */
                reset(currentEpoch);
            }
            return storeString(s);
        }

        private long storeString(String s) {
            long sid = this.sidIdx.getAndIncrement();
            /* we can race but it is ok */
            this.cache.put(s, sid);
            boolean currentEpoch;
            synchronized(SimpleStringIdPool.class) {
                currentEpoch = JVM.addStringConstant(poolEpoch, sid, s);
                currentSizeUTF16 += s.length();
            }
            /* did we write in chunk that this pool represent */
            return currentEpoch == poolEpoch ? sid : -1;
        }
        private boolean preCache(String s) {
            if (preCache[0].equals(s)) {
                return true;
            }
            if (preCache[1].equals(s)) {
                return true;
            }
            if (preCache[2].equals(s)) {
                return true;
            }
            if (preCache[3].equals(s)) {
                return true;
            }
            preCacheOld = (preCacheOld - 1) & preCacheMask;
            preCache[preCacheOld] = s;
            return false;
        }
    }
}
