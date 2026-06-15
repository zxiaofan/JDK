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

public class FormatData_sr_Cyrl_BA extends ListResourceBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] metaValue_generic_narrow_AmPmMarkers = new String[] {
            "\u043f\u0440\u0438\u0458\u0435\u202f\u043f\u043e\u0434\u043d\u0435",
            "\u043f\u043e\u202f\u043f\u043e\u0434\u043d\u0435",
            "\u043f\u043e\u043d\u043e\u045b",
            "\u043f\u043e\u0434\u043d\u0435",
            "\u0443\u0458\u0443\u0442\u0440\u043e",
            "",
            "\u043f\u043e \u043f\u043e\u0434\u043d\u0435",
            "",
            "\u0443\u0432\u0435\u0447\u0435",
            "",
            "\u043d\u043e\u045b\u0443",
            "",
        };
        final String[] metaValue_generic_DayNames = new String[] {
            "\u043d\u0435\u0434\u0458\u0435\u0459\u0430",
            "\u043f\u043e\u043d\u0435\u0434\u0458\u0435\u0459\u0430\u043a",
            "\u0443\u0442\u043e\u0440\u0430\u043a",
            "\u0441\u0440\u0438\u0458\u0435\u0434\u0430",
            "\u0447\u0435\u0442\u0432\u0440\u0442\u0430\u043a",
            "\u043f\u0435\u0442\u0430\u043a",
            "\u0441\u0443\u0431\u043e\u0442\u0430",
        };
        final String[] metaValue_generic_DayAbbreviations = new String[] {
            "\u043d\u0435\u0434",
            "\u043f\u043e\u043d",
            "\u0443\u0442\u043e",
            "\u0441\u0440\u0438",
            "\u0447\u0435\u0442",
            "\u043f\u0435\u0442",
            "\u0441\u0443\u0431",
        };
        final String[] metaValue_generic_AmPmMarkers = new String[] {
            "\u043f\u0440\u0438\u0458\u0435 \u043f\u043e\u0434\u043d\u0435",
            "\u043f\u043e \u043f\u043e\u0434\u043d\u0435",
            "\u043f\u043e\u043d\u043e\u045b",
            "\u043f\u043e\u0434\u043d\u0435",
            "\u0443\u0458\u0443\u0442\u0440\u043e",
            "",
            "\u043f\u043e \u043f\u043e\u0434\u043d\u0435",
            "",
            "\u0443\u0432\u0435\u0447\u0435",
            "",
            "\u043d\u043e\u045b\u0443",
            "",
        };
        final Object[][] data = new Object[][] {
            { "generic.DayNames", metaValue_generic_DayNames },
            { "generic.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "generic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "generic.narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "generic.abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "DayNames", metaValue_generic_DayNames },
            { "standalone.DayNames", metaValue_generic_DayNames },
            { "DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "standalone.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "long.Eras",
                new String[] {
                    "\u043f\u0440\u0438\u0458\u0435 \u043d\u043e\u0432\u0435 \u0435\u0440\u0435",
                    "\u043d\u043e\u0432\u0435 \u0435\u0440\u0435",
                }
            },
            { "field.month", "\u043c\u0458\u0435\u0441\u0435\u0446" },
            { "field.week", "\u0441\u0435\u0434\u043c\u0438\u0446\u0430" },
            { "field.weekday", "\u0434\u0430\u043d \u0443 \u0441\u0435\u0434\u043c\u0438\u0446\u0438" },
            { "field.dayperiod", "\u043f\u0440\u0438\u0458\u0435 \u043f\u043e\u0434\u043d\u0435/\u043f\u043e \u043f\u043e\u0434\u043d\u0435" },
            { "timezone.regionFormat.daylight", "{0}, \u0459\u0435\u0442\u045a\u0435 \u0432\u0440\u0438\u0458\u0435\u043c\u0435" },
            { "timezone.regionFormat.standard", "{0}, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0434\u043d\u043e \u0432\u0440\u0438\u0458\u0435\u043c\u0435" },
            { "buddhist.DayNames", metaValue_generic_DayNames },
            { "buddhist.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "buddhist.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "buddhist.narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "buddhist.abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "japanese.DayNames", metaValue_generic_DayNames },
            { "japanese.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "japanese.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "japanese.narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "japanese.abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "roc.DayNames", metaValue_generic_DayNames },
            { "roc.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "roc.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "roc.narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "roc.abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "islamic.DayNames", metaValue_generic_DayNames },
            { "islamic.DayAbbreviations", metaValue_generic_DayAbbreviations },
            { "islamic.AmPmMarkers", metaValue_generic_AmPmMarkers },
            { "islamic.narrow.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
            { "islamic.abbreviated.AmPmMarkers", metaValue_generic_narrow_AmPmMarkers },
        };
        return data;
    }
}
