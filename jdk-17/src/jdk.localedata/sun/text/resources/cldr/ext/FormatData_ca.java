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

public class FormatData_ca extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "de gener",
               "de febrer",
               "de mar\u00e7",
               "d\u2019abril",
               "de maig",
               "de juny",
               "de juliol",
               "d\u2019agost",
               "de setembre",
               "d\u2019octubre",
               "de novembre",
               "de desembre",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "de gen.",
               "de febr.",
               "de mar\u00e7",
               "d\u2019abr.",
               "de maig",
               "de juny",
               "de jul.",
               "d\u2019ag.",
               "de set.",
               "d\u2019oct.",
               "de nov.",
               "de des.",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "GN",
               "FB",
               "M\u00c7",
               "AB",
               "MG",
               "JN",
               "JL",
               "AG",
               "ST",
               "OC",
               "NV",
               "DS",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "diumenge",
               "dilluns",
               "dimarts",
               "dimecres",
               "dijous",
               "divendres",
               "dissabte",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "dg.",
               "dl.",
               "dt.",
               "dc.",
               "dj.",
               "dv.",
               "ds.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "dg",
               "dl",
               "dt",
               "dc",
               "dj",
               "dv",
               "ds",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1r trimestre",
               "2n trimestre",
               "3r trimestre",
               "4t trimestre",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1T",
               "2T",
               "3T",
               "4T",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "a.\u00a0m.",
               "p.\u00a0m.",
               "mitjanit",
               "",
               "matinada",
               "mat\u00ed",
               "migdia",
               "tarda",
               "vespre",
               "",
               "nit",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a.\u00a0m.",
               "p.\u00a0m.",
               "mitjanit",
               "",
               "mat.",
               "mat\u00ed",
               "md",
               "tarda",
               "vespre",
               "",
               "nit",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "aC",
               "dC",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "H:mm:ss (zzzz)",
               "H:mm:ss z",
               "H:mm:ss",
               "H:mm",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "eB",
            };
        final String[] metaValue_java_time_japanese_DatePatterns = new String[] {
               "EEEE, d MMMM 'de' y G",
               "d MMMM 'de' y G",
               "d/M/y G",
               "d/M/yy GGGGG",
            };
        final String[] metaValue_japanese_DatePatterns = new String[] {
               "EEEE, d MMMM 'de' y GGGG",
               "d MMMM 'de' y GGGG",
               "d/M/y GGGG",
               "d/M/yy G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "Abans de ROC",
               "ROC",
            };
        final String metaValue_calendarname_gregorian = "calendari gregori\u00e0";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "any" },
            { "calendarname.islamic-umalqura", "calendari isl\u00e0mic (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "calendari civil isl\u00e0mic" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "Hora est\u00e0ndard, {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "calendari japon\u00e8s" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "abans de Crist",
                    "despr\u00e9s de Crist",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1}, 'a' 'les' {0}",
                    "{1}, 'a' 'les' {0}",
                    "{1}, {0}",
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
            { "japanese.DatePatterns", metaValue_japanese_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minut" },
            { "field.era", "era" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "a.\u00a0m./p.\u00a0m." },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "calendari de la Rep\u00fablica de Xina" },
            { "islamic.DatePatterns", metaValue_japanese_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "mes" },
            { "field.second", "segon" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns",
                new String[] {
                    "EEEE d MMMM 'de' y GGGG",
                    "d MMMM 'de' y GGGG",
                    "dd/MM/y GGGG",
                    "dd/MM/y G",
                }
            },
            { "calendarname.islamic", "calendari isl\u00e0mic" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;night1:21:00-24:00;morning2:06:00-12:00;afternoon1:12:00-13:00;morning1:00:00-06:00;afternoon2:13:00-19:00;evening1:19:00-21:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "gen.",
                    "febr.",
                    "mar\u00e7",
                    "abr.",
                    "maig",
                    "juny",
                    "jul.",
                    "ag.",
                    "set.",
                    "oct.",
                    "nov.",
                    "des.",
                    "",
                }
            },
            { "timezone.regionFormat", "Hora de: {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'miler other:0' 'milers}",
                    "{one:00' 'milers other:00' 'milers}",
                    "{one:000' 'milers other:000' 'milers}",
                    "{one:0' 'mili\u00f3 other:0' 'milions}",
                    "{one:00' 'milions other:00' 'milions}",
                    "{one:000' 'milions other:000' 'milions}",
                    "{one:0' 'miler' 'de' 'milions other:0' 'milers' 'de' 'milions}",
                    "{one:00' 'milers' 'de' 'milions other:00' 'milers' 'de' 'milions}",
                    "{one:000' 'milers' 'de' 'milions other:000' 'milers' 'de' 'milions}",
                    "{one:0' 'bili\u00f3 other:0' 'bilions}",
                    "{one:00' 'bilions other:00' 'bilions}",
                    "{one:000' 'bilions other:000' 'bilions}",
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
            { "field.zone", "fus horari" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "field.weekday", "dia de la setmana" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns",
                new String[] {
                    "EEEE, dd MMMM y GGGG",
                    "d MMMM y GGGG",
                    "d MMM y GGGG",
                    "dd/MM/y G",
                }
            },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "setmana" },
            { "buddhist.DateTimePatterns",
                new String[] {
                    "{1}, {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                }
            },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.buddhist.DatePatterns",
                new String[] {
                    "EEEE, dd MMMM y G",
                    "d MMMM y G",
                    "d MMM y G",
                    "dd/MM/y GGGGG",
                }
            },
            { "java.time.roc.DatePatterns",
                new String[] {
                    "EEEE d MMMM 'de' y G",
                    "d MMMM 'de' y G",
                    "dd/MM/y G",
                    "dd/MM/y GGGGG",
                }
            },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0m other:0m}",
                    "{one:00m other:00m}",
                    "{one:000m other:000m}",
                    "{one:0\u00a0M other:0\u00a0M}",
                    "{one:00\u00a0M other:00\u00a0M}",
                    "{one:000\u00a0M other:000\u00a0M}",
                    "{one:0000\u00a0M other:0000\u00a0M}",
                    "{one:00mM other:00mM}",
                    "{one:000mM other:000mM}",
                    "{one:0\u00a0B other:0\u00a0B}",
                    "{one:00\u00a0B other:00\u00a0B}",
                    "{one:000\u00a0B other:000\u00a0B}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "Hora d\u2019estiu, {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM 'de' y",
                    "d MMMM 'de' y",
                    "d MMM y",
                    "d/M/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 1 and v = 0" },
            { "field.hour", "hora" },
            { "calendarname.buddhist", "calendari budista" },
            { "standalone.MonthNames",
                new String[] {
                    "gener",
                    "febrer",
                    "mar\u00e7",
                    "abril",
                    "maig",
                    "juny",
                    "juliol",
                    "agost",
                    "setembre",
                    "octubre",
                    "novembre",
                    "desembre",
                    "",
                }
            },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "#,##0.00\u00a0\u00a4;(#,##0.00\u00a0\u00a4)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
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
