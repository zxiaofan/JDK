/*
 * Copyright (c) 2004, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.tools.jconsole;

import java.util.*;

public class Worker extends Thread {
    ArrayList<Runnable> jobs = new ArrayList<Runnable>();
    private volatile boolean stopped = false;

    public Worker(String name) {
        super("Worker-"+name);

        setPriority(NORM_PRIORITY - 1);
    }

    public void run() {
        while (!stopped) {
            Runnable job;
            synchronized(jobs) {
                while (!stopped && jobs.size() == 0) {
                    try {
                        jobs.wait();
                    } catch (InterruptedException ex) {
                    }
                }

                if(stopped) break;

                job = jobs.remove(0);
            }
            job.run();
        }
    }

    public void stopWorker() {
        stopped = true;
        synchronized(jobs) {
            jobs.notify();
        }
    }

    public void add(Runnable job) {
        synchronized(jobs) {
            jobs.add(job);
            jobs.notify();
        }
    }

    public boolean queueFull() {
        synchronized(jobs) {
            return (jobs.size() > 0);
        }
    }
}
