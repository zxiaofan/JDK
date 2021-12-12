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

public class FormatData_gsw extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Januar",
               "Februar",
               "M\u00e4rz",
               "April",
               "Mai",
               "Juni",
               "Juli",
               "Auguscht",
               "Sept\u00e4mber",
               "Oktoober",
               "Nov\u00e4mber",
               "Dez\u00e4mber",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan",
               "Feb",
               "M\u00e4r",
               "Apr",
               "Mai",
               "Jun",
               "Jul",
               "Aug",
               "Sep",
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
               "A",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Sunntig",
               "M\u00e4\u00e4ntig",
               "Ziischtig",
               "Mittwuch",
               "Dunschtig",
               "Friitig",
               "Samschtig",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Su.",
               "M\u00e4.",
               "Zi.",
               "Mi.",
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
               "1. Quartal",
               "2. Quartal",
               "3. Quartal",
               "4. Quartal",
            };
        final String[] metaValue_standalone_QuarterAbbreviations = new String[] {
               "Q1",
               "Q2",
               "Q3",
               "Q4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "am Vormittag",
               "am Namittag",
               "Mitternacht",
               "",
               "am Morge",
               "",
               "zmittag",
               "am Namittag",
               "zaabig",
               "",
               "znacht",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "vorm.",
               "nam.",
               "Mitternacht",
               "",
               "am Morge",
               "",
               "zmittag",
               "am Namittag",
               "zaabig",
               "",
               "znacht",
               "",
            };
        final String[] metaValue_long_Eras = new String[] {
               "v. Chr.",
               "n. Chr.",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_java_time_japanese_DatePatterns = new String[] {
               "EEEE, d. MMMM y G",
               "d. MMMM y G",
               "dd.MM.y G",
               "dd.MM.yy GGGGG",
            };
        final String[] metaValue_japanese_DatePatterns = new String[] {
               "EEEE, d. MMMM y GGGG",
               "d. MMMM y GGGG",
               "dd.MM.y GGGG",
               "dd.MM.yy G",
            };
        final String metaValue_calendarname_gregorian = "Gregoriaanisch Kal\u00e4nder";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Jaar" },
            { "islamic.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "TimePatterns", metaValue_TimePatterns },
            { "calendarname.islamic-civil", "B\u00fcrgerlich islaamisch Kal\u00e4nder" },
            { "japanese.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_long_Eras },
            { "abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.japanese", "Japaanisch Kal\u00e4nder" },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_long_Eras },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "long.Eras", metaValue_long_Eras },
            { "islamic.DayNames", metaValue_DayNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "field.weekday", "Wuchetag" },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "latn.NumberElements",
                new String[] {
                    ".",
                    "\u2019",
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
            { "japanese.DatePatterns", metaValue_japanese_DatePatterns },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "Minuute" },
            { "field.era", "Epoche" },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "Tagesh\u00e4lfti" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "calendarname.roc", "Kal\u00e4nder vor Republik Chiina" },
            { "islamic.DatePatterns", metaValue_japanese_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "field.month", "Monet" },
            { "buddhist.DatePatterns",
                new String[] {
                    "EEEE d. MMMM y GGGG",
                    "d. MMMM y GGGG",
                    "d. MMM y GGGG",
                    "d.M.y",
                }
            },
            { "field.second", "Sekunde" },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "Wuche" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_japanese_DatePatterns },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "calendarname.islamic", "Islaamisch Kal\u00e4nder" },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "DayPeriodRules", "midnight:00:00;night1:00:00-05:00;afternoon1:12:00-14:00;morning1:05:00-12:00;afternoon2:14:00-18:00;evening1:18:00-24:00" },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.roc.DatePatterns", metaValue_java_time_japanese_DatePatterns },
            { "java.time.buddhist.DatePatterns",
                new String[] {
                    "EEEE d. MMMM y G",
                    "d. MMMM y G",
                    "d. MMM y G",
                    "d.M.y",
                }
            },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0\u00a0Tsg'.' other:0\u00a0Tsg'.'}",
                    "{one:00\u00a0Tsg'.' other:00\u00a0Tsg'.'}",
                    "{one:000\u00a0Tsg'.' other:000\u00a0Tsg'.'}",
                    "{one:0\u00a0Mio'.' other:0\u00a0Mio'.'}",
                    "{one:00\u00a0Mio'.' other:00\u00a0Mio'.'}",
                    "{one:000\u00a0Mio'.' other:000\u00a0Mio'.'}",
                    "{one:0\u00a0Mrd'.' other:0\u00a0Mrd'.'}",
                    "{one:00\u00a0Mrd'.' other:00\u00a0Mrd'.'}",
                    "{one:000\u00a0Mrd'.' other:000\u00a0Mrd'.'}",
                    "{one:0\u00a0Bio'.' other:0\u00a0Bio'.'}",
                    "{one:00\u00a0Bio'.' other:00\u00a0Bio'.'}",
                    "{one:000\u00a0Bio'.' other:000\u00a0Bio'.'}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
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
            { "field.hour", "Schtund" },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "calendarname.buddhist", "Buddhischtisch Kal\u00e4nder" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "",
                }
            },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'Tuusig other:0' 'Tuusig}",
                    "{one:00' 'Tuusig other:00' 'Tuusig}",
                    "{one:000' 'Tuusig other:000' 'Tuusig}",
                    "{one:0' 'Millioon other:0' 'Millioone}",
                    "{one:00' 'Millioon other:00' 'Millioone}",
                    "{one:000' 'Millioon other:000' 'Millioone}",
                    "{one:0' 'Milliarde other:0' 'Milliarde}",
                    "{one:00' 'Milliarde other:00' 'Milliarde}",
                    "{one:000' 'Milliarde other:000' 'Milliarde}",
                    "{one:0' 'Billioon other:0' 'Billioone}",
                    "{one:00' 'Billioon other:00' 'Billioone}",
                    "{one:000' 'Billioon other:000' 'Billioone}",
                }
            },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "roc.abbreviated.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
