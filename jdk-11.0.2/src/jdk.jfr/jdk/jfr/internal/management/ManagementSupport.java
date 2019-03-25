/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.internal.management;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import jdk.jfr.EventType;
import jdk.jfr.internal.JVMSupport;
import jdk.jfr.internal.LogLevel;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;
import jdk.jfr.internal.MetadataRepository;
import jdk.jfr.internal.Utils;
import jdk.jfr.internal.instrument.JDKEvents;

/**
 * The management API in module jdk.management.jfr should be built on top of the
 * public API in jdk.jfr. Before putting more functionality here, consider if it
 * should not be part of the public API, and if not, please provide motivation
 *
 */
public final class ManagementSupport {

    // Purpose of this method is to expose the event types to the
    // FlightRecorderMXBean without instantiating Flight Recorder.
    //
    // This allows:
    //
    // 1) discoverability, so event settings can be exposed without the need to
    // create a new Recording in FlightrecorderMXBean.
    //
    // 2) a graphical JMX client to list all attributes to the user, without
    // loading JFR memory buffers. This is especially important when there is
    // no intent to use Flight Recorder.
    //
    // An alternative design would be to make FlightRecorder#getEventTypes
    // static, but it would the make the API look strange
    //
    public static List<EventType> getEventTypes() {
        // would normally be checked when a Flight Recorder instance is created
        Utils.checkAccessFlightRecorder();
        if (JVMSupport.isNotAvailable()) {
            return new ArrayList<>();
        }
        JDKEvents.initialize(); // make sure JDK events are available
        return Collections.unmodifiableList(MetadataRepository.getInstance().getRegisteredEventTypes());
    }

    // Reuse internal code for parsing a timespan
    public static long parseTimespan(String s) {
        return Utils.parseTimespan(s);
    }

    // Reuse internal code for formatting settings
    public static final String formatTimespan(Duration dValue, String separation) {
        return Utils.formatTimespan(dValue, separation);
    }

    // Reuse internal logging mechanism
    public static void logError(String message) {
        Logger.log(LogTag.JFR, LogLevel.ERROR, message);
    }
}
