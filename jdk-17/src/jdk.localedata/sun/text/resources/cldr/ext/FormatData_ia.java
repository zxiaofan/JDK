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

public class FormatData_ia extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "januario",
               "februario",
               "martio",
               "april",
               "maio",
               "junio",
               "julio",
               "augusto",
               "septembre",
               "octobre",
               "novembre",
               "decembre",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan",
               "feb",
               "mar",
               "apr",
               "mai",
               "jun",
               "jul",
               "aug",
               "sep",
               "oct",
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
               "dominica",
               "lunedi",
               "martedi",
               "mercuridi",
               "jovedi",
               "venerdi",
               "sabbato",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "dom",
               "lun",
               "mar",
               "mer",
               "jov",
               "ven",
               "sab",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "d",
               "l",
               "m",
               "m",
               "j",
               "v",
               "s",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1me trimestre",
               "2nde trimestre",
               "3tie trimestre",
               "4te trimestre",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "T1",
               "T2",
               "T3",
               "T4",
            };
        final String[] metaValue_Eras = new String[] {
               "a.Chr.",
               "p.Chr.",
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
               "EEEE 'le' d 'de' MMMM y G",
               "d 'de' MMMM y G",
               "d MMM y G",
               "dd-MM-y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE 'le' d 'de' MMMM y GGGG",
               "d 'de' MMMM y GGGG",
               "d MMM y GGGG",
               "dd-MM-y G",
            };
        final String metaValue_calendarname_gregorian = "calendario gregorian";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "anno" },
            { "japanese.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "timezone.regionFormat.standard", "hora normal de {0}" },
            { "calendarname.japanese", "calendario japonese" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "ante Christo",
                    "post Christo",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'a' {0}",
                    "{1} 'a' {0}",
                    "{1} {0}",
                    "{1} {0}",
                }
            },
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
            { "field.minute", "minuta" },
            { "field.era", "era" },
            { "buddhist.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "calendario del Republica de China" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "mense" },
            { "field.second", "secunda" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "calendario islamic" },
            { "japanese.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "hora de {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'mil other:0' 'milles}",
                    "{one:00' 'mil other:00' 'milles}",
                    "{one:000' 'mil other:000' 'milles}",
                    "{one:0' 'mln other:0' 'milliones}",
                    "{one:00' 'mln other:00' 'milliones}",
                    "{one:000' 'mln other:000' 'milliones}",
                    "{one:0' 'mld other:0' 'milliardos}",
                    "{one:00' 'mld other:00' 'milliardos}",
                    "{one:000' 'mld other:000' 'milliardos}",
                    "{one:0' 'bln other:0' 'billiones}",
                    "{one:00' 'bln other:00' 'billiones}",
                    "{one:000' 'bln other:000' 'billiones}",
                }
            },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "fuso horari" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "die del septimana" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "septimana" },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0\u00a0mil other:0\u00a0mil}",
                    "{one:00\u00a0mil other:00\u00a0mil}",
                    "{one:000\u00a0mil other:000\u00a0mil}",
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
            { "timezone.regionFormat.daylight", "hora estive de {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE 'le' d 'de' MMMM y",
                    "d 'de' MMMM y",
                    "d MMM y",
                    "dd-MM-y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 1 and v = 0" },
            { "field.hour", "hora" },
            { "calendarname.buddhist", "calendario buddhista" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4\u00a0#,##0.00;(\u00a4\u00a0#,##0.00)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
