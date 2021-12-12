/*
 * Copyright (c) 1997, 2020, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.ref;

/**
 * Final references, used to implement finalization
 */
class FinalReference<T> extends Reference<T> {

    public FinalReference(T referent, ReferenceQueue<? super T> q) {
        super(referent, q);
    }

    /* May only be called when the reference is inactive, so no longer weak. */
    @Override
    public T get() {
        // Cannot call super.get() when active, as the GC could
        // deactivate immediately after the test.
        return getFromInactiveFinalReference();
    }

    /* May only be called when the reference is inactive, so no longer weak.
     * Clearing while active would discard the finalization request.
     */
    @Override
    public void clear() {
        clearInactiveFinalReference();
    }

    @Override
    public boolean enqueue() {
        throw new InternalError("should never reach here");
    }
}
