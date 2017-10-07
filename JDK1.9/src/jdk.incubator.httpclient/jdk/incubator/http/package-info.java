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

/**
 * <h2>High level HTTP and WebSocket API</h2>
 * {@Incubating}
 *
 * <p> Provides high-level client interfaces to HTTP (versions 1.1 and 2) and
 * WebSocket. The main types defined are:
 *
 * <ul>
 *    <li>{@link jdk.incubator.http.HttpClient}</li>
 *    <li>{@link jdk.incubator.http.HttpRequest}</li>
 *    <li>{@link jdk.incubator.http.HttpResponse}</li>
 *    <li>{@link jdk.incubator.http.WebSocket}</li>
 * </ul>
 *
 * <p> The API functions asynchronously (using {@link java.util.concurrent.CompletableFuture})
 * and work is done on the threads supplied by the client's {@link java.util.concurrent.Executor}
 * where practical.
 *
 * <p> {@code HttpClient} also provides a simple synchronous mode, where all
 * work may be done on the calling thread.
 *
 * <p> {@code CompletableFuture}s returned by this API will throw {@link java.lang.UnsupportedOperationException}
 * for their {@link java.util.concurrent.CompletableFuture#obtrudeValue(Object) obtrudeValue}
 * and {@link java.util.concurrent.CompletableFuture#obtrudeException(Throwable) obtrudeException}
 * methods. Invoking the {@link java.util.concurrent.CompletableFuture#cancel cancel}
 * method on a {@code CompletableFuture} returned by this API will not interrupt
 * the underlying operation, but may be useful to complete, exceptionally,
 * dependent stages that have not already completed.
 *
 * <p> Unless otherwise stated, {@code null} parameter values will cause methods
 * of all classes in this package to throw {@code NullPointerException}.
 *
 * @since 9
 */
package jdk.incubator.http;
