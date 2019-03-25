/*
 * Copyright (c) 2017, 2017, Oracle and/or its affiliates. All rights reserved.
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

import org.graalvm.compiler.core.common.type.Stamp;
import org.graalvm.compiler.nodes.ValueNode;

public interface StampInverter {

    /**
     * Computes the stamp of the input for the given output stamp.
     */
    Stamp invertStamp(Stamp outStamp);

    /**
     * Gets the input node.
     */
    ValueNode getValue();
}
