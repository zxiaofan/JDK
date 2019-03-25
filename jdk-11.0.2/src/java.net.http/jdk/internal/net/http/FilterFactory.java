/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.util.LinkedList;
import java.util.List;

class FilterFactory {

    // Strictly-ordered list of filters.
    final LinkedList<Class<? extends HeaderFilter>> filterClasses = new LinkedList<>();

    public void addFilter(Class<? extends HeaderFilter> type) {
        filterClasses.add(type);
    }

    LinkedList<HeaderFilter> getFilterChain() {
        LinkedList<HeaderFilter> l = new LinkedList<>();
        for (Class<? extends HeaderFilter> clazz : filterClasses) {
            try {
                // Requires a public no arg constructor.
                HeaderFilter headerFilter = clazz.getConstructor().newInstance();
                l.add(headerFilter);
            } catch (ReflectiveOperationException e) {
                throw new InternalError(e);
            }
        }
        return l;
    }
}
