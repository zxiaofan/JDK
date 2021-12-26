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

public class FormatData_ga extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "Ean\u00e1ir",
               "Feabhra",
               "M\u00e1rta",
               "Aibre\u00e1n",
               "Bealtaine",
               "Meitheamh",
               "I\u00fail",
               "L\u00fanasa",
               "Me\u00e1n F\u00f3mhair",
               "Deireadh F\u00f3mhair",
               "Samhain",
               "Nollaig",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "Ean",
               "Feabh",
               "M\u00e1rta",
               "Aib",
               "Beal",
               "Meith",
               "I\u00fail",
               "L\u00fan",
               "MF\u00f3mh",
               "DF\u00f3mh",
               "Samh",
               "Noll",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "E",
               "F",
               "M",
               "A",
               "B",
               "M",
               "I",
               "L",
               "M",
               "D",
               "S",
               "N",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "D\u00e9 Domhnaigh",
               "D\u00e9 Luain",
               "D\u00e9 M\u00e1irt",
               "D\u00e9 C\u00e9adaoin",
               "D\u00e9ardaoin",
               "D\u00e9 hAoine",
               "D\u00e9 Sathairn",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "Domh",
               "Luan",
               "M\u00e1irt",
               "C\u00e9ad",
               "D\u00e9ar",
               "Aoine",
               "Sath",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "D",
               "L",
               "M",
               "C",
               "D",
               "A",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "1\u00fa r\u00e1ithe",
               "2\u00fa r\u00e1ithe",
               "3\u00fa r\u00e1ithe",
               "4\u00fa r\u00e1ithe",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "R1",
               "R2",
               "R3",
               "R4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "r.n.",
               "i.n.",
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
        final String[] metaValue_Eras = new String[] {
               "RC",
               "AD",
            };
        final String[] metaValue_TimePatterns = new String[] {
               "HH:mm:ss zzzz",
               "HH:mm:ss z",
               "HH:mm:ss",
               "HH:mm",
            };
        final String[] metaValue_DateTimePatterns = new String[] {
               "{1} {0}",
               "{1} {0}",
               "{1} {0}",
               "{1} {0}",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String[] metaValue_java_time_buddhist_long_Eras = new String[] {
               "BC",
               "RB",
            };
        final String[] metaValue_java_time_buddhist_DatePatterns = new String[] {
               "EEEE d MMMM y G",
               "d MMMM y G",
               "d MMM y G",
               "dd/MM/y GGGGG",
            };
        final String[] metaValue_buddhist_DatePatterns = new String[] {
               "EEEE d MMMM y GGGG",
               "d MMMM y GGGG",
               "d MMM y GGGG",
               "dd/MM/y G",
            };
        final String metaValue_calendarname_gregorian = "F\u00e9ilire Ghr\u00e9ag\u00f3ra";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "Bliain" },
            { "calendarname.islamic-umalqura", "F\u00e9ilire Ioslamach (Umm al-Qura)" },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "timezone.gmtFormat", "MAG{0}" },
            { "java.time.japanese.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.islamic-civil", "F\u00e9ilire Ioslamach (t\u00e1blach, seanr\u00e9 shibhialta)" },
            { "japanese.TimePatterns", metaValue_TimePatterns },
            { "narrow.Eras", metaValue_Eras },
            { "abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.japanese", "F\u00e9ilire Seap\u00e1nach" },
            { "timezone.gmtZeroFormat", "MAG" },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "Roimh Chr\u00edost",
                    "Anno Domini",
                }
            },
            { "roc.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "DateTimePatterns", metaValue_DateTimePatterns },
            { "narrow.AmPmMarkers", metaValue_AmPmMarkers },
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
                    "Nuimh",
                    "",
                    "",
                }
            },
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.DatePatterns", metaValue_buddhist_DatePatterns },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "N\u00f3im\u00e9ad" },
            { "field.era", "R\u00e9" },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "field.dayperiod", "a.m./p.m." },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.roc", "F\u00e9ilire T\u00e9av\u00e1nach" },
            { "islamic.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "field.month", "M\u00ed" },
            { "field.second", "Soicind" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "roc.DatePatterns", metaValue_buddhist_DatePatterns },
            { "calendarname.islamic", "F\u00e9ilire Ioslamach" },
            { "buddhist.TimePatterns", metaValue_TimePatterns },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.CompactNumberPatterns",
                new String[] {
                    "",
                    "",
                    "",
                    "{one:0' 'mh\u00edle two:0' 'mh\u00edle few:0' 'mh\u00edle many:0' 'm\u00edle other:0' 'm\u00edle}",
                    "{one:00' 'm\u00edle two:00' 'm\u00edle few:00' 'm\u00edle many:00' 'm\u00edle other:00' 'm\u00edle}",
                    "{one:000' 'm\u00edle two:000' 'm\u00edle few:000' 'm\u00edle many:000' 'm\u00edle other:000' 'm\u00edle}",
                    "{one:0' 'mhilli\u00fan two:0' 'mhilli\u00fan few:0' 'mhilli\u00fan many:0' 'milli\u00fan other:0' 'milli\u00fan}",
                    "{one:00' 'milli\u00fan two:00' 'milli\u00fan few:00' 'milli\u00fan many:00' 'milli\u00fan other:00' 'milli\u00fan}",
                    "{one:000' 'milli\u00fan two:000' 'milli\u00fan few:000' 'milli\u00fan many:000' 'milli\u00fan other:000' 'milli\u00fan}",
                    "{one:0' 'bhilli\u00fan two:0' 'bhilli\u00fan few:0' 'bhilli\u00fan many:0' 'mbilli\u00fan other:0' 'billi\u00fan}",
                    "{one:00' 'billi\u00fan two:00' 'billi\u00fan few:00' 'billi\u00fan many:00' 'mbilli\u00fan other:00' 'billi\u00fan}",
                    "{one:000' 'billi\u00fan two:000' 'billi\u00fan few:000' 'billi\u00fan many:000' 'billi\u00fan other:000' 'billi\u00fan}",
                    "{one:0' 'trilli\u00fan two:0' 'thrilli\u00fan few:0' 'thrilli\u00fan many:0' 'dtrilli\u00fan other:0' 'trilli\u00fan}",
                    "{one:00' 'trilli\u00fan two:00' 'trilli\u00fan few:00' 'trilli\u00fan many:00' 'dtrilli\u00fan other:00' 'trilli\u00fan}",
                    "{one:000' 'trilli\u00fan two:000' 'trilli\u00fan few:000' 'trilli\u00fan many:000' 'trilli\u00fan other:000' 'trilli\u00fan}",
                }
            },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "standalone.QuarterNames", metaValue_QuarterNames },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "java.time.buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.long.Eras", metaValue_java_time_buddhist_long_Eras },
            { "TimePatterns", metaValue_TimePatterns },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "field.zone", "Crios Ama" },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "buddhist.narrow.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "Eras", metaValue_Eras },
            { "roc.DayNames", metaValue_DayNames },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "islamic.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "java.time.islamic.DatePatterns", metaValue_java_time_buddhist_DatePatterns },
            { "field.weekday", "L\u00e1 na seachtaine" },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterNames", metaValue_QuarterNames },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "java.time.buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "buddhist.DatePatterns", metaValue_buddhist_DatePatterns },
            { "roc.MonthNames", metaValue_MonthNames },
            { "buddhist.Eras", metaValue_java_time_buddhist_long_Eras },
            { "field.week", "Seachtain" },
            { "buddhist.DateTimePatterns", metaValue_DateTimePatterns },
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
                    "{one:0k two:0k few:0k many:0k other:0k}",
                    "{one:00k two:00k few:00k many:00k other:00k}",
                    "{one:000k two:000k few:000k many:000k other:000k}",
                    "{one:0M two:0M few:0M many:0M other:0M}",
                    "{one:00M two:00M few:00M many:00M other:00M}",
                    "{one:000M two:000M few:000M many:000M other:000M}",
                    "{one:0B two:0B few:0B many:0B other:0B}",
                    "{one:00B two:00B few:00B many:00B other:00B}",
                    "{one:000B two:000B few:000B many:000B other:000B}",
                    "{one:0T two:0T few:0T many:0T other:0T}",
                    "{one:00T two:00T few:00T many:00T other:00T}",
                    "{one:000T two:000T few:000T many:000T other:000T}",
                }
            },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "java.time.buddhist.narrow.Eras", metaValue_java_time_buddhist_long_Eras },
            { "DatePatterns",
                new String[] {
                    "EEEE d MMMM y",
                    "d MMMM y",
                    "d MMM y",
                    "dd/MM/y",
                }
            },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.TimePatterns", metaValue_TimePatterns },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "PluralRules", "one:n = 1;few:n = 3..6;many:n = 7..10;two:n = 2" },
            { "field.hour", "Uair" },
            { "calendarname.buddhist", "F\u00e9ilire B\u00fada\u00edoch" },
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
            { "roc.abbreviated.AmPmMarkers", metaValue_AmPmMarkers },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
