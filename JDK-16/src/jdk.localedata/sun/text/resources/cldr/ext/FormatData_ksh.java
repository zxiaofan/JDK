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

public class FormatData_ksh extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Jannewa",
               "F\u00e4browa",
               "M\u00e4\u00e4z",
               "Aprell",
               "Mai",
               "Juuni",
               "Juuli",
               "Oujo\u00df",
               "Sept\u00e4mber",
               "Oktohber",
               "Nov\u00e4mber",
               "Dez\u00e4mber",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan",
               "F\u00e4b",
               "M\u00e4z",
               "Apr",
               "Mai",
               "Jun",
               "Jul",
               "Ouj",
               "S\u00e4p",
               "Okt",
               "Nov",
               "Dez",
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
               "O",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Sunndaach",
               "Mohndaach",
               "Dinnsdaach",
               "Metwoch",
               "Dunnersdaach",
               "Friidaach",
               "Samsdaach",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Su.",
               "Mo.",
               "Di.",
               "Me.",
               "Du.",
               "Fr.",
               "Sa.",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "M",
               "D",
               "M",
               "D",
               "F",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1. Quattahl",
               "2. Quattahl",
               "3. Quattahl",
               "4. Quattahl",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "1.Q.",
               "2.Q.",
               "3.Q.",
               "4.Q.",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "Uhr v\u00f6rmiddaachs",
               "Uhr nommendaachs",
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
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "v.M.",
               "n.M.",
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
        final String[] metaValue_java_time_japanese_DatePatterns = new String[] {
               "EEEE, 'd\u00e4' d. MMMM y G",
               "d. MMMM y G",
               "d. MMM. y G",
               "d. M. y GGGGG",
            };
        final String[] metaValue_japanese_DatePatterns = new String[] {
               "EEEE, 'd\u00e4' d. MMMM y GGGG",
               "d. MMMM y GGGG",
               "d. MMM. y GGGG",
               "d. M. y G",
            };
        final String metaValue_calendarname_gregorian = "jrejorejahnesche Kal\u00e4nnder";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Johr" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "calendarname.islamic-civil", "w\u00e4ltlesche islaamesche Kal\u00e4nder" },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras",
                new String[] {
                    "vC",
                    "nC",
                }
            },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "timezone.regionFormat.standard", "Schtandattzick vun {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "japaanesche Kal\u00e4nder" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "v\u00fcr Krestos",
                    "noh Krestos",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
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
            { "japanese.DatePatterns", metaValue_japanese_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "Menutt" },
            { "field.era", "\u00c4hra" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "Daachteil" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "rotschineesesche Kal\u00e4nder" },
            { "islamic.DatePatterns", metaValue_japanese_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "Mohnd" },
            { "field.second", "Sekond" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_japanese_DatePatterns },
            { "calendarname.islamic", "i\u00dflaamesche Kal\u00e4nder" },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "Jan.",
                    "F\u00e4b.",
                    "M\u00e4z.",
                    "Apr.",
                    "Mai",
                    "Jun.",
                    "Jul.",
                    "Ouj.",
                    "S\u00e4p.",
                    "Okt.",
                    "Nov.",
                    "Dez.",
                    "",
                }
            },
            { "timezone.regionFormat", "Zick vun {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{zero:0' 'Dousend one:0' 'Dousend other:0' 'Dousend}",
                    "{zero:00' 'Dousend one:00' 'Dousend other:00' 'Dousend}",
                    "{zero:000' 'Dousend one:000' 'Dousend other:000' 'Dousend}",
                    "{zero:0' 'Milljuhne one:0' 'Million other:0' 'Milljuhne}",
                    "{zero:00' 'Milljuhne one:00' 'Milljuhne other:00' 'Millionen}",
                    "{zero:000' 'Milljuhne one:000' 'Milljuhne other:000' 'Millionen}",
                    "{zero:0' 'Milljard one:0' 'Milliarde other:0' 'Milljarde}",
                    "{zero:00' 'Milljarde one:00' 'Milljarde other:00' 'Milliarden}",
                    "{zero:000' 'Milljarde one:000' 'Milliarde other:000' 'Milliarden}",
                    "{zero:0' 'Billjuhn one:0' 'Billjuhn other:0' 'Billjuhn}",
                    "{zero:00' 'Billjuhn one:00' 'Billion other:00' 'Billionen}",
                    "{zero:000' 'Billjuhn one:000' 'Billion other:000' 'Billionen}",
                }
            },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "field.zone", "Zickzohn" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras",
                new String[] {
                    "v. Chr.",
                    "n. Chr.",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "standalone.QuarterNarrows",
                new String[] {
                    "1Q",
                    "2Q",
                    "3Q",
                    "4Q",
                }
            },
            { "java.time.islamic.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "field.weekday", "Wochedaach" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns",
                new String[] {
                    "EEEE, d. MMMM y GGGG",
                    "d. MMMM y GGGG",
                    "d. MMM. y GGGG",
                    "d. M. y G",
                }
            },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "Woch" },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "java.time.buddhist.DatePatterns",
                new String[] {
                    "EEEE, d. MMMM y G",
                    "d. MMMM y G",
                    "d. MMM. y G",
                    "d. M. y GGGGG",
                }
            },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{zero:0\u00a0tsd one:0\u00a0tsd other:0\u00a0tsd}",
                    "{zero:00\u00a0tsd one:00\u00a0tsd other:00\u00a0tsd}",
                    "{zero:000\u00a0tsd one:000\u00a0tsd other:000\u00a0tsd}",
                    "{zero:0\u00a0Mio one:0\u00a0Mio other:0\u00a0Mio}",
                    "{zero:00\u00a0Mio one:00\u00a0Mio other:00\u00a0Mio}",
                    "{zero:000\u00a0Mio one:000\u00a0Mio other:000\u00a0Mio}",
                    "{zero:0\u00a0Mrd one:0\u00a0Mrd other:0\u00a0Mrd}",
                    "{zero:00\u00a0Mrd one:00\u00a0Mrd other:00\u00a0Mrd}",
                    "{zero:000\u00a0Mrd one:000\u00a0Mrd other:000\u00a0Mrd}",
                    "{zero:0\u00a0Bio one:0\u00a0Bio other:0\u00a0Bio}",
                    "{zero:00\u00a0Bio one:00\u00a0Bio other:00\u00a0Bio}",
                    "{zero:000\u00a0Bio one:000\u00a0Bio other:000\u00a0Bio}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Summerzick vun {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, 'd\u00e4' d. MMMM y",
                    "d. MMMM y",
                    "d. MMM. y",
                    "d. M. y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "zero:n = 0;one:n = 1" },
            { "field.hour", "Schtund" },
            { "calendarname.buddhist", "buddistesche Kal\u00e4nder" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "",
                }
            },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
