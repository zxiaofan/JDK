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

public class FormatData_ig extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Jen\u1ee5war\u1ecb",
               "Febr\u1ee5war\u1ecb",
               "Maach\u1ecb",
               "Epreel",
               "Mee",
               "Juun",
               "Jula\u1ecb",
               "\u1eccg\u1ecd\u1ecdst",
               "Septemba",
               "\u1eccktoba",
               "Novemba",
               "Disemba",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jen",
               "Feb",
               "Maa",
               "Epr",
               "Mee",
               "Juu",
               "Jul",
               "\u1eccg\u1ecd",
               "Sep",
               "\u1ecckt",
               "Nov",
               "Dis",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "J",
               "F",
               "M",
               "E",
               "M",
               "J",
               "J",
               "\u1ecc",
               "S",
               "\u1ecc",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "S\u1ecdndee",
               "M\u1ecdnde",
               "Tiuzdee",
               "Wenezdee",
               "T\u1ecd\u1ecdzdee",
               "Fra\u1ecbdee",
               "Sat\u1ecddee",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "S\u1ecdn",
               "M\u1ecdn",
               "Tiu",
               "Wen",
               "T\u1ecd\u1ecd",
               "Fra\u1ecb",
               "Sat",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "\u1ecckara 1",
               "\u1ecckara 2",
               "\u1ecckara 3",
               "\u1ecckara 4",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "\u1ecc1",
               "\u1ecc2",
               "\u1ecc3",
               "\u1ecc4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "N\u2019\u1ee5t\u1ee5t\u1ee5",
               "N\u2019abali",
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
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "A.M.",
               "P.M.",
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
               "T.K.",
               "A.K.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
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
        final String metaValue_calendarname_gregorian = "Kalenda Gregory";
        final String[] metaValue_arabext_NumberPatterns = new String[] {
               "#,##0.###",
               "\u00a4\u00a0#,##0.00",
               "#,##0%",
               "",
            };
        final String[] metaValue_brah_NumberElements = new String[] {
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
            };
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Af\u1ecd" },
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
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "timezone.regionFormat.standard", "Oge Izugbe {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "Kal\u1ecbnda Japanese" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "beng.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "\u09e6",
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
            { "long.Eras",
                new String[] {
                    "Tupu Kraist",
                    "Af\u1ecd Kra\u1ecbst",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "cakm.NumberPatterns", metaValue_arabext_NumberPatterns },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'na' {0}",
                    "{1} 'na' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                }
            },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "latn.NumberElements", metaValue_brah_NumberElements },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "Nkeji" },
            { "field.era", "Agba" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "N\u2019\u1ee5t\u1ee5t\u1ee5/N\u2019abal\u1ecb" },
            { "bali.NumberPatterns", metaValue_arabext_NumberPatterns },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "arab.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a\u200f",
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
            { "beng.NumberPatterns", metaValue_arabext_NumberPatterns },
            { "calendarname.roc", "Kal\u1ecbnda rep\u1ee5blic nke China" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "\u1eccnwa" },
            { "arabext.NumberPatterns", metaValue_arabext_NumberPatterns },
            { "field.second", "T\u1ecbm k\u1ecdm" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Kal\u1ecbnda Islam" },
            { "bali.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "\u1b50",
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
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "brah.NumberElements", metaValue_brah_NumberElements },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Oge {0}" },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "field.zone", "Mpaghara oge" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "arab.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0\u00a0%",
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
            { "field.weekday", "\u1ee4b\u1ecdch\u1ecb izu" },
            { "brah.NumberPatterns", metaValue_arabext_NumberPatterns },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "cakm.NumberElements", metaValue_brah_NumberElements },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "Izu" },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Oge Ihe {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "d/M/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "Elekere" },
            { "calendarname.buddhist", "Kal\u1ecbnda B\u1ee5dd\u1ecbst" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
