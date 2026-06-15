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

public class FormatData_lkt extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_generic_DayNames = new String[] {
            "A\u014bp\u00e9tuwak\u021fa\u014b",
            "A\u014bp\u00e9tuwa\u014b\u017ei",
            "A\u014bp\u00e9tunu\u014bpa",
            "A\u014bp\u00e9tuyamni",
            "A\u014bp\u00e9tutopa",
            "A\u014bp\u00e9tuzapta\u014b",
            "Ow\u00e1\u014bgyu\u017ea\u017eapi",
        };
        final String[] metaValue_MonthNames = new String[] {
            "Wi\u00f3the\u021fika W\u00ed",
            "Thiy\u00f3\u021feyu\u014bka W\u00ed",
            "I\u0161t\u00e1wi\u010dhayaza\u014b W\u00ed",
            "P\u021fe\u017e\u00edt\u021fo W\u00ed",
            "\u010cha\u014bw\u00e1pet\u021fo W\u00ed",
            "W\u00edpazuk\u021fa-wa\u0161t\u00e9 W\u00ed",
            "\u010cha\u014bp\u021f\u00e1sapa W\u00ed",
            "Was\u00fat\u021fu\u014b W\u00ed",
            "\u010cha\u014bw\u00e1pe\u01e7i W\u00ed",
            "\u010cha\u014bw\u00e1pe-kasn\u00e1 W\u00ed",
            "Wan\u00edyetu W\u00ed",
            "T\u021fah\u00e9kap\u0161u\u014b W\u00ed",
            "",
        };
        final String[] metaValue_generic_DayNarrows = new String[] {
            "A",
            "W",
            "N",
            "Y",
            "T",
            "Z",
            "O",
        };
        final String[] metaValue_generic_TimePatterns = new String[] {
            "h:mm:ss\u202fa zzzz",
            "h:mm:ss\u202fa z",
            "h:mm:ss\u202fa",
            "h:mm\u202fa",
        };
        final Object[][] data = new Object[][] {
            { "generic.DayNames", metaValue_generic_DayNames },
            { "generic.DayAbbreviations", metaValue_generic_DayNames },
            { "generic.DayNarrows", metaValue_generic_DayNarrows },
            { "generic.TimePatterns", metaValue_generic_TimePatterns },
            { "MonthNames", metaValue_MonthNames },
            { "standalone.MonthNames", metaValue_MonthNames },
            { "MonthAbbreviations", metaValue_MonthNames },
            { "standalone.MonthAbbreviations", metaValue_MonthNames },
            { "DayNames", metaValue_generic_DayNames },
            { "standalone.DayNames", metaValue_generic_DayNames },
            { "DayAbbreviations", metaValue_generic_DayNames },
            { "standalone.DayAbbreviations", metaValue_generic_DayNames },
            { "DayNarrows", metaValue_generic_DayNarrows },
            { "field.year", "\u00d3mak\u021fa" },
            { "field.month", "W\u00ed" },
            { "field.week", "Ok\u00f3" },
            { "field.weekday", "Ok\u00f3-a\u014bp\u00e9tu" },
            { "field.hour", "Ow\u00e1p\u021fe" },
            { "field.minute", "Ow\u00e1p\u021fe o\u021f\u02bc\u00e1\u014bk\u021fo" },
            { "field.second", "Okp\u00ed" },
            { "TimePatterns", metaValue_generic_TimePatterns },
            { "DatePatterns",
                new String[] {
                    "EEEE, MMMM d, y",
                    "MMMM d, y",
                    "MMM d, y",
                    "M/d/yy",
                }
            },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "buddhist.DayNames", metaValue_generic_DayNames },
            { "buddhist.DayAbbreviations", metaValue_generic_DayNames },
            { "buddhist.DayNarrows", metaValue_generic_DayNarrows },
            { "buddhist.TimePatterns", metaValue_generic_TimePatterns },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "japanese.MonthAbbreviations", metaValue_MonthNames },
            { "japanese.DayNames", metaValue_generic_DayNames },
            { "japanese.DayAbbreviations", metaValue_generic_DayNames },
            { "japanese.DayNarrows", metaValue_generic_DayNarrows },
            { "japanese.TimePatterns", metaValue_generic_TimePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "roc.MonthAbbreviations", metaValue_MonthNames },
            { "roc.DayNames", metaValue_generic_DayNames },
            { "roc.DayNarrows", metaValue_generic_DayNarrows },
            { "roc.TimePatterns", metaValue_generic_TimePatterns },
            { "islamic.DayNames", metaValue_generic_DayNames },
            { "islamic.DayAbbreviations", metaValue_generic_DayNames },
            { "islamic.DayNarrows", metaValue_generic_DayNarrows },
            { "islamic.TimePatterns", metaValue_generic_TimePatterns },
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
                    "",
                }
            },
        };
        return data;
    }
}
