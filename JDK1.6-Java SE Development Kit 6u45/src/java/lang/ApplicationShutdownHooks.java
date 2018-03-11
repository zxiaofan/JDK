/*
 * %W% %E%
 *
 * Copyright (c) 2004, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.lang;

import java.util.*;

/*
 * Class to track and run user level shutdown hooks registered through
 * <tt>{@link Runtime#addShutdownHook Runtime.addShutdownHook}</tt>.
 *
 * @see java.lang.Runtime#addShutdownHook
 * @see java.lang.Runtime#removeShutdownHook
 */

class ApplicationShutdownHooks {
    static {
        Shutdown.add(1 /* shutdown hook invocation order */,
            new Runnable() {
                public void run() {
                    runHooks();
                }
            });
    }

    /* The set of registered hooks */
    private static IdentityHashMap<Thread, Thread> hooks = new IdentityHashMap<Thread, Thread>();

    private void ApplicationShutdownHooks() {}

    /* Add a new shutdown hook.  Checks the shutdown state and the hook itself,
     * but does not do any security checks.
     */
    static synchronized void add(Thread hook) {
	if(hooks == null)
	    throw new IllegalStateException("Shutdown in progress");

	if (hook.isAlive())
	    throw new IllegalArgumentException("Hook already running");

	if (hooks.containsKey(hook))
	    throw new IllegalArgumentException("Hook previously registered");

        hooks.put(hook, hook);
    }

    /* Remove a previously-registered hook.  Like the add method, this method
     * does not do any security checks.
     */
    static synchronized boolean remove(Thread hook) {
	if(hooks == null)
	    throw new IllegalStateException("Shutdown in progress");

	if (hook == null) 
	    throw new NullPointerException();

	return hooks.remove(hook) != null;
    }

    /* Iterates over all application hooks creating a new thread for each
     * to run in. Hooks are run concurrently and this method waits for 
     * them to finish.
     */
    static void runHooks() {
	Collection<Thread> threads;
	synchronized(ApplicationShutdownHooks.class) {
	    threads = hooks.keySet();
	    hooks = null;
	}

	for (Thread hook : threads) {
	    hook.start();
	}
	for (Thread hook : threads) {
	    try {
		hook.join();
	    } catch (InterruptedException x) { }
	}
    }
}

