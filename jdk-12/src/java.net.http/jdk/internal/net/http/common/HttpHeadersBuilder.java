/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http.common;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static jdk.internal.net.http.common.Utils.ACCEPT_ALL;

/** A mutable builder for collecting and building HTTP headers. */
public class HttpHeadersBuilder {

    private final TreeMap<String, List<String>> headersMap;

    public HttpHeadersBuilder() {
        headersMap = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    public HttpHeadersBuilder structuralCopy() {
        HttpHeadersBuilder builder = new HttpHeadersBuilder();
        for (Map.Entry<String, List<String>> entry : headersMap.entrySet()) {
            List<String> valuesCopy = new ArrayList<>(entry.getValue());
            builder.headersMap.put(entry.getKey(), valuesCopy);
        }
        return builder;
    }

    public void addHeader(String name, String value) {
        headersMap.computeIfAbsent(name, k -> new ArrayList<>(1))
                  .add(value);
    }

    public void setHeader(String name, String value) {
        // headers typically have one value
        List<String> values = new ArrayList<>(1);
        values.add(value);
        headersMap.put(name, values);
    }

    public void clear() {
        headersMap.clear();
    }

    public Map<String, List<String>> map() {
        return headersMap;
    }

    public HttpHeaders build() {
        return HttpHeaders.of(headersMap, ACCEPT_ALL);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(" { ");
        sb.append(map());
        sb.append(" }");
        return sb.toString();
    }
}
