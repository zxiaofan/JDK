/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http.internal.common;

import jdk.incubator.http.HttpHeaders;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalLong;
import java.util.Set;
import java.util.TreeMap;

/**
 * Implementation of HttpHeaders.
 */
public class HttpHeadersImpl implements HttpHeaders {

    private final TreeMap<String,List<String>> headers;

    public HttpHeadersImpl() {
        headers = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    @Override
    public Optional<String> firstValue(String name) {
        List<String> l = headers.get(name);
        return Optional.ofNullable(l == null ? null : l.get(0));
    }

    @Override
    public List<String> allValues(String name) {
        return headers.get(name);
    }

    @Override
    public Map<String, List<String>> map() {
        return Collections.unmodifiableMap(headers);
    }

    public Map<String, List<String>> directMap() {
        return headers;
    }

    // package private mutators

    public HttpHeadersImpl deepCopy() {
        HttpHeadersImpl h1 = new HttpHeadersImpl();
        TreeMap<String,List<String>> headers1 = h1.headers;
        Set<String> keys = headers.keySet();
        for (String key : keys) {
            List<String> vals = headers.get(key);
            List<String> vals1 = new ArrayList<>(vals);
            headers1.put(key, vals1);
        }
        return h1;
    }

    public void addHeader(String name, String value) {
        headers.computeIfAbsent(name, k -> new ArrayList<>(1))
               .add(value);
    }

    public void setHeader(String name, String value) {
        List<String> values = new ArrayList<>(1); // most headers has one value
        values.add(value);
        headers.put(name, values);
    }

    @Override
    public OptionalLong firstValueAsLong(String name) {
        List<String> l = headers.get(name);
        if (l == null) {
            return OptionalLong.empty();
        } else {
            String v = l.get(0);
            return OptionalLong.of(Long.parseLong(v));
        }
    }

    public void clear() {
        headers.clear();
    }
}
