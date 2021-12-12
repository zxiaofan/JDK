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

public class TimeZoneNames_en_AU extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Cook = new String[] {
               "Cook Island Standard Time",
               "",
               "Cook Island Summer Time",
               "",
               "Cook Island Time",
               "",
            };
        final String[] China = new String[] {
               "China Standard Time",
               "",
               "China Summer Time",
               "",
               "China Time",
               "",
            };
        final String[] Japan = new String[] {
               "Japan Standard Time",
               "",
               "Japan Summer Time",
               "",
               "Japan Time",
               "",
            };
        final String[] Korea = new String[] {
               "Korean Standard Time",
               "",
               "Korean Summer Time",
               "",
               "Korea Time",
               "",
            };
        final String[] Samoa = new String[] {
               "Samoa Standard Time",
               "",
               "Samoa Summer Time",
               "",
               "Samoa Time",
               "",
            };
        final String[] Moscow = new String[] {
               "Moscow Standard Time",
               "",
               "Moscow Daylight Time",
               "",
               "Moscow Time",
               "",
            };
        final String[] Taipei = new String[] {
               "Taipei Standard Time",
               "",
               "Taipei Summer Time",
               "",
               "Taipei Time",
               "",
            };
        final String[] Arabian = new String[] {
               "Arabia Standard Time",
               "",
               "Arabia Daylight Time",
               "",
               "Arabia Time",
               "",
            };
        final String[] Lord_Howe = new String[] {
               "Lord Howe Standard Time",
               "LHST",
               "Lord Howe Daylight Time",
               "LHDT",
               "Lord Howe Time",
               "LHT",
            };
        final String[] EMPTY_ZONE = new String[] {
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] New_Zealand = new String[] {
               "New Zealand Standard Time",
               "NZST",
               "New Zealand Daylight Time",
               "NZDT",
               "New Zealand Time",
               "NZT",
            };
        final String[] Africa_Eastern = new String[] {
               "Eastern Africa Time",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Australia_Central = new String[] {
               "Australian Central Standard Time",
               "ACST",
               "Australian Central Daylight Time",
               "ACDT",
               "Australian Central Time",
               "ACT",
            };
        final String[] Australia_Eastern = new String[] {
               "Australian Eastern Standard Time",
               "AEST",
               "Australian Eastern Daylight Time",
               "AEDT",
               "Australian Eastern Time",
               "AET",
            };
        final String[] Australia_Western = new String[] {
               "Australian Western Standard Time",
               "AWST",
               "Australian Western Daylight Time",
               "AWDT",
               "Australian Western Time",
               "AWT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "Australian Central Western Standard Time",
               "ACWST",
               "Australian Central Western Daylight Time",
               "ACWDT",
               "Australian Central Western Time",
               "ACWT",
            };
        final Object[][] data = new Object[][] {
            { "Asia/Tokyo", Japan },
            { "Asia/Shanghai", China },
            { "UTC", EMPTY_ZONE },
            { "ACT", Australia_Central },
            { "AET", Australia_Eastern },
            { "CTT", China },
            { "EAT", Africa_Eastern },
            { "JST", Japan },
            { "NST", New_Zealand },
            { "Asia/Aden", Arabian },
            { "Asia/Macau", China },
            { "Asia/Qatar", Arabian },
            { "Asia/Seoul", Korea },
            { "Asia/Harbin", China },
            { "Asia/Kuwait", Arabian },
            { "Asia/Riyadh", Arabian },
            { "Asia/Taipei", Taipei },
            { "Asia/Baghdad", Arabian },
            { "Asia/Bahrain", Arabian },
            { "Europe/Minsk", Moscow },
            { "Africa/Asmera", Africa_Eastern },
            { "Europe/Moscow", Moscow },
            { "Indian/Comoro", Africa_Eastern },
            { "Africa/Kampala", Africa_Eastern },
            { "Africa/Nairobi", Africa_Eastern },
            { "Asia/Chongqing", China },
            { "Asia/Pyongyang", Korea },
            { "Indian/Mayotte", Africa_Eastern },
            { "Pacific/Midway", Samoa },
            { "Africa/Djibouti", Africa_Eastern },
            { "Australia/Eucla", Australia_CentralWestern },
            { "Australia/Perth", Australia_Western },
            { "Africa/Mogadishu", Africa_Eastern },
            { "Australia/Currie", Australia_Eastern },
            { "Australia/Darwin", Australia_Central },
            { "Australia/Hobart", Australia_Eastern },
            { "Australia/Sydney", Australia_Eastern },
            { "Pacific/Auckland", New_Zealand },
            { "Europe/Simferopol", Moscow },
            { "Pacific/Pago_Pago", Samoa },
            { "Pacific/Rarotonga", Cook },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Antarctica/McMurdo", New_Zealand },
            { "Australia/Adelaide", Australia_Central },
            { "Australia/Brisbane", Australia_Eastern },
            { "Australia/Lindeman", Australia_Eastern },
            { "Australia/Lord_Howe", Lord_Howe },
            { "Australia/Melbourne", Australia_Eastern },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "Antarctica/Macquarie", Australia_Eastern },
            { "Antarctica/South_Pole", New_Zealand },
            { "Australia/Broken_Hill", Australia_Central },
            { "timezone.excity.Pacific/Johnston", "Johnston" },
        };
        return data;
    }
}
