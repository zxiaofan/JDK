/*
 * Copyright (c) 2011, 2014, Oracle and/or its affiliates. All rights reserved.
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
 */


package org.graalvm.compiler.nodes.virtual;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.graalvm.compiler.nodes.java.MonitorIdNode;

/**
 * The class implements a simple linked list of MonitorIdNodes, which can be used to describe the
 * current lock state of an object.
 */
public final class LockState {

    public final MonitorIdNode monitorId;
    public final LockState next;

    public LockState(MonitorIdNode monitorId, LockState next) {
        this.monitorId = monitorId;
        this.next = next;
    }

    @Override
    public String toString() {
        return monitorId.getLockDepth() + (next == null ? "" : "," + next);
    }

    public static List<MonitorIdNode> asList(LockState state) {
        if (state == null) {
            return Collections.emptyList();
        } else {
            ArrayList<MonitorIdNode> result = new ArrayList<>();
            LockState a = state;
            do {
                result.add(a.monitorId);
                a = a.next;
            } while (a != null);
            return result;
        }
    }
}
