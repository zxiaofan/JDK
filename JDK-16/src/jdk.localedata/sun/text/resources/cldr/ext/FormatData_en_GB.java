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

public class FormatData_en_GB extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Jan",
               "Feb",
               "Mar",
               "Apr",
               "May",
               "Jun",
               "Jul",
               "Aug",
               "Sept",
               "Oct",
               "Nov",
               "Dec",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_MonthNarrows = new String[] {
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
        final String[] metaValue_buddhist_DayNarrows = new String[] {
               "S",
               "M",
               "T",
               "W",
               "T",
               "F",
               "S",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final Object[][] data = new Object[][] {
            { "roc.DayNarrows", metaValue_buddhist_DayNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "TimePatterns", metaValue_TimePatterns },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd/MM/y",
                }
            },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayNarrows", metaValue_buddhist_DayNarrows },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'at' {0}",
                    "{1} 'at' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
                }
            },
            { "roc.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayNarrows", metaValue_buddhist_DayNarrows },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "japanese.DayNarrows", metaValue_buddhist_DayNarrows },
            { "buddhist.MonthNarrows", metaValue_buddhist_MonthNarrows },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "japanese.MonthNarrows", metaValue_buddhist_MonthNarrows },
        };
        return data;
    }
}
