/*
 * Copyright (c) 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.X11;

import java.util.*;

/**
 * Implements abstract X window property caching mechanism.  The
 * caching is performed using storeCache method, the cached data can
 * be retrieved using getCacheEntry method.
 *
 * NOTE: current caching is disabled because of the big variate of
 * uncovered access to properties/changes of properties.  Once the
 * access to properites is rewritten using general mechanisms, caching
 * will be enabled.
 */
public class XPropertyCache {

    static class PropertyCacheEntry {
        private final int format;
        private final int numberOfItems;
        private final long bytesAfter;
        private final long data;
        private final int dataLength;
        public PropertyCacheEntry(int format, int numberOfItems, long bytesAfter, long data, int dataLength) {
            this.format = format;
            this.numberOfItems = numberOfItems;
            this.bytesAfter = bytesAfter;
            this.data = XlibWrapper.unsafe.allocateMemory(dataLength);
            this.dataLength = dataLength;
            XlibWrapper.memcpy(this.data, data, dataLength);
        }

        public int getFormat() {
            return format;
        }

        public int getNumberOfItems() {
            return numberOfItems;
        }

        public long getBytesAfter() {
            return bytesAfter;
        }

        public long getData() {
            return data;
        }

        public int getDataLength() {
            return dataLength;
        }
    }

    private static Map<Long, Map<XAtom, PropertyCacheEntry>> windowToMap = new HashMap<Long, Map<XAtom, PropertyCacheEntry>>();

    public static boolean isCached(long window, XAtom property) {
        Map<XAtom, PropertyCacheEntry> entryMap = windowToMap.get(window);
        if (entryMap != null) {
            return entryMap.containsKey(property);
        } else {
            return false;
        }
    }

    public static PropertyCacheEntry getCacheEntry(long window, XAtom property) {
        Map<XAtom, PropertyCacheEntry> entryMap = windowToMap.get(window);
        if (entryMap != null) {
            return entryMap.get(property);
        } else {
            return null;
        }
    }

    public static void storeCache(PropertyCacheEntry entry, long window, XAtom property) {
        Map<XAtom, PropertyCacheEntry> entryMap = windowToMap.get(window);
        if (entryMap == null) {
            entryMap = new HashMap<XAtom, PropertyCacheEntry>();
            windowToMap.put(window, entryMap);
        }
        entryMap.put(property, entry);
    }

    public static void clearCache(long window) {
        windowToMap.remove(window);
    }

    public static void clearCache(long window, XAtom property) {
        Map<XAtom, PropertyCacheEntry> entryMap = windowToMap.get(window);
        if (entryMap != null) {
            entryMap.remove(property);
        }
    }

    public static boolean isCachingSupported() {
        // Currently - unsupported
        return false;
    }
}
