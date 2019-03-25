/*
 * Copyright (c) 2011, 2018, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.common.jmx;

import java.util.Collection;

public interface HotSpotMBeanOperationProvider {
    <T> void registerOperations(Class<T> clazz, Collection<? super T> ops);

    Object invoke(String actionName, Object[] params, String[] signature);
}
