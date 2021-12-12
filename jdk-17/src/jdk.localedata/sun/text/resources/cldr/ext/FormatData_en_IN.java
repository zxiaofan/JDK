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

public class FormatData_en_IN extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_TimePatterns = new String[] {
               "h:mm:ss a zzzz",
               "h:mm:ss a z",
               "h:mm:ss a",
               "h:mm a",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM, y G",
               "d MMMM, y G",
               "d MMM, y G",
               "d/M/y/ GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM, y GGGG",
               "d MMMM, y GGGG",
               "d MMM, y GGGG",
               "d/M/y/ G",
            };
        final String[] metaValue_short_CompactNumberPatterns = new String[] {
               "",
               "",
               "",
               "{one:0T other:0T}",
               "{one:00T other:00T}",
               "{one:0L other:0L}",
               "{one:00L other:00L}",
               "{one:0Cr other:0Cr}",
               "{one:00Cr other:00Cr}",
               "{one:000Cr other:000Cr}",
               "{one:0TCr other:0TCr}",
               "{one:00TCr other:00TCr}",
               "{one:0LCr other:0LCr}",
               "{one:00LCr other:00LCr}",
               "{one:000LCr}",
            };
        final Object[][] data = new Object[][] {
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "TimePatterns", metaValue_TimePatterns },
            { "DatePatterns",
                new String[] {
                    "EEEE, d MMMM, y",
                    "d MMMM y",
                    "dd-MMM-y",
                    "dd/MM/yy",
                }
            },
            { "java.time.islamic.DatePatterns",
                new String[] {
                    "EEEE d MMMM y G",
                    "d MMMM, y G",
                    "dd-MMM-y G",
                    "d/M/y/ GGGGG",
                }
            },
            { "islamic.DatePatterns",
                new String[] {
                    "EEEE d MMMM y GGGG",
                    "d MMMM, y GGGG",
                    "dd-MMM-y GGGG",
                    "d/M/y/ G",
                }
            },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "DateTimePatterns",
                new String[] {
                    "{1} 'at' {0}",
                    "{1} 'at' {0}",
                    "{1}, {0}",
                    "{1}, {0}",
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
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "long.CompactNumberPatterns", metaValue_short_CompactNumberPatterns },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##,##0.###",
                    "\u00a4#,##,##0.00",
                    "#,##,##0%",
                    "\u00a4#,##0.00;(\u00a4#,##0.00)",
                }
            },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "field.dayperiod", "AM/PM" },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
        };
        return data;
    }
}
