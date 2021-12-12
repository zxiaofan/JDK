/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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
package jdk.jpackage.internal;

import java.io.IOException;
import java.util.function.Consumer;
import java.util.function.Supplier;

public final class RetryExecutor {
    public RetryExecutor() {
        setMaxAttemptsCount(5);
        setAttemptTimeoutMillis(2 * 1000);
        setWriteOutputToFile(false);
    }

    public RetryExecutor setMaxAttemptsCount(int v) {
        attempts = v;
        return this;
    }

    public RetryExecutor setAttemptTimeoutMillis(int v) {
        timeoutMillis = v;
        return this;
    }

    RetryExecutor setWriteOutputToFile(boolean v) {
        writeOutputToFile = v;
        return this;
    }

    public RetryExecutor setExecutorInitializer(Consumer<Executor> v) {
        executorInitializer = v;
        return this;
    }

    public void abort() {
        aborted = true;
    }

    public boolean isAborted() {
        return aborted;
    }

    static RetryExecutor retryOnKnownErrorMessage(String v) {
        RetryExecutor result = new RetryExecutor();
        return result.setExecutorInitializer(exec -> {
            exec.setOutputConsumer(output -> {
                if (!output.anyMatch(v::equals)) {
                    result.abort();
                }
            });
        });
    }

    public void execute(String cmdline[]) throws IOException {
        executeLoop(() ->
                Executor.of(cmdline).setWriteOutputToFile(writeOutputToFile));
    }

    public void execute(ProcessBuilder pb) throws IOException {
        executeLoop(() ->
                Executor.of(pb).setWriteOutputToFile(writeOutputToFile));
    }

    private void executeLoop(Supplier<Executor> execSupplier) throws IOException {
        aborted = false;
        for (;;) {
            if (aborted) {
                break;
            }

            try {
                Executor exec = execSupplier.get();
                if (executorInitializer != null) {
                    executorInitializer.accept(exec);
                }
                exec.executeExpectSuccess();
                break;
            } catch (IOException ex) {
                if (aborted || (--attempts) <= 0) {
                    throw ex;
                }
            }

            try {
                Thread.sleep(timeoutMillis);
            } catch (InterruptedException ex) {
                Log.verbose(ex);
                throw new RuntimeException(ex);
            }
        }
    }

    private Consumer<Executor> executorInitializer;
    private boolean aborted;
    private int attempts;
    private int timeoutMillis;
    private boolean writeOutputToFile;
}
