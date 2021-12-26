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

public class FormatData_eu extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "urtarrilak",
               "otsailak",
               "martxoak",
               "apirilak",
               "maiatzak",
               "ekainak",
               "uztailak",
               "abuztuak",
               "irailak",
               "urriak",
               "azaroak",
               "abenduak",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "urt.",
               "ots.",
               "mar.",
               "api.",
               "mai.",
               "eka.",
               "uzt.",
               "abu.",
               "ira.",
               "urr.",
               "aza.",
               "abe.",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "U",
               "O",
               "M",
               "A",
               "M",
               "E",
               "U",
               "A",
               "I",
               "U",
               "A",
               "A",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "igandea",
               "astelehena",
               "asteartea",
               "asteazkena",
               "osteguna",
               "ostirala",
               "larunbata",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "ig.",
               "al.",
               "ar.",
               "az.",
               "og.",
               "or.",
               "lr.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "I",
               "A",
               "A",
               "A",
               "O",
               "O",
               "L",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. hiruhilekoa",
               "2. hiruhilekoa",
               "3. hiruhilekoa",
               "4. hiruhilekoa",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1Hh",
               "2Hh",
               "3Hh",
               "4Hh",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "gauerdia",
               "",
               "goizaldeko",
               "goizeko",
               "eguerdiko",
               "arratsaldeko",
               "iluntzeko",
               "",
               "gaueko",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "g",
               "a",
               "gauerdia",
               "",
               "goizald.",
               "goizeko",
               "eguerd.",
               "arrats.",
               "iluntz.",
               "",
               "gaueko",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "gauerdia",
               "",
               "goizald.",
               "goizeko",
               "eguerd.",
               "arrats.",
               "iluntz.",
               "",
               "gaueko",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "K.a.",
               "K.o.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss (zzzz)",
               "HH:mm:ss (z)",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "BG",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "G. 'aroko' y. 'urteko' MMMM d, EEEE",
               "G. 'aroko' y. 'urteko' MMMM d",
               "G. 'aroko' y('e')'ko' MMM d",
               "GGGGG y-MM-dd",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "GGGG. 'aroko' y. 'urteko' MMMM d, EEEE",
               "GGGG. 'aroko' y. 'urteko' MMMM d",
               "GGGG. 'aroko' y('e')'ko' MMM d",
               "G y-MM-dd",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "R.O.C. aurretik",
               "R.O.C.",
            };
        final String metaValue_calendarname_gregorian = "Egutegi gregoriarra";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "urtea" },
            { "arabext.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a",
                    "\u06f0",
                    "#",
                    "\u200e-\u200e",
                    "\u00d7\u06f1\u06f0^",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Islamiar egutegi zibila" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0}(e)ko ordu estandarra" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "Japoniar egutegia" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "K.a.",
                    "Kristo ondoren",
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
                    ",",
                    ".",
                    ";",
                    "%",
                    "0",
                    "#",
                    "\u2212",
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
            { "field.minute", "minutua" },
            { "field.era", "aroa" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "arab.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a\u061c",
                    "\u0660",
                    "#",
                    "-",
                    "\u0627\u0633",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "calendarname.roc", "Minguo egutegia" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "hilabetea" },
            { "arabext.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "",
                }
            },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "segundoa" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Islamiar egutegia" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;night1:21:00-24:00;morning2:06:00-12:00;afternoon1:12:00-14:00;morning1:00:00-06:00;afternoon2:14:00-19:00;evening1:19:00-21:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "{0} aldeko ordua" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0 other:0}",
                    "{one:0 other:0}",
                    "{one:0 other:0}",
                    "{one:0' 'milioi other:0' 'milioi}",
                    "{one:00' 'milioi other:00' 'milioi}",
                    "{one:000' 'milioi other:000' 'milioi}",
                    "{one:0000' 'milioi other:0000' 'milioi}",
                    "{one:00000' 'milioi other:00000' 'milioi}",
                    "{one:000000' 'milioi other:000000' 'milioi}",
                    "{one:0' 'bilioi other:0' 'bilioi}",
                    "{one:00' 'bilioi other:00' 'bilioi}",
                    "{one:000' 'bilioi other:000' 'bilioi}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.zone", "ordu-zona" },
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
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "asteguna" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "astea" },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0 other:0}",
                    "{one:0 other:0}",
                    "{one:0 other:0}",
                    "{one:0\u00a0M other:0\u00a0M}",
                    "{one:00\u00a0M other:00\u00a0M}",
                    "{one:000\u00a0M other:000\u00a0M}",
                    "{one:0000\u00a0M other:0000\u00a0M}",
                    "{one:00000\u00a0M other:00000\u00a0M}",
                    "{one:000000\u00a0M other:000000\u00a0M}",
                    "{one:0\u00a0B other:0\u00a0B}",
                    "{one:00\u00a0B other:00\u00a0B}",
                    "{one:000\u00a0B other:000\u00a0B}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "{0} (udako ordua)" },
            { "DatePatterns",
                new String[] {
                    "y('e')'ko' MMMM'ren' d('a'), EEEE",
                    "y('e')'ko' MMMM'ren' d('a')",
                    "y('e')'ko' MMM d('a')",
                    "yy/M/d",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "field.hour", "ordua" },
            { "calendarname.buddhist", "Egutegi budista" },
            { "standalone.MonthNames",
                new String[] {
                    "urtarrila",
                    "otsaila",
                    "martxoa",
                    "apirila",
                    "maiatza",
                    "ekaina",
                    "uztaila",
                    "abuztua",
                    "iraila",
                    "urria",
                    "azaroa",
                    "abendua",
                    "",
                }
            },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "%\u00a0#,##0",
                    "#,##0.00\u00a0\u00a4;(#,##0.00\u00a0\u00a4)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
