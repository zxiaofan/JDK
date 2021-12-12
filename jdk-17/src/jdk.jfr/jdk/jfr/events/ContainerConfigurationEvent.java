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

@Name(Type.EVENT_NAME_PREFIX + "ContainerConfiguration")
@Label("Container Configuration")
@Category({"Operating System"})
@Description("A set of container specific attributes")
public final class ContainerConfigurationEvent extends AbstractJDKEvent {
    @Label("Container Type")
    @Description("Container type information")
    public String containerType;

    @Label("CPU Slice Period")
    @Description("Length of the scheduling period for processes within the container")
    @Timespan(Timespan.MICROSECONDS)
    public long cpuSlicePeriod;

    @Label("CPU Quota")
    @Description("Total available run-time allowed during each scheduling period for all tasks in the container")
    @Timespan(Timespan.MICROSECONDS)
    public long cpuQuota;

    @Label("CPU Shares")
    @Description("Relative weighting of processes with the container used for prioritizing the scheduling of processes across " +
                 "all containers running on a host")
    public long cpuShares;

    @Label("Effective CPU Count")
    @Description("Number of effective processors that this container has available to it")
    public long effectiveCpuCount;

    @Label("Memory Soft Limit")
    @Description("Hint to the operating system that allows groups to specify the minimum required amount of physical memory")
    @DataAmount
    public long memorySoftLimit;

    @Label("Memory Limit")
    @Description("Maximum amount of physical memory that can be allocated in the container")
    @DataAmount
    public long memoryLimit;

    @Label("Memory and Swap Limit")
    @Description("Maximum amount of physical memory and swap space, in bytes, that can be allocated in the container")
    @DataAmount
    public long swapMemoryLimit;
}
