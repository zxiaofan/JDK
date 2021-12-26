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

public class FormatData_sr_Latn extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "januar",
               "februar",
               "mart",
               "april",
               "maj",
               "jun",
               "jul",
               "avgust",
               "septembar",
               "oktobar",
               "novembar",
               "decembar",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan",
               "feb",
               "mar",
               "apr",
               "maj",
               "jun",
               "jul",
               "avg",
               "sep",
               "okt",
               "nov",
               "dec",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "j",
               "f",
               "m",
               "a",
               "m",
               "j",
               "j",
               "a",
               "s",
               "o",
               "n",
               "d",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "nedelja",
               "ponedeljak",
               "utorak",
               "sreda",
               "\u010detvrtak",
               "petak",
               "subota",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "ned",
               "pon",
               "uto",
               "sre",
               "\u010det",
               "pet",
               "sub",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "n",
               "p",
               "u",
               "s",
               "\u010d",
               "p",
               "s",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "prvi kvartal",
               "drugi kvartal",
               "tre\u0107i kvartal",
               "\u010detvrti kvartal",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "K1",
               "K2",
               "K3",
               "K4",
            };
        final String[] metaValue_QuarterNarrows = new String[] {
               "1.",
               "2.",
               "3.",
               "4.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "pre podne",
               "po podne",
               "pono\u0107",
               "podne",
               "ujutro",
               "",
               "po podne",
               "",
               "uve\u010de",
               "",
               "no\u0107u",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a",
               "p",
               "pono\u0107",
               "podne",
               "ujutru",
               "",
               "po podne",
               "",
               "uve\u010de",
               "",
               "no\u0107u",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "BE",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d. MMMM y. G",
               "d. MMMM y. G",
               "d.MM.y. G",
               "d.M.y. GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d. MMMM y. GGGG",
               "d. MMMM y. GGGG",
               "d.MM.y. GGGG",
               "d.M.y. G",
            };
        final String[] metaValue_java_time_japanese_long_Eras = new String[] {
               "nove ere",
               "Mei\u0111i",
               "Tai\u0161o",
               "\u0160ova",
               "Haisei",
               "Reiva",
            };
        final String[] metaValue_java_time_japanese_Eras = new String[] {
               "n. e.",
               "Mei\u0111i",
               "Tai\u0161o",
               "\u0160ova",
               "Haisei",
               "Reiva",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "Pre RK",
               "RK",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "gregorijanski kalendar";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "godina" },
            { "calendarname.islamic-umalqura", "islamski kalendar (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns",
                new String[] {
                    "EEEE, MMMM d, y G",
                    "MMMM d, y G",
                    "MMM d, y G",
                    "M/d/yy G",
                }
            },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Islamski civilni kalendar" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "narrow.Eras",
                new String[] {
                    "p.n.e.",
                    "n.e.",
                }
            },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0}, standardno vreme" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "japanski kalendar" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras",
                new String[] {
                    "pre nove ere",
                    "nove ere",
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
            { "japanese.DatePatterns",
                new String[] {
                    "EEEE, MMMM d, y GGGG",
                    "MMMM d, y GGGG",
                    "MMM d, y GGGG",
                    "M/d/yy GGGG",
                }
            },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minut" },
            { "japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "field.era", "era" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "pre podne/po podne" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "Muraham",
                    "Safar",
                    "Rabi\u02bb I",
                    "Rabi\u02bb II",
                    "Jumada I",
                    "Jumada II",
                    "Ra\u0111ab",
                    "\u0160a\u02bbban",
                    "Ramadan",
                    "\u0160aval",
                    "Du\u02bbl-Ki\u02bbda",
                    "Du\u02bbl-hi\u0111a",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_QuarterNarrows },
            { "calendarname.roc", "kalendar Republike Kine" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "mesec" },
            { "java.time.japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "sekund" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islamski kalendar" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'hiljada few:0' 'hiljade other:0' 'hiljada}",
                    "{one:00' 'hiljada few:00' 'hiljade other:00' 'hiljada}",
                    "{one:000' 'hiljada few:000' 'hiljade other:000' 'hiljada}",
                    "{one:0' 'milion few:0' 'miliona other:0' 'miliona}",
                    "{one:00' 'milion few:00' 'miliona other:00' 'miliona}",
                    "{one:000' 'milion few:000' 'miliona other:000' 'miliona}",
                    "{one:0' 'milijarda few:0' 'milijarde other:0' 'milijardi}",
                    "{one:00' 'milijarda few:00' 'milijarde other:00' 'milijardi}",
                    "{one:000' 'milijarda few:000' 'milijarde other:000' 'milijardi}",
                    "{one:0' 'bilion few:0' 'biliona other:0' 'biliona}",
                    "{one:00' 'bilion few:00' 'biliona other:00' 'biliona}",
                    "{one:000' 'bilion few:000' 'biliona other:000' 'biliona}",
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
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.zone", "vremenska zona" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras",
                new String[] {
                    "p. n. e.",
                    "n. e.",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "standalone.QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "dan u nedelji" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
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
            { "field.week", "nedelja" },
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
                    "{one:0\u00a0hilj'.' few:0\u00a0hilj'.' other:0\u00a0hilj'.'}",
                    "{one:00\u00a0hilj'.' few:00\u00a0hilj'.' other:00\u00a0hilj'.'}",
                    "{one:000\u00a0hilj'.' few:000\u00a0hilj'.' other:000\u00a0hilj'.'}",
                    "{one:0\u00a0mil'.' few:0\u00a0mil'.' other:0\u00a0mil'.'}",
                    "{one:00\u00a0mil'.' few:00\u00a0mil'.' other:00\u00a0mil'.'}",
                    "{one:000\u00a0mil'.' few:000\u00a0mil'.' other:000\u00a0mil'.'}",
                    "{one:0\u00a0mlrd'.' few:0\u00a0mlrd'.' other:0\u00a0mlrd'.'}",
                    "{one:00\u00a0mlrd'.' few:00\u00a0mlrd'.' other:00\u00a0mlrd'.'}",
                    "{one:000\u00a0mlrd'.' few:000\u00a0mlrd'.' other:000\u00a0mlrd'.'}",
                    "{one:0\u00a0bil'.' few:0\u00a0bil'.' other:0\u00a0bil'.'}",
                    "{one:00\u00a0bil'.' few:00\u00a0bil'.' other:00\u00a0bil'.'}",
                    "{one:000\u00a0bil'.' few:000\u00a0bil'.' other:000\u00a0bil'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "{0}, letnje vreme" },
            { "DatePatterns",
                new String[] {
                    "EEEE, dd. MMMM y.",
                    "dd. MMMM y.",
                    "dd.MM.y.",
                    "d.M.yy.",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "sat" },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "budisti\u010dki kalendar" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "#,##0.00\u00a0\u00a4;(#,##0.00\u00a0\u00a4)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.Eras", metaValue_java_time_japanese_Eras },
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
