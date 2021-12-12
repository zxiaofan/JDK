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
package jdk.jfr.internal.consumer;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashSet;
import java.util.Set;

import jdk.jfr.EventType;
import jdk.jfr.FlightRecorder;
import jdk.jfr.consumer.EventStream;
import jdk.jfr.consumer.RecordedEvent;
import jdk.jfr.internal.LogLevel;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;
import jdk.jfr.internal.PlatformEventType;
import jdk.jfr.internal.PrivateAccess;
import jdk.jfr.internal.tool.PrettyWriter;


public final class EventLog {
    private static final class LogWriter extends Writer {
        private final StringBuilder builder = new StringBuilder();
        private LogLevel level = LogLevel.WARN;
        private boolean system;

        public void setSystem(boolean system) {
            this.system = system;
        }

        public void setLevel(LogLevel level) {
            this.level = level;
        }

        @Override
        public void write(char[] buffer, int off, int len) throws IOException {
            builder.append(buffer, off, len);
        }

        @Override
        public void flush() throws IOException {
            String[] lines = builder.toString().split("\n");
            builder.setLength(0);
            Logger.logEvent(level, lines, system);
        }

        @Override
        public void close() throws IOException {
            // ignore
        }
    }

    private static EventStream logStream;
    private static PrettyWriter prettyWriter;
    private static LogWriter logWriter;
    private static Set<Long> systemEventLookup;

    // 1) At least one disk recording must be running
    //    before calling this method
    // 2) Caller must hold PlatformRecorder lock
    public static void update() {
        boolean shouldLog = shouldLog();
        if (shouldLog && !isLogging()) {
            start();
            return;
        }
        if (!shouldLog && isLogging()) {
            stop();
            return;
        }
    }

    // 1) At least one disk recording must be running
    //    before calling this method
    // 2) Caller must hold PlatformRecorder lock
    public static void start() {
        if (logStream != null) {
            return;
        }
        try {
            ensureSystemEventLookup();
            logStream = EventStream.openRepository();
            ((AbstractEventStream)logStream).setDaemon(true);
            logStream.onEvent(EventLog::log);
            logWriter = new LogWriter();
            prettyWriter = new PrettyWriter(new PrintWriter(logWriter));
            prettyWriter.setLineSeparator("\n");
            logStream.startAsync();
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.DEBUG, "Log stream started");
        } catch (Exception e) {
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.WARN, "Unable to print events to the log");
        }
    }

    // Caller must hold PlatformRecorder lock
    public static void stop() {
        if (logStream == null) {
            return;
        }
        try {
            logStream.close();
            logStream = null;
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.DEBUG, "Log stream stopped");
        } catch (Exception e) {
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.WARN, "Unable to stop printing events to the log");
        }
    }

    public static boolean shouldLog() {
        if (Logger.shouldLog(LogTag.JFR_EVENT, LogLevel.DEBUG)) {
            return true;
        }
        if (Logger.shouldLog(LogTag.JFR_SYSTEM_EVENT, LogLevel.DEBUG)) {
            return true;
        }
        return false;
    }

    private static void log(RecordedEvent event) {
        boolean system = isSystemEvent(event);
        LogTag tag = system ? LogTag.JFR_SYSTEM_EVENT : LogTag.JFR_EVENT;
        LogLevel level = tag.level();
        if (Logger.shouldLog(tag, LogLevel.TRACE)) {
            log(event, 64, level, system);
            return;
        }

        if (Logger.shouldLog(tag, LogLevel.DEBUG)) {
            log(event, 5, level, system);
            return;
        }
    }

    private static void log(RecordedEvent event, int stackDepth, LogLevel level, boolean system) {
        logWriter.setSystem(system);
        logWriter.setLevel(level);
        prettyWriter.setStackDepth(stackDepth);
        prettyWriter.print(event);
        prettyWriter.flush(true);
        try {
            logWriter.flush();
        } catch (IOException e) {
            Logger.log(LogTag.JFR_SYSTEM, LogLevel.WARN, "Unable to print event to the log");
        }
    }

    private static boolean isSystemEvent(RecordedEvent event) {
        return systemEventLookup.contains(event.getEventType().getId());
    }

    // The file format doesn't contains information if an event is
    // from the JDK/JVM, besides the prefix "jdk." which is not reliable
    // Therefore, create a lookup by event type ID to see if is a JDK/JVM event.
    private static void ensureSystemEventLookup() {
        if (systemEventLookup == null) {
            systemEventLookup = new HashSet<>();
            for (EventType type : FlightRecorder.getFlightRecorder().getEventTypes()) {
                PlatformEventType pe = PrivateAccess.getInstance().getPlatformEventType(type);
                if (pe.isSystem()) {
                    systemEventLookup.add(pe.getId());
                }
            }
        }
    }

    private static boolean isLogging() {
        return logStream != null;
    }
}
