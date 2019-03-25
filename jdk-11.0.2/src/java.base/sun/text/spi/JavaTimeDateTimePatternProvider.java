/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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



package sun.text.spi;

import java.util.Locale;
import java.util.spi.LocaleServiceProvider;

/**
 * Service Provider Interface for retrieving DateTime patterns from
 * specified Locale provider for java.time.
 */

public abstract class JavaTimeDateTimePatternProvider extends LocaleServiceProvider {

    protected JavaTimeDateTimePatternProvider() {
    }

    /**
     * Gets the formatting pattern for a timeStyle
     * dateStyle, calendarType and locale.
     * Concrete implementation of this method will retrieve
     * a java.time specific dateTime Pattern from selected Locale Provider.
     *
     * @param timeStyle an {@code int} value representing FormatStyle constant, -1
     * for date-only pattern
     * @param dateStyle an {@code int} value,representing FormatStyle constant, -1
     * for time-only pattern
     * @param locale {@code locale}, non-null
     * @param calType a {@code String},non-null representing CalendarType such as "japanese",
     * "iso8601"
     * @return  formatting pattern {@code String}
     * @see java.time.format.DateTimeFormatterBuilder#convertStyle(java.time.format.FormatStyle)
     * @since 9
     */
    public abstract String getJavaTimeDateTimePattern(int timeStyle, int dateStyle, String calType, Locale locale);
}
