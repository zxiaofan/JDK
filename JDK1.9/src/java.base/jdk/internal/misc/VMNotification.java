/*
 * Copyright (c) 1996, 2004, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.misc;

/** @deprecated */
@Deprecated
public interface VMNotification {

    // when the vm switches allocation states, we get notified
    // (possible semantics: if the state changes while in this
    // notification, don't recursively notify).
    // oldState and newState may be the same if we are just releasing
    // suspended threads.
    void newAllocState(int oldState, int newState,
                       boolean threadsSuspended);
}
