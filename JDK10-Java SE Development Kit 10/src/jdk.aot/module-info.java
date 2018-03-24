/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Defines the Ahead-of-Time (AOT) compiler, <em>{@index jaotc jaotc tool}</em>,
 * for compiling Java classes into AOT library.
 *
 * @moduleGraph
 * @since 9
 */
module jdk.aot {
    requires jdk.internal.vm.ci;
    requires jdk.internal.vm.compiler;
    requires jdk.management;
}
