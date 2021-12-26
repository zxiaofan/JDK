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

public class FormatData_en_CA extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan.",
               "Feb.",
               "Mar.",
               "Apr.",
               "May",
               "Jun.",
               "Jul.",
               "Aug.",
               "Sep.",
               "Oct.",
               "Nov.",
               "Dec.",
               "",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Sun.",
               "Mon.",
               "Tue.",
               "Wed.",
               "Thu.",
               "Fri.",
               "Sat.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "midnight",
               "noon",
               "in the morning",
               "",
               "in the afternoon",
               "",
               "in the evening",
               "",
               "at night",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "am",
               "pm",
               "mid",
               "n",
               "mor",
               "",
               "aft",
               "",
               "eve",
               "",
               "night",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "mi",
               "n",
               "in the morning",
               "",
               "in the afternoon",
               "",
               "in the evening",
               "",
               "at night",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, MMMM d, y G",
               "MMMM d, y G",
               "MMM d, y G",
               "GGGGG y-MM-dd",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, MMMM d, y GGGG",
               "MMMM d, y GGGG",
               "MMM d, y GGGG",
               "G y-MM-dd",
            };
        final Object[][] data = new Object[][] {
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "timezone.regionFormat.daylight", "{0} Daylight Saving Time" },
            { "DatePatterns",
                new String[] {
                    "EEEE, MMMM d, y",
                    "MMMM d, y",
                    "MMM d, y",
                    "y-MM-dd",
                }
            },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'at' {0}",
                    "{1} 'at' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
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
                    "e",
                    "\u2030",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "field.dayperiod", "a.m./p.m." },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
        };
        return data;
    }
}
