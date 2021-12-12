/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.events;

import jdk.internal.misc.VM;
import jdk.internal.misc.VM.BufferPool;

import jdk.jfr.*;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "DirectBufferStatistics")
@Label("Direct Buffer Statistics")
@Description("Statistics of direct buffer")
public final class DirectBufferStatisticsEvent extends AbstractBufferStatisticsEvent {

    private static final BufferPool DIRECT_BUFFER_POOL = findPoolByName("direct");

    public DirectBufferStatisticsEvent() {
        super(DIRECT_BUFFER_POOL);
        this.maxCapacity = VM.maxDirectMemory();
    }

    @Label("Maximum Capacity")
    @Description("Maximum direct buffer capacity the process can use")
    @DataAmount
    final long maxCapacity;
}
