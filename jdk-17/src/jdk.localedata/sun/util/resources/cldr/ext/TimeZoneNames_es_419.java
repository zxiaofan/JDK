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

public class TimeZoneNames_es_419 extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] GMT = new String[] {
               "hora del meridiano de Greenwich",
               "\u2205\u2205\u2205",
               "",
               "",
               "",
               "",
            };
        final String[] Cook = new String[] {
               "hora est\u00e1ndar de las islas Cook",
               "",
               "hora de verano media de las islas Cook",
               "",
               "hora de las islas Cook",
               "",
            };
        final String[] Wake = new String[] {
               "hora de Isla Wake",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Cocos = new String[] {
               "hora de Islas Cocos",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] India = new String[] {
               "hora de India",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Easter = new String[] {
               "hora est\u00e1ndar de Isla de Pascua",
               "",
               "hora de verano de la Isla de Pascua",
               "",
               "hora de la Isla de Pascua",
               "",
            };
        final String[] ETC_UTC = new String[] {
               "hora universal coordinada",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Myanmar = new String[] {
               "hora de Myanmar (Birmania)",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Norfolk = new String[] {
               "hora est\u00e1ndar de la Isla Norfolk",
               "",
               "hora de verano de la Isla Norfolk",
               "",
               "hora de la Isla Norfolk",
               "",
            };
        final String[] Solomon = new String[] {
               "hora de Islas Salom\u00f3n",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Falkland = new String[] {
               "hora est\u00e1ndar de las Islas Malvinas",
               "",
               "hora de verano de las Islas Malvinas",
               "",
               "hora de las Islas Malvinas",
               "",
            };
        final String[] Europe_Central = new String[] {
               "hora est\u00e1ndar de Europa central",
               "\u2205\u2205\u2205",
               "hora de verano de Europa central",
               "\u2205\u2205\u2205",
               "hora de Europa central",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Eastern = new String[] {
               "hora est\u00e1ndar de Europa del Este",
               "\u2205\u2205\u2205",
               "hora de verano de Europa del Este",
               "\u2205\u2205\u2205",
               "hora de Europa del Este",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Western = new String[] {
               "hora est\u00e1ndar de Europa del Oeste",
               "\u2205\u2205\u2205",
               "hora de verano de Europa del Oeste",
               "\u2205\u2205\u2205",
               "hora de Europa del Oeste",
               "\u2205\u2205\u2205",
            };
        final String[] French_Southern = new String[] {
               "hora de las Tierras Australes y Ant\u00e1rticas Francesas",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Gilbert_Islands = new String[] {
               "hora de Islas Gilbert",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] America_Mountain = new String[] {
               "hora est\u00e1ndar de la monta\u00f1a",
               "",
               "hora de verano de la monta\u00f1a",
               "",
               "hora de la monta\u00f1a",
               "",
            };
        final String[] Marshall_Islands = new String[] {
               "hora de Islas Marshall",
               "",
               "",
               "",
               "",
               "",
            };
        final Object[][] data = new Object[][] {
            { "America/Denver", America_Mountain },
            { "America/Phoenix", America_Mountain },
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", ETC_UTC },
            { "ART", Europe_Eastern },
            { "ECT", Europe_Central },
            { "PNT", America_Mountain },
            { "SST", Solomon },
            { "Etc/GMT", GMT },
            { "Etc/UTC", ETC_UTC },
            { "MST7MDT", America_Mountain },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Africa/Lome", GMT },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Oslo", Europe_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Africa/Accra", GMT },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Dakar", GMT },
            { "Africa/Tunis", Europe_Central },
            { "Asia/Colombo", India },
            { "Asia/Nicosia", Europe_Eastern },
            { "Asia/Rangoon", Myanmar },
            { "Europe/Malta", Europe_Central },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "Indian/Cocos", Cocos },
            { "Pacific/Wake", Wake },
            { "SystemV/MST7", America_Mountain },
            { "Africa/Bamako", GMT },
            { "Africa/Banjul", GMT },
            { "Africa/Bissau", GMT },
            { "America/Boise", America_Mountain },
            { "Asia/Calcutta", India },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Dublin",
                new String[] {
                    "hora del meridiano de Greenwich",
                    "\u2205\u2205\u2205",
                    "hora est\u00e1ndar de Irlanda",
                    "",
                    "",
                    "",
                }
            },
            { "Europe/Jersey", GMT },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/London", GMT },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Monaco", Europe_Central },
            { "Europe/Prague", Europe_Central },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Zurich", Europe_Central },
            { "Africa/Abidjan", GMT },
            { "Africa/Algiers", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Tripoli", Europe_Eastern },
            { "America/Dawson", America_Mountain },
            { "America/Inuvik", America_Mountain },
            { "Europe/Andorra", Europe_Central },
            { "Europe/Belfast", GMT },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vatican", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Pacific/Easter", Easter },
            { "Pacific/Majuro", Marshall_Islands },
            { "Pacific/Tarawa", Gilbert_Islands },
            { "Africa/Freetown", GMT },
            { "Africa/Monrovia", GMT },
            { "Africa/Sao_Tome", GMT },
            { "Africa/Timbuktu", GMT },
            { "America/Creston", America_Mountain },
            { "America/Ojinaga", America_Mountain },
            { "Atlantic/Canary", Europe_Western },
            { "Atlantic/Faeroe", Europe_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Budapest", Europe_Central },
            { "Europe/Busingen", Europe_Central },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/Guernsey", GMT },
            { "Europe/Helsinki", Europe_Eastern },
            { "Europe/Sarajevo", Europe_Central },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "Pacific/Norfolk", Norfolk },
            { "SystemV/MST7MDT", America_Mountain },
            { "America/Edmonton", America_Mountain },
            { "America/Shiprock", America_Mountain },
            { "Antarctica/Troll", GMT },
            { "Atlantic/Madeira", Europe_Western },
            { "Atlantic/Stanley", Falkland },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Gibraltar", Europe_Central },
            { "Europe/Ljubljana", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Stockholm", Europe_Central },
            { "Indian/Kerguelen", French_Southern },
            { "Africa/Nouakchott", GMT },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Pacific/Kwajalein", Marshall_Islands },
            { "Pacific/Rarotonga", Cook },
            { "Africa/Ouagadougou", GMT },
            { "America/Whitehorse", America_Mountain },
            { "Atlantic/Jan_Mayen", Europe_Central },
            { "Atlantic/Reykjavik", GMT },
            { "Atlantic/St_Helena", GMT },
            { "Europe/Isle_of_Man", GMT },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "America/Fort_Nelson", America_Mountain },
            { "America/Yellowknife", America_Mountain },
            { "Arctic/Longyearbyen", Europe_Central },
            { "Pacific/Guadalcanal", Solomon },
            { "America/Danmarkshavn", GMT },
            { "America/Dawson_Creek", America_Mountain },
            { "America/Cambridge_Bay", America_Mountain },
            { "timezone.excity.Etc/Unknown", "ciudad desconocida" },
            { "timezone.excity.Pacific/Wake", "Isla Wake" },
            { "timezone.excity.America/Nassau", "Nas\u00e1u" },
            { "timezone.excity.Atlantic/Canary", "Islas Canarias" },
            { "timezone.excity.Europe/Busingen", "B\u00fcsingen" },
            { "timezone.excity.Europe/Guernsey", "Guernsey" },
            { "timezone.excity.America/Santiago", "Santiago" },
            { "timezone.excity.America/St_Thomas", "Santo Tom\u00e1s" },
            { "timezone.excity.America/Fort_Nelson", "Fuerte Nelson" },
        };
        return data;
    }
}
