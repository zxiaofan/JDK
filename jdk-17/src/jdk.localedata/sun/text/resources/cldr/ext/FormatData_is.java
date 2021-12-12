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

public class FormatData_is extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "jan\u00faar",
               "febr\u00faar",
               "mars",
               "apr\u00edl",
               "ma\u00ed",
               "j\u00fan\u00ed",
               "j\u00fal\u00ed",
               "\u00e1g\u00fast",
               "september",
               "okt\u00f3ber",
               "n\u00f3vember",
               "desember",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan.",
               "feb.",
               "mar.",
               "apr.",
               "ma\u00ed",
               "j\u00fan.",
               "j\u00fal.",
               "\u00e1g\u00fa.",
               "sep.",
               "okt.",
               "n\u00f3v.",
               "des.",
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
               "\u00c1",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "sunnudagur",
               "m\u00e1nudagur",
               "\u00feri\u00f0judagur",
               "mi\u00f0vikudagur",
               "fimmtudagur",
               "f\u00f6studagur",
               "laugardagur",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "sun.",
               "m\u00e1n.",
               "\u00feri.",
               "mi\u00f0.",
               "fim.",
               "f\u00f6s.",
               "lau.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "M",
               "\u00de",
               "M",
               "F",
               "F",
               "L",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. fj\u00f3r\u00f0ungur",
               "2. fj\u00f3r\u00f0ungur",
               "3. fj\u00f3r\u00f0ungur",
               "4. fj\u00f3r\u00f0ungur",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "F1",
               "F2",
               "F3",
               "F4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "f.h.",
               "e.h.",
               "mi\u00f0n\u00e6tti",
               "h\u00e1degi",
               "a\u00f0 morgni",
               "",
               "s\u00ed\u00f0degis",
               "",
               "a\u00f0 kv\u00f6ldi",
               "",
               "a\u00f0 n\u00f3ttu",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "f.",
               "e.",
               "mn.",
               "h.",
               "mrg.",
               "",
               "sd.",
               "",
               "kv.",
               "",
               "n.",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_DateTimePatterns = new String[] {
               "{1} 'kl'. {0}",
               "{1} 'kl'. {0}",
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
               "b\u00faddhadagatal",
            };
        final String[] metaValue_java_time_buddhist_Eras = new String[] {
               "BC",
               "BD",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d. MMMM y G",
               "d. MMMM y G",
               "d.M.y G",
               "d.M.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d. MMMM y GGGG",
               "d. MMMM y GGGG",
               "d.M.y GGGG",
               "d.M.y G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "fyrir l\u00fd\u00f0veldi K\u00edna",
               "Minguo",
            };
        final String[] metaValue_java_time_roc_Eras = new String[] {
               "fyrir l\u00fd\u00f0v. K\u00edna",
               "Minguo",
            };
        final String[] metaValue_java_time_roc_narrow_Eras = new String[] {
               "fyrir lv.K.",
               "Minguo",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "eftir Hijra",
            };
        final String[] metaValue_java_time_islamic_Eras = new String[] {
               "",
               "EH",
            };
        final String metaValue_calendarname_gregorian = "Gregor\u00edskt t\u00edmatal";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\u00e1r" },
            { "calendarname.islamic-umalqura", "\u00cdslamskt dagatal (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "\u00cdslamskt borgaradagatal" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "narrow.Eras",
                new String[] {
                    "f.k.",
                    "e.k.",
                }
            },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0} (sta\u00f0alt\u00edmi)" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "Japanskt t\u00edmatal" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "long.Eras",
                new String[] {
                    "fyrir Krist",
                    "eftir Krist",
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
                    ",",
                    ".",
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
            { "field.minute", "m\u00edn\u00fata" },
            { "field.era", "t\u00edmabil" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "f.h./e.h." },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "muharram",
                    "safar",
                    "rabi\u02bb I",
                    "rabi\u02bb II",
                    "jumada I",
                    "jumada II",
                    "rajab",
                    "sha\u02bbban",
                    "ramadan",
                    "shawwal",
                    "dhu\u02bbl-Qi\u02bbdah",
                    "dhu\u02bbl-Hijjah",
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
                    "\u061c-",
                    "\u0627\u0633",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "calendarname.roc", "Minguo t\u00edmatal" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_Eras },
            { "field.month", "m\u00e1nu\u00f0ur" },
            { "roc.Eras", metaValue_java_time_roc_Eras },
            { "field.second", "sek\u00fanda" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "\u00cdslamskt t\u00edmatal" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:00:00-06:00;afternoon1:12:00-18:00;morning1:06:00-12:00;evening1:18:00-24:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_narrow_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' '\u00fe\u00fasund other:0' '\u00fe\u00fasund}",
                    "{one:00' '\u00fe\u00fasund other:00' '\u00fe\u00fasund}",
                    "{one:000' '\u00fe\u00fasund other:000' '\u00fe\u00fasund}",
                    "{one:0' 'millj\u00f3n other:0' 'millj\u00f3nir}",
                    "{one:00' 'millj\u00f3n other:00' 'millj\u00f3nir}",
                    "{one:000' 'millj\u00f3n other:000' 'millj\u00f3nir}",
                    "{one:0' 'milljar\u00f0ur other:0' 'milljar\u00f0ar}",
                    "{one:00' 'milljar\u00f0ur other:00' 'milljar\u00f0ar}",
                    "{one:000' 'milljar\u00f0ur other:000' 'milljar\u00f0ar}",
                    "{one:0' 'billj\u00f3n other:0' 'billj\u00f3nir}",
                    "{one:00' 'billj\u00f3n other:00' 'billj\u00f3nir}",
                    "{one:000' 'billj\u00f3n other:000' 'billj\u00f3nir}",
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
            { "java.time.roc.Eras", metaValue_java_time_roc_Eras },
            { "field.zone", "t\u00edmabelti" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DateTimePatterns", metaValue_DateTimePatterns },
            { "roc.narrow.Eras", metaValue_java_time_roc_narrow_Eras },
            { "arab.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "",
                }
            },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras",
                new String[] {
                    "f.Kr.",
                    "e.Kr.",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "vikudagur" },
            { "islamic.DateTimePatterns", metaValue_DateTimePatterns },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_Eras },
            { "field.week", "vika" },
            { "buddhist.DateTimePatterns", metaValue_DateTimePatterns },
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
                    "{one:0\u00a0\u00fe'.' other:0\u00a0\u00fe'.'}",
                    "{one:00\u00a0\u00fe'.' other:00\u00a0\u00fe'.'}",
                    "{one:000\u00a0\u00fe'.' other:000\u00a0\u00fe'.'}",
                    "{one:0\u00a0m'.' other:0\u00a0m'.'}",
                    "{one:00\u00a0m'.' other:00\u00a0m'.'}",
                    "{one:000\u00a0m'.' other:000\u00a0m'.'}",
                    "{one:0\u00a0ma'.' other:0\u00a0ma'.'}",
                    "{one:00\u00a0ma'.' other:00\u00a0ma'.'}",
                    "{one:000\u00a0ma'.' other:000\u00a0ma'.'}",
                    "{one:0\u00a0bn other:0\u00a0bn}",
                    "{one:00\u00a0bn other:00\u00a0bn}",
                    "{one:000\u00a0bn other:000\u00a0bn}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "timezone.regionFormat.daylight", "{0} (sumart\u00edmi)" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d. MMMM y",
                    "d. MMMM y",
                    "d. MMM y",
                    "d.M.y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "japanese.DateTimePatterns", metaValue_DateTimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:t = 0 and i % 10 = 1 and i % 100 != 11 or t != 0" },
            { "field.hour", "klukkustund" },
            { "islamic.MonthAbbreviations",
                new String[] {
                    "muh.",
                    "saf.",
                    "rab. I",
                    "rab. II",
                    "jum. I",
                    "jum. II",
                    "raj.",
                    "sha.",
                    "ram.",
                    "shaw.",
                    "dhu\u02bbl-Q.",
                    "dhu\u02bbl-H.",
                    "",
                }
            },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "calendarname.buddhist", "B\u00fadd\u00edskt t\u00edmatal" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "#,##0.00\u00a0\u00a4",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
