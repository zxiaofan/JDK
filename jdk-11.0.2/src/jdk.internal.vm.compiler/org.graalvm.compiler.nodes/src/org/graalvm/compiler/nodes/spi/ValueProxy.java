/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.nodes.spi;

import org.graalvm.compiler.nodes.extended.GuardingNode;

/**
 * This interface marks nodes whose result is the same as one of their inputs. Such nodes are used
 * to add type information, to introduce scheduling restrictions, etc.
 *
 * For some algorithms it is necessary or advantageous to see through these proxies.
 */
public interface ValueProxy extends LimitedValueProxy {
    GuardingNode getGuard();
}
