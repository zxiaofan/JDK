/*
 * Copyright (c) 2013, 2016, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.memory.MemoryNode;
import jdk.internal.vm.compiler.word.LocationIdentity;

public interface MemoryProxy extends Proxy, MemoryNode {

    LocationIdentity getLocationIdentity();

    MemoryNode getOriginalMemoryNode();
}
