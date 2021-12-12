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

public class FormatData_se extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "o\u0111\u0111ajagem\u00e1nnu",
               "guovvam\u00e1nnu",
               "njuk\u010dam\u00e1nnu",
               "cuo\u014bom\u00e1nnu",
               "miessem\u00e1nnu",
               "geassem\u00e1nnu",
               "suoidnem\u00e1nnu",
               "borgem\u00e1nnu",
               "\u010dak\u010dam\u00e1nnu",
               "golggotm\u00e1nnu",
               "sk\u00e1bmam\u00e1nnu",
               "juovlam\u00e1nnu",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "o\u0111\u0111j",
               "guov",
               "njuk",
               "cuo",
               "mies",
               "geas",
               "suoi",
               "borg",
               "\u010dak\u010d",
               "golg",
               "sk\u00e1b",
               "juov",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "O",
               "G",
               "N",
               "C",
               "M",
               "G",
               "S",
               "B",
               "\u010c",
               "G",
               "S",
               "J",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "sotnabeaivi",
               "vuoss\u00e1rga",
               "ma\u014b\u014beb\u00e1rga",
               "gaskavahkku",
               "duorasdat",
               "bearjadat",
               "l\u00e1vvardat",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "sotn",
               "vuos",
               "ma\u014b",
               "gask",
               "duor",
               "bear",
               "l\u00e1v",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "V",
               "M",
               "G",
               "D",
               "B",
               "L",
            };
        final String[] metaValue_standalone_QuarterAbbreviations = new String[] {
               "Q1",
               "Q2",
               "Q3",
               "Q4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "i\u0111itbeaivet",
               "eahketbeaivet",
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
               "i.b.",
               "e.b.",
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
               "o.Kr.",
               "m.Kr.",
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
        final String metaValue_calendarname_gregorian = "gregoria kaleander";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "j\u00e1hki" },
            { "islamic.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.gmtFormat", "UTC{0}" },
            { "standalone.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "\u00e1igeav\u00e1dat" },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "timezone.gmtZeroFormat", "UTC" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "long.Eras",
                new String[] {
                    "ovdal Kristtusa",
                    "ma\u014b\u014bel Kristtusa",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "field.weekday", "v\u00e1hkkubeaivi" },
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
                    "\u00a0",
                    ";",
                    "%",
                    "0",
                    "#",
                    "\u2212",
                    "\u00b710^",
                    "\u2030",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minuhtta" },
            { "field.era", "\u00e9ra" },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "beaivi r\u00e1idod\u00e1ssi" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "timezone.hourFormat", "+HH:mm;\u2212HH:mm" },
            { "roc.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "field.month", "m\u00e1nnu" },
            { "field.second", "sekunda" },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "v\u00e1hkku" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0\u00a0dt two:0\u00a0dt other:0\u00a0dt}",
                    "{one:00\u00a0dt two:00\u00a0dt other:00\u00a0dt}",
                    "{one:000\u00a0dt two:000\u00a0dt other:000\u00a0dt}",
                    "{one:0\u00a0mn two:0\u00a0mn other:0\u00a0mn}",
                    "{one:00\u00a0mn two:00\u00a0mn other:00\u00a0mn}",
                    "{one:000\u00a0mn two:000\u00a0mn other:000\u00a0mn}",
                    "{one:0\u00a0md two:0\u00a0md other:0\u00a0md}",
                    "{one:00\u00a0md two:00\u00a0md other:00\u00a0md}",
                    "{one:000\u00a0md two:000\u00a0md other:000\u00a0md}",
                    "{one:0\u00a0bn two:0\u00a0bn other:0\u00a0bn}",
                    "{one:00\u00a0bn two:00\u00a0bn other:00\u00a0bn}",
                    "{one:000\u00a0bn two:000\u00a0bn other:000\u00a0bn}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "DatePatterns",
                new String[] {
                    "y MMMM d, EEEE",
                    "y MMMM d",
                    "y MMM d",
                    "y-MM-dd",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1;two:n = 2" },
            { "field.hour", "diibmu" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "calendarname.buddhist", "buddhista kaleander" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "{0} \u00e1igi" },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "#,##0.00\u00a0\u00a4",
                }
            },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'duh\u00e1t two:0' 'duh\u00e1hat other:0' 'duh\u00e1hat}",
                    "{one:00' 'duh\u00e1t two:00' 'duh\u00e1hat other:00' 'duh\u00e1hat}",
                    "{one:000' 'duh\u00e1t two:000' 'duh\u00e1hat other:000' 'duh\u00e1hat}",
                    "{one:0' 'miljona two:0' 'miljonat other:0' 'miljonat}",
                    "{one:00' 'miljona two:00' 'miljonat other:00' 'miljonat}",
                    "{one:000' 'miljona two:000' 'miljonat other:000' 'miljonat}",
                    "{one:0' 'miljardi two:0' 'miljardit other:0' 'miljardit}",
                    "{one:00' 'miljardi two:00' 'miljardit other:00' 'miljardit}",
                    "{one:000' 'miljardi two:000' 'miljardit other:000' 'miljardit}",
                    "{one:0' 'biljona two:0' 'biljonat other:0' 'biljonat}",
                    "{one:00' 'biljona two:00' 'biljonat other:00' 'biljonat}",
                    "{one:000' 'biljona two:000' 'biljonat other:000' 'biljonat}",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
