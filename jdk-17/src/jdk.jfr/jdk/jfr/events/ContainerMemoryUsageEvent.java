/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
 * Copyright (c) 2021, DataDog. All rights reserved.
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

import jdk.jfr.Category;
import jdk.jfr.DataAmount;
import jdk.jfr.Description;
import jdk.jfr.Enabled;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.Period;
import jdk.jfr.StackTrace;
import jdk.jfr.Threshold;
import jdk.jfr.Timespan;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "ContainerMemoryUsage")
@Label("Container Memory Usage")
@Category({"Operating System", "Memory"})
@Description("Container memory usage related information")
public final class ContainerMemoryUsageEvent extends AbstractJDKEvent {
    @Label("Memory Fail Count")
    @Description("Number of times that user memory requests in the container have exceeded the memory limit")
    public long memoryFailCount;

    @Label("Memory Usage")
    @Description("Amount of physical memory, in bytes, that is currently allocated in the current container")
    @DataAmount
    public long memoryUsage;

    @Label("Memory and Swap Usage")
    @Description("Amount of physical memory and swap space, in bytes, that is currently allocated in the current container")
    @DataAmount
    public long swapMemoryUsage;
}
