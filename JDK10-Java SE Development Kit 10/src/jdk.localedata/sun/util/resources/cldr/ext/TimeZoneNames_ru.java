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

public class TimeZoneNames_ru extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u041c\u043e\u0441\u043a\u0432\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MSK",
               "\u041c\u043e\u0441\u043a\u0432\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MSD",
               "\u041c\u043e\u0441\u043a\u0432\u0430",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u042f\u043f\u043e\u043d\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "JST",
               "\u042f\u043f\u043e\u043d\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "JDT",
               "\u042f\u043f\u043e\u043d\u0438\u044f",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u041f\u0430\u043a\u0438\u0441\u0442\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PKT",
               "\u041f\u0430\u043a\u0438\u0441\u0442\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PKST",
               "\u041f\u0430\u043a\u0438\u0441\u0442\u0430\u043d",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u0422\u0430\u0439\u0432\u0430\u043d\u044c, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CST",
               "\u0422\u0430\u0439\u0432\u0430\u043d\u044c, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CDT",
               "\u0422\u0430\u0439\u0432\u0430\u043d\u044c",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u0425\u043e\u0432\u0434, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HOVT",
               "\u0425\u043e\u0432\u0434, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HOVST",
               "\u0425\u043e\u0432\u0434",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u041c\u0430\u0433\u0430\u0434\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MAGT",
               "\u041c\u0430\u0433\u0430\u0434\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MAGST",
               "\u041c\u0430\u0433\u0430\u0434\u0430\u043d",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0437\u0430\u043f\u0430\u0434\u043d\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACWST",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0437\u0430\u043f\u0430\u0434\u043d\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACWDT",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0437\u0430\u043f\u0430\u0434\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CET",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CEST",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u0421\u0430\u0445\u0430\u043b\u0438\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SAKT",
               "\u0421\u0430\u0445\u0430\u043b\u0438\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SAKST",
               "\u0421\u0430\u0445\u0430\u043b\u0438\u043d",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u041f\u0430\u0440\u0430\u0433\u0432\u0430\u0439, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PYT",
               "\u041f\u0430\u0440\u0430\u0433\u0432\u0430\u0439, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PYST",
               "\u041f\u0430\u0440\u0430\u0433\u0432\u0430\u0439",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u0410\u043a\u0440\u0438 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACT",
               "\u0410\u043a\u0440\u0438 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACST",
               "\u0410\u043a\u0440\u0438 \u0432\u0440\u0435\u043c\u044f",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u041c\u0430\u043b\u0430\u0439\u0437\u0438\u044f",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EST",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EDT",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u041b\u043e\u0440\u0434-\u0425\u0430\u0443, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "LHST",
               "\u041b\u043e\u0440\u0434-\u0425\u0430\u0443, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "LHDT",
               "\u041b\u043e\u0440\u0434-\u0425\u0430\u0443",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u041d\u043e\u0432\u0430\u044f \u0417\u0435\u043b\u0430\u043d\u0434\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NZST",
               "\u041d\u043e\u0432\u0430\u044f \u0417\u0435\u043b\u0430\u043d\u0434\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NZDT",
               "\u041d\u043e\u0432\u0430\u044f \u0417\u0435\u043b\u0430\u043d\u0434\u0438\u044f",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u0418\u043d\u0434\u0438\u0439\u0441\u043a\u0438\u0439 \u043e\u043a\u0435\u0430\u043d",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u042f\u043a\u0443\u0442\u0441\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "YAKT",
               "\u042f\u043a\u0443\u0442\u0441\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "YAKST",
               "\u042f\u043a\u0443\u0442\u0441\u043a",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u041c\u0430\u0432\u0440\u0438\u043a\u0438\u0439, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MUT",
               "\u041c\u0430\u0432\u0440\u0438\u043a\u0438\u0439, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MUST",
               "\u041c\u0430\u0432\u0440\u0438\u043a\u0438\u0439",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u044b\u0439 \u0422\u0438\u043c\u043e\u0440",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u0421\u043e\u043b\u043e\u043c\u043e\u043d\u043e\u0432\u044b \u043e-\u0432\u0430",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u041a\u043e\u0441\u0440\u0430\u044d",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u041c\u0430\u0440\u0448\u0430\u043b\u043b\u043e\u0432\u044b \u043e-\u0432\u0430",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EET",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EEST",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u041d\u044c\u044e\u0444\u0430\u0443\u043d\u0434\u043b\u0435\u043d\u0434, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NST",
               "\u041d\u044c\u044e\u0444\u0430\u0443\u043d\u0434\u043b\u0435\u043d\u0434, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NDT",
               "\u041d\u044c\u044e\u0444\u0430\u0443\u043d\u0434\u043b\u0435\u043d\u0434",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u0410\u0444\u0433\u0430\u043d\u0438\u0441\u0442\u0430\u043d",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u0413\u043e\u043d\u043a\u043e\u043d\u0433, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HKT",
               "\u0413\u043e\u043d\u043a\u043e\u043d\u0433, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HKST",
               "\u0413\u043e\u043d\u043a\u043e\u043d\u0433",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ART",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ARST",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u0410\u0442\u043b\u0430\u043d\u0442\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AST",
               "\u0410\u0442\u043b\u0430\u043d\u0442\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ADT",
               "\u0410\u0442\u043b\u0430\u043d\u0442\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u041f\u043e\u043d\u0430\u043f\u0435, \u043e-\u0432\u0430",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u0411\u043e\u043b\u0438\u0432\u0438\u044f",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u0421\u0435\u043d-\u041f\u044c\u0435\u0440 \u0438 \u041c\u0438\u043a\u0435\u043b\u043e\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PMST",
               "\u0421\u0435\u043d-\u041f\u044c\u0435\u0440 \u0438 \u041c\u0438\u043a\u0435\u043b\u043e\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PMDT",
               "\u0421\u0435\u043d-\u041f\u044c\u0435\u0440 \u0438 \u041c\u0438\u043a\u0435\u043b\u043e\u043d",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u0418\u043d\u0434\u043e\u043a\u0438\u0442\u0430\u0439",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u0415\u043a\u0430\u0442\u0435\u0440\u0438\u043d\u0431\u0443\u0440\u0433, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "YEKT",
               "\u0415\u043a\u0430\u0442\u0435\u0440\u0438\u043d\u0431\u0443\u0440\u0433, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "YEKST",
               "\u0415\u043a\u0430\u0442\u0435\u0440\u0438\u043d\u0431\u0443\u0440\u0433",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u041c\u0430\u043b\u044c\u0434\u0438\u0432\u044b",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u0422\u0430\u0438\u0442\u0438, \u043e-\u0432",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u0418\u0437\u0440\u0430\u0438\u043b\u044c, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IST",
               "\u0418\u0437\u0440\u0430\u0438\u043b\u044c, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IDT",
               "\u0418\u0437\u0440\u0430\u0438\u043b\u044c",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0418\u043d\u0434\u043e\u043d\u0435\u0437\u0438\u044f",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u0423\u043e\u043b\u043b\u0438\u0441 \u0438 \u0424\u0443\u0442\u0443\u043d\u0430",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u042e\u0436\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u0421\u0451\u0432\u0430",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u041b\u0430\u0439\u043d, \u043e-\u0432\u0430",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u0423\u0437\u0431\u0435\u043a\u0438\u0441\u0442\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "UZT",
               "\u0423\u0437\u0431\u0435\u043a\u0438\u0441\u0442\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "UZST",
               "\u0423\u0437\u0431\u0435\u043a\u0438\u0441\u0442\u0430\u043d",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u041e\u043c\u0441\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "OMST",
               "\u041e\u043c\u0441\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "OMSST",
               "\u041e\u043c\u0441\u043a",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u0421\u0435\u0439\u0448\u0435\u043b\u044c\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u0423\u0440\u0443\u0433\u0432\u0430\u0439, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "UYT",
               "\u0423\u0440\u0443\u0433\u0432\u0430\u0439, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "UYST",
               "\u0423\u0440\u0443\u0433\u0432\u0430\u0439",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u041d\u0435\u043f\u0430\u043b",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u0423\u043b\u0430\u043d-\u0411\u0430\u0442\u043e\u0440, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ULAT",
               "\u0423\u043b\u0430\u043d-\u0411\u0430\u0442\u043e\u0440, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ULAST",
               "\u0423\u043b\u0430\u043d-\u0411\u0430\u0442\u043e\u0440",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CST",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CDT",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u043c\u0435\u0440\u0438\u043a\u0430",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u0427\u0443\u0443\u043a",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u041d\u0438\u0443\u044d",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u0423\u044d\u0439\u043a, \u043e-\u0432",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u0424\u043e\u043b\u043a\u043b\u0435\u043d\u0434\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FKT",
               "\u0424\u043e\u043b\u043a\u043b\u0435\u043d\u0434\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FKST",
               "\u0424\u043e\u043b\u043a\u043b\u0435\u043d\u0434\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u0412\u0430\u043d\u0443\u0430\u0442\u0443, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "VUT",
               "\u0412\u0430\u043d\u0443\u0430\u0442\u0443, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "VUST",
               "\u0412\u0430\u043d\u0443\u0430\u0442\u0443",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u041d\u043e\u0432\u043e\u0441\u0438\u0431\u0438\u0440\u0441\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NOVT",
               "\u041d\u043e\u0432\u043e\u0441\u0438\u0431\u0438\u0440\u0441\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NOVST",
               "\u041d\u043e\u0432\u043e\u0441\u0438\u0431\u0438\u0440\u0441\u043a",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u0421\u0438\u043d\u0433\u0430\u043f\u0443\u0440",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u0410\u0437\u043e\u0440\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AZOT",
               "\u0410\u0437\u043e\u0440\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AZOST",
               "\u0410\u0437\u043e\u0440\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u0410\u043f\u0438\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WSST",
               "\u0410\u043f\u0438\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WSDT",
               "\u0410\u043f\u0438\u0430",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u0411\u0443\u0442\u0430\u043d",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u0421\u0443\u0440\u0438\u043d\u0430\u043c",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u041d\u0430\u0443\u0440\u0443",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u041a\u0440\u0430\u0441\u043d\u043e\u044f\u0440\u0441\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "KRAT",
               "\u041a\u0440\u0430\u0441\u043d\u043e\u044f\u0440\u0441\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "KRAST",
               "\u041a\u0440\u0430\u0441\u043d\u043e\u044f\u0440\u0441\u043a",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u044b\u0439 \u041a\u0430\u0437\u0430\u0445\u0441\u0442\u0430\u043d",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u041c\u044c\u044f\u043d\u043c\u0430",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u0420\u043e\u0436\u0434\u0435\u0441\u0442\u0432\u0430, \u043e-\u0432",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u0410\u043c\u0430\u0437\u043e\u043d\u043a\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AMT",
               "\u0410\u043c\u0430\u0437\u043e\u043d\u043a\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AMST",
               "\u0410\u043c\u0430\u0437\u043e\u043d\u043a\u0430",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u044b\u0439 \u041a\u0430\u0437\u0430\u0445\u0441\u0442\u0430\u043d",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u0424\u0438\u0434\u0436\u0438, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FJT",
               "\u0424\u0438\u0434\u0436\u0438, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FJST",
               "\u0424\u0438\u0434\u0436\u0438",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u0420\u0435\u044e\u043d\u044c\u043e\u043d",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u041a\u043e\u043a\u043e\u0441\u043e\u0432\u044b\u0435 \u043e-\u0432\u0430",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u0427\u0430\u0442\u0435\u043c, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CHAST",
               "\u0427\u0430\u0442\u0435\u043c, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CHADT",
               "\u0427\u0430\u0442\u0435\u043c",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u043a",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ART",
               "\u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ARST",
               "\u0410\u0440\u0433\u0435\u043d\u0442\u0438\u043d\u0430",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u0413\u0430\u043c\u0431\u044c\u0435",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u0421\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f \u0432 \u041f\u0435\u0442\u0440\u043e\u043f\u0430\u0432\u043b\u043e\u0432\u0441\u043a\u0443-\u041a\u0430\u043c\u0447\u0430\u0442\u0441\u043a\u043e\u043c\u0443",
               "PETT",
               "\u041b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f \u0432 \u041f\u0435\u0442\u0440\u043e\u043f\u0430\u0432\u043b\u043e\u0432\u0441\u043a\u0435-\u041a\u0430\u043c\u0447\u0430\u0442\u0441\u043a\u043e\u043c",
               "PETST",
               "\u0412\u0440\u0435\u043c\u044f \u0432 \u041f\u0435\u0442\u0440\u043e\u043f\u0430\u0432\u043b\u043e\u0432\u0441\u043a\u0443-\u041a\u0430\u043c\u0447\u0430\u0442\u0441\u043a\u043e\u043c\u0443",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u0422\u0443\u0432\u0430\u043b\u0443",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u0413\u0430\u043b\u0430\u043f\u0430\u0433\u043e\u0441\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u041c\u0430\u043a\u043a\u0443\u043e\u0440\u0438",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u0412\u0435\u043d\u0435\u0441\u0443\u044d\u043b\u0430",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u0413\u0430\u0432\u0430\u0439\u0441\u043a\u043e-\u0430\u043b\u0435\u0443\u0442\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HAST",
               "\u0413\u0430\u0432\u0430\u0439\u0441\u043a\u043e-\u0430\u043b\u0435\u0443\u0442\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HADT",
               "\u0413\u0430\u0432\u0430\u0439\u0441\u043a\u043e-\u0430\u043b\u0435\u0443\u0442\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACST",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ACDT",
               "\u0426\u0435\u043d\u0442\u0440\u0430\u043b\u044c\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PST",
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PDT",
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u0424\u0435\u043d\u0438\u043a\u0441, \u043e-\u0432\u0430",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u0422\u0443\u0440\u043a\u043c\u0435\u043d\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "TMT",
               "\u0422\u0443\u0440\u043a\u043c\u0435\u043d\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "TMST",
               "\u0422\u0443\u0440\u043a\u043c\u0435\u043d\u0438\u044f",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WET",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WEST",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0415\u0432\u0440\u043e\u043f\u0430",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u041a\u0430\u0431\u043e-\u0412\u0435\u0440\u0434\u0435, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CVT",
               "\u041a\u0430\u0431\u043e-\u0412\u0435\u0440\u0434\u0435, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CVST",
               "\u041a\u0430\u0431\u043e-\u0412\u0435\u0440\u0434\u0435",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u041d\u043e\u0440\u0444\u043e\u043b\u043a",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u0413\u0430\u0439\u0430\u043d\u0430",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u041f\u0438\u0442\u043a\u044d\u0440\u043d",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u0420\u043e\u0442\u0435\u0440\u0430",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u0421\u0430\u043c\u043e\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SST",
               "\u0421\u0430\u043c\u043e\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SDT",
               "\u0421\u0430\u043c\u043e\u0430",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u041f\u0430\u043b\u0430\u0443",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u041c\u0438\u043d\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u0410\u0437\u0435\u0440\u0431\u0430\u0439\u0434\u0436\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AZT",
               "\u0410\u0437\u0435\u0440\u0431\u0430\u0439\u0434\u0436\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AZST",
               "\u0410\u0437\u0435\u0440\u0431\u0430\u0439\u0434\u0436\u0430\u043d",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u041c\u043e\u0443\u0441\u043e\u043d",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MST",
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MDT",
               "\u0422\u0438\u0445\u043e\u043e\u043a\u0435\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u0414\u0435\u0439\u0432\u0438\u0441",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u041a\u0443\u0431\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CST",
               "\u041a\u0443\u0431\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CDT",
               "\u041a\u0443\u0431\u0430",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CAT",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CAST",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0444\u0440\u0438\u043a\u0430",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u0421\u0440\u0435\u0434\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f \u043f\u043e \u0413\u0440\u0438\u043d\u0432\u0438\u0447\u0443",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u0424\u0438\u043b\u0438\u043f\u043f\u0438\u043d\u044b, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PHT",
               "\u0424\u0438\u043b\u0438\u043f\u043f\u0438\u043d\u044b, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PHST",
               "\u0424\u0438\u043b\u0438\u043f\u043f\u0438\u043d\u044b",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u0424\u0440\u0430\u043d\u0446\u0443\u0437\u0441\u043a\u043e\u0435 \u044e\u0436\u043d\u043e\u0435 \u0438 \u0430\u043d\u0442\u0430\u0440\u043a\u0442\u0438\u0447\u0435\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u042e\u0436\u043d\u0430\u044f \u0413\u0435\u043e\u0440\u0433\u0438\u044f",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u041d\u043e\u0432\u0430\u044f \u041a\u0430\u043b\u0435\u0434\u043e\u043d\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NCT",
               "\u041d\u043e\u0432\u0430\u044f \u041a\u0430\u043b\u0435\u0434\u043e\u043d\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "NCST",
               "\u041d\u043e\u0432\u0430\u044f \u041a\u0430\u043b\u0435\u0434\u043e\u043d\u0438\u044f",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u0411\u0440\u0443\u043d\u0435\u0439-\u0414\u0430\u0440\u0443\u0441\u0441\u0430\u043b\u0430\u043c",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u0418\u0440\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IRST",
               "\u0418\u0440\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IRDT",
               "\u0418\u0440\u0430\u043d",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u041e-\u0432 \u041f\u0430\u0441\u0445\u0438, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EAST",
               "\u041e-\u0432 \u041f\u0430\u0441\u0445\u0438, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EASST",
               "\u041e-\u0432 \u041f\u0430\u0441\u0445\u0438",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u0421\u0435\u0432\u0435\u0440\u043e\u0430\u043c\u0435\u0440\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PST",
               "\u0421\u0435\u0432\u0435\u0440\u043e\u0430\u043c\u0435\u0440\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PDT",
               "\u0421\u0435\u0432\u0435\u0440\u043e\u0430\u043c\u0435\u0440\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u043c\u0435\u043a\u0441\u0438\u043a\u0430\u043d\u0441\u043a\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u0414\u044e\u043c\u043e\u043d-\u0434\u2019\u042e\u0440\u0432\u0438\u043b\u044c",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u0422\u0430\u0434\u0436\u0438\u043a\u0438\u0441\u0442\u0430\u043d",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u0422\u043e\u043d\u0433\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "TOT",
               "\u0422\u043e\u043d\u0433\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "TOST",
               "\u0422\u043e\u043d\u0433\u0430",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u0411\u0430\u043d\u0433\u043b\u0430\u0434\u0435\u0448, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "BDT",
               "\u0411\u0430\u043d\u0433\u043b\u0430\u0434\u0435\u0448, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "BDST",
               "\u0411\u0430\u043d\u0433\u043b\u0430\u0434\u0435\u0448",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u041f\u0435\u0440\u0443, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PET",
               "\u041f\u0435\u0440\u0443, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "PEST",
               "\u041f\u0435\u0440\u0443",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WGT",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "WGST",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u042d\u043a\u0432\u0430\u0434\u043e\u0440",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EGT",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "EGST",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0413\u0440\u0435\u043d\u043b\u0430\u043d\u0434\u0438\u044f",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u041f\u0435\u0440\u0441\u0438\u0434\u0441\u043a\u0438\u0439 \u0437\u0430\u043b\u0438\u0432",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0418\u043d\u0434\u043e\u043d\u0435\u0437\u0438\u044f",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u041a\u043e\u0440\u0435\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "KST",
               "\u041a\u043e\u0440\u0435\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "KDT",
               "\u041a\u043e\u0440\u0435\u044f",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AWST",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AWDT",
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u041a\u0438\u0440\u0433\u0438\u0437\u0438\u044f",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u0417\u0430\u043f\u0430\u0434\u043d\u0430\u044f \u0418\u043d\u0434\u043e\u043d\u0435\u0437\u0438\u044f",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AEST",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AEDT",
               "\u0412\u043e\u0441\u0442\u043e\u0447\u043d\u0430\u044f \u0410\u0432\u0441\u0442\u0440\u0430\u043b\u0438\u044f",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u0424\u0440\u0430\u043d\u0446\u0443\u0437\u0441\u043a\u0430\u044f \u0413\u0432\u0438\u0430\u043d\u0430",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u041a\u043e\u043b\u0443\u043c\u0431\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "COT",
               "\u041a\u043e\u043b\u0443\u043c\u0431\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "COST",
               "\u041a\u043e\u043b\u0443\u043c\u0431\u0438\u044f",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u0427\u0438\u043b\u0438, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CLT",
               "\u0427\u0438\u043b\u0438, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CLST",
               "\u0427\u0438\u043b\u0438",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u0413\u0438\u043b\u0431\u0435\u0440\u0442\u0430, \u043e-\u0432\u0430",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u0413\u043e\u0440\u043d\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f (\u0421\u0428\u0410)",
               "MST",
               "\u0413\u043e\u0440\u043d\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f (\u0421\u0428\u0410)",
               "MDT",
               "\u0413\u043e\u0440\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f (\u0421\u0428\u0410)",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u041c\u0430\u0440\u043a\u0438\u0437\u0441\u043a\u0438\u0435 \u043e-\u0432\u0430",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u0421\u0430\u0443\u0434\u043e\u0432\u0441\u043a\u0430\u044f \u0410\u0440\u0430\u0432\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AST",
               "\u0421\u0430\u0443\u0434\u043e\u0432\u0441\u043a\u0430\u044f \u0410\u0440\u0430\u0432\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "ADT",
               "\u0421\u0430\u0443\u0434\u043e\u0432\u0441\u043a\u0430\u044f \u0410\u0440\u0430\u0432\u0438\u044f",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u0410\u043b\u044f\u0441\u043a\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AKST",
               "\u0410\u043b\u044f\u0441\u043a\u0430, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AKDT",
               "\u0410\u043b\u044f\u0441\u043a\u0430",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u0412\u043b\u0430\u0434\u0438\u0432\u043e\u0441\u0442\u043e\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "VLAT",
               "\u0412\u043b\u0430\u0434\u0438\u0432\u043e\u0441\u0442\u043e\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "VLAST",
               "\u0412\u043b\u0430\u0434\u0438\u0432\u043e\u0441\u0442\u043e\u043a",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u0427\u0430\u043c\u043e\u0440\u0440\u043e",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u0418\u0440\u043a\u0443\u0442\u0441\u043a, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IRKT",
               "\u0418\u0440\u043a\u0443\u0442\u0441\u043a, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "IRKST",
               "\u0418\u0440\u043a\u0443\u0442\u0441\u043a",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u0413\u0440\u0443\u0437\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "GET",
               "\u0413\u0440\u0443\u0437\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "GEST",
               "\u0413\u0440\u0443\u0437\u0438\u044f",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u0422\u043e\u043a\u0435\u043b\u0430\u0443",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u041f\u0430\u043f\u0443\u0430 \u2013 \u041d\u043e\u0432\u0430\u044f \u0413\u0432\u0438\u043d\u0435\u044f",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u0424\u0435\u0440\u043d\u0430\u043d\u0434\u0443-\u0434\u0438-\u041d\u043e\u0440\u043e\u043d\u044c\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FNT",
               "\u0424\u0435\u0440\u043d\u0430\u043d\u0434\u0443-\u0434\u0438-\u041d\u043e\u0440\u043e\u043d\u044c\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "FNST",
               "\u0424\u0435\u0440\u043d\u0430\u043d\u0434\u0443-\u0434\u0438-\u041d\u043e\u0440\u043e\u043d\u044c\u044f",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u0427\u043e\u0439\u0431\u0430\u043b\u0441\u0430\u043d, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CHOT",
               "\u0427\u043e\u0439\u0431\u0430\u043b\u0441\u0430\u043d, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CHOST",
               "\u0427\u043e\u0439\u0431\u0430\u043b\u0441\u0430\u043d",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u0411\u0440\u0430\u0437\u0438\u043b\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "BRT",
               "\u0411\u0440\u0430\u0437\u0438\u043b\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "BRST",
               "\u0411\u0440\u0430\u0437\u0438\u043b\u0438\u044f",
               "BRT",
            };
        final String[] China = new String[] {
               "\u041a\u0438\u0442\u0430\u0439, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CST",
               "\u041a\u0438\u0442\u0430\u0439, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CDT",
               "\u041a\u0438\u0442\u0430\u0439",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u0410\u0440\u043c\u0435\u043d\u0438\u044f, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AMT",
               "\u0410\u0440\u043c\u0435\u043d\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "AMST",
               "\u0410\u0440\u043c\u0435\u043d\u0438\u044f",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u0421\u0430\u043c\u0430\u0440\u0441\u043a\u043e\u0435 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SAMT",
               "\u0421\u0430\u043c\u0430\u0440\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "SAMST",
               "\u0412\u0440\u0435\u043c\u044f \u0432 \u0421\u0430\u043c\u0430\u0440\u0435",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u0418\u043d\u0434\u0438\u044f",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u041a\u0443\u043a\u0430, \u043e-\u0432\u0430, \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043d\u043e\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CKT",
               "\u041a\u0443\u043a\u0430, \u043e-\u0432\u0430, \u043f\u043e\u043b\u0443\u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
               "CKHST",
               "\u041a\u0443\u043a\u0430, \u043e-\u0432\u0430",
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
                    "\u0421\u0440\u0435\u0434\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f \u043f\u043e \u0413\u0440\u0438\u043d\u0432\u0438\u0447\u0443",
                    "GMT",
                    "\u0411\u0440\u0438\u0442\u0430\u043d\u0441\u043a\u043e\u0435 \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
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
                    "\u0421\u0440\u0435\u0434\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f \u043f\u043e \u0413\u0440\u0438\u043d\u0432\u0438\u0447\u0443",
                    "GMT",
                    "\u0418\u0440\u043b\u0430\u043d\u0434\u0438\u044f, \u043b\u0435\u0442\u043d\u0435\u0435 \u0432\u0440\u0435\u043c\u044f",
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
