/*
 * Copyright (c) 1995, 1997, Oracle and/or its affiliates. All rights reserved.
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

package sun.applet;

/**
 * This class defines an applet thread group.
 *
 * @author      Arthur van Hoff
 */
public class AppletThreadGroup extends ThreadGroup {

    /**
     * Constructs a new thread group for an applet.
     * The parent of this new group is the thread
     * group of the currently running thread.
     *
     * @param   name   the name of the new thread group.
     */
    public AppletThreadGroup(String name) {
        this(Thread.currentThread().getThreadGroup(), name);
    }

    /**
     * Creates a new thread group for an applet.
     * The parent of this new group is the specified
     * thread group.
     *
     * @param     parent   the parent thread group.
     * @param     name     the name of the new thread group.
     * @exception  NullPointerException  if the thread group argument is
     *               {@code null}.
     * @exception  SecurityException  if the current thread cannot create a
     *               thread in the specified thread group.
     * @see     java.lang.SecurityException
     * @since   1.1.1
     */
    public AppletThreadGroup(ThreadGroup parent, String name) {
        super(parent, name);
        setMaxPriority(Thread.NORM_PRIORITY - 1);
    }
}
