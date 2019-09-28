/*
 * Copyright (c) 2012, 2019, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (C) 1991-2016 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in 
 * http://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that
 * (a) this copyright and permission notice appear with all copies 
 * of the Data Files or Software,
 * (b) this copyright and permission notice appear in associated 
 * documentation, and
 * (c) there is clear notice in each modified Data File or in the Software
 * as well as in the documentation associated with the Data File(s) or
 * Software that the data or software has been modified.
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

public class FormatData_so extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Bisha Koobaad",
               "Bisha Labaad",
               "Bisha Saddexaad",
               "Bisha Afraad",
               "Bisha Shanaad",
               "Bisha Lixaad",
               "Bisha Todobaad",
               "Bisha Sideedaad",
               "Bisha Sagaalaad",
               "Bisha Tobnaad",
               "Bisha Kow iyo Tobnaad",
               "Bisha Laba iyo Tobnaad",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan",
               "Feb",
               "Mar",
               "Abr",
               "May",
               "Jun",
               "Lul",
               "Ogs",
               "Seb",
               "Okt",
               "Nof",
               "Dis",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "J",
               "F",
               "M",
               "A",
               "M",
               "J",
               "L",
               "O",
               "S",
               "O",
               "N",
               "D",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Axad",
               "Isniin",
               "Salaasa",
               "Arbaca",
               "Khamiis",
               "Jimce",
               "Sabti",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Axd",
               "Isn",
               "Slsa",
               "Arbc",
               "Khms",
               "Jmc",
               "Sbti",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "A",
               "I",
               "S",
               "A",
               "Kh",
               "J",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "Rubaca 1aad",
               "Rubaca 2aad",
               "Rubaca 3aad",
               "Rubaca 4aad",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "R1",
               "R2",
               "R3",
               "R4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "GH",
               "GD",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "h",
               "d",
            };
        final String[] metaValue_Eras = new String[] {
               "CH",
               "CD",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
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
               "EEEE, MMMM d, y G",
               "MMMM d, y G",
               "MMM d, y G",
               "M/d/y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, MMMM d, y GGGG",
               "MMMM d, y GGGG",
               "MMM d, y GGGG",
               "M/d/y G",
            };
        final String metaValue_calendarname_gregorian = "Habeetiriska Geregoriyaan";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Sannad" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.regionFormat.standard", "Waqtiga Caadiga Ah ee {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "Habeentiriska jabbaanka" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "Ciise Hortii",
                    "Ciise Dabadii",
                }
            },
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
                    ".",
                    ",",
                    ";",
                    "%",
                    "0",
                    "#",
                    "-",
                    "E",
                    "\u2030",
                    "\u221e",
                    "MaL",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "daqiiqad" },
            { "field.era", "saman" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "GH/GD" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.roc", "Habeentiriska Minguwo" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "Bil" },
            { "field.second", "ilbiriqsi" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                }
            },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Habeentiriska islaamka" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "timezone.regionFormat", "Waqtiga {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "0 Kun",
                    "00 Kun",
                    "000 Kun",
                    "0 Milyan",
                    "00 Milyan",
                    "000 Milyan",
                    "0 Bilyan",
                    "00 Bilyan",
                    "000 Bilyan",
                    "0 Tirilyan",
                    "00 Tirilyan",
                    "000 Tirilyan",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "wakhtiga aagga" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "maalinta toddobaadka" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "Toddobaad" },
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
                    "0K",
                    "00K",
                    "000K",
                    "0M",
                    "00M",
                    "000M",
                    "0B",
                    "00B",
                    "000B",
                    "0T",
                    "00T",
                    "000T",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Waqtiga Dharaarta ee {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, MMMM dd, y",
                    "dd MMMM y",
                    "dd-MMM-y",
                    "dd/MM/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "Saacad" },
            { "calendarname.buddhist", "Habeentiriska Buudhist" },
            { "standalone.MonthNames",
                new String[] {
                    "Jannaayo",
                    "Febraayo",
                    "Maarso",
                    "Abriil",
                    "May",
                    "Juun",
                    "Luuliyo",
                    "Ogost",
                    "Sebtembar",
                    "Oktoobar",
                    "Nofembar",
                    "Desembar",
                    "",
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
