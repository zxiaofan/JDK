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

package com.sun.javafx.event;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javafx.event.EventDispatchChain;
import javafx.event.EventTarget;

public class CompositeEventTargetImpl implements CompositeEventTarget {
    private final Set<EventTarget> eventTargets;

    public CompositeEventTargetImpl(final EventTarget... eventTargets) {
        final Set<EventTarget> mutableSet =
                new HashSet<EventTarget>(eventTargets.length);
        mutableSet.addAll(Arrays.asList(eventTargets));

        this.eventTargets = Collections.unmodifiableSet(mutableSet);
    }

    @Override
    public Set<EventTarget> getTargets() {
        return eventTargets;
    }

    @Override
    public boolean containsTarget(EventTarget target) {
        return eventTargets.contains(target);
    }

    @Override
    public EventDispatchChain buildEventDispatchChain(
            final EventDispatchChain tail) {
        EventDispatchTree eventDispatchTree = (EventDispatchTree) tail;

        for (final EventTarget eventTarget: eventTargets) {
            final EventDispatchTree targetDispatchTree =
                    eventDispatchTree.createTree();
            eventDispatchTree = eventDispatchTree.mergeTree(
                    (EventDispatchTree) eventTarget.buildEventDispatchChain(
                                                        targetDispatchTree));
        }

        return eventDispatchTree;
    }
}
