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

public class FormatData_es_MX extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_DayNarrows = new String[] {
               "D",
               "L",
               "M",
               "M",
               "J",
               "V",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1.er trimestre",
               "2.\u00ba trimestre",
               "3.er trimestre",
               "4.\u00ba trimestre",
            };
        final String[] metaValue_QuarterNarrows = new String[] {
               "1T",
               "2T",
               "3T",
               "4T",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a.\u00a0m.",
               "p.\u00a0m.",
               "",
               "del mediod\u00eda",
               "de la madrugada",
               "ma\u00f1ana",
               "",
               "",
               "de la tarde",
               "",
               "de la noche",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d 'de' MMMM 'de' y G",
               "d 'de' MMMM 'de' y G",
               "d MMM, y G",
               "dd/MM/yy GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d 'de' MMMM 'de' y GGGG",
               "d 'de' MMMM 'de' y GGGG",
               "d MMM, y GGGG",
               "dd/MM/yy G",
            };
        final Object[][] data = new Object[][] {
            { "japanese.QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "TimePatterns", metaValue_TimePatterns },
            { "calendarname.roc", "calendario minguo" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "DayNarrows", metaValue_DayNarrows },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0\u00a0k other:0\u00a0k}",
                    "{one:00\u00a0k other:00\u00a0k}",
                    "{one:000\u00a0k other:000\u00a0k}",
                }
            },
            { "standalone.QuarterNarrows", metaValue_QuarterNarrows },
            { "roc.QuarterNarrows", metaValue_QuarterNarrows },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "DatePatterns",
                new String[] {
                    "EEEE, d 'de' MMMM 'de' y",
                    "d 'de' MMMM 'de' y",
                    "d MMM y",
                    "dd/MM/yy",
                }
            },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "DateTimePatterns",
                new String[] {
                    "{1}, {0}",
                    "{1}, {0}",
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
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4#,##0.00",
                    "#,##0\u00a0%",
                    "\u00a4#,##0.00",
                }
            },
            { "long.CompactNumberPatterns",
                new String[] {
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
                    "",
                    "",
                    "{one:0' 'bill\u00f3n other:0' 'billones}",
                    "{one:00' 'billones other:00' 'billones}",
                    "{one:000' 'billones other:000' 'billones}",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "QuarterAbbreviations", metaValue_QuarterNames },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.QuarterNames", metaValue_QuarterNames },
        };
        return data;
    }
}
