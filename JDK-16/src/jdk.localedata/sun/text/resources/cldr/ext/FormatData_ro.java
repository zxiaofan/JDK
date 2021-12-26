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

public class FormatData_ro extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "ianuarie",
               "februarie",
               "martie",
               "aprilie",
               "mai",
               "iunie",
               "iulie",
               "august",
               "septembrie",
               "octombrie",
               "noiembrie",
               "decembrie",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "ian.",
               "feb.",
               "mar.",
               "apr.",
               "mai",
               "iun.",
               "iul.",
               "aug.",
               "sept.",
               "oct.",
               "nov.",
               "dec.",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "I",
               "F",
               "M",
               "A",
               "M",
               "I",
               "I",
               "A",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "duminic\u0103",
               "luni",
               "mar\u021bi",
               "miercuri",
               "joi",
               "vineri",
               "s\u00e2mb\u0103t\u0103",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "dum.",
               "lun.",
               "mar.",
               "mie.",
               "joi",
               "vin.",
               "s\u00e2m.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "D",
               "L",
               "M",
               "M",
               "J",
               "V",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "trimestrul I",
               "trimestrul al II-lea",
               "trimestrul al III-lea",
               "trimestrul al IV-lea",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "trim. I",
               "trim. II",
               "trim. III",
               "trim. IV",
            };
        final String[] metaValue_QuarterNarrows = new String[] {
               "I",
               "II",
               "III",
               "IV",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "la miezul nop\u021bii",
               "la amiaz\u0103",
               "diminea\u021ba",
               "",
               "dup\u0103-amiaza",
               "",
               "seara",
               "",
               "noaptea",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "miezul nop\u021bii",
               "la amiaz\u0103",
               "diminea\u021ba",
               "",
               "dup\u0103-amiaza",
               "",
               "seara",
               "",
               "noaptea",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "miezul nop\u021bii",
               "amiaz\u0103",
               "diminea\u021ba",
               "",
               "dup\u0103-amiaza",
               "",
               "seara",
               "",
               "noaptea",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "\u00ee.Hr.",
               "d.Hr.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "era budist\u0103",
            };
        final String[] metaValue_java_time_buddhist_Eras = new String[] {
               "BC",
               "e.b.",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y G",
               "d MMMM y G",
               "dd.MM.y G",
               "dd.MM.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y GGGG",
               "d MMMM y GGGG",
               "dd.MM.y GGGG",
               "dd.MM.y G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "\u00eenainte de Republica China",
               "Republica China",
            };
        final String[] metaValue_java_time_roc_Eras = new String[] {
               "\u00ee.R.C.",
               "R.C.",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "A.H.",
            };
        final String[] metaValue_java_time_islamic_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "calendar gregorian";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "an" },
            { "calendarname.islamic-umalqura", "calendar islamic (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "calendar islamic civil" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "Ora standard din {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "calendar japonez" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "long.Eras",
                new String[] {
                    "\u00eenainte de Hristos",
                    "dup\u0103 Hristos",
                }
            },
            { "roc.QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1}, {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                    "{1}, {0}",
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
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minut" },
            { "field.era", "er\u0103" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "a.m/p.m." },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_QuarterNarrows },
            { "calendarname.roc", "calendarul Republicii Chineze" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_Eras },
            { "field.month", "lun\u0103" },
            { "roc.Eras", metaValue_java_time_roc_Eras },
            { "field.second", "secund\u0103" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "calendar islamic" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:22:00-05:00;afternoon1:12:00-18:00;morning1:05:00-12:00;evening1:18:00-22:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Ora din {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'mie few:0' 'mii other:0' 'de' 'mii}",
                    "{one:00' 'mie few:00' 'mii other:00' 'de' 'mii}",
                    "{one:000' 'mie few:000' 'mii other:000' 'de' 'mii}",
                    "{one:0' 'milion few:0' 'milioane other:0' 'de' 'milioane}",
                    "{one:00' 'milion few:00' 'milioane other:00' 'de' 'milioane}",
                    "{one:000' 'milion few:000' 'milioane other:000' 'de' 'milioane}",
                    "{one:0' 'miliard few:0' 'miliarde other:0' 'de' 'miliarde}",
                    "{one:00' 'miliard few:00' 'miliarde other:00' 'de' 'miliarde}",
                    "{one:000' 'miliard few:000' 'miliarde other:000' 'de' 'miliarde}",
                    "{one:0' 'trilion few:0' 'trilioane other:0' 'de' 'trilioane}",
                    "{one:00' 'trilion few:00' 'trilioane other:00' 'de' 'trilioane}",
                    "{one:000' 'trilion few:000' 'trilioane other:000' 'de' 'trilioane}",
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
            { "field.zone", "fus orar" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "QuarterNarrows", metaValue_QuarterNarrows },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "standalone.QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "ziua din s\u0103pt\u0103m\u00e2n\u0103" },
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
            { "field.week", "s\u0103pt\u0103m\u00e2n\u0103" },
            { "buddhist.DateTimePatterns",
                new String[] {
                    "{1} 'la' {0}",
                    "{1} 'la' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                }
            },
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
                    "{one:0\u00a0K few:0\u00a0K other:0\u00a0K}",
                    "{one:00\u00a0K few:00\u00a0K other:00\u00a0K}",
                    "{one:000\u00a0K few:000\u00a0K other:000\u00a0K}",
                    "{one:0\u00a0mil'.' few:0\u00a0mil'.' other:0\u00a0mil'.'}",
                    "{one:00\u00a0mil'.' few:00\u00a0mil'.' other:00\u00a0mil'.'}",
                    "{one:000\u00a0mil'.' few:000\u00a0mil'.' other:000\u00a0mil'.'}",
                    "{one:0\u00a0mld'.' few:0\u00a0mld'.' other:0\u00a0mld'.'}",
                    "{one:00\u00a0mld'.' few:00\u00a0mld'.' other:00\u00a0mld'.'}",
                    "{one:000\u00a0mld'.' few:000\u00a0mld'.' other:000\u00a0mld'.'}",
                    "{one:0\u00a0tril'.' few:0\u00a0tril'.' other:0\u00a0tril'.'}",
                    "{one:00\u00a0tril'.' few:00\u00a0tril'.' other:00\u00a0tril'.'}",
                    "{one:000\u00a0tril'.' few:000\u00a0tril'.' other:000\u00a0tril'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_Eras },
            { "timezone.regionFormat.daylight", "Ora de var\u0103 din {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd.MM.y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 1 and v = 0;few:v != 0 or n = 0 or n % 100 = 2..19" },
            { "field.hour", "or\u0103" },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_Eras },
            { "calendarname.buddhist", "calendar budist" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "#,##0.00\u00a0\u00a4;(#,##0.00\u00a0\u00a4)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
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
