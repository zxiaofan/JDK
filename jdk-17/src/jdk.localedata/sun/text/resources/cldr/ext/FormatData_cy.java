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

public class FormatData_cy extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Ionawr",
               "Chwefror",
               "Mawrth",
               "Ebrill",
               "Mai",
               "Mehefin",
               "Gorffennaf",
               "Awst",
               "Medi",
               "Hydref",
               "Tachwedd",
               "Rhagfyr",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Ion",
               "Chwef",
               "Maw",
               "Ebr",
               "Mai",
               "Meh",
               "Gorff",
               "Awst",
               "Medi",
               "Hyd",
               "Tach",
               "Rhag",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "I",
               "Ch",
               "M",
               "E",
               "M",
               "M",
               "G",
               "A",
               "M",
               "H",
               "T",
               "Rh",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "Dydd Sul",
               "Dydd Llun",
               "Dydd Mawrth",
               "Dydd Mercher",
               "Dydd Iau",
               "Dydd Gwener",
               "Dydd Sadwrn",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Sul",
               "Llun",
               "Maw",
               "Mer",
               "Iau",
               "Gwen",
               "Sad",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "S",
               "Ll",
               "M",
               "M",
               "I",
               "G",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "chwarter 1af",
               "2il chwarter",
               "3ydd chwarter",
               "4ydd chwarter",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "Ch1",
               "Ch2",
               "Ch3",
               "Ch4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "yb",
               "yh",
               "canol nos",
               "canol dydd",
               "y bore",
               "",
               "y prynhawn",
               "",
               "yr hwyr",
               "",
               "",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "b",
               "h",
               "canol nos",
               "canol dydd",
               "yn y bore",
               "",
               "yn y prynhawn",
               "",
               "min nos",
               "",
               "",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "AM",
               "PM",
               "canol nos",
               "canol dydd",
               "y bore",
               "",
               "y prynhawn",
               "",
               "yr hwyr",
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
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y G",
               "d MMMM y G",
               "d MMM y G",
               "dd/MM/y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM y GGGG",
               "d MMMM y GGGG",
               "d MMM y GGGG",
               "dd/MM/y G",
            };
        final String metaValue_calendarname_gregorian = "Calendr Gregori";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "blwyddyn" },
            { "arabext.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a",
                    "\u06f0",
                    "#",
                    "\u200e-\u200e",
                    "\u00d7\u06f1\u06f0^",
                    "\u0609",
                    "\u221e",
                    "NaN",
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
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras",
                new String[] {
                    "C",
                    "O",
                }
            },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "Amser Safonol {0}" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "calendarname.japanese", "Calendr Japan" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations",
                new String[] {
                    "Sul",
                    "Llun",
                    "Maw",
                    "Mer",
                    "Iau",
                    "Gwe",
                    "Sad",
                }
            },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "Cyn Crist",
                    "Oed Crist",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'am' {0}",
                    "{1} 'am' {0}",
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
                    "NaN",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "munud" },
            { "field.era", "oes" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "arab.NumberElements",
                new String[] {
                    "\u066b",
                    "\u066c",
                    "\u061b",
                    "\u066a\u061c",
                    "\u0660",
                    "#",
                    "\u061c-",
                    "\u0627\u0633",
                    "\u0609",
                    "\u221e",
                    "NaN",
                    "",
                    "",
                }
            },
            { "calendarname.roc", "Calendr Gweriniaeth Tseina" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "mis" },
            { "arabext.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "",
                }
            },
            { "field.second", "eiliad" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "Calendr Islam" },
            { "DayPeriodRules", "midnight:00:00;noon:12:00;afternoon1:12:00-18:00;morning1:00:00-12:00;evening1:18:00-24:00" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "Ion",
                    "Chw",
                    "Maw",
                    "Ebr",
                    "Mai",
                    "Meh",
                    "Gor",
                    "Awst",
                    "Medi",
                    "Hyd",
                    "Tach",
                    "Rhag",
                    "",
                }
            },
            { "timezone.regionFormat", "Amser {0}" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{zero:0' 'mil one:0' 'mil two:0K few:0K many:0K other:0' 'mil}",
                    "{zero:00K one:00' 'mil two:00K few:00K many:00K other:00' 'mil}",
                    "{zero:000K one:000' 'mil two:000K few:000K many:000K other:000' 'mil}",
                    "{zero:0M one:0' 'miliwn two:0M few:0M many:0M other:0' 'miliwn}",
                    "{zero:00M one:00' 'miliwn two:00M few:00M many:00M other:00' 'miliwn}",
                    "{zero:000M one:000' 'miliwn two:000M few:000M many:000M other:000' 'miliwn}",
                    "{zero:0B one:0' 'biliwn two:0B few:0B many:0B other:0' 'biliwn}",
                    "{zero:00B one:00' 'biliwn two:00B few:00B many:00B other:00' 'biliwn}",
                    "{zero:000B one:000' 'biliwn two:000B few:000B many:000B other:000' 'biliwn}",
                    "{zero:0T one:0' 'triliwn two:0T few:0T many:0T other:0' 'triliwn}",
                    "{zero:00T one:00' 'triliwn two:00T few:00T many:00T other:00' 'triliwn}",
                    "{zero:000T one:000T two:000T few:000T many:000T other:000' 'triliwn}",
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
            { "field.zone", "cylchfa amser" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "arab.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0%",
                    "",
                }
            },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "Eras",
                new String[] {
                    "CC",
                    "OC",
                }
            },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "diwrnod o\u2019r wythnos" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "wythnos" },
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
                    "{zero:0K one:0K two:0K few:0K many:0K other:0K}",
                    "{zero:00K one:00K two:00K few:00K many:00K other:00K}",
                    "{zero:000K one:000K two:000K few:000K many:000K other:000K}",
                    "{zero:0M one:0M two:0M few:0M many:0M other:0M}",
                    "{zero:00M one:00M two:00M few:00M many:00M other:00M}",
                    "{zero:000M one:000M two:000M few:000M many:000M other:000M}",
                    "{zero:0B one:0B two:0B few:0B many:0B other:0B}",
                    "{zero:00B one:00B two:00B few:00B many:00B other:00B}",
                    "{zero:000B one:000B two:000B few:000B many:000B other:000B}",
                    "{zero:0T one:0T two:0T few:0T many:0T other:0T}",
                    "{zero:00T one:00T two:00T few:00T many:00T other:00T}",
                    "{zero:000T one:000T two:000T few:000T many:000T other:000T}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "Amser Haf {0}" },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd/MM/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "zero:n = 0;one:n = 1;few:n = 3;many:n = 6;two:n = 2" },
            { "field.hour", "awr" },
            { "calendarname.buddhist", "Calendr Bwdaidd" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
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
