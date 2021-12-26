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

public class FormatData_sq extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "janar",
               "shkurt",
               "mars",
               "prill",
               "maj",
               "qershor",
               "korrik",
               "gusht",
               "shtator",
               "tetor",
               "n\u00ebntor",
               "dhjetor",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan",
               "shk",
               "mar",
               "pri",
               "maj",
               "qer",
               "korr",
               "gush",
               "sht",
               "tet",
               "n\u00ebn",
               "dhj",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "j",
               "sh",
               "m",
               "p",
               "m",
               "q",
               "k",
               "g",
               "sh",
               "t",
               "n",
               "dh",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "e diel",
               "e h\u00ebn\u00eb",
               "e mart\u00eb",
               "e m\u00ebrkur\u00eb",
               "e enjte",
               "e premte",
               "e shtun\u00eb",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Die",
               "H\u00ebn",
               "Mar",
               "M\u00ebr",
               "Enj",
               "Pre",
               "Sht",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "d",
               "h",
               "m",
               "m",
               "e",
               "p",
               "sh",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "tremujori i par\u00eb",
               "tremujori i dyt\u00eb",
               "tremujori i tret\u00eb",
               "tremujori i kat\u00ebrt",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "tremujori I",
               "tremujori II",
               "tremujori III",
               "tremujori IV",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "e paradites",
               "e pasdites",
               "e mesnat\u00ebs",
               "e mesdit\u00ebs",
               "e m\u00ebngjesit",
               "e paradites",
               "e pasdites",
               "",
               "e mbr\u00ebmjes",
               "",
               "e nat\u00ebs",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "p.d.",
               "m.d.",
               "e mesnat\u00ebs",
               "e mesdit\u00ebs",
               "e m\u00ebngjesit",
               "e paradites",
               "e pasdites",
               "",
               "e mbr\u00ebmjes",
               "",
               "e nat\u00ebs",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "p.K.",
               "mb.K.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a, zzzz",
               "h:mm:ss a, z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMM y G",
               "d MMM y G",
               "d MMM y G",
               "d.M.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMM y GGGG",
               "d MMM y GGGG",
               "d MMM y GGGG",
               "d.M.y G",
            };
        final String metaValue_calendarname_gregorian = "kalendar gregorian";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "vit" },
            { "calendarname.islamic-umalqura", "Kalendari Islamik (Um al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations",
                new String[] {
                    "Tremujori I",
                    "Tremujori II",
                    "Tremujori III",
                    "Tremujori IV",
                }
            },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Kalendari Islamik (tabelor, periudha civile)" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "timezone.regionFormat.standard", "Ora standarde: {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "kalendar japonez" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "die",
                    "h\u00ebn",
                    "mar",
                    "m\u00ebr",
                    "enj",
                    "pre",
                    "sht",
                }
            },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "para Krishtit",
                    "mbas Krishtit",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'n\u00eb' {0}",
                    "{1} 'n\u00eb' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
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
                    "NaN",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minut\u00eb" },
            { "field.era", "er\u00eb" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "paradite/pasdite" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "kalendar minguo" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "muaj" },
            { "field.second", "sekond\u00eb" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "kalendar islamik" },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:00:00-04:00;morning2:09:00-12:00;afternoon1:12:00-18:00;morning1:04:00-09:00;evening1:18:00-24:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Ora: {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'mij\u00eb other:0' 'mij\u00eb}",
                    "{one:00' 'mij\u00eb other:00' 'mij\u00eb}",
                    "{one:000' 'mij\u00eb other:000' 'mij\u00eb}",
                    "{one:0' 'milion other:0' 'milion}",
                    "{one:00' 'milion other:00' 'milion}",
                    "{one:000' 'milion other:000' 'milion}",
                    "{one:0' 'miliard other:0' 'miliard}",
                    "{one:00' 'miliard other:00' 'miliard}",
                    "{one:000' 'miliard other:000' 'miliard}",
                    "{one:0' 'bilion other:0' 'bilion}",
                    "{one:00' 'bilion other:00' 'bilion}",
                    "{one:000' 'bilion other:000' 'bilion}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames",
                new String[] {
                    "Tremujori i 1-r\u00eb",
                    "Tremujori i 2-t\u00eb",
                    "Tremujori i 3-t\u00eb",
                    "Tremujori i 4-t",
                }
            },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "brezi orar" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "dit\u00eb e jav\u00ebs" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "jav\u00eb" },
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
                    "{one:0\u00a0mij\u00eb other:0\u00a0mij\u00eb}",
                    "{one:00\u00a0mij\u00eb other:00\u00a0mij\u00eb}",
                    "{one:000\u00a0mij\u00eb other:000\u00a0mij\u00eb}",
                    "{one:0\u00a0mln other:0\u00a0mln}",
                    "{one:00\u00a0mln other:00\u00a0mln}",
                    "{one:000\u00a0mln other:000\u00a0mln}",
                    "{one:0\u00a0mld other:0\u00a0mld}",
                    "{one:00\u00a0mld other:00\u00a0mld}",
                    "{one:000\u00a0mld other:000\u00a0mld}",
                    "{one:0\u00a0bln other:0\u00a0bln}",
                    "{one:00\u00a0bln other:00\u00a0bln}",
                    "{one:000\u00a0bln other:000\u00a0bln}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Ora verore: {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "d.M.yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "field.hour", "or\u00eb" },
            { "calendarname.buddhist", "kalendar budist" },
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
