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

public class TimeZoneNames_ja extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u4e2d\u592e\u30a2\u30d5\u30ea\u30ab\u6642\u9593",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u30e2\u30b9\u30af\u30ef\u6a19\u6e96\u6642",
               "MSK",
               "\u30e2\u30b9\u30af\u30ef\u590f\u6642\u9593",
               "MSD",
               "\u30e2\u30b9\u30af\u30ef\u6642\u9593",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u65e5\u672c\u6a19\u6e96\u6642",
               "JST",
               "\u65e5\u672c\u590f\u6642\u9593",
               "JDT",
               "\u65e5\u672c\u6642\u9593",
               "\u2205\u2205\u2205",
            };
        final String[] Pakistan = new String[] {
               "\u30d1\u30ad\u30b9\u30bf\u30f3\u6a19\u6e96\u6642",
               "PKT",
               "\u30d1\u30ad\u30b9\u30bf\u30f3\u590f\u6642\u9593",
               "PKST",
               "\u30d1\u30ad\u30b9\u30bf\u30f3\u6642\u9593",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u53f0\u5317\u6a19\u6e96\u6642",
               "CST",
               "\u53f0\u5317\u590f\u6642\u9593",
               "CDT",
               "\u53f0\u5317\u6642\u9593",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u30db\u30d6\u30c9\u6a19\u6e96\u6642",
               "HOVT",
               "\u30db\u30d6\u30c9\u590f\u6642\u9593",
               "HOVST",
               "\u30db\u30d6\u30c9\u6642\u9593",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u30de\u30ac\u30c0\u30f3\u6a19\u6e96\u6642",
               "MAGT",
               "\u30de\u30ac\u30c0\u30f3\u590f\u6642\u9593",
               "MAGST",
               "\u30de\u30ac\u30c0\u30f3\u6642\u9593",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u897f\u90e8\u6a19\u6e96\u6642",
               "ACWST",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u897f\u90e8\u590f\u6642\u9593",
               "ACWDT",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u897f\u90e8\u6642\u9593",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u4e2d\u592e\u30e8\u30fc\u30ed\u30c3\u30d1\u6a19\u6e96\u6642",
               "CET",
               "\u4e2d\u592e\u30e8\u30fc\u30ed\u30c3\u30d1\u590f\u6642\u9593",
               "CEST",
               "\u4e2d\u592e\u30e8\u30fc\u30ed\u30c3\u30d1\u6642\u9593",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u30b5\u30cf\u30ea\u30f3\u6a19\u6e96\u6642",
               "SAKT",
               "\u30b5\u30cf\u30ea\u30f3\u590f\u6642\u9593",
               "SAKST",
               "\u30b5\u30cf\u30ea\u30f3\u6642\u9593",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u30d1\u30e9\u30b0\u30a2\u30a4\u6a19\u6e96\u6642",
               "PYT",
               "\u30d1\u30e9\u30b0\u30a2\u30a4\u590f\u6642\u9593",
               "PYST",
               "\u30d1\u30e9\u30b0\u30a2\u30a4\u6642\u9593",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u30a2\u30af\u30ec\u6a19\u6e96\u6642",
               "ACT",
               "\u30a2\u30af\u30ec\u590f\u6642\u9593",
               "ACST",
               "\u30a2\u30af\u30ec\u6642\u9593",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u30de\u30ec\u30fc\u30b7\u30a2\u6642\u9593",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u30a2\u30e1\u30ea\u30ab\u6771\u90e8\u6a19\u6e96\u6642",
               "EST",
               "\u30a2\u30e1\u30ea\u30ab\u6771\u90e8\u590f\u6642\u9593",
               "EDT",
               "\u30a2\u30e1\u30ea\u30ab\u6771\u90e8\u6642\u9593",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u30ed\u30fc\u30c9\u30cf\u30a6\u6a19\u6e96\u6642",
               "LHST",
               "\u30ed\u30fc\u30c9\u30cf\u30a6\u590f\u6642\u9593",
               "LHDT",
               "\u30ed\u30fc\u30c9\u30cf\u30a6\u6642\u9593",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u30cb\u30e5\u30fc\u30b8\u30fc\u30e9\u30f3\u30c9\u6a19\u6e96\u6642",
               "NZST",
               "\u30cb\u30e5\u30fc\u30b8\u30fc\u30e9\u30f3\u30c9\u590f\u6642\u9593",
               "NZDT",
               "\u30cb\u30e5\u30fc\u30b8\u30fc\u30e9\u30f3\u30c9\u6642\u9593",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u30a4\u30f3\u30c9\u6d0b\u6642\u9593",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u30e4\u30af\u30fc\u30c4\u30af\u6a19\u6e96\u6642",
               "YAKT",
               "\u30e4\u30af\u30fc\u30c4\u30af\u590f\u6642\u9593",
               "YAKST",
               "\u30e4\u30af\u30fc\u30c4\u30af\u6642\u9593",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u30e2\u30fc\u30ea\u30b7\u30e3\u30b9\u6a19\u6e96\u6642",
               "MUT",
               "\u30e2\u30fc\u30ea\u30b7\u30e3\u30b9\u590f\u6642\u9593",
               "MUST",
               "\u30e2\u30fc\u30ea\u30b7\u30e3\u30b9\u6642\u9593",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u6771\u30a2\u30d5\u30ea\u30ab\u6642\u9593",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u6771\u30c6\u30a3\u30e2\u30fc\u30eb\u6642\u9593",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u30bd\u30ed\u30e2\u30f3\u8af8\u5cf6\u6642\u9593",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u30b3\u30b9\u30e9\u30a8\u6642\u9593",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u30de\u30fc\u30b7\u30e3\u30eb\u8af8\u5cf6\u6642\u9593",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u6771\u30e8\u30fc\u30ed\u30c3\u30d1\u6a19\u6e96\u6642",
               "EET",
               "\u6771\u30e8\u30fc\u30ed\u30c3\u30d1\u590f\u6642\u9593",
               "EEST",
               "\u6771\u30e8\u30fc\u30ed\u30c3\u30d1\u6642\u9593",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u30cb\u30e5\u30fc\u30d5\u30a1\u30f3\u30c9\u30e9\u30f3\u30c9\u6a19\u6e96\u6642",
               "NST",
               "\u30cb\u30e5\u30fc\u30d5\u30a1\u30f3\u30c9\u30e9\u30f3\u30c9\u590f\u6642\u9593",
               "NDT",
               "\u30cb\u30e5\u30fc\u30d5\u30a1\u30f3\u30c9\u30e9\u30f3\u30c9\u6642\u9593",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u30a2\u30d5\u30ac\u30cb\u30b9\u30bf\u30f3\u6642\u9593",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u9999\u6e2f\u6a19\u6e96\u6642",
               "HKT",
               "\u9999\u6e2f\u590f\u6642\u9593",
               "HKST",
               "\u9999\u6e2f\u6642\u9593",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u897f\u90e8\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u6a19\u6e96\u6642",
               "ART",
               "\u897f\u90e8\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u590f\u6642\u9593",
               "ARST",
               "\u897f\u90e8\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u6642\u9593",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u5927\u897f\u6d0b\u6a19\u6e96\u6642",
               "AST",
               "\u5927\u897f\u6d0b\u590f\u6642\u9593",
               "ADT",
               "\u5927\u897f\u6d0b\u6642\u9593",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u30dd\u30ca\u30da\u6642\u9593",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u30dc\u30ea\u30d3\u30a2\u6642\u9593",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u30b5\u30f3\u30d4\u30a8\u30fc\u30eb\u30fb\u30df\u30af\u30ed\u30f3\u6a19\u6e96\u6642",
               "PMST",
               "\u30b5\u30f3\u30d4\u30a8\u30fc\u30eb\u30fb\u30df\u30af\u30ed\u30f3\u590f\u6642\u9593",
               "PMDT",
               "\u30b5\u30f3\u30d4\u30a8\u30fc\u30eb\u30fb\u30df\u30af\u30ed\u30f3\u6642\u9593",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u30a4\u30f3\u30c9\u30b7\u30ca\u6642\u9593",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u30a8\u30ab\u30c6\u30ea\u30f3\u30d6\u30eb\u30b0\u6a19\u6e96\u6642",
               "YEKT",
               "\u30a8\u30ab\u30c6\u30ea\u30f3\u30d6\u30eb\u30b0\u590f\u6642\u9593",
               "YEKST",
               "\u30a8\u30ab\u30c6\u30ea\u30f3\u30d6\u30eb\u30b0\u6642\u9593",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u30e2\u30eb\u30c7\u30a3\u30d6\u6642\u9593",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u30bf\u30d2\u30c1\u6642\u9593",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u30a4\u30b9\u30e9\u30a8\u30eb\u6a19\u6e96\u6642",
               "IST",
               "\u30a4\u30b9\u30e9\u30a8\u30eb\u590f\u6642\u9593",
               "IDT",
               "\u30a4\u30b9\u30e9\u30a8\u30eb\u6642\u9593",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u30a4\u30f3\u30c9\u30cd\u30b7\u30a2\u4e2d\u90e8\u6642\u9593",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u30a6\u30a9\u30ea\u30b9\u30fb\u30d5\u30c4\u30ca\u6642\u9593",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u5357\u30a2\u30d5\u30ea\u30ab\u6a19\u6e96\u6642",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u662d\u548c\u57fa\u5730\u6642\u9593",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u30e9\u30a4\u30f3\u8af8\u5cf6\u6642\u9593",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u30a6\u30ba\u30d9\u30ad\u30b9\u30bf\u30f3\u6a19\u6e96\u6642",
               "UZT",
               "\u30a6\u30ba\u30d9\u30ad\u30b9\u30bf\u30f3\u590f\u6642\u9593",
               "UZST",
               "\u30a6\u30ba\u30d9\u30ad\u30b9\u30bf\u30f3\u6642\u9593",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u30aa\u30e0\u30b9\u30af\u6a19\u6e96\u6642",
               "OMST",
               "\u30aa\u30e0\u30b9\u30af\u590f\u6642\u9593",
               "OMSST",
               "\u30aa\u30e0\u30b9\u30af\u6642\u9593",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u30bb\u30fc\u30b7\u30a7\u30eb\u6642\u9593",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u30a6\u30eb\u30b0\u30a2\u30a4\u6a19\u6e96\u6642",
               "UYT",
               "\u30a6\u30eb\u30b0\u30a2\u30a4\u590f\u6642\u9593",
               "UYST",
               "\u30a6\u30eb\u30b0\u30a2\u30a4\u6642\u9593",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u30cd\u30d1\u30fc\u30eb\u6642\u9593",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u30a6\u30e9\u30f3\u30d0\u30fc\u30c8\u30eb\u6a19\u6e96\u6642",
               "ULAT",
               "\u30a6\u30e9\u30f3\u30d0\u30fc\u30c8\u30eb\u590f\u6642\u9593",
               "ULAST",
               "\u30a6\u30e9\u30f3\u30d0\u30fc\u30c8\u30eb\u6642\u9593",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u30a2\u30e1\u30ea\u30ab\u4e2d\u90e8\u6a19\u6e96\u6642",
               "CST",
               "\u30a2\u30e1\u30ea\u30ab\u4e2d\u90e8\u590f\u6642\u9593",
               "CDT",
               "\u30a2\u30e1\u30ea\u30ab\u4e2d\u90e8\u6642\u9593",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u30c1\u30e5\u30fc\u30af\u6642\u9593",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u30cb\u30a6\u30a8\u6642\u9593",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u30a6\u30a7\u30fc\u30af\u5cf6\u6642\u9593",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u30d5\u30a9\u30fc\u30af\u30e9\u30f3\u30c9\u8af8\u5cf6\u6a19\u6e96\u6642",
               "FKT",
               "\u30d5\u30a9\u30fc\u30af\u30e9\u30f3\u30c9\u8af8\u5cf6\u590f\u6642\u9593",
               "FKST",
               "\u30d5\u30a9\u30fc\u30af\u30e9\u30f3\u30c9\u8af8\u5cf6\u6642\u9593",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u30d0\u30cc\u30a2\u30c4\u6a19\u6e96\u6642",
               "VUT",
               "\u30d0\u30cc\u30a2\u30c4\u590f\u6642\u9593",
               "VUST",
               "\u30d0\u30cc\u30a2\u30c4\u6642\u9593",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u30ce\u30f4\u30a9\u30b7\u30d3\u30eb\u30b9\u30af\u6a19\u6e96\u6642",
               "NOVT",
               "\u30ce\u30f4\u30a9\u30b7\u30d3\u30eb\u30b9\u30af\u590f\u6642\u9593",
               "NOVST",
               "\u30ce\u30f4\u30a9\u30b7\u30d3\u30eb\u30b9\u30af\u6642\u9593",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u30b7\u30f3\u30ac\u30dd\u30fc\u30eb\u6a19\u6e96\u6642",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u30a2\u30be\u30ec\u30b9\u6a19\u6e96\u6642",
               "AZOT",
               "\u30a2\u30be\u30ec\u30b9\u590f\u6642\u9593",
               "AZOST",
               "\u30a2\u30be\u30ec\u30b9\u6642\u9593",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u30a2\u30d4\u30a2\u6a19\u6e96\u6642",
               "WSST",
               "\u30a2\u30d4\u30a2\u590f\u6642\u9593",
               "WSDT",
               "\u30a2\u30d4\u30a2\u6642\u9593",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u30d6\u30fc\u30bf\u30f3\u6642\u9593",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u30b9\u30ea\u30ca\u30e0\u6642\u9593",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u30ca\u30a6\u30eb\u6642\u9593",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u30af\u30e9\u30b9\u30ce\u30e4\u30eb\u30b9\u30af\u6a19\u6e96\u6642",
               "KRAT",
               "\u30af\u30e9\u30b9\u30ce\u30e4\u30eb\u30b9\u30af\u590f\u6642\u9593",
               "KRAST",
               "\u30af\u30e9\u30b9\u30ce\u30e4\u30eb\u30b9\u30af\u6642\u9593",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u897f\u30ab\u30b6\u30d5\u30b9\u30bf\u30f3\u6642\u9593",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u30df\u30e3\u30f3\u30de\u30fc\u6642\u9593",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u30af\u30ea\u30b9\u30de\u30b9\u5cf6\u6642\u9593",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u30a2\u30de\u30be\u30f3\u6a19\u6e96\u6642",
               "AMT",
               "\u30a2\u30de\u30be\u30f3\u590f\u6642\u9593",
               "AMST",
               "\u30a2\u30de\u30be\u30f3\u6642\u9593",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u6771\u30ab\u30b6\u30d5\u30b9\u30bf\u30f3\u6642\u9593",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u30d5\u30a3\u30b8\u30fc\u6a19\u6e96\u6642",
               "FJT",
               "\u30d5\u30a3\u30b8\u30fc\u590f\u6642\u9593",
               "FJST",
               "\u30d5\u30a3\u30b8\u30fc\u6642\u9593",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u30ec\u30e6\u30cb\u30aa\u30f3\u6642\u9593",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u30b3\u30b3\u30b9\u8af8\u5cf6\u6642\u9593",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u30c1\u30e3\u30bf\u30e0\u6a19\u6e96\u6642",
               "CHAST",
               "\u30c1\u30e3\u30bf\u30e0\u590f\u6642\u9593",
               "CHADT",
               "\u30c1\u30e3\u30bf\u30e0\u6642\u9593",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u30dc\u30b9\u30c8\u30fc\u30af\u57fa\u5730\u6642\u9593",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u6a19\u6e96\u6642",
               "ART",
               "\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u590f\u6642\u9593",
               "ARST",
               "\u30a2\u30eb\u30bc\u30f3\u30c1\u30f3\u6642\u9593",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u30ac\u30f3\u30d3\u30a8\u8af8\u5cf6\u6642\u9593",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u30da\u30c8\u30ed\u30d1\u30d6\u30ed\u30d5\u30b9\u30af\u30fb\u30ab\u30e0\u30c1\u30e3\u30c4\u30ad\u30fc\u6a19\u6e96\u6642",
               "PETT",
               "\u30da\u30c8\u30ed\u30d1\u30d6\u30ed\u30d5\u30b9\u30af\u30fb\u30ab\u30e0\u30c1\u30e3\u30c4\u30ad\u30fc\u590f\u6642\u9593",
               "PETST",
               "\u30da\u30c8\u30ed\u30d1\u30d6\u30ed\u30d5\u30b9\u30af\u30fb\u30ab\u30e0\u30c1\u30e3\u30c4\u30ad\u30fc\u6642\u9593",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u30c4\u30d0\u30eb\u6642\u9593",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u30ac\u30e9\u30d1\u30b4\u30b9\u6642\u9593",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u30de\u30c3\u30b3\u30fc\u30ea\u30fc\u5cf6\u6642\u9593",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u30d9\u30cd\u30ba\u30a8\u30e9\u6642\u9593",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u30cf\u30ef\u30a4\u30fb\u30a2\u30ea\u30e5\u30fc\u30b7\u30e3\u30f3\u6a19\u6e96\u6642",
               "HAST",
               "\u30cf\u30ef\u30a4\u30fb\u30a2\u30ea\u30e5\u30fc\u30b7\u30e3\u30f3\u590f\u6642\u9593",
               "HADT",
               "\u30cf\u30ef\u30a4\u30fb\u30a2\u30ea\u30e5\u30fc\u30b7\u30e3\u30f3\u6642\u9593",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u90e8\u6a19\u6e96\u6642",
               "ACST",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u90e8\u590f\u6642\u9593",
               "ACDT",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u4e2d\u90e8\u6642\u9593",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u30a2\u30e1\u30ea\u30ab\u592a\u5e73\u6d0b\u6a19\u6e96\u6642",
               "PST",
               "\u30a2\u30e1\u30ea\u30ab\u592a\u5e73\u6d0b\u590f\u6642\u9593",
               "PDT",
               "\u30a2\u30e1\u30ea\u30ab\u592a\u5e73\u6d0b\u6642\u9593",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u30d5\u30a7\u30cb\u30c3\u30af\u30b9\u8af8\u5cf6\u6642\u9593",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u30c8\u30eb\u30af\u30e1\u30cb\u30b9\u30bf\u30f3\u6a19\u6e96\u6642",
               "TMT",
               "\u30c8\u30eb\u30af\u30e1\u30cb\u30b9\u30bf\u30f3\u590f\u6642\u9593",
               "TMST",
               "\u30c8\u30eb\u30af\u30e1\u30cb\u30b9\u30bf\u30f3\u6642\u9593",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u897f\u30e8\u30fc\u30ed\u30c3\u30d1\u6a19\u6e96\u6642",
               "WET",
               "\u897f\u30e8\u30fc\u30ed\u30c3\u30d1\u590f\u6642\u9593",
               "WEST",
               "\u897f\u30e8\u30fc\u30ed\u30c3\u30d1\u6642\u9593",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u30ab\u30fc\u30dc\u30d9\u30eb\u30c7\u6a19\u6e96\u6642",
               "CVT",
               "\u30ab\u30fc\u30dc\u30d9\u30eb\u30c7\u590f\u6642\u9593",
               "CVST",
               "\u30ab\u30fc\u30dc\u30d9\u30eb\u30c7\u6642\u9593",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u30ce\u30fc\u30d5\u30a9\u30fc\u30af\u5cf6\u6642\u9593",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u30ac\u30a4\u30a2\u30ca\u6642\u9593",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u30d4\u30c8\u30b1\u30a2\u30f3\u6642\u9593",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u30ed\u30bc\u30e9\u57fa\u5730\u6642\u9593",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u30b5\u30e2\u30a2\u6a19\u6e96\u6642",
               "SST",
               "\u30b5\u30e2\u30a2\u590f\u6642\u9593",
               "SDT",
               "\u30b5\u30e2\u30a2\u6642\u9593",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u30d1\u30e9\u30aa\u6642\u9593",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u6975\u6771\u30e8\u30fc\u30ed\u30c3\u30d1\u6642\u9593",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u30a2\u30bc\u30eb\u30d0\u30a4\u30b8\u30e3\u30f3\u6a19\u6e96\u6642",
               "AZT",
               "\u30a2\u30bc\u30eb\u30d0\u30a4\u30b8\u30e3\u30f3\u590f\u6642\u9593",
               "AZST",
               "\u30a2\u30bc\u30eb\u30d0\u30a4\u30b8\u30e3\u30f3\u6642\u9593",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u30e2\u30fc\u30bd\u30f3\u57fa\u5730\u6642\u9593",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u30e1\u30ad\u30b7\u30b3\u592a\u5e73\u6d0b\u6a19\u6e96\u6642",
               "MST",
               "\u30e1\u30ad\u30b7\u30b3\u592a\u5e73\u6d0b\u590f\u6642\u9593",
               "MDT",
               "\u30e1\u30ad\u30b7\u30b3\u592a\u5e73\u6d0b\u6642\u9593",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u30c7\u30fc\u30d3\u30b9\u57fa\u5730\u6642\u9593",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u30ad\u30e5\u30fc\u30d0\u6a19\u6e96\u6642",
               "CST",
               "\u30ad\u30e5\u30fc\u30d0\u590f\u6642\u9593",
               "CDT",
               "\u30ad\u30e5\u30fc\u30d0\u6642\u9593",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u897f\u30a2\u30d5\u30ea\u30ab\u6a19\u6e96\u6642",
               "CAT",
               "\u897f\u30a2\u30d5\u30ea\u30ab\u590f\u6642\u9593",
               "CAST",
               "\u897f\u30a2\u30d5\u30ea\u30ab\u6642\u9593",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u30b0\u30ea\u30cb\u30c3\u30b8\u6a19\u6e96\u6642",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u30d5\u30a3\u30ea\u30d4\u30f3\u6a19\u6e96\u6642",
               "PHT",
               "\u30d5\u30a3\u30ea\u30d4\u30f3\u590f\u6642\u9593",
               "PHST",
               "\u30d5\u30a3\u30ea\u30d4\u30f3\u6642\u9593",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u4ecf\u9818\u5357\u65b9\u5357\u6975\u6642\u9593",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u30b5\u30a6\u30b9\u30b8\u30e7\u30fc\u30b8\u30a2\u6642\u9593",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u30cb\u30e5\u30fc\u30ab\u30ec\u30c9\u30cb\u30a2\u6a19\u6e96\u6642",
               "NCT",
               "\u30cb\u30e5\u30fc\u30ab\u30ec\u30c9\u30cb\u30a2\u590f\u6642\u9593",
               "NCST",
               "\u30cb\u30e5\u30fc\u30ab\u30ec\u30c9\u30cb\u30a2\u6642\u9593",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u30d6\u30eb\u30cd\u30a4\u30fb\u30c0\u30eb\u30b5\u30e9\u30fc\u30e0\u6642\u9593",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u30a4\u30e9\u30f3\u6a19\u6e96\u6642",
               "IRST",
               "\u30a4\u30e9\u30f3\u590f\u6642\u9593",
               "IRDT",
               "\u30a4\u30e9\u30f3\u6642\u9593",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u30a4\u30fc\u30b9\u30bf\u30fc\u5cf6\u6a19\u6e96\u6642",
               "EAST",
               "\u30a4\u30fc\u30b9\u30bf\u30fc\u5cf6\u590f\u6642\u9593",
               "EASST",
               "\u30a4\u30fc\u30b9\u30bf\u30fc\u5cf6\u6642\u9593",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u30e1\u30ad\u30b7\u30b3\u5317\u897f\u90e8\u6a19\u6e96\u6642",
               "PST",
               "\u30e1\u30ad\u30b7\u30b3\u5317\u897f\u90e8\u590f\u6642\u9593",
               "PDT",
               "\u30e1\u30ad\u30b7\u30b3\u5317\u897f\u90e8\u6642\u9593",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u30c7\u30e5\u30e2\u30f3\u30fb\u30c7\u30e5\u30eb\u30f4\u30a3\u30eb\u57fa\u5730\u6642\u9593",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u30bf\u30b8\u30ad\u30b9\u30bf\u30f3\u6642\u9593",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u30c8\u30f3\u30ac\u6a19\u6e96\u6642",
               "TOT",
               "\u30c8\u30f3\u30ac\u590f\u6642\u9593",
               "TOST",
               "\u30c8\u30f3\u30ac\u6642\u9593",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u30d0\u30f3\u30b0\u30e9\u30c7\u30b7\u30e5\u6a19\u6e96\u6642",
               "BDT",
               "\u30d0\u30f3\u30b0\u30e9\u30c7\u30b7\u30e5\u590f\u6642\u9593",
               "BDST",
               "\u30d0\u30f3\u30b0\u30e9\u30c7\u30b7\u30e5\u6642\u9593",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u30da\u30eb\u30fc\u6a19\u6e96\u6642",
               "PET",
               "\u30da\u30eb\u30fc\u590f\u6642\u9593",
               "PEST",
               "\u30da\u30eb\u30fc\u6642\u9593",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u897f\u90e8\u6a19\u6e96\u6642",
               "WGT",
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u897f\u90e8\u590f\u6642\u9593",
               "WGST",
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u897f\u90e8\u6642\u9593",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u30a8\u30af\u30a2\u30c9\u30eb\u6642\u9593",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u6771\u90e8\u6a19\u6e96\u6642",
               "EGT",
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u6771\u90e8\u590f\u6642\u9593",
               "EGST",
               "\u30b0\u30ea\u30fc\u30f3\u30e9\u30f3\u30c9\u6771\u90e8\u6642\u9593",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u6e7e\u5cb8\u6a19\u6e96\u6642",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u30a4\u30f3\u30c9\u30cd\u30b7\u30a2\u6771\u90e8\u6642\u9593",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u97d3\u56fd\u6a19\u6e96\u6642",
               "KST",
               "\u97d3\u56fd\u590f\u6642\u9593",
               "KDT",
               "\u97d3\u56fd\u6642\u9593",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u897f\u90e8\u6a19\u6e96\u6642",
               "AWST",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u897f\u90e8\u590f\u6642\u9593",
               "AWDT",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u897f\u90e8\u6642\u9593",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u30ad\u30eb\u30ae\u30b9\u30bf\u30f3\u6642\u9593",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u30a4\u30f3\u30c9\u30cd\u30b7\u30a2\u897f\u90e8\u6642\u9593",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u6771\u90e8\u6a19\u6e96\u6642",
               "AEST",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u6771\u90e8\u590f\u6642\u9593",
               "AEDT",
               "\u30aa\u30fc\u30b9\u30c8\u30e9\u30ea\u30a2\u6771\u90e8\u6642\u9593",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u4ecf\u9818\u30ae\u30a2\u30ca\u6642\u9593",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u30b3\u30ed\u30f3\u30d3\u30a2\u6a19\u6e96\u6642",
               "COT",
               "\u30b3\u30ed\u30f3\u30d3\u30a2\u590f\u6642\u9593",
               "COST",
               "\u30b3\u30ed\u30f3\u30d3\u30a2\u6642\u9593",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u30c1\u30ea\u6a19\u6e96\u6642",
               "CLT",
               "\u30c1\u30ea\u590f\u6642\u9593",
               "CLST",
               "\u30c1\u30ea\u6642\u9593",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u30ae\u30eb\u30d0\u30fc\u30c8\u8af8\u5cf6\u6642\u9593",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u30a2\u30e1\u30ea\u30ab\u5c71\u5730\u6a19\u6e96\u6642",
               "MST",
               "\u30a2\u30e1\u30ea\u30ab\u5c71\u5730\u590f\u6642\u9593",
               "MDT",
               "\u30a2\u30e1\u30ea\u30ab\u5c71\u5730\u6642\u9593",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u30de\u30eb\u30ad\u30fc\u30ba\u6642\u9593",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u30a2\u30e9\u30d3\u30a2\u6a19\u6e96\u6642",
               "AST",
               "\u30a2\u30e9\u30d3\u30a2\u590f\u6642\u9593",
               "ADT",
               "\u30a2\u30e9\u30d3\u30a2\u6642\u9593",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u30a2\u30e9\u30b9\u30ab\u6a19\u6e96\u6642",
               "AKST",
               "\u30a2\u30e9\u30b9\u30ab\u590f\u6642\u9593",
               "AKDT",
               "\u30a2\u30e9\u30b9\u30ab\u6642\u9593",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u30a6\u30e9\u30b8\u30aa\u30b9\u30c8\u30af\u6a19\u6e96\u6642",
               "VLAT",
               "\u30a6\u30e9\u30b8\u30aa\u30b9\u30c8\u30af\u590f\u6642\u9593",
               "VLAST",
               "\u30a6\u30e9\u30b8\u30aa\u30b9\u30c8\u30af\u6642\u9593",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u30c1\u30e3\u30e2\u30ed\u6642\u9593",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u30a4\u30eb\u30af\u30fc\u30c4\u30af\u6a19\u6e96\u6642",
               "IRKT",
               "\u30a4\u30eb\u30af\u30fc\u30c4\u30af\u590f\u6642\u9593",
               "IRKST",
               "\u30a4\u30eb\u30af\u30fc\u30c4\u30af\u6642\u9593",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u30b8\u30e7\u30fc\u30b8\u30a2\u6a19\u6e96\u6642",
               "GET",
               "\u30b8\u30e7\u30fc\u30b8\u30a2\u590f\u6642\u9593",
               "GEST",
               "\u30b8\u30e7\u30fc\u30b8\u30a2\u6642\u9593",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u30c8\u30b1\u30e9\u30a6\u6642\u9593",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u30d1\u30d7\u30a2\u30cb\u30e5\u30fc\u30ae\u30cb\u30a2\u6642\u9593",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u30d5\u30a7\u30eb\u30ca\u30f3\u30c9\u30fb\u30c7\u30fb\u30ce\u30ed\u30fc\u30cb\u30e3\u6a19\u6e96\u6642",
               "FNT",
               "\u30d5\u30a7\u30eb\u30ca\u30f3\u30c9\u30fb\u30c7\u30fb\u30ce\u30ed\u30fc\u30cb\u30e3\u590f\u6642\u9593",
               "FNST",
               "\u30d5\u30a7\u30eb\u30ca\u30f3\u30c9\u30fb\u30c7\u30fb\u30ce\u30ed\u30fc\u30cb\u30e3\u6642\u9593",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u30c1\u30e7\u30a4\u30d0\u30eb\u30b5\u30f3\u6a19\u6e96\u6642",
               "CHOT",
               "\u30c1\u30e7\u30a4\u30d0\u30eb\u30b5\u30f3\u590f\u6642\u9593",
               "CHOST",
               "\u30c1\u30e7\u30a4\u30d0\u30eb\u30b5\u30f3\u6642\u9593",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u30d6\u30e9\u30b8\u30ea\u30a2\u6a19\u6e96\u6642",
               "BRT",
               "\u30d6\u30e9\u30b8\u30ea\u30a2\u590f\u6642\u9593",
               "BRST",
               "\u30d6\u30e9\u30b8\u30ea\u30a2\u6642\u9593",
               "BRT",
            };
        final String[] China = new String[] {
               "\u4e2d\u56fd\u6a19\u6e96\u6642",
               "CST",
               "\u4e2d\u56fd\u590f\u6642\u9593",
               "CDT",
               "\u4e2d\u56fd\u6642\u9593",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u30a2\u30eb\u30e1\u30cb\u30a2\u6a19\u6e96\u6642",
               "AMT",
               "\u30a2\u30eb\u30e1\u30cb\u30a2\u590f\u6642\u9593",
               "AMST",
               "\u30a2\u30eb\u30e1\u30cb\u30a2\u6642\u9593",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u30b5\u30de\u30e9\u6a19\u6e96\u6642",
               "SAMT",
               "\u30b5\u30de\u30e9\u590f\u6642\u9593",
               "SAMST",
               "\u30b5\u30de\u30e9\u6642\u9593",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u30a4\u30f3\u30c9\u6a19\u6e96\u6642",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u30af\u30c3\u30af\u8af8\u5cf6\u6a19\u6e96\u6642",
               "CKT",
               "\u30af\u30c3\u30af\u8af8\u5cf6\u590f\u6642\u9593",
               "CKHST",
               "\u30af\u30c3\u30af\u8af8\u5cf6\u6642\u9593",
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
                    "\u30b0\u30ea\u30cb\u30c3\u30b8\u6a19\u6e96\u6642",
                    "GMT",
                    "\u82f1\u56fd\u590f\u6642\u9593",
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
                    "\u30b0\u30ea\u30cb\u30c3\u30b8\u6a19\u6e96\u6642",
                    "GMT",
                    "\u30a2\u30a4\u30eb\u30e9\u30f3\u30c9\u6a19\u6e96\u6642",
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
