/*
 * Copyright (c) 2019, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.consumer;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

final class ParserFilter {
    public static final ParserFilter ACCEPT_ALL = new ParserFilter(true, Map.of());

    private final Map<String, Long> thresholds;
    private final boolean acceptAll;

    public ParserFilter() {
        this(false, new HashMap<>());
    }

    private ParserFilter(boolean acceptAll, Map<String, Long> thresholds) {
        this.acceptAll = acceptAll;
        this.thresholds = thresholds;
    }

    public void setThreshold(String eventName, long nanos) {
        Long l = thresholds.get(eventName);
        if (l != null) {
            l = Math.min(l, nanos);
        } else {
            l = nanos;
        }
        thresholds.put(eventName, l);
    }

    public long getThreshold(String eventName) {
        if (acceptAll) {
            return 0L;
        }
        Long l = thresholds.get(eventName);
        if (l != null) {
            return l;
        }
        return -1;
    }

    @Override
    public String toString() {
        if (acceptAll) {
            return "ACCEPT ALL";
        }

        StringJoiner sb = new StringJoiner(", ");
        for (String key : thresholds.keySet().toArray(new String[0])) {
            Long value = thresholds.get(key);
            sb.add(key + " = " + value);
        }
        return sb.toString();
    }
}
