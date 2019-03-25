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
 */


package org.graalvm.compiler.phases.contract;

import org.graalvm.compiler.nodeinfo.NodeSize;

public interface PhaseSizeContract {

    /**
     * Returns a factor {@code >=1} that determines what the final code size in terms of the sum of
     * the node code sizes {@link NodeSize} of all nodes is.
     *
     * @return a factor that determines how much the code size can be increased by this phase
     */
    float codeSizeIncrease();

    default boolean checkContract() {
        return true;
    }

    String contractorName();
}
