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

public class TimeZoneNames_ks extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u0645\u0631\u06a9\u0632\u06cc \u0627\u0641\u0631\u06cc\u0656\u0642\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u0645\u0627\u0633\u06a9\u0648 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "MSK",
               "\u0645\u0627\u0633\u06a9\u0648 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "MSD",
               "\u0645\u0627\u0633\u06a9\u064e\u0648 \u0679\u0627\u06cc\u0650\u0645",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u062c\u0627\u067e\u0672\u0646\u06cd \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "JST",
               "\u062c\u0627\u067e\u0672\u0646\u06cd \u0691\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "JDT",
               "\u062c\u0627\u067e\u0672\u0646\u06cd \u0679\u0627\u06cc\u0650\u0645",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u067e\u0627\u06a9\u0650\u0633\u062a\u0627\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PKT",
               "\u067e\u0627\u06a9\u0650\u0633\u062a\u0627\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "PKST",
               "\u067e\u0627\u06a9\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "PKT",
            };
        final String[] Hovd = new String[] {
               "\u062d\u0648\u0648\u0691 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "HOVT",
               "\u062d\u0648\u0648\u0691 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "HOVST",
               "\u062d\u0648\u0648\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u0645\u064e\u06af\u064e\u062f\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "MAGT",
               "\u0645\u064e\u06af\u064e\u062f\u064e\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "MAGST",
               "\u0645\u064e\u06af\u064e\u062f\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0631\u06a9\u0632\u06cc \u0645\u063a\u0631\u0628\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ACWST",
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0631\u06a9\u0632\u06cc \u0645\u063a\u0631\u0628\u06cc \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "ACWDT",
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0631\u06a9\u0632\u06cc \u0645\u063a\u0631\u0628\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u0645\u0631\u06a9\u0632\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CET",
               "\u0645\u0631\u06a9\u0632\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CEST",
               "\u0645\u0631\u06a9\u0632\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u0633\u064e\u06a9\u06be\u066e\u06ea\u0644\u0650\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "SAKT",
               "\u0633\u064e\u06a9\u06be\u066e\u06ea\u0644\u0650\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "SAKST",
               "\u0633\u064e\u06a9\u06be\u066e\u06ea\u0644\u0650\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u067e\u06cc\u0631\u066e\u06ea\u06af\u0648\u06d2 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PYT",
               "\u067e\u06cc\u0631\u066e\u06ea\u06af\u0648\u06d2 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "PYST",
               "\u067e\u06cc\u0631\u066e\u06ea\u06af\u0648\u06d2 \u0679\u0627\u06cc\u0650\u0645",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u0627\u066e\u06ea\u06a9\u0631\u06d2 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ACT",
               "\u0627\u066e\u06ea\u06a9\u0631\u06d2 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "ACST",
               "\u0627\u066e\u06ea\u06a9\u0631\u06d2 \u0679\u0627\u06cc\u0650\u0645",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u0645\u064e\u0644\u06cc\u0634\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u0645\u0634\u0631\u0642\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "EST",
               "\u0645\u0634\u0631\u0642\u06cc \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "EDT",
               "\u0645\u0634\u0631\u0642\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u0644\u0639\u0627\u0691 \u062d\u0648\u0648\u06d2 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "LHST",
               "\u0644\u0639\u0627\u0691 \u0691\u06d2\u0644\u0627\u06cc\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "LHDT",
               "\u0644\u0639\u0627\u0691 \u062d\u0648\u0648\u06d2 \u0679\u0627\u06cc\u0650\u0645",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u0646\u0650\u0648\u0632\u0650\u0644\u06cc\u0646\u0691 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NZST",
               "\u0646\u0650\u0648\u0632\u0650\u0644\u06cc\u0646\u0691 \u0691\u06d2\u0644\u0627\u06cc\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "NZDT",
               "\u0646\u0650\u0648\u0632\u0650\u0644\u06cc\u0646\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u06c1\u0650\u0646\u062f\u0648\u0633\u062a\u0672\u0646\u06cd \u0627\u0648\u0634\u064e\u0646 \u0679\u0627\u06cc\u0650\u0646",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u06cc\u064e\u06a9\u064f\u0679\u0633\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "YAKT",
               "\u06cc\u064e\u06a9\u064f\u0679\u064f\u0633\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "YAKST",
               "\u06cc\u064e\u06a9\u064f\u0679\u0633\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u0645\u0648\u0631\u0650\u0634\u064e\u0633 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "MUT",
               "\u0645\u0648\u0631\u0650\u0634\u064e\u0633 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "MUST",
               "\u0645\u0648\u0631\u0650\u0634\u064e\u0633 \u0679\u0627\u06cc\u0650\u0645",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u0645\u0634\u0631\u0642\u06cc \u0627\u0641\u0631\u06cc\u0656\u0642\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u0627\u06cc\u0656\u0633\u0679 \u0679\u06cc\u0656\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u0633\u0648\u0644\u0648\u0645\u064e\u0646 \u062c\u062c\u06cc\u0656\u0631\u064e\u0646 \u06c1\u064f\u0646\u065b\u062f \u0679\u0627\u06cc\u0650\u0645",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u06a9\u0648\u0631\u0633\u064e\u06d2 \u0679\u0627\u06cc\u0650\u0645",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u0645\u0627\u0631\u0634\u064e\u0644 \u062c\u062c\u06cc\u0656\u0631\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u0645\u0634\u0631\u0642\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "EET",
               "\u0645\u0634\u0631\u0642\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "EEST",
               "\u0645\u0634\u0631\u0642\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u0646\u06cc\u0648\u0657 \u0641\u0627\u0648\u0646\u0691\u0644\u06cc\u0646\u0691 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NST",
               "\u0646\u06cc\u0648\u0657 \u0641\u0627\u0648\u0646\u0691 \u0644\u06cc\u0646\u0691 \u0691\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "NDT",
               "\u0646\u06cc\u0648\u0657 \u0641\u0627\u0648\u0646\u0691\u0644\u06cc\u0646\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u0627\u0641\u063a\u0627\u0646\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u062d\u0627\u0646\u06af \u06a9\u0627\u0646\u065b\u06af \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "HKT",
               "\u062d\u0627\u0646\u065b\u06af \u06a9\u0627\u0646\u065b\u06af \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "HKST",
               "\u062d\u0627\u0646\u06af \u06a9\u0627\u0646\u065b\u06af \u0679\u0627\u06cc\u0650\u0645",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ART",
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "ARST",
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u0627\u066e\u06ea\u0679\u0644\u0627\u0646\u0679\u0650\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AST",
               "\u0627\u066e\u06ea\u0679\u0644\u0627\u0646\u0679\u0650\u06a9 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "ADT",
               "\u0627\u066e\u06ea\u0679\u0644\u0627\u0646\u0679\u0650\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u067e\u0648\u0646\u06cc\u067e \u0679\u0627\u06cc\u0650\u0645",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u0628\u0648\u0644\u0650\u0648\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u0633\u06cc\u0646\u065b\u0679 \u067e\u064e\u06cc\u0631\u06cc \u0645\u0650\u0642\u06cc\u0648\u0657\u0644\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PMST",
               "\u0633\u06cc\u0646\u065b\u0679 \u067e\u064e\u06cc\u0631\u06cc \u0645\u0650\u0642\u06cc\u0648\u0657\u0644\u064e\u0646 \u0691\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "PMDT",
               "\u0633\u06cc\u0646\u065b\u0679 \u067e\u064e\u06cc\u0631\u06cc \u0645\u0650\u0642\u06cc\u0648\u0657\u0644\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u0627\u0650\u0646\u0691\u0648\u0686\u064e\u06cc\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u06cc\u066e\u06ea\u06a9\u064e\u0679\u0654\u0631\u0650\u0646\u0628\u0654\u0631\u06af \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "YEKT",
               "\u06cc\u066e\u06ea\u06a9\u064e\u0679\u0631\u0650\u0646\u0628\u0654\u0631\u06af \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "YEKST",
               "\u06cc\u066e\u06ea\u06a9\u064e\u0679\u0654\u0631\u0650\u0646\u0628\u0654\u0631\u06af \u0679\u0627\u06cc\u0650\u0645",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u0645\u0627\u0644\u062f\u06cc\u0656\u0648\u0655\u0632 \u0679\u0627\u06cc\u0650\u0645",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u0679\u0627\u06c1\u0650\u0679\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u0627\u0650\u0633\u0631\u0672\u06cc\u0650\u0644\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "IST",
               "\u0627\u0650\u0633\u0631\u0672\u06cc\u0650\u0644\u06cc \u0691\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "IDT",
               "\u0627\u0650\u0633\u0631\u0672\u06cc\u0650\u0644\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u0645\u0631\u06a9\u0632\u06cc \u0627\u0650\u0646\u0691\u0648\u0646\u06cc\u0634\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u0648\u0627\u0644\u0650\u0633 \u062a\u06c1\u0655 \u0641\u06cc\u0648\u0657\u0679\u06cc\u0648\u0657\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u062c\u0646\u0648\u0657\u0628\u06cc \u0627\u0641\u0631\u06cc\u0642\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u0633\u06cc\u0648\u0648\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u0644\u0627\u06cc\u0650\u0654\u0646 \u062c\u062c\u06cc\u0656\u0631\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u0627\u064f\u0632\u0628\u06cc\u06a9\u0650\u0633\u062a\u0627\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "UZT",
               "\u0627\u064f\u0632\u0628\u06cc\u06a9\u0650\u0633\u062a\u0627\u0646\u064f\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "UZST",
               "\u0627\u064f\u0632\u0628\u06cc\u06a9\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u0627\u06c4\u0645\u0633\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "OMST",
               "\u0627\u06c4\u0645\u0633\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "OMSST",
               "\u0627\u06c4\u0645\u0633\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u0633\u06cc\u0634\u066e\u06ea\u0644\u0655\u0632 \u0679\u0627\u06cc\u0650\u0645",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u06cc\u0648\u0657\u0631\u066e\u06ea\u06af\u0648\u064e\u06d2 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "UYT",
               "\u06cc\u0648\u0657\u0631\u066e\u06ea\u06af\u0648\u064e\u06d2 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "UYST",
               "\u06cc\u0648\u0657\u0631\u066e\u06ea\u06af\u0648\u064e\u06d2 \u0679\u0627\u06cc\u0650\u0645",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u0646\u066e\u06ea\u067e\u0672\u0644\u06cd \u0679\u0627\u06cc\u0650\u0645",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u0645\u0648\u0646\u06af\u0648\u0644\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ULAT",
               "\u0645\u0648\u0646\u06af\u0648\u0644\u0650\u06cc\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "ULAST",
               "\u0645\u0648\u0646\u06af\u0648\u0644\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u0645\u0631\u06a9\u0632\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CST",
               "\u0645\u0631\u06a9\u0632\u06cc \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "CDT",
               "\u0645\u0631\u06a9\u0632\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u0679\u0654\u0631\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u0646\u0650\u06cc\u0648\u0657 \u0679\u0627\u06cc\u0650\u0645",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u0648\u06cc\u06a9 \u062c\u062c\u06cc\u0656\u0631\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u0641\u0627\u06a9\u0644\u06cc\u0646\u0691 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "FKT",
               "\u0641\u0627\u06a9\u0644\u06cc\u0646\u0691 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "FKST",
               "\u0641\u0627\u06a9\u0644\u06cc\u0646\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u0648\u064e\u0646\u0648\u0657\u0627\u064e\u0679\u0648\u0657 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "VUT",
               "\u0648\u064e\u0646\u0648\u0657\u0627\u064e\u0679\u0648\u0657 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "VUST",
               "\u0648\u064e\u0646\u0648\u0657\u0627\u064e\u0679\u0648\u0657 \u0679\u0627\u06cc\u0650\u0645",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u0646\u06c4\u0648\u06c4\u0633\u0650\u0628\u0654\u0631\u0633\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NOVT",
               "\u0646\u06c4\u0648\u06c4\u0633\u0650\u0628\u0654\u0631\u0633\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "NOVST",
               "\u0646\u06c4\u0648\u06c4\u0633\u0650\u0628\u0654\u0631\u0633\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u0633\u0650\u0646\u065b\u06af\u0627\u067e\u0648\u0657\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u0627\u066e\u06ea\u0632\u0648\u0631\u0655\u0633 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AZOT",
               "\u0627\u066e\u06ea\u0632\u0648\u0631\u0655\u0633 \u0633\u064e\u0645\u064e\u0631 \u0679",
               "AZOST",
               "\u0627\u066e\u06ea\u0632\u0648\u0631\u0655\u0633 \u0679\u0627\u06cc\u0650\u0645",
               "AZOT",
            };
        final String[] Bhutan = new String[] {
               "\u0628\u0648\u0657\u0679\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u0633\u064f\u0631\u0650\u0646\u0627\u0645 \u0679\u0627\u06cc\u0650\u0645",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u0646\u064e\u0639\u0648\u0657\u0631\u0648\u0657 \u0679\u0627\u06cc\u0650\u0645",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u06a9\u0631\u066e\u06ea\u0633\u0646\u0648\u06d2\u06cc\u0627\u0631\u0633\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "KRAT",
               "\u06a9\u0631\u066e\u06ea\u0633\u0646\u0648\u06d2\u06cc\u0627\u0631\u0633\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "KRAST",
               "\u06a9\u0631\u066e\u06ea\u0633\u0646\u0648\u06d2\u06cc\u0627\u0631\u0633\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06a9\u064e\u0632\u0627\u06a9\u06be\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u0645\u0650\u06cc\u0627\u0646\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u06a9\u0631\u065b\u0633\u0645\u064e\u0633 \u0679\u0627\u06cc\u0650\u0645",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u0627\u066e\u06ea\u0645\u064e\u0632\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AMT",
               "\u0627\u066e\u06ea\u0645\u064e\u0632\u064e\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "AMST",
               "\u0627\u066e\u06ea\u0645\u064e\u0632\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u06a9\u064e\u0632\u0627\u06a9\u06be\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u0641\u06cc\u0656\u062c\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "FJT",
               "\u0641\u06cc\u0656\u062c\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "FJST",
               "\u0641\u06cc\u0656\u062c\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u0631\u0650\u06cc\u0648\u0657\u0646\u0650\u06cc\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u06a9\u0648\u06a9\u0648\u0632 \u0627\u064e\u06cc\u0644\u06cc\u0646\u0691\u0632 \u0679\u0627\u06cc\u0650\u0645",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u06a9\u066e\u06ea\u062a\u06be\u064e\u0645 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CHAST",
               "\u0686\u066e\u06ea\u062a\u06be\u064e\u0645 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CHADT",
               "\u06a9\u066e\u06ea\u062a\u06be\u064e\u0645 \u0679\u0627\u06cc\u0650\u0645",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u0648\u0648\u0633\u0679\u0648\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ART",
               "\u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "ARST",
               "\u0627\u0631\u062c\u066e\u06ea\u0646\u0679\u06cc\u0656\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u06af\u066e\u06ea\u0645\u0628\u0650\u06cc\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u06a9\u064e\u0645\u0686\u064e\u0679\u06a9\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PETT",
               "\u06a9\u064e\u0645\u0686\u064e\u0679\u06a9\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "PETST",
               "\u06a9\u064e\u0645\u0686\u064e\u0679\u06a9\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u0679\u0648\u0657\u0648\u064e\u0644\u0648\u0657 \u0679\u0627\u06cc\u0650\u0645",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u06af\u066e\u06ea\u0644\u066e\u06ea\u067e\u06cc\u065a\u06af\u0648\u0632 \u0679\u0627\u06cc\u0650\u0645",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Venezuela = new String[] {
               "\u0648\u066e\u06ea\u0646\u066e\u06ea\u0632\u06cc\u0648\u0657\u0644\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u062d\u064e\u0648\u0627\u06d2 \u0627\u066e\u06ea\u0644\u06cc\u0648\u0657\u0679\u0650\u06cc\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "HAST",
               "\u062d\u064e\u0648\u0627\u06d2 \u0627\u066e\u06ea\u0644\u06cc\u0648\u0657\u0679\u0650\u06cc\u064e\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "HADT",
               "\u062d\u064e\u0648\u0627\u06d2 \u0627\u066e\u06ea\u0644\u06cc\u0648\u0657\u0679\u0650\u06cc\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0631\u06a9\u0632\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ACST",
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0631\u06a9\u0632\u06cc \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "ACDT",
               "\u0645\u0631\u06a9\u0632\u06cc \u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u067e\u06cc\u0633\u0650\u0641\u0650\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PST",
               "\u067e\u06cc\u0633\u0650\u0641\u0650\u06a9 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "PDT",
               "\u067e\u06cc\u0633\u0650\u0641\u0650\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u067e\u06be\u0648\u0646\u0650\u06a9\u0633 \u062c\u062c\u06cc\u0656\u0631\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u062a\u064f\u0631\u06a9\u0645\u066e\u06ea\u0646\u0650\u0633\u062a\u0627\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "TMT",
               "\u062a\u064f\u0631\u06a9\u0645\u066e\u06ea\u0646\u0650\u0633\u062a\u0627\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "TMST",
               "\u062a\u064f\u0631\u06a9\u0645\u066e\u06ea\u0646\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "WET",
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06cc\u0648\u0657\u0631\u0650\u067e\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "WEST",
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06cc\u0648\u0657\u0631\u067e\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u06a9\u06cc\u067e \u0624\u0631\u0691\u0648 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CVT",
               "\u06a9\u06cc\u067e \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CVST",
               "\u06a9\u06cc\u067e \u0624\u0631\u0691\u0648 \u0679\u0627\u06cc\u0650\u0645",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u0646\u0648\u0631\u0641\u0639\u0627\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u06af\u064f\u06cc\u064e\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u067e\u0650\u0679\u06a9\u06cc\u0631\u0655\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u0631\u0648\u062a\u06be\u066e\u06ea\u0631\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u0633\u066e\u06ea\u0645\u0648\u0622 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "SST",
               "\u0633\u066e\u06ea\u0645\u0648\u0622 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "SDT",
               "\u0633\u066e\u06ea\u0645\u0648\u0622 \u0679\u0627\u06cc\u0650\u0645",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u067e\u064e\u0644\u0627\u0648 \u0679\u0627\u06cc\u0650\u0645",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Azerbaijan = new String[] {
               "\u0627\u064e\u0632\u064e\u0631\u0628\u06cc\u062c\u0627\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AZT",
               "\u0627\u064e\u0632\u064e\u0631\u0628\u06cc\u062c\u0627\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "AZST",
               "\u0627\u064e\u0632\u064e\u0631\u0628\u06cc\u062c\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u0645\u0627\u0633\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Davis = new String[] {
               "\u0691\u06cc\u0648\u0650\u0633 \u0679\u0627\u06cc\u0650\u0645",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u06a9\u06cc\u0648\u0657\u0628\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CST",
               "\u06a9\u06cc\u0648\u0657\u0628\u0627 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "CDT",
               "\u06a9\u06cc\u0648\u0657\u0628\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0641\u0631\u06cc\u0656\u0642\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CAT",
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0641\u0631\u06cc\u0656\u0642\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CAST",
               "\u0645\u063a\u0631\u0628\u06cc \u0627\u0641\u0631\u06cc\u0656\u0642\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u06af\u0631\u065b\u06cc\u0656\u0646 \u0648\u0650\u0686 \u0645\u06cc\u0656\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u067e\u06be\u0650\u0644\u0650\u067e\u0627\u06cc\u0650\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PHT",
               "\u067e\u06be\u0650\u0644\u0650\u067e\u0627\u06cc\u0650\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "PHST",
               "\u067e\u06be\u0650\u0644\u0650\u067e\u0627\u06cc\u0650\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u062c\u0646\u0648\u0657\u0628\u06cc \u0641\u0631\u066e\u06ea\u0646\u065b\u0686 \u0679\u0627\u06cc\u0650\u0645",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u0634\u064f\u0645\u0672\u0644\u06cc \u062c\u0648\u0631\u062c\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u0646\u0650\u0648 \u06a9\u06cc\u0644\u066e\u06ea\u0691\u0648\u0646\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "NCT",
               "\u0646\u0650\u0648 \u06a9\u06cc\u0644\u066e\u06ea\u0691\u0648\u0646\u0650\u06cc\u0633 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "NCST",
               "\u0646\u0650\u0648 \u06a9\u06cc\u0644\u066e\u06ea\u0691\u0648\u0646\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u0628\u0631\u065b\u0648\u0657\u0646\u064e\u06d2 \u062f\u064e\u0631\u0648\u0657\u0633\u064e\u0644\u064e\u0645 \u0679\u0627\u06cc\u0650\u0645",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u0627\u0650\u06cc\u0656\u0631\u0672\u0646\u06cd \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "IRST",
               "\u0627\u0650\u06cc\u0656\u0631\u0672\u0646\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "IRDT",
               "\u0627\u0650\u06cc\u0656\u0631\u0672\u0646\u06cd \u0679\u0627\u06cc\u0650\u0645",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u0627\u06cc\u0656\u0633\u0679\u064e\u0631 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "EAST",
               "\u0627\u06cc\u0656\u0633\u0679\u064e\u0631 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "EASST",
               "\u0627\u06cc\u0656\u0633\u0679\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "EAST",
            };
        final String[] DumontDUrville = new String[] {
               "\u0691\u0645\u0627\u0646\u0679 \u0688\u06cc \u0627\u064f\u0631\u0648\u06cc\u0656\u0644 \u0679\u0627\u06cc\u0650\u0645",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u062a\u0627\u0632\u0650\u06a9\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u0679\u0639\u0627\u0646\u065b\u06af\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "TOT",
               "\u0679\u0639\u0627\u0646\u065b\u06af\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "TOST",
               "\u0679\u0639\u0627\u0646\u065b\u06af\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u0628\u064e\u0646\u065b\u06af\u0644\u0627\u062f\u06cc\u0634 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "BDT",
               "\u0628\u064e\u0646\u065b\u06af\u0644\u0627\u062f\u06cc\u0634 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "BDST",
               "\u0628\u064e\u0646\u065b\u06af\u0644\u0627\u062f\u06cc\u0634 \u0679\u0627\u06cc\u0650\u0645",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u067e\u0654\u0631\u0648\u0657 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "PET",
               "\u067e\u0654\u0631\u0648\u0657 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "PEST",
               "\u067e\u0654\u0631\u0648\u0657 \u0679\u0627\u06cc\u0650\u0645",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "WGT",
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "WGST",
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u0627\u0650\u06a9\u0648\u06cc\u0691\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "EGT",
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "EGST",
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u06af\u0631\u06cc\u0656\u0646 \u0644\u06cc\u0646\u0691\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u06af\u064e\u0644\u0641 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u0627\u0650\u0646\u0691\u0648\u0646\u06cc\u0634\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u06a9\u0648\u0631\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "KST",
               "\u06a9\u0648\u0631\u0650\u06cc\u0627 \u0691\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "KDT",
               "\u06a9\u0648\u0631\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u063a\u0631\u0650\u0628\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AWST",
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u063a\u0631\u0650\u0628\u06cc\u0656 \u0688\u06d2\u0644\u0627\u06cc\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "AWDT",
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u06a9\u0650\u0631\u06af\u0650\u0633\u062a\u0627\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u0645\u063a\u0631\u0650\u0628\u06cc \u0627\u0650\u0646\u0691\u0648\u0646\u06cc\u0634\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0634\u0631\u0642\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AEST",
               "\u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u064e\u0646 \u0645\u0634\u0631\u0642\u06cc \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "AEDT",
               "\u0645\u0634\u0631\u0650\u0642\u06cc \u0622\u0633\u0679\u0631\u06cc\u0644\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u0641\u0631\u065b\u066e\u06ea\u0646\u065b\u0686 \u06af\u06cc\u0648\u0657\u066e\u06ea\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u06a9\u0648\u0644\u0648\u0645\u0628\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "COT",
               "\u06a9\u0648\u0644\u0648\u0645\u0628\u0650\u06cc\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "COST",
               "\u06a9\u0648\u0644\u0648\u0645\u0628\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u0686\u0650\u0644\u06cc \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CLT",
               "\u0686\u0650\u0644\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CLST",
               "\u0686\u0650\u0644\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u06af\u0650\u0644\u0628\u0672\u0679 \u062c\u062c\u06cc\u0656\u0631\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u0645\u0627\u0648\u0646\u0679\u06cc\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "MST",
               "\u0645\u0627\u0648\u0646\u0679\u06cc\u0646 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "MDT",
               "\u0645\u0627\u0648\u0646\u0679\u06cc\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u0645\u0627\u0631\u0642\u06cc\u0648\u0657\u0633\u064e\u0633 \u0679\u0627\u06cc\u0650\u0645",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u0627\u0631\u066e\u06ea\u0628\u0650\u06cc\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AST",
               "\u0627\u0631\u066e\u06ea\u0628\u0650\u06cc\u064e\u0646 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "ADT",
               "\u0627\u0631\u066e\u06ea\u0628\u0650\u06cc\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u0627\u066e\u06ea\u0644\u0627\u0633\u06a9\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AKST",
               "\u0627\u066e\u06ea\u0644\u0627\u0633\u06a9\u0627 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "AKDT",
               "\u0627\u066e\u06ea\u0644\u0627\u0633\u06a9\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u0648\u0644\u0627\u0691\u0650\u0648\u0648\u0633\u0679\u0648\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "VLAT",
               "\u0648\u0644\u0627\u0691\u0650\u0648\u0648\u0633\u0679\u0648\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "VLAST",
               "\u0648\u0644\u0627\u0691\u0650\u0648\u0648\u0633\u0679\u0648\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u06a9\u066e\u06ea\u0645\u0648\u0631\u0648 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u0627\u0650\u0631\u06a9\u064f\u0679\u0633\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "IRKT",
               "\u0627\u0650\u0631\u06a9\u064f\u0679\u0633\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "IRKST",
               "\u0627\u0650\u0631\u06a9\u064f\u0679\u0633\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u062c\u0648\u0631\u062c\u0650\u06cc\u0627\u06c1\u064f\u06a9 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "GET",
               "\u062c\u0648\u0631\u062c\u0650\u06cc\u0627\u06c1\u064f\u06a9 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "GEST",
               "\u062c\u0648\u0631\u062c\u0650\u06cc\u0627\u06c1\u064f\u06a9 \u0679\u0627\u06cc\u0650\u0645",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u0679\u0648\u06a9\u066e\u06ea\u0644\u0648 \u0679\u0627\u06cc\u0650\u0645",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u067e\u0627\u067e\u064f\u0639\u0627 \u0646\u06cc\u0648\u0657 \u06af\u066e\u06ea\u0646\u06cc \u0679\u0627\u06cc\u0650\u0645",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u0646\u0648\u0631\u0648\u0646\u06c1\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "FNT",
               "\u0646\u0648\u0631\u0648\u0646\u06c1\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "FNST",
               "\u0646\u0648\u0631\u0648\u0646\u06c1\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u06a9\u0648\u06d2\u0628\u066e\u06ea\u0644\u0633\u064e\u0646 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CHOT",
               "\u06a9\u0648\u06d2\u0628\u066e\u06ea\u0644\u0633\u064e\u0646 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CHOST",
               "\u06a9\u0648\u06d2\u0628\u066e\u06ea\u0644\u0633\u064e\u0646 \u0679\u0627\u06cc\u0650\u0645",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u0628\u0631\u066e\u06ea\u0633\u0650\u0644\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "BRT",
               "\u0628\u0631\u066e\u06ea\u0633\u0650\u0644\u0650\u06cc\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "BRST",
               "\u0628\u0631\u066e\u06ea\u0633\u0650\u0644\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "BRT",
            };
        final String[] China = new String[] {
               "\u0686\u064e\u06cc\u0646\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CST",
               "\u0686\u064e\u06cc\u0646\u0627 \u0688\u06d2\u0644\u0627\u06cc\u0650\u0654\u0679 \u0679\u0627\u06cc\u0650\u0645",
               "CDT",
               "\u0686\u064e\u06cc\u0646\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u0627\u0631\u0645\u06cc\u0656\u0646\u0650\u06cc\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "AMT",
               "\u0627\u0631\u0645\u06cc\u0656\u0646\u0650\u06cc\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "AMST",
               "\u0627\u0631\u0645\u06cc\u0656\u0646\u0650\u06cc\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u0633\u0645\u066e\u06ea\u0631\u0627 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "SAMT",
               "\u0633\u0645\u066e\u06ea\u0631\u0627 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "SAMST",
               "\u0633\u0645\u066e\u06ea\u0631\u0627 \u0679\u0627\u06cc\u0650\u0645",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u06c1\u0650\u0646\u065b\u062f\u0648\u0633\u062a\u0627\u0646",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u06a9\u064f\u06a9 \u0627\u064e\u06cc\u0644\u06cc\u0646\u0691\u0632 \u0633\u0679\u06cc\u0646\u0691\u0627\u0691 \u0679\u0627\u06cc\u0650\u0645",
               "CKT",
               "\u06a9\u064f\u06a9 \u0627\u064e\u06cc\u0644\u06cc\u0646\u0691\u0632 \u062d\u0627\u0641 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
               "CKHST",
               "\u06a9\u064f\u06a9 \u0627\u064e\u06cc\u0644\u06cc\u0646\u0691\u0632 \u0679\u0627\u06cc\u0650\u0645",
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
                    "\u06af\u0631\u065b\u06cc\u0656\u0646 \u0648\u0650\u0686 \u0645\u06cc\u0656\u0646 \u0679\u0627\u06cc\u0650\u0645",
                    "GMT",
                    "\u0628\u0631\u0637\u0672\u0646\u0648\u06cc \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
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
            { "Pacific/Niue", Niue },
            { "Australia/Lord_Howe", Lord_Howe },
            { "Europe/Dublin",
                new String[] {
                    "\u06af\u0631\u065b\u06cc\u0656\u0646 \u0648\u0650\u0686 \u0645\u06cc\u0656\u0646 \u0679\u0627\u06cc\u0650\u0645",
                    "GMT",
                    "\u0627\u064e\u06cc\u0631\u0650\u0634 \u0633\u064e\u0645\u064e\u0631 \u0679\u0627\u06cc\u0650\u0645",
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
