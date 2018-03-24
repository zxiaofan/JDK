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

public class TimeZoneNames_my extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u102c\u1016\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u1019\u1031\u102c\u1037\u1005\u103a\u1000\u102d\u102f\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "MSK",
               "\u1019\u1031\u102c\u1037\u1005\u103a\u1000\u102d\u102f\u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "MSD",
               "\u1019\u1031\u102c\u1037\u1005\u103a\u1000\u102d\u102f \u1021\u1001\u103b\u102d\u1014\u103a",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u1002\u103b\u1015\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "JST",
               "\u1002\u103b\u1015\u1014\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "JDT",
               "\u1002\u103b\u1015\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u1015\u102b\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PKT",
               "\u1015\u102b\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "PKST",
               "\u1015\u102b\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u1010\u102d\u102f\u1004\u103a\u1015\u1031\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CST",
               "\u1010\u102d\u102f\u1004\u103a\u1015\u1031\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CDT",
               "\u1010\u102d\u102f\u1004\u103a\u1015\u1031\u1021\u1001\u103b\u102d\u1014\u103a",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u101f\u102d\u102f\u1038\u1017\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "HOVT",
               "\u101f\u102d\u102f\u1038\u1017\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "HOVST",
               "\u101f\u102d\u102f\u1038\u1017\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u1019\u102c\u1002\u102b\u1012\u1014\u103a\u1038\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "MAGT",
               "\u1019\u102c\u1002\u102b\u1012\u1014\u103a\u1038\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "MAGST",
               "\u1019\u102c\u1002\u102b\u1012\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u1021\u101c\u101a\u103a\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "ACWST",
               "\u1021\u101c\u101a\u103a\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ACWDT",
               "\u1021\u101c\u101a\u103a\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u1025\u101b\u1031\u102c\u1015 \u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CET",
               "\u1025\u101b\u1031\u102c\u1015 \u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "CEST",
               "\u1025\u101b\u1031\u102c\u1015\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u1005\u1032\u1000\u103a\u1001\u102b\u101c\u102e\u1004\u103a\u1038\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "SAKT",
               "\u1005\u1032\u1000\u103a\u1001\u102b\u101c\u102e\u1038\u1004\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "SAKST",
               "\u1005\u1032\u1000\u103a\u1001\u102b\u101c\u102e\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u1015\u102b\u101b\u102c\u1002\u103d\u1031\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PYT",
               "\u1015\u102b\u101b\u102c\u1002\u103d\u1031\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "PYST",
               "\u1015\u102b\u101b\u102c\u1002\u103d\u1031\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "PYT",
            };
        final String[] Malaysia = new String[] {
               "\u1019\u101c\u1031\u1038\u101b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "EST",
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "EDT",
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u101c\u1031\u102c\u1037\u1012\u103a\u101f\u1031\u102c\u1004\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "LHST",
               "\u101c\u1031\u102c\u1037\u1012\u103a\u101f\u1031\u102c\u1004\u103a\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "LHDT",
               "\u101c\u1031\u102c\u1037\u1012\u103a\u101f\u1031\u102c\u1004\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u1014\u101a\u1030\u1038\u1007\u102e\u101c\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "NZST",
               "\u1014\u101a\u1030\u1038\u1007\u102e\u101c\u1014\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "NZDT",
               "\u1014\u101a\u1030\u1038\u1007\u102e\u101c\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u1021\u102d\u1014\u1039\u1012\u103c\u102d\u101a \u101e\u1019\u102f\u1012\u1039\u1012\u101b\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u101a\u1030\u1001\u1030\u1038\u1010\u103a\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "YAKT",
               "\u101a\u1030\u1001\u1030\u1038\u1010\u103a\u1005\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "YAKST",
               "\u101a\u1030\u1001\u1030\u1038\u1010\u103a\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u1019\u1031\u102c\u103a\u101b\u1031\u101b\u103e\u102c\u1038\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "MUT",
               "\u1019\u1031\u102c\u103a\u101b\u1031\u101b\u103e\u102c\u1038\u1005\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "MUST",
               "\u1019\u1031\u102c\u103a\u101b\u1031\u101b\u103e\u102c\u1038\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u102c\u1016\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1010\u102e\u1019\u1031\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u1006\u102d\u102f\u101c\u102d\u102f\u1019\u103d\u1014\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u1001\u102d\u102f\u1005\u103a\u101b\u102d\u102f\u1004\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u1019\u102c\u101b\u101a\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1025\u101b\u1031\u102c\u1015 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "EET",
               "\u1021\u101b\u103e\u1031\u1037\u1025\u101b\u1031\u102c\u1015 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "EEST",
               "\u1021\u101b\u103e\u1031\u1037\u1025\u101b\u1031\u102c\u1015 \u1021\u1001\u103b\u102d\u1014\u103a",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u1014\u101a\u1030\u1038\u1016\u1031\u102c\u1004\u103a\u101c\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "NST",
               "\u1014\u101a\u1030\u1038\u1016\u1031\u102c\u1004\u103a\u101c\u1014\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "NDT",
               "\u1014\u101a\u1030\u1038\u1016\u1031\u102c\u1004\u103a\u101c\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u1021\u102c\u1016\u1002\u1014\u103a\u1014\u1005\u1039\u1005\u1010\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u101f\u1031\u102c\u1004\u103a\u1000\u1031\u102c\u1004\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "HKT",
               "\u101f\u1031\u102c\u1004\u103a\u1000\u1031\u102c\u1004\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "HKST",
               "\u101f\u1031\u102c\u1004\u103a\u1000\u1031\u102c\u1004\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "ART",
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "ARST",
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u1021\u1010\u1039\u1011\u101c\u1014\u103a\u1010\u1005\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AST",
               "\u1021\u1010\u1039\u1011\u101c\u1014\u103a\u1010\u1005\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ADT",
               "\u1021\u1010\u1039\u1011\u101c\u1014\u103a\u1010\u1005\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u1016\u102d\u102f\u1014\u102c\u1016\u1032\u1021\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u1018\u102d\u102f\u101c\u102e\u1038\u1018\u102e\u1038\u101a\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u1005\u102d\u1014\u1037\u103a\u1015\u102e\u1021\u1032\u1014\u103e\u1004\u1037\u103a\u1019\u102e\u1001\u103d\u102e\u101c\u103d\u1014\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PMST",
               "\u1005\u102d\u1014\u1037\u103a\u1015\u102e\u1021\u1032\u1014\u103e\u1004\u1037\u103a\u1019\u102e\u1001\u103d\u102e\u101c\u103d\u1014\u103a\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "PMDT",
               "\u1005\u102d\u1014\u1037\u103a\u1015\u102e\u1021\u1032\u1014\u103e\u1004\u1037\u103a\u1019\u102e\u1001\u103d\u102e\u101c\u103d\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u1021\u1004\u103a\u1012\u102d\u102f\u1001\u103b\u102d\u102f\u1004\u103a\u1038\u1014\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u101b\u101a\u103a\u1001\u102b\u1038\u1010\u102e\u101b\u1004\u103a\u1018\u102c\u1038\u1001\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "YEKT",
               "\u101b\u101a\u103a\u1001\u102b\u1038\u1010\u102e\u101b\u1004\u103a\u1018\u102c\u1001\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "YEKST",
               "\u101b\u101a\u103a\u1001\u102b\u1038\u1010\u102e\u101b\u1004\u103a\u1018\u102c\u1038\u1001\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u1019\u1031\u102c\u101c\u103a\u1012\u102d\u102f\u1004\u103a\u1038\u1017\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u1010\u102c\u101f\u102e\u1010\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u1021\u1005\u1039\u1005\u101b\u1031\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "IST",
               "\u1021\u1005\u1039\u1005\u101b\u1031\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "IDT",
               "\u1021\u1005\u1039\u1005\u101b\u1031\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1004\u103a\u1012\u102d\u102f\u1014\u102e\u1038\u101b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u101d\u1031\u102b\u101c\u102e\u1005\u103a\u1014\u103e\u1004\u1037\u103a",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u1010\u1031\u102c\u1004\u103a\u1021\u102c\u1016\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u101b\u103e\u102d\u102f\u101d\u102b\u1021\u1001\u103b\u102d\u1014\u103a",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u101c\u102d\u102f\u1004\u103a\u1038\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u1025\u1018\u1000\u103a\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "UZT",
               "\u1025\u1018\u1000\u103a\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "UZST",
               "\u1025\u1018\u1000\u103a\u1000\u1005\u1039\u1005\u1010\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u1021\u103d\u1019\u103a\u1038\u1005\u103a\u1001\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "OMST",
               "\u1021\u103d\u1019\u103a\u1038\u1005\u103a\u1001\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "OMSST",
               "\u1021\u103d\u1019\u103a\u1038\u1005\u103a\u1001\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u1006\u1031\u1038\u101b\u103e\u101c\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u1025\u101b\u102f\u1002\u103d\u1031\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "UYT",
               "\u1025\u101b\u102f\u1002\u103d\u1031\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "UYST",
               "\u1025\u101b\u102f\u1002\u103d\u1031\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u1014\u102e\u1015\u1031\u102b \u1021\u1001\u103b\u102d\u1014\u103a",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u1025\u101c\u1014\u103a\u1018\u102c\u1010\u1031\u102c\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "ULAT",
               "\u1025\u101c\u1014\u103a\u1018\u102c\u1010\u1031\u102c\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "ULAST",
               "\u1025\u101c\u1014\u103a\u1018\u102c\u1010\u1031\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CST",
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "CDT",
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1019\u1031\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u1001\u103b\u102f\u1001\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u1014\u102e\u1026\u1038\u1021\u1031\u1021\u1001\u103b\u102d\u1014\u103a",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u101d\u102d\u1010\u103a\u1001\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u1016\u1031\u102c\u1004\u103a\u1000\u101c\u1014\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "FKT",
               "\u1016\u1031\u102c\u1004\u103a\u1000\u101c\u1014\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "FKST",
               "\u1016\u1031\u102c\u1004\u103a\u1000\u101c\u1014\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f \u1021\u1001\u103b\u102d\u1014\u103a",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u1017\u102c\u1014\u102f\u1021\u102c\u1010\u1030\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "VUT",
               "\u1017\u102c\u1014\u102f\u1021\u102c\u1010\u1030\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "VUST",
               "\u1017\u102c\u1014\u102f\u1021\u102c\u1010\u1030\u1021\u1001\u103b\u102d\u1014\u103a",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u1014\u102d\u102f\u1017\u102d\u102f\u1005\u1032\u1018\u102e\u1021\u1032\u101a\u103a\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "NOVT",
               "\u1014\u102d\u102f\u1017\u102d\u102f\u1005\u1032\u1018\u102e\u1021\u1032\u101a\u103a\u1005\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "NOVST",
               "\u1014\u102d\u102f\u1017\u102d\u102f\u1005\u1032\u1018\u102e\u1021\u1032\u101a\u103a\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u1005\u1004\u103a\u1039\u1000\u102c\u1015\u1030 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u1021\u102c\u1007\u102d\u102f\u1038\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AZOT",
               "\u1021\u102c\u1007\u102d\u102f\u1038\u1005\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "AZOST",
               "\u1021\u102c\u1007\u102d\u102f\u1038\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u1021\u1015\u102e\u101a\u102c\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "WSST",
               "\u1021\u1015\u102e\u101a\u102c\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "WSDT",
               "\u1021\u1015\u102e\u101a\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u1018\u1030\u1010\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u1005\u1030\u1038\u101b\u102e\u1014\u102c\u1019\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u1014\u102c\u1025\u1030\u101b\u1030\u1021\u1001\u103b\u102d\u1014\u103a",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u1001\u101b\u102c\u1037\u1005\u103a\u1014\u102d\u102f\u101b\u102c\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "KRAT",
               "\u1001\u101b\u102c\u1037\u1005\u103a\u1014\u102d\u102f\u101b\u102c\u1005\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "KRAST",
               "\u1001\u101b\u102c\u1037\u1005\u103a\u1014\u102d\u102f\u101b\u102c\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1000\u102c\u1007\u1000\u103a\u1005\u1010\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u1019\u103c\u1014\u103a\u1019\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u1001\u101b\u1005\u103a\u1005\u1019\u1010\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u1021\u1019\u1031\u1007\u103d\u1014\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AMT",
               "\u1021\u1019\u1031\u1007\u103d\u1014\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "AMST",
               "\u1021\u1019\u1031\u1007\u103d\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1000\u102c\u1007\u1000\u103a\u1005\u1010\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u1016\u102e\u1002\u103b\u102e\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "FJT",
               "\u1016\u102e\u1002\u103b\u102e\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "FJST",
               "\u1016\u102e\u1002\u103b\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u101b\u1032\u1021\u1030\u1014\u102e\u101b\u103d\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u1000\u102d\u102f\u1038\u1000\u102d\u102f\u1038\u1000\u103b\u103d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u1001\u103b\u102c\u1038\u101e\u1019\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CHAST",
               "\u1001\u103b\u102c\u1038\u101e\u1019\u103a\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CHADT",
               "\u1001\u103b\u102c\u1038\u101e\u1019\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u1017\u102d\u102f\u1005\u103a\u1010\u102d\u102f\u1001\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "ART",
               "\u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "ARST",
               "\u1021\u102c\u1002\u103b\u1004\u103a\u1010\u102e\u1038\u1014\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u1002\u1014\u103a\u1018\u102e\u1021\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Tuvalu = new String[] {
               "\u1011\u1030\u1017\u102c\u101c\u1030\u1021\u1001\u103b\u102d\u1014\u103a",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u1002\u102b\u101c\u102c\u1038\u1015\u102b\u1002\u102d\u102f\u1038\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u1019\u1001\u103d\u102b\u101b\u102e\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u1017\u1004\u103a\u1014\u102e\u1007\u103d\u1032\u101c\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u101f\u102c\u101d\u102d\u102f\u1004\u103a\u1021\u102e \u1021\u102c\u101c\u1030\u1038\u101b\u103e\u1014\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "HAST",
               "\u101f\u102c\u101d\u102d\u102f\u1004\u103a\u1021\u102e \u1021\u102c\u101c\u1030\u1038\u101b\u103e\u1014\u103a\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "HADT",
               "\u101f\u102c\u101d\u102d\u102f\u1004\u103a\u1021\u102e \u1021\u102c\u101c\u1030\u1038\u101b\u103e\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "ACST",
               "\u1021\u101c\u101a\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ACDT",
               "\u1021\u101c\u101a\u103a\u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u1015\u1005\u102d\u1016\u102d\u1010\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PST",
               "\u1015\u1005\u102d\u1016\u102d\u1010\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "PDT",
               "\u1015\u1005\u102d\u1016\u102d\u1010\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u1016\u102e\u1038\u1014\u1005\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u1010\u102c\u1001\u103a\u1019\u102e\u1014\u1037\u1005\u103a\u1010\u1014\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "TMT",
               "\u1010\u102c\u1001\u103a\u1019\u102e\u1014\u1037\u1005\u103a\u1010\u1014\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "TMST",
               "\u1010\u102c\u1001\u103a\u1019\u102e\u1014\u1037\u1005\u103a\u1010\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1025\u101b\u1031\u102c\u1015 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "WET",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1025\u101b\u1031\u102c\u1015 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "WEST",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1025\u101b\u1031\u102c\u1015 \u1021\u1001\u103b\u102d\u1014\u103a",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u1001\u1031\u1037\u1015\u103a\u1017\u102c\u1012\u1030\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CVT",
               "\u1001\u1031\u1037\u1015\u103a\u1017\u102c\u1012\u1030\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "CVST",
               "\u1001\u1031\u1037\u1015\u103a\u1017\u102c\u1012\u1030\u1021\u1001\u103b\u102d\u1014\u103a",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u1014\u1031\u102c\u1016\u1031\u102c\u1037\u1001\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u1002\u102d\u102f\u1004\u103a\u101b\u102c\u1014\u102c\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u1015\u102d\u1000\u102d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u101b\u102d\u102f\u101e\u102e\u101b\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u1006\u102c\u1019\u102d\u102f\u1021\u102c\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "SST",
               "\u1006\u102c\u1019\u102d\u102f\u1021\u102c\u1014\u1031\u1037\u1021\u1001\u103b\u102d\u1014\u103a",
               "SDT",
               "\u1006\u102c\u1019\u102d\u102f\u1021\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u1016\u101c\u1031\u102c\u1004\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u1011\u1015\u103a\u1010\u102d\u102f\u1038\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1025\u101b\u1031\u102c\u1015\u1021\u1001\u103b\u102d\u1014\u103a",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u1021\u1007\u102c\u1018\u102d\u102f\u1004\u103a\u1002\u103b\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AZT",
               "\u1021\u1007\u102c\u1018\u102d\u102f\u1004\u103a\u1002\u103b\u1014\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "AZST",
               "\u1021\u1007\u102c\u1018\u102d\u102f\u1004\u103a\u1002\u103b\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u1019\u1031\u102c\u103a\u1005\u103d\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u1019\u1000\u1039\u1000\u1006\u102e\u1000\u1014\u103a \u1015\u1005\u102d\u1016\u102d\u1010\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "MST",
               "\u1019\u1000\u1039\u1000\u1006\u102e\u1000\u1014\u103a \u1015\u1005\u102d\u1016\u102d\u1010\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "MDT",
               "\u1019\u1000\u1039\u1000\u1006\u102e\u1000\u1014\u103a \u1015\u1005\u102d\u1016\u102d\u1010\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u1012\u1031\u1038\u1017\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u1000\u103b\u1030\u1038\u1018\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CST",
               "\u1000\u103b\u1030\u1038\u1018\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CDT",
               "\u1000\u103b\u1030\u1038\u1018\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u102c\u1016\u101b\u102d\u1000 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CAT",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u102c\u1016\u101b\u102d\u1000 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "CAST",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u102c\u1016\u101b\u102d\u1000 \u1021\u1001\u103b\u102d\u1014\u103a",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u1002\u101b\u1004\u103a\u1038\u1014\u1005\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u1016\u102d\u101c\u1005\u103a\u1015\u102d\u102f\u1004\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PHT",
               "\u1016\u102d\u101c\u1005\u103a\u1015\u102d\u102f\u1004\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "PHST",
               "\u1016\u102d\u101c\u1005\u103a\u1015\u102d\u102f\u1004\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u1015\u103c\u1004\u103a\u101e\u1005\u103a\u1010\u1031\u102c\u1004\u103a\u1015\u102d\u102f\u1004\u103a\u1038\u1014\u1004\u1037\u103a\u1021\u1014\u1039\u1010\u1010\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u1010\u1031\u102c\u1004\u103a\u1002\u103b\u1031\u102c\u103a\u1002\u103b\u102e\u101a\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u1014\u101a\u1030\u1038\u1000\u102c\u101c\u102e\u1012\u102d\u102f\u1038\u1014\u102e\u1038\u101a\u102c\u1038\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "NCT",
               "\u1014\u101a\u1030\u1038\u1000\u102c\u101c\u102e\u1012\u102d\u102f\u1038\u1014\u102e\u1038\u101a\u102c\u1038\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "NCST",
               "\u1014\u101a\u1030\u1038\u1000\u102c\u101c\u102e\u1012\u102d\u102f\u1038\u1014\u102e\u1038\u101a\u102c\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u1018\u101b\u1030\u1014\u102d\u102f\u1004\u103a\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u1021\u102e\u101b\u1014\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "IRST",
               "\u1021\u102e\u101b\u1014\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "IRDT",
               "\u1021\u102e\u101b\u1014\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u1021\u102e\u1005\u1010\u102c\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "EAST",
               "\u1021\u102e\u1005\u1010\u102c\u1000\u103b\u103d\u1014\u103a\u1038\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "EASST",
               "\u1021\u102e\u1005\u1010\u102c\u1000\u103b\u103d\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1010\u1031\u102c\u1004\u103a \u1019\u1000\u1039\u1000\u1006\u102e\u1000\u102d\u102f \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PST",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1010\u1031\u102c\u1004\u103a \u1019\u1000\u1039\u1000\u1006\u102e\u1000\u102d\u102f \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "PDT",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1010\u1031\u102c\u1004\u103a \u1019\u1000\u1039\u1000\u1006\u102e\u1000\u102d\u102f \u1021\u1001\u103b\u102d\u1014\u103a",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u1012\u1030\u1038\u1019\u1031\u102c\u1037\u1010\u103a \u1012\u102b\u101b\u103a\u1017\u102e\u1038\u101c\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u1010\u102c\u1002\u103b\u102e\u1000\u1005\u1039\u1005\u1010\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u1010\u103d\u1014\u103a\u1002\u102b\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "TOT",
               "\u1010\u103d\u1014\u103a\u1002\u102b\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "TOST",
               "\u1010\u103d\u1014\u103a\u1002\u102b\u1021\u1001\u103b\u102d\u1014\u103a",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u1018\u1004\u103a\u1039\u1002\u101c\u102c\u1038\u1012\u1031\u1037\u101b\u103e\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "BDT",
               "\u1018\u1004\u103a\u1039\u1002\u101c\u102c\u1038\u1012\u1031\u1037\u101b\u103e\u103a \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "BDST",
               "\u1018\u1004\u103a\u1039\u1002\u101c\u102c\u1038\u1012\u1031\u1037\u101b\u103e\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u1015\u102e\u101b\u1030\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "PET",
               "\u1015\u102e\u101b\u1030\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "PEST",
               "\u1015\u102e\u101b\u1030\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "WGT",
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "WGST",
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u1021\u102e\u1000\u103d\u1031\u1012\u1031\u102b \u1021\u1001\u103b\u102d\u1014\u103a",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "EGT",
               "\u1021\u101b\u103e\u1031\u1037\u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "EGST",
               "\u1021\u101b\u103e\u1031\u1037\u1002\u101b\u1004\u103a\u1038\u101c\u1014\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u1015\u1004\u103a\u101c\u101a\u103a\u1002\u103d\u1031\u1037 \u1021\u1001\u103b\u102d\u1014\u103a",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1004\u103a\u1012\u102d\u102f\u1014\u102e\u1038\u101b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u1000\u102d\u102f\u1038\u101b\u102e\u1038\u101a\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "KST",
               "\u1000\u102d\u102f\u1038\u101b\u102e\u1038\u101a\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "KDT",
               "\u1000\u102d\u102f\u1038\u101b\u102e\u1038\u101a\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AWST",
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "AWDT",
               "\u1021\u1014\u1031\u102c\u1000\u103a \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u1001\u101a\u103a\u1000\u1005\u103a\u1010\u1014\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u1021\u1014\u1031\u102c\u1000\u103a\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1004\u103a\u1012\u102d\u102f\u1014\u102e\u1038\u101b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AEST",
               "\u1021\u101b\u103e\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "AEDT",
               "\u1021\u101b\u103e\u1031\u1037\u1029\u1005\u1010\u103c\u1031\u1038\u101c\u103b\u103e\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u1015\u103c\u1004\u103a\u101e\u1005\u103a \u1002\u102e\u101a\u102c\u1014\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u1000\u102d\u102f\u101c\u1036\u1018\u102e\u101a\u102c \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "COT",
               "\u1000\u102d\u102f\u101c\u1036\u1018\u102e\u101a\u102c \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "COST",
               "\u1000\u102d\u102f\u101c\u1036\u1018\u102e\u101a\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u1001\u103b\u102e\u101c\u102e \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CLT",
               "\u1001\u103b\u102e\u101c\u102e \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "CLST",
               "\u1001\u103b\u102e\u101c\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u1002\u102e\u101c\u103a\u1018\u1010\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u1021\u1019\u1031\u101b\u102d\u1000 \u1010\u1031\u102c\u1004\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "MST",
               "\u1021\u1019\u1031\u101b\u102d\u1000 \u1010\u1031\u102c\u1004\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "MDT",
               "\u1021\u1019\u1031\u101b\u102d\u1000 \u1010\u1031\u102c\u1004\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u1019\u102c\u1001\u1031\u1038\u1021\u1015\u103a\u1005\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u1021\u102c\u101b\u1031\u1017\u103b \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AST",
               "\u1021\u102c\u101b\u1031\u1017\u103b \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "ADT",
               "\u1021\u102c\u101b\u1031\u1017\u103b \u1021\u1001\u103b\u102d\u1014\u103a",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u1021\u101c\u102c\u1005\u1000\u102c\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AKST",
               "\u1021\u101c\u102c\u1005\u1000\u102c\u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "AKDT",
               "\u1021\u101c\u102c\u1005\u1000\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u1017\u101c\u102c\u1012\u102b\u1017\u102d\u102f\u1005\u103a\u1010\u102d\u102f\u1001\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "VLAT",
               "\u1017\u101c\u102c\u1012\u102b\u1017\u102d\u102f\u1005\u103a\u1010\u102d\u102f\u1001\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "VLAST",
               "\u1017\u101c\u102c\u1012\u102b\u1017\u102d\u102f\u1005\u103a\u1010\u102d\u102f\u1001\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u1001\u103b\u102c\u1019\u102d\u102f\u101b\u102d\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u1021\u102e\u101b\u1030\u1001\u1030\u1010\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "IRKT",
               "\u1021\u102e\u101b\u1030\u1001\u1030\u1010\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "IRKST",
               "\u1021\u102e\u101b\u1030\u1001\u1030\u1010\u103a\u1021\u1001\u103b\u102d\u1014\u103a",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u1002\u103b\u1031\u102c\u103a\u1002\u103b\u102e\u101a\u102c \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "GET",
               "\u1002\u103b\u1031\u102c\u103a\u1002\u103b\u102e\u101a\u102c \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "GEST",
               "\u1002\u103b\u1031\u102c\u103a\u1002\u103b\u102e\u101a\u102c \u1021\u1001\u103b\u102d\u1014\u103a",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u1010\u102d\u102f\u1000\u102e\u101c\u102c\u1025 \u1021\u1001\u103b\u102d\u1014\u103a",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u1015\u102b\u1015\u1030\u101b\u102c\u1014\u101a\u1030\u1038\u1002\u102e\u1014\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u1016\u102c\u1014\u1014\u103a\u1012\u102d\u102f\u1038\u1012\u102e\u1014\u102d\u102f\u1038\u101b\u102d\u102f\u1038\u100a\u102c\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "FNT",
               "\u1016\u102c\u1014\u1014\u103a\u1012\u102d\u102f\u1038\u1012\u102e\u1014\u102d\u102f\u1038\u101b\u102d\u102f\u1038\u100a\u102c\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "FNST",
               "\u1016\u102c\u1014\u1014\u103a\u1012\u102d\u102f\u1038\u1012\u102e\u1014\u102d\u102f\u1038\u101b\u102d\u102f\u1038\u100a\u102c\u1021\u1001\u103b\u102d\u1014\u103a",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u1001\u103b\u103d\u1032\u1018\u1031\u102c\u103a\u1006\u1014\u103a\u1038\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CHOT",
               "\u1001\u103b\u103d\u1032\u1018\u1031\u102c\u103a\u1006\u1014\u103a\u1038\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "CHOST",
               "\u1001\u103b\u103d\u1032\u1018\u1031\u102c\u103a\u1006\u1014\u103a\u1038\u1021\u1001\u103b\u102d\u1014\u103a",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u1018\u101b\u102c\u1007\u102e\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "BRT",
               "\u1018\u101b\u102c\u1007\u102e\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "BRST",
               "\u1018\u101b\u102c\u1007\u102e\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "BRT",
            };
        final String[] China = new String[] {
               "\u1010\u101b\u102f\u1010\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CST",
               "\u1010\u101b\u102f\u1010\u103a \u1014\u1031\u1037\u1015\u102d\u102f\u1004\u103a\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "CDT",
               "\u1010\u101b\u102f\u1010\u103a \u1021\u1001\u103b\u102d\u1014\u103a",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u1021\u102c\u1019\u1031\u1014\u102e\u1038\u101a\u102c\u1038 \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "AMT",
               "\u1021\u102c\u1019\u1031\u1014\u102e\u1038\u101a\u102c\u1038 \u1014\u103d\u1031\u101b\u102c\u101e\u102e \u1021\u1001\u103b\u102d\u1014\u103a",
               "AMST",
               "\u1021\u102c\u1019\u1031\u1014\u102e\u1038\u101a\u102c\u1038 \u1021\u1001\u103b\u102d\u1014\u103a",
               "AMT",
            };
        final String[] India = new String[] {
               "\u1021\u102d\u1014\u1039\u1012\u103c\u102d\u101a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u1000\u103d\u1010\u103a\u1001\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
               "CKT",
               "\u1000\u103d\u1010\u103a\u1000\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
               "CKHST",
               "\u1000\u103d\u1010\u103a\u1001\u103a\u1000\u103b\u103d\u1014\u103a\u1038\u1005\u102f\u1021\u1001\u103b\u102d\u1014\u103a",
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
                    "\u1002\u101b\u1004\u103a\u1038\u1014\u1005\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
                    "GMT",
                    "\u1017\u103c\u102d\u1010\u102d\u1014\u103a\u1014\u103d\u1031\u101b\u102c\u101e\u102e\u1021\u1001\u103b\u102d\u1014\u103a",
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
                    "\u1002\u101b\u1004\u103a\u1038\u1014\u1005\u103a \u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
                    "GMT",
                    "\u1021\u102d\u102f\u1004\u103a\u1038\u101b\u1005\u103a\u1005\u1036\u1010\u1031\u102c\u103a\u1001\u103b\u102d\u1014\u103a",
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
