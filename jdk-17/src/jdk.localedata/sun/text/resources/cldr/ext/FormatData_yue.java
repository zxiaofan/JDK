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

public class FormatData_yue extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "1\u6708",
               "2\u6708",
               "3\u6708",
               "4\u6708",
               "5\u6708",
               "6\u6708",
               "7\u6708",
               "8\u6708",
               "9\u6708",
               "10\u6708",
               "11\u6708",
               "12\u6708",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "\u661f\u671f\u65e5",
               "\u661f\u671f\u4e00",
               "\u661f\u671f\u4e8c",
               "\u661f\u671f\u4e09",
               "\u661f\u671f\u56db",
               "\u661f\u671f\u4e94",
               "\u661f\u671f\u516d",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "\u65e5",
               "\u4e00",
               "\u4e8c",
               "\u4e09",
               "\u56db",
               "\u4e94",
               "\u516d",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "\u7b2c1\u5b63",
               "\u7b2c2\u5b63",
               "\u7b2c3\u5b63",
               "\u7b2c4\u5b63",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "\u4e0a\u5348",
               "\u4e0b\u5348",
               "\u5348\u591c",
               "",
               "\u6e05\u6668",
               "\u671d\u65e9",
               "\u4e2d\u5348",
               "\u4e0b\u665d",
               "\u591c\u665a",
               "",
               "\u51cc\u6668",
               "",
            };
        final String[] metaValue_long_Eras = new String[] {
               "\u897f\u5143\u524d",
               "\u897f\u5143",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "ah:mm:ss [zzzz]",
               "ah:mm:ss [z]",
               "ah:mm:ss",
               "ah:mm",
            };
        final String[] metaValue_DateTimePatterns = new String[] {
               "{1} {0}",
               "{1} {0}",
               "{1} {0}",
               "{1} {0}",
            };
        final String[] metaValue_buddhist_MonthNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
               "5",
               "6",
               "7",
               "8",
               "9",
               "10",
               "11",
               "12",
               "",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "\u4f5b\u66c6",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "Gy\u5e74M\u6708d\u65e5EEEE",
               "Gy\u5e74M\u6708d\u65e5",
               "Gy\u5e74M\u6708d\u65e5",
               "Gy/M/d",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "GGGGy\u5e74M\u6708d\u65e5EEEE",
               "GGGGy\u5e74M\u6708d\u65e5",
               "GGGGy\u5e74M\u6708d\u65e5",
               "GGGGy/M/d",
            };
        final String[] metaValue_java_time_japanese_long_Eras = new String[] {
               "\u897f\u5143",
               "\u660e\u6cbb",
               "\u5927\u6b63",
               "\u662d\u548c",
               "\u5e73\u6210",
               "\u4ee4\u548c",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "\u6c11\u570b\u524d",
               "\u6c11\u570b",
            };
        final String[] metaValue_islamic_MonthNames = new String[] {
               "\u7a46\u54c8\u862d\u59c6\u6708",
               "\u8272\u6cd5\u723e\u6708",
               "\u8cf4\u6bd4\u6708 I",
               "\u8cf4\u6bd4\u6708 II",
               "\u4e3b\u99ac\u9054\u6708 I",
               "\u4e3b\u99ac\u9054\u6708 II",
               "\u8cf4\u54f2\u535c\u6708",
               "\u820d\u723e\u90a6\u6708",
               "\u8cf4\u8cb7\u4e39\u6708",
               "\u9583\u74e6\u9b6f\u6708",
               "\u90fd\u723e\u5580\u723e\u5fb7\u6708",
               "\u90fd\u723e\u9ed1\u54f2\u6708",
               "",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "\u4f0a\u65af\u862d\u66c6",
            };
        final String metaValue_calendarname_gregorian = "\u516c\u66c6";
        final String[] metaValue_short_CompactNumberPatterns = new String[] {
               "",
               "",
               "",
               "{other:0}",
               "{other:0\u842c}",
               "{other:00\u842c}",
               "{other:000\u842c}",
               "{other:0000\u842c}",
               "{other:0\u5104}",
               "{other:00\u5104}",
               "{other:000\u5104}",
               "{other:0000\u5104}",
               "{other:0\u5146}",
               "{other:00\u5146}",
               "{other:000\u5146}",
            };
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\u5e74" },
            { "calendarname.islamic-umalqura", "\u70cf\u59c6\u5eab\u62c9\u66c6" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "calendarname.islamic-civil", "\u4f0a\u65af\u862d\u6c11\u7528\u66c6" },
            { "islamic.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_long_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0}\u6a19\u6e96\u6642\u9593" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "\u65e5\u672c\u66c6" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayNames },
            { "roc.MonthAbbreviations", metaValue_MonthNames },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras", metaValue_long_Eras },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthNames },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns", metaValue_DateTimePatterns },
            { "narrow.AmPmMarkers", metaValue_AmPmMarkers },
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
                    "\u975e\u6578\u503c",
                    "",
                    "",
                }
            },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "\u5206\u9418" },
            { "japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "field.era", "\u5e74\u4ee3" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "\u4e0a\u5348/\u4e0b\u5348" },
            { "islamic.MonthNames", metaValue_islamic_MonthNames },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "\u6c11\u570b\u66c6" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterNames },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "\u6708" },
            { "java.time.japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "\u79d2" },
            { "DayAbbreviations", metaValue_DayNames },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns",
                new String[] {
                    "GGGGy\u5e74M\u6708d\u65e5 EEEE",
                    "GGGGy\u5e74M\u6708d\u65e5",
                    "GGGGy\u5e74M\u6708d\u65e5",
                    "GGGGy/M/d",
                }
            },
            { "calendarname.islamic", "\u4f0a\u65af\u862d\u66c6" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;night1:00:00-05:00;morning2:08:00-12:00;afternoon1:12:00-13:00;morning1:05:00-08:00;afternoon2:13:00-19:00;evening1:19:00-24:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthNames },
            { "long.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "timezone.regionFormat", "{0}\u6642\u9593" },
            { "roc.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.DayAbbreviations", metaValue_DayNames },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "hanidec.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "",
                }
            },
            { "field.zone", "\u6642\u5340" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterNames },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_long_Eras },
            { "hanidec.NumberElements",
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
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "\u9031\u5929" },
            { "japanese.MonthAbbreviations", metaValue_MonthNames },
            { "islamic.DayAbbreviations", metaValue_DayNames },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterNames },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayNames },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "java.time.japanese.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "\u9031" },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "buddhist.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.roc.DatePatterns",
                new String[] {
                    "Gy\u5e74M\u6708d\u65e5 EEEE",
                    "Gy\u5e74M\u6708d\u65e5",
                    "Gy\u5e74M\u6708d\u65e5",
                    "Gy/M/d",
                }
            },
            { "short.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "{0}\u590f\u4ee4\u6642\u9593" },
            { "DatePatterns",
                new String[] {
                    "y\u5e74M\u6708d\u65e5 EEEE",
                    "y\u5e74M\u6708d\u65e5",
                    "y\u5e74M\u6708d\u65e5",
                    "y/M/d",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayNames },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "japanese.DateTimePatterns", metaValue_DateTimePatterns },
            { "MonthAbbreviations", metaValue_MonthNames },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "\u5c0f\u6642" },
            { "islamic.MonthAbbreviations", metaValue_islamic_MonthNames },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "\u4f5b\u66c6" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterNames },
            { "japanese.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
