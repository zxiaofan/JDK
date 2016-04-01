/*
 * Copyright (c) 2011, Oracle and/or its affiliates. All rights reserved.
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

package java.lang.invoke;

import static java.lang.invoke.MethodHandleNatives.Constants.*;

/**
 * This method handle is used to optionally provide a count of how
 * many times it was invoked.
 *
 * @author never
 */
class CountingMethodHandle extends AdapterMethodHandle {
    private int vmcount;

    private CountingMethodHandle(MethodHandle target) {
        super(target, target.type(), AdapterMethodHandle.makeConv(OP_RETYPE_ONLY));
    }

    /** Wrap the incoming MethodHandle in a CountingMethodHandle if they are enabled */
    static MethodHandle wrap(MethodHandle mh) {
        if (MethodHandleNatives.COUNT_GWT) {
            return new CountingMethodHandle(mh);
        }
        return mh;
    }
}
