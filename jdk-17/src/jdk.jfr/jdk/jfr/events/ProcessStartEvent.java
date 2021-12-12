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

import jdk.jfr.Category;
import jdk.jfr.Description;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.internal.MirrorEvent;

@Category({"Operating System"})
@Label("Process Start")
@Name("jdk.ProcessStart")
@Description("Operating system process started")
@MirrorEvent(className = "jdk.internal.event.ProcessStartEvent")
public final class ProcessStartEvent extends AbstractJDKEvent {
    @Label("Process Id")
    public long pid;

    @Label("Directory")
    public String directory;

    @Label("Command")
    public String command;
}
