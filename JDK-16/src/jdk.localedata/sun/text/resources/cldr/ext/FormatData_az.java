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

public class FormatData_az extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "yanvar",
               "fevral",
               "mart",
               "aprel",
               "may",
               "iyun",
               "iyul",
               "avqust",
               "sentyabr",
               "oktyabr",
               "noyabr",
               "dekabr",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "yan",
               "fev",
               "mar",
               "apr",
               "may",
               "iyn",
               "iyl",
               "avq",
               "sen",
               "okt",
               "noy",
               "dek",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "bazar",
               "bazar ert\u0259si",
               "\u00e7\u0259r\u015f\u0259nb\u0259 ax\u015fam\u0131",
               "\u00e7\u0259r\u015f\u0259nb\u0259",
               "c\u00fcm\u0259 ax\u015fam\u0131",
               "c\u00fcm\u0259",
               "\u015f\u0259nb\u0259",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "B.",
               "B.e.",
               "\u00c7.a.",
               "\u00c7.",
               "C.a.",
               "C.",
               "\u015e.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "7",
               "1",
               "2",
               "3",
               "4",
               "5",
               "6",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1-ci kvartal",
               "2-ci kvartal",
               "3-c\u00fc kvartal",
               "4-c\u00fc kvartal",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1-ci kv.",
               "2-ci kv.",
               "3-c\u00fc kv.",
               "4-c\u00fc kv.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "gec\u0259yar\u0131",
               "g\u00fcnorta",
               "s\u00fcbh",
               "s\u0259h\u0259r",
               "g\u00fcnd\u00fcz",
               "",
               "ax\u015fam\u00fcst\u00fc",
               "",
               "ax\u015fam",
               "gec\u0259",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a",
               "p",
               "gec\u0259yar\u0131",
               "g",
               "s\u00fcbh",
               "s\u0259h\u0259r",
               "g\u00fcnd\u00fcz",
               "",
               "ax\u015fam\u00fcst\u00fc",
               "",
               "ax\u015fam",
               "gec\u0259",
            };
        final String[] metaValue_Eras = new String[] {
               "e.\u0259.",
               "y.e.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_MonthNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
               "5",
               "6",
               "7",
               "8",
               "9",
               "10",
               "11",
               "12",
               "",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "G d MMMM y, EEEE",
               "G d MMMM, y",
               "G d MMM y",
               "GGGGG dd.MM.y",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "GGGG d MMMM y, EEEE",
               "GGGG d MMMM, y",
               "GGGG d MMM y",
               "G dd.MM.y",
            };
        final String metaValue_calendarname_gregorian = "Qreqorian T\u0259qvimi";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\u0130l" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "calendarname.islamic-civil", "Ivrit t\u0259qvimi" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0} Standart Vaxt\u0131" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "Yapon T\u0259qvimi" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "B.",
                    "B.E.",
                    "\u00c7.A.",
                    "\u00c7.",
                    "C.A.",
                    "C.",
                    "\u015e.",
                }
            },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "eram\u0131zdan \u0259vv\u0259l",
                    "yeni era",
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
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "D\u0259qiq\u0259" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "islamic.MonthNames",
                new String[] {
                    "M\u0259h\u0259rr\u0259m",
                    "S\u0259f\u0259r",
                    "R\u0259bi\u00fcl\u0259vv\u0259l",
                    "R\u0259bi\u00fclax\u0131r",
                    "C\u0259madiy\u0259l\u0259vv\u0259l",
                    "C\u0259madiy\u0259lax\u0131r",
                    "R\u0259c\u0259b",
                    "\u015eaban",
                    "Ramazan",
                    "\u015e\u0259vval",
                    "Zilq\u0259d\u0259",
                    "Zilhicc\u0259",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Minquo T\u0259qvimi" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "Ay" },
            { "field.second", "Saniy\u0259" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "\u0130slam T\u0259qvimi" },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:19:00-24:00;morning2:06:00-12:00;afternoon1:12:00-17:00;morning1:04:00-06:00;evening1:17:00-19:00;night2:00:00-04:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "{0} Vaxt\u0131" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'min other:0' 'min}",
                    "{one:00' 'min other:00' 'min}",
                    "{one:000' 'min other:000' 'min}",
                    "{one:0' 'milyon other:0' 'milyon}",
                    "{one:00' 'milyon other:00' 'milyon}",
                    "{one:000' 'milyon other:000' 'milyon}",
                    "{one:0' 'milyard other:0' 'milyard}",
                    "{one:00' 'milyard other:00' 'milyard}",
                    "{one:000' 'milyard other:000' 'milyard}",
                    "{one:0' 'trilyon other:0' 'trilyon}",
                    "{one:00' 'trilyon other:00' 'trilyon}",
                    "{one:000' 'trilyon other:000' 'trilyon}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "Saat Qur\u015fa\u011f\u0131" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "H\u0259ft\u0259nin G\u00fcn\u00fc" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "H\u0259ft\u0259" },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "buddhist.MonthNarrows", metaValue_buddhist_MonthNarrows },
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
                    "{one:0K other:0K}",
                    "{one:00K other:00K}",
                    "{one:000K other:000K}",
                    "{one:0\u00a0mln other:0\u00a0mln}",
                    "{one:00\u00a0mln other:00\u00a0mln}",
                    "{one:000\u00a0mln other:000\u00a0mln}",
                    "{one:0\u00a0mlrd other:0\u00a0mlrd}",
                    "{one:00\u00a0mlrd other:00\u00a0mlrd}",
                    "{one:000\u00a0mlrd other:000\u00a0mlrd}",
                    "{one:0\u00a0trln other:0\u00a0trln}",
                    "{one:00\u00a0trln other:00\u00a0trln}",
                    "{one:000\u00a0trln other:000\u00a0trln}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "{0} Yay Vaxt\u0131" },
            { "DatePatterns",
                new String[] {
                    "d MMMM y, EEEE",
                    "d MMMM y",
                    "d MMM y",
                    "dd.MM.yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "field.hour", "Saat" },
            { "islamic.MonthAbbreviations",
                new String[] {
                    "M\u0259h.",
                    "S\u0259f.",
                    "R\u0259b. I",
                    "R\u0259b. II",
                    "C\u0259m. I",
                    "C\u0259m. II",
                    "R\u0259c.",
                    "\u015eab.",
                    "Ram.",
                    "\u015e\u0259v.",
                    "Zilq.",
                    "Zilh.",
                    "",
                }
            },
            { "calendarname.buddhist", "Buddist T\u0259qvimi" },
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
