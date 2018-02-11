/*
 * Copyright (c) 2000, 2001, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.jvm.hotspot.utilities;

/** This class abstracts the notion of a worker thread which is fed
    tasks in the form of Runnables. */

public class WorkerThread {
  private volatile boolean done = false;
  private MessageQueueBackend mqb;
  private MessageQueue mq;

  public WorkerThread() {
    mqb = new MessageQueueBackend();
    mq = mqb.getFirstQueue();

    // Enable to terminate this worker during runnning by daemonize.
    Thread mqthread = new Thread(new MainLoop());
    mqthread.setDaemon(true);
    mqthread.start();
  }

  /** Runs the given Runnable in the thread represented by this
      WorkerThread object at an unspecified later time. */
  public void invokeLater(Runnable runnable) {
    mq.writeMessage(runnable);
  }

  /** Can be used to dispose of the internal worker thread. Note that
      this method may return before the internal worker thread
      terminates. */
  public void shutdown() {
    done = true;
    mq.writeMessage(new Runnable() { public void run() {} });
  }

  class MainLoop implements Runnable {
    private MessageQueue myMq;

    public MainLoop() {
      myMq = mqb.getSecondQueue();
    }

    public void run() {
      while (!done) {
        Runnable runnable = (Runnable) myMq.readMessage();
        try {
          runnable.run();
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
