/*
 * Copyright (c) 2009, 2011, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.phases.schedule;

import org.graalvm.compiler.nodes.cfg.Block;

/**
 * The {@code BlockClosure} interface represents a closure for iterating over blocks.
 */
public interface BlockClosure {

    void apply(Block block);
}
