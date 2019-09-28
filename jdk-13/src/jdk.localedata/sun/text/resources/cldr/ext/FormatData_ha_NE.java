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

public class FormatData_ha_NE extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_buddhist_MonthNames = new String[] {
               "Janairu",
               "Faburairu",
               "Maris",
               "Afirilu",
               "Mayu",
               "Yuni",
               "Yuli",
               "Agusta",
               "Satumba",
               "Oktoba",
               "Nuwamba",
               "Disamba",
               "",
            };
        final String[] metaValue_buddhist_DayNames = new String[] {
               "Lahadi",
               "Litinin",
               "Talata",
               "Laraba",
               "Alhamis",
               "Jumma\u02bca",
               "Asabar",
            };
        final String[] metaValue_buddhist_DayAbbreviations = new String[] {
               "Lah",
               "Lit",
               "Tal",
               "Lar",
               "Alh",
               "Jum",
               "Asa",
            };
        final String[] metaValue_buddhist_QuarterNames = new String[] {
               "Kwata na \u0257aya",
               "Kwata na biyu",
               "Kwata na uku",
               "Kwata na hu\u0257u",
            };
        final String[] metaValue_buddhist_AmPmMarkers = new String[] {
               "Safiya",
               "Yamma",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM, y G",
               "d MMMM, y G",
               "d MMM, y G",
               "d/M/yy GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE, d MMMM, y GGGG",
               "d MMMM, y GGGG",
               "d MMM, y GGGG",
               "d/M/yy G",
            };
        final String[] metaValue_japanese_MonthAbbreviations = new String[] {
               "Jan",
               "Fab",
               "Mar",
               "Afi",
               "May",
               "Yun",
               "Yul",
               "Agu",
               "Sat",
               "Okt",
               "Nuw",
               "Dis",
               "",
            };
        final Object[][] data = new Object[][] {
            { "japanese.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "TimePatterns", metaValue_TimePatterns },
            { "roc.QuarterNames", metaValue_buddhist_QuarterNames },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "japanese.DayNames", metaValue_buddhist_DayNames },
            { "japanese.DayAbbreviations", metaValue_buddhist_DayAbbreviations },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "roc.MonthNames", metaValue_buddhist_MonthNames },
            { "narrow.Eras",
                new String[] {
                    "K.H",
                    "BHAI",
                }
            },
            { "NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "\u00a4\u00a0#,##0.00",
                    "#,##0%",
                }
            },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.QuarterNames", metaValue_buddhist_QuarterNames },
            { "japanese.MonthNames", metaValue_buddhist_MonthNames },
            { "roc.DayNarrows",
                new String[] {
                    "L",
                    "L",
                    "T",
                    "L",
                    "A",
                    "J",
                    "A",
                }
            },
            { "roc.DayNames", metaValue_buddhist_DayNames },
            { "roc.MonthAbbreviations", metaValue_japanese_MonthAbbreviations },
            { "islamic.QuarterNames", metaValue_buddhist_QuarterNames },
            { "java.time.roc.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "java.time.buddhist.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "short.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "0D",
                    "00D",
                    "000D",
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
            { "islamic.DayNames", metaValue_buddhist_DayNames },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "DatePatterns",
                new String[] {
                    "EEEE d MMMM, y",
                    "d MMMM, y",
                    "d MMM, y",
                    "d/M/yy",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_buddhist_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "buddhist.MonthNames", metaValue_buddhist_MonthNames },
            { "DateTimePatterns",
                new String[] {
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
                    "{1} {0}",
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
                }
            },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "buddhist.DayNames", metaValue_buddhist_DayNames },
            { "japanese.MonthAbbreviations", metaValue_japanese_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_buddhist_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_buddhist_AmPmMarkers },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "Dubu 0",
                    "Dubu 00",
                    "Dubu 000",
                    "Miliyan 0",
                    "Miliyan 00",
                    "Miliyan 000",
                    "Biliyan 0",
                    "Biliyan 00",
                    "Biliyan 000",
                    "Triliyan 0",
                    "Triliyan 00",
                    "Triliyan 000",
                }
            },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "japanese.QuarterNames", metaValue_buddhist_QuarterNames },
        };
        return data;
    }
}
