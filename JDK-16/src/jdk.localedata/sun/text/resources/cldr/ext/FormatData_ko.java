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

public class FormatData_ko extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "1\uc6d4",
               "2\uc6d4",
               "3\uc6d4",
               "4\uc6d4",
               "5\uc6d4",
               "6\uc6d4",
               "7\uc6d4",
               "8\uc6d4",
               "9\uc6d4",
               "10\uc6d4",
               "11\uc6d4",
               "12\uc6d4",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "\uc77c\uc694\uc77c",
               "\uc6d4\uc694\uc77c",
               "\ud654\uc694\uc77c",
               "\uc218\uc694\uc77c",
               "\ubaa9\uc694\uc77c",
               "\uae08\uc694\uc77c",
               "\ud1a0\uc694\uc77c",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "\uc77c",
               "\uc6d4",
               "\ud654",
               "\uc218",
               "\ubaa9",
               "\uae08",
               "\ud1a0",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "\uc81c 1/4\ubd84\uae30",
               "\uc81c 2/4\ubd84\uae30",
               "\uc81c 3/4\ubd84\uae30",
               "\uc81c 4/4\ubd84\uae30",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1\ubd84\uae30",
               "2\ubd84\uae30",
               "3\ubd84\uae30",
               "4\ubd84\uae30",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "\uc624\uc804",
               "\uc624\ud6c4",
               "\uc790\uc815",
               "\uc815\uc624",
               "\uc0c8\ubcbd",
               "\uc624\uc804",
               "\uc624\ud6c4",
               "",
               "\uc800\ub141",
               "",
               "\ubc24",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "\uc790\uc815",
               "\uc815\uc624",
               "\uc0c8\ubcbd",
               "\uc624\uc804",
               "\uc624\ud6c4",
               "",
               "\uc800\ub141",
               "",
               "\ubc24",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "BC",
               "AD",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "a h\uc2dc m\ubd84 s\ucd08 zzzz",
               "a h\uc2dc m\ubd84 s\ucd08 z",
               "a h:mm:ss",
               "a h:mm",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "\ubd88\uae30",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "G y\ub144 M\uc6d4 d\uc77c EEEE",
               "G y\ub144 M\uc6d4 d\uc77c",
               "G y. M. d.",
               "G y. M. d.",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "GGGG y\ub144 M\uc6d4 d\uc77c EEEE",
               "GGGG y\ub144 M\uc6d4 d\uc77c",
               "GGGG y. M. d.",
               "GGGG y. M. d.",
            };
        final String[] metaValue_java_time_japanese_long_Eras = new String[] {
               "\uc11c\uae30",
               "\uba54\uc774\uc9c0",
               "\ub2e4\uc774\uc1fc",
               "\uc1fc\uc640",
               "\ud5e4\uc774\uc138\uc774",
               "\ub808\uc774\uc640",
            };
        final String[] metaValue_java_time_japanese_Eras = new String[] {
               "AD",
               "\uba54\uc774\uc9c0",
               "\ub2e4\uc774\uc1fc",
               "\uc1fc\uc640",
               "\ud5e4\uc774\uc138\uc774",
               "\ub808\uc774\uc640",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "\uc911\ud654\ubbfc\uad6d\uc804",
               "\uc911\ud654\ubbfc\uad6d",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "\ud788\uc988\ub77c\ub825",
            };
        final String[] metaValue_java_time_islamic_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "\uc591\ub825";
        final String[] metaValue_short_CompactNumberPatterns = new String[] {
               "",
               "",
               "",
               "{other:0\ucc9c}",
               "{other:0\ub9cc}",
               "{other:00\ub9cc}",
               "{other:000\ub9cc}",
               "{other:0000\ub9cc}",
               "{other:0\uc5b5}",
               "{other:00\uc5b5}",
               "{other:000\uc5b5}",
               "{other:0000\uc5b5}",
               "{other:0\uc870}",
               "{other:00\uc870}",
               "{other:000\uc870}",
            };
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\ub144" },
            { "calendarname.islamic-umalqura", "\uc774\uc2ac\ub78c\ub825(\uc6c0 \uc54c \ucfe0\ub77c)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNames },
            { "calendarname.islamic-civil", "\uc774\uc2ac\ub78c \uc0c1\uc6a9\ub825" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0} \ud45c\uc900\uc2dc" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "\uc77c\ubcf8\ub825" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthNames },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "long.Eras",
                new String[] {
                    "\uae30\uc6d0\uc804",
                    "\uc11c\uae30",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthNames },
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
            { "MonthNarrows", metaValue_MonthNames },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "\ubd84" },
            { "japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "field.era", "\uc5f0\ud638" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "\uc624\uc804/\uc624\ud6c4" },
            { "standalone.MonthNarrows", metaValue_MonthNames },
            { "islamic.MonthNames",
                new String[] {
                    "\ubb34\ud558\ub78c",
                    "\uc0ac\ud30c\ub974",
                    "\ub77c\ube44 \uc54c \uc544\uc648",
                    "\ub77c\ube44 \uc54c \uc384\ub2c8",
                    "\uc8fc\ub9c8\ub2e4 \uc54c \uc544\uc648",
                    "\uc8fc\ub9c8\ub2e4 \uc54c \uc384\ub2c8",
                    "\ub77c\uc7a1",
                    "\uc250\uc544\ubc18",
                    "\ub77c\ub9c8\ub2e8",
                    "\uc250\uc648",
                    "\ub4c0 \uc54c \uae4c\ub2e4",
                    "\ub4c0 \uc54c \ud788\uc790",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "arab.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a\u061c",
                    "\u0660",
                    "#",
                    "\u200f-",
                    "\u0627\u0633",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "calendarname.roc", "\ub300\ub9cc\ub825" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_Eras },
            { "field.month", "\uc6d4" },
            { "java.time.japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "\ucd08" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayAbbreviations },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "\uc774\uc2ac\ub78c\ub825" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:21:00-03:00;morning2:06:00-12:00;afternoon1:12:00-18:00;morning1:03:00-06:00;evening1:18:00-21:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthNames },
            { "long.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "timezone.regionFormat", "{0} \uc2dc\uac04" },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNames },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "standalone.DayNarrows", metaValue_DayAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayAbbreviations },
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.zone", "\uc2dc\uac04\ub300" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "arab.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "",
                }
            },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "\uc694\uc77c" },
            { "japanese.MonthAbbreviations", metaValue_MonthNames },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "java.time.japanese.Eras", metaValue_java_time_japanese_Eras },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "\uc8fc" },
            { "buddhist.MonthNarrows", metaValue_MonthNames },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayAbbreviations },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "{0} \ud558\uacc4 \ud45c\uc900\uc2dc" },
            { "DatePatterns",
                new String[] {
                    "y\ub144 M\uc6d4 d\uc77c EEEE",
                    "y\ub144 M\uc6d4 d\uc77c",
                    "y. M. d.",
                    "yy. M. d.",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthNames },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "\uc2dc" },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "calendarname.buddhist", "\ubd88\uad50\ub825" },
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
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.Eras", metaValue_java_time_japanese_Eras },
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
