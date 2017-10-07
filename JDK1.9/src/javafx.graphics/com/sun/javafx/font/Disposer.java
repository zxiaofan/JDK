/*
 * Copyright (c) 2011, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.font;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.Hashtable;

/**
 * This class is used for registering and disposing the native
 * data associated with java objects.
 *
 * The object can register itself by calling the addRecord method and
 * providing a descendant of the DisposerRecord class with overridden
 * dispose() method.
 *
 * When the object becomes unreachable, the dispose() method
 * of the associated DisposerRecord object will be called.
 *
 * @see DisposerRecord
 */
public class Disposer implements Runnable {
    private static final ReferenceQueue queue = new ReferenceQueue();
    private static final Hashtable records = new Hashtable();
    private static Disposer disposerInstance;

    static {
        disposerInstance = new Disposer();

        ThreadGroup tg = Thread.currentThread().getThreadGroup();
        java.security.AccessController.doPrivileged(
            new java.security.PrivilegedAction() {
                public Object run() {
                    /* The thread must be a member of a thread group
                     * which will not get GCed before VM exit.
                     * Make its parent the top-level thread group.
                     */
                    ThreadGroup tg = Thread.currentThread().getThreadGroup();
                    for (ThreadGroup tgn = tg;
                         tgn != null;
                         tg = tgn, tgn = tg.getParent());
                    Thread t =
                        new Thread(tg, disposerInstance, "Prism Font Disposer");
                    t.setContextClassLoader(null);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    t.start();
                    return null;
                }
            }
        );
    }

    /**
     * Registers the object and the native data for later disposal.
     * @param target Object to be registered
     * @param rec the associated DisposerRecord object
     * @see DisposerRecord
     */
    public static WeakReference addRecord(Object target, DisposerRecord rec) {
        WeakReference ref = new WeakReference(target, queue);
        disposerInstance.records.put(ref, rec);
        return ref;
    }

    public void run() {
        while (true) {
            try {
                Object obj = queue.remove();
                ((Reference)obj).clear();
                DisposerRecord rec = (DisposerRecord)records.remove(obj);
                rec.dispose();
                obj = null;
                rec = null;
            } catch (Exception e) {
                System.out.println("Exception while removing reference: " + e);
                e.printStackTrace();
            }
        }
    }
}
