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

public class TimeZoneNames_zh extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u4e2d\u90e8\u975e\u6d32\u65f6\u95f4",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u83ab\u65af\u79d1\u6807\u51c6\u65f6\u95f4",
               "MSK",
               "\u83ab\u65af\u79d1\u590f\u4ee4\u65f6\u95f4",
               "MSD",
               "\u83ab\u65af\u79d1\u65f6\u95f4",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u65e5\u672c\u6807\u51c6\u65f6\u95f4",
               "JST",
               "\u65e5\u672c\u590f\u4ee4\u65f6\u95f4",
               "JDT",
               "\u65e5\u672c\u65f6\u95f4",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u5df4\u57fa\u65af\u5766\u6807\u51c6\u65f6\u95f4",
               "PKT",
               "\u5df4\u57fa\u65af\u5766\u590f\u4ee4\u65f6\u95f4",
               "PKST",
               "\u5df4\u57fa\u65af\u5766\u65f6\u95f4",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u53f0\u5317\u6807\u51c6\u65f6\u95f4",
               "CST",
               "\u53f0\u5317\u590f\u4ee4\u65f6\u95f4",
               "CDT",
               "\u53f0\u5317\u65f6\u95f4",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u79d1\u5e03\u591a\u6807\u51c6\u65f6\u95f4",
               "HOVT",
               "\u79d1\u5e03\u591a\u590f\u4ee4\u65f6\u95f4",
               "HOVST",
               "\u79d1\u5e03\u591a\u65f6\u95f4",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u9a6c\u52a0\u4e39\u6807\u51c6\u65f6\u95f4",
               "MAGT",
               "\u9a6c\u52a0\u4e39\u590f\u4ee4\u65f6\u95f4",
               "MAGST",
               "\u9a6c\u52a0\u4e39\u65f6\u95f4",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u897f\u90e8\u6807\u51c6\u65f6\u95f4",
               "ACWST",
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u897f\u90e8\u590f\u4ee4\u65f6\u95f4",
               "ACWDT",
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u897f\u90e8\u65f6\u95f4",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u4e2d\u6b27\u6807\u51c6\u65f6\u95f4",
               "CET",
               "\u4e2d\u6b27\u590f\u4ee4\u65f6\u95f4",
               "CEST",
               "\u4e2d\u6b27\u65f6\u95f4",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u5e93\u9875\u5c9b\u6807\u51c6\u65f6\u95f4",
               "SAKT",
               "\u5e93\u9875\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "SAKST",
               "\u5e93\u9875\u5c9b\u65f6\u95f4",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u5df4\u62c9\u572d\u6807\u51c6\u65f6\u95f4",
               "PYT",
               "\u5df4\u62c9\u572d\u590f\u4ee4\u65f6\u95f4",
               "PYST",
               "\u5df4\u62c9\u572d\u65f6\u95f4",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u963f\u514b\u91cc\u6807\u51c6\u65f6\u95f4",
               "ACT",
               "\u963f\u514b\u91cc\u590f\u4ee4\u65f6\u95f4",
               "ACST",
               "\u963f\u514b\u91cc\u65f6\u95f4",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u9a6c\u6765\u897f\u4e9a\u65f6\u95f4",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u5317\u7f8e\u4e1c\u90e8\u6807\u51c6\u65f6\u95f4",
               "EST",
               "\u5317\u7f8e\u4e1c\u90e8\u590f\u4ee4\u65f6\u95f4",
               "EDT",
               "\u5317\u7f8e\u4e1c\u90e8\u65f6\u95f4",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u8c6a\u52cb\u7235\u5c9b\u6807\u51c6\u65f6\u95f4",
               "LHST",
               "\u8c6a\u52cb\u7235\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "LHDT",
               "\u8c6a\u52cb\u7235\u5c9b\u65f6\u95f4",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u65b0\u897f\u5170\u6807\u51c6\u65f6\u95f4",
               "NZST",
               "\u65b0\u897f\u5170\u590f\u4ee4\u65f6\u95f4",
               "NZDT",
               "\u65b0\u897f\u5170\u65f6\u95f4",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u5370\u5ea6\u6d0b\u65f6\u95f4",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u96c5\u5e93\u8328\u514b\u6807\u51c6\u65f6\u95f4",
               "YAKT",
               "\u96c5\u5e93\u8328\u514b\u590f\u4ee4\u65f6\u95f4",
               "YAKST",
               "\u96c5\u5e93\u8328\u514b\u65f6\u95f4",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u6bdb\u91cc\u6c42\u65af\u6807\u51c6\u65f6\u95f4",
               "MUT",
               "\u6bdb\u91cc\u6c42\u65af\u590f\u4ee4\u65f6\u95f4",
               "MUST",
               "\u6bdb\u91cc\u6c42\u65af\u65f6\u95f4",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u4e1c\u90e8\u975e\u6d32\u65f6\u95f4",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u4e1c\u5e1d\u6c76\u65f6\u95f4",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u6240\u7f57\u95e8\u7fa4\u5c9b\u65f6\u95f4",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u79d1\u65af\u96f7\u65f6\u95f4",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u9a6c\u7ecd\u5c14\u7fa4\u5c9b\u65f6\u95f4",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u4e1c\u6b27\u6807\u51c6\u65f6\u95f4",
               "EET",
               "\u4e1c\u6b27\u590f\u4ee4\u65f6\u95f4",
               "EEST",
               "\u4e1c\u6b27\u65f6\u95f4",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u7ebd\u82ac\u5170\u6807\u51c6\u65f6\u95f4",
               "NST",
               "\u7ebd\u82ac\u5170\u590f\u4ee4\u65f6\u95f4",
               "NDT",
               "\u7ebd\u82ac\u5170\u65f6\u95f4",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u963f\u5bcc\u6c57\u65f6\u95f4",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u9999\u6e2f\u6807\u51c6\u65f6\u95f4",
               "HKT",
               "\u9999\u6e2f\u590f\u4ee4\u65f6\u95f4",
               "HKST",
               "\u9999\u6e2f\u65f6\u95f4",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u963f\u6839\u5ef7\u897f\u90e8\u6807\u51c6\u65f6\u95f4",
               "ART",
               "\u963f\u6839\u5ef7\u897f\u90e8\u590f\u4ee4\u65f6\u95f4",
               "ARST",
               "\u963f\u6839\u5ef7\u897f\u90e8\u65f6\u95f4",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u5927\u897f\u6d0b\u6807\u51c6\u65f6\u95f4",
               "AST",
               "\u5927\u897f\u6d0b\u590f\u4ee4\u65f6\u95f4",
               "ADT",
               "\u5927\u897f\u6d0b\u65f6\u95f4",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u6ce2\u7eb3\u4f69\u65f6\u95f4",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u73bb\u5229\u7ef4\u4e9a\u65f6\u95f4",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u5723\u76ae\u57c3\u5c14\u548c\u5bc6\u514b\u9686\u7fa4\u5c9b\u6807\u51c6\u65f6\u95f4",
               "PMST",
               "\u5723\u76ae\u57c3\u5c14\u548c\u5bc6\u514b\u9686\u7fa4\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "PMDT",
               "\u5723\u76ae\u57c3\u5c14\u548c\u5bc6\u514b\u9686\u7fa4\u5c9b\u65f6\u95f4",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u5370\u5ea6\u652f\u90a3\u65f6\u95f4",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u53f6\u5361\u6377\u7433\u5821\u6807\u51c6\u65f6\u95f4",
               "YEKT",
               "\u53f6\u5361\u6377\u7433\u5821\u590f\u4ee4\u65f6\u95f4",
               "YEKST",
               "\u53f6\u5361\u6377\u7433\u5821\u65f6\u95f4",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u9a6c\u5c14\u4ee3\u592b\u65f6\u95f4",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u5854\u5e0c\u63d0\u5c9b\u65f6\u95f4",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u4ee5\u8272\u5217\u6807\u51c6\u65f6\u95f4",
               "IST",
               "\u4ee5\u8272\u5217\u590f\u4ee4\u65f6\u95f4",
               "IDT",
               "\u4ee5\u8272\u5217\u65f6\u95f4",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u5370\u5ea6\u5c3c\u897f\u4e9a\u4e2d\u90e8\u65f6\u95f4",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u74e6\u5229\u65af\u548c\u5bcc\u56fe\u7eb3\u65f6\u95f4",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u5357\u90e8\u975e\u6d32\u65f6\u95f4",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u662d\u548c\u65f6\u95f4",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u83b1\u6069\u7fa4\u5c9b\u65f6\u95f4",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u4e4c\u5179\u522b\u514b\u65af\u5766\u6807\u51c6\u65f6\u95f4",
               "UZT",
               "\u4e4c\u5179\u522b\u514b\u65af\u5766\u590f\u4ee4\u65f6\u95f4",
               "UZST",
               "\u4e4c\u5179\u522b\u514b\u65af\u5766\u65f6\u95f4",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u9102\u6728\u65af\u514b\u6807\u51c6\u65f6\u95f4",
               "OMST",
               "\u9102\u6728\u65af\u514b\u590f\u4ee4\u65f6\u95f4",
               "OMSST",
               "\u9102\u6728\u65af\u514b\u65f6\u95f4",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u585e\u820c\u5c14\u65f6\u95f4",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u4e4c\u62c9\u572d\u6807\u51c6\u65f6\u95f4",
               "UYT",
               "\u4e4c\u62c9\u572d\u590f\u4ee4\u65f6\u95f4",
               "UYST",
               "\u4e4c\u62c9\u572d\u65f6\u95f4",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u5c3c\u6cca\u5c14\u65f6\u95f4",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u4e4c\u5170\u5df4\u6258\u6807\u51c6\u65f6\u95f4",
               "ULAT",
               "\u4e4c\u5170\u5df4\u6258\u590f\u4ee4\u65f6\u95f4",
               "ULAST",
               "\u4e4c\u5170\u5df4\u6258\u65f6\u95f4",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u5317\u7f8e\u4e2d\u90e8\u6807\u51c6\u65f6\u95f4",
               "CST",
               "\u5317\u7f8e\u4e2d\u90e8\u590f\u4ee4\u65f6\u95f4",
               "CDT",
               "\u5317\u7f8e\u4e2d\u90e8\u65f6\u95f4",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u695a\u514b\u65f6\u95f4",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u7ebd\u57c3\u65f6\u95f4",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u5a01\u514b\u5c9b\u65f6\u95f4",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u798f\u514b\u5170\u7fa4\u5c9b\u6807\u51c6\u65f6\u95f4",
               "FKT",
               "\u798f\u514b\u5170\u7fa4\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "FKST",
               "\u798f\u514b\u5170\u7fa4\u5c9b\u65f6\u95f4",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u74e6\u52aa\u963f\u56fe\u6807\u51c6\u65f6\u95f4",
               "VUT",
               "\u74e6\u52aa\u963f\u56fe\u590f\u4ee4\u65f6\u95f4",
               "VUST",
               "\u74e6\u52aa\u963f\u56fe\u65f6\u95f4",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u65b0\u897f\u4f2f\u5229\u4e9a\u6807\u51c6\u65f6\u95f4",
               "NOVT",
               "\u65b0\u897f\u4f2f\u5229\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "NOVST",
               "\u65b0\u897f\u4f2f\u5229\u4e9a\u65f6\u95f4",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u65b0\u52a0\u5761\u6807\u51c6\u65f6\u95f4",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u4e9a\u901f\u5c14\u7fa4\u5c9b\u6807\u51c6\u65f6\u95f4",
               "AZOT",
               "\u4e9a\u901f\u5c14\u7fa4\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "AZOST",
               "\u4e9a\u901f\u5c14\u7fa4\u5c9b\u65f6\u95f4",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u963f\u76ae\u4e9a\u6807\u51c6\u65f6\u95f4",
               "WSST",
               "\u963f\u76ae\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "WSDT",
               "\u963f\u76ae\u4e9a\u65f6\u95f4",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u4e0d\u4e39\u65f6\u95f4",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u82cf\u91cc\u5357\u65f6\u95f4",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u7459\u9c81\u65f6\u95f4",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u514b\u62c9\u65af\u8bfa\u4e9a\u5c14\u65af\u514b\u6807\u51c6\u65f6\u95f4",
               "KRAT",
               "\u514b\u62c9\u65af\u8bfa\u4e9a\u5c14\u65af\u514b\u590f\u4ee4\u65f6\u95f4",
               "KRAST",
               "\u514b\u62c9\u65af\u8bfa\u4e9a\u5c14\u65af\u514b\u65f6\u95f4",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u54c8\u8428\u514b\u65af\u5766\u897f\u90e8\u65f6\u95f4",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u7f05\u7538\u65f6\u95f4",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u5723\u8bde\u5c9b\u65f6\u95f4",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u4e9a\u9a6c\u900a\u6807\u51c6\u65f6\u95f4",
               "AMT",
               "\u4e9a\u9a6c\u900a\u590f\u4ee4\u65f6\u95f4",
               "AMST",
               "\u4e9a\u9a6c\u900a\u65f6\u95f4",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u54c8\u8428\u514b\u65af\u5766\u4e1c\u90e8\u65f6\u95f4",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u6590\u6d4e\u6807\u51c6\u65f6\u95f4",
               "FJT",
               "\u6590\u6d4e\u590f\u4ee4\u65f6\u95f4",
               "FJST",
               "\u6590\u6d4e\u65f6\u95f4",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u7559\u5c3c\u6c6a\u65f6\u95f4",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u79d1\u79d1\u65af\u7fa4\u5c9b\u65f6\u95f4",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u67e5\u5766\u6807\u51c6\u65f6\u95f4",
               "CHAST",
               "\u67e5\u5766\u590f\u4ee4\u65f6\u95f4",
               "CHADT",
               "\u67e5\u5766\u65f6\u95f4",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u6c83\u65af\u6258\u514b\u65f6\u95f4",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u963f\u6839\u5ef7\u6807\u51c6\u65f6\u95f4",
               "ART",
               "\u963f\u6839\u5ef7\u590f\u4ee4\u65f6\u95f4",
               "ARST",
               "\u963f\u6839\u5ef7\u65f6\u95f4",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u7518\u6bd4\u5c14\u65f6\u95f4",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u5f7c\u5f97\u7f57\u5df4\u752b\u6d1b\u592b\u65af\u514b-\u582a\u5bdf\u52a0\u6807\u51c6\u65f6\u95f4",
               "PETT",
               "\u5f7c\u5f97\u7f57\u5df4\u752b\u6d1b\u592b\u65af\u514b-\u582a\u5bdf\u52a0\u590f\u4ee4\u65f6\u95f4",
               "PETST",
               "\u5f7c\u5f97\u7f57\u5df4\u752b\u6d1b\u592b\u65af\u514b-\u582a\u5bdf\u52a0\u65f6\u95f4",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u56fe\u74e6\u5362\u65f6\u95f4",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u52a0\u62c9\u5e15\u6208\u65af\u65f6\u95f4",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u9ea6\u5938\u91cc\u5c9b\u65f6\u95f4",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u59d4\u5185\u745e\u62c9\u65f6\u95f4",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u590f\u5a01\u5937-\u963f\u7559\u7533\u6807\u51c6\u65f6\u95f4",
               "HAST",
               "\u590f\u5a01\u5937-\u963f\u7559\u7533\u590f\u4ee4\u65f6\u95f4",
               "HADT",
               "\u590f\u5a01\u5937-\u963f\u7559\u7533\u65f6\u95f4",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u90e8\u6807\u51c6\u65f6\u95f4",
               "ACST",
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u90e8\u590f\u4ee4\u65f6\u95f4",
               "ACDT",
               "\u6fb3\u5927\u5229\u4e9a\u4e2d\u90e8\u65f6\u95f4",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u5317\u7f8e\u592a\u5e73\u6d0b\u6807\u51c6\u65f6\u95f4",
               "PST",
               "\u5317\u7f8e\u592a\u5e73\u6d0b\u590f\u4ee4\u65f6\u95f4",
               "PDT",
               "\u5317\u7f8e\u592a\u5e73\u6d0b\u65f6\u95f4",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u83f2\u5c3c\u514b\u65af\u7fa4\u5c9b\u65f6\u95f4",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u571f\u5e93\u66fc\u65af\u5766\u6807\u51c6\u65f6\u95f4",
               "TMT",
               "\u571f\u5e93\u66fc\u65af\u5766\u590f\u4ee4\u65f6\u95f4",
               "TMST",
               "\u571f\u5e93\u66fc\u65af\u5766\u65f6\u95f4",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u897f\u6b27\u6807\u51c6\u65f6\u95f4",
               "WET",
               "\u897f\u6b27\u590f\u4ee4\u65f6\u95f4",
               "WEST",
               "\u897f\u6b27\u65f6\u95f4",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u4f5b\u5f97\u89d2\u6807\u51c6\u65f6\u95f4",
               "CVT",
               "\u4f5b\u5f97\u89d2\u590f\u4ee4\u65f6\u95f4",
               "CVST",
               "\u4f5b\u5f97\u89d2\u65f6\u95f4",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u8bfa\u798f\u514b\u5c9b\u65f6\u95f4",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u572d\u4e9a\u90a3\u65f6\u95f4",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u76ae\u7279\u51ef\u6069\u65f6\u95f4",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u7f57\u745f\u62c9\u65f6\u95f4",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u8428\u6469\u4e9a\u6807\u51c6\u65f6\u95f4",
               "SST",
               "\u8428\u6469\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "SDT",
               "\u8428\u6469\u4e9a\u65f6\u95f4",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u5e15\u52b3\u65f6\u95f4",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u8fdc\u4e1c\u6807\u51c6\u65f6\u95f4",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u963f\u585e\u62dc\u7586\u6807\u51c6\u65f6\u95f4",
               "AZT",
               "\u963f\u585e\u62dc\u7586\u590f\u4ee4\u65f6\u95f4",
               "AZST",
               "\u963f\u585e\u62dc\u7586\u65f6\u95f4",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u83ab\u68ee\u65f6\u95f4",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u58a8\u897f\u54e5\u592a\u5e73\u6d0b\u6807\u51c6\u65f6\u95f4",
               "MST",
               "\u58a8\u897f\u54e5\u592a\u5e73\u6d0b\u590f\u4ee4\u65f6\u95f4",
               "MDT",
               "\u58a8\u897f\u54e5\u592a\u5e73\u6d0b\u65f6\u95f4",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u6234\u7ef4\u65af\u65f6\u95f4",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u53e4\u5df4\u6807\u51c6\u65f6\u95f4",
               "CST",
               "\u53e4\u5df4\u590f\u4ee4\u65f6\u95f4",
               "CDT",
               "\u53e4\u5df4\u65f6\u95f4",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u897f\u90e8\u975e\u6d32\u6807\u51c6\u65f6\u95f4",
               "CAT",
               "\u897f\u90e8\u975e\u6d32\u590f\u4ee4\u65f6\u95f4",
               "CAST",
               "\u897f\u90e8\u975e\u6d32\u65f6\u95f4",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u683c\u6797\u5c3c\u6cbb\u6807\u51c6\u65f6\u95f4",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u83f2\u5f8b\u5bbe\u6807\u51c6\u65f6\u95f4",
               "PHT",
               "\u83f2\u5f8b\u5bbe\u590f\u4ee4\u65f6\u95f4",
               "PHST",
               "\u83f2\u5f8b\u5bbe\u65f6\u95f4",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u6cd5\u5c5e\u5357\u65b9\u548c\u5357\u6781\u9886\u5730\u65f6\u95f4",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u5357\u4e54\u6cbb\u4e9a\u5c9b\u65f6\u95f4",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u65b0\u5580\u91cc\u591a\u5c3c\u4e9a\u6807\u51c6\u65f6\u95f4",
               "NCT",
               "\u65b0\u5580\u91cc\u591a\u5c3c\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "NCST",
               "\u65b0\u5580\u91cc\u591a\u5c3c\u4e9a\u65f6\u95f4",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u6587\u83b1\u8fbe\u9c81\u8428\u5170\u65f6\u95f4",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u4f0a\u6717\u6807\u51c6\u65f6\u95f4",
               "IRST",
               "\u4f0a\u6717\u590f\u4ee4\u65f6\u95f4",
               "IRDT",
               "\u4f0a\u6717\u65f6\u95f4",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u590d\u6d3b\u8282\u5c9b\u6807\u51c6\u65f6\u95f4",
               "EAST",
               "\u590d\u6d3b\u8282\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "EASST",
               "\u590d\u6d3b\u8282\u5c9b\u65f6\u95f4",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u58a8\u897f\u54e5\u897f\u5317\u90e8\u6807\u51c6\u65f6\u95f4",
               "PST",
               "\u58a8\u897f\u54e5\u897f\u5317\u90e8\u590f\u4ee4\u65f6\u95f4",
               "PDT",
               "\u58a8\u897f\u54e5\u897f\u5317\u90e8\u65f6\u95f4",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u8fea\u8499\u8fea\u5c14\u7ef4\u5c14\u65f6\u95f4",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u5854\u5409\u514b\u65af\u5766\u65f6\u95f4",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u6c64\u52a0\u6807\u51c6\u65f6\u95f4",
               "TOT",
               "\u6c64\u52a0\u590f\u4ee4\u65f6\u95f4",
               "TOST",
               "\u6c64\u52a0\u65f6\u95f4",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u5b5f\u52a0\u62c9\u6807\u51c6\u65f6\u95f4",
               "BDT",
               "\u5b5f\u52a0\u62c9\u590f\u4ee4\u65f6\u95f4",
               "BDST",
               "\u5b5f\u52a0\u62c9\u65f6\u95f4",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u79d8\u9c81\u6807\u51c6\u65f6\u95f4",
               "PET",
               "\u79d8\u9c81\u590f\u4ee4\u65f6\u95f4",
               "PEST",
               "\u79d8\u9c81\u65f6\u95f4",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u683c\u9675\u5170\u5c9b\u897f\u90e8\u6807\u51c6\u65f6\u95f4",
               "WGT",
               "\u683c\u9675\u5170\u5c9b\u897f\u90e8\u590f\u4ee4\u65f6\u95f4",
               "WGST",
               "\u683c\u9675\u5170\u5c9b\u897f\u90e8\u65f6\u95f4",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u5384\u74dc\u591a\u5c14\u65f6\u95f4",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u683c\u9675\u5170\u5c9b\u4e1c\u90e8\u6807\u51c6\u65f6\u95f4",
               "EGT",
               "\u683c\u9675\u5170\u5c9b\u4e1c\u90e8\u590f\u4ee4\u65f6\u95f4",
               "EGST",
               "\u683c\u9675\u5170\u5c9b\u4e1c\u90e8\u65f6\u95f4",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u6d77\u6e7e\u6807\u51c6\u65f6\u95f4",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u5370\u5ea6\u5c3c\u897f\u4e9a\u4e1c\u90e8\u65f6\u95f4",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u97e9\u56fd\u6807\u51c6\u65f6\u95f4",
               "KST",
               "\u97e9\u56fd\u590f\u4ee4\u65f6\u95f4",
               "KDT",
               "\u97e9\u56fd\u65f6\u95f4",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u6fb3\u5927\u5229\u4e9a\u897f\u90e8\u6807\u51c6\u65f6\u95f4",
               "AWST",
               "\u6fb3\u5927\u5229\u4e9a\u897f\u90e8\u590f\u4ee4\u65f6\u95f4",
               "AWDT",
               "\u6fb3\u5927\u5229\u4e9a\u897f\u90e8\u65f6\u95f4",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u5409\u5c14\u5409\u65af\u65af\u5766\u65f6\u95f4",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u5370\u5ea6\u5c3c\u897f\u4e9a\u897f\u90e8\u65f6\u95f4",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u6fb3\u5927\u5229\u4e9a\u4e1c\u90e8\u6807\u51c6\u65f6\u95f4",
               "AEST",
               "\u6fb3\u5927\u5229\u4e9a\u4e1c\u90e8\u590f\u4ee4\u65f6\u95f4",
               "AEDT",
               "\u6fb3\u5927\u5229\u4e9a\u4e1c\u90e8\u65f6\u95f4",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u6cd5\u5c5e\u572d\u4e9a\u90a3\u65f6\u95f4",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u54e5\u4f26\u6bd4\u4e9a\u6807\u51c6\u65f6\u95f4",
               "COT",
               "\u54e5\u4f26\u6bd4\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "COST",
               "\u54e5\u4f26\u6bd4\u4e9a\u65f6\u95f4",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u667a\u5229\u6807\u51c6\u65f6\u95f4",
               "CLT",
               "\u667a\u5229\u590f\u4ee4\u65f6\u95f4",
               "CLST",
               "\u667a\u5229\u65f6\u95f4",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u5409\u5c14\u4f2f\u7279\u7fa4\u5c9b\u65f6\u95f4",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u5317\u7f8e\u5c71\u533a\u6807\u51c6\u65f6\u95f4",
               "MST",
               "\u5317\u7f8e\u5c71\u533a\u590f\u4ee4\u65f6\u95f4",
               "MDT",
               "\u5317\u7f8e\u5c71\u533a\u65f6\u95f4",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u9a6c\u514b\u8428\u65af\u7fa4\u5c9b\u65f6\u95f4",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u963f\u62c9\u4f2f\u6807\u51c6\u65f6\u95f4",
               "AST",
               "\u963f\u62c9\u4f2f\u590f\u4ee4\u65f6\u95f4",
               "ADT",
               "\u963f\u62c9\u4f2f\u65f6\u95f4",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u963f\u62c9\u65af\u52a0\u6807\u51c6\u65f6\u95f4",
               "AKST",
               "\u963f\u62c9\u65af\u52a0\u590f\u4ee4\u65f6\u95f4",
               "AKDT",
               "\u963f\u62c9\u65af\u52a0\u65f6\u95f4",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u6d77\u53c2\u5d34\u6807\u51c6\u65f6\u95f4",
               "VLAT",
               "\u6d77\u53c2\u5d34\u590f\u4ee4\u65f6\u95f4",
               "VLAST",
               "\u6d77\u53c2\u5d34\u65f6\u95f4",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u67e5\u83ab\u7f57\u65f6\u95f4",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u4f0a\u5c14\u5e93\u8328\u514b\u6807\u51c6\u65f6\u95f4",
               "IRKT",
               "\u4f0a\u5c14\u5e93\u8328\u514b\u590f\u4ee4\u65f6\u95f4",
               "IRKST",
               "\u4f0a\u5c14\u5e93\u8328\u514b\u65f6\u95f4",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u683c\u9c81\u5409\u4e9a\u6807\u51c6\u65f6\u95f4",
               "GET",
               "\u683c\u9c81\u5409\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "GEST",
               "\u683c\u9c81\u5409\u4e9a\u65f6\u95f4",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u6258\u514b\u52b3\u65f6\u95f4",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u5df4\u5e03\u4e9a\u65b0\u51e0\u5185\u4e9a\u65f6\u95f4",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u8d39\u5c14\u5357\u591a-\u8fea\u8bfa\u7f57\u5c3c\u4e9a\u5c9b\u6807\u51c6\u65f6\u95f4",
               "FNT",
               "\u8d39\u5c14\u5357\u591a-\u8fea\u8bfa\u7f57\u5c3c\u4e9a\u5c9b\u590f\u4ee4\u65f6\u95f4",
               "FNST",
               "\u8d39\u5c14\u5357\u591a-\u8fea\u8bfa\u7f57\u5c3c\u4e9a\u5c9b\u65f6\u95f4",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u4e54\u5df4\u5c71\u6807\u51c6\u65f6\u95f4",
               "CHOT",
               "\u4e54\u5df4\u5c71\u590f\u4ee4\u65f6\u95f4",
               "CHOST",
               "\u4e54\u5df4\u5c71\u65f6\u95f4",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u5df4\u897f\u5229\u4e9a\u6807\u51c6\u65f6\u95f4",
               "BRT",
               "\u5df4\u897f\u5229\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "BRST",
               "\u5df4\u897f\u5229\u4e9a\u65f6\u95f4",
               "BRT",
            };
        final String[] China = new String[] {
               "\u4e2d\u56fd\u6807\u51c6\u65f6\u95f4",
               "CST",
               "\u4e2d\u56fd\u590f\u4ee4\u65f6\u95f4",
               "CDT",
               "\u4e2d\u56fd\u65f6\u95f4",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u4e9a\u7f8e\u5c3c\u4e9a\u6807\u51c6\u65f6\u95f4",
               "AMT",
               "\u4e9a\u7f8e\u5c3c\u4e9a\u590f\u4ee4\u65f6\u95f4",
               "AMST",
               "\u4e9a\u7f8e\u5c3c\u4e9a\u65f6\u95f4",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u8428\u9a6c\u62c9\u6807\u51c6\u65f6\u95f4",
               "SAMT",
               "\u8428\u9a6c\u62c9\u590f\u4ee4\u65f6\u95f4",
               "SAMST",
               "\u8428\u9a6c\u62c9\u65f6\u95f4",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u5370\u5ea6\u65f6\u95f4",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u5e93\u514b\u7fa4\u5c9b\u6807\u51c6\u65f6\u95f4",
               "CKT",
               "\u5e93\u514b\u7fa4\u5c9b\u4ef2\u590f\u65f6\u95f4",
               "CKHST",
               "\u5e93\u514b\u7fa4\u5c9b\u65f6\u95f4",
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
                    "\u683c\u6797\u5c3c\u6cbb\u6807\u51c6\u65f6\u95f4",
                    "GMT",
                    "\u82f1\u56fd\u590f\u4ee4\u65f6\u95f4",
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
                    "\u683c\u6797\u5c3c\u6cbb\u6807\u51c6\u65f6\u95f4",
                    "GMT",
                    "\u7231\u5c14\u5170\u6807\u51c6\u65f6\u95f4",
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
