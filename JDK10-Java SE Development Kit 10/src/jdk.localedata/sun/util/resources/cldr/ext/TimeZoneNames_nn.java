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

public class TimeZoneNames_nn extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "sentralafrikansk tid",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "vest-sentralaustralsk standardtid",
               "ACWST",
               "vest-sentralaustralsk sommartid",
               "ACWDT",
               "vest-sentralaustralsk tid",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "sentraleuropeisk standardtid",
               "CET",
               "sentraleuropeisk sommartid",
               "CEST",
               "sentraleuropeisk tid",
               "CET",
            };
        final String[] Africa_Southern = new String[] {
               "s\u00f8rafrikansk tid",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Australia_Western = new String[] {
               "vestaustralsk standardtid",
               "AWST",
               "vestaustralsk sommartid",
               "AWDT",
               "vestaustralsk tid",
               "AWT",
            };
        final String[] Australia_Central = new String[] {
               "sentralaustralsk standardtid",
               "ACST",
               "sentralaustralsk sommartid",
               "ACDT",
               "sentralaustralsk tid",
               "ACT",
            };
        final String[] Australia_Eastern = new String[] {
               "austaustralsk standardtid",
               "AEST",
               "austaustralsk sommartid",
               "AEDT",
               "austaustralsk tid",
               "AET",
            };
        final String[] Africa_Eastern = new String[] {
               "austafrikansk tid",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] Europe_Western = new String[] {
               "vesteuropeisk standardtid",
               "WET",
               "vesteuropeisk sommartid",
               "WEST",
               "vesteuropeisk tid",
               "WET",
            };
        final String[] Europe_Eastern = new String[] {
               "austeuropeisk standardtid",
               "EET",
               "austeuropeisk sommartid",
               "EEST",
               "austeuropeisk tid",
               "EET",
            };
        final String[] Africa_Western = new String[] {
               "vestafrikansk standardtid",
               "CAT",
               "vestafrikansk sommartid",
               "CAST",
               "vestafrikansk tid",
               "CAT",
            };
        final String[] GMT = new String[] {
               "greenwich middeltid",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final Object[][] data = new Object[][] {
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Africa/Casablanca", Europe_Western },
            { "Europe/Bucharest", Europe_Eastern },
            { "Europe/Ljubljana", Europe_Central },
            { "Africa/Nairobi", Africa_Eastern },
            { "Africa/Libreville", Africa_Western },
            { "Africa/Lusaka", Africa_Central },
            { "Africa/Maputo", Africa_Central },
            { "Europe/Berlin", Europe_Central },
            { "Africa/El_Aaiun", Europe_Western },
            { "Africa/Ouagadougou", GMT },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Mbabane", Africa_Southern },
            { "Australia/Hobart", Australia_Eastern },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/London", GMT },
            { "Europe/Stockholm", Europe_Central },
            { "Africa/Dakar", GMT },
            { "Europe/Budapest", Europe_Central },
            { "Australia/Eucla", Australia_CentralWestern },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Helsinki", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Europe/Brussels", Europe_Central },
            { "Africa/Harare", Africa_Central },
            { "Africa/Douala", Africa_Western },
            { "Africa/Sao_Tome", GMT },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Tallinn", Europe_Eastern },
            { "Africa/Khartoum", Africa_Eastern },
            { "Europe/Jersey", GMT },
            { "Africa/Johannesburg", Africa_Southern },
            { "Europe/Istanbul", Europe_Eastern },
            { "Africa/Ndjamena", Africa_Western },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Luxembourg", Europe_Central },
            { "Africa/Bangui", Africa_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Africa/Bissau", GMT },
            { "Atlantic/Reykjavik", GMT },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Africa/Brazzaville", Africa_Western },
            { "Africa/Porto-Novo", Africa_Western },
            { "Atlantic/St_Helena", GMT },
            { "Africa/Juba", Africa_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "Europe/Guernsey", GMT },
            { "Atlantic/Madeira", Europe_Western },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Australia/Adelaide", Australia_Central },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "Africa/Djibouti", Africa_Eastern },
            { "Africa/Kigali", Africa_Central },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Isle_of_Man", GMT },
            { "Africa/Nouakchott", GMT },
            { "Africa/Niamey", Africa_Western },
            { "Europe/Prague", Europe_Central },
            { "Antarctica/Troll", GMT },
            { "Africa/Tunis", Europe_Central },
            { "Europe/Andorra", Europe_Central },
            { "Africa/Tripoli", Europe_Eastern },
            { "Africa/Banjul", GMT },
            { "Indian/Comoro", Africa_Eastern },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Africa/Gaborone", Africa_Central },
            { "Africa/Windhoek", Africa_Western },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/Oslo", Europe_Central },
            { "Africa/Mogadishu", Africa_Eastern },
            { "Asia/Gaza", Europe_Eastern },
            { "Australia/Perth", Australia_Western },
            { "Australia/Darwin", Australia_Central },
            { "Atlantic/Faeroe", Europe_Western },
            { "Atlantic/Canary", Europe_Western },
            { "Europe/Bratislava", Europe_Central },
            { "Africa/Lome", GMT },
            { "Africa/Freetown", GMT },
            { "Antarctica/Casey", Australia_Western },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Malta", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Africa/Asmera", Africa_Eastern },
            { "Europe/Busingen", Europe_Central },
            { "Africa/Kampala", Africa_Eastern },
            { "Africa/Malabo", Africa_Western },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Sarajevo", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Africa/Bujumbura", Africa_Central },
            { "Arctic/Longyearbyen", Europe_Central },
            { "Australia/Broken_Hill", Australia_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Africa/Lagos", Africa_Western },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Asia/Hebron", Europe_Eastern },
            { "Africa/Abidjan", GMT },
            { "Africa/Monrovia", GMT },
            { "Africa/Luanda", Africa_Western },
            { "Australia/Currie", Australia_Eastern },
            { "Australia/Melbourne", Australia_Eastern },
            { "Africa/Algiers", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Zurich", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Africa/Bamako", GMT },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Vatican", Europe_Central },
            { "Africa/Accra", GMT },
            { "Africa/Maseru", Africa_Southern },
            { "Europe/Gibraltar", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Kinshasa", Africa_Western },
            { "Asia/Amman", Europe_Eastern },
            { "Australia/Sydney", Australia_Eastern },
            { "Africa/Lubumbashi", Africa_Central },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Dublin", GMT },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Australia/Lindeman", Australia_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "Australia/Brisbane", Australia_Eastern },
            { "Indian/Mayotte", Africa_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Africa/Blantyre", Africa_Central },
            { "America/Danmarkshavn", GMT },
            { "Europe/Monaco", Europe_Central },
        };
        return data;
    }
}
