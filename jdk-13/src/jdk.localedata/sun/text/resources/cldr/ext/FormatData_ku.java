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

public class FormatData_ku extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_MonthNames = new String[] {
               "r\u00eabendan\u00ea",
               "re\u015femiy\u00ea",
               "adar\u00ea",
               "avr\u00eal\u00ea",
               "gulan\u00ea",
               "p\u00fb\u015fper\u00ea",
               "t\u00eermeh\u00ea",
               "gelaw\u00eaj\u00ea",
               "rezber\u00ea",
               "kew\u00e7\u00ear\u00ea",
               "sermawez\u00ea",
               "berfanbar\u00ea",
               "",
            };
        final String[] metaValue_MonthAbbreviations = new String[] {
               "r\u00eab",
               "re\u015f",
               "ada",
               "avr",
               "gul",
               "p\u00fb\u015f",
               "t\u00eer",
               "gel",
               "rez",
               "kew",
               "ser",
               "ber",
               "",
            };
        final String[] metaValue_MonthNarrows = new String[] {
               "R",
               "R",
               "A",
               "A",
               "G",
               "P",
               "T",
               "G",
               "R",
               "K",
               "S",
               "B",
               "",
            };
        final String[] metaValue_DayNames = new String[] {
               "yek\u015fem",
               "du\u015fem",
               "s\u00ea\u015fem",
               "\u00e7ar\u015fem",
               "p\u00eanc\u015fem",
               "\u00een",
               "\u015fem\u00ee",
            };
        final String[] metaValue_DayAbbreviations = new String[] {
               "y\u015f",
               "d\u015f",
               "s\u015f",
               "\u00e7\u015f",
               "p\u015f",
               "\u00een",
               "\u015f",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "Y",
               "D",
               "S",
               "\u00c7",
               "P",
               "\u00ce",
               "\u015e",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "\u00c71",
               "\u00c72",
               "\u00c73",
               "\u00c74",
            };
        final String[] metaValue_Eras = new String[] {
               "BZ",
               "PZ",
            };
        final String[] metaValue_buddhist_QuarterNarrows = new String[] {
               "1",
               "2",
               "3",
               "4",
            };
        final String metaValue_calendarname_gregorian = "salnameya gregor\u00ee";
        final Object[][] data = new Object[][] {
            { "MonthNames", metaValue_MonthNames },
            { "field.year", "sal" },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "standalone.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "roc.MonthNarrows", metaValue_MonthNarrows },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "narrow.Eras", metaValue_Eras },
            { "calendarname.japanese", "salnameya japon\u00ee" },
            { "Eras", metaValue_Eras },
            { "japanese.MonthNames", metaValue_MonthNames },
            { "roc.DayNames", metaValue_DayNames },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "roc.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "long.Eras",
                new String[] {
                    "ber\u00ee zay\u00een\u00ea",
                    "pi\u015ft\u00ee zay\u00een\u00ea",
                }
            },
            { "islamic.DayNames", metaValue_DayNames },
            { "buddhist.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.MonthNames", metaValue_MonthNames },
            { "latn.NumberElements",
                new String[] {
                    ",",
                    ".",
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
            { "MonthNarrows", metaValue_MonthNarrows },
            { "japanese.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "buddhist.DayNames", metaValue_DayNames },
            { "field.minute", "deq\u00eeqe" },
            { "field.era", "serdem" },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.MonthNarrows", metaValue_MonthNarrows },
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "calendarname.roc", "salnameya Komara \u00c7\u00een\u00ea" },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayNames", metaValue_DayNames },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNames", metaValue_DayNames },
            { "field.month", "meh" },
            { "field.second", "saniye" },
            { "roc.MonthNames", metaValue_MonthNames },
            { "field.week", "hefte" },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "NumberPatterns",
                new String[] {
                    "#,##0.###",
                    "#,##0.00\u00a0\u00a4",
                    "%#,##0",
                }
            },
            { "buddhist.MonthNarrows", metaValue_MonthNarrows },
            { "islamic.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "calendarname.islamic", "salnameya ko\u00e7\u00ee" },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "calendarname.gregorian", metaValue_calendarname_gregorian },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.DayNames", metaValue_DayNames },
            { "field.hour", "saet" },
            { "standalone.MonthAbbreviations", metaValue_MonthAbbreviations },
            { "standalone.MonthNames",
                new String[] {
                    "r\u00eabendan",
                    "re\u015fem\u00ee",
                    "adar",
                    "avr\u00eal",
                    "gulan",
                    "p\u00fb\u015fper",
                    "t\u00eermeh",
                    "gelaw\u00eaj",
                    "rezber",
                    "kew\u00e7\u00ear",
                    "sermawez",
                    "berfanbar",
                    "",
                }
            },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "buddhist.QuarterNarrows", metaValue_buddhist_QuarterNarrows },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.MonthNarrows", metaValue_MonthNarrows },
            { "calendarname.gregory", metaValue_calendarname_gregorian },
        };
        return data;
    }
}
