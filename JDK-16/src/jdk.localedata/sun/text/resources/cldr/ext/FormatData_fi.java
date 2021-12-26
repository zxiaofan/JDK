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

public class FormatData_fi extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "tammikuuta",
               "helmikuuta",
               "maaliskuuta",
               "huhtikuuta",
               "toukokuuta",
               "kes\u00e4kuuta",
               "hein\u00e4kuuta",
               "elokuuta",
               "syyskuuta",
               "lokakuuta",
               "marraskuuta",
               "joulukuuta",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "tammik.",
               "helmik.",
               "maalisk.",
               "huhtik.",
               "toukok.",
               "kes\u00e4k.",
               "hein\u00e4k.",
               "elok.",
               "syysk.",
               "lokak.",
               "marrask.",
               "jouluk.",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "T",
               "H",
               "M",
               "H",
               "T",
               "K",
               "H",
               "E",
               "S",
               "L",
               "M",
               "J",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "sunnuntaina",
               "maanantaina",
               "tiistaina",
               "keskiviikkona",
               "torstaina",
               "perjantaina",
               "lauantaina",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "su",
               "ma",
               "ti",
               "ke",
               "to",
               "pe",
               "la",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "M",
               "T",
               "K",
               "T",
               "P",
               "L",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. nelj\u00e4nnes",
               "2. nelj\u00e4nnes",
               "3. nelj\u00e4nnes",
               "4. nelj\u00e4nnes",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1. nelj.",
               "2. nelj.",
               "3. nelj.",
               "4. nelj.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "ap.",
               "ip.",
               "keskiy\u00f6ll\u00e4",
               "keskip\u00e4iv\u00e4ll\u00e4",
               "aamulla",
               "aamup\u00e4iv\u00e4ll\u00e4",
               "iltap\u00e4iv\u00e4ll\u00e4",
               "",
               "illalla",
               "",
               "y\u00f6ll\u00e4",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "ap.",
               "ip.",
               "ky.",
               "kp.",
               "aamulla",
               "ap.",
               "ip.",
               "",
               "illalla",
               "",
               "y\u00f6ll\u00e4",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "ap.",
               "ip.",
               "keskiy\u00f6ll\u00e4",
               "keskip.",
               "aamulla",
               "aamup.",
               "iltap.",
               "",
               "illalla",
               "",
               "y\u00f6ll\u00e4",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "H.mm.ss zzzz",
               "H.mm.ss z",
               "H.mm.ss",
               "H.mm",
            };
        final String[] metaValue_DateTimePatterns = new String[] {
               "{1} 'klo' {0}",
               "{1} 'klo' {0}",
               "{1} 'klo' {0}",
               "{1} {0}",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "buddhalainen aika",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "cccc d. MMMM y G",
               "d. MMMM y G",
               "d.M.y G",
               "d.M.y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE d. MMMM y GGGG",
               "d. MMMM y GGGG",
               "d.M.y GGGG",
               "d.M.y G",
            };
        final String[] metaValue_java_time_roc_long_Eras = new String[] {
               "ennen Kiinan tasavaltaa",
               "Minguo",
            };
        final String[] metaValue_java_time_roc_Eras = new String[] {
               "e. Kiinan tasav.",
               "Minguo",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "hid\u017eran j\u00e4lkeen",
            };
        final String metaValue_calendarname_gregorian = "gregoriaaninen kalenteri";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "vuosi" },
            { "calendarname.islamic-umalqura", "islamilainen Umm al-Qura -kalenteri" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.gmtFormat", "UTC{0}" },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "islamilainen siviilikalenteri, perjantai-epookki" },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "narrow.Eras",
                new String[] {
                    "eKr",
                    "jKr",
                }
            },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0} (normaaliaika)" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "japanilainen kalenteri" },
            { "timezone.gmtZeroFormat", "UTC" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "ennen Kristuksen syntym\u00e4\u00e4",
                    "j\u00e4lkeen Kristuksen syntym\u00e4n",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns", metaValue_DateTimePatterns },
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
                    "E",
                    "\u2030",
                    "\u221e",
                    "ep\u00e4luku",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "minuutti" },
            { "field.era", "aikakausi" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "vuorokaudenaika" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.MonthNames",
                new String[] {
                    "muharram",
                    "safar",
                    "rabi\u2019 al-awwal",
                    "rabi\u2019 al-akhir",
                    "d\u017eumada-l-ula",
                    "d\u017eumada-l-akhira",
                    "rad\u017eab",
                    "\u0161a\u2019ban",
                    "ramadan",
                    "\u0161awwal",
                    "dhu-l-qa\u2019da",
                    "dhu-l-hidd\u017ea",
                    "",
                }
            },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "Kiinan tasavallan kalenteri" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "kuukausi" },
            { "roc.Eras", metaValue_java_time_roc_Eras },
            { "field.second", "sekunti" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "islamilainen kalenteri" },
            { "java.time.roc.long.Eras", metaValue_java_time_roc_long_Eras },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;night1:23:00-05:00;morning2:10:00-12:00;afternoon1:12:00-18:00;morning1:05:00-10:00;evening1:18:00-23:00" },
            { "java.time.roc.narrow.Eras", metaValue_java_time_roc_Eras },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "tammi",
                    "helmi",
                    "maalis",
                    "huhti",
                    "touko",
                    "kes\u00e4",
                    "hein\u00e4",
                    "elo",
                    "syys",
                    "loka",
                    "marras",
                    "joulu",
                    "",
                }
            },
            { "timezone.regionFormat", "aikavy\u00f6hyke: {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'tuhat other:0' 'tuhatta}",
                    "{one:00' 'tuhatta other:00' 'tuhatta}",
                    "{one:000' 'tuhatta other:000' 'tuhatta}",
                    "{one:0' 'miljoona other:0' 'miljoonaa}",
                    "{one:00' 'miljoonaa other:00' 'miljoonaa}",
                    "{one:000' 'miljoonaa other:000' 'miljoonaa}",
                    "{one:0' 'miljardi other:0' 'miljardia}",
                    "{one:00' 'miljardia other:00' 'miljardia}",
                    "{one:000' 'miljardia other:000' 'miljardia}",
                    "{one:0' 'biljoona other:0' 'biljoonaa}",
                    "{one:00' 'biljoonaa other:00' 'biljoonaa}",
                    "{one:000' 'biljoonaa other:000' 'biljoonaa}",
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
            { "java.time.roc.Eras", metaValue_java_time_roc_Eras },
            { "field.zone", "aikavy\u00f6hyke" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.narrow.Eras", metaValue_java_time_roc_Eras },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras",
                new String[] {
                    "eKr.",
                    "jKr.",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "viikonp\u00e4iv\u00e4" },
            { "java.time.DatePatterns",
                new String[] {
                    "cccc d. MMMM y",
                    "d. MMMM y",
                    "d.M.y",
                    "d.M.y",
                }
            },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "timezone.hourFormat", "+H.mm;-H.mm" },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "viikko" },
            { "buddhist.DateTimePatterns", metaValue_DateTimePatterns },
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
                    "{one:0\u00a0t'.' other:0\u00a0t'.'}",
                    "{one:00\u00a0t'.' other:00\u00a0t'.'}",
                    "{one:000\u00a0t'.' other:000\u00a0t'.'}",
                    "{one:0\u00a0milj'.' other:0\u00a0milj'.'}",
                    "{one:00\u00a0milj'.' other:00\u00a0milj'.'}",
                    "{one:000\u00a0milj'.' other:000\u00a0milj'.'}",
                    "{one:0\u00a0mrd'.' other:0\u00a0mrd'.'}",
                    "{one:00\u00a0mrd'.' other:00\u00a0mrd'.'}",
                    "{one:000\u00a0mrd'.' other:000\u00a0mrd'.'}",
                    "{one:0\u00a0bilj'.' other:0\u00a0bilj'.'}",
                    "{one:00\u00a0bilj'.' other:00\u00a0bilj'.'}",
                    "{one:000\u00a0bilj'.' other:000\u00a0bilj'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "{0} (kes\u00e4aika)" },
            { "DatePatterns",
                new String[] {
                    "EEEE d. MMMM y",
                    "d. MMMM y",
                    "d.M.y",
                    "d.M.y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames",
                new String[] {
                    "sunnuntai",
                    "maanantai",
                    "tiistai",
                    "keskiviikko",
                    "torstai",
                    "perjantai",
                    "lauantai",
                }
            },
            { "PluralRules", "one:i = 1 and v = 0" },
            { "field.hour", "tunti" },
            { "calendarname.buddhist", "buddhalainen kalenteri" },
            { "standalone.MonthNames",
                new String[] {
                    "tammikuu",
                    "helmikuu",
                    "maaliskuu",
                    "huhtikuu",
                    "toukokuu",
                    "kes\u00e4kuu",
                    "hein\u00e4kuu",
                    "elokuu",
                    "syyskuu",
                    "lokakuu",
                    "marraskuu",
                    "joulukuu",
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
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
