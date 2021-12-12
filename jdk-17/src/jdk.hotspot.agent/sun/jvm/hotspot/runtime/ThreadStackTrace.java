/*
 * Copyright (c) 2017, 2020, Oracle and/or its affiliates. All rights reserved.
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

package sun.jvm.hotspot.runtime;

import java.util.*;

public class ThreadStackTrace {
    private JavaThread                        thread;
    private int                               depth;  // number of stack frames added
    private ArrayList<StackFrameInfo>         frames;

    public ThreadStackTrace(JavaThread t) {
        this.thread = t;
        this.depth = 0;
        this.frames = new ArrayList<StackFrameInfo>();
    }

    public int getStackDepth() {
        return depth;
    }

    public StackFrameInfo stackFrameAt(int index) {
        return frames.get(index);
    }

    public void dumpStack(int maxDepth) {
        if (!thread.isJavaThread()) {
            return;
        }
        try {
            for (JavaVFrame vf = thread.getLastJavaVFrameDbg(); vf != null; vf = vf.javaSender()) {
                StackFrameInfo frame = new StackFrameInfo(vf);
                frames.add(frame);
                depth++;

                if (maxDepth > 0 && depth == maxDepth) {
                    // Skip frames if more than maxDepth
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error occurred during stack walking:");
            e.printStackTrace();
        }
    }
}
