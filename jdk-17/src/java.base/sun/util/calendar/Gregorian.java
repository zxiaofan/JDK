/*
 * Copyright (c) 2000, 2005, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.calendar;

import java.util.TimeZone;

/**
 * Gregorian calendar implementation.
 *
 * @author Masayoshi Okutsu
 * @since 1.5
 */

public class Gregorian extends BaseCalendar {

    static class Date extends BaseCalendar.Date {
        protected Date() {
            super();
        }

        protected Date(TimeZone zone) {
            super(zone);
        }

        public int getNormalizedYear() {
            return getYear();
        }

        public void setNormalizedYear(int normalizedYear) {
            setYear(normalizedYear);
        }
    }

    Gregorian() {
    }

    public String getName() {
        return "gregorian";
    }

    public Date getCalendarDate() {
        return getCalendarDate(System.currentTimeMillis(), newCalendarDate());
    }

    public Date getCalendarDate(long millis) {
        return getCalendarDate(millis, newCalendarDate());
    }

    public Date getCalendarDate(long millis, CalendarDate date) {
        return (Date) super.getCalendarDate(millis, date);
    }

    public Date getCalendarDate(long millis, TimeZone zone) {
        return getCalendarDate(millis, newCalendarDate(zone));
    }

    public Date newCalendarDate() {
        return new Date();
    }

    public Date newCalendarDate(TimeZone zone) {
        return new Date(zone);
    }
}
