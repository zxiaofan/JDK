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

package sun.util.resources.cldr.ext;

import sun.util.resources.TimeZoneNamesBundle;

public class TimeZoneNames_lrc extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] EMPTY_ZONE = new String[] {
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] America_Central = new String[] {
               "\u06af\u0627\u065b\u062a \u0645\u06cc\u0646\u062c\u0627\u065b\u06cc\u06cc \u0626\u0633\u062a\u0627\u065b\u0646\u062f\u0627\u065b\u0631\u062f",
               "",
               "\u0631\u0648\u0659\u0634\u0646\u0627\u06cc\u06cc \u0646\u0626\u0647\u0627\u062f\u0627\u0631 \u0631\u0648\u0659\u0632",
               "",
               "\u06af\u0627\u065b\u062a \u0645\u06cc\u0646\u062c\u0627\u065b\u06cc\u06cc",
               "",
            };
        final Object[][] data = new Object[][] {
            { "America/Chicago", America_Central },
            { "UTC", EMPTY_ZONE },
            { "CST", America_Central },
            { "CST6CDT", America_Central },
            { "SystemV/CST6", America_Central },
            { "America/Belize", America_Central },
            { "America/Merida", America_Central },
            { "America/Regina", America_Central },
            { "America/Managua", America_Central },
            { "SystemV/CST6CDT", America_Central },
            { "America/Resolute", America_Central },
            { "America/Winnipeg", America_Central },
            { "America/Guatemala", America_Central },
            { "America/Matamoros", America_Central },
            { "America/Menominee", America_Central },
            { "America/Monterrey", America_Central },
            { "America/Costa_Rica", America_Central },
            { "America/El_Salvador", America_Central },
            { "America/Mexico_City", America_Central },
            { "America/Rainy_River", America_Central },
            { "America/Tegucigalpa", America_Central },
            { "America/Indiana/Knox", America_Central },
            { "America/Rankin_Inlet", America_Central },
            { "America/Swift_Current", America_Central },
            { "America/Bahia_Banderas", America_Central },
            { "America/Indiana/Tell_City", America_Central },
            { "America/North_Dakota/Beulah", America_Central },
            { "America/North_Dakota/Center", America_Central },
            { "timezone.excity.Etc/Unknown", "\u0646\u0627\u062f\u06cc\u0627\u0631" },
            { "America/North_Dakota/New_Salem", America_Central },
        };
        return data;
    }
}
