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

import java.util.concurrent.CompletableFuture;
import jdk.incubator.http.internal.common.MinimalFuture;
import jdk.incubator.http.internal.common.Log;

/**
 * One PushGroup object is associated with the parent Stream of the pushed
 * Streams. This keeps track of all common state associated with the pushes.
 */
class PushGroup<U,T> {
    // the overall completion object, completed when all pushes are done.
    final CompletableFuture<Void> resultCF;
    final CompletableFuture<Void> noMorePushesCF;

    volatile Throwable error; // any exception that occured during pushes

    // CF for main response
    final CompletableFuture<HttpResponse<T>> mainResponse;

    // user's processor object
    final HttpResponse.MultiProcessor<U, T> multiProcessor;

    final HttpResponse.BodyHandler<T> mainBodyHandler;

    int numberOfPushes;
    int remainingPushes;
    boolean noMorePushes = false;

    PushGroup(HttpResponse.MultiProcessor<U, T> multiProcessor, HttpRequestImpl req) {
        this(multiProcessor, req, new MinimalFuture<>());
    }

    // Check mainBodyHandler before calling nested constructor.
    private PushGroup(HttpResponse.MultiProcessor<U, T> multiProcessor,
            HttpRequestImpl req,
            CompletableFuture<HttpResponse<T>> mainResponse) {
        this(multiProcessor, mainResponse,
             multiProcessor.onRequest(req).orElseThrow(
                    () -> new IllegalArgumentException(
                     "A valid body processor for the main response is required")));
    }

    // This private constructor is called after all parameters have been
    // checked.
    private PushGroup(HttpResponse.MultiProcessor<U, T> multiProcessor,
                      CompletableFuture<HttpResponse<T>> mainResponse,
                      HttpResponse.BodyHandler<T> mainBodyHandler) {

        assert mainResponse != null; // A new instance is created above
        assert mainBodyHandler != null; // should have been checked above

        this.resultCF = new MinimalFuture<>();
        this.noMorePushesCF = new MinimalFuture<>();
        this.multiProcessor = multiProcessor;
        this.mainResponse = mainResponse.thenApply(r -> {
            multiProcessor.onResponse(r);
            return r;
        });
        this.mainBodyHandler = mainBodyHandler;
    }

    CompletableFuture<Void> groupResult() {
        return resultCF;
    }

    HttpResponse.MultiProcessor<U, T> processor() {
        return multiProcessor;
    }

    HttpResponse.BodyHandler<T> mainResponseHandler() {
        return mainBodyHandler;
    }

    synchronized void setMainResponse(CompletableFuture<HttpResponse<T>> r) {
        r.whenComplete((HttpResponse<T> response, Throwable t) -> {
            if (t != null)
                mainResponse.completeExceptionally(t);
            else
                mainResponse.complete(response);
        });
    }

    synchronized CompletableFuture<HttpResponse<T>> mainResponse() {
        return mainResponse;
    }

    synchronized void addPush() {
        numberOfPushes++;
        remainingPushes++;
    }

    synchronized int numberOfPushes() {
        return numberOfPushes;
    }
    // This is called when the main body response completes because it means
    // no more PUSH_PROMISEs are possible

    synchronized void noMorePushes(boolean noMore) {
        noMorePushes = noMore;
        checkIfCompleted();
        noMorePushesCF.complete(null);
    }

    CompletableFuture<Void> pushesCF() {
        return noMorePushesCF;
    }

    synchronized boolean noMorePushes() {
        return noMorePushes;
    }

    synchronized void pushCompleted() {
        remainingPushes--;
        checkIfCompleted();
    }

    synchronized void checkIfCompleted() {
        if (Log.trace()) {
            Log.logTrace("PushGroup remainingPushes={0} error={1} noMorePushes={2}",
                         remainingPushes,
                         (error==null)?error:error.getClass().getSimpleName(),
                         noMorePushes);
        }
        if (remainingPushes == 0 && error == null && noMorePushes) {
            if (Log.trace()) {
                Log.logTrace("push completed");
            }
            resultCF.complete(null);
        }
    }

    synchronized void pushError(Throwable t) {
        if (t == null) {
            return;
        }
        this.error = t;
        resultCF.completeExceptionally(t);
    }
}
