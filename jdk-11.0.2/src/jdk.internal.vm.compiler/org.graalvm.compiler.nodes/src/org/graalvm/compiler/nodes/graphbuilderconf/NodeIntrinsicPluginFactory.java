/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.graphbuilderconf;

import org.graalvm.compiler.core.common.type.Stamp;

public interface NodeIntrinsicPluginFactory {

    public interface InjectionProvider {

        <T> T getInjectedArgument(Class<T> type);

        /**
         * Gets a stamp denoting a given type and non-nullness property.
         *
         * @param type the type the returned stamp represents
         * @param nonNull specifies if the returned stamp denotes a value that is guaranteed to be
         *            non-null
         */
        Stamp getInjectedStamp(Class<?> type, boolean nonNull);
    }

    void registerPlugins(InvocationPlugins plugins, InjectionProvider injection);
}
