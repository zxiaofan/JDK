/*
 * Copyright (c) 2014, 2016, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.sjavac.comp;

import com.sun.tools.javac.main.Main.Result;
import com.sun.tools.sjavac.Log;
import com.sun.tools.sjavac.server.Sjavac;

import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * An sjavac implementation that limits the number of concurrent calls by
 * wrapping invocations in Callables and delegating them to a FixedThreadPool.
 *
 *  <p><b>This is NOT part of any supported API.
 *  If you write code that depends on this, you do so at your own risk.
 *  This code and its internal interfaces are subject to change or
 *  deletion without notice.</b>
 */
public class PooledSjavac implements Sjavac {

    final Sjavac delegate;
    final ExecutorService pool;

    public PooledSjavac(Sjavac delegate, int poolsize) {
        Objects.requireNonNull(delegate);
        this.delegate = delegate;
        pool = Executors.newFixedThreadPool(poolsize);
    }

    @Override
    public Result compile(String[] args) {
        Log log = Log.get();
        try {
            return pool.submit(() -> {
                Log.setLogForCurrentThread(log);
                return delegate.compile(args);
            }).get();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error during compile", e);
        }
    }

    @Override
    public void shutdown() {
        Log.debug("Shutting down PooledSjavac");
        pool.shutdown(); // Disable new tasks from being submitted
        try {
            // Wait a while for existing tasks to terminate
            if (!pool.awaitTermination(60, TimeUnit.SECONDS)) {
                pool.shutdownNow(); // Cancel currently executing tasks
                // Wait a while for tasks to respond to being cancelled
                if (!pool.awaitTermination(60, TimeUnit.SECONDS))
                    Log.error("ThreadPool did not terminate");
            }
        } catch (InterruptedException ie) {
          // (Re-)Cancel if current thread also interrupted
          pool.shutdownNow();
          // Preserve interrupt status
          Thread.currentThread().interrupt();
        }

        delegate.shutdown();
    }

}
