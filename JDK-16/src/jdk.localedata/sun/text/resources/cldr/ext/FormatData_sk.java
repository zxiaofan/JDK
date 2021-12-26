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

public class FormatData_sk extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "janu\u00e1ra",
               "febru\u00e1ra",
               "marca",
               "apr\u00edla",
               "m\u00e1ja",
               "j\u00fana",
               "j\u00fala",
               "augusta",
               "septembra",
               "okt\u00f3bra",
               "novembra",
               "decembra",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "jan",
               "feb",
               "mar",
               "apr",
               "m\u00e1j",
               "j\u00fan",
               "j\u00fal",
               "aug",
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
               "nede\u013ea",
               "pondelok",
               "utorok",
               "streda",
               "\u0161tvrtok",
               "piatok",
               "sobota",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "ne",
               "po",
               "ut",
               "st",
               "\u0161t",
               "pi",
               "so",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "n",
               "p",
               "u",
               "s",
               "\u0161",
               "p",
               "s",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. \u0161tvr\u0165rok",
               "2. \u0161tvr\u0165rok",
               "3. \u0161tvr\u0165rok",
               "4. \u0161tvr\u0165rok",
            };
        final String[] metaValue_standalone_QuarterAbbreviations = new String[] {
               "Q1",
               "Q2",
               "Q3",
               "Q4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "o polnoci",
               "napoludnie",
               "r\u00e1no",
               "dopoludnia",
               "popoludn\u00ed",
               "",
               "ve\u010der",
               "",
               "v noci",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "o poln.",
               "nap.",
               "r\u00e1no",
               "dop.",
               "pop.",
               "",
               "ve\u010d.",
               "",
               "v n.",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "o poln.",
               "napol.",
               "r\u00e1no",
               "dopol.",
               "popol.",
               "",
               "ve\u010der",
               "",
               "v noci",
               "",
            };
        final String[] metaValue_Eras = new String[] {
               "pred Kr.",
               "po Kr.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "H:mm:ss zzzz",
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
               "BE",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d. M. y G",
               "d. M. y G",
               "d. M. y G",
               "d.M.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d. M. y GGGG",
               "d. M. y GGGG",
               "d. M. y GGGG",
               "d.M.y G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "pred ROC",
               "ROC",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "AH",
            };
        final String metaValue_calendarname_gregorian = "gregori\u00e1nsky kalend\u00e1r";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "rok" },
            { "calendarname.islamic-umalqura", "islamsk\u00fd kalend\u00e1r (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "Islamsk\u00fd ob\u010diansky kalend\u00e1r" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "japonsk\u00fd kalend\u00e1r" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "long.Eras",
                new String[] {
                    "pred Kristom",
                    "po Kristovi",
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
                    "e",
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
            { "field.minute", "min\u00fata" },
            { "field.era", "letopo\u010det" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "al-muharram",
                    "safar",
                    "rab\u00ed\u00b4 al-avval",
                    "rab\u00ed\u00b4ath-th\u00e1n\u00ed",
                    "d\u017eum\u00e1d\u00e1 l-\u00fal\u00e1",
                    "d\u017eum\u00e1d\u00e1 l-\u00e1chira",
                    "rad\u017eab",
                    "\u0161a\u00b4 b\u00e1n",
                    "ramad\u00e1n",
                    "\u0161auv\u00e1l",
                    "dh\u00fa l-ka\u00b4 da",
                    "dh\u00fa l-hid\u017ed\u017ea",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "\u010d\u00ednsky republik\u00e1nsky kalend\u00e1r" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "field.month", "mesiac" },
            { "roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.second", "sekunda" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islamsk\u00fd kalend\u00e1r" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:22:00-04:00;morning2:09:00-12:00;afternoon1:12:00-18:00;morning1:04:00-09:00;evening1:18:00-22:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "\u010dasov\u00e9 p\u00e1smo {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'tis\u00edc few:0' 'tis\u00edce many:0' 'tis\u00edca other:0' 'tis\u00edc}",
                    "{one:00' 'tis\u00edc few:00' 'tis\u00edc many:00' 'tis\u00edca other:00' 'tis\u00edc}",
                    "{one:000' 'tis\u00edc few:000' 'tis\u00edc many:000' 'tis\u00edca other:000' 'tis\u00edc}",
                    "{one:0' 'mili\u00f3n few:0' 'mili\u00f3ny many:0' 'mili\u00f3na other:0' 'mili\u00f3nov}",
                    "{one:00' 'mili\u00f3nov few:00' 'mili\u00f3nov many:00' 'mili\u00f3na other:00' 'mili\u00f3nov}",
                    "{one:000' 'mili\u00f3nov few:000' 'mili\u00f3nov many:000' 'mili\u00f3na other:000' 'mili\u00f3nov}",
                    "{one:0' 'miliarda few:0' 'miliardy many:0' 'miliardy other:0' 'mili\u00e1rd}",
                    "{one:00' 'mili\u00e1rd few:00' 'mili\u00e1rd many:00' 'miliardy other:00' 'mili\u00e1rd}",
                    "{one:000' 'mili\u00e1rd few:000' 'mili\u00e1rd many:000' 'miliardy other:000' 'mili\u00e1rd}",
                    "{one:0' 'bili\u00f3n few:0' 'bili\u00f3ny many:0' 'bili\u00f3na other:0' 'bili\u00f3nov}",
                    "{one:00' 'bili\u00f3nov few:00' 'bili\u00f3nov many:00' 'bili\u00f3na other:00' 'bili\u00f3nov}",
                    "{one:000' 'bili\u00f3nov few:000' 'bili\u00f3nov many:000' 'bili\u00f3na other:000' 'bili\u00f3nov}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "java.time.roc.Eras", metaValue_java_time_roc_long_Eras },
            { "field.zone", "\u010dasov\u00e9 p\u00e1smo" },
            { "japanese.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_long_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "de\u0148 t\u00fd\u017ed\u0148a" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "java.time.islamic.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "t\u00fd\u017ede\u0148" },
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
                    "{one:0\u00a0tis'.' few:0\u00a0tis'.' many:0\u00a0tis'.' other:0\u00a0tis'.'}",
                    "{one:00\u00a0tis'.' few:00\u00a0tis'.' many:00\u00a0tis'.' other:00\u00a0tis'.'}",
                    "{one:000\u00a0tis'.' few:000\u00a0tis'.' many:000\u00a0tis'.' other:000\u00a0tis'.'}",
                    "{one:0\u00a0mil'.' few:0\u00a0mil'.' many:0\u00a0mil'.' other:0\u00a0mil'.'}",
                    "{one:00\u00a0mil'.' few:00\u00a0mil'.' many:00\u00a0mil'.' other:00\u00a0mil'.'}",
                    "{one:000\u00a0mil'.' few:000\u00a0mil'.' many:000\u00a0mil'.' other:000\u00a0mil'.'}",
                    "{one:0\u00a0mld'.' few:0\u00a0mld'.' many:0\u00a0mld'.' other:0\u00a0mld'.'}",
                    "{one:00\u00a0mld'.' few:00\u00a0mld'.' many:00\u00a0mld'.' other:00\u00a0mld'.'}",
                    "{one:000\u00a0mld'.' few:000\u00a0mld'.' many:000\u00a0mld'.' other:000\u00a0mld'.'}",
                    "{one:0\u00a0bil'.' few:0\u00a0bil'.' many:0\u00a0bil'.' other:0\u00a0bil'.'}",
                    "{one:00\u00a0bil'.' few:00\u00a0bil'.' many:00\u00a0bil'.' other:00\u00a0bil'.'}",
                    "{one:000\u00a0bil'.' few:000\u00a0bil'.' many:000\u00a0bil'.' other:000\u00a0bil'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "DatePatterns",
                new String[] {
                    "EEEE d. MMMM y",
                    "d. MMMM y",
                    "d. M. y",
                    "d. M. y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:i = 1 and v = 0;few:i = 2..4 and v = 0;many:v != 0" },
            { "field.hour", "hodina" },
            { "islamic.MonthAbbreviations",
                new String[] {
                    "muh.",
                    "saf.",
                    "rab. I",
                    "rab. II",
                    "d\u017eum. I",
                    "d\u017eum. II",
                    "rad.",
                    "\u0161a.",
                    "ram.",
                    "\u0161au.",
                    "dh\u00fa l-k.",
                    "dh\u00fa l-h.",
                    "",
                }
            },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_long_Eras },
            { "calendarname.buddhist", "buddhistick\u00fd kalend\u00e1r" },
            { "standalone.MonthNames",
                new String[] {
                    "janu\u00e1r",
                    "febru\u00e1r",
                    "marec",
                    "apr\u00edl",
                    "m\u00e1j",
                    "j\u00fan",
                    "j\u00fal",
                    "august",
                    "september",
                    "okt\u00f3ber",
                    "november",
                    "december",
                    "",
                }
            },
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
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
