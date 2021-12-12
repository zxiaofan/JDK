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
package jdk.jshell.execution;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;

/**
 * An implementation of {@link jdk.jshell.spi.ExecutionControl} which executes
 * in the same JVM as the JShell-core.
 *
 * @author Grigory Ptashko
 * @since 9
 */
public class LocalExecutionControl extends DirectExecutionControl {

    private final Object STOP_LOCK = new Object();
    private boolean userCodeRunning = false;
    private ThreadGroup execThreadGroup;

    /**
     * Creates an instance, delegating loader operations to the specified
     * delegate.
     *
     * @param loaderDelegate the delegate to handle loading classes
     */
    public LocalExecutionControl(LoaderDelegate loaderDelegate) {
        super(loaderDelegate);
    }

    /**
     * Create an instance using the default class loading.
     */
    public LocalExecutionControl() {
    }

    @Override
    protected String invoke(Method doitMethod) throws Exception {
        execThreadGroup = new ThreadGroup("JShell process local execution");

        AtomicReference<InvocationTargetException> iteEx = new AtomicReference<>();
        AtomicReference<IllegalAccessException> iaeEx = new AtomicReference<>();
        AtomicReference<NoSuchMethodException> nmeEx = new AtomicReference<>();
        AtomicReference<Boolean> stopped = new AtomicReference<>(false);

        Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
            if (e instanceof InvocationTargetException) {
                if (e.getCause() instanceof ThreadDeath) {
                    stopped.set(true);
                } else {
                    iteEx.set((InvocationTargetException) e);
                }
            } else if (e instanceof IllegalAccessException) {
                iaeEx.set((IllegalAccessException) e);
            } else if (e instanceof NoSuchMethodException) {
                nmeEx.set((NoSuchMethodException) e);
            } else if (e instanceof ThreadDeath) {
                stopped.set(true);
            }
        });

        final Object[] res = new Object[1];
        Thread snippetThread = new Thread(execThreadGroup, () -> {
            try {
                res[0] = doitMethod.invoke(null, new Object[0]);
            } catch (InvocationTargetException e) {
                if (e.getCause() instanceof ThreadDeath) {
                    stopped.set(true);
                } else {
                    iteEx.set(e);
                }
            } catch (IllegalAccessException e) {
                iaeEx.set(e);
            } catch (ThreadDeath e) {
                stopped.set(true);
            }
        });

        snippetThread.start();
        Thread[] threadList = new Thread[execThreadGroup.activeCount()];
        execThreadGroup.enumerate(threadList);
        for (Thread thread : threadList) {
            if (thread != null) {
                thread.join();
            }
        }

        if (stopped.get()) {
            throw new StoppedException();
        }

        if (iteEx.get() != null) {
            throw iteEx.get();
        } else if (nmeEx.get() != null) {
            throw nmeEx.get();
        } else if (iaeEx.get() != null) {
            throw iaeEx.get();
        }

        return valueString(res[0]);
    }

    @Override
    @SuppressWarnings({"deprecation", "removal"})
    public void stop() throws EngineTerminationException, InternalException {
        synchronized (STOP_LOCK) {
            if (!userCodeRunning) {
                return;
            }
            if (execThreadGroup == null) {
                throw new InternalException("Process-local code snippets thread group is null. Aborting stop.");
            }

            execThreadGroup.stop();
        }
    }

    @Override
    protected void clientCodeEnter() {
        synchronized (STOP_LOCK) {
            userCodeRunning = true;
        }
    }

    @Override
    protected void clientCodeLeave() {
        synchronized (STOP_LOCK) {
            userCodeRunning = false;
        }
    }

}
