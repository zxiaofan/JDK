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

public class FormatData_pcm extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "J\u00e9n\u00fa\u00e1ri",
               "F\u1eb9\u0301b\u00fa\u00e1ri",
               "Mach",
               "\u00c9prel",
               "Mee",
               "Jun",
               "Julai",
               "\u1eccg\u1ecdst",
               "S\u1eb9pt\u1eb9\u0301mba",
               "\u1ecckt\u00f3ba",
               "N\u1ecdv\u1eb9\u0301mba",
               "Dis\u1eb9\u0301mba",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "J\u00e9n",
               "F\u1eb9\u0301b",
               "Mach",
               "\u00c9pr",
               "Mee",
               "Jun",
               "Jul",
               "\u1eccg\u1ecd",
               "S\u1eb9p",
               "\u1ecckt",
               "N\u1ecdv",
               "Dis",
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
               "S\u1ecd\u0301nd\u00e8",
               "M\u1ecd\u0301nd\u00e8",
               "Ti\u00fazd\u00e8",
               "W\u1eb9\u0301n\u1eb9\u0301zd\u00e8",
               "T\u1ecd\u0301zd\u00e8",
               "Fra\u00edd\u00e8",
               "S\u00e1t\u1ecdd\u00e8",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "S\u1ecd\u0301n",
               "M\u1ecd\u0301n",
               "Ti\u00fa",
               "W\u1eb9\u0301n",
               "T\u1ecd\u0301z",
               "Fra\u00ed",
               "S\u00e1t",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "F\u1eb9\u0301st Kw\u1ecd\u0301ta",
               "S\u1eb9\u0301k\u1ecd\u0301n Kw\u1ecd\u0301ta",
               "T\u1ecd\u0301d Kw\u1ecd\u0301ta",
               "F\u1ecd\u0301t Kw\u1ecd\u0301ta",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "K1",
               "K2",
               "K3",
               "K4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "F\u1ecd m\u1ecd\u0301nin",
               "F\u1ecd \u00edvnin",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "BK",
               "KIY",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "H:mm:ss z",
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
        final String[] metaValue_buddhist_narrow_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
               "",
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
        final String metaValue_calendarname_gregorian = "Gr\u1eb9\u0301g\u00f3r\u00ed Kal\u1eb9\u0301nda";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Yi\u1eb9" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_buddhist_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "timezone.regionFormat.standard", "{0} F\u00edksd Taim" },
            { "calendarname.japanese", "Jap\u00e1n Kal\u1eb9\u0301nda" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "Bif\u1ecd\u0301 Kraist",
                    "Kraist Im Yi\u1eb9",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'f\u1ecd' {0}",
                    "{1} 'f\u1ecd' {0}",
                    "{1} {0}",
                    "{1} {0}",
                }
            },
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
            { "field.minute", "M\u00ednit" },
            { "field.era", "Taim" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "f\u1ecd m\u1ecd\u0301nin f\u1ecd \u00e1ftanun f\u1ecd \u00edvnin f\u1ecd nait" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Rip\u1ecd\u0301bl\u00edk \u1ecdf Cha\u00edn\u00e1 Kal\u1eb9\u0301nda" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "M\u1ecdnt" },
            { "field.second", "S\u1eb9\u0301k\u1ecdn" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "M\u00fasl\u00edm Kal\u1eb9\u0301nda" },
            { "japanese.narrow.AmPmMarkers", metaValue_buddhist_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "J\u00e9n",
                    "F\u1eb9\u0301b",
                    "Mach",
                    "\u00c9pr",
                    "Mee",
                    "Jun",
                    "Jul",
                    "\u1ecc\u0301g\u1ecd",
                    "S\u1eb9p",
                    "\u1ecckt",
                    "N\u1ecdv",
                    "Dis",
                    "",
                }
            },
            { "timezone.regionFormat", "{0} Taim" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'Ta\u00fazan other:0' 'Ta\u00fazan}",
                    "{one:00' 'Ta\u00fazan other:00' 'Ta\u00fazan}",
                    "{one:000' 'Ta\u00fazan other:000' 'Ta\u00fazan}",
                    "{one:0' 'M\u00edli\u1ecdn other:0' 'M\u00edli\u1ecdn}",
                    "{one:00' 'M\u00edli\u1ecdn other:00' 'M\u00edli\u1ecdn}",
                    "{one:000' 'M\u00edli\u1ecdn other:000' 'M\u00edli\u1ecdn}",
                    "{one:0' 'B\u00edli\u1ecdn other:0' 'B\u00edli\u1ecdn}",
                    "{one:00' 'B\u00edli\u1ecdn other:00' 'B\u00edli\u1ecdn}",
                    "{one:000' 'B\u00edli\u1ecdn other:000' 'B\u00edli\u1ecdn}",
                    "{one:0' 'Tr\u00edli\u1ecdn other:0' 'Tr\u00edli\u1ecdn}",
                    "{one:00' 'Tr\u00edli\u1ecdn other:00' 'Tr\u00edli\u1ecdn}",
                    "{one:000' 'Tr\u00edli\u1ecdn other:000' 'Tr\u00edli\u1ecdn}",
                }
            },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_buddhist_narrow_AmPmMarkers },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_buddhist_DayNarrows },
            { "field.zone", "Ta\u00edm Zon" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_buddhist_narrow_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "D\u00e8 f\u1ecd wik" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "Wik" },
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
            { "timezone.regionFormat.daylight", "{0} D\u00e9la\u00edt Taim" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd/MM/y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 0 or n = 1" },
            { "field.hour", "Awa" },
            { "calendarname.buddhist", "B\u00fad\u00edst Kal\u1eb9\u0301nda" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00",
                }
            },
            { "buddhist.DayNarrows", metaValue_buddhist_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "japanese.DayNarrows", metaValue_buddhist_DayNarrows },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
