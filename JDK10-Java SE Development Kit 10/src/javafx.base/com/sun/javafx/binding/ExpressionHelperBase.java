/*
 * Copyright (c) 2012, 2015, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.javafx.binding;

import java.util.function.Predicate;
import javafx.beans.WeakListener;

public class ExpressionHelperBase {

    protected static int trim(int size, Object[] listeners) {
        Predicate<Object> p = t -> t instanceof WeakListener &&
                ((WeakListener)t).wasGarbageCollected();
        int index = 0;
        for (; index < size; index++) {
            if (p.test(listeners[index])) {
                break;
            }
        }
        if (index < size) {
            for (int src = index + 1; src < size; src++) {
                if (!p.test(listeners[src])) {
                    listeners[index++] = listeners[src];
                }
            }
            int oldSize = size;
            size = index;
            for (; index < oldSize; index++) {
                listeners[index] = null;
            }
        }

        return size;
    }

}
