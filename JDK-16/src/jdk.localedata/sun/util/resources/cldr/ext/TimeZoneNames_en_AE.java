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

public class TimeZoneNames_en_AE extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Gulf = new String[] {
               "Gulf Standard Time",
               "GST",
               "",
               "",
               "",
               "",
            };
        final String[] Alaska = new String[] {
               "Alaska Standard Time",
               "\u2205\u2205\u2205",
               "Alaska Daylight Time",
               "\u2205\u2205\u2205",
               "Alaska Time",
               "\u2205\u2205\u2205",
            };
        final String[] Atlantic = new String[] {
               "Atlantic Standard Time",
               "\u2205\u2205\u2205",
               "Atlantic Daylight Time",
               "\u2205\u2205\u2205",
               "Atlantic Time",
               "\u2205\u2205\u2205",
            };
        final String[] EMPTY_ZONE = new String[] {
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] America_Central = new String[] {
               "Central Standard Time",
               "\u2205\u2205\u2205",
               "Central Daylight Time",
               "\u2205\u2205\u2205",
               "Central Time",
               "\u2205\u2205\u2205",
            };
        final String[] America_Eastern = new String[] {
               "Eastern Standard Time",
               "\u2205\u2205\u2205",
               "Eastern Daylight Time",
               "\u2205\u2205\u2205",
               "Eastern Time",
               "\u2205\u2205\u2205",
            };
        final String[] America_Pacific = new String[] {
               "Pacific Standard Time",
               "\u2205\u2205\u2205",
               "Pacific Daylight Time",
               "\u2205\u2205\u2205",
               "Pacific Time",
               "\u2205\u2205\u2205",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "Hawaii-Aleutian Standard Time",
               "\u2205\u2205\u2205",
               "Hawaii-Aleutian Daylight Time",
               "\u2205\u2205\u2205",
               "Hawaii-Aleutian Time",
               "\u2205\u2205\u2205",
            };
        final String[] America_Mountain = new String[] {
               "Mountain Standard Time",
               "\u2205\u2205\u2205",
               "Mountain Daylight Time",
               "\u2205\u2205\u2205",
               "Mountain Time",
               "\u2205\u2205\u2205",
            };
        final Object[][] data = new Object[][] {
            { "America/Los_Angeles", America_Pacific },
            { "America/Denver", America_Mountain },
            { "America/Phoenix", America_Mountain },
            { "America/Chicago", America_Central },
            { "America/New_York", America_Eastern },
            { "America/Indianapolis", America_Eastern },
            { "Pacific/Honolulu",
                new String[] {
                    "",
                    "\u2205\u2205\u2205",
                    "",
                    "\u2205\u2205\u2205",
                    "",
                    "\u2205\u2205\u2205",
                }
            },
            { "America/Anchorage", Alaska },
            { "America/Halifax", Atlantic },
            { "America/Sitka", Alaska },
            { "UTC", EMPTY_ZONE },
            { "AST", Alaska },
            { "CST", America_Central },
            { "PNT", America_Mountain },
            { "PRT", Atlantic },
            { "PST", America_Pacific },
            { "CST6CDT", America_Central },
            { "EST5EDT", America_Eastern },
            { "MST7MDT", America_Mountain },
            { "PST8PDT", America_Pacific },
            { "Asia/Dubai", Gulf },
            { "Asia/Muscat", Gulf },
            { "America/Adak", Hawaii_Aleutian },
            { "America/Nome", Alaska },
            { "SystemV/AST4", Atlantic },
            { "SystemV/CST6", America_Central },
            { "SystemV/EST5", America_Eastern },
            { "SystemV/MST7", America_Mountain },
            { "America/Aruba", Atlantic },
            { "America/Boise", America_Mountain },
            { "America/Thule", Atlantic },
            { "SystemV/HST10",
                new String[] {
                    "",
                    "\u2205\u2205\u2205",
                    "",
                    "\u2205\u2205\u2205",
                    "",
                    "\u2205\u2205\u2205",
                }
            },
            { "America/Belize", America_Central },
            { "America/Cancun", America_Eastern },
            { "America/Cayman", America_Eastern },
            { "America/Dawson", America_Mountain },
            { "America/Inuvik", America_Mountain },
            { "America/Juneau", Alaska },
            { "America/Merida", America_Central },
            { "America/Nassau", America_Eastern },
            { "America/Panama", America_Eastern },
            { "America/Regina", America_Central },
            { "America/Antigua", Atlantic },
            { "America/Creston", America_Mountain },
            { "America/Curacao", Atlantic },
            { "America/Detroit", America_Eastern },
            { "America/Grenada", Atlantic },
            { "America/Iqaluit", America_Eastern },
            { "America/Jamaica", America_Eastern },
            { "America/Managua", America_Central },
            { "America/Marigot", Atlantic },
            { "America/Moncton", Atlantic },
            { "America/Nipigon", America_Eastern },
            { "America/Ojinaga", America_Mountain },
            { "America/Tijuana", America_Pacific },
            { "America/Toronto", America_Eastern },
            { "America/Tortola", Atlantic },
            { "America/Yakutat", Alaska },
            { "SystemV/AST4ADT", Atlantic },
            { "SystemV/CST6CDT", America_Central },
            { "SystemV/EST5EDT", America_Eastern },
            { "SystemV/MST7MDT", America_Mountain },
            { "SystemV/PST8PDT", America_Pacific },
            { "SystemV/YST9YDT", Alaska },
            { "America/Anguilla", Atlantic },
            { "America/Barbados", Atlantic },
            { "America/Dominica", Atlantic },
            { "America/Edmonton", America_Mountain },
            { "America/Montreal", America_Eastern },
            { "America/Resolute", America_Central },
            { "America/Shiprock", America_Mountain },
            { "America/St_Kitts", Atlantic },
            { "America/St_Lucia", Atlantic },
            { "America/Winnipeg", America_Central },
            { "Atlantic/Bermuda", Atlantic },
            { "Pacific/Johnston", Hawaii_Aleutian },
            { "America/Glace_Bay", Atlantic },
            { "America/Goose_Bay", Atlantic },
            { "America/Guatemala", America_Central },
            { "America/Matamoros", America_Central },
            { "America/Menominee", America_Central },
            { "America/Monterrey", America_Central },
            { "America/St_Thomas", Atlantic },
            { "America/Vancouver", America_Pacific },
            { "America/Costa_Rica", America_Central },
            { "America/Grand_Turk", America_Eastern },
            { "America/Guadeloupe", Atlantic },
            { "America/Kralendijk", Atlantic },
            { "America/Louisville", America_Eastern },
            { "America/Martinique", Atlantic },
            { "America/Metlakatla", Alaska },
            { "America/Montserrat", Atlantic },
            { "America/St_Vincent", Atlantic },
            { "America/Whitehorse", America_Mountain },
            { "America/El_Salvador", America_Central },
            { "America/Fort_Nelson", America_Mountain },
            { "America/Mexico_City", America_Central },
            { "America/Pangnirtung", America_Eastern },
            { "America/Puerto_Rico", Atlantic },
            { "America/Rainy_River", America_Central },
            { "America/Tegucigalpa", America_Central },
            { "America/Thunder_Bay", America_Eastern },
            { "America/Yellowknife", America_Mountain },
            { "America/Blanc-Sablon", Atlantic },
            { "America/Dawson_Creek", America_Mountain },
            { "America/Indiana/Knox", America_Central },
            { "America/Rankin_Inlet", America_Central },
            { "America/Cambridge_Bay", America_Mountain },
            { "America/Coral_Harbour", America_Eastern },
            { "America/Indiana/Vevay", America_Eastern },
            { "America/Lower_Princes", Atlantic },
            { "America/Port_of_Spain", Atlantic },
            { "America/Santo_Domingo", Atlantic },
            { "America/St_Barthelemy", Atlantic },
            { "America/Swift_Current", America_Central },
            { "America/Bahia_Banderas", America_Central },
            { "America/Port-au-Prince", America_Eastern },
            { "America/Indiana/Marengo", America_Eastern },
            { "America/Indiana/Winamac", America_Eastern },
            { "America/Indiana/Tell_City", America_Central },
            { "America/Indiana/Vincennes", America_Eastern },
            { "America/Indiana/Petersburg", America_Eastern },
            { "America/Kentucky/Monticello", America_Eastern },
            { "America/North_Dakota/Beulah", America_Central },
            { "America/North_Dakota/Center", America_Central },
            { "America/North_Dakota/New_Salem", America_Central },
        };
        return data;
    }
}
