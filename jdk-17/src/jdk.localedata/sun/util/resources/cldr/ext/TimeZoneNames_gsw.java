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

public class TimeZoneNames_gsw extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Acre = new String[] {
               "Acre-Schtandardziit",
               "",
               "Acre-Summerziit",
               "",
               "Acre-Ziit",
               "",
            };
        final String[] Alaska = new String[] {
               "Alaska-Schtandardziit",
               "",
               "Alaska-Summerziit",
               "",
               "Alaska-Ziit",
               "",
            };
        final String[] Amazon = new String[] {
               "Amazonas-Schtandardziit",
               "",
               "Amazonas-Summerziit",
               "",
               "Amazonas-Ziit",
               "",
            };
        final String[] Moscow = new String[] {
               "Moskauer Schtandardziit",
               "",
               "Moskauer Summerziit",
               "",
               "Moskauer Ziit",
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
        final String[] Afghanistan = new String[] {
               "Afghanischtan-Ziit",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Central = new String[] {
               "Zentralafrikanischi Ziit",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Eastern = new String[] {
               "Oschtafrikanischi Ziit",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Western = new String[] {
               "Weschtafrikanischi Schtandardziit",
               "",
               "Weschtafrikanischi Summerziit",
               "",
               "Weschtafrikanischi Ziit",
               "",
            };
        final String[] Europe_Central = new String[] {
               "Mitteleurop\u00e4ischi Schtandardziit",
               "MEZ",
               "Mitteleurop\u00e4ischi Summerziit",
               "MESZ",
               "Mitteleurop\u00e4ischi Ziit",
               "MEZ",
            };
        final String[] Europe_Eastern = new String[] {
               "Oschteurop\u00e4ischi Schtandardziit",
               "OEZ",
               "Oschteurop\u00e4ischi Summerziit",
               "OESZ",
               "Oschteurop\u00e4ischi Ziit",
               "OEZ",
            };
        final String[] Europe_Western = new String[] {
               "Weschteurop\u00e4ischi Schtandardziit",
               "WEZ",
               "Weschteurop\u00e4ischi Summerziit",
               "WESZ",
               "Weschteurop\u00e4ischi Ziit",
               "WEZ",
            };
        final String[] Africa_Southern = new String[] {
               "S\u00fc\u00fcdafrikanischi ziit",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] America_Central = new String[] {
               "Amerika-Zentraal Schtandardziit",
               "",
               "Amerika-Zentraal Summerziit",
               "",
               "Amerika-Zentraal Ziit",
               "",
            };
        final Object[][] data = new Object[][] {
            { "America/Chicago", America_Central },
            { "America/Anchorage", Alaska },
            { "America/Sitka", Alaska },
            { "Europe/Paris", Europe_Central },
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", EMPTY_ZONE },
            { "ART", Europe_Eastern },
            { "AST", Alaska },
            { "CAT", Africa_Central },
            { "CST", America_Central },
            { "EAT", Africa_Eastern },
            { "ECT", Europe_Central },
            { "CST6CDT", America_Central },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Asia/Kabul", Afghanistan },
            { "Africa/Juba", Africa_Central },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Oslo", Europe_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Lagos", Africa_Western },
            { "Africa/Tunis", Europe_Central },
            { "America/Nome", Alaska },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Malta", Europe_Central },
            { "Europe/Minsk", Moscow },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "SystemV/CST6", America_Central },
            { "Africa/Asmera", Africa_Eastern },
            { "Africa/Bangui", Africa_Western },
            { "Africa/Douala", Africa_Western },
            { "Africa/Harare", Africa_Central },
            { "Africa/Kigali", Africa_Central },
            { "Africa/Luanda", Africa_Western },
            { "Africa/Lusaka", Africa_Central },
            { "Africa/Malabo", Africa_Western },
            { "Africa/Maputo", Africa_Central },
            { "Africa/Maseru", Africa_Southern },
            { "Africa/Niamey", Africa_Western },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Monaco", Europe_Central },
            { "Europe/Moscow", Moscow },
            { "Europe/Prague", Europe_Central },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Zurich", Europe_Central },
            { "Indian/Comoro", Africa_Eastern },
            { "Africa/Algiers", Europe_Central },
            { "Africa/Kampala", Africa_Eastern },
            { "Africa/Mbabane", Africa_Southern },
            { "Africa/Nairobi", Africa_Eastern },
            { "Africa/Tripoli", Europe_Eastern },
            { "America/Belize", America_Central },
            { "America/Cuiaba", Amazon },
            { "America/Juneau", Alaska },
            { "America/Manaus", Amazon },
            { "America/Merida", America_Central },
            { "America/Regina", America_Central },
            { "Europe/Andorra", Europe_Central },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vatican", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Indian/Mayotte", Africa_Eastern },
            { "Africa/Blantyre", Africa_Central },
            { "Africa/Djibouti", Africa_Eastern },
            { "Africa/Gaborone", Africa_Central },
            { "Africa/Khartoum", Africa_Central },
            { "Africa/Kinshasa", Africa_Western },
            { "Africa/Ndjamena", Africa_Western },
            { "Africa/Windhoek", Africa_Central },
            { "America/Managua", America_Central },
            { "America/Yakutat", Alaska },
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
            { "SystemV/CST6CDT", America_Central },
            { "SystemV/YST9YDT", Alaska },
            { "Africa/Bujumbura", Africa_Central },
            { "Africa/Mogadishu", Africa_Eastern },
            { "America/Eirunepe", Acre },
            { "America/Resolute", America_Central },
            { "America/Winnipeg", America_Central },
            { "Atlantic/Madeira", Europe_Western },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Gibraltar", Europe_Central },
            { "Europe/Ljubljana", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Stockholm", Europe_Central },
            { "Africa/Libreville", Africa_Western },
            { "Africa/Lubumbashi", Africa_Central },
            { "Africa/Porto-Novo", Africa_Western },
            { "America/Boa_Vista", Amazon },
            { "America/Guatemala", America_Central },
            { "America/Matamoros", America_Central },
            { "America/Menominee", America_Central },
            { "America/Monterrey", America_Central },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Simferopol", Moscow },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Africa/Brazzaville", Africa_Western },
            { "America/Costa_Rica", America_Central },
            { "America/Metlakatla", Alaska },
            { "America/Rio_Branco", Acre },
            { "Atlantic/Jan_Mayen", Europe_Central },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Africa/Johannesburg", Africa_Southern },
            { "America/El_Salvador", America_Central },
            { "America/Mexico_City", America_Central },
            { "America/Porto_Velho", Amazon },
            { "America/Rainy_River", America_Central },
            { "America/Tegucigalpa", America_Central },
            { "Arctic/Longyearbyen", Europe_Central },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "America/Campo_Grande", Amazon },
            { "America/Indiana/Knox", America_Central },
            { "America/Rankin_Inlet", America_Central },
            { "America/Swift_Current", America_Central },
            { "America/Bahia_Banderas", America_Central },
            { "America/Indiana/Tell_City", America_Central },
            { "timezone.excity.Asia/Qatar", "Katar" },
            { "timezone.excity.Asia/Tokyo", "Tokio" },
            { "America/North_Dakota/Beulah", America_Central },
            { "America/North_Dakota/Center", America_Central },
            { "timezone.excity.Asia/Aqtobe", "Aktobe" },
            { "timezone.excity.Asia/Muscat", "Muschkat" },
            { "timezone.excity.Asia/Riyadh", "Riad" },
            { "timezone.excity.Asia/Taipei", "Taipeh" },
            { "timezone.excity.Asia/Tehran", "Teheran" },
            { "timezone.excity.Etc/Unknown", "Unbekannt" },
            { "timezone.excity.Europe/Kiev", "Kiew" },
            { "timezone.excity.Europe/Rome", "Rom" },
            { "timezone.excity.Africa/Accra", "Akkra" },
            { "timezone.excity.Africa/Cairo", "Kairo" },
            { "timezone.excity.Asia/Baghdad", "Bagdad" },
            { "timezone.excity.Asia/Bishkek", "Bischkek" },
            { "timezone.excity.Asia/Nicosia", "Nikosia" },
            { "timezone.excity.Asia/Tbilisi", "Tiflis" },
            { "timezone.excity.Asia/Yakutsk", "Jakutsk" },
            { "timezone.excity.Asia/Yerevan", "Erivan" },
            { "timezone.excity.Pacific/Fiji", "Fidschi" },
            { "timezone.excity.Asia/Damascus", "Damaskus" },
            { "timezone.excity.Asia/Dushanbe", "Duschanbe" },
            { "timezone.excity.Asia/Sakhalin", "Sachalin" },
            { "timezone.excity.Asia/Tashkent", "Taschkent" },
            { "timezone.excity.Europe/Athens", "Athen" },
            { "timezone.excity.Europe/Lisbon", "Lissabon" },
            { "timezone.excity.Europe/Moscow", "Moskau" },
            { "timezone.excity.Europe/Tirane", "Tirana" },
            { "timezone.excity.Europe/Vienna", "Wien" },
            { "timezone.excity.Europe/Warsaw", "Warschau" },
            { "timezone.excity.Europe/Zurich", "Z\u00fcri" },
            { "timezone.excity.Indian/Comoro", "Komore" },
            { "America/North_Dakota/New_Salem", America_Central },
            { "timezone.excity.Africa/Algiers", "Algier" },
            { "timezone.excity.America/Cayman", "Kaimaninsle" },
            { "timezone.excity.America/Havana", "Havanna" },
            { "timezone.excity.Asia/Hong_Kong", "Hongkong" },
            { "timezone.excity.Asia/Kamchatka", "Kamtschatka" },
            { "timezone.excity.Asia/Pyongyang", "Pj\u00f6ngjang" },
            { "timezone.excity.Asia/Singapore", "Singapur" },
            { "timezone.excity.Europe/Vilnius", "Wilna" },
            { "timezone.excity.Indian/Reunion", "R\u00e9union" },
            { "timezone.excity.Pacific/Easter", "Oschterinsle" },
            { "timezone.excity.Africa/Djibouti", "Dschibuti" },
            { "timezone.excity.Africa/El_Aaiun", "El Aai\u00fan" },
            { "timezone.excity.Africa/Khartoum", "Khartum" },
            { "timezone.excity.Africa/Sao_Tome", "S\u00e3o Tom\u00e9" },
            { "timezone.excity.America/Curacao", "Cura\u00e7ao" },
            { "timezone.excity.America/Jamaica", "Jamaika" },
            { "timezone.excity.Atlantic/Azores", "Azore" },
            { "timezone.excity.Atlantic/Canary", "Kanare" },
            { "timezone.excity.Atlantic/Faeroe", "F\u00e4r\u00f6er" },
            { "timezone.excity.Europe/Brussels", "Br\u00fcssel" },
            { "timezone.excity.Europe/Chisinau", "Kischinau" },
            { "timezone.excity.Europe/Uzhgorod", "Uschgorod" },
            { "timezone.excity.Indian/Maldives", "Maledive" },
            { "timezone.excity.Africa/Mogadishu", "Mogadischu" },
            { "timezone.excity.America/Asuncion", "Asunci\u00f3n" },
            { "timezone.excity.Asia/Krasnoyarsk", "Krasnojarsk" },
            { "timezone.excity.Asia/Novosibirsk", "Nowosibirsk" },
            { "timezone.excity.Asia/Ulaanbaatar", "Ulan-Baator" },
            { "timezone.excity.Asia/Vladivostok", "Wladiwostok" },
            { "timezone.excity.Atlantic/Bermuda", "Bermudas" },
            { "timezone.excity.Europe/Bucharest", "Bukarescht" },
            { "timezone.excity.Indian/Christmas", "Wienachts-Insle" },
            { "timezone.excity.Antarctica/Vostok", "Woschtok" },
            { "timezone.excity.Europe/Copenhagen", "Kopehage" },
            { "timezone.excity.Europe/Luxembourg", "Luxemburg" },
            { "timezone.excity.Europe/Zaporozhye", "Saporischja" },
            { "timezone.excity.Africa/Addis_Ababa", "Addis Abeba" },
            { "timezone.excity.Africa/Ouagadougou", "Wagadugu" },
            { "timezone.excity.Asia/Yekaterinburg", "Jekaterinburg" },
            { "timezone.excity.America/El_Salvador", "Salvador" },
            { "timezone.excity.America/Mexico_City", "Mexiko-Schtadt" },
            { "timezone.excity.Atlantic/Cape_Verde", "Kap Verde" },
            { "timezone.excity.Africa/Dar_es_Salaam", "Daressalam" },
            { "timezone.excity.America/Indiana/Knox", "Knox" },
            { "timezone.excity.America/Port_of_Spain", "Port-of-Spain" },
            { "timezone.excity.Atlantic/South_Georgia", "S\u00fc\u00fcd-Georgie" },
            { "timezone.excity.Antarctica/DumontDUrville", "Dumont D\u2019Urville" },
        };
        return data;
    }
}
