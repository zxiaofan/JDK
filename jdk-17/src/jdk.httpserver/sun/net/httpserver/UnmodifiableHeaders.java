/*
 * Copyright (c) 2005, 2021, Oracle and/or its affiliates. All rights reserved.
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

package sun.net.httpserver;

import java.util.*;
import java.util.function.BiFunction;
import com.sun.net.httpserver.*;

public class UnmodifiableHeaders extends Headers {

    private final Headers headers;  // modifiable, but no reference to it escapes
    private final Map<String, List<String>> map;  // unmodifiable

    public UnmodifiableHeaders(Headers headers) {
        var h = headers;
        var unmodHeaders = new Headers();
        h.forEach((k, v) -> unmodHeaders.put(k, Collections.unmodifiableList(v)));
        this.map = Collections.unmodifiableMap(unmodHeaders);
        this.headers = unmodHeaders;
    }

    public int size() {return headers.size();}

    public boolean isEmpty() {return headers.isEmpty();}

    public boolean containsKey(Object key) { return headers.containsKey(key); }

    public boolean containsValue(Object value) { return headers.containsValue(value); }

    public List<String> get(Object key) { return headers.get(key); }

    public String getFirst(String key) { return headers.getFirst(key); }

    public List<String> put(String key, List<String> value) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public void add(String key, String value) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public void set(String key, String value) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public List<String> remove(Object key) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public void putAll(Map<? extends String,? extends List<String>> t)  {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public void clear() {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public Set<String> keySet() { return map.keySet(); }

    public Collection<List<String>> values() { return map.values(); }

    /* TODO check that contents of set are not modifable : security */

    public Set<Map.Entry<String, List<String>>> entrySet() { return map.entrySet(); }

    public List<String> replace(String key, List<String> value) {
        throw new UnsupportedOperationException("unsupported operation");
    }

    public boolean replace(String key, List<String> oldValue, List<String> newValue) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public void replaceAll(BiFunction<? super String, ? super List<String>, ? extends List<String>> function) {
        throw new UnsupportedOperationException ("unsupported operation");
    }

    public boolean equals(Object o) {return headers.equals(o);}

    public int hashCode() {return headers.hashCode();}
}
