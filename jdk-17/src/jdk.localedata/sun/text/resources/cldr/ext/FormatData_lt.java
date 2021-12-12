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

public class FormatData_lt extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "sausio",
               "vasario",
               "kovo",
               "baland\u017eio",
               "gegu\u017e\u0117s",
               "bir\u017eelio",
               "liepos",
               "rugpj\u016b\u010dio",
               "rugs\u0117jo",
               "spalio",
               "lapkri\u010dio",
               "gruod\u017eio",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "saus.",
               "vas.",
               "kov.",
               "bal.",
               "geg.",
               "bir\u017e.",
               "liep.",
               "rugp.",
               "rugs.",
               "spal.",
               "lapkr.",
               "gruod.",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "S",
               "V",
               "K",
               "B",
               "G",
               "B",
               "L",
               "R",
               "R",
               "S",
               "L",
               "G",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "sekmadienis",
               "pirmadienis",
               "antradienis",
               "tre\u010diadienis",
               "ketvirtadienis",
               "penktadienis",
               "\u0161e\u0161tadienis",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "sk",
               "pr",
               "an",
               "tr",
               "kt",
               "pn",
               "\u0161t",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "P",
               "A",
               "T",
               "K",
               "P",
               "\u0160",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "I ketvirtis",
               "II ketvirtis",
               "III ketvirtis",
               "IV ketvirtis",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "I k.",
               "II k.",
               "III k.",
               "IV k.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "prie\u0161piet",
               "popiet",
               "vidurnaktis",
               "perpiet",
               "rytas",
               "",
               "popiet\u0117",
               "",
               "vakaras",
               "",
               "naktis",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "pr.\u00a0p.",
               "pop.",
               "vidurnaktis",
               "perpiet",
               "rytas",
               "",
               "popiet\u0117",
               "",
               "vakaras",
               "",
               "naktis",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "pr. Kr.",
               "po Kr.",
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
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "BE",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "y MMMM d G, EEEE",
               "y MMMM d G",
               "y MMM d G",
               "y-MM-dd G",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "y MMMM d GGGG, EEEE",
               "y MMMM d GGGG",
               "y MMM d GGGG",
               "y-MM-dd GGGG",
            };
        final String[] metaValue_java_time_japanese_long_Eras = new String[] {
               "po Kristaus",
               "Meid\u017ei",
               "Tai\u0161o",
               "\u0160ova",
               "Heisei",
               "Reiwa",
            };
        final String[] metaValue_java_time_japanese_Eras = new String[] {
               "po Kr.",
               "Meid\u017ei",
               "Tai\u0161o",
               "\u0160ova",
               "Heisei",
               "Reiwa",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "Prie\u0161 R.O.C.",
               "R.O.C.",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "Grigaliaus kalendorius";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "metai" },
            { "calendarname.islamic-umalqura", "Islamo kalendorius (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations",
                new String[] {
                    "I ketv.",
                    "II ketv.",
                    "III ketv.",
                    "IV ketv.",
                }
            },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Islamo kalendorius (lentelinis, pilietin\u0117 era)" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "\u017diemos laikas: {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "japon\u0173 kalendorius" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras",
                new String[] {
                    "prie\u0161 Krist\u0173",
                    "po Kristaus",
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
                    "\u00a0",
                    ";",
                    "%",
                    "0",
                    "#",
                    "\u2212",
                    "\u00d710^",
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
            { "field.minute", "minut\u0117" },
            { "japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "field.era", "era" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "iki piet\u0173 / po piet\u0173" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Kinijos Respublikos kalendorius" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "m\u0117nuo" },
            { "java.time.japanese.long.Eras", metaValue_java_time_japanese_long_Eras },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "sekund\u0117" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islamo kalendorius" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:00:00-06:00;afternoon1:12:00-18:00;morning1:06:00-12:00;evening1:18:00-24:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Laikas: {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 't\u016bkstantis few:0' 't\u016bkstan\u010diai many:0' 't\u016bkstan\u010dio other:0' 't\u016bkstan\u010di\u0173}",
                    "{one:00' 't\u016bkstantis few:00' 't\u016bkstan\u010diai many:00' 't\u016bkstan\u010dio other:00' 't\u016bkstan\u010di\u0173}",
                    "{one:000' 't\u016bkstantis few:000' 't\u016bkstan\u010diai many:000' 't\u016bkstan\u010dio other:000' 't\u016bkstan\u010di\u0173}",
                    "{one:0' 'milijonas few:0' 'milijonai many:0' 'milijono other:0' 'milijon\u0173}",
                    "{one:00' 'milijonas few:00' 'milijonai many:00' 'milijono other:00' 'milijon\u0173}",
                    "{one:000' 'milijonas few:000' 'milijonai many:000' 'milijono other:000' 'milijon\u0173}",
                    "{one:0' 'milijardas few:0' 'milijardai many:0' 'milijardo other:0' 'milijard\u0173}",
                    "{one:00' 'milijardas few:00' 'milijardai many:00' 'milijardo other:00' 'milijard\u0173}",
                    "{one:000' 'milijardas few:000' 'milijardai many:000' 'milijardo other:000' 'milijard\u0173}",
                    "{one:0' 'trilijonas few:0' 'trilijonai many:0' 'trilijono other:0' 'trilijon\u0173}",
                    "{one:00' 'trilijonas few:00' 'trilijonai many:00' 'trilijono other:00' 'trilijon\u0173}",
                    "{one:000' 'trilijonas few:000' 'trilijonai many:000' 'trilijono other:000' 'trilijon\u0173}",
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
            { "field.zone", "laiko juosta" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "savait\u0117s diena" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.hourFormat", "+HH:mm;\u2212HH:mm" },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "java.time.japanese.Eras", metaValue_java_time_japanese_Eras },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "savait\u0117" },
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
                    "{one:0\u00a0t\u016bkst'.' few:0\u00a0t\u016bkst'.' many:0\u00a0t\u016bkst'.' other:0\u00a0t\u016bkst'.'}",
                    "{one:00\u00a0t\u016bkst'.' few:00\u00a0t\u016bkst'.' many:00\u00a0t\u016bkst'.' other:00\u00a0t\u016bkst'.'}",
                    "{one:000\u00a0t\u016bkst'.' few:000\u00a0t\u016bkst'.' many:000\u00a0t\u016bkst'.' other:000\u00a0t\u016bkst'.'}",
                    "{one:0\u00a0mln'.' few:0\u00a0mln'.' many:0\u00a0mln'.' other:0\u00a0mln'.'}",
                    "{one:00\u00a0mln'.' few:00\u00a0mln'.' many:00\u00a0mln'.' other:00\u00a0mln'.'}",
                    "{one:000\u00a0mln'.' few:000\u00a0mln'.' many:000\u00a0mln'.' other:000\u00a0mln'.'}",
                    "{one:0\u00a0mlrd'.' few:0\u00a0mlrd'.' many:0\u00a0mlrd'.' other:0\u00a0mlrd'.'}",
                    "{one:00\u00a0mlrd'.' few:00\u00a0mlrd'.' many:00\u00a0mlrd'.' other:00\u00a0mlrd'.'}",
                    "{one:000\u00a0mlrd'.' few:000\u00a0mlrd'.' many:000\u00a0mlrd'.' other:000\u00a0mlrd'.'}",
                    "{one:0\u00a0trln'.' few:0\u00a0trln'.' many:0\u00a0trln'.' other:0\u00a0trln'.'}",
                    "{one:00\u00a0trln'.' few:00\u00a0trln'.' many:00\u00a0trln'.' other:00\u00a0trln'.'}",
                    "{one:000\u00a0trln'.' few:000\u00a0trln'.' many:000\u00a0trln'.' other:000\u00a0trln'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "timezone.regionFormat.daylight", "Vasaros laikas: {0}" },
            { "DatePatterns",
                new String[] {
                    "y 'm'. MMMM d 'd'., EEEE",
                    "y 'm'. MMMM d 'd'.",
                    "y-MM-dd",
                    "y-MM-dd",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n % 10 = 1 and n % 100 != 11..19;few:n % 10 = 2..9 and n % 100 != 11..19;many:f != 0" },
            { "field.hour", "valanda" },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "budist\u0173 kalendorius" },
            { "standalone.MonthNames",
                new String[] {
                    "sausis",
                    "vasaris",
                    "kovas",
                    "balandis",
                    "gegu\u017e\u0117",
                    "bir\u017eelis",
                    "liepa",
                    "rugpj\u016btis",
                    "rugs\u0117jis",
                    "spalis",
                    "lapkritis",
                    "gruodis",
                    "",
                }
            },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "#,##0.00\u00a0\u00a4",
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
