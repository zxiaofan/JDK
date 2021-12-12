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

public class TimeZoneNames_wae extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Atlantic = new String[] {
               "Atlanti\u0161i Standardzit",
               "",
               "Atlanti\u0161i Summerzit",
               "",
               "Atlanti\u0161i Zit",
               "",
            };
        final String[] EMPTY_ZONE = new String[] {
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Europe_Central = new String[] {
               "Mitteleurop\u00e4i\u0161i Standardzit",
               "MEZ",
               "Mitteleurop\u00e4i\u0161i Summerzit",
               "MESZ",
               "Mitteleurop\u00e4i\u0161i Zit",
               "MEZ",
            };
        final String[] Europe_Eastern = new String[] {
               "O\u0161teurop\u00e4i\u0161i Standardzit",
               "OEZ",
               "O\u0161teurop\u00e4i\u0161i Summerzit",
               "OESZ",
               "O\u0161teurop\u00e4i\u0161i Zit",
               "OEZ",
            };
        final String[] Europe_Western = new String[] {
               "We\u0161teurop\u00e4i\u0161i Standardzit",
               "WEZ",
               "We\u0161teurop\u00e4i\u0161i Summerzit",
               "WESZ",
               "We\u0161teurop\u00e4i\u0161i Zit",
               "WEZ",
            };
        final Object[][] data = new Object[][] {
            { "America/Halifax", Atlantic },
            { "Europe/Paris", Europe_Central },
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", EMPTY_ZONE },
            { "ART", Europe_Eastern },
            { "ECT", Europe_Central },
            { "PRT", Atlantic },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Oslo", Europe_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Tunis", Europe_Central },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Malta", Europe_Central },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "SystemV/AST4", Atlantic },
            { "America/Aruba", Atlantic },
            { "America/Thule", Atlantic },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Monaco", Europe_Central },
            { "Europe/Prague", Europe_Central },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Zurich", Europe_Central },
            { "Africa/Algiers", Europe_Central },
            { "Africa/Tripoli", Europe_Eastern },
            { "Europe/Andorra", Europe_Central },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vatican", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "America/Antigua", Atlantic },
            { "America/Curacao", Atlantic },
            { "America/Grenada", Atlantic },
            { "America/Marigot", Atlantic },
            { "America/Moncton", Atlantic },
            { "America/Tortola", Atlantic },
            { "Atlantic/Canary", Europe_Western },
            { "Atlantic/Faeroe", Europe_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Budapest", Europe_Central },
            { "Europe/Busingen", Europe_Central },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/Helsinki", Europe_Eastern },
            { "Europe/Sarajevo", Europe_Central },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "SystemV/AST4ADT", Atlantic },
            { "America/Anguilla", Atlantic },
            { "America/Barbados", Atlantic },
            { "America/Dominica", Atlantic },
            { "America/St_Kitts", Atlantic },
            { "America/St_Lucia", Atlantic },
            { "Atlantic/Bermuda", Atlantic },
            { "Atlantic/Madeira", Europe_Western },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Gibraltar", Europe_Central },
            { "Europe/Ljubljana", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Stockholm", Europe_Central },
            { "America/Glace_Bay", Atlantic },
            { "America/Goose_Bay", Atlantic },
            { "America/St_Thomas", Atlantic },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "America/Guadeloupe", Atlantic },
            { "America/Kralendijk", Atlantic },
            { "America/Martinique", Atlantic },
            { "America/Montserrat", Atlantic },
            { "America/St_Vincent", Atlantic },
            { "Atlantic/Jan_Mayen", Europe_Central },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "America/Puerto_Rico", Atlantic },
            { "Arctic/Longyearbyen", Europe_Central },
            { "America/Blanc-Sablon", Atlantic },
            { "America/Lower_Princes", Atlantic },
            { "America/Port_of_Spain", Atlantic },
            { "America/Santo_Domingo", Atlantic },
            { "America/St_Barthelemy", Atlantic },
            { "timezone.excity.Asia/Tokyo", "Tokio" },
            { "timezone.excity.Etc/Unknown", "Unbekannti Stadt" },
            { "timezone.excity.Europe/Rome", "Rom" },
            { "timezone.excity.Africa/Accra", "Akra" },
            { "timezone.excity.Africa/Cairo", "Kairo" },
            { "timezone.excity.Asia/Baghdad", "Bagdad" },
            { "timezone.excity.Asia/Damascus", "Damaskus" },
            { "timezone.excity.Europe/Prague", "Prag" },
            { "timezone.excity.Europe/Tirane", "Tiran" },
            { "timezone.excity.Europe/Vienna", "Wien" },
            { "timezone.excity.Europe/Warsaw", "War\u0161au" },
            { "timezone.excity.Europe/Zurich", "Z\u00fcri\u010d" },
            { "timezone.excity.Africa/Algiers", "Algier" },
            { "timezone.excity.Africa/Tripoli", "Tripolis" },
            { "timezone.excity.America/Cayman", "Kaimaninsla" },
            { "timezone.excity.America/Havana", "Hawanna" },
            { "timezone.excity.Asia/Hong_Kong", "Hongkong" },
            { "timezone.excity.Asia/Singapore", "Singapur" },
            { "timezone.excity.Europe/Tallinn", "Reval" },
            { "timezone.excity.Europe/Vatican", "Vatikan" },
            { "timezone.excity.Europe/Vilnius", "Wilna" },
            { "timezone.excity.Africa/Djibouti", "D\u0161ibuti" },
            { "timezone.excity.Africa/Khartoum", "Kartum" },
            { "timezone.excity.America/Cordoba", "Kordoba" },
            { "timezone.excity.America/Jamaica", "Jamaika" },
            { "timezone.excity.Europe/Belgrade", "Belgrad" },
            { "timezone.excity.Europe/Brussels", "Br\u00fcssel" },
            { "timezone.excity.Europe/Budapest", "Budape\u0161t" },
            { "timezone.excity.Europe/Istanbul", "Kon\u0161tantinopel" },
            { "timezone.excity.Africa/Mogadishu", "Mogadi\u0161u" },
            { "timezone.excity.Australia/Sydney", "Sidnei" },
            { "timezone.excity.Europe/Amsterdam", "Am\u0161terdam" },
            { "timezone.excity.Europe/Bucharest", "Bukare\u0161t" },
            { "timezone.excity.Europe/Ljubljana", "Laiba\u010d" },
            { "timezone.excity.Europe/Volgograd", "Wolgograd" },
            { "timezone.excity.Europe/Copenhagen", "Kopehage" },
            { "timezone.excity.Africa/Ouagadougou", "Wagadugu" },
            { "timezone.excity.America/Montserrat", "Monserat" },
            { "timezone.excity.Atlantic/Reykjavik", "Rikjawik" },
            { "timezone.excity.Europe/Kaliningrad", "K\u00f6nigsb\u00e4rg" },
        };
        return data;
    }
}
