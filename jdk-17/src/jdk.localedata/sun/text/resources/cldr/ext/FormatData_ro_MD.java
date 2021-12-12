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

public class FormatData_ro_MD extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_DayAbbreviations = new String[] {
               "Dum",
               "Lun",
               "Mar",
               "Mie",
               "Joi",
               "Vin",
               "S\u00e2m",
            };
        final String[] metaValue_DayNarrows = new String[] {
               "D",
               "L",
               "Ma",
               "Mi",
               "J",
               "V",
               "S",
            };
        final String[] metaValue_QuarterNames = new String[] {
               "trimestrul 1",
               "trimestrul 2",
               "trimestrul 3",
               "trimestrul 4",
            };
        final String[] metaValue_QuarterAbbreviations = new String[] {
               "trim. 1",
               "trim. 2",
               "trim. 3",
               "trim. 4",
            };
        final String[] metaValue_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "miezul nop\u021bii",
               "amiaz\u0103",
               "diminea\u021ba",
               "",
               "dup\u0103-amiaza",
               "",
               "seara",
               "",
               "noaptea",
               "",
            };
        final String[] metaValue_narrow_AmPmMarkers = new String[] {
               "a.m.",
               "p.m.",
               "miezul nop\u021bii",
               "amiaz\u0103",
               "diminea\u021b\u0103",
               "",
               "dup\u0103-amiaz\u0103",
               "",
               "sear\u0103",
               "",
               "noapte",
               "",
            };
        final Object[][] data = new Object[][] {
            { "buddhist.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "roc.DayAbbreviations", metaValue_DayAbbreviations },
            { "standalone.DayNarrows", metaValue_DayNarrows },
            { "japanese.AmPmMarkers", metaValue_AmPmMarkers },
            { "islamic.AmPmMarkers", metaValue_AmPmMarkers },
            { "AmPmMarkers", metaValue_AmPmMarkers },
            { "standalone.QuarterAbbreviations",
                new String[] {
                    "Trim. 1",
                    "Trim. 2",
                    "Trim. 3",
                    "Trim. 4",
                }
            },
            { "roc.QuarterNames", metaValue_QuarterNames },
            { "islamic.DayNarrows", metaValue_DayNarrows },
            { "roc.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "japanese.DayAbbreviations", metaValue_DayAbbreviations },
            { "japanese.QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "islamic.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "DayAbbreviations", metaValue_DayAbbreviations },
            { "DayNarrows", metaValue_DayNarrows },
            { "buddhist.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "buddhist.QuarterNames", metaValue_QuarterNames },
            { "roc.DayNarrows", metaValue_DayNarrows },
            { "standalone.DayAbbreviations", metaValue_DayAbbreviations },
            { "islamic.QuarterNames", metaValue_QuarterNames },
            { "roc.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.DayAbbreviations", metaValue_DayAbbreviations },
            { "narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "islamic.DayAbbreviations", metaValue_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_AmPmMarkers },
            { "buddhist.DayNarrows", metaValue_DayNarrows },
            { "roc.narrow.AmPmMarkers", metaValue_narrow_AmPmMarkers },
            { "japanese.DayNarrows", metaValue_DayNarrows },
            { "QuarterNames", metaValue_QuarterNames },
            { "QuarterAbbreviations", metaValue_QuarterAbbreviations },
            { "standalone.QuarterNames",
                new String[] {
                    "Trimestrul 1",
                    "Trimestrul 2",
                    "Trimestrul 3",
                    "Trimestrul 4",
                }
            },
            { "japanese.QuarterNames", metaValue_QuarterNames },
        };
        return data;
    }
}
