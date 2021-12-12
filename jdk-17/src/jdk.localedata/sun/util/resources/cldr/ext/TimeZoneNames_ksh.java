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

public class TimeZoneNames_ksh extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] GMT = new String[] {
               "Greenwich sing Standat-Zick",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Azores = new String[] {
               "de Azore ier jew\u00f6hnlijje Zick",
               "",
               "de Azore ier Summerzick",
               "",
               "de Azore ier Zick",
               "",
            };
        final String[] Reunion = new String[] {
               "Zigg vun Reunion",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Mauritius = new String[] {
               "Jew\u00f6hnlijje Zigg vun Mauritius",
               "",
               "Summerzigg vun Mauritius",
               "",
               "Zigg vun Mauritius",
               "",
            };
        final String[] Cape_Verde = new String[] {
               "Jew\u00f6hnlijje Kapv\u00e4rdejaansche Zigg",
               "",
               "Kapv\u00e4rdejaansche Sommerzigg",
               "",
               "Kapv\u00e4rdejaansche Zigg",
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
        final String[] Seychelles = new String[] {
               "Zigg vun de Seisch\u00e4lle",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Indian_Ocean = new String[] {
               "dem Indische Ozejan sing Zick",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Central = new String[] {
               "Zentraal-Affrekaanesche Zigg",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Eastern = new String[] {
               "O\u00df-Affrekaanesche Zigg",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Africa_Western = new String[] {
               "Jew\u00f6hnlijje W\u00e4\u00df-Affrekaanesche Zigg",
               "",
               "W\u00e4\u00df-Affrekaanesche Sommerzigg",
               "",
               "W\u00e4\u00df-Affrekaanesche Zigg",
               "",
            };
        final String[] Europe_Central = new String[] {
               "Meddel-Europpa sing jew\u00f6hnlijje Zick",
               "MEZ",
               "Meddel-Europpa sing Summerzick",
               "MESZ",
               "Meddel-Europpa sing Zick",
               "MEZ",
            };
        final String[] Europe_Eastern = new String[] {
               "O\u00df-Europpa sing jew\u00f6hnlijje Zick",
               "OEZ",
               "O\u00df-Europpa sing Summerzick",
               "OESZ",
               "O\u00df-Europpa sing Zick",
               "OEZ",
            };
        final String[] Europe_Western = new String[] {
               "We\u00df-Europpa sing jew\u00f6hnlijje Zick",
               "WEZ",
               "We\u00df-Europpa sing Summerzick",
               "WESZ",
               "We\u00df-Europpa sing Zick",
               "WEZ",
            };
        final String[] Africa_Southern = new String[] {
               "S\u00f6d-Affrekaanesche Zigg",
               "",
               "",
               "",
               "",
               "",
            };
        final Object[][] data = new Object[][] {
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", EMPTY_ZONE },
            { "ART", Europe_Eastern },
            { "CAT", Africa_Central },
            { "EAT", Africa_Eastern },
            { "ECT", Europe_Central },
            { "Etc/GMT", GMT },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Africa/Juba", Africa_Central },
            { "Africa/Lome", GMT },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Oslo", Europe_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Indian/Mahe", Seychelles },
            { "Africa/Accra", GMT },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Dakar", GMT },
            { "Africa/Lagos", Africa_Western },
            { "Africa/Tunis", Europe_Central },
            { "Asia/Nicosia", Europe_Eastern },
            { "Europe/Malta", Europe_Central },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "Africa/Asmera", Africa_Eastern },
            { "Africa/Bamako", GMT },
            { "Africa/Bangui", Africa_Western },
            { "Africa/Banjul", GMT },
            { "Africa/Bissau", GMT },
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
            { "Europe/Dublin",
                new String[] {
                    "Greenwich sing Standat-Zick",
                    "",
                    "Irland sing Summerzick",
                    "",
                    "",
                    "",
                }
            },
            { "Europe/Jersey", GMT },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/London",
                new String[] {
                    "Greenwich sing Standat-Zick",
                    "",
                    "Jru\u00dfbretannije sing Summerzick",
                    "",
                    "",
                    "",
                }
            },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Monaco", Europe_Central },
            { "Europe/Prague", Europe_Central },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Zurich", Europe_Central },
            { "Indian/Chagos", Indian_Ocean },
            { "Indian/Comoro", Africa_Eastern },
            { "Africa/Abidjan", GMT },
            { "Africa/Algiers", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Kampala", Africa_Eastern },
            { "Africa/Mbabane", Africa_Southern },
            { "Africa/Nairobi", Africa_Eastern },
            { "Africa/Tripoli", Europe_Eastern },
            { "Europe/Andorra", Europe_Central },
            { "Europe/Belfast",
                new String[] {
                    "Greenwich sing Standat-Zick",
                    "",
                    "Jru\u00dfbretannije sing Summerzick",
                    "",
                    "",
                    "",
                }
            },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vatican", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Indian/Mayotte", Africa_Eastern },
            { "Indian/Reunion", Reunion },
            { "Africa/Blantyre", Africa_Central },
            { "Africa/Djibouti", Africa_Eastern },
            { "Africa/Freetown", GMT },
            { "Africa/Gaborone", Africa_Central },
            { "Africa/Khartoum", Africa_Central },
            { "Africa/Kinshasa", Africa_Western },
            { "Africa/Monrovia", GMT },
            { "Africa/Ndjamena", Africa_Western },
            { "Africa/Sao_Tome", GMT },
            { "Africa/Timbuktu", GMT },
            { "Africa/Windhoek", Africa_Central },
            { "Atlantic/Azores", Azores },
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
            { "Africa/Bujumbura", Africa_Central },
            { "Africa/Mogadishu", Africa_Eastern },
            { "Antarctica/Troll", GMT },
            { "Atlantic/Madeira", Europe_Western },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Gibraltar", Europe_Central },
            { "Europe/Ljubljana", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Stockholm", Europe_Central },
            { "Indian/Mauritius", Mauritius },
            { "Africa/Libreville", Africa_Western },
            { "Africa/Lubumbashi", Africa_Central },
            { "Africa/Nouakchott", GMT },
            { "Africa/Porto-Novo", Africa_Western },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Africa/Brazzaville", Africa_Western },
            { "Africa/Ouagadougou", GMT },
            { "Atlantic/Jan_Mayen", Europe_Central },
            { "Atlantic/Reykjavik", GMT },
            { "Atlantic/St_Helena", GMT },
            { "Europe/Isle_of_Man", GMT },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Africa/Johannesburg", Africa_Southern },
            { "Arctic/Longyearbyen", Europe_Central },
            { "Atlantic/Cape_Verde", Cape_Verde },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "America/Danmarkshavn", GMT },
            { "timezone.excity.Asia/Gaza", "Jaasa" },
            { "timezone.excity.Asia/Aqtobe", "Aqt\u00f6be" },
            { "timezone.excity.Asia/Riyadh", "Rijad" },
            { "timezone.excity.Asia/Saigon", "Sigong (Ho-Tschi-Minh-Schtadt)" },
            { "timezone.excity.Asia/Urumqi", "Urrumptschi" },
            { "timezone.excity.Etc/Unknown", "- we\u00dfe mer nit -" },
            { "timezone.excity.Europe/Riga", "Riija" },
            { "timezone.excity.Europe/Rome", "Rom" },
            { "timezone.excity.Africa/Cairo", "Kaijro" },
            { "timezone.excity.Africa/Lagos", "Laajos" },
            { "timezone.excity.Asia/Baghdad", "Bagdad" },
            { "timezone.excity.Asia/Bishkek", "Bischkek" },
            { "timezone.excity.Asia/Nicosia", "Nikosija" },
            { "timezone.excity.Asia/Rangoon", "Ranjun" },
            { "timezone.excity.Asia/Tbilisi", "Tiblis" },
            { "timezone.excity.Asia/Yakutsk", "Jakutsk" },
            { "timezone.excity.Asia/Yerevan", "Eriwan" },
            { "timezone.excity.Pacific/Guam", "Juam" },
            { "timezone.excity.Asia/Ashgabat", "Asshgabat" },
            { "timezone.excity.Asia/Damascus", "Damaskus" },
            { "timezone.excity.Asia/Dushanbe", "Duschanbe" },
            { "timezone.excity.Asia/Shanghai", "Schanghai" },
            { "timezone.excity.Asia/Tashkent", "Taschkent" },
            { "timezone.excity.Europe/Athens", "Athen" },
            { "timezone.excity.Europe/Jersey", "J\u00f6\u00f6sei" },
            { "timezone.excity.Europe/Lisbon", "Lissabon" },
            { "timezone.excity.Europe/Moscow", "Moskau" },
            { "timezone.excity.Europe/Prague", "Prag" },
            { "timezone.excity.Europe/Tirane", "Tiraana" },
            { "timezone.excity.Europe/Vienna", "Wien" },
            { "timezone.excity.Europe/Warsaw", "Warschau" },
            { "timezone.excity.Europe/Zagreb", "Sagreb" },
            { "timezone.excity.Europe/Zurich", "Z\u00fcresch" },
            { "timezone.excity.Asia/Hong_Kong", "Hongkong" },
            { "timezone.excity.Asia/Kamchatka", "Kamschattka" },
            { "timezone.excity.Asia/Qyzylorda", "Qysylorda" },
            { "timezone.excity.Asia/Singapore", "Singjapuur" },
            { "timezone.excity.Europe/Vatican", "der Vatikahn" },
            { "timezone.excity.Africa/Windhoek", "Windhuk" },
            { "timezone.excity.America/Yakutat", "Jakutat" },
            { "timezone.excity.Asia/Phnom_Penh", "Pnom Penh" },
            { "timezone.excity.Atlantic/Azores", "Azoore" },
            { "timezone.excity.Atlantic/Canary", "Kannaare" },
            { "timezone.excity.Atlantic/Faeroe", "F\u00e4r\u00f6r" },
            { "timezone.excity.Europe/Belgrade", "Beljrad" },
            { "timezone.excity.Europe/Brussels", "Br\u00fcssel" },
            { "timezone.excity.Europe/Guernsey", "J\u00f6\u00f6nsei" },
            { "timezone.excity.Europe/Istanbul", "Istambul" },
            { "timezone.excity.Europe/Uzhgorod", "Uschjorod" },
            { "timezone.excity.Indian/Maldives", "Malldive" },
            { "timezone.excity.America/St_Johns", "Zint John\u2019s" },
            { "timezone.excity.America/St_Kitts", "Zint Kitts" },
            { "timezone.excity.America/St_Lucia", "Santa Lutschiija" },
            { "timezone.excity.Antarctica/Syowa", "Schoowa-Schtazjohn op d\u00e4 Ensel Onjul" },
            { "timezone.excity.Asia/Krasnoyarsk", "Krasnojarsk" },
            { "timezone.excity.Asia/Ulaanbaatar", "Ulan Bator" },
            { "timezone.excity.Asia/Vladivostok", "Wladiwostok" },
            { "timezone.excity.Europe/Bucharest", "Bukarest" },
            { "timezone.excity.Europe/Gibraltar", "Jibraltaa" },
            { "timezone.excity.Europe/Volgograd", "Woljojrad" },
            { "timezone.excity.Pacific/Honolulu", "Honululu" },
            { "timezone.excity.Pacific/Pitcairn", "Pitkern" },
            { "timezone.excity.America/Guayaquil", "Juayaquil" },
            { "timezone.excity.America/St_Thomas", "Zint Thomas" },
            { "timezone.excity.Antarctica/Vostok", "Wostok" },
            { "timezone.excity.Europe/Copenhagen", "Kopenharen" },
            { "timezone.excity.Europe/Luxembourg", "Luxembursch" },
            { "timezone.excity.Europe/Zaporozhye", "Saporischschja" },
            { "timezone.excity.Pacific/Galapagos", "Jalappajos" },
            { "timezone.excity.America/Costa_Rica", "Ko\u00dftaricka" },
            { "timezone.excity.America/St_Vincent", "Zint Vintsch\u00e4nt" },
            { "timezone.excity.Asia/Yekaterinburg", "Jekaterinburg" },
            { "timezone.excity.Atlantic/St_Helena", "Zint Helena" },
            { "timezone.excity.Europe/Isle_of_Man", "Ensel M\u00e4n" },
            { "timezone.excity.Europe/Kaliningrad", "Kalinninjraad" },
            { "timezone.excity.America/Mexico_City", "Schtadt Mexiko" },
            { "timezone.excity.Atlantic/Cape_Verde", "Kap Verde" },
            { "timezone.excity.America/Indiana/Knox", "Knox en Indiana" },
            { "timezone.excity.America/Indiana/Vevay", "Vevay en Indiana" },
            { "timezone.excity.America/St_Barthelemy", "Zint Barth\u00e9lemy" },
            { "timezone.excity.America/Indiana/Marengo", "Marengo en Indiana" },
            { "timezone.excity.America/Indiana/Winamac", "Winamac en Indiana" },
            { "timezone.excity.America/Indiana/Tell_City", "Tell City en Indiana" },
            { "timezone.excity.America/Indiana/Vincennes", "Vincennes en Indiana" },
            { "timezone.excity.Antarctica/DumontDUrville", "Dumont-d\u2019Urville-Schtazjohn" },
            { "timezone.excity.America/Indiana/Petersburg", "Petersburg en Indiana" },
            { "timezone.excity.America/Kentucky/Monticello", "Monticello en Kentucky" },
            { "timezone.excity.America/North_Dakota/Beulah", "Beulah en Nood Dakota" },
            { "timezone.excity.America/North_Dakota/Center", "Zenter en Nood Dakota" },
            { "timezone.excity.America/North_Dakota/New_Salem", "Neu Salem en Nood Dakota" },
        };
        return data;
    }
}
