/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.awt.event.WindowEvent;
import java.awt.Window;

@SuppressWarnings("serial") // JDK-implementation class
public class TimedWindowEvent extends WindowEvent {

    private long time;

    public long getWhen() {
        return time;
    }

    public TimedWindowEvent(Window source, int id, Window opposite, long time) {
        super(source, id, opposite);
        this.time = time;
    }

    public TimedWindowEvent(Window source, int id, Window opposite,
                            int oldState, int newState, long time)
    {
        super(source, id, opposite, oldState, newState);
        this.time = time;
    }
}

