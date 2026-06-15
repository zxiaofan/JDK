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

public class FormatData_bn_IN extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNarrows = new String[] {
            "\u099c\u09be",
            "\u09ab\u09c7",
            "\u09ae\u09be",
            "\u098f",
            "\u09ae\u09c7",
            "\u099c\u09c1\u09a8",
            "\u099c\u09c1\u09b2",
            "\u0986",
            "\u09b8\u09c7",
            "\u0985",
            "\u09a8",
            "\u09a1\u09bf",
            "",
        };
        final String[] metaValue_generic_AmPmMarkers = new String[] {
            "AM",
            "PM",
            "",
            "",
            "\u09ad\u09cb\u09b0\u09ac\u09c7\u09b2\u09be\u09af\u09bc",
            "\u09b8\u0995\u09be\u09b2\u09ac\u09c7\u09b2\u09be\u09af\u09bc",
            "\u09a6\u09c1\u09aa\u09c1\u09b0\u09ac\u09c7\u09b2\u09be\u09af\u09bc",
            "\u09ac\u09bf\u0995\u09be\u09b2",
            "\u09b8\u09a8\u09cd\u09a7\u09cd\u09af\u09be\u09ac\u09c7\u09b2\u09be\u09af\u09bc",
            "",
            "\u09b0\u09be\u09a4\u09cd\u09b0\u09bf",
            "",
        };
        final String[] metaValue_Eras = new String[] {
            "\u0996\u09cd\u09b0\u09bf\u0983\u09aa\u09c2\u0983",
            "\u0996\u09cd\u09b0\u09bf\u0983",
        };
        final String metaValue_generic_DateFormatItem_MMMMW = "MMMM \u098f\u09b0 W \u09a8\u09ae\u09cd\u09ac\u09b0 \u09b8\u09aa\u09cd\u09a4\u09be\u09b9";
        final String[] metaValue_MonthAbbreviations = new String[] {
            "\u099c\u09be\u09a8\u09c1",
            "\u09ab\u09c7\u09ac",
            "\u09ae\u09be\u09b0\u09cd\u099a",
            "\u098f\u09aa\u09cd\u09b0\u09bf",
            "\u09ae\u09c7",
            "\u099c\u09c1\u09a8",
            "\u099c\u09c1\u09b2",
            "\u0986\u0997",
            "\u09b8\u09c7\u09aa\u09cd\u099f\u09c7\u0983",
            "\u0985\u0995\u09cd\u099f\u09cb\u0983",
            "\u09a8\u09ad\u09c7\u0983",
            "\u09a1\u09bf\u09b8\u09c7\u0983",
            "",
        };
        final String metaValue_calendarname_gregorian = "\u0997\u09cd\u09b0\u09c7\u0997\u09cb\u09b0\u09bf\u09af\u09bc\u09be\u09a8 \u0995\u09cd\u09af\u09be\u09b2\u09c7\u09a8\u09cd\u09a1\u09be\u09b0";
        final Object[][] data = new Object[][] {
            { "generic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "generic.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.MonthAbbreviations",
                new String[] {
                    "\u099c\u09be\u09a8\u09c1",
                    "\u09ab\u09c7\u09ac",
                    "\u09ae\u09be\u09b0\u09cd\u099a",
                    "\u098f\u09aa\u09cd\u09b0\u09bf\u09b2",
                    "\u09ae\u09c7",
                    "\u099c\u09c1\u09a8",
                    "\u099c\u09c1\u09b2\u09be\u0987",
                    "\u0986\u0997\u09b8\u09cd\u099f",
                    "\u09b8\u09c7\u09aa\u09cd\u099f\u09c7\u0983",
                    "\u0985\u0995\u09cd\u099f\u09cb\u0983",
                    "\u09a8\u09ad\u09c7\u0983",
                    "\u09a1\u09bf\u09b8\u09c7\u0983",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "long.Eras",
                new String[] {
                    "\u0996\u09cd\u09b0\u09bf\u0983\u09aa\u09c2\u0983",
                    "\u0996\u09cd\u09b0\u09bf\u09b7\u09cd\u099f\u09be\u09ac\u09cd\u09a6",
                }
            },
            { "Eras", metaValue_Eras },
            { "narrow.Eras", metaValue_Eras },
            { "DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "buddhist.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "japanese.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "roc.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "roc.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "islamic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "islamic.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "islamic-civil.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "islamic-umalqura.DateFormatItem.MMMMW", metaValue_generic_DateFormatItem_MMMMW },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
            { "beng.NumberElements",
                new String[] {
                    ".",
                    ",",
                    ";",
                    "%",
                    "\u09e6",
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
            { "beng.NumberPatterns",
                new String[] {
                    "#,##,##0.###",
                    "\u00a4#,##,##0.00",
                    "#,##0%",
                    "#,##,##0.00\u00a4;(#,##,##0.00\u00a4)",
                }
            },
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
                    "#,##,##0.###",
                    "\u00a4#,##,##0.00",
                    "#,##,##0%",
                    "\u00a4#,##,##0.00;(\u00a4#,##,##0.00)",
                }
            },
        };
        return data;
    }
}
