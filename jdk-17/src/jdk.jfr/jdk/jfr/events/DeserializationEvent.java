/*
 * Copyright (c) 2021, Oracle and/or its affiliates. All rights reserved.
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

@Category({"Java Development Kit", "Serialization"})
@Label("Deserialization")
@Name("jdk.Deserialization")
@Description("Results of deserialization and ObjectInputFilter checks")
@MirrorEvent(className = "jdk.internal.event.DeserializationEvent")
public final class DeserializationEvent extends AbstractJDKEvent {

    @Label("Filter Configured")
    public boolean filterConfigured;

    @Label("Filter Status")
    public String filterStatus;

    @Label ("Type")
    public Class<?> type;

    @Label ("Array Length")
    public int arrayLength;

    @Label ("Object References")
    public long objectReferences;

    @Label ("Depth")
    public long depth;

    @Label ("Bytes Read")
    public long bytesRead;

    @Label ("Exception Type")
    public Class<?> exceptionType;

    @Label ("Exception Message")
    public String exceptionMessage;
}
