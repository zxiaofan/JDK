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

@Name(Type.EVENT_NAME_PREFIX + "ContainerCPUThrottling")
@Label("CPU Throttling")
@Category({"Operating System", "Processor"})
@Description("Container CPU throttling related information")
public class ContainerCPUThrottlingEvent extends AbstractJDKEvent {
  @Label("CPU Elapsed Slices")
  @Description("Number of time-slice periods that have elapsed if a CPU quota has been setup for the container")
  public long cpuElapsedSlices;

  @Label("CPU Throttled Slices")
  @Description("Number of time-slice periods that the CPU has been throttled or limited due to exceeding CPU quota")
  public long cpuThrottledSlices;

  @Label("CPU Throttled Time")
  @Description("Total time duration, in nanoseconds, that the CPU has been throttled or limited due to exceeding CPU quota")
  @Timespan
  public long cpuThrottledTime;
}
