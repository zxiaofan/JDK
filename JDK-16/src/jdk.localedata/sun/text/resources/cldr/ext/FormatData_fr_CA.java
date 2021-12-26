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

public class FormatData_fr_CA extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthAbbreviations = new String[] {
               "janv.",
               "f\u00e9vr.",
               "mars",
               "avr.",
               "mai",
               "juin",
               "juill.",
               "ao\u00fbt",
               "sept.",
               "oct.",
               "nov.",
               "d\u00e9c.",
               "",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "minuit",
               "midi",
               "du matin",
               "",
               "de l\u2019apr\u00e8s-midi",
               "",
               "du soir",
               "",
               "du matin",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a",
               "p",
               "minuit",
               "midi",
               "mat.",
               "",
               "apr\u00e8s-midi",
               "",
               "soir",
               "",
               "mat.",
               "",
            };
        final String[] metaValue_abbreviated_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "minuit",
               "midi",
               "du mat.",
               "",
               "apr\u00e8s-midi",
               "",
               "du soir",
               "",
               "du mat.",
               "",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH 'h' mm 'min' ss 's' zzzz",
               "HH 'h' mm 'min' ss 's' z",
               "HH 'h' mm 'min' ss 's'",
               "HH 'h' mm",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE d MMMM y G",
               "d MMMM y G",
               "d MMM y G",
               "yy-MM-dd GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE d MMMM y GGGG",
               "d MMMM y GGGG",
               "d MMM y GGGG",
               "yy-MM-dd G",
            };
        final String[] metaValue_java_time_islamic_long_Eras = new String[] {
               "",
               "Anno Hegirae",
            };
        final String[] metaValue_java_time_islamic_narrow_Eras = new String[] {
               "",
               "AH",
            };
        final Object[][] data = new Object[][] {
            { "calendarname.islamic-umalqura", "calendrier musulman (calcul\u00e9, Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DatePatterns",
                new String[] {
                    "EEEE d MMMM y GGGG",
                    "d MMMM y GGGG",
                    "d MMM y GGGG",
                    "y-MM-dd G",
                }
            },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "timezone.regionFormat.standard", "{0} (heure normale)" },
            { "japanese.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.narrow.Eras", metaValue_java_time_islamic_narrow_Eras },
            { "islamic.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
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
                    "{one:0\u00a0M other:0\u00a0M}",
                    "{one:00\u00a0M other:00\u00a0M}",
                    "{one:000\u00a0M other:000\u00a0M}",
                    "{one:0\u00a0G other:0\u00a0G}",
                    "{one:00\u00a0G other:00\u00a0G}",
                    "{one:000\u00a0G other:000\u00a0G}",
                    "{one:0\u00a0T other:0\u00a0T}",
                    "{one:00\u00a0T other:00\u00a0T}",
                    "{one:000\u00a0T other:000\u00a0T}",
                }
            },
            { "timezone.regionFormat.daylight", "{0} (heure avanc\u00e9e)" },
            { "DatePatterns",
                new String[] {
                    "EEEE d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "y-MM-dd",
                }
            },
            { "java.time.islamic.DatePatterns",
                new String[] {
                    "EEEE d MMMM y G",
                    "d MMMM y G",
                    "d MMM y G",
                    "y-MM-dd GGGGG",
                }
            },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "DateTimePatterns",
                new String[] {
                    "{1} '\u00e0' {0}",
                    "{1} '\u00e0' {0}",
                    "{1}, {0}",
                    "{1} {0}",
                }
            },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "latn.NumberElements",
                new String[] {
                    ",",
                    "\u00a0",
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
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "islamic.narrow.Eras", metaValue_java_time_islamic_narrow_Eras },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "latn.NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "#,##0\u00a0%",
                    "#,##0.00\u00a0\u00a4;(#,##0.00\u00a0\u00a4)",
                }
            },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{1:0' 'mille one:0' 'mille other:0' 'mille}",
                    "{one:00' 'mille other:00' 'mille}",
                    "{one:000' 'mille other:000' 'mille}",
                    "{one:0' 'million other:0' 'millions}",
                    "{one:00' 'million other:00' 'millions}",
                    "{one:000' 'million other:000' 'millions}",
                    "{one:0' 'milliard other:0' 'milliards}",
                    "{one:00' 'milliard other:00' 'milliards}",
                    "{one:000' 'milliard other:000' 'milliards}",
                    "{one:0' 'billion other:0' 'billions}",
                    "{one:00' 'billion other:00' 'billions}",
                    "{one:000' 'billion other:000' 'billions}",
                }
            },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "java.time.islamic.long.Eras", metaValue_java_time_islamic_long_Eras },
            { "roc.TimePatterns", metaValue_TimePatterns },
            { "roc.abbreviated.AmPmMarkers", metaValue_abbreviated_AmPmMarkers },
        };
        return data;
    }
}
