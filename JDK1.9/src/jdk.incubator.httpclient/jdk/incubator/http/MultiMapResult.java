/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

package jdk.incubator.http;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

/**
 * A {@link java.util.Map} containing the result of a HTTP/2 request and multi-response.
 * {@Incubating}
 * <p>
 * This is one possible implementation of the aggregate result type {@code <U>} returned
 * from {@link HttpClient#sendAsync(HttpRequest,MultiProcessor) }.
 * The map is indexed by {@link HttpRequest} and each value is a
 * {@link java.util.concurrent.CompletableFuture}&lt;
 * {@link HttpResponse}{@code <V>}&gt;
 * <p>
 * A {@code MultiMapResult} is obtained from an invocation such as the one shown below:
 * <p>
 * {@link CompletableFuture}&lt;{@code MultiMapResult<V>}&gt;
 * {@link HttpClient#sendAsync(HttpRequest,
 * HttpResponse.MultiProcessor) HttpClient.sendAsync(}{@link
 * HttpResponse.MultiProcessor#asMap(java.util.function.Function)
 * MultiProcessor.asMap(Function)})
 *
 * @param <V> the response body type for all responses
 */
public class MultiMapResult<V> implements Map<HttpRequest,CompletableFuture<HttpResponse<V>>> {
    private final Map<HttpRequest,CompletableFuture<HttpResponse<V>>> map;

    MultiMapResult(Map<HttpRequest,CompletableFuture<HttpResponse<V>>> map) {
        this.map = map;
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return map.containsValue(value);
    }

    @Override
    public CompletableFuture<HttpResponse<V>> get(Object key) {
        return map.get(key);
    }

    @Override
    public CompletableFuture<HttpResponse<V>> put(HttpRequest key, CompletableFuture<HttpResponse<V>> value) {
        return map.put(key, value);
    }

    @Override
    public CompletableFuture<HttpResponse<V>> remove(Object key) {
        return map.remove(key);
    }

    @Override
    public void putAll(Map<? extends HttpRequest, ? extends CompletableFuture<HttpResponse<V>>> m) {
        map.putAll(m);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public Set<HttpRequest> keySet() {
        return map.keySet();
    }

    @Override
    public Collection<CompletableFuture<HttpResponse<V>>> values() {
        return map.values();
    }

    @Override
    public Set<Entry<HttpRequest, CompletableFuture<HttpResponse<V>>>> entrySet() {
        return map.entrySet();
    }
}

