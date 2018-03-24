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

public class TimeZoneNames_th extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e01\u0e25\u0e32\u0e07",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e21\u0e2d\u0e2a\u0e42\u0e01",
               "MSK",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e21\u0e2d\u0e2a\u0e42\u0e01",
               "MSD",
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e2d\u0e2a\u0e42\u0e01",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0d\u0e35\u0e48\u0e1b\u0e38\u0e48\u0e19",
               "JST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e0d\u0e35\u0e48\u0e1b\u0e38\u0e48\u0e19",
               "JDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e0d\u0e35\u0e48\u0e1b\u0e38\u0e48\u0e19",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1b\u0e32\u0e01\u0e35\u0e2a\u0e16\u0e32\u0e19",
               "PKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1b\u0e32\u0e01\u0e35\u0e2a\u0e16\u0e32\u0e19",
               "PKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1b\u0e32\u0e01\u0e35\u0e2a\u0e16\u0e32\u0e19",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e44\u0e17\u0e40\u0e1b",
               "CST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e44\u0e17\u0e40\u0e1b",
               "CDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e44\u0e17\u0e40\u0e1b",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2e\u0e2d\u0e1f\u0e14\u0e4c",
               "HOVT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2e\u0e2d\u0e1f\u0e14\u0e4c",
               "HOVST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2e\u0e2d\u0e1f\u0e14\u0e4c",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e21\u0e32\u0e01\u0e32\u0e14\u0e32\u0e19",
               "MAGT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e21\u0e32\u0e01\u0e32\u0e14\u0e32\u0e19",
               "MAGST",
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e01\u0e32\u0e14\u0e32\u0e19",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "ACWST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "ACWDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e01\u0e25\u0e32\u0e07",
               "CET",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e01\u0e25\u0e32\u0e07",
               "CEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e01\u0e25\u0e32\u0e07",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0b\u0e32\u0e04\u0e32\u0e25\u0e34\u0e19",
               "SAKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e0b\u0e32\u0e04\u0e32\u0e25\u0e34\u0e19",
               "SAKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e0b\u0e32\u0e04\u0e32\u0e25\u0e34\u0e19",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1b\u0e32\u0e23\u0e32\u0e01\u0e27\u0e31\u0e22",
               "PYT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1b\u0e32\u0e23\u0e32\u0e01\u0e27\u0e31\u0e22",
               "PYST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1b\u0e32\u0e23\u0e32\u0e01\u0e27\u0e31\u0e22",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e40\u0e01\u0e23",
               "ACT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e32\u0e40\u0e01\u0e23",
               "ACST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e40\u0e01\u0e23",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e40\u0e25\u0e40\u0e0b\u0e35\u0e22",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "EST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "EDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e25\u0e2d\u0e23\u0e4c\u0e14\u0e42\u0e2e\u0e27\u0e4c",
               "LHST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e02\u0e2d\u0e07\u0e25\u0e2d\u0e23\u0e4c\u0e14\u0e42\u0e2e\u0e27\u0e4c",
               "LHDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e25\u0e2d\u0e23\u0e4c\u0e14\u0e42\u0e2e\u0e27",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e19\u0e34\u0e27\u0e0b\u0e35\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NZST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e19\u0e34\u0e27\u0e0b\u0e35\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NZDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e19\u0e34\u0e27\u0e0b\u0e35\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e2b\u0e32\u0e2a\u0e21\u0e38\u0e17\u0e23\u0e2d\u0e34\u0e19\u0e40\u0e14\u0e35\u0e22",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e22\u0e32\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "YAKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e22\u0e32\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "YAKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e22\u0e32\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e21\u0e2d\u0e23\u0e34\u0e40\u0e0a\u0e35\u0e22\u0e2a",
               "MUT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e02\u0e2d\u0e07\u0e21\u0e2d\u0e23\u0e34\u0e40\u0e0a\u0e35\u0e22\u0e2a",
               "MUST",
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e2d\u0e23\u0e34\u0e40\u0e0a\u0e35\u0e22\u0e2a",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e34\u0e21\u0e2d\u0e23\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e42\u0e0b\u0e42\u0e25\u0e21\u0e2d\u0e19",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e2d\u0e2a\u0e44\u0e23",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e21\u0e32\u0e23\u0e4c\u0e41\u0e0a\u0e25\u0e25\u0e4c",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EET",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e19\u0e34\u0e27\u0e1f\u0e31\u0e19\u0e14\u0e4c\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e19\u0e34\u0e27\u0e1f\u0e31\u0e19\u0e14\u0e4c\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e19\u0e34\u0e27\u0e1f\u0e31\u0e19\u0e14\u0e4c\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e31\u0e1f\u0e01\u0e32\u0e19\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2e\u0e48\u0e2d\u0e07\u0e01\u0e07",
               "HKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2e\u0e48\u0e2d\u0e07\u0e01\u0e07",
               "HKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2e\u0e48\u0e2d\u0e07\u0e01\u0e07",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ART",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ARST",
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e2d\u0e15\u0e41\u0e25\u0e19\u0e15\u0e34\u0e01",
               "AST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e02\u0e2d\u0e07\u0e41\u0e2d\u0e15\u0e41\u0e25\u0e19\u0e15\u0e34\u0e01",
               "ADT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e2d\u0e15\u0e41\u0e25\u0e19\u0e15\u0e34\u0e01",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e1b\u0e40\u0e19\u0e1b",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e1a\u0e25\u0e34\u0e40\u0e27\u0e35\u0e22",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e0b\u0e07\u0e1b\u0e35\u0e41\u0e22\u0e23\u0e4c\u0e41\u0e25\u0e30\u0e21\u0e35\u0e40\u0e01\u0e2d\u0e25\u0e07",
               "PMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e02\u0e2d\u0e07\u0e41\u0e0b\u0e07\u0e1b\u0e35\u0e41\u0e22\u0e23\u0e4c\u0e41\u0e25\u0e30\u0e21\u0e35\u0e40\u0e01\u0e2d\u0e25\u0e07",
               "PMDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e0b\u0e07\u0e1b\u0e35\u0e41\u0e22\u0e23\u0e4c\u0e41\u0e25\u0e30\u0e21\u0e35\u0e40\u0e01\u0e2d\u0e25\u0e07",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e19\u0e42\u0e14\u0e08\u0e35\u0e19",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e22\u0e04\u0e32\u0e40\u0e15\u0e23\u0e34\u0e19\u0e1a\u0e39\u0e23\u0e4c\u0e01",
               "YEKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e22\u0e04\u0e32\u0e40\u0e15\u0e23\u0e34\u0e19\u0e1a\u0e39\u0e23\u0e4c\u0e01",
               "YEKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e22\u0e04\u0e32\u0e40\u0e15\u0e23\u0e34\u0e19\u0e1a\u0e39\u0e23\u0e4c\u0e01",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e31\u0e25\u0e14\u0e35\u0e1f\u0e2a\u0e4c",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e32\u0e2e\u0e35\u0e15\u0e35",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e34\u0e2a\u0e23\u0e32\u0e40\u0e2d\u0e25",
               "IST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e2d\u0e34\u0e2a\u0e23\u0e32\u0e40\u0e2d\u0e25",
               "IDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e2a\u0e23\u0e32\u0e40\u0e2d\u0e25",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e19\u0e42\u0e14\u0e19\u0e35\u0e40\u0e0b\u0e35\u0e22\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e27\u0e32\u0e25\u0e25\u0e34\u0e2a\u0e41\u0e25\u0e30\u0e1f\u0e38\u0e15\u0e39\u0e19\u0e32",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e43\u0e15\u0e49",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e0b\u0e27\u0e32",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e44\u0e25\u0e19\u0e4c",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e38\u0e0b\u0e40\u0e1a\u0e01\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "UZT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e38\u0e0b\u0e40\u0e1a\u0e01\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "UZST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e38\u0e0b\u0e40\u0e1a\u0e01\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e2d\u0e21\u0e2a\u0e04\u0e4c",
               "OMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e2d\u0e21\u0e2a\u0e04\u0e4c",
               "OMSST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e2a\u0e04\u0e4c",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e0b\u0e40\u0e0a\u0e25\u0e2a\u0e4c",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e38\u0e23\u0e38\u0e01\u0e27\u0e31\u0e22",
               "UYT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e38\u0e23\u0e38\u0e01\u0e27\u0e31\u0e22",
               "UYST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e38\u0e23\u0e38\u0e01\u0e27\u0e31\u0e22",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e19\u0e1b\u0e32\u0e25",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e39\u0e25\u0e32\u0e19\u0e1a\u0e32\u0e15\u0e2d\u0e23\u0e4c",
               "ULAT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e39\u0e25\u0e32\u0e19\u0e1a\u0e32\u0e15\u0e2d\u0e23\u0e4c",
               "ULAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e39\u0e25\u0e32\u0e19\u0e1a\u0e32\u0e15\u0e2d\u0e23\u0e4c",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "CST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "CDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e0a\u0e38\u0e01",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e19\u0e35\u0e2d\u0e39\u0e40\u0e2d",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e30\u0e40\u0e27\u0e01",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e1f\u0e2d\u0e25\u0e4c\u0e01\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "FKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e1f\u0e2d\u0e25\u0e4c\u0e01\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "FKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e1f\u0e2d\u0e25\u0e4c\u0e01\u0e41\u0e25\u0e19\u0e14\u0e4c",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e27\u0e32\u0e19\u0e39\u0e2d\u0e32\u0e15\u0e39",
               "VUT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e27\u0e32\u0e19\u0e39\u0e2d\u0e32\u0e15\u0e39",
               "VUST",
               "\u0e40\u0e27\u0e25\u0e32\u0e27\u0e32\u0e19\u0e39\u0e2d\u0e32\u0e15\u0e39",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e42\u0e19\u0e42\u0e27\u0e0b\u0e35\u0e1a\u0e35\u0e2a\u0e04\u0e4c",
               "NOVT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e42\u0e19\u0e42\u0e27\u0e0b\u0e35\u0e1a\u0e35\u0e2a\u0e04\u0e4c",
               "NOVST",
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e19\u0e42\u0e27\u0e0b\u0e35\u0e1a\u0e35\u0e2a\u0e04\u0e4c",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2a\u0e34\u0e07\u0e04\u0e42\u0e1b\u0e23\u0e4c",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e30\u0e42\u0e0b\u0e23\u0e4c\u0e2a",
               "AZOT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e30\u0e42\u0e0b\u0e23\u0e4c\u0e2a",
               "AZOST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e30\u0e42\u0e0b\u0e23\u0e4c\u0e2a",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e1b\u0e35\u0e2d\u0e32",
               "WSST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e2d\u0e32\u0e1b\u0e35\u0e2d\u0e32",
               "WSDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e1b\u0e35\u0e2d\u0e32",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e20\u0e39\u0e0f\u0e32\u0e19",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e0b\u0e39\u0e23\u0e34\u0e19\u0e32\u0e40\u0e21",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e19\u0e32\u0e2d\u0e39\u0e23\u0e39",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e04\u0e23\u0e31\u0e2a\u0e42\u0e19\u0e22\u0e32\u0e2a\u0e04\u0e4c",
               "KRAT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e04\u0e23\u0e31\u0e2a\u0e42\u0e19\u0e22\u0e32\u0e2a\u0e04\u0e4c",
               "KRAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e23\u0e31\u0e2a\u0e42\u0e19\u0e22\u0e32\u0e2a\u0e04\u0e4c",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e32\u0e0b\u0e31\u0e04\u0e2a\u0e16\u0e32\u0e19\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e1e\u0e21\u0e48\u0e32",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e30\u0e04\u0e23\u0e34\u0e2a\u0e15\u0e4c\u0e21\u0e32\u0e2a",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e30\u0e40\u0e21\u0e0b\u0e2d\u0e19",
               "AMT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e30\u0e40\u0e21\u0e0b\u0e2d\u0e19",
               "AMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e30\u0e40\u0e21\u0e0b\u0e2d\u0e19",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e32\u0e0b\u0e31\u0e04\u0e2a\u0e16\u0e32\u0e19\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1f\u0e34\u0e08\u0e34",
               "FJT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1f\u0e34\u0e08\u0e34",
               "FJST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1f\u0e34\u0e08\u0e34",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e23\u0e2d\u0e39\u0e19\u0e35\u0e22\u0e07",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e42\u0e04\u0e42\u0e04\u0e2a",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e0a\u0e17\u0e31\u0e21",
               "CHAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e41\u0e0a\u0e17\u0e31\u0e21",
               "CHADT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e0a\u0e17\u0e31\u0e21",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e27\u0e2d\u0e2a\u0e15\u0e2d\u0e04",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ART",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ARST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e08\u0e19\u0e15\u0e34\u0e19\u0e32",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e01\u0e21\u0e40\u0e1a\u0e35\u0e22\u0e23\u0e4c",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e1b\u0e42\u0e15\u0e23\u0e1b\u0e31\u0e1f\u0e25\u0e2d\u0e1f\u0e2a\u0e04\u0e4c-\u0e04\u0e31\u0e21\u0e0a\u0e31\u0e15\u0e2a\u0e01\u0e35",
               "PETT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e1b\u0e42\u0e15\u0e23\u0e1b\u0e31\u0e1f\u0e25\u0e2d\u0e1f\u0e2a\u0e04\u0e4c-\u0e04\u0e31\u0e21\u0e0a\u0e31\u0e15\u0e2a\u0e01\u0e35",
               "PETST",
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e31\u0e21\u0e0a\u0e31\u0e15\u0e04\u0e32",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e39\u0e27\u0e32\u0e25\u0e39",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e01\u0e32\u0e25\u0e32\u0e1b\u0e32\u0e42\u0e01\u0e2a",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e30\u0e41\u0e21\u0e01\u0e04\u0e27\u0e2d\u0e23\u0e35",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e27\u0e40\u0e19\u0e0b\u0e38\u0e40\u0e2d\u0e25\u0e32",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2e\u0e32\u0e27\u0e32\u0e22-\u0e2d\u0e30\u0e25\u0e39\u0e40\u0e0a\u0e35\u0e22\u0e19",
               "HAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e2e\u0e32\u0e27\u0e32\u0e22-\u0e2d\u0e30\u0e25\u0e39\u0e40\u0e0a\u0e35\u0e22\u0e19",
               "HADT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2e\u0e32\u0e27\u0e32\u0e22-\u0e2d\u0e30\u0e25\u0e39\u0e40\u0e0a\u0e35\u0e22\u0e19",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "ACST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e17\u0e32\u0e07\u0e15\u0e2d\u0e19\u0e01\u0e25\u0e32\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "ACDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22\u0e01\u0e25\u0e32\u0e07",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e1f\u0e34\u0e19\u0e34\u0e01\u0e0b\u0e4c",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e15\u0e34\u0e23\u0e4c\u0e01\u0e40\u0e21\u0e19\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "TMT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e15\u0e34\u0e23\u0e4c\u0e01\u0e40\u0e21\u0e19\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "TMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e15\u0e34\u0e23\u0e4c\u0e01\u0e40\u0e21\u0e19\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WET",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e04\u0e1b\u0e40\u0e27\u0e34\u0e23\u0e4c\u0e14",
               "CVT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e04\u0e1b\u0e40\u0e27\u0e34\u0e23\u0e4c\u0e14",
               "CVST",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e04\u0e1b\u0e40\u0e27\u0e34\u0e23\u0e4c\u0e14",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e30\u0e19\u0e2d\u0e23\u0e4c\u0e1f\u0e2d\u0e25\u0e4c\u0e01",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e01\u0e32\u0e22\u0e2d\u0e32\u0e19\u0e32",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e1e\u0e34\u0e15\u0e41\u0e04\u0e23\u0e4c\u0e19",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e23\u0e18\u0e35\u0e23\u0e32",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0b\u0e32\u0e21\u0e31\u0e27",
               "SST",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e0b\u0e32\u0e21\u0e31\u0e27",
               "SDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e0b\u0e32\u0e21\u0e31\u0e27",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e1b\u0e32\u0e40\u0e25\u0e32",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e22\u0e38\u0e42\u0e23\u0e1b\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e44\u0e01\u0e25",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e40\u0e0b\u0e2d\u0e23\u0e4c\u0e44\u0e1a\u0e08\u0e32\u0e19",
               "AZT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e32\u0e40\u0e0b\u0e2d\u0e23\u0e4c\u0e44\u0e1a\u0e08\u0e32\u0e19",
               "AZST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e40\u0e0b\u0e2d\u0e23\u0e4c\u0e44\u0e1a\u0e08\u0e32\u0e19",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e2d\u0e27\u0e4c\u0e2a\u0e31\u0e19",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01",
               "MST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01",
               "MDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e1b\u0e0b\u0e34\u0e1f\u0e34\u0e01\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e14\u0e27\u0e34\u0e2a",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e04\u0e34\u0e27\u0e1a\u0e32",
               "CST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e02\u0e2d\u0e07\u0e04\u0e34\u0e27\u0e1a\u0e32",
               "CDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e34\u0e27\u0e1a\u0e32",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "CAT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "CAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e2d\u0e1f\u0e23\u0e34\u0e01\u0e32\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e01\u0e23\u0e35\u0e19\u0e34\u0e0a",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1f\u0e34\u0e25\u0e34\u0e1b\u0e1b\u0e34\u0e19\u0e2a\u0e4c",
               "PHT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1f\u0e34\u0e25\u0e34\u0e1b\u0e1b\u0e34\u0e19\u0e2a\u0e4c",
               "PHST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1f\u0e34\u0e25\u0e34\u0e1b\u0e1b\u0e34\u0e19\u0e2a\u0e4c",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e1f\u0e23\u0e19\u0e0a\u0e4c\u0e40\u0e0b\u0e32\u0e40\u0e17\u0e34\u0e23\u0e4c\u0e19\u0e41\u0e25\u0e30\u0e41\u0e2d\u0e19\u0e15\u0e32\u0e23\u0e4c\u0e01\u0e15\u0e34\u0e01",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e0b\u0e32\u0e17\u0e4c\u0e08\u0e2d\u0e23\u0e4c\u0e40\u0e08\u0e35\u0e22",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e19\u0e34\u0e27\u0e41\u0e04\u0e25\u0e34\u0e42\u0e14\u0e40\u0e19\u0e35\u0e22",
               "NCT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e19\u0e34\u0e27\u0e41\u0e04\u0e25\u0e34\u0e42\u0e14\u0e40\u0e19\u0e35\u0e22",
               "NCST",
               "\u0e40\u0e27\u0e25\u0e32\u0e19\u0e34\u0e27\u0e41\u0e04\u0e25\u0e34\u0e42\u0e14\u0e40\u0e19\u0e35\u0e22",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e1a\u0e23\u0e39\u0e44\u0e19\u0e14\u0e32\u0e23\u0e38\u0e2a\u0e0b\u0e32\u0e25\u0e32\u0e21",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e34\u0e2b\u0e23\u0e48\u0e32\u0e19",
               "IRST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e2d\u0e34\u0e2b\u0e23\u0e48\u0e32\u0e19",
               "IRDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e2b\u0e23\u0e48\u0e32\u0e19",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e01\u0e32\u0e30\u0e2d\u0e35\u0e2a\u0e40\u0e15\u0e2d\u0e23\u0e4c",
               "EAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e01\u0e32\u0e30\u0e2d\u0e35\u0e2a\u0e40\u0e15\u0e2d\u0e23\u0e4c",
               "EASST",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e30\u0e2d\u0e35\u0e2a\u0e40\u0e15\u0e2d\u0e23\u0e4c",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e40\u0e09\u0e35\u0e22\u0e07\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e40\u0e09\u0e35\u0e22\u0e07\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e21\u0e47\u0e01\u0e0b\u0e34\u0e42\u0e01\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e40\u0e09\u0e35\u0e22\u0e07\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e14\u0e39\u0e21\u0e2d\u0e07\u0e15\u0e4c\u0e14\u0e39\u0e23\u0e4c\u0e27\u0e34\u0e25\u0e25\u0e4c",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e17\u0e32\u0e08\u0e34\u0e01\u0e34\u0e2a\u0e16\u0e32\u0e19",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e15\u0e2d\u0e07\u0e01\u0e32",
               "TOT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e15\u0e2d\u0e07\u0e01\u0e32",
               "TOST",
               "\u0e40\u0e27\u0e25\u0e32\u0e15\u0e2d\u0e07\u0e01\u0e32",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1a\u0e31\u0e07\u0e01\u0e25\u0e32\u0e40\u0e17\u0e28",
               "BDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1a\u0e31\u0e07\u0e01\u0e25\u0e32\u0e40\u0e17\u0e28",
               "BDST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1a\u0e31\u0e07\u0e01\u0e25\u0e32\u0e40\u0e17\u0e28",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e1b\u0e23\u0e39",
               "PET",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e40\u0e1b\u0e23\u0e39",
               "PEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e1b\u0e23\u0e39",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WGT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WGST",
               "\u0e40\u0e27\u0e25\u0e32\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e2d\u0e01\u0e27\u0e32\u0e14\u0e2d\u0e23\u0e4c",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EGT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EGST",
               "\u0e40\u0e27\u0e25\u0e32\u0e01\u0e23\u0e35\u0e19\u0e41\u0e25\u0e19\u0e14\u0e4c\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e01\u0e31\u0e25\u0e1f\u0e4c",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e19\u0e42\u0e14\u0e19\u0e35\u0e40\u0e0b\u0e35\u0e22\u0e1d\u0e31\u0e48\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e40\u0e01\u0e32\u0e2b\u0e25\u0e35",
               "KST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e40\u0e01\u0e32\u0e2b\u0e25\u0e35",
               "KDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e01\u0e32\u0e2b\u0e25\u0e35",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "AWST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "AWDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e35\u0e23\u0e4c\u0e01\u0e35\u0e0b\u0e2a\u0e16\u0e32\u0e19",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e19\u0e42\u0e14\u0e19\u0e35\u0e40\u0e0b\u0e35\u0e22\u0e1d\u0e31\u0e48\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e15\u0e01",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "AEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e17\u0e32\u0e07\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01\u0e02\u0e2d\u0e07\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22",
               "AEDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e2a\u0e40\u0e15\u0e23\u0e40\u0e25\u0e35\u0e22\u0e15\u0e30\u0e27\u0e31\u0e19\u0e2d\u0e2d\u0e01",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e40\u0e1f\u0e23\u0e19\u0e0a\u0e4c\u0e40\u0e01\u0e35\u0e22\u0e19\u0e32",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e42\u0e04\u0e25\u0e2d\u0e21\u0e40\u0e1a\u0e35\u0e22",
               "COT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e42\u0e04\u0e25\u0e2d\u0e21\u0e40\u0e1a\u0e35\u0e22",
               "COST",
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e04\u0e25\u0e2d\u0e21\u0e40\u0e1a\u0e35\u0e22",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0a\u0e34\u0e25\u0e35",
               "CLT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e0a\u0e34\u0e25\u0e35",
               "CLST",
               "\u0e40\u0e27\u0e25\u0e32\u0e0a\u0e34\u0e25\u0e35",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e01\u0e34\u0e25\u0e40\u0e1a\u0e34\u0e23\u0e4c\u0e15",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e41\u0e16\u0e1a\u0e20\u0e39\u0e40\u0e02\u0e32\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "MST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e41\u0e16\u0e1a\u0e20\u0e39\u0e40\u0e02\u0e32\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "MDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e41\u0e16\u0e1a\u0e20\u0e39\u0e40\u0e02\u0e32\u0e43\u0e19\u0e2d\u0e40\u0e21\u0e23\u0e34\u0e01\u0e32\u0e40\u0e2b\u0e19\u0e37\u0e2d",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e23\u0e4c\u0e40\u0e04\u0e0b\u0e31\u0e2a",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e2b\u0e23\u0e31\u0e1a",
               "AST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e2d\u0e32\u0e2b\u0e23\u0e31\u0e1a",
               "ADT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e2b\u0e23\u0e31\u0e1a",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e30\u0e41\u0e25\u0e2a\u0e01\u0e32",
               "AKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e02\u0e2d\u0e07\u0e2d\u0e30\u0e41\u0e25\u0e2a\u0e01\u0e32",
               "AKDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e30\u0e41\u0e25\u0e2a\u0e01\u0e32",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e27\u0e25\u0e32\u0e14\u0e35\u0e27\u0e2d\u0e2a\u0e15\u0e2d\u0e04",
               "VLAT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e27\u0e25\u0e32\u0e14\u0e35\u0e27\u0e2d\u0e2a\u0e15\u0e2d\u0e04",
               "VLAST",
               "\u0e40\u0e27\u0e25\u0e32\u0e27\u0e25\u0e32\u0e14\u0e35\u0e27\u0e2d\u0e2a\u0e15\u0e2d\u0e04",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e0a\u0e32\u0e21\u0e2d\u0e23\u0e4c\u0e42\u0e23",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e35\u0e23\u0e4c\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "IRKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e35\u0e23\u0e4c\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "IRKST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e35\u0e23\u0e4c\u0e04\u0e38\u0e15\u0e2a\u0e04\u0e4c",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e08\u0e2d\u0e23\u0e4c\u0e40\u0e08\u0e35\u0e22",
               "GET",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e08\u0e2d\u0e23\u0e4c\u0e40\u0e08\u0e35\u0e22",
               "GEST",
               "\u0e40\u0e27\u0e25\u0e32\u0e08\u0e2d\u0e23\u0e4c\u0e40\u0e08\u0e35\u0e22",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e42\u0e15\u0e40\u0e01\u0e40\u0e25\u0e32",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e1b\u0e32\u0e1b\u0e31\u0e27\u0e19\u0e34\u0e27\u0e01\u0e34\u0e19\u0e35",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e40\u0e1f\u0e2d\u0e23\u0e4c\u0e19\u0e31\u0e19\u0e42\u0e14",
               "FNT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e02\u0e2d\u0e07\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e40\u0e1f\u0e2d\u0e23\u0e4c\u0e19\u0e31\u0e19\u0e42\u0e14",
               "FNST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e40\u0e1f\u0e2d\u0e23\u0e4c\u0e19\u0e31\u0e19\u0e42\u0e14",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0a\u0e2d\u0e22\u0e1b\u0e32\u0e25\u0e0a\u0e32\u0e19",
               "CHOT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e0a\u0e2d\u0e22\u0e1b\u0e32\u0e25\u0e0a\u0e32\u0e19",
               "CHOST",
               "\u0e40\u0e27\u0e25\u0e32\u0e0a\u0e2d\u0e22\u0e1b\u0e32\u0e25\u0e0a\u0e32\u0e19",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e1a\u0e23\u0e32\u0e0b\u0e34\u0e40\u0e25\u0e35\u0e22",
               "BRT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e1a\u0e23\u0e32\u0e0b\u0e34\u0e40\u0e25\u0e35\u0e22",
               "BRST",
               "\u0e40\u0e27\u0e25\u0e32\u0e1a\u0e23\u0e32\u0e0b\u0e34\u0e40\u0e25\u0e35\u0e22",
               "BRT",
            };
        final String[] China = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e08\u0e35\u0e19",
               "CST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e2d\u0e21\u0e41\u0e2a\u0e07\u0e08\u0e35\u0e19",
               "CDT",
               "\u0e40\u0e27\u0e25\u0e32\u0e08\u0e35\u0e19",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e21\u0e40\u0e19\u0e35\u0e22",
               "AMT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e21\u0e40\u0e19\u0e35\u0e22",
               "AMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e32\u0e23\u0e4c\u0e40\u0e21\u0e40\u0e19\u0e35\u0e22",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e0b\u0e32\u0e21\u0e32\u0e23\u0e32",
               "SAMT",
               "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e0b\u0e32\u0e21\u0e32\u0e23\u0e32",
               "SAMST",
               "\u0e40\u0e27\u0e25\u0e32\u0e0b\u0e32\u0e21\u0e32\u0e23\u0e32",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e2d\u0e34\u0e19\u0e40\u0e14\u0e35\u0e22",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e04\u0e38\u0e01",
               "CKT",
               "\u0e40\u0e27\u0e25\u0e32\u0e04\u0e23\u0e36\u0e48\u0e07\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e04\u0e38\u0e01",
               "CKHST",
               "\u0e40\u0e27\u0e25\u0e32\u0e2b\u0e21\u0e39\u0e48\u0e40\u0e01\u0e32\u0e30\u0e04\u0e38\u0e01",
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
                    "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e01\u0e23\u0e35\u0e19\u0e34\u0e0a",
                    "GMT",
                    "\u0e40\u0e27\u0e25\u0e32\u0e24\u0e14\u0e39\u0e23\u0e49\u0e2d\u0e19\u0e2d\u0e31\u0e07\u0e01\u0e24\u0e29",
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
                    "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e01\u0e23\u0e35\u0e19\u0e34\u0e0a",
                    "GMT",
                    "\u0e40\u0e27\u0e25\u0e32\u0e21\u0e32\u0e15\u0e23\u0e10\u0e32\u0e19\u0e44\u0e2d\u0e23\u0e4c\u0e41\u0e25\u0e19\u0e14\u0e4c",
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
