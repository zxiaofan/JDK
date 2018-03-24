/*
 * Copyright (c) 2012, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.resources.cldr.ext;

import sun.util.resources.TimeZoneNamesBundle;

public class TimeZoneNames_es_419 extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Europe_Western = new String[] {
               "hora est\u00e1ndar de Europa occidental",
               "\u2205\u2205\u2205",
               "hora de verano de Europa occidental",
               "\u2205\u2205\u2205",
               "hora de Europa occidental",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Eastern = new String[] {
               "hora est\u00e1ndar de Europa oriental",
               "\u2205\u2205\u2205",
               "hora de verano de Europa oriental",
               "\u2205\u2205\u2205",
               "hora de Europa oriental",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Central = new String[] {
               "hora est\u00e1ndar de Europa central",
               "\u2205\u2205\u2205",
               "hora de verano de Europa central",
               "\u2205\u2205\u2205",
               "hora de Europa central",
               "\u2205\u2205\u2205",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "horario del lejano este de Europa",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] GMT = new String[] {
               "hora del meridiano de Greenwich",
               "\u2205\u2205\u2205",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Cook = new String[] {
               "hora est\u00e1ndar de las islas Cook",
               "CKT",
               "hora de verano media de las islas Cook",
               "CKHST",
               "hora de las islas Cook",
               "CKT",
            };
        final Object[][] data = new Object[][] {
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Africa/Casablanca", Europe_Western },
            { "Europe/Bucharest", Europe_Eastern },
            { "Europe/Ljubljana", Europe_Central },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Europe/Berlin", Europe_Central },
            { "Africa/El_Aaiun", Europe_Western },
            { "Africa/Ouagadougou", GMT },
            { "Africa/Cairo", Europe_Eastern },
            { "Europe/Lisbon", Europe_Western },
            { "Pacific/Rarotonga", Cook },
            { "Europe/Oslo", Europe_Central },
            { "Asia/Gaza", Europe_Eastern },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/London", GMT },
            { "Atlantic/Faeroe", Europe_Western },
            { "Europe/Stockholm", Europe_Central },
            { "Africa/Dakar", GMT },
            { "Europe/Budapest", Europe_Central },
            { "Atlantic/Canary", Europe_Western },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Africa/Lome", GMT },
            { "Africa/Freetown", GMT },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Malta", Europe_Central },
            { "Europe/Helsinki", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Busingen", Europe_Central },
            { "Africa/Sao_Tome", GMT },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Jersey", GMT },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Istanbul", Europe_Eastern },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Sarajevo", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/Belgrade", Europe_Central },
            { "Arctic/Longyearbyen", Europe_Central },
            { "Europe/Minsk", Europe_Further_Eastern },
            { "Africa/Bissau", GMT },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Asia/Hebron", Europe_Eastern },
            { "Africa/Abidjan", GMT },
            { "Atlantic/Reykjavik", GMT },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Africa/Monrovia", GMT },
            { "Atlantic/St_Helena", GMT },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Algiers", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Zurich", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Africa/Bamako", GMT },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Guernsey", GMT },
            { "Atlantic/Madeira", Europe_Western },
            { "Europe/Vatican", Europe_Central },
            { "Africa/Accra", GMT },
            { "Europe/Gibraltar", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Asia/Amman", Europe_Eastern },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "Europe/Dublin", GMT },
            { "Europe/Vaduz", Europe_Central },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Isle_of_Man", GMT },
            { "Africa/Nouakchott", GMT },
            { "Europe/Prague", Europe_Central },
            { "Antarctica/Troll", GMT },
            { "Africa/Tunis", Europe_Central },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Andorra", Europe_Central },
            { "Africa/Tripoli", Europe_Eastern },
            { "Africa/Banjul", GMT },
            { "America/Danmarkshavn", GMT },
            { "Europe/Monaco", Europe_Central },
        };
        return data;
    }
}
