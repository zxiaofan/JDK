/*
 * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */

/*
 * COPYRIGHT AND PERMISSION NOTICE
 *
 * Copyright (c) 1991-2020 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in https://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that either
 * (a) this copyright and permission notice appear with all copies
 * of the Data Files or Software, or
 * (b) this copyright and permission notice appear in associated
 * Documentation.
 *
 * THE DATA FILES AND SOFTWARE ARE PROVIDED "AS IS", WITHOUT WARRANTY OF
 * ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT OF THIRD PARTY RIGHTS.
 * IN NO EVENT SHALL THE COPYRIGHT HOLDER OR HOLDERS INCLUDED IN THIS
 * NOTICE BE LIABLE FOR ANY CLAIM, OR ANY SPECIAL INDIRECT OR CONSEQUENTIAL
 * DAMAGES, OR ANY DAMAGES WHATSOEVER RESULTING FROM LOSS OF USE,
 * DATA OR PROFITS, WHETHER IN AN ACTION OF CONTRACT, NEGLIGENCE OR OTHER
 * TORTIOUS ACTION, ARISING OUT OF OR IN CONNECTION WITH THE USE OR
 * PERFORMANCE OF THE DATA FILES OR SOFTWARE.
 *
 * Except as contained in this notice, the name of a copyright holder
 * shall not be used in advertising or otherwise to promote the sale,
 * use or other dealings in these Data Files or Software without prior
 * written authorization of the copyright holder.
 */

package sun.text.resources.cldr.ext;

import java.util.ListResourceBundle;

public class FormatData_fil extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Enero",
               "Pebrero",
               "Marso",
               "Abril",
               "Mayo",
               "Hunyo",
               "Hulyo",
               "Agosto",
               "Setyembre",
               "Oktubre",
               "Nobyembre",
               "Disyembre",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Ene",
               "Peb",
               "Mar",
               "Abr",
               "May",
               "Hun",
               "Hul",
               "Ago",
               "Set",
               "Okt",
               "Nob",
               "Dis",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Linggo",
               "Lunes",
               "Martes",
               "Miyerkules",
               "Huwebes",
               "Biyernes",
               "Sabado",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Lin",
               "Lun",
               "Mar",
               "Miy",
               "Huw",
               "Biy",
               "Sab",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "ika-1 quarter",
               "ika-2 quarter",
               "ika-3 quarter",
               "ika-4 na quarter",
            };
        final String[] metaValue_standalone_QuarterAbbreviations = new String[] {
               "Q1",
               "Q2",
               "Q3",
               "Q4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "hatinggabi",
               "tanghaling-tapat",
               "nang umaga",
               "madaling-araw",
               "tanghali",
               "",
               "ng hapon",
               "",
               "ng gabi",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "am",
               "pm",
               "hatinggabi",
               "tanghaling-tapat",
               "umaga",
               "madaling-araw",
               "sa hapon",
               "",
               "sa gabi",
               "",
               "gabi",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "hatinggabi",
               "tanghaling-tapat",
               "nang umaga",
               "madaling-araw",
               "tanghali",
               "",
               "ng hapon",
               "",
               "gabi",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "BC",
               "AD",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_DateTimePatterns = new String[] {
               "{1} 'nang' {0}",
               "{1} 'nang' {0}",
               "{1}, {0}",
               "{1}, {0}",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "BE",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, MMMM d, y G",
               "MMMM d, y G",
               "MMM d, y G",
               "M/d/y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, MMMM d, y GGGG",
               "MMMM d, y GGGG",
               "MMM d, y GGGG",
               "M/d/y G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "Bago ang R.O.C.",
               "Minguo",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "Gregorian na Kalendaryo";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "taon" },
            { "calendarname.islamic-umalqura", "Kalendaryong Islamiko (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthAbbreviations },
            { "calendarname.islamic-civil", "Kalendaryong Islamic-Civil" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "Standard na Oras sa {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "Kalendaryong Japanese" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras",
                new String[] {
                    "Before Christ",
                    "Anno Domini",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns", metaValue_DateTimePatterns },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "latn.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "0",
                    "#",
                    "-",
                    "E",
                    "\u2030",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthAbbreviations },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minuto" },
            { "field.era", "panahon" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows",
                new String[] {
                    "E",
                    "P",
                    "M",
                    "A",
                    "M",
                    "Hun",
                    "Hul",
                    "Ago",
                    "Set",
                    "Okt",
                    "Nob",
                    "Dis",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Kalendaryong Minguo" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "buwan" },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "segundo" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayAbbreviations },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Kalendaryong Islamic" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:18:00-24:00;morning2:06:00-12:00;afternoon1:12:00-16:00;morning1:00:00-06:00;evening1:16:00-18:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Oras sa {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'libo other:0' 'na' 'libo}",
                    "{one:00' 'libo other:00' 'na' 'libo}",
                    "{one:000' 'libo other:000' 'na' 'libo}",
                    "{one:0' 'milyon other:0' 'na' 'milyon}",
                    "{one:00' 'milyon other:00' 'na' 'milyon}",
                    "{one:000' 'milyon other:000' 'na' 'milyon}",
                    "{one:0' 'bilyon other:0' 'na' 'bilyon}",
                    "{one:00' 'bilyon other:00' 'na' 'bilyon}",
                    "{one:000' 'bilyon other:000' 'na' 'bilyon}",
                    "{one:0' 'trilyon other:0' 'na' 'trilyon}",
                    "{one:00' 'trilyon other:00' 'na' 'trilyon}",
                    "{one:000' 'trilyon other:000' 'na' 'trilyon}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthAbbreviations },
            { "islamic.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "standalone.DayNarrows", metaValue_DayAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayAbbreviations },
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.zone", "time zone" },
            { "japanese.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.DateTimePatterns", metaValue_DateTimePatterns },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "araw ng linggo" },
            { "islamic.DateTimePatterns", metaValue_DateTimePatterns },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "linggo" },
            { "buddhist.DateTimePatterns", metaValue_DateTimePatterns },
            { "buddhist.MonthNarrows", metaValue_MonthAbbreviations },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayAbbreviations },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0K other:0K}",
                    "{one:00K other:00K}",
                    "{one:000K other:000K}",
                    "{one:0M other:0M}",
                    "{one:00M other:00M}",
                    "{one:000M other:000M}",
                    "{one:0B other:0B}",
                    "{one:00B other:00B}",
                    "{one:000B other:000B}",
                    "{one:0T other:0T}",
                    "{one:00T other:00T}",
                    "{one:000T other:000T}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "Daylight Time ng {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, MMMM d, y",
                    "MMMM d, y",
                    "MMM d, y",
                    "M/d/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:v = 0 and i = 1,2,3 or v = 0 and i % 10 != 4,6,9 or v != 0 and f % 10 != 4,6,9" },
            { "field.hour", "oras" },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "Kalendaryo ng Buddhist" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayAbbreviations },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.DayNarrows", metaValue_DayAbbreviations },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
