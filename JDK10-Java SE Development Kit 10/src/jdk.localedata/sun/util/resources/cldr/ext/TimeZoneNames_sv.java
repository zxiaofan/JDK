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

public class TimeZoneNames_sv extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "centralafrikansk tid",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "Moskva, normaltid",
               "MSK",
               "Moskva, sommartid",
               "MSD",
               "Moskvatid",
               "MT",
            };
        final String[] Japan = new String[] {
               "japansk normaltid",
               "JST",
               "japansk sommartid",
               "JDT",
               "japansk tid",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "pakistansk normaltid",
               "PKT",
               "pakistansk sommartid",
               "PKST",
               "pakistansk tid",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "Taipei, normaltid",
               "CST",
               "Taipei, sommartid",
               "CDT",
               "Taipeitid",
               "CT",
            };
        final String[] Hovd = new String[] {
               "Chovd, normaltid",
               "HOVT",
               "Chovd, sommartid",
               "HOVST",
               "Chovdtid",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "Magadan, normaltid",
               "MAGT",
               "Magadan, sommartid",
               "MAGST",
               "Magadantid",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "v\u00e4stcentralaustralisk normaltid",
               "ACWST",
               "v\u00e4stcentralaustralisk sommartid",
               "ACWDT",
               "v\u00e4stcentralaustralisk tid",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "centraleuropeisk normaltid",
               "CET",
               "centraleuropeisk sommartid",
               "CEST",
               "centraleuropeisk tid",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "Sachalin, normaltid",
               "SAKT",
               "Sachalin, sommartid",
               "SAKST",
               "Sachalintid",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "paraguayansk normaltid",
               "PYT",
               "paraguayansk sommartid",
               "PYST",
               "paraguayansk tid",
               "PYT",
            };
        final String[] Acre = new String[] {
               "v\u00e4stbrasiliansk normaltid",
               "ACT",
               "v\u00e4stbrasiliansk sommartid",
               "ACST",
               "v\u00e4stbrasiliansk tid",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "malaysisk tid",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u00f6stnordamerikansk normaltid",
               "EST",
               "\u00f6stnordamerikansk sommartid",
               "EDT",
               "\u00f6stnordamerikansk tid",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "Lord Howe, normaltid",
               "LHST",
               "Lord Howe, sommartid",
               "LHDT",
               "Lord Howetid",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "nyzeel\u00e4ndsk normaltid",
               "NZST",
               "nyzeel\u00e4ndsk sommartid",
               "NZDT",
               "nyzeel\u00e4ndsk tid",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "Brittiska Indiska ocean\u00f6arnas tid",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "Jakutsk, normaltid",
               "YAKT",
               "Jakutsk, sommartid",
               "YAKST",
               "Jakutsktid",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "Mauritius, normaltid",
               "MUT",
               "Mauritius, sommartid",
               "MUST",
               "Mauritiustid",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u00f6stafrikansk tid",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u00f6sttimorisk tid",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "Salomon\u00f6arnas tid",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "Kosraetid",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "Marshall\u00f6arnas tid",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u00f6steuropeisk normaltid",
               "EET",
               "\u00f6steuropeisk sommartid",
               "EEST",
               "\u00f6steuropeisk tid",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "Newfoundland, normaltid",
               "NST",
               "Newfoundland, sommartid",
               "NDT",
               "Newfoundlandtid",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "afghansk tid",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "Hongkong, normaltid",
               "HKT",
               "Hongkong, sommartid",
               "HKST",
               "Hongkongtid",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "v\u00e4stargentinsk normaltid",
               "ART",
               "v\u00e4stargentinsk sommartid",
               "ARST",
               "v\u00e4stargentinsk tid",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "nordamerikansk atlantnormaltid",
               "AST",
               "nordamerikansk atlantsommartid",
               "ADT",
               "nordamerikansk atlanttid",
               "AT",
            };
        final String[] Ponape = new String[] {
               "Ponapetid",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "boliviansk tid",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "S:t Pierre och Miquelon, normaltid",
               "PMST",
               "S:t Pierre och Miquelon, sommartid",
               "PMDT",
               "S:t Pierre och Miquelontid",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "indokinesisk tid",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "Jekaterinburg, normaltid",
               "YEKT",
               "Jekaterinburg, sommartid",
               "YEKST",
               "Jekaterinburgtid",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "Maldivernatid",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "Tahititid",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "israelisk normaltid",
               "IST",
               "israelisk sommartid",
               "IDT",
               "israelisk tid",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "centralindonesisk tid",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "Wallis- och Futuna\u00f6arnas tid",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "sydafrikansk tid",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "Syowatid",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "Line\u00f6arnas tid",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "uzbekisk normaltid",
               "UZT",
               "uzbekisk sommartid",
               "UZST",
               "uzbekisk tid",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "Omsk, normaltid",
               "OMST",
               "Omsk, sommartid",
               "OMSST",
               "Omsktid",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "Seychellernatid",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "uruguayansk normaltid",
               "UYT",
               "uruguayansk sommartid",
               "UYST",
               "uruguayansk tid",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "nepalesisk tid",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "Ulaanbaatar, normaltid",
               "ULAT",
               "Ulaanbaatar, sommartid",
               "ULAST",
               "Ulaanbaatartid",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "centralnordamerikansk normaltid",
               "CST",
               "centralnordamerikansk sommartid",
               "CDT",
               "centralnordamerikansk tid",
               "CT",
            };
        final String[] Truk = new String[] {
               "Chuuktid",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "Niuetid",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "Wake\u00f6arnas tid",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "Falklands\u00f6arna, normaltid",
               "FKT",
               "Falklands\u00f6arna, sommartid",
               "FKST",
               "Falklands\u00f6arnas tid",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "Vanuatu, normaltid",
               "VUT",
               "Vanuatu, sommartid",
               "VUST",
               "Vanuatutid",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "Novosibirsk, normaltid",
               "NOVT",
               "Novosibirsk, sommartid",
               "NOVST",
               "Novosibirsktid",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "Singaporetid",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "azorisk normaltid",
               "AZOT",
               "azorisk sommartid",
               "AZOST",
               "azorisk tid",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "Apia, normaltid",
               "WSST",
               "Apia, sommartid",
               "WSDT",
               "Apiatid",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "bhutansk tid",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "Surinamtid",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "Naurutid",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "Krasnojarsk, normaltid",
               "KRAT",
               "Krasnojarsk, sommartid",
               "KRAST",
               "Krasnojarsktid",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "v\u00e4stkazakstansk tid",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "burmesisk tid",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "Jul\u00f6ns tid",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "Amazonas, normaltid",
               "AMT",
               "Amazonas, sommartid",
               "AMST",
               "Amazonastid",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u00f6stkazakstansk tid",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "Fiji, normaltid",
               "FJT",
               "Fiji, sommartid",
               "FJST",
               "Fijitid",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "R\u00e9uniontid",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "Keeling\u00f6arnas tid",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "Chatham, normaltid",
               "CHAST",
               "Chatham, sommartid",
               "CHADT",
               "Chathamtid",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "Vostoktid",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u00f6stargentinsk normaltid",
               "ART",
               "\u00f6stargentinsk sommartid",
               "ARST",
               "\u00f6stargentinsk tid",
               "ART",
            };
        final String[] Gambier = new String[] {
               "Gambiertid",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "Kamtjatkanormaltid",
               "PETT",
               "Kamtjatkasommartid",
               "PETST",
               "Kamtjatkatid",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "Tuvalutid",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "Gal\u00e1pagostid",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "Macquarietid",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "venezuelansk tid",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "Honolulu, normaltid",
               "HAST",
               "Honolulu, sommartid",
               "HADT",
               "Honolulutid",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "centralaustralisk normaltid",
               "ACST",
               "centralaustralisk sommartid",
               "ACDT",
               "centralaustralisk tid",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "v\u00e4stnordamerikansk normaltid",
               "PST",
               "v\u00e4stnordamerikansk sommartid",
               "PDT",
               "v\u00e4stnordamerikansk tid",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "Enderburytid",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "turkmensk normaltid",
               "TMT",
               "turkmensk sommartid",
               "TMST",
               "turkmensk tid",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "v\u00e4steuropeisk normaltid",
               "WET",
               "v\u00e4steuropeisk sommartid",
               "WEST",
               "v\u00e4steuropeisk tid",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "Kap Verde, normaltid",
               "CVT",
               "Kap Verde, sommartid",
               "CVST",
               "Kap Verdetid",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "Norfolk\u00f6ns tid",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "Guyanatid",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "Pitcairntid",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "Rotheratid",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "samoansk normaltid",
               "SST",
               "samoansk sommartid",
               "SDT",
               "samoansk tid",
               "ST",
            };
        final String[] Palau = new String[] {
               "Palautid",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "Kaliningradtid",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "azerbajdzjansk normaltid",
               "AZT",
               "azerbajdzjansk sommartid",
               "AZST",
               "azerbajdzjansk tid",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "Mawsontid",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "mexikansk stillahavstid, normaltid",
               "MST",
               "mexikansk stillahavstid, sommartid",
               "MDT",
               "mexikansk stillahavstid",
               "MT",
            };
        final String[] Davis = new String[] {
               "Davistid",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "kubansk normaltid",
               "CST",
               "kubansk sommartid",
               "CDT",
               "kubansk tid",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "v\u00e4stafrikansk normaltid",
               "CAT",
               "v\u00e4stafrikansk sommartid",
               "CAST",
               "v\u00e4stafrikansk tid",
               "CAT",
            };
        final String[] GMT = new String[] {
               "Greenwichtid",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "filippinsk normaltid",
               "PHT",
               "filippinsk sommartid",
               "PHST",
               "filippinsk tid",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "Franska Sydterritoriernas tid",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "sydgeorgisk tid",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "Nya Kaledonien, normaltid",
               "NCT",
               "Nya Kaledonien, sommartid",
               "NCST",
               "Nya Kaledonientid",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "Bruneitid",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "iransk normaltid",
               "IRST",
               "iransk sommartid",
               "IRDT",
               "iransk tid",
               "IRT",
            };
        final String[] Easter = new String[] {
               "P\u00e5sk\u00f6n, normaltid",
               "EAST",
               "P\u00e5sk\u00f6n, sommartid",
               "EASST",
               "P\u00e5sk\u00f6tid",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "nordv\u00e4stmexikansk normaltid",
               "PST",
               "nordv\u00e4stmexikansk sommartid",
               "PDT",
               "nordv\u00e4stmexikansk tid",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "Dumont d\u2019Urville-tid",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "Tadzjikistantid",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "Tonga, normaltid",
               "TOT",
               "Tonga, sommartid",
               "TOST",
               "Tongatid",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "bangladeshisk normaltid",
               "BDT",
               "bangladeshisk sommartid",
               "BDST",
               "bangladeshisk tid",
               "BDT",
            };
        final String[] Peru = new String[] {
               "peruansk normaltid",
               "PET",
               "peruansk sommartid",
               "PEST",
               "peruansk tid",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "v\u00e4stgr\u00f6nl\u00e4ndsk normaltid",
               "WGT",
               "v\u00e4stgr\u00f6nl\u00e4ndsk sommartid",
               "WGST",
               "v\u00e4stgr\u00f6nl\u00e4ndsk tid",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "ecuadoriansk tid",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u00f6stgr\u00f6nl\u00e4ndsk normaltid",
               "EGT",
               "\u00f6stgr\u00f6nl\u00e4ndsk sommartid",
               "EGST",
               "\u00f6stgr\u00f6nl\u00e4ndsk tid",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "Persiska vikentid",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u00f6stindonesisk tid",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "koreansk normaltid",
               "KST",
               "koreansk sommartid",
               "KDT",
               "koreansk tid",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "v\u00e4staustralisk normaltid",
               "AWST",
               "v\u00e4staustralisk sommartid",
               "AWDT",
               "v\u00e4staustralisk tid",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "kirgizisk tid",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "v\u00e4stindonesisk tid",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u00f6staustralisk normaltid",
               "AEST",
               "\u00f6staustralisk sommartid",
               "AEDT",
               "\u00f6staustralisk tid",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "Franska Guyanatid",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "colombiansk normaltid",
               "COT",
               "colombiansk sommartid",
               "COST",
               "colombiansk tid",
               "COT",
            };
        final String[] Chile = new String[] {
               "chilensk normaltid",
               "CLT",
               "chilensk sommartid",
               "CLST",
               "chilensk tid",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "Kiribatitid",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "Klippiga bergen, normaltid",
               "MST",
               "Klippiga bergen, sommartid",
               "MDT",
               "Klippiga bergentid",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "Marquesastid",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "saudiarabisk normaltid",
               "AST",
               "saudiarabisk sommartid",
               "ADT",
               "saudiarabisk tid",
               "AT",
            };
        final String[] Alaska = new String[] {
               "Alaska, normaltid",
               "AKST",
               "Alaska, sommartid",
               "AKDT",
               "Alaskatid",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "Vladivostok, normaltid",
               "VLAT",
               "Vladivostok, sommartid",
               "VLAST",
               "Vladivostoktid",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "Chamorrotid",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "Irkutsk, normaltid",
               "IRKT",
               "Irkutsk, sommartid",
               "IRKST",
               "Irkutsktid",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "georgisk normaltid",
               "GET",
               "georgisk sommartid",
               "GEST",
               "georgisk tid",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "Tokelautid",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "Papua Nya Guineas tid",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "Fernando de Noronha, normaltid",
               "FNT",
               "Fernando de Noronha, sommartid",
               "FNST",
               "Fernando de Noronhatid",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "Tjojbalsan, normaltid",
               "CHOT",
               "Tjojbalsan, sommartid",
               "CHOST",
               "Tjojbalsantid",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "Brasilia, normaltid",
               "BRT",
               "Brasilia, sommartid",
               "BRST",
               "Brasiliatid",
               "BRT",
            };
        final String[] China = new String[] {
               "kinesisk normaltid",
               "CST",
               "kinesisk sommartid",
               "CDT",
               "kinesisk tid",
               "CT",
            };
        final String[] Armenia = new String[] {
               "armenisk normaltid",
               "AMT",
               "armenisk sommartid",
               "AMST",
               "armenisk tid",
               "AMT",
            };
        final String[] Samara = new String[] {
               "Samaranormaltid",
               "SAMT",
               "Samarasommartid",
               "SAMST",
               "Samaratid",
               "SAMT",
            };
        final String[] India = new String[] {
               "indisk tid",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "Cook\u00f6arnas normaltid",
               "CKT",
               "Cook\u00f6arnas sommartid",
               "CKHST",
               "Cook\u00f6arnas tid",
               "CKT",
            };
        final Object[][] data = new Object[][] {
            { "America/Los_Angeles", America_Pacific },
            { "America/Denver", America_Mountain },
            { "America/Phoenix", America_Mountain },
            { "America/Chicago", America_Central },
            { "America/New_York", America_Eastern },
            { "America/Indianapolis", America_Eastern },
            { "Pacific/Honolulu", Hawaii_Aleutian },
            { "America/Anchorage", Alaska },
            { "America/Halifax", Atlantic },
            { "America/Sitka", Alaska },
            { "America/St_Johns", Newfoundland },
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Africa/Casablanca", Europe_Western },
            { "Asia/Jerusalem", Israel },
            { "Asia/Tokyo", Japan },
            { "Europe/Bucharest", Europe_Eastern },
            { "Asia/Shanghai", China },
            { "Asia/Aden", Arabian },
            { "America/Cuiaba", Amazon },
            { "Africa/Nairobi", Africa_Eastern },
            { "America/Marigot", Atlantic },
            { "Asia/Aqtau", Kazakhstan_Western },
            { "Pacific/Kwajalein", Marshall_Islands },
            { "America/El_Salvador", America_Central },
            { "Asia/Pontianak", Indonesia_Western },
            { "Africa/Cairo", Europe_Eastern },
            { "Pacific/Pago_Pago", Samoa },
            { "Africa/Mbabane", Africa_Southern },
            { "Asia/Kuching", Malaysia },
            { "Pacific/Rarotonga", Cook },
            { "America/Guatemala", America_Central },
            { "Australia/Hobart", Australia_Eastern },
            { "Europe/London",
                new String[] {
                    "Greenwichtid",
                    "GMT",
                    "brittisk sommartid",
                    "GMT",
                    "Greenwich Mean Time",
                    "GMT",
                }
            },
            { "America/Belize", America_Central },
            { "America/Panama", America_Eastern },
            { "America/Managua", America_Central },
            { "America/Indiana/Petersburg", America_Eastern },
            { "Asia/Yerevan", Armenia },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Jersey", GMT },
            { "America/Tegucigalpa", America_Central },
            { "Europe/Istanbul", Europe_Eastern },
            { "America/Eirunepe", Acre },
            { "America/Miquelon", Pierre_Miquelon },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Atlantic/St_Helena", GMT },
            { "Europe/Guernsey", GMT },
            { "America/Grand_Turk", Atlantic },
            { "Asia/Samarkand", Uzbekistan },
            { "Asia/Phnom_Penh", Indochina },
            { "Africa/Kigali", Africa_Central },
            { "Asia/Almaty", Kazakhstan_Eastern },
            { "Asia/Dubai", Gulf },
            { "Europe/Isle_of_Man", GMT },
            { "America/Araguaina", Brasilia },
            { "Asia/Novosibirsk", Novosibirsk },
            { "America/Argentina/Salta", Argentina },
            { "Africa/Tunis", Europe_Central },
            { "Pacific/Fakaofo", Tokelau },
            { "Africa/Tripoli", Europe_Eastern },
            { "Africa/Banjul", GMT },
            { "Indian/Comoro", Africa_Eastern },
            { "Pacific/Port_Moresby", Papua_New_Guinea },
            { "Antarctica/Syowa", Syowa },
            { "Indian/Reunion", Reunion },
            { "Pacific/Palau", Palau },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "America/Montevideo", Uruguay },
            { "Africa/Windhoek", Africa_Western },
            { "Asia/Karachi", Pakistan },
            { "Africa/Mogadishu", Africa_Eastern },
            { "Australia/Perth", Australia_Western },
            { "Asia/Chita", Yakutsk },
            { "Pacific/Easter", Easter },
            { "Antarctica/Davis", Davis },
            { "Antarctica/McMurdo", New_Zealand },
            { "America/Manaus", Amazon },
            { "Africa/Freetown", GMT },
            { "Asia/Macau", China },
            { "Europe/Malta", Europe_Central },
            { "Pacific/Tahiti", Tahiti },
            { "Africa/Asmera", Africa_Eastern },
            { "Europe/Busingen", Europe_Central },
            { "America/Argentina/Rio_Gallegos", Argentina },
            { "Africa/Malabo", Africa_Western },
            { "Europe/Skopje", Europe_Central },
            { "America/Catamarca", Argentina },
            { "America/Godthab", Greenland_Western },
            { "Europe/Sarajevo", Europe_Central },
            { "Africa/Lagos", Africa_Western },
            { "America/Cordoba", Argentina },
            { "Europe/Rome", Europe_Central },
            { "Indian/Mauritius", Mauritius },
            { "America/Regina", America_Central },
            { "America/Dawson_Creek", America_Mountain },
            { "Africa/Algiers", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "America/St_Thomas", Atlantic },
            { "Europe/Zurich", Europe_Central },
            { "America/Anguilla", Atlantic },
            { "Asia/Dili", East_Timor },
            { "Africa/Bamako", GMT },
            { "Pacific/Wallis", Wallis },
            { "Europe/Gibraltar", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Lubumbashi", Africa_Central },
            { "America/Havana", Cuba },
            { "Asia/Choibalsan", Choibalsan },
            { "Asia/Omsk", Omsk },
            { "Europe/Vaduz", Europe_Central },
            { "Asia/Dhaka", Bangladesh },
            { "America/Barbados", Atlantic },
            { "Atlantic/Cape_Verde", Cape_Verde },
            { "Asia/Yekaterinburg", Yekaterinburg },
            { "America/Louisville", America_Eastern },
            { "Pacific/Johnston", Hawaii_Aleutian },
            { "Pacific/Chatham", Chatham },
            { "Europe/Ljubljana", Europe_Central },
            { "America/Sao_Paulo", Brasilia },
            { "Asia/Jayapura", Indonesia_Eastern },
            { "America/Curacao", Atlantic },
            { "Asia/Dushanbe", Tajikistan },
            { "America/Guyana", Guyana },
            { "America/Guayaquil", Ecuador },
            { "America/Martinique", Atlantic },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Moscow", Moscow },
            { "Europe/Chisinau", Europe_Eastern },
            { "America/Puerto_Rico", Atlantic },
            { "America/Rankin_Inlet", America_Central },
            { "Pacific/Ponape", Ponape },
            { "Europe/Stockholm", Europe_Central },
            { "Europe/Budapest", Europe_Central },
            { "Australia/Eucla", Australia_CentralWestern },
            { "Europe/Zagreb", Europe_Central },
            { "America/Port_of_Spain", Atlantic },
            { "Europe/Helsinki", Europe_Eastern },
            { "Asia/Beirut", Europe_Eastern },
            { "Pacific/Bougainville", New_Zealand },
            { "Africa/Sao_Tome", GMT },
            { "Indian/Chagos", Indian_Ocean },
            { "America/Cayenne", French_Guiana },
            { "Asia/Yakutsk", Yakutsk },
            { "Pacific/Galapagos", Galapagos },
            { "Africa/Ndjamena", Africa_Western },
            { "Pacific/Fiji", Fiji },
            { "America/Rainy_River", America_Central },
            { "Indian/Maldives", Maldives },
            { "Asia/Oral", Kazakhstan_Western },
            { "America/Yellowknife", America_Mountain },
            { "Pacific/Enderbury", Phoenix_Islands },
            { "America/Juneau", Alaska },
            { "America/Indiana/Vevay", America_Eastern },
            { "Asia/Tashkent", Uzbekistan },
            { "Asia/Jakarta", Indonesia_Western },
            { "Africa/Ceuta", Europe_Central },
            { "America/Recife", Brasilia },
            { "America/Buenos_Aires", Argentina },
            { "America/Noronha", Noronha },
            { "America/Swift_Current", America_Central },
            { "Australia/Adelaide", Australia_Central },
            { "America/Metlakatla", Alaska },
            { "Africa/Djibouti", Africa_Eastern },
            { "America/Paramaribo", Suriname },
            { "Europe/Simferopol", Moscow },
            { "Europe/Sofia", Europe_Eastern },
            { "Africa/Nouakchott", GMT },
            { "Europe/Prague", Europe_Central },
            { "America/Indiana/Vincennes", America_Eastern },
            { "Antarctica/Mawson", Mawson },
            { "America/Kralendijk", Atlantic },
            { "Antarctica/Troll", GMT },
            { "Europe/Samara", Samara },
            { "Indian/Christmas", Christmas },
            { "America/Antigua", Atlantic },
            { "Pacific/Gambier", Gambier },
            { "America/Inuvik", America_Mountain },
            { "America/Iqaluit", America_Eastern },
            { "Pacific/Funafuti", Tuvalu },
            { "Antarctica/Macquarie", Macquarie },
            { "America/Moncton", Atlantic },
            { "Africa/Gaborone", Africa_Central },
            { "America/St_Vincent", Atlantic },
            { "Asia/Gaza", Europe_Eastern },
            { "PST8PDT", America_Pacific },
            { "Atlantic/Faeroe", Europe_Western },
            { "Asia/Qyzylorda", Kazakhstan_Eastern },
            { "America/Yakutat", Alaska },
            { "Antarctica/Casey", Australia_Western },
            { "Europe/Copenhagen", Europe_Central },
            { "Atlantic/Azores", Azores },
            { "Europe/Vienna", Europe_Central },
            { "Pacific/Pitcairn", Pitcairn },
            { "America/Mazatlan", Mexico_Pacific },
            { "Pacific/Nauru", Nauru },
            { "Europe/Tirane", Europe_Central },
            { "Australia/Broken_Hill", Australia_Central },
            { "Europe/Riga", Europe_Eastern },
            { "America/Dominica", Atlantic },
            { "Africa/Abidjan", GMT },
            { "America/Mendoza", Argentina },
            { "America/Santarem", Brasilia },
            { "America/Asuncion", Paraguay },
            { "America/Boise", America_Mountain },
            { "Australia/Currie", Australia_Eastern },
            { "EST5EDT", America_Eastern },
            { "Pacific/Guam", Chamorro },
            { "Pacific/Wake", Wake },
            { "Atlantic/Bermuda", Atlantic },
            { "America/Costa_Rica", America_Central },
            { "America/Dawson", America_Pacific },
            { "Europe/Amsterdam", Europe_Central },
            { "America/Indiana/Knox", America_Central },
            { "America/North_Dakota/Beulah", America_Central },
            { "Africa/Accra", GMT },
            { "America/Maceio", Brasilia },
            { "Pacific/Apia", Apia },
            { "Pacific/Niue", Niue },
            { "Australia/Lord_Howe", Lord_Howe },
            { "Europe/Dublin",
                new String[] {
                    "Greenwichtid",
                    "GMT",
                    "irl\u00e4ndsk sommartid",
                    "GMT",
                    "Greenwich Mean Time",
                    "GMT",
                }
            },
            { "Pacific/Truk", Truk },
            { "MST7MDT", America_Mountain },
            { "America/Monterrey", America_Central },
            { "America/Nassau", America_Eastern },
            { "America/Jamaica", America_Eastern },
            { "Asia/Bishkek", Kyrgystan },
            { "Atlantic/Stanley", Falkland },
            { "Indian/Mahe", Seychelles },
            { "Asia/Aqtobe", Kazakhstan_Western },
            { "Asia/Vladivostok", Vladivostok },
            { "Africa/Libreville", Africa_Western },
            { "Africa/Maputo", Africa_Central },
            { "America/Kentucky/Monticello", America_Eastern },
            { "Africa/El_Aaiun", Europe_Western },
            { "Africa/Ouagadougou", GMT },
            { "America/Coral_Harbour", America_Eastern },
            { "Pacific/Marquesas", Marquesas },
            { "America/Aruba", Atlantic },
            { "America/North_Dakota/Center", America_Central },
            { "America/Cayman", America_Eastern },
            { "Asia/Ulaanbaatar", Mongolia },
            { "Asia/Baghdad", Arabian },
            { "Europe/San_Marino", Europe_Central },
            { "America/Indiana/Tell_City", America_Central },
            { "America/Tijuana", America_Pacific },
            { "Pacific/Saipan", Chamorro },
            { "Africa/Douala", Africa_Western },
            { "America/Chihuahua", Mexico_Pacific },
            { "America/Ojinaga", America_Mountain },
            { "Asia/Hovd", Hovd },
            { "Antarctica/Rothera", Rothera },
            { "Asia/Damascus", Europe_Eastern },
            { "America/Argentina/San_Luis", Argentina_Western },
            { "America/Santiago", Chile },
            { "Asia/Baku", Azerbaijan },
            { "America/Argentina/Ushuaia", Argentina },
            { "Atlantic/Reykjavik", GMT },
            { "Africa/Brazzaville", Africa_Western },
            { "Africa/Porto-Novo", Africa_Western },
            { "America/La_Paz", Bolivia },
            { "Antarctica/DumontDUrville", DumontDUrville },
            { "Asia/Taipei", Taipei },
            { "Asia/Manila", Philippines },
            { "Asia/Bangkok", Indochina },
            { "Africa/Dar_es_Salaam", Africa_Eastern },
            { "Atlantic/Madeira", Europe_Western },
            { "Antarctica/Palmer", Chile },
            { "America/Thunder_Bay", America_Eastern },
            { "Africa/Addis_Ababa", Africa_Eastern },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "America/Indiana/Marengo", America_Eastern },
            { "America/Creston", America_Mountain },
            { "America/Mexico_City", America_Central },
            { "Antarctica/Vostok", Vostok },
            { "Europe/Andorra", Europe_Central },
            { "Asia/Vientiane", Indochina },
            { "Pacific/Kiritimati", Line_Islands },
            { "America/Matamoros", America_Central },
            { "America/Blanc-Sablon", Atlantic },
            { "Asia/Riyadh", Arabian },
            { "Atlantic/South_Georgia", South_Georgia },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/Oslo", Europe_Central },
            { "Asia/Novokuznetsk", Krasnoyarsk },
            { "CST6CDT", America_Central },
            { "Atlantic/Canary", Europe_Western },
            { "Asia/Kuwait", Arabian },
            { "Pacific/Efate", Vanuatu },
            { "Africa/Lome", GMT },
            { "America/Bogota", Colombia },
            { "America/Menominee", America_Central },
            { "America/Adak", Hawaii_Aleutian },
            { "Pacific/Norfolk", Norfolk },
            { "America/Resolute", America_Central },
            { "Pacific/Tarawa", Gilbert_Islands },
            { "Africa/Kampala", Africa_Eastern },
            { "Asia/Krasnoyarsk", Krasnoyarsk },
            { "America/Edmonton", America_Mountain },
            { "Europe/Podgorica", Europe_Central },
            { "Africa/Bujumbura", Africa_Central },
            { "America/Santo_Domingo", Atlantic },
            { "Europe/Minsk", Europe_Further_Eastern },
            { "Pacific/Auckland", New_Zealand },
            { "America/Glace_Bay", Atlantic },
            { "Asia/Qatar", Arabian },
            { "Europe/Kiev", Europe_Eastern },
            { "Asia/Magadan", Magadan },
            { "America/Port-au-Prince", America_Eastern },
            { "America/St_Barthelemy", Atlantic },
            { "Asia/Ashgabat", Turkmenistan },
            { "Africa/Luanda", Africa_Western },
            { "America/Nipigon", America_Eastern },
            { "Asia/Muscat", Gulf },
            { "Asia/Bahrain", Arabian },
            { "Europe/Vilnius", Europe_Eastern },
            { "America/Fortaleza", Brasilia },
            { "America/Hermosillo", Mexico_Pacific },
            { "America/Cancun", America_Eastern },
            { "Africa/Maseru", Africa_Southern },
            { "Pacific/Kosrae", Kosrae },
            { "Africa/Kinshasa", Africa_Western },
            { "Asia/Seoul", Korea },
            { "Australia/Sydney", Australia_Eastern },
            { "America/Lima", Peru },
            { "America/St_Lucia", Atlantic },
            { "Europe/Madrid", Europe_Central },
            { "America/Bahia_Banderas", America_Central },
            { "America/Montserrat", Atlantic },
            { "Asia/Brunei", Brunei },
            { "America/Santa_Isabel", Mexico_Northwest },
            { "America/Cambridge_Bay", America_Mountain },
            { "Asia/Colombo", India },
            { "Indian/Antananarivo", Africa_Eastern },
            { "Australia/Brisbane", Australia_Eastern },
            { "Indian/Mayotte", Africa_Eastern },
            { "Europe/Volgograd", Moscow },
            { "America/Lower_Princes", Atlantic },
            { "America/Vancouver", America_Pacific },
            { "Africa/Blantyre", Africa_Central },
            { "America/Rio_Branco", Acre },
            { "America/Danmarkshavn", GMT },
            { "America/Detroit", America_Eastern },
            { "America/Thule", Atlantic },
            { "Africa/Lusaka", Africa_Central },
            { "Asia/Hong_Kong", Hong_Kong },
            { "America/Argentina/La_Rioja", Argentina },
            { "Africa/Dakar", GMT },
            { "America/Tortola", Atlantic },
            { "America/Porto_Velho", Amazon },
            { "Asia/Sakhalin", Sakhalin },
            { "America/Scoresbysund", Greenland_Eastern },
            { "Asia/Kamchatka", Kamchatka },
            { "Africa/Harare", Africa_Central },
            { "America/Nome", Alaska },
            { "Europe/Tallinn", Europe_Eastern },
            { "Africa/Khartoum", Africa_Eastern },
            { "Africa/Johannesburg", Africa_Southern },
            { "Africa/Bangui", Africa_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Africa/Bissau", GMT },
            { "Asia/Tehran", Iran },
            { "Africa/Juba", Africa_Eastern },
            { "America/Campo_Grande", Amazon },
            { "America/Belem", Brasilia },
            { "Asia/Saigon", Indochina },
            { "Pacific/Midway", Samoa },
            { "America/Jujuy", Argentina },
            { "America/Bahia", Brasilia },
            { "America/Goose_Bay", Atlantic },
            { "America/Pangnirtung", America_Eastern },
            { "Asia/Katmandu", Nepal },
            { "Africa/Niamey", Africa_Western },
            { "America/Whitehorse", America_Pacific },
            { "Pacific/Noumea", New_Caledonia },
            { "Asia/Tbilisi", Georgia },
            { "Asia/Makassar", Indonesia_Central },
            { "America/Argentina/San_Juan", Argentina },
            { "Asia/Nicosia", Europe_Eastern },
            { "America/Indiana/Winamac", America_Eastern },
            { "America/Boa_Vista", Amazon },
            { "America/Grenada", Atlantic },
            { "Australia/Darwin", Australia_Central },
            { "Asia/Khandyga", Yakutsk },
            { "Asia/Kuala_Lumpur", Malaysia },
            { "Asia/Thimphu", Bhutan },
            { "Asia/Rangoon", Myanmar },
            { "Europe/Bratislava", Europe_Central },
            { "Asia/Calcutta", India },
            { "America/Argentina/Tucuman", Argentina },
            { "Asia/Kabul", Afghanistan },
            { "Indian/Cocos", Cocos },
            { "Pacific/Tongatapu", Tonga },
            { "America/Merida", America_Central },
            { "America/St_Kitts", Atlantic },
            { "Arctic/Longyearbyen", Europe_Central },
            { "America/Fort_Nelson", America_Mountain },
            { "America/Caracas", Venezuela },
            { "America/Guadeloupe", Atlantic },
            { "Asia/Hebron", Europe_Eastern },
            { "Indian/Kerguelen", French_Southern },
            { "Africa/Monrovia", GMT },
            { "Asia/Ust-Nera", Vladivostok },
            { "Asia/Srednekolymsk", Singapore },
            { "America/North_Dakota/New_Salem", America_Central },
            { "Asia/Anadyr", Magadan },
            { "Australia/Melbourne", Australia_Eastern },
            { "Asia/Irkutsk", Irkutsk },
            { "America/Winnipeg", America_Central },
            { "Europe/Vatican", Europe_Central },
            { "Asia/Amman", Europe_Eastern },
            { "America/Toronto", America_Eastern },
            { "Asia/Singapore", Singapore },
            { "Australia/Lindeman", Australia_Eastern },
            { "Pacific/Majuro", Marshall_Islands },
            { "Pacific/Guadalcanal", Solomon },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Monaco", Europe_Central },
        };
        return data;
    }
}
