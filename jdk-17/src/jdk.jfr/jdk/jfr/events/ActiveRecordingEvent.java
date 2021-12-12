/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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
import jdk.jfr.Label;
import jdk.jfr.DataAmount;
import jdk.jfr.Name;
import jdk.jfr.StackTrace;
import jdk.jfr.Timespan;
import jdk.jfr.Timestamp;
import jdk.jfr.internal.Type;

@Name(Type.EVENT_NAME_PREFIX + "ActiveRecording")
@Label("Flight Recording")
@Category("Flight Recorder")
@StackTrace(false)
public final class ActiveRecordingEvent extends AbstractJDKEvent {

    // To be accessed when holding recorder lock
    public static final ActiveRecordingEvent EVENT = new ActiveRecordingEvent();

    @Label("Id")
    public long id;

    @Label("Name")
    public String name;

    @Label("Destination")
    public String destination;

    @Label("Max Age")
    @Timespan(Timespan.MILLISECONDS)
    public long maxAge;

    @Label("Flush Interval")
    @Timespan(Timespan.MILLISECONDS)
    public long flushInterval;

    @Label("Max Size")
    @DataAmount
    public long maxSize;

    @Label("Start Time")
    @Timestamp(Timestamp.MILLISECONDS_SINCE_EPOCH)
    public long recordingStart;

    @Label("Recording Duration")
    @Timespan(Timespan.MILLISECONDS)
    public long recordingDuration;
}
