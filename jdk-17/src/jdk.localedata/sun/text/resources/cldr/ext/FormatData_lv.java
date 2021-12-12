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

public class FormatData_lv extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "janv\u0101ris",
               "febru\u0101ris",
               "marts",
               "apr\u012blis",
               "maijs",
               "j\u016bnijs",
               "j\u016blijs",
               "augusts",
               "septembris",
               "oktobris",
               "novembris",
               "decembris",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "janv.",
               "febr.",
               "marts",
               "apr.",
               "maijs",
               "j\u016bn.",
               "j\u016bl.",
               "aug.",
               "sept.",
               "okt.",
               "nov.",
               "dec.",
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
               "sv\u0113tdiena",
               "pirmdiena",
               "otrdiena",
               "tre\u0161diena",
               "ceturtdiena",
               "piektdiena",
               "sestdiena",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "sv\u0113td.",
               "pirmd.",
               "otrd.",
               "tre\u0161d.",
               "ceturtd.",
               "piektd.",
               "sestd.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "P",
               "O",
               "T",
               "C",
               "P",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. ceturksnis",
               "2. ceturksnis",
               "3. ceturksnis",
               "4. ceturksnis",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1.\u00a0cet.",
               "2.\u00a0cet.",
               "3.\u00a0cet.",
               "4.\u00a0cet.",
            };
        final String[] metaValue_QuarterNarrows = new String[] {
               "1.",
               "2.",
               "3.",
               "4.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "priek\u0161pusdien\u0101",
               "p\u0113cpusdien\u0101",
               "pusnakt\u012b",
               "pusdienlaik\u0101",
               "no r\u012bta",
               "",
               "p\u0113cpusdien\u0101",
               "",
               "vakar\u0101",
               "",
               "nakt\u012b",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "priek\u0161p.",
               "p\u0113cp.",
               "pusnakt\u012b",
               "pusd.",
               "no r\u012bta",
               "",
               "p\u0113cpusd.",
               "",
               "vakar\u0101",
               "",
               "nakt\u012b",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "p.m.\u0113.",
               "m.\u0113.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "budistu \u0113ra",
            };
        final String[] metaValue_java_time_buddhist_Eras = new String[] {
               "BC",
               "B.E.",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, y. 'gada' d. MMMM G",
               "y. 'gada' d. MMMM G",
               "y. 'gada' d. MMM G",
               "dd.MM.y. GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, y. 'gada' d. MMMM GGGG",
               "y. 'gada' d. MMMM GGGG",
               "y. 'gada' d. MMM GGGG",
               "dd.MM.y. G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "pirms \u0136\u012bnas Republikas dibin\u0101\u0161anas",
               "Mi\u0146go",
            };
        final String[] metaValue_java_time_roc_Eras = new String[] {
               "pirms republikas",
               "Mi\u0146go",
            };
        final String[] metaValue_java_time_roc_narrow_Eras = new String[] {
               "pirms rep.",
               "Mi\u0146go",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "p\u0113c hid\u017eras",
            };
        final String metaValue_calendarname_gregorian = "Gregora kalend\u0101rs";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "gads" },
            { "calendarname.islamic-umalqura", "isl\u0101ma kalend\u0101rs (Umm al-kura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "isl\u0101ma pilso\u0146u kalend\u0101rs" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0}: standarta laiks" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "jap\u0101\u0146u kalend\u0101rs" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "Sv\u0113td.",
                    "Pirmd.",
                    "Otrd.",
                    "Tre\u0161d.",
                    "Ceturtd.",
                    "Piektd.",
                    "Sestd.",
                }
            },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "pirms m\u016bsu \u0113ras",
                    "m\u016bsu \u0113r\u0101",
                }
            },
            { "roc.QuarterNarrows", metaValue_QuarterNarrows },
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
                    "\u00a0",
                    ";",
                    "%",
                    "0",
                    "#",
                    "-",
                    "E",
                    "\u2030",
                    "\u221e",
                    "NS",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "min\u016btes" },
            { "field.era", "\u0113ra" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "priek\u0161pusdien\u0101/p\u0113cpusdien\u0101" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "muharams",
                    "safars",
                    "1. rab\u012b",
                    "2. rab\u012b",
                    "1. d\u017eum\u0101d\u0101",
                    "2. d\u017eum\u0101d\u0101",
                    "rad\u017eabs",
                    "\u0161abans",
                    "ramad\u0101ns",
                    "\u0161auvals",
                    "du al-kid\u0101",
                    "du al-hid\u017e\u0101",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_QuarterNarrows },
            { "calendarname.roc", "\u0136\u012bnas Republikas kalend\u0101rs" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "m\u0113nesis" },
            { "roc.Eras", metaValue_java_time_roc_Eras },
            { "field.second", "sekundes" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "isl\u0101ma kalend\u0101rs" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:23:00-06:00;afternoon1:12:00-18:00;morning1:06:00-12:00;evening1:18:00-23:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_narrow_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Laika josla: {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{zero:0' 't\u016bksto\u0161u one:0' 't\u016bkstotis other:0' 't\u016bksto\u0161i}",
                    "{zero:00' 't\u016bksto\u0161i one:00' 't\u016bkstotis other:00' 't\u016bksto\u0161i}",
                    "{zero:000' 't\u016bksto\u0161i one:000' 't\u016bkstotis other:000' 't\u016bksto\u0161i}",
                    "{zero:0' 'miljonu one:0' 'miljons other:0' 'miljoni}",
                    "{zero:00' 'miljoni one:00' 'miljons other:00' 'miljoni}",
                    "{zero:000' 'miljoni one:000' 'miljons other:000' 'miljoni}",
                    "{zero:0' 'miljardu one:0' 'miljards other:0' 'miljardi}",
                    "{zero:00' 'miljardi one:00' 'miljards other:00' 'miljardi}",
                    "{zero:000' 'miljardi one:000' 'miljards other:000' 'miljardi}",
                    "{zero:0' 'triljonu one:0' 'triljons other:0' 'triljoni}",
                    "{zero:00' 'triljoni one:00' 'triljons other:00' 'triljoni}",
                    "{zero:000' 'triljoni one:000' 'triljons other:000' 'triljoni}",
                }
            },
            { "buddhist.QuarterNarrows", metaValue_QuarterNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
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
            { "field.zone", "laika josla" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_narrow_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "standalone.QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "ned\u0113\u013cas diena" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_Eras },
            { "field.week", "ned\u0113\u013ca" },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{zero:0\u00a0t\u016bkst'.' one:0\u00a0t\u016bkst'.' other:0\u00a0t\u016bkst'.'}",
                    "{zero:00\u00a0t\u016bkst'.' one:00\u00a0t\u016bkst'.' other:00\u00a0t\u016bkst'.'}",
                    "{zero:000\u00a0t\u016bkst'.' one:000\u00a0t\u016bkst'.' other:000\u00a0t\u016bkst'.'}",
                    "{zero:0\u00a0milj'.' one:0\u00a0milj'.' other:0\u00a0milj'.'}",
                    "{zero:00\u00a0milj'.' one:00\u00a0milj'.' other:00\u00a0milj'.'}",
                    "{zero:000\u00a0milj'.' one:000\u00a0milj'.' other:000\u00a0milj'.'}",
                    "{zero:0\u00a0mljrd'.' one:0\u00a0mljrd'.' other:0\u00a0mljrd'.'}",
                    "{zero:00\u00a0mljrd'.' one:00\u00a0mljrd'.' other:00\u00a0mljrd'.'}",
                    "{zero:000\u00a0mljrd'.' one:000\u00a0mljrd'.' other:000\u00a0mljrd'.'}",
                    "{zero:0\u00a0trilj'.' one:0\u00a0trilj'.' other:0\u00a0trilj'.'}",
                    "{zero:00\u00a0trilj'.' one:00\u00a0trilj'.' other:00\u00a0trilj'.'}",
                    "{zero:000\u00a0trilj'.' one:000\u00a0trilj'.' other:000\u00a0trilj'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "timezone.regionFormat.daylight", "{0}: vasaras laiks" },
            { "DatePatterns",
                new String[] {
                    "EEEE, y. 'gada' d. MMMM",
                    "y. 'gada' d. MMMM",
                    "y. 'gada' d. MMM",
                    "dd.MM.yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames",
                new String[] {
                    "Sv\u0113tdiena",
                    "Pirmdiena",
                    "Otrdiena",
                    "Tre\u0161diena",
                    "Ceturtdiena",
                    "Piektdiena",
                    "Sestdiena",
                }
            },
            { "PluralRules", "zero:n % 10 = 0 or n % 100 = 11..19 or v = 2 and f % 100 = 11..19;one:n % 10 = 1 and n % 100 != 11 or v = 2 and f % 10 = 1 and f % 100 != 11 or v != 2 and f % 10 = 1" },
            { "field.hour", "stundas" },
            { "calendarname.buddhist", "budistu kalend\u0101rs" },
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
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
