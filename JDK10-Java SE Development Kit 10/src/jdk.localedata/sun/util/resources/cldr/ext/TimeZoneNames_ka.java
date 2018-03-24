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

public class TimeZoneNames_ka extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u10db\u10dd\u10e1\u10d9\u10dd\u10d5\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "MSK",
               "\u10db\u10dd\u10e1\u10d9\u10dd\u10d5\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MSD",
               "\u10db\u10dd\u10e1\u10d9\u10dd\u10d5\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u10d8\u10d0\u10de\u10dd\u10dc\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "JST",
               "\u10d8\u10d0\u10de\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "JDT",
               "\u10d8\u10d0\u10de\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u10de\u10d0\u10d9\u10d8\u10e1\u10e2\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PKT",
               "\u10de\u10d0\u10d9\u10d8\u10e1\u10e2\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PKST",
               "\u10de\u10d0\u10d9\u10d8\u10e1\u10e2\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u10e2\u10d0\u10d8\u10d1\u10d4\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CST",
               "\u10e2\u10d0\u10d8\u10d1\u10d4\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CDT",
               "\u10e2\u10d0\u10d8\u10d1\u10d4\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u10f0\u10dd\u10d5\u10d3\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "HOVT",
               "\u10f0\u10dd\u10d5\u10d3\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HOVST",
               "\u10f0\u10dd\u10d5\u10d3\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u10db\u10d0\u10d2\u10d0\u10d3\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "MAGT",
               "\u10db\u10d0\u10d2\u10d0\u10d3\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MAGST",
               "\u10db\u10d0\u10d2\u10d0\u10d3\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d3\u10d0 \u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "ACWST",
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d3\u10d0 \u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ACWDT",
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d3\u10d0 \u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CET",
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CEST",
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u10e1\u10d0\u10ee\u10d0\u10da\u10d8\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "SAKT",
               "\u10e1\u10d0\u10ee\u10d0\u10da\u10d8\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SAKST",
               "\u10e1\u10d0\u10ee\u10d0\u10da\u10d8\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u10de\u10d0\u10e0\u10d0\u10d2\u10d5\u10d0\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PYT",
               "\u10de\u10d0\u10e0\u10d0\u10d2\u10d5\u10d0\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PYST",
               "\u10de\u10d0\u10e0\u10d0\u10d2\u10d5\u10d0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PYT",
            };
        final String[] Malaysia = new String[] {
               "\u10db\u10d0\u10da\u10d0\u10d8\u10d6\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "EST",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EDT",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u10da\u10dd\u10e0\u10d3-\u10f0\u10d0\u10e3\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "LHST",
               "\u10da\u10dd\u10e0\u10d3-\u10f0\u10d0\u10e3\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "LHDT",
               "\u10da\u10dd\u10e0\u10d3-\u10f0\u10d0\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d6\u10d4\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "NZST",
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d6\u10d4\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NZDT",
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d6\u10d4\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u10d8\u10dc\u10d3\u10dd\u10d4\u10d7\u10d8\u10e1 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u10d8\u10d0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "YAKT",
               "\u10d8\u10d0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "YAKST",
               "\u10d8\u10d0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u10db\u10d0\u10d5\u10e0\u10d8\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "MUT",
               "\u10db\u10d0\u10d5\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MUST",
               "\u10db\u10d0\u10d5\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10e2\u10d8\u10db\u10dd\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u10e1\u10dd\u10da\u10dd\u10db\u10dd\u10dc\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u10d9\u10dd\u10e1\u10e0\u10d4\u10e1 \u10d3\u10e0\u10dd",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u10db\u10d0\u10e0\u10e8\u10d0\u10da\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "EET",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EEST",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u10dc\u10d8\u10e3\u10e4\u10d0\u10e3\u10dc\u10d3\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "NST",
               "\u10dc\u10d8\u10e3\u10e4\u10d0\u10e3\u10dc\u10d3\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NDT",
               "\u10dc\u10d8\u10e3\u10e4\u10d0\u10e3\u10dc\u10d3\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u10d0\u10d5\u10e6\u10d0\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u10f0\u10dd\u10dc\u10d9\u10dd\u10dc\u10d2\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "HKT",
               "\u10f0\u10dd\u10dc\u10d9\u10dd\u10dc\u10d2\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HKST",
               "\u10f0\u10dd\u10dc\u10d9\u10dd\u10dc\u10d2\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "ART",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ARST",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u10d0\u10e2\u10da\u10d0\u10dc\u10e2\u10d8\u10d9\u10d8\u10e1 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AST",
               "\u10d0\u10e2\u10da\u10d0\u10dc\u10e2\u10d8\u10d9\u10d8\u10e1 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ADT",
               "\u10d0\u10e2\u10da\u10d0\u10dc\u10e2\u10d8\u10d9\u10d8\u10e1 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u10de\u10dd\u10dc\u10d0\u10de\u10d4\u10e1 \u10d3\u10e0\u10dd",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u10d1\u10dd\u10da\u10d8\u10d5\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u10e1\u10d4\u10dc-\u10de\u10d8\u10d4\u10e0\u10d8\u10e1 \u10d3\u10d0 \u10db\u10d8\u10d9\u10d4\u10da\u10dd\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PMST",
               "\u10e1\u10d4\u10dc-\u10de\u10d8\u10d4\u10e0\u10d8\u10e1 \u10d3\u10d0 \u10db\u10d8\u10d9\u10d4\u10da\u10dd\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PMDT",
               "\u10e1\u10d4\u10dc-\u10de\u10d8\u10d4\u10e0\u10d8\u10e1 \u10d3\u10d0 \u10db\u10d8\u10d9\u10d4\u10da\u10dd\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u10d8\u10dc\u10d3\u10dd\u10e9\u10d8\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u10d4\u10d9\u10d0\u10e2\u10d4\u10e0\u10d8\u10dc\u10d1\u10e3\u10e0\u10d2\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "YEKT",
               "\u10d4\u10d9\u10d0\u10e2\u10d4\u10e0\u10d8\u10dc\u10d1\u10e3\u10e0\u10d2\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "YEKST",
               "\u10d4\u10d9\u10d0\u10e2\u10d4\u10e0\u10d8\u10dc\u10d1\u10e3\u10e0\u10d2\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u10db\u10d0\u10da\u10d3\u10d8\u10d5\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u10e2\u10d0\u10d8\u10e2\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u10d8\u10e1\u10e0\u10d0\u10d4\u10da\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "IST",
               "\u10d8\u10e1\u10e0\u10d0\u10d4\u10da\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IDT",
               "\u10d8\u10e1\u10e0\u10d0\u10d4\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d8\u10dc\u10d3\u10dd\u10dc\u10d4\u10d6\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u10d5\u10dd\u10da\u10d8\u10e1\u10d8 \u10d3\u10d0 \u10e4\u10e3\u10e2\u10e3\u10dc\u10d0\u10e1 \u10d3\u10e0\u10dd",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u10e1\u10d0\u10db\u10ee\u10e0\u10d4\u10d7 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u10e1\u10d8\u10dd\u10d5\u10d0\u10e1 \u10d3\u10e0\u10dd",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u10da\u10d0\u10d8\u10dc\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u10e3\u10d6\u10d1\u10d4\u10d9\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "UZT",
               "\u10e3\u10d6\u10d1\u10d4\u10d9\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "UZST",
               "\u10e3\u10d6\u10d1\u10d4\u10d9\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u10dd\u10db\u10e1\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "OMST",
               "\u10dd\u10db\u10e1\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "OMSST",
               "\u10dd\u10db\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u10e1\u10d4\u10d8\u10e8\u10d4\u10da\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u10e3\u10e0\u10e3\u10d2\u10d5\u10d0\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "UYT",
               "\u10e3\u10e0\u10e3\u10d2\u10d5\u10d0\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "UYST",
               "\u10e3\u10e0\u10e3\u10d2\u10d5\u10d0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u10dc\u10d4\u10de\u10d0\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u10e3\u10da\u10d0\u10dc-\u10d1\u10d0\u10e2\u10dd\u10e0\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "ULAT",
               "\u10e3\u10da\u10d0\u10dc-\u10d1\u10d0\u10e2\u10dd\u10e0\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ULAST",
               "\u10e3\u10da\u10d0\u10dc-\u10d1\u10d0\u10e2\u10dd\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CST",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CDT",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d3\u10e0\u10dd",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u10e9\u10e3\u10e3\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u10dc\u10d8\u10e3\u10d4\u10e1 \u10d3\u10e0\u10dd",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u10d5\u10d4\u10d8\u10d9\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u10e4\u10dd\u10da\u10d9\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "FKT",
               "\u10e4\u10dd\u10da\u10d9\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "FKST",
               "\u10e4\u10dd\u10da\u10d9\u10da\u10d4\u10dc\u10d3\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u10d5\u10d0\u10dc\u10e3\u10d0\u10e2\u10e3\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "VUT",
               "\u10d5\u10d0\u10dc\u10e3\u10d0\u10e2\u10e3\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "VUST",
               "\u10d5\u10d0\u10dc\u10e3\u10d0\u10e2\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u10dc\u10dd\u10d5\u10dd\u10e1\u10d8\u10d1\u10d8\u10e0\u10e1\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "NOVT",
               "\u10dc\u10dd\u10d5\u10dd\u10e1\u10d8\u10d1\u10d8\u10e0\u10e1\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NOVST",
               "\u10dc\u10dd\u10d5\u10dd\u10e1\u10d8\u10d1\u10d8\u10e0\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u10e1\u10d8\u10dc\u10d2\u10d0\u10de\u10e3\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u10d0\u10d6\u10dd\u10e0\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AZOT",
               "\u10d0\u10d6\u10dd\u10e0\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AZOST",
               "\u10d0\u10d6\u10dd\u10e0\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u10d0\u10de\u10d8\u10d0\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "WSST",
               "\u10d0\u10de\u10d8\u10d0\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WSDT",
               "\u10d0\u10de\u10d8\u10d0\u10e1 \u10d3\u10e0\u10dd",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u10d1\u10e3\u10e2\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u10e1\u10e3\u10e0\u10d8\u10dc\u10d0\u10db\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u10dc\u10d0\u10e3\u10e0\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u10d9\u10e0\u10d0\u10e1\u10dc\u10dd\u10d8\u10d0\u10e0\u10e1\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "KRAT",
               "\u10d9\u10e0\u10d0\u10e1\u10dc\u10dd\u10d8\u10d0\u10e0\u10e1\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "KRAST",
               "\u10d9\u10e0\u10d0\u10e1\u10dc\u10dd\u10d8\u10d0\u10e0\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10e7\u10d0\u10d6\u10d0\u10ee\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u10db\u10d8\u10d0\u10dc\u10db\u10d0\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u10e8\u10dd\u10d1\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u10d0\u10db\u10d0\u10d6\u10dd\u10dc\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AMT",
               "\u10d0\u10db\u10d0\u10d6\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AMST",
               "\u10d0\u10db\u10d0\u10d6\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10e7\u10d0\u10d6\u10d0\u10ee\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u10e4\u10d8\u10ef\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "FJT",
               "\u10e4\u10d8\u10ef\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "FJST",
               "\u10e4\u10d8\u10ef\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u10e0\u10d4\u10d8\u10e3\u10dc\u10d8\u10dd\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u10e5\u10dd\u10e5\u10dd\u10e1\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u10e9\u10d0\u10e2\u10d4\u10db\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CHAST",
               "\u10e9\u10d0\u10e2\u10d4\u10db\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CHADT",
               "\u10e9\u10d0\u10e2\u10d4\u10db\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u10d5\u10dd\u10e1\u10e2\u10dd\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "ART",
               "\u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ARST",
               "\u10d0\u10e0\u10d2\u10d4\u10dc\u10e2\u10d8\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u10d2\u10d0\u10db\u10d1\u10d8\u10d4\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Tuvalu = new String[] {
               "\u10e2\u10e3\u10d5\u10d0\u10da\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u10d2\u10d0\u10da\u10d0\u10de\u10d0\u10d2\u10dd\u10e1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u10db\u10d0\u10e5\u10d9\u10e3\u10dd\u10e0\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u10d5\u10d4\u10dc\u10d4\u10e1\u10e3\u10d4\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u10f0\u10d0\u10d5\u10d0\u10d8\u10e1 \u10d3\u10d0 \u10d0\u10da\u10d4\u10e3\u10e2\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "HAST",
               "\u10f0\u10d0\u10d5\u10d0\u10d8\u10e1 \u10d3\u10d0 \u10d0\u10da\u10d4\u10e3\u10e2\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HADT",
               "\u10f0\u10d0\u10d5\u10d0\u10d8\u10e1 \u10d3\u10d0 \u10d0\u10da\u10d4\u10e3\u10e2\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "ACST",
               "\u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ACDT",
               "\u10ea\u10d4\u10dc\u10e2\u10e0\u10d0\u10da\u10e3\u10e0\u10d8 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PST",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PDT",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u10e4\u10d4\u10dc\u10d8\u10e5\u10e1\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u10d7\u10e3\u10e0\u10e5\u10db\u10d4\u10dc\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "TMT",
               "\u10d7\u10e3\u10e0\u10e5\u10db\u10d4\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TMST",
               "\u10d7\u10e3\u10e0\u10e5\u10db\u10d4\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "WET",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WEST",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u10d9\u10d0\u10d1\u10dd-\u10d5\u10d4\u10e0\u10d3\u10d4\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CVT",
               "\u10d9\u10d0\u10d1\u10dd-\u10d5\u10d4\u10e0\u10d3\u10d4\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CVST",
               "\u10d9\u10d0\u10d1\u10dd-\u10d5\u10d4\u10e0\u10d3\u10d4\u10e1 \u10d3\u10e0\u10dd",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u10dc\u10dd\u10e0\u10e4\u10dd\u10da\u10d9\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u10d2\u10d0\u10d8\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u10de\u10d8\u10e2\u10d9\u10d4\u10e0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u10e0\u10dd\u10d7\u10d4\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u10e1\u10d0\u10db\u10dd\u10d0\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "SST",
               "\u10e1\u10d0\u10db\u10dd\u10d0\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "SDT",
               "\u10e1\u10d0\u10db\u10dd\u10d0\u10e1 \u10d3\u10e0\u10dd",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u10de\u10d0\u10da\u10d0\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u10e8\u10dd\u10e0\u10d4\u10e3\u10da\u10d8 \u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d4\u10d5\u10e0\u10dd\u10de\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u10d0\u10d6\u10d4\u10e0\u10d1\u10d0\u10d8\u10ef\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AZT",
               "\u10d0\u10d6\u10d4\u10e0\u10d1\u10d0\u10d8\u10ef\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AZST",
               "\u10d0\u10d6\u10d4\u10e0\u10d1\u10d0\u10d8\u10ef\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u10db\u10dd\u10e3\u10e1\u10dd\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "MST",
               "\u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MDT",
               "\u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10ec\u10e7\u10dc\u10d0\u10e0\u10d8 \u10dd\u10d9\u10d4\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u10d3\u10d4\u10d5\u10d8\u10e1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u10d9\u10e3\u10d1\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CST",
               "\u10d9\u10e3\u10d1\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CDT",
               "\u10d9\u10e3\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CAT",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CAST",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10e4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u10d2\u10e0\u10d8\u10dc\u10d5\u10d8\u10e9\u10d8\u10e1 \u10e1\u10d0\u10e8\u10e3\u10d0\u10da\u10dd \u10d3\u10e0\u10dd",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u10e4\u10d8\u10da\u10d8\u10de\u10d8\u10dc\u10d4\u10d1\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PHT",
               "\u10e4\u10d8\u10da\u10d8\u10de\u10d8\u10dc\u10d4\u10d1\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PHST",
               "\u10e4\u10d8\u10da\u10d8\u10de\u10d8\u10dc\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u10e4\u10e0\u10d0\u10dc\u10d2\u10e3\u10da\u10d8 \u10e1\u10d0\u10db\u10ee\u10e0\u10d4\u10d7\u10d8\u10e1 \u10d3\u10d0 \u10d0\u10dc\u10e2\u10d0\u10e0\u10e5\u10e2\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u10e1\u10d0\u10db\u10ee\u10e0\u10d4\u10d7 \u10d2\u10d4\u10dd\u10e0\u10d2\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d9\u10d0\u10da\u10d4\u10d3\u10dd\u10dc\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "NCT",
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d9\u10d0\u10da\u10d4\u10d3\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NCST",
               "\u10d0\u10ee\u10d0\u10da\u10d8 \u10d9\u10d0\u10da\u10d4\u10d3\u10dd\u10dc\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u10d1\u10e0\u10e3\u10dc\u10d4\u10d8-\u10d3\u10d0\u10e0\u10e3\u10e1\u10d0\u10da\u10d0\u10db\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u10d8\u10e0\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "IRST",
               "\u10d8\u10e0\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd\u10d8\u10e1 \u10e1\u10d0\u10e0\u10e2\u10e7\u10d4\u10da\u10d8",
               "IRDT",
               "\u10d8\u10e0\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u10d0\u10e6\u10d3\u10d2\u10dd\u10db\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "EAST",
               "\u10d0\u10e6\u10d3\u10d2\u10dd\u10db\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EASST",
               "\u10d0\u10e6\u10d3\u10d2\u10dd\u10db\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd-\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PST",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd-\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PDT",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd-\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10db\u10d4\u10e5\u10e1\u10d8\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u10d3\u10e3\u10db\u10dd\u10dc-\u10d3\u10e3\u10e0\u10d5\u10d8\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u10e2\u10d0\u10ef\u10d8\u10d9\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u10e2\u10dd\u10dc\u10d2\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "TOT",
               "\u10e2\u10dd\u10dc\u10d2\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TOST",
               "\u10e2\u10dd\u10dc\u10d2\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u10d1\u10d0\u10dc\u10d2\u10da\u10d0\u10d3\u10d4\u10e8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "BDT",
               "\u10d1\u10d0\u10dc\u10d2\u10da\u10d0\u10d3\u10d4\u10e8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BDST",
               "\u10d1\u10d0\u10dc\u10d2\u10da\u10d0\u10d3\u10d4\u10e8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u10de\u10d4\u10e0\u10e3\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "PET",
               "\u10de\u10d4\u10e0\u10e3\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PEST",
               "\u10de\u10d4\u10e0\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "WGT",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WGST",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u10d4\u10d9\u10d5\u10d0\u10d3\u10dd\u10e0\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "EGT",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EGST",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d2\u10e0\u10d4\u10dc\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u10e1\u10de\u10d0\u10e0\u10e1\u10d4\u10d7\u10d8\u10e1 \u10e7\u10e3\u10e0\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d8\u10dc\u10d3\u10dd\u10dc\u10d4\u10d6\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u10d9\u10dd\u10e0\u10d4\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "KST",
               "\u10d9\u10dd\u10e0\u10d4\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "KDT",
               "\u10d9\u10dd\u10e0\u10d4\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AWST",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AWDT",
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u10e7\u10d8\u10e0\u10d2\u10d8\u10d6\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u10d3\u10d0\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d8\u10dc\u10d3\u10dd\u10dc\u10d4\u10d6\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AEST",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AEDT",
               "\u10d0\u10e6\u10db\u10dd\u10e1\u10d0\u10d5\u10da\u10d4\u10d7 \u10d0\u10d5\u10e1\u10e2\u10e0\u10d0\u10da\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u10e1\u10d0\u10e4\u10e0\u10d0\u10dc\u10d2\u10d4\u10d7\u10d8\u10e1 \u10d2\u10d5\u10d8\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u10d9\u10dd\u10da\u10e3\u10db\u10d1\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "COT",
               "\u10d9\u10dd\u10da\u10e3\u10db\u10d1\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "COST",
               "\u10d9\u10dd\u10da\u10e3\u10db\u10d1\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u10e9\u10d8\u10da\u10d4\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CLT",
               "\u10e9\u10d8\u10da\u10d4\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CLST",
               "\u10e9\u10d8\u10da\u10d4\u10e1 \u10d3\u10e0\u10dd",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u10d2\u10d8\u10da\u10d1\u10d4\u10e0\u10e2\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10db\u10d0\u10e3\u10dc\u10d7\u10d8\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "MST",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10db\u10d0\u10e3\u10dc\u10d7\u10d8\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MDT",
               "\u10e9\u10e0\u10d3\u10d8\u10da\u10dd\u10d4\u10d7 \u10d0\u10db\u10d4\u10e0\u10d8\u10d9\u10d8\u10e1 \u10db\u10d0\u10e3\u10dc\u10d7\u10d8\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u10db\u10d0\u10e0\u10d9\u10d8\u10d6\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u10d0\u10e0\u10d0\u10d1\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AST",
               "\u10d0\u10e0\u10d0\u10d1\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "ADT",
               "\u10d0\u10e0\u10d0\u10d1\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u10d0\u10da\u10d0\u10e1\u10d9\u10d0\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AKST",
               "\u10d0\u10da\u10d0\u10e1\u10d9\u10d0\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AKDT",
               "\u10d0\u10da\u10d0\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u10d5\u10da\u10d0\u10d3\u10d8\u10d5\u10dd\u10e1\u10e2\u10dd\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "VLAT",
               "\u10d5\u10da\u10d0\u10d3\u10d8\u10d5\u10dd\u10e1\u10e2\u10dd\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "VLAST",
               "\u10d5\u10da\u10d0\u10d3\u10d8\u10d5\u10dd\u10e1\u10e2\u10dd\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u10e9\u10d0\u10db\u10dd\u10e0\u10dd\u10e1 \u10d3\u10e0\u10dd",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u10d8\u10e0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "IRKT",
               "\u10d8\u10e0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IRKST",
               "\u10d8\u10e0\u10d9\u10e3\u10e2\u10e1\u10d9\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u10e1\u10d0\u10e5\u10d0\u10e0\u10d7\u10d5\u10d4\u10da\u10dd\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "GET",
               "\u10e1\u10d0\u10e5\u10d0\u10e0\u10d7\u10d5\u10d4\u10da\u10dd\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "GEST",
               "\u10e1\u10d0\u10e5\u10d0\u10e0\u10d7\u10d5\u10d4\u10da\u10dd\u10e1 \u10d3\u10e0\u10dd",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u10e2\u10dd\u10d9\u10d4\u10da\u10d0\u10e3\u10e1 \u10d3\u10e0\u10dd",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u10de\u10d0\u10de\u10e3\u10d0-\u10d0\u10ee\u10d0\u10da\u10d8 \u10d2\u10d5\u10d8\u10dc\u10d4\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u10e4\u10d4\u10e0\u10dc\u10d0\u10dc\u10d3\u10dd-\u10d3\u10d4-\u10dc\u10dd\u10e0\u10dd\u10dc\u10d8\u10d0\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "FNT",
               "\u10e4\u10d4\u10e0\u10dc\u10d0\u10dc\u10d3\u10dd-\u10d3\u10d4-\u10dc\u10dd\u10e0\u10dd\u10dc\u10d8\u10d0\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "FNST",
               "\u10e4\u10d4\u10e0\u10dc\u10d0\u10dc\u10d3\u10dd-\u10d3\u10d4-\u10dc\u10dd\u10e0\u10dd\u10dc\u10d8\u10d0\u10e1 \u10d3\u10e0\u10dd",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u10e9\u10dd\u10d8\u10d1\u10d0\u10da\u10e1\u10d0\u10dc\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CHOT",
               "\u10e9\u10dd\u10d8\u10d1\u10d0\u10da\u10e1\u10d0\u10dc\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CHOST",
               "\u10e9\u10dd\u10d8\u10d1\u10d0\u10da\u10e1\u10d0\u10dc\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u10d1\u10e0\u10d0\u10d6\u10d8\u10da\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "BRT",
               "\u10d1\u10e0\u10d0\u10d6\u10d8\u10da\u10d8\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BRST",
               "\u10d1\u10e0\u10d0\u10d6\u10d8\u10da\u10d8\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "BRT",
            };
        final String[] China = new String[] {
               "\u10e9\u10d8\u10dc\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CST",
               "\u10e9\u10d8\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd\u10d8\u10e1 \u10e1\u10d0\u10e0\u10e2\u10e7\u10d4\u10da\u10d8",
               "CDT",
               "\u10e9\u10d8\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u10e1\u10dd\u10db\u10ee\u10d4\u10d7\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "AMT",
               "\u10e1\u10dd\u10db\u10ee\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AMST",
               "\u10e1\u10dd\u10db\u10ee\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "AMT",
            };
        final String[] India = new String[] {
               "\u10d8\u10dc\u10d3\u10dd\u10d4\u10d7\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u10d9\u10e3\u10d9\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
               "CKT",
               "\u10d9\u10e3\u10d9\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10dc\u10d0\u10ee\u10d4\u10d5\u10e0\u10d0\u10d3 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
               "CKHST",
               "\u10d9\u10e3\u10d9\u10d8\u10e1 \u10d9\u10e3\u10dc\u10eb\u10e3\u10da\u10d4\u10d1\u10d8\u10e1 \u10d3\u10e0\u10dd",
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
                    "\u10d2\u10e0\u10d8\u10dc\u10d5\u10d8\u10e9\u10d8\u10e1 \u10e1\u10d0\u10e8\u10e3\u10d0\u10da\u10dd \u10d3\u10e0\u10dd",
                    "GMT",
                    "\u10d1\u10e0\u10d8\u10e2\u10d0\u10dc\u10d4\u10d7\u10d8\u10e1 \u10d6\u10d0\u10e4\u10ee\u10e3\u10da\u10d8\u10e1 \u10d3\u10e0\u10dd",
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
                    "\u10d2\u10e0\u10d8\u10dc\u10d5\u10d8\u10e9\u10d8\u10e1 \u10e1\u10d0\u10e8\u10e3\u10d0\u10da\u10dd \u10d3\u10e0\u10dd",
                    "GMT",
                    "\u10d8\u10e0\u10da\u10d0\u10dc\u10d3\u10d8\u10d8\u10e1 \u10e1\u10e2\u10d0\u10dc\u10d3\u10d0\u10e0\u10e2\u10e3\u10da\u10d8 \u10d3\u10e0\u10dd",
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
