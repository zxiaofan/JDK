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

package sun.security.util;

/**
 * This class implements an event model with services for reporter and listener.
 * Reporter uses report() method to generate an event.
 * Listener uses setReportListener() to register for listening to an event,
 * and uses clearReportListener() to unregister a listening session.
 * Listener should implement the event handling of the Reporter interface.
 */
public final class Event {
    private Event() {}

    public enum ReporterCategory {
        CRLCHECK(),
        ZIPFILEATTRS();

        private Reporter reporter;
    }

    public interface Reporter {
        public void handle(String type, Object... args);
    }

    public static void setReportListener(ReporterCategory cat, Reporter re) {
        cat.reporter = re;
    }

    public static void clearReportListener(ReporterCategory cat) {
        cat.reporter = null;
    }

    public static void report(ReporterCategory cat, String type, Object... args) {
        Reporter currentReporter = cat.reporter;

        if (currentReporter != null) {
            currentReporter.handle(type, args);
        }
    }
}
