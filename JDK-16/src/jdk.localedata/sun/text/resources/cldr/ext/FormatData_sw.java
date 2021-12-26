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

public class FormatData_sw extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Januari",
               "Februari",
               "Machi",
               "Aprili",
               "Mei",
               "Juni",
               "Julai",
               "Agosti",
               "Septemba",
               "Oktoba",
               "Novemba",
               "Desemba",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan",
               "Feb",
               "Mac",
               "Apr",
               "Mei",
               "Jun",
               "Jul",
               "Ago",
               "Sep",
               "Okt",
               "Nov",
               "Des",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "J",
               "F",
               "M",
               "A",
               "M",
               "J",
               "J",
               "A",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Jumapili",
               "Jumatatu",
               "Jumanne",
               "Jumatano",
               "Alhamisi",
               "Ijumaa",
               "Jumamosi",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "Robo ya 1",
               "Robo ya 2",
               "Robo ya 3",
               "Robo ya 4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "saa sita za usiku",
               "saa sita za mchana",
               "alfajiri",
               "asubuhi",
               "mchana",
               "",
               "jioni",
               "",
               "usiku",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "am",
               "pm",
               "usiku",
               "mchana",
               "alfajiri",
               "asubuhi",
               "mchana",
               "",
               "jioni",
               "",
               "usiku",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "saa sita za usiku",
               "adhuhuri",
               "alfajiri",
               "asubuhi",
               "mchana",
               "",
               "jioni",
               "",
               "usiku",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "KK",
               "BK",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_DayNarrows = new String[] {
               "S",
               "M",
               "T",
               "W",
               "T",
               "F",
               "S",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y G",
               "d MMMM y G",
               "d MMM y G",
               "dd/MM/y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y GGGG",
               "d MMMM y GGGG",
               "d MMM y GGGG",
               "dd/MM/y G",
            };
        final String metaValue_calendarname_gregorian = "Kalenda ya Kigregori";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "mwaka" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.gmtFormat", "GMT {0}" },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Kalenda ya Kiislamu/Rasmi" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "Saa za wastani za {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "Kalenda ya Kijapani" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayNames },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "Kabla ya Kristo",
                    "Baada ya Kristo",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
                }
            },
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
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "dakika" },
            { "field.era", "enzi" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Kalenda ya Jamhuri ya Uchina" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterNames },
            { "field.month", "mwezi" },
            { "field.second", "sekunde" },
            { "DayAbbreviations", metaValue_DayNames },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Kalenda ya Kiislamu" },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:19:00-04:00;morning2:07:00-12:00;afternoon1:12:00-16:00;morning1:04:00-07:00;evening1:16:00-19:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Saa za {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:elfu' '0;elfu' '-0 other:elfu' '0;elfu' '-0}",
                    "{one:elfu' '00;elfu' '-00 other:elfu' '00;elfu' '-00}",
                    "{one:elfu' '000;elfu' '-000 other:elfu' '000;elfu' '-000}",
                    "{one:milioni' '0;milioni' '-0 other:milioni' '0;milioni' '-0}",
                    "{one:milioni' '00;milioni' '-00 other:milioni' '00;milioni' '-00}",
                    "{one:milioni' '000;milioni' '-000 other:milioni' '000;milioni' '-000}",
                    "{one:bilioni' '0;bilioni' '-0 other:bilioni' '0;bilioni' '-0}",
                    "{one:bilioni' '00;bilioni' '-00 other:bilioni' '00;bilioni' '-00}",
                    "{one:bilioni' '000;bilioni' '-000 other:bilioni' '000;bilioni' '-000}",
                    "{one:trilioni' '0;trilioni' '-0 other:trilioni' '0;trilioni' '-0}",
                    "{one:trilioni' '00;trilioni' '-00 other:trilioni' '00;trilioni' '-00}",
                    "{one:trilioni' '000;trilioni' '-000 other:trilioni' '000;trilioni' '-000}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.DayAbbreviations", metaValue_DayNames },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_buddhist_DayNarrows },
            { "field.zone", "saa za eneo" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterNames },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "siku ya wiki" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayNames },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterNames },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayNames },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "wiki" },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_buddhist_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:elfu\u00a00;elfu\u00a0-0 other:elfu\u00a00;elfu\u00a0-0}",
                    "{one:elfu\u00a000;elfu\u00a0-00 other:elfu\u00a000;elfu\u00a0-00}",
                    "{one:elfu\u00a0000;elfu\u00a0-000 other:elfu\u00a0000;elfu\u00a0-000}",
                    "{one:0M;-0M other:0M}",
                    "{one:00M;-00M other:00M}",
                    "{one:000M;-000M other:000M}",
                    "{one:0B;-0B other:0B;-0B}",
                    "{one:00B;-00B other:00B;-00B}",
                    "{one:000B;-000B other:000B;-000B}",
                    "{one:0T;-0T other:0T}",
                    "{one:00T;-00T other:00T}",
                    "{one:000T;-000T other:000T}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Saa za Mchana za {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd/MM/y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayNames },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 1 and v = 0" },
            { "field.hour", "saa" },
            { "calendarname.buddhist", "Kalenda ya Kibuddha" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4\u00a0#,##0.00",
                }
            },
            { "buddhist.DayNarrows", metaValue_buddhist_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "japanese.DayNarrows", metaValue_buddhist_DayNarrows },
            { "QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
