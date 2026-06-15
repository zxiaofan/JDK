/*
 * Copyright (c) 2012, 2023, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (c) 1991-2022 Unicode, Inc. All rights reserved.
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

public class FormatData_sat extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_generic_QuarterNames = new String[] {
            "\u1c51\u1c5f\u1c5c \u1c6f\u1c6e \u1c6a\u1c5f\u1c78\u1c6b\u1c5a\u1c60\u1c64\u1c6d\u1c5f\u1c79",
            "\u1c52\u1c5f\u1c5c \u1c6f\u1c6e \u1c6a\u1c5f\u1c78\u1c6b\u1c5a\u1c60\u1c64\u1c6d\u1c5f\u1c79",
            "\u1c53\u1c6d\u1c5f\u1c5c \u1c6f\u1c6e \u1c6a\u1c5f\u1c78\u1c6b\u1c5a\u1c60\u1c64\u1c6d\u1c5f\u1c79",
            "\u1c54\u1c5f\u1c5c \u1c6f\u1c6e \u1c6a\u1c5f\u1c78\u1c6b\u1c5a\u1c60\u1c64\u1c6d\u1c5f\u1c79",
        };
        final String[] metaValue_MonthNames = new String[] {
            "\u1c61\u1c5f\u1c71\u1c63\u1c5f\u1c68\u1c64",
            "\u1c6f\u1c77\u1c5f\u1c68\u1c63\u1c5f\u1c68\u1c64",
            "\u1c62\u1c5f\u1c68\u1c6a",
            "\u1c5f\u1c6f\u1c68\u1c6e\u1c5e",
            "\u1c62\u1c6e",
            "\u1c61\u1c69\u1c71",
            "\u1c61\u1c69\u1c5e\u1c5f\u1c6d",
            "\u1c5f\u1c5c\u1c5f\u1c65\u1c5b",
            "\u1c65\u1c6e\u1c6f\u1c74\u1c6e\u1c62\u1c75\u1c5f\u1c68",
            "\u1c5a\u1c60\u1c74\u1c5a\u1c75\u1c5f\u1c68",
            "\u1c71\u1c5f\u1c63\u1c5f\u1c62\u1c75\u1c5f\u1c68",
            "\u1c6b\u1c64\u1c65\u1c5f\u1c62\u1c75\u1c5f\u1c68",
            "",
        };
        final String[] metaValue_MonthAbbreviations = new String[] {
            "\u1c61\u1c5f\u1c71",
            "\u1c6f\u1c77\u1c5f",
            "\u1c62\u1c5f\u1c68",
            "\u1c5f\u1c6f\u1c68",
            "\u1c62\u1c6e",
            "\u1c61\u1c69\u1c71",
            "\u1c61\u1c69\u1c5e",
            "\u1c5f\u1c5c\u1c5f",
            "\u1c65\u1c6e\u1c6f",
            "\u1c5a\u1c60\u1c74",
            "\u1c71\u1c5f\u1c63",
            "\u1c6b\u1c64\u1c65",
            "",
        };
        final String[] metaValue_MonthNarrows = new String[] {
            "\u1c61",
            "\u1c6f",
            "\u1c62",
            "\u1c5f",
            "\u1c62",
            "\u1c61",
            "\u1c61",
            "\u1c5f",
            "\u1c65",
            "\u1c5a",
            "\u1c71",
            "\u1c6b",
            "",
        };
        final String[] metaValue_generic_DayNames = new String[] {
            "\u1c65\u1c64\u1c78\u1c5c\u1c6e",
            "\u1c5a\u1c5b\u1c6e",
            "\u1c75\u1c5f\u1c5e\u1c6e",
            "\u1c65\u1c5f\u1c79\u1c5c\u1c69\u1c71",
            "\u1c65\u1c5f\u1c79\u1c68\u1c6b\u1c64",
            "\u1c61\u1c5f\u1c79\u1c68\u1c69\u1c62",
            "\u1c67\u1c69\u1c66\u1c69\u1c62",
        };
        final String[] metaValue_generic_DayAbbreviations = new String[] {
            "\u1c65\u1c64\u1c78",
            "\u1c5a\u1c5b",
            "\u1c75\u1c5f",
            "\u1c65\u1c5f\u1c79",
            "\u1c65\u1c5f\u1c79\u1c68",
            "\u1c61\u1c5f\u1c79",
            "\u1c67\u1c69",
        };
        final String[] metaValue_generic_DayNarrows = new String[] {
            "\u1c65",
            "\u1c5a",
            "\u1c75",
            "\u1c65",
            "\u1c65",
            "\u1c61",
            "\u1c67",
        };
        final String[] metaValue_generic_QuarterNarrows = new String[] {
            "\u1c51",
            "\u1c52",
            "\u1c53",
            "\u1c54",
        };
        final String[] metaValue_generic_AmPmMarkers = new String[] {
            "\u1c65\u1c6e\u1c5b\u1c5f\u1c5c",
            "\u1c67\u1c64\u1c6b\u1c5f\u1c79",
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
            "\u1c65\u1c6e\u1c68\u1c62\u1c5f \u1c5e\u1c5f\u1c66\u1c5f",
            "\u1c64\u1c65\u1c63\u1c64",
        };
        final String[] metaValue_generic_TimePatterns = new String[] {
            "h:mm:ss a zzzz",
            "h:mm:ss a z",
            "h:mm:ss a",
            "h:mm a",
        };
        final String[] metaValue_generic_DateTimePatterns = new String[] {
            "{1} {0}",
            "{1} {0}",
            "{1} {0}",
            "{1} {0}",
        };
        final String[] metaValue_java_time_generic_DatePatterns = new String[] {
            "G y MMMM d, EEEE",
            "G y MMMM d",
            "G y MMM d",
            "GGGGG y-MM-dd",
        };
        final String[] metaValue_generic_DatePatterns = new String[] {
            "GGGG y MMMM d, EEEE",
            "GGGG y MMMM d",
            "GGGG y MMM d",
            "G y-MM-dd",
        };
        final String metaValue_calendarname_gregorian = "\u1c5c\u1c68\u1c6e\u1c5c\u1c5a\u1c68\u1c64\u1c6d\u1c5f\u1c71 \u1c60\u1c5f\u1c5e\u1c6e\u1c71\u1c70\u1c5f\u1c68";
        final Object[][] data = new Object[][] {
            { "generic.DayNames", metaValue_generic_DayNames },
            { "generic.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "generic.DayNarrows", metaValue_generic_DayNarrows },
            { "generic.QuarterNames", metaValue_generic_QuarterNames },
            { "generic.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "generic.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "generic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "generic.TimePatterns", metaValue_generic_TimePatterns },
            { "java.time.generic.DatePatterns", metaValue_java_time_generic_DatePatterns },
            { "generic.DatePatterns", metaValue_generic_DatePatterns },
            { "generic.DateTimePatterns", metaValue_generic_DateTimePatterns },
            { "MonthNames", metaValue_MonthNames },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "DayNames", metaValue_generic_DayNames },
            { "standalone.DayNames", metaValue_generic_DayNames },
            { "DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "standalone.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "DayNarrows", metaValue_generic_DayNarrows },
            { "standalone.DayNarrows", metaValue_generic_DayNarrows },
            { "QuarterNames", metaValue_generic_QuarterNames },
            { "standalone.QuarterNames", metaValue_generic_QuarterNames },
            { "QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "standalone.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "standalone.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "long.Eras", metaValue_long_Eras },
            { "Eras", metaValue_long_Eras },
            { "narrow.Eras", metaValue_long_Eras },
            { "field.era", "\u1c61\u1c69\u1c5c\u1c7d" },
            { "field.year", "\u1c65\u1c6e\u1c68\u1c62\u1c5f/\u1c75\u1c5a\u1c6a\u1c77\u1c5a\u1c5e\u1c68" },
            { "field.month", "\u1c6a\u1c5f\u1c78\u1c6b\u1c5a" },
            { "field.week", "\u1c66\u1c5f\u1c6f\u1c5b\u1c5f/\u1c6e\u1c62\u1c66\u1c5f" },
            { "field.weekday", "\u1c66\u1c5f\u1c6f\u1c5b\u1c5f \u1c68\u1c6e\u1c6d\u1c5f\u1c5c \u1c62\u1c5f\u1c66\u1c5f" },
            { "field.dayperiod", "\u1c65\u1c6e\u1c5b\u1c5f\u1c5c/\u1c5f\u1c79\u1c6d\u1c69\u1c75" },
            { "field.hour", "\u1c74\u1c5f\u1c72\u1c5f\u1c5d" },
            { "timezone.gmtFormat", "\u1c61\u1c64\u1c6e\u1c62\u1c74\u1c64{0}" },
            { "timezone.gmtZeroFormat", "\u1c61\u1c64\u1c6e\u1c62\u1c74\u1c64" },
            { "timezone.regionFormat", "{0} \u1c5a\u1c60\u1c5b\u1c5a" },
            { "timezone.regionFormat.daylight", "{0} \u1c6b\u1c64\u1c71\u1c75\u1c6e\u1c72\u1c5f \u1c5a\u1c60\u1c5b\u1c5a" },
            { "timezone.regionFormat.standard", "{0} \u1c62\u1c5f\u1c71\u1c5a\u1c60 \u1c5a\u1c60\u1c5b\u1c5a" },
            { "field.minute", "\u1c74\u1c64\u1c6f\u1c64\u1c61" },
            { "field.second", "\u1c74\u1c64\u1c68\u1c64\u1c61" },
            { "field.zone", "\u1c74\u1c5a\u1c74\u1c77\u1c5f" },
            { "TimePatterns", metaValue_generic_TimePatterns },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "d/M/yy",
                }
            },
            { "DateTimePatterns", metaValue_generic_DateTimePatterns },
            { "PluralRules", "one:n = 1;two:n = 2" },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.DayNames", metaValue_generic_DayNames },
            { "buddhist.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "buddhist.DayNarrows", metaValue_generic_DayNarrows },
            { "buddhist.QuarterNames", metaValue_generic_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "buddhist.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "buddhist.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_generic_TimePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_generic_DatePatterns },
            { "buddhist.DatePatterns", metaValue_generic_DatePatterns },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DayNames", metaValue_generic_DayNames },
            { "japanese.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "japanese.DayNarrows", metaValue_generic_DayNarrows },
            { "japanese.QuarterNames", metaValue_generic_QuarterNames },
            { "japanese.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "japanese.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "japanese.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_generic_TimePatterns },
            { "java.time.japanese.DatePatterns", metaValue_java_time_generic_DatePatterns },
            { "japanese.DatePatterns", metaValue_generic_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "roc.DayNames", metaValue_generic_DayNames },
            { "roc.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "roc.DayNarrows", metaValue_generic_DayNarrows },
            { "roc.QuarterNames", metaValue_generic_QuarterNames },
            { "roc.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "roc.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "roc.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "roc.TimePatterns", metaValue_generic_TimePatterns },
            { "java.time.roc.DatePatterns", metaValue_java_time_generic_DatePatterns },
            { "roc.DatePatterns", metaValue_generic_DatePatterns },
            { "islamic.DayNames", metaValue_generic_DayNames },
            { "islamic.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "islamic.DayNarrows", metaValue_generic_DayNarrows },
            { "islamic.QuarterNames", metaValue_generic_QuarterNames },
            { "islamic.QuarterAbbreviations", metaValue_generic_QuarterNames },
            { "islamic.QuarterNarrows", metaValue_generic_QuarterNarrows },
            { "islamic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "islamic.TimePatterns", metaValue_generic_TimePatterns },
            { "java.time.islamic.DatePatterns", metaValue_java_time_generic_DatePatterns },
            { "islamic.DatePatterns", metaValue_generic_DatePatterns },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
            { "DefaultNumberingSystem", "olck" },
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
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                    "\u00a4\u00a0#,##0.00",
                }
            },
        };
        return data;
    }
}
