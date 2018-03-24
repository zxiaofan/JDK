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

public class TimeZoneNames_am extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a0\u134d\u122a\u12ab \u1230\u12d3\u1275",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u12e8\u121e\u1235\u12ae \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MSK",
               "\u12e8\u121e\u1235\u12ae \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MSD",
               "\u12e8\u121e\u1235\u12ae \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u12e8\u1303\u1353\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "JST",
               "\u12e8\u1303\u1353\u1295 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "JDT",
               "\u12e8\u1303\u1353\u1295 \u1230\u12d3\u1275",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u12e8\u1353\u12aa\u1235\u1273\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "PKT",
               "\u12e8\u1353\u12aa\u1235\u1273\u1295 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "PKST",
               "\u12e8\u1353\u12aa\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u12e8\u1273\u12ed\u1354\u12ed \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CST",
               "\u12e8\u1273\u12ed\u1354\u12ed \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "CDT",
               "\u12e8\u1273\u12ed\u1354\u12ed \u1230\u12d3\u1275",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u12e8\u1206\u126d\u12f5 \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HOVT",
               "\u12e8\u1206\u126d\u12f5 \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HOVST",
               "\u12e8\u1206\u126d\u12f5 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u12e8\u121b\u130b\u12f3\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MAGT",
               "\u12e8\u121b\u130b\u12f3\u1295 \u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MAGST",
               "\u12e8\u121b\u130b\u12f3\u1295 \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1218\u12ab\u12a8\u1208\u129b \u121d\u1235\u122b\u1243\u12ca \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACWST",
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1218\u12ab\u12a8\u1208\u129b\u12cd \u121d\u1235\u122b\u1245 \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACWDT",
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1218\u12ab\u12a8\u1208\u129b \u121d\u1235\u122b\u1243\u12ca \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a0\u12cd\u122e\u1353 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CET",
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a0\u12cd\u122e\u1353 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "CEST",
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a0\u12cd\u122e\u1353 \u1230\u12d3\u1275",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u12e8\u1233\u12ad\u1203\u120a\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAKT",
               "\u12e8\u1233\u12ad\u1203\u120a\u1295 \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAKST",
               "\u12e8\u1233\u12ad\u1203\u120a\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u12e8\u1353\u122b\u1313\u12ed \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "PYT",
               "\u12e8\u1353\u122b\u1313\u12ed \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "PYST",
               "\u12e8\u1353\u122b\u1313\u12ed \u1230\u12d3\u1275",
               "PYT",
            };
        final String[] Malaysia = new String[] {
               "\u12e8\u121b\u120c\u12ed\u12e2\u12eb \u1230\u12d3\u1275",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "EST",
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "EDT",
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u12e8\u120e\u122d\u12f5 \u1206\u12cc \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "LHST",
               "\u12e8\u120e\u122d\u12f5 \u1206\u12cc \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "LHDT",
               "\u12e8\u120e\u122d\u12f5 \u1206\u12cc \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u12e8\u1292\u12cd \u12da\u120b\u1295\u12f5 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "NZST",
               "\u12e8\u1292\u12cd \u12da\u120b\u1295\u12f5 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "NZDT",
               "\u12e8\u1292\u12cd \u12da\u120b\u1295\u12f5 \u1230\u12d3\u1275",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u12e8\u1205\u1295\u12f5 \u12cd\u1245\u12eb\u1296\u1235 \u1230\u12d3\u1275",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u12eb\u12a9\u1275\u1235\u12ad \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YAKT",
               "\u12e8\u12eb\u12a9\u1275\u1235\u12ad \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YAKST",
               "\u12eb\u12a9\u1275\u1235\u12ad \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u12e8\u121b\u12cd\u122a\u123a\u12e8\u1235 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "MUT",
               "\u12e8\u121b\u12cd\u122a\u123a\u12e8\u1235 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "MUST",
               "\u12e8\u121b\u12cd\u122a\u123a\u12e8\u1235 \u1230\u12d3\u1275",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u12e8\u121d\u1235\u122b\u1245 \u12a0\u134d\u122a\u12ab \u1230\u12d3\u1275",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u12e8\u121d\u1235\u122b\u1245 \u1272\u121e\u122d \u1230\u12d3\u1275",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u12e8\u1230\u1208\u121e\u1295 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u12e8\u12ae\u1235\u122b\u12a4 \u1230\u12d3\u1275",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u12e8\u121b\u122d\u123b\u120d \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u12e8\u121d\u1235\u122b\u1243\u12ca \u12a0\u12cd\u122e\u1353 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "EET",
               "\u12e8\u121d\u1235\u122b\u1243\u12ca \u12a0\u12cd\u122e\u1353 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "EEST",
               "\u12e8\u121d\u1235\u122b\u1243\u12ca \u12a0\u12cd\u122e\u1353 \u1230\u12d3\u1275",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u12e8\u1292\u12cd\u134b\u12cd\u1295\u12f5\u120b\u1295\u12f5 \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NST",
               "\u12e8\u1292\u12cd\u134b\u12cd\u1295\u12f5\u120b\u1295\u12f5 \u12e8\u1240\u1295 \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NDT",
               "\u12e8\u1292\u12cd\u134b\u12cd\u1295\u12f5\u120b\u1295\u12f5 \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u12e8\u12a0\u134d\u130b\u1292\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u12e8\u1206\u1295\u130d \u12ae\u1295\u130d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "HKT",
               "\u12e8\u1206\u1295\u130d \u12ae\u1295\u130d \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "HKST",
               "\u12e8\u1206\u1295\u130d \u12ae\u1295\u130d \u1230\u12d3\u1275",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a0\u122d\u1300\u1295\u1272\u1293 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ART",
               "\u12e8\u12a0\u122d\u1300\u1295\u1272\u1293 \u121d\u1235\u122b\u1243\u12ca \u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ARST",
               "\u12e8\u12a0\u122d\u1300\u1295\u1272\u1293 \u121d\u1235\u122b\u1243\u12ca \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u12e8\u12a0\u1275\u120b\u1295\u1272\u12ad \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AST",
               "\u12e8\u12a0\u1275\u120b\u1295\u1272\u12ad \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ADT",
               "\u12e8\u12a0\u1275\u120b\u1295\u1272\u12ad \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u12e8\u1356\u1293\u1354 \u1230\u12d3\u1275",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u12e8\u1266\u120a\u126a\u12eb \u1230\u12d3\u1275",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u1245\u12f1\u1235 \u12e8\u1352\u12ec\u122d \u12a5\u1293 \u121a\u12b4\u120e\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "PMST",
               "\u1245\u12f1\u1235 \u12e8\u1352\u12ec\u122d \u12a5\u1293 \u121a\u12b4\u120e\u1295 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "PMDT",
               "\u1245\u12f1\u1235 \u12e8\u1352\u12ec\u122d \u12a5\u1293 \u121a\u12b4\u120e\u1295 \u1230\u12d3\u1275",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u12e8\u12a2\u1295\u12f6\u127b\u12ed\u1293 \u1230\u12d3\u1275",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u12e8\u12e8\u12ab\u1270\u122a\u1295\u1260\u122d\u130d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YEKT",
               "\u12e8\u12e8\u12ab\u1270\u122a\u1295\u1260\u122d\u130d \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YEKST",
               "\u12e8\u12e8\u12ab\u1270\u122a\u1295\u1260\u122d\u130d \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u12e8\u121b\u120d\u12f2\u126d\u1235 \u1230\u12d3\u1275",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u12e8\u1273\u1202\u1272 \u1230\u12d3\u1275",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u12e8\u12a5\u1235\u122b\u12a4\u120d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "IST",
               "\u12e8\u12a5\u1235\u122b\u12a4\u120d \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "IDT",
               "\u12e8\u12a5\u1235\u122b\u12a4\u120d \u1230\u12d3\u1275",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a2\u1295\u12f6\u1294\u12e2\u12eb \u1230\u12d3\u1275",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u12e8\u12cb\u120a\u1235 \u12a5\u1293 \u1349\u1271\u1293 \u1230\u12d3\u1275",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u12e8\u12f0\u1261\u1265 \u12a0\u134d\u122a\u12ab \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u12e8\u1232\u12ee\u12cb \u1230\u12d3\u1275",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u12e8\u120b\u12ed\u1295 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u12e8\u12a1\u12dd\u1264\u12aa\u1235\u1273\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "UZT",
               "\u12e8\u12a1\u12dd\u1264\u12aa\u1235\u1273\u1295 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "UZST",
               "\u12e8\u12a1\u12dd\u1264\u12aa\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u12e8\u12a6\u121d\u1235\u12ad \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "OMST",
               "\u12e8\u12a6\u121d\u1235\u12ad \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "OMSST",
               "\u12e8\u12a6\u121d\u1235\u12ad \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u12e8\u1234\u1238\u120d\u1235 \u1230\u12d3\u1275",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u12e8\u12a1\u122b\u1313\u12ed \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "UYT",
               "\u12e8\u12a1\u122b\u1313\u12ed \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "UYST",
               "\u12e8\u12a1\u122b\u1313\u12ed \u1230\u12d3\u1275",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u12e8\u1294\u1353\u120d \u1230\u12d3\u1275",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u12e8\u12a1\u120b\u1295 \u1263\u1276\u122d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ULAT",
               "\u12e8\u12a1\u120b\u1295 \u1263\u1276\u122d \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ULAST",
               "\u12e8\u12a1\u120b\u1295 \u1263\u1276\u122d \u130a\u12dc",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CST",
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CDT",
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u12e8\u1279\u12ad \u1230\u12d3\u1275",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u12e8\u1292\u12e9\u12cc \u1230\u12d3\u1275",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u12e8\u12cc\u12ad \u12f0\u1234\u1275 \u1230\u12d3\u1275",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u12e8\u134b\u120d\u12ad\u120b\u1295\u12f5 \u12f0\u1234\u1276\u127d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "FKT",
               "\u12e8\u134b\u120d\u12ad\u120b\u1295\u12f5 \u12f0\u1234\u1276\u127d \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "FKST",
               "\u12e8\u134b\u120d\u12ad\u120b\u1295\u12f5 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u12e8\u126b\u1297\u1271 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "VUT",
               "\u12e8\u126b\u1297\u1271 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "VUST",
               "\u12e8\u126b\u1297\u1271 \u1230\u12d3\u1275",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u12e8\u1296\u126e\u1232\u1262\u122d\u1235\u12ad \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NOVT",
               "\u12e8\u1296\u126e\u1232\u1265\u122a\u1235\u12ad \u12e8\u1260\u130b \u1230\u12a0\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NOVST",
               "\u12e8\u1296\u126e\u1232\u1265\u122a\u1235\u12ad \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u12e8\u1232\u1295\u130b\u1352\u122d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u12e8\u12a0\u12de\u1228\u1235 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "AZOT",
               "\u12e8\u12a0\u12de\u1228\u1235 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "AZOST",
               "\u12e8\u12a0\u12de\u1228\u1235 \u1230\u12d3\u1275",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u12e8\u12a0\u1352\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "WSST",
               "\u12e8\u12a0\u1352\u12eb \u12e8\u1240\u1295 \u130a\u12dc \u1230\u12d3\u1275",
               "WSDT",
               "\u12e8\u12a0\u1352\u12eb \u1230\u12d3\u1275",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u12e8\u1261\u1273\u1295 \u1230\u12d3\u1275",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u12e8\u1231\u122a\u1293\u121d \u1230\u12d3\u1275",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u12e8\u1293\u12cd\u1229 \u1230\u12d3\u1275",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u12e8\u12ad\u122b\u1235\u1296\u12ed\u12a0\u122d\u1235\u12ad \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "KRAT",
               "\u12e8\u12ad\u122b\u1235\u1296\u12eb\u122d\u1235\u12ad \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "KRAST",
               "\u12e8\u12ad\u122b\u1235\u1296\u12eb\u122d\u1235\u12ad \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1265 \u12ab\u12db\u12aa\u1235\u1273\u1295 \u130a\u12dc",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u12e8\u121a\u12eb\u1295\u121b\u122d \u1230\u12d3\u1275",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u12e8\u1308\u1293 \u12f0\u1234\u1275 \u1230\u12d3\u1275",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u12e8\u12a0\u121b\u12de\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AMT",
               "\u12e8\u12a0\u121b\u12de\u1295 \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AMST",
               "\u12e8\u12a0\u121b\u12de\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u12e8\u121d\u1235\u122b\u1245 \u12ab\u12db\u12aa\u1235\u1273\u1295 \u130a\u12dc",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u12e8\u134a\u1302 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "FJT",
               "\u12e8\u134a\u1302 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "FJST",
               "\u12e8\u134a\u1302 \u1230\u12d3\u1275",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u12e8\u122c\u12e9\u1292\u12e8\u1295 \u1230\u12d3\u1275",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u12e8\u12ae\u12ae\u1235 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u12e8\u127b\u1273\u121d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CHAST",
               "\u12e8\u127b\u1273\u121d \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "CHADT",
               "\u12e8\u127b\u1273\u121d \u1230\u12d3\u1275",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u12e8\u126e\u1235\u1276\u12ad \u1230\u12d3\u1275",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u12e8\u12a0\u122d\u1300\u1295\u1272\u1293 \u1218\u12f0\u1260\u129b \u130a\u12dc",
               "ART",
               "\u12e8\u12a0\u122d\u1300\u1295\u1272\u1293 \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ARST",
               "\u12e8\u12a0\u122d\u1300\u1295\u1272\u1293 \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u12e8\u130b\u121d\u1262\u12e8\u122d \u1230\u12d3\u1275",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u12e8\u1354\u1275\u122e\u1353\u126d\u120e\u1235\u12aa - \u12ab\u121d\u127b\u1275\u1235\u12aa \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PETT",
               "\u12e8\u1354\u1275\u122e\u1353\u126d\u120e\u1235\u12aa - \u12ab\u121d\u127b\u1275\u1235\u12aa \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PETST",
               "\u12e8\u12ab\u121d\u127b\u1275\u12ab \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u12e8\u1271\u126b\u1209 \u1230\u12d3\u1275",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u12e8\u130b\u120b\u1353\u130e\u1235 \u1230\u12d3\u1275",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u12e8\u121b\u12a8\u122a \u12f0\u1234\u1275 \u1230\u12d3\u1275",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u12e8\u126c\u1294\u12dd\u12cc\u120b \u1230\u12d3\u1275",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u12e8\u1203\u12cb\u12ed \u12a0\u120c\u12a1\u1275 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HAST",
               "\u12e8\u1203\u12cb\u12ed \u12a0\u120c\u12a1\u1275 \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HADT",
               "\u12e8\u1203\u12cb\u12ed \u12a0\u120c\u12a1\u1275 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1218\u12ab\u12a8\u1208\u129b \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACST",
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1218\u12ab\u12a8\u1208\u129b \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACDT",
               "\u12e8\u1218\u12ab\u12a8\u1208\u129b\u12cd \u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u12e8\u1353\u1235\u134a\u12ad \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PST",
               "\u12e8\u1353\u1235\u134a\u12ad \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PDT",
               "\u12e8\u1353\u1235\u134a\u12ad \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u12e8\u134a\u1292\u12ad\u1235 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u12e8\u1271\u122d\u12ad\u1218\u1292\u1235\u1273\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "TMT",
               "\u12e8\u1271\u122d\u12ad\u1218\u1292\u1235\u1273\u1295 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "TMST",
               "\u12e8\u1271\u122d\u12ad\u1218\u1292\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a0\u12cd\u122e\u1353 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "WET",
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a0\u12cd\u122e\u1353 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "WEST",
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a0\u12cd\u122e\u1353 \u1230\u12d3\u1275",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u12e8\u12ac\u1355 \u1268\u122d\u12f4 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CVT",
               "\u12e8\u12ac\u1355 \u1268\u122d\u12f4 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "CVST",
               "\u12e8\u12ac\u1355 \u1268\u122d\u12f4 \u1230\u12d3\u1275",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u12e8\u1296\u122d\u134e\u120d\u12ad \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u12e8\u1309\u12eb\u1293 \u1230\u12d3\u1275",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u12e8\u1352\u1275\u12ab\u12ed\u122d\u1295 \u1230\u12d3\u1275",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u12e8\u122e\u1274\u122b \u1230\u12d3\u1275",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u12e8\u1233\u121e\u12cb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "SST",
               "\u12e8\u1233\u121e\u12cb \u12e8\u1260\u130b \u1230\u12d3\u1275",
               "SDT",
               "\u12e8\u1233\u121e\u12cb \u1230\u12d3\u1275",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u12e8\u1353\u120b\u12cd \u1230\u12d3\u1275",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u12e8\u1229\u1245 \u121d\u1235\u122b\u1245 \u12e8\u12a0\u12cd\u122e\u1353 \u1230\u12d3\u1275",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u12e8\u12a0\u12d8\u122d\u1263\u12ed\u1303\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "AZT",
               "\u12e8\u12a0\u12d8\u122d\u1263\u12ed\u1303\u1295 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "AZST",
               "\u12e8\u12a0\u12d8\u122d\u1263\u12ed\u1303\u1295 \u1230\u12d3\u1275",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u12e8\u121b\u12cd\u1230\u1295 \u1230\u12d3\u1275",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u12e8\u121c\u12ad\u1232\u12ae \u1353\u1232\u134a\u12ad \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MST",
               "\u12e8\u121c\u12ad\u1232\u12ae \u1353\u1232\u134a\u12ad \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MDT",
               "\u12e8\u121c\u12ad\u1232\u12ae \u1353\u1232\u134a\u12ad \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u12e8\u12f4\u126a\u1235 \u1230\u12d3\u1275",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u12e8\u12a9\u1263 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CST",
               "\u12e8\u12a9\u1263 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "CDT",
               "\u12a9\u1263 \u1230\u12d3\u1275",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1265 \u12a0\u134d\u122a\u12ab \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CAT",
               "\u12e8\u121d\u12d5\u122b\u1265 \u12a0\u134d\u122a\u12ab \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "CAST",
               "\u12e8\u121d\u12d5\u122b\u1265 \u12a0\u134d\u122a\u12ab \u1230\u12d3\u1275",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u130d\u122a\u1295\u12ca\u127d \u121b\u12d5\u12a8\u120b\u12ca \u1230\u12d3\u1275",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u12e8\u134a\u120a\u1352\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "PHT",
               "\u12e8\u134a\u120a\u1352\u1295 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "PHST",
               "\u12e8\u134a\u120a\u1352\u1295 \u1230\u12d3\u1275",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u12e8\u1348\u1228\u1295\u1233\u12ed \u12f0\u1261\u1263\u12ca \u12a5\u1293 \u12a0\u1295\u1273\u122d\u12ad\u1272\u12ad \u1230\u12d3\u1275",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u12e8\u12f0\u1261\u1265 \u1302\u12ee\u122d\u1302\u12eb \u1230\u12d3\u1275",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u12e8\u1292\u12cd \u12ab\u120c\u12f6\u1292\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "NCT",
               "\u12e8\u1292\u12cd \u12ab\u120c\u12f6\u1292\u12eb \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "NCST",
               "\u12e8\u1292\u12cd \u12ab\u120c\u12f6\u1292\u12eb \u1230\u12d3\u1275",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u12e8\u1265\u1229\u1294\u12ed \u12f3\u1229\u1233\u120b\u121d \u1230\u12d3\u1275",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u12e8\u12a2\u122b\u1295 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "IRST",
               "\u12e8\u12a2\u122b\u1295 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "IRDT",
               "\u12e8\u12a2\u122b\u1295 \u1230\u12d3\u1275",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u12e8\u12a2\u1235\u1270\u122d \u12f0\u1234\u1275 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "EAST",
               "\u12e8\u12a2\u1235\u1270\u122d \u12f0\u1234\u1275 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "EASST",
               "\u12e8\u12a2\u1235\u1270\u122d \u12f0\u1234\u1275 \u1230\u12d3\u1275",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u1230\u121c\u1293\u12ca \u121d\u12a5\u122b\u1265 \u12e8\u121c\u12ad\u1232\u12ae \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PST",
               "\u1230\u121c\u1293\u12ca \u121d\u12a5\u122b\u1265 \u12e8\u121c\u12ad\u1232\u12ae \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PDT",
               "\u1230\u121c\u1293\u12ca \u121d\u12a5\u122b\u1265 \u12e8\u121c\u12ad\u1232\u12ae \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u12e8\u12f1\u121e\u1295\u1275-\u12f1\u122d\u126a\u120d \u1230\u12d3\u1275",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u12e8\u1273\u1302\u12aa\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u12e8\u1276\u1295\u130b \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "TOT",
               "\u12e8\u1276\u1295\u130b \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "TOST",
               "\u12e8\u1276\u1295\u130b \u1230\u12d3\u1275",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u12e8\u1263\u1295\u130d\u120b\u12f4\u123d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "BDT",
               "\u12e8\u1263\u1295\u130d\u120b\u12f4\u123d \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "BDST",
               "\u12e8\u1263\u1295\u130d\u120b\u12f4\u123d \u1230\u12d3\u1275",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u12e8\u1354\u1229 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "PET",
               "\u12e8\u1354\u1229 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "PEST",
               "\u12e8\u1354\u1229 \u1230\u12d3\u1275",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1265 \u130d\u122a\u1295\u120b\u1295\u12f5 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "WGT",
               "\u12e8\u121d\u12d5\u122b\u1265 \u130d\u122a\u1295\u120b\u1295\u12f5 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "WGST",
               "\u12e8\u121d\u12d5\u122b\u1265 \u130d\u122a\u1295\u120b\u1295\u12f5 \u1230\u12d3\u1275",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u12e8\u12a2\u12b3\u12f6\u122d \u1230\u12d3\u1275",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u12e8\u121d\u1235\u122b\u1245 \u130d\u122a\u1295\u120b\u1295\u12f5 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "EGT",
               "\u12e8\u121d\u1235\u122b\u1245 \u130d\u122a\u1295\u120b\u1295\u12f5 \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "EGST",
               "\u12e8\u121d\u1235\u122b\u1245 \u130d\u122a\u1295\u120b\u1295\u12f5 \u1230\u12d3\u1275",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u12e8\u1263\u1205\u1228\u1230\u120b\u1324 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u12e8\u121d\u1235\u122b\u1243\u12ca \u12a2\u1295\u12f6\u1294\u12e2\u12eb \u1230\u12d3\u1275",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u12e8\u12ae\u122a\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "KST",
               "\u12e8\u12ae\u122a\u12eb \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "KDT",
               "\u12e8\u12ae\u122a\u12eb \u1230\u12d3\u1275",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u121d\u1235\u122b\u1243\u12ca \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AWST",
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u121d\u1235\u122b\u1243\u12ca \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AWDT",
               "\u12e8\u121d\u1235\u122b\u1243\u12ca \u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u12e8\u12aa\u122d\u130a\u1235\u1273\u1295 \u1230\u12d3\u1275",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a2\u1295\u12f6\u1294\u12e2\u12eb \u1230\u12d3\u1275",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u121d\u12d5\u122b\u1263\u12ca \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AEST",
               "\u12e8\u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u121d\u12d5\u122b\u1263\u12ca \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AEDT",
               "\u12e8\u121d\u12d5\u122b\u1263\u12ca \u12a0\u12cd\u1235\u1275\u122b\u120a\u12eb \u12e8\u1230\u12a0\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u12e8\u1348\u1228\u1295\u1233\u12ed \u1309\u12eb\u1293 \u1230\u12d3\u1275",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u12e8\u12ae\u120e\u121d\u1262\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "COT",
               "\u12e8\u12ae\u120e\u121d\u1262\u12eb \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "COST",
               "\u12e8\u12ae\u120e\u121d\u1262\u12eb \u1230\u12d3\u1275",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u12e8\u127a\u120a \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CLT",
               "\u12e8\u127a\u120a \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "CLST",
               "\u12e8\u127a\u120a \u1230\u12d3\u1275",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u12e8\u1302\u120d\u1260\u122d\u1275 \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u12e8\u1270\u122b\u122b \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MST",
               "\u12e8\u1270\u122b\u122b \u12e8\u1240\u1295\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MDT",
               "\u12e8\u1270\u122b\u122b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u12e8\u121b\u122d\u12b4\u1233\u1235 \u1230\u12d3\u1275",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u12e8\u12d3\u1228\u1262\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "AST",
               "\u12e8\u12d3\u1228\u1262\u12eb \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "ADT",
               "\u12e8\u12d3\u1228\u1262\u12eb \u1230\u12d3\u1275",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u12e8\u12a0\u120b\u1235\u12ab \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AKST",
               "\u12e8\u12a0\u120b\u1235\u12ab \u12e8\u1240\u1295 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AKDT",
               "\u12e8\u12a0\u120b\u1235\u12ab \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u12e8\u126a\u120b\u12f2\u126e\u1235\u1276\u12ad \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "VLAT",
               "\u12e8\u126d\u120b\u12f2\u126e\u1235\u1276\u12ad \u12e8\u1260\u130b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "VLAST",
               "\u12e8\u126d\u120b\u12f2\u126e\u1235\u1276\u12ad \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u12e8\u127b\u121e\u122e \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u12e8\u12a2\u122d\u12a9\u1275\u1235\u12ad \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "IRKT",
               "\u12a2\u122d\u12a9\u1275\u1235\u12ad \u12e8\u1260\u130b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "IRKST",
               "\u12e8\u12a2\u122d\u12a9\u1275\u1235\u12ad \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u12e8\u1302\u12ee\u122d\u1302\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "GET",
               "\u12e8\u1302\u12ee\u122d\u1302\u12eb \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "GEST",
               "\u12e8\u1302\u12ee\u122d\u1302\u12eb \u1230\u12d3\u1275",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u12e8\u1276\u12ac\u120b\u12cd \u1230\u12d3\u1275",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u12e8\u1353\u1357 \u1292\u12cd \u130a\u1292 \u1230\u12d3\u1275",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u12e8\u1348\u122d\u1293\u1295\u12f6 \u12f2 \u1296\u122e\u1295\u127b \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "FNT",
               "\u12e8\u1348\u122d\u1293\u1295\u12f6 \u12f2 \u1296\u122e\u1295\u1203 \u12e8\u1260\u130b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "FNST",
               "\u12e8\u1296\u122e\u1295\u1203 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u12e8\u127e\u12ed\u1263\u120d\u1233\u1295 \u1218\u12f0\u1260\u129b \u12e8\u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CHOT",
               "\u12e8\u127e\u12ed\u1263\u120d\u1233\u1295 \u12e8\u1260\u130b \u12e8\u1230\u12a0\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CHOST",
               "\u12e8\u127e\u12ed\u1263\u120d\u1233 \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u12e8\u1265\u122b\u1232\u120a\u12eb \u1218\u12f0\u1260\u129b \u130a\u12dc",
               "BRT",
               "\u12e8\u1265\u122b\u12da\u120b \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "BRST",
               "\u12e8\u1265\u122b\u12da\u120b\u12ca \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "BRT",
            };
        final String[] China = new String[] {
               "\u12e8\u127b\u12ed\u1293 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CST",
               "\u12e8\u127b\u12ed\u1293 \u12e8\u1240\u1295 \u1265\u122d\u1203\u1295 \u1230\u12d3\u1275",
               "CDT",
               "\u12e8\u127b\u12ed\u1293 \u1230\u12d3\u1275",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u12e8\u12a0\u122d\u1218\u1292\u12eb \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "AMT",
               "\u12e8\u12a0\u122d\u1218\u1292\u12eb \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "AMST",
               "\u12e8\u12a0\u122d\u1218\u1292\u12eb \u1230\u12d3\u1275",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u12e8\u1233\u121b\u122b \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAMT",
               "\u12e8\u1233\u121b\u122b \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAMST",
               "\u12e8\u1233\u121b\u122b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u12e8\u1205\u1295\u12f5 \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u12e8\u12a9\u12ad \u12f0\u1234\u1276\u127d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275",
               "CKT",
               "\u12e8\u12a9\u12ad \u12f0\u1234\u1276\u127d \u130d\u121b\u123d \u12ad\u1228\u121d\u1275 \u1230\u12d3\u1275",
               "CKHST",
               "\u12e8\u12a9\u12ad \u12f0\u1234\u1276\u127d \u1230\u12d3\u1275",
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
                    "\u130d\u122a\u1295\u12ca\u127d \u121b\u12d5\u12a8\u120b\u12ca \u1230\u12d3\u1275",
                    "GMT",
                    "\u12e8\u1265\u122a\u1275\u123d \u12e8\u1260\u130b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
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
                    "\u130d\u122a\u1295\u12ca\u127d \u121b\u12d5\u12a8\u120b\u12ca \u1230\u12d3\u1275",
                    "GMT",
                    "\u12e8\u12a0\u12ed\u122a\u123d \u1218\u12f0\u1260\u129b \u1230\u12d3\u1275 \u12a0\u1246\u1323\u1320\u122d",
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
