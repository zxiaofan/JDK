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

public class FormatData_fo extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "januar",
               "februar",
               "mars",
               "apr\u00edl",
               "mai",
               "juni",
               "juli",
               "august",
               "september",
               "oktober",
               "november",
               "desember",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan.",
               "feb.",
               "mar.",
               "apr.",
               "mai",
               "jun.",
               "jul.",
               "aug.",
               "sep.",
               "okt.",
               "nov.",
               "des.",
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
               "sunnudagur",
               "m\u00e1nadagur",
               "t\u00fdsdagur",
               "mikudagur",
               "h\u00f3sdagur",
               "fr\u00edggjadagur",
               "leygardagur",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "sun.",
               "m\u00e1n.",
               "t\u00fds.",
               "mik.",
               "h\u00f3s.",
               "fr\u00ed.",
               "ley.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "M",
               "T",
               "M",
               "H",
               "F",
               "L",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. \u00e1rsfj\u00f3r\u00f0ingur",
               "2. \u00e1rsfj\u00f3r\u00f0ingur",
               "3. \u00e1rsfj\u00f3r\u00f0ingur",
               "4. \u00e1rsfj\u00f3r\u00f0ingur",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1. \u00e1rsfj.",
               "2. \u00e1rsfj.",
               "3. \u00e1rsfj.",
               "4. \u00e1rsfj.",
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
               "EEEE, dd. MMMM y G",
               "d. MMMM y G",
               "d. MMM y G",
               "dd.MM.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, dd. MMMM y GGGG",
               "d. MMMM y GGGG",
               "d. MMM y GGGG",
               "dd.MM.y G",
            };
        final String metaValue_calendarname_gregorian = "gregorianskur kalendari";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\u00e1r" },
            { "japanese.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras",
                new String[] {
                    "fKr",
                    "eKr",
                }
            },
            { "timezone.regionFormat.standard", "{0} vanlig t\u00ed\u00f0" },
            { "calendarname.japanese", "japanskur kalendari" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "sun",
                    "m\u00e1n",
                    "t\u00fds",
                    "mik",
                    "h\u00f3s",
                    "fr\u00ed",
                    "ley",
                }
            },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "fyri Krist",
                    "eftir Krist",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'kl'. {0}",
                    "{1} 'kl'. {0}",
                    "{1}, {0}",
                    "{1}, {0}",
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
                    "\u2212",
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
            { "field.minute", "minuttur" },
            { "field.era", "t\u00ed\u00f0arrokning" },
            { "buddhist.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "minguo kalendari" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "m\u00e1na\u00f0ur" },
            { "field.second", "sekund" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islamiskur kalendari" },
            { "japanese.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "jan",
                    "feb",
                    "mar",
                    "apr",
                    "mai",
                    "jun",
                    "jul",
                    "aug",
                    "sep",
                    "okt",
                    "nov",
                    "des",
                    "",
                }
            },
            { "timezone.regionFormat", "{0} t\u00ed\u00f0" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 't\u00fasund other:0' 't\u00fasund}",
                    "{one:00' 't\u00fasund other:00' 't\u00fasund}",
                    "{one:000' 't\u00fasund other:000' 't\u00fasund}",
                    "{one:0' 'milli\u00f3n other:0' 'milli\u00f3nir}",
                    "{one:00' 'milli\u00f3nir other:00' 'milli\u00f3nir}",
                    "{one:000' 'milli\u00f3nir other:000' 'milli\u00f3nir}",
                    "{one:0' 'milliard other:0' 'milliardir}",
                    "{one:00' 'milliardir other:00' 'milliardir}",
                    "{one:000' 'milliardir other:000' 'milliardir}",
                    "{one:0' 'billi\u00f3n other:0' 'billi\u00f3nir}",
                    "{one:00' 'billi\u00f3nir other:00' 'billi\u00f3nir}",
                    "{one:000' 'billi\u00f3nir other:000' 'billi\u00f3nir}",
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
            { "field.zone", "t\u00ed\u00f0ar\u00f8ki" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "Eras",
                new String[] {
                    "f.Kr.",
                    "e.Kr.",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "vikudagur" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "vika" },
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
                    "{one:0\u00a0t\u00fas'.' other:0\u00a0t\u00fas'.'}",
                    "{one:00\u00a0t\u00fas'.' other:00\u00a0t\u00fas'.'}",
                    "{one:000\u00a0t\u00fas'.' other:000\u00a0t\u00fas'.'}",
                    "{one:0\u00a0mi\u00f3'.' other:0\u00a0mi\u00f3'.'}",
                    "{one:00\u00a0mi\u00f3'.' other:00\u00a0mi\u00f3'.'}",
                    "{one:000\u00a0mi\u00f3'.' other:000\u00a0mi\u00f3'.'}",
                    "{one:0\u00a0mia'.' other:0\u00a0mia'.'}",
                    "{one:00\u00a0mia'.' other:00\u00a0mia'.'}",
                    "{one:000\u00a0mia'.' other:000\u00a0mia'.'}",
                    "{one:0\u00a0bi\u00f3'.' other:0\u00a0bi\u00f3'.'}",
                    "{one:00\u00a0bi\u00f3'.' other:00\u00a0bi\u00f3'.'}",
                    "{one:000\u00a0bi\u00f3'.' other:000\u00a0bi\u00f3'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "{0} summart\u00ed\u00f0" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d. MMMM y",
                    "d. MMMM y",
                    "dd.MM.y",
                    "dd.MM.yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "field.hour", "t\u00edmi" },
            { "calendarname.buddhist", "buddistiskur kalendari" },
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
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
