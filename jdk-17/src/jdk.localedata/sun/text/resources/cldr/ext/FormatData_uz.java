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

public class FormatData_uz extends ListResourceBundle {
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
               "avgust",
               "sentabr",
               "oktabr",
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
               "avg",
               "sen",
               "okt",
               "noy",
               "dek",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "Y",
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
               "yakshanba",
               "dushanba",
               "seshanba",
               "chorshanba",
               "payshanba",
               "juma",
               "shanba",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Yak",
               "Dush",
               "Sesh",
               "Chor",
               "Pay",
               "Jum",
               "Shan",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "Y",
               "D",
               "S",
               "C",
               "P",
               "J",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1-chorak",
               "2-chorak",
               "3-chorak",
               "4-chorak",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1-ch",
               "2-ch",
               "3-ch",
               "4-ch",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "TO",
               "TK",
               "yarim tun",
               "tush payti",
               "ertalab",
               "",
               "kunduzi",
               "",
               "kechqurun",
               "",
               "kechasi",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "m.a.",
               "milodiy",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "H:mm:ss (zzzz)",
               "H:mm:ss (z)",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d-MMMM, y (G)",
               "d-MMMM, y (G)",
               "d-MMM, y (G)",
               "dd.MM.y (GGGGG)",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d-MMMM, y (GGGG)",
               "d-MMMM, y (GGGG)",
               "d-MMM, y (GGGG)",
               "dd.MM.y (G)",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "Hijriy yil",
            };
        final String metaValue_calendarname_gregorian = "grigorian taqvimi";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "yil" },
            { "arabext.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a",
                    "\u06f0",
                    "#",
                    "-",
                    "\u00d7\u06f1\u06f0^",
                    "\u0609",
                    "\u221e",
                    "son\u00a0emas",
                    "",
                    "",
                }
            },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "yapon taqvimi" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras",
                new String[] {
                    "miloddan avvalgi",
                    "milodiy",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
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
            { "narrow.AmPmMarkers", metaValue_AmPmMarkers },
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
                    "son\u00a0emas",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "daqiqa" },
            { "field.era", "era" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "TO/TK" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "Muharram",
                    "Safar",
                    "Robi\u2019 ul-avval",
                    "Robi\u2019 ul-oxir",
                    "Jumad ul-avval",
                    "Jumad ul-oxir",
                    "Rajab",
                    "Sha\u2019bon",
                    "Ramazon",
                    "Shavvol",
                    "Zul-qa\u2019da",
                    "Zul-hijja",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Mingo taqvimi" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "oy" },
            { "arabext.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "",
                }
            },
            { "field.second", "soniya" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islomiy taqvim" },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:22:00-06:00;afternoon1:11:00-18:00;morning1:06:00-11:00;evening1:18:00-22:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "Yan",
                    "Fev",
                    "Mar",
                    "Apr",
                    "May",
                    "Iyn",
                    "Iyl",
                    "Avg",
                    "Sen",
                    "Okt",
                    "Noy",
                    "Dek",
                    "",
                }
            },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'ming other:0' 'ming}",
                    "{one:00' 'ming other:00' 'ming}",
                    "{one:000' 'ming other:000' 'ming}",
                    "{one:0' 'million other:0' 'million}",
                    "{one:00' 'million other:00' 'million}",
                    "{one:000' 'million other:000' 'million}",
                    "{one:0' 'milliard other:0' 'milliard}",
                    "{one:00' 'milliard other:00' 'milliard}",
                    "{one:000' 'milliard other:000' 'milliard}",
                    "{one:0' 'trillion other:0' 'trillion}",
                    "{one:00' 'trillion other:00' 'trillion}",
                    "{one:000' 'trillion other:000' 'trillion}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "vaqt mintaqasi" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "hafta kuni" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "hafta" },
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
                    "{one:0\u00a0ming other:0\u00a0ming}",
                    "{one:00\u00a0ming other:00\u00a0ming}",
                    "{one:000\u00a0ming other:000\u00a0ming}",
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
            { "DatePatterns",
                new String[] {
                    "EEEE, d-MMMM, y",
                    "d-MMMM, y",
                    "d-MMM, y",
                    "dd/MM/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1" },
            { "field.hour", "soat" },
            { "islamic.MonthAbbreviations",
                new String[] {
                    "Muh.",
                    "Saf.",
                    "Rob. avv.",
                    "Rob. ox.",
                    "Jum. avv.",
                    "Jum. ox.",
                    "Raj.",
                    "Sha.",
                    "Ram.",
                    "Shav.",
                    "Zul-q.",
                    "Zul-h.",
                    "",
                }
            },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "buddizm taqvimi" },
            { "standalone.MonthNames",
                new String[] {
                    "Yanvar",
                    "Fevral",
                    "Mart",
                    "Aprel",
                    "May",
                    "Iyun",
                    "Iyul",
                    "Avgust",
                    "Sentabr",
                    "Oktabr",
                    "Noyabr",
                    "Dekabr",
                    "",
                }
            },
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
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
