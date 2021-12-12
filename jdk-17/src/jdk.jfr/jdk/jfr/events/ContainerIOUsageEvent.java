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


@Name(Type.EVENT_NAME_PREFIX + "ContainerIOUsage")
@Label("Container IO Usage")
@Category({"Operating System", "File System"})
@Description("Container IO usage related information")
public class ContainerIOUsageEvent extends AbstractJDKEvent {

  @Label("Block IO Request Count")
  @Description("Number of block IO requests to the disk that have been issued by the container")
  public long serviceRequests;

  @Label("Block IO Transfer")
  @Description("Number of block IO bytes that have been transferred to/from the disk by the container")
  @DataAmount
  public long dataTransferred;
}
