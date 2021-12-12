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

public class TimeZoneNames_es_MX extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Apia = new String[] {
               "hora est\u00e1ndar de Apia",
               "",
               "hora de verano de Apia",
               "",
               "hora de Apia",
               "",
            };
        final String[] Cook = new String[] {
               "hora est\u00e1ndar de las Islas Cook",
               "",
               "hora de verano media de las Islas Cook",
               "",
               "hora de las Islas Cook",
               "",
            };
        final String[] Wake = new String[] {
               "hora de la Isla Wake",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Cocos = new String[] {
               "hora de las Islas Cocos",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Easter = new String[] {
               "hora est\u00e1ndar de la isla de Pascua",
               "",
               "hora de verano de la isla de Pascua",
               "",
               "hora de Isla de Pascua",
               "",
            };
        final String[] Solomon = new String[] {
               "hora de las Islas Salom\u00f3n",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Falkland = new String[] {
               "hora est\u00e1ndar de Islas Malvinas",
               "",
               "hora de verano de Islas Malvinas",
               "",
               "hora de Islas Malvinas",
               "",
            };
        final String[] Christmas = new String[] {
               "hora de la isla de Navidad",
               "",
               "",
               "",
               "",
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
        final String[] Europe_Eastern = new String[] {
               "hora est\u00e1ndar de Europa oriental",
               "\u2205\u2205\u2205",
               "hora de verano de Europa oriental",
               "\u2205\u2205\u2205",
               "hora de Europa oriental",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Western = new String[] {
               "hora est\u00e1ndar de Europa occidental",
               "\u2205\u2205\u2205",
               "hora de verano de Europa occidental",
               "\u2205\u2205\u2205",
               "hora de Europa occidental",
               "\u2205\u2205\u2205",
            };
        final String[] Gilbert_Islands = new String[] {
               "hora de las Islas Gilbert",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Marshall_Islands = new String[] {
               "hora de las Islas Marshall",
               "",
               "",
               "",
               "",
               "",
            };
        final Object[][] data = new Object[][] {
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", EMPTY_ZONE },
            { "ART", Europe_Eastern },
            { "MIT", Apia },
            { "SST", Solomon },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Riga", Europe_Eastern },
            { "Africa/Cairo", Europe_Eastern },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Sofia", Europe_Eastern },
            { "Indian/Cocos", Cocos },
            { "Pacific/Apia", Apia },
            { "Pacific/Wake", Wake },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Lisbon", Europe_Western },
            { "Africa/Tripoli", Europe_Eastern },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vilnius", Europe_Eastern },
            { "Pacific/Easter", Easter },
            { "Pacific/Majuro", Marshall_Islands },
            { "Pacific/Tarawa", Gilbert_Islands },
            { "Atlantic/Canary", Europe_Western },
            { "Atlantic/Faeroe", Europe_Western },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/Helsinki", Europe_Eastern },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "Atlantic/Madeira", Europe_Western },
            { "Atlantic/Stanley", Falkland },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Indian/Christmas", Christmas },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Pacific/Kwajalein", Marshall_Islands },
            { "Pacific/Rarotonga", Cook },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Pacific/Guadalcanal", Solomon },
            { "timezone.excity.Asia/Almaty", "Almat\u00fd" },
            { "timezone.excity.Asia/Aqtobe", "Aktob\u00e9" },
            { "timezone.excity.Asia/Atyrau", "Atirau" },
            { "timezone.excity.Pacific/Wake", "Wake" },
            { "timezone.excity.Africa/Conakry", "Conakri" },
            { "timezone.excity.Africa/Khartoum", "Jartum" },
            { "timezone.excity.Africa/Bujumbura", "Buyumbura" },
            { "timezone.excity.Pacific/Honolulu", "Honolulu" },
            { "timezone.excity.America/St_Thomas", "St. Thomas" },
            { "timezone.excity.America/Rio_Branco", "Rio Branco" },
            { "timezone.excity.America/Fort_Nelson", "Fort Nelson" },
            { "timezone.excity.Africa/Dar_es_Salaam", "Dar es-Salaam" },
        };
        return data;
    }
}
