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

public class FormatData_kok extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "\u091c\u093e\u0928\u0947\u0935\u093e\u0930\u0940",
               "\u092b\u0947\u092c\u094d\u0930\u0941\u0935\u093e\u0930\u0940",
               "\u092e\u093e\u0930\u094d\u091a",
               "\u090f\u092a\u094d\u0930\u0940\u0932",
               "\u092e\u0947",
               "\u091c\u0942\u0928",
               "\u091c\u0941\u0932\u092f",
               "\u0911\u0917\u0938\u094d\u091f",
               "\u0938\u092a\u094d\u091f\u0947\u0902\u092c\u0930",
               "\u0911\u0915\u094d\u091f\u094b\u092c\u0930",
               "\u0928\u094b\u0935\u094d\u0939\u0947\u0902\u092c\u0930",
               "\u0921\u093f\u0938\u0947\u0902\u092c\u0930",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "\u0906\u092f\u0924\u093e\u0930",
               "\u0938\u094b\u092e\u093e\u0930",
               "\u092e\u0902\u0917\u0933\u093e\u0930",
               "\u092c\u0941\u0927\u0935\u093e\u0930",
               "\u092c\u093f\u0930\u0947\u0938\u094d\u0924\u093e\u0930",
               "\u0936\u0941\u0915\u094d\u0930\u093e\u0930",
               "\u0936\u0947\u0928\u0935\u093e\u0930",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "\u0906",
               "\u0938\u094b",
               "\u092e\u0902",
               "\u092c\u0941",
               "\u092c\u093f",
               "\u0936\u0941",
               "\u0936\u0947",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1\u0932\u0947\u0902 \u0924\u094d\u0930\u0948\u092e\u093e\u0938\u0940\u0915",
               "2\u0930\u0947\u0902 \u0924\u094d\u0930\u0948\u092e\u093e\u0938\u0940\u0915",
               "3\u0930\u0947\u0902 \u0924\u094d\u0930\u0948\u092e\u093e\u0938\u0940\u0915",
               "4\u0925\u0947\u0902 \u0924\u094d\u0930\u0948\u092e\u093e\u0938\u0940\u0915",
            };
        final String[] metaValue_standalone_QuarterAbbreviations = new String[] {
               "Q1",
               "Q2",
               "Q3",
               "Q4",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a",
               "p",
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
        final String[] metaValue_long_Eras = new String[] {
               "\u0915\u094d\u0930\u093f\u0938\u094d\u0924\u092a\u0942\u0930\u094d\u0935",
               "\u0915\u094d\u0930\u093f\u0938\u094d\u0924\u0936\u0916\u093e",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
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
               "EEEE d MMMM y G",
               "d MMMM y G",
               "d-M-y G",
               "d-M-y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE d MMMM y GGGG",
               "d MMMM y GGGG",
               "d-M-y GGGG",
               "d-M-y G",
            };
        final String metaValue_calendarname_gregorian = "\u0917\u094d\u0930\u0947\u0917\u094b\u0930\u093f\u092f\u0928 \u0915\u0945\u0932\u0945\u0923\u094d\u0921\u0930";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "\u0935\u0930\u094d\u0938" },
            { "japanese.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_long_Eras },
            { "timezone.regionFormat.standard", "{0} \u092a\u094d\u0930\u092e\u093e\u0923\u093f\u0924 \u0935\u0947\u0933" },
            { "calendarname.japanese", "\u091c\u092a\u093e\u0928\u0940 \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u093e" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayNames },
            { "roc.MonthAbbreviations", metaValue_MonthNames },
            { "long.Eras", metaValue_long_Eras },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthNames },
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
                    "NaN",
                    "",
                    "",
                }
            },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "\u092e\u093f\u0928\u0940\u091f" },
            { "field.era", "\u0936\u0915" },
            { "buddhist.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "field.dayperiod", "AM/PM" },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "\u092e\u093f\u0902\u0917\u0941\u0906 \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u093e (\u0905\u0923\u0915\u093e\u0930\u093e\u091a\u0940 \u0915\u0941\u0930\u0942: \u091c\u093e\u0915\u093e \u091a\u093f\u0928\u0940 \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u0947\u091a\u0947\u0902 \u092a\u094d\u0930\u091c\u093e\u0938\u0924\u094d\u0924\u093e\u0915\", \"\u0930\u093f\u092a\u092c\u094d\u0932\u093f\u0915\u0928 \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u093e\")" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "deva.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "\u0966",
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
            { "roc.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "field.month", "\u092e\u094d\u0939\u092f\u0928\u094b" },
            { "field.second", "\u0938\u0947\u0915\u0902\u0926" },
            { "DayAbbreviations", metaValue_DayNames },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "\u0908\u0938\u094d\u0932\u093e\u092e\u0940\u0915 \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u093e" },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "\u091c\u093e\u0928\u0947",
                    "\u092b\u0947\u092c\u094d\u0930\u0941",
                    "\u092e\u093e\u0930\u094d\u091a",
                    "\u090f\u092a\u094d\u0930\u0940",
                    "\u092e\u0947",
                    "\u091c\u0942\u0928",
                    "\u091c\u0941\u0932",
                    "\u0911\u0917",
                    "\u0938\u092a\u094d\u091f\u0947\u0902",
                    "\u0911\u0915\u094d\u091f\u094b",
                    "\u0928\u094b",
                    "\u0921\u093f\u0938\u0947",
                    "",
                }
            },
            { "timezone.regionFormat", "{0} \u0935\u0947\u0933" },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{other:0' '\u0939\u091c\u093e\u0930}",
                    "{other:00' '\u0939\u091c\u093e\u0930}",
                    "{other:000' '\u0939\u091c\u093e\u0930}",
                    "{other:0' '\u0926\u0936\u0932\u0915\u094d\u0937}",
                    "{other:00' '\u0926\u0936\u0932\u0915\u094d\u0937}",
                    "{other:000' '\u0926\u0936\u0932\u0915\u094d\u0937}",
                    "{other:0' '\u0905\u092c\u094d\u091c}",
                    "{other:00' '\u0905\u092c\u094d\u091c}",
                    "{other:000' '\u0905\u092c\u094d\u091c}",
                    "{other:0' '\u091f\u094d\u0930\u093f\u0932\u093f\u092f\u0928}",
                    "{other:00' '\u091f\u094d\u0930\u093f\u0932\u093f\u092f\u0928}",
                    "{other:000' '\u091f\u094d\u0930\u093f\u0932\u093f\u092f\u0928}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayNames },
            { "standalone.DayNarrows",
                new String[] {
                    "\u0906",
                    "\u0938\u094b",
                    "\u092e\u0902",
                    "\u092c\u0941",
                    "\u092c",
                    "\u0936\u0941",
                    "\u0936\u0947",
                }
            },
            { "islamic.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "\u0935\u0947\u0933 \u091d\u094b\u0928" },
            { "japanese.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "Eras", metaValue_long_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "\u0938\u092a\u094d\u0924\u0915\u093e\u091a\u094b \u0926\u0940\u0938" },
            { "japanese.MonthAbbreviations", metaValue_MonthNames },
            { "islamic.DayAbbreviations", metaValue_DayNames },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_standalone_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayNames },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "\u0938\u092a\u094d\u0924\u0915" },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "buddhist.MonthNarrows", metaValue_buddhist_MonthNarrows },
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
                    "{other:0K}",
                    "{other:00K}",
                    "{other:000K}",
                    "{other:0M}",
                    "{other:00M}",
                    "{other:000M}",
                    "{other:0B}",
                    "{other:00B}",
                    "{other:000B}",
                    "{other:0T}",
                    "{other:00T}",
                    "{other:000T}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "timezone.regionFormat.daylight", "{0} \u0921\u0947\u0932\u093e\u092f\u091f \u0935\u0947\u0933" },
            { "DatePatterns",
                new String[] {
                    "EEEE d MMMM y",
                    "d MMMM y",
                    "d-MMM-y",
                    "d-M-yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayNames },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthNames },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "\u0935\u0930" },
            { "calendarname.buddhist", "\u092c\u0941\u0927\u094d\u0926\u0940\u0936\u094d\u091f \u0926\u093f\u0928\u0926\u0930\u094d\u0936\u093f\u0915\u093e" },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "deva.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0%",
                    "",
                }
            },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
