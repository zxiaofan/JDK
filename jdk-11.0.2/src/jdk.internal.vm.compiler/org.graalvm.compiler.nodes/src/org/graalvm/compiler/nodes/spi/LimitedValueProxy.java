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

import org.graalvm.compiler.nodes.ValueNode;

/**
 * This interface is like the derived {@link ValueProxy}. The difference is that only the graph
 * builder should see through the proxy for doing some checks. Optimizations should not see through
 * this proxy and therefore should only test for {@link ValueProxy}.
 */
public interface LimitedValueProxy extends Proxy {

    @Override
    ValueNode getOriginalNode();

}
