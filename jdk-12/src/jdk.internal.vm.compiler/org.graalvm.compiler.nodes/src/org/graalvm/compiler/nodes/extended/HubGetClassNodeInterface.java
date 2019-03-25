/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.nodes.ValueNode;
import org.graalvm.compiler.nodes.ValueNodeInterface;

/**
 * In some systems, the hub and the class are different objects, and this is a base interface for
 * operations that converts a hub to the class.
 */
public interface HubGetClassNodeInterface extends ValueNodeInterface {
    ValueNode getHub();
}
