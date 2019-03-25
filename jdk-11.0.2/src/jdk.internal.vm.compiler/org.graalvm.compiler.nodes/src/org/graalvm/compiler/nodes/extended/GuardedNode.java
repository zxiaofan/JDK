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


package org.graalvm.compiler.nodes.extended;

import org.graalvm.compiler.nodes.ValueNodeInterface;

/**
 * A node that may be guarded by a {@linkplain GuardingNode guarding node}.
 */
public interface GuardedNode extends ValueNodeInterface {

    GuardingNode getGuard();

    void setGuard(GuardingNode guard);
}
