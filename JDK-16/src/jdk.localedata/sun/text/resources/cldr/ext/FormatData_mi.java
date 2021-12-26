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

public class FormatData_mi extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Kohit\u0101tea",
               "Huitanguru",
               "Pout\u016bterangi",
               "Paengawh\u0101wh\u0101",
               "Haratua",
               "Pipiri",
               "H\u014dngongoi",
               "Hereturik\u014dk\u0101",
               "Mahuru",
               "Whiringa-\u0101-nuku",
               "Whiringa-\u0101-rangi",
               "Hakihea",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Kohi",
               "Hui",
               "Pou",
               "Pae",
               "Hara",
               "Pipi",
               "H\u014dngo",
               "Here",
               "Mahu",
               "Nuku",
               "Rangi",
               "Haki",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "K",
               "H",
               "P",
               "P",
               "H",
               "P",
               "H",
               "H",
               "M",
               "N",
               "R",
               "H",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "R\u0101tapu",
               "R\u0101hina",
               "R\u0101t\u016b",
               "R\u0101apa",
               "R\u0101pare",
               "R\u0101mere",
               "R\u0101horoi",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Tap",
               "Hin",
               "T\u016b",
               "Apa",
               "Par",
               "Mer",
               "Hor",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "T",
               "H",
               "T",
               "A",
               "P",
               "M",
               "H",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "Hauwh\u0101 tuatahi",
               "Hauwh\u0101 tuarua",
               "Hauwh\u0101 tuatoru",
               "Hauwh\u0101 tuawh\u0101",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "HW1",
               "HW2",
               "HW3",
               "HW4",
            };
        final String[] metaValue_long_Eras = new String[] {
               "BCE",
               "CE",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_buddhist_AmPmMarkers = new String[] {
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
               "dd-MM-y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y GGGG",
               "d MMMM y GGGG",
               "d MMM y GGGG",
               "dd-MM-y G",
            };
        final String metaValue_calendarname_gregorian = "Maramataka P\u0101keh\u0101";
        final String[] metaValue_short_CompactNumberPatterns = new String[] {
               "",
               "",
               "",
               "{other:0K}",
               "{other:00K}",
               "{other:000K}",
               "{other:0M}",
               "{other:00M}",
               "{other:000M}",
               "{other:0G}",
               "{other:00G}",
               "{other:000G}",
               "{other:0T}",
               "{other:00T}",
               "{other:000T}",
            };
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "tau" },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "japanese.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "rohe w\u0101" },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "long.Eras", metaValue_long_Eras },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "field.weekday", "r\u0101 o te wiki" },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} {0}",
                    "{1} {0}",
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
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "meneti" },
            { "field.era", "w\u0101" },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "field.month", "marama" },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "field.second", "h\u0113kona" },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "wiki" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd-MM-y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "h\u0101ora" },
            { "japanese.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4\u00a0#,##0.00",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
