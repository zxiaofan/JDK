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

public class TimeZoneNames_mr extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] Africa_Central = new String[] {
               "\u092e\u0927\u094d\u200d\u092f \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u0935\u0947\u0933",
               "CAT",
               "Central African Summer Time",
               "CAST",
               "Central Africa Time",
               "CAT",
            };
        final String[] Moscow = new String[] {
               "\u092e\u0949\u0938\u094d\u0915\u094b \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "MSK",
               "\u092e\u0949\u0938\u094d\u0915\u094b \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "MSD",
               "\u092e\u0949\u0938\u094d\u0915\u094b \u0935\u0947\u0933",
               "MT",
            };
        final String[] Japan = new String[] {
               "\u091c\u092a\u093e\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "JST",
               "\u091c\u092a\u093e\u0928 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "JDT",
               "\u091c\u092a\u093e\u0928 \u0935\u0947\u0933",
               "JT",
            };
        final String[] Pakistan = new String[] {
               "\u092a\u093e\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PKT",
               "\u092a\u093e\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "PKST",
               "\u092a\u093e\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "PKT",
            };
        final String[] Taipei = new String[] {
               "\u0924\u0948\u092a\u0947\u0908 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CST",
               "\u0924\u0948\u092a\u0947\u0908 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "CDT",
               "\u0924\u0948\u092a\u0947\u0908 \u0935\u0947\u0933",
               "CT",
            };
        final String[] Hovd = new String[] {
               "\u0939\u094b\u0935\u094d\u0939\u094d\u0921 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "HOVT",
               "\u0939\u094b\u0935\u094d\u0939\u094d\u0921 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "HOVST",
               "\u0939\u094b\u0935\u094d\u0939\u094d\u0921 \u0935\u0947\u0933",
               "HOVT",
            };
        final String[] Magadan = new String[] {
               "\u092e\u0945\u0917\u093e\u0921\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "MAGT",
               "\u092e\u0945\u0917\u093e\u0921\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "MAGST",
               "\u092e\u0945\u0917\u093e\u0921\u0928 \u0935\u0947\u0933",
               "MAGT",
            };
        final String[] Australia_CentralWestern = new String[] {
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092e\u0927\u094d\u092f-\u092a\u0936\u094d\u091a\u093f\u092e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ACWST",
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092e\u0927\u094d\u092f-\u092a\u0936\u094d\u091a\u093f\u092e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "ACWDT",
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092e\u0927\u094d\u092f-\u092a\u0936\u094d\u091a\u093f\u092e \u0935\u0947\u0933",
               "ACWT",
            };
        final String[] Europe_Central = new String[] {
               "\u092e\u0927\u094d\u200d\u092f \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CET",
               "\u092e\u0927\u094d\u200d\u092f \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CEST",
               "\u092e\u0927\u094d\u200d\u092f \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0935\u0947\u0933",
               "CET",
            };
        final String[] Sakhalin = new String[] {
               "\u0938\u0916\u0932\u093f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "SAKT",
               "\u0938\u0916\u0932\u093f\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "SAKST",
               "\u0938\u0916\u0932\u093f\u0928 \u0935\u0947\u0933",
               "SAKT",
            };
        final String[] Paraguay = new String[] {
               "\u092a\u0945\u0930\u093e\u0917\u094d\u0935\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PYT",
               "\u092a\u0945\u0930\u093e\u0917\u094d\u0935\u0947 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "PYST",
               "\u092a\u0945\u0930\u093e\u0917\u094d\u0935\u0947 \u0935\u0947\u0933",
               "PYT",
            };
        final String[] Acre = new String[] {
               "\u090f\u0915\u0930 \u092a\u094d\u0930\u092e\u093e\u0923\u0935\u0947\u0933",
               "ACT",
               "\u0910\u0915\u0930 \u0917\u094d\u0930\u0940\u0937\u094d\u092e \u0935\u0947\u0933",
               "ACST",
               "\u090f\u0915\u0930 \u0935\u0947\u0933",
               "ACT",
            };
        final String[] Malaysia = new String[] {
               "\u092e\u0932\u0947\u0936\u093f\u092f\u093e \u0935\u0947\u0933",
               "MYT",
               "Malaysia Summer Time",
               "MYST",
               "Malaysia Time",
               "MYT",
            };
        final String[] America_Eastern = new String[] {
               "\u092a\u094c\u0930\u094d\u0935\u093e\u0924\u094d\u092f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "EST",
               "\u092a\u094c\u0930\u094d\u0935\u093e\u0924\u094d\u092f \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "EDT",
               "\u092a\u094c\u0930\u094d\u0935\u093e\u0924\u094d\u092f \u0935\u0947\u0933",
               "ET",
            };
        final String[] Lord_Howe = new String[] {
               "\u0932\u0949\u0930\u094d\u0921 \u0939\u094b\u0935\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "LHST",
               "\u0932\u0949\u0930\u094d\u0921 \u0939\u094b\u0935\u0947 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "LHDT",
               "\u0932\u0949\u0930\u094d\u0921 \u0939\u094b\u0935\u0947 \u0935\u0947\u0933",
               "LHT",
            };
        final String[] New_Zealand = new String[] {
               "\u0928\u094d\u092f\u0942\u091d\u0940\u0932\u0902\u0921 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "NZST",
               "\u0928\u094d\u092f\u0942\u091d\u0940\u0932\u0902\u0921 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "NZDT",
               "\u0928\u094d\u092f\u0942\u091d\u0940\u0932\u0902\u0921 \u0935\u0947\u0933",
               "NZT",
            };
        final String[] Indian_Ocean = new String[] {
               "\u0939\u093f\u0902\u0926\u092e\u0939\u093e\u0938\u093e\u0917\u0930 \u0935\u0947\u0933",
               "IOT",
               "Indian Ocean Territory Summer Time",
               "IOST",
               "Indian Ocean Territory Time",
               "IOT",
            };
        final String[] Yakutsk = new String[] {
               "\u092f\u093e\u0915\u0941\u0924\u094d\u0938\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "YAKT",
               "\u092f\u093e\u0915\u0941\u0924\u094d\u0938\u0915 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "YAKST",
               "\u092f\u093e\u0915\u0941\u0924\u094d\u0938\u0915 \u0935\u0947\u0933",
               "YAKT",
            };
        final String[] Mauritius = new String[] {
               "\u092e\u0949\u0930\u0940\u0936\u0938 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "MUT",
               "\u092e\u0949\u0930\u0940\u0936\u0938 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "MUST",
               "\u092e\u0949\u0930\u0940\u0936\u0938 \u0935\u0947\u0933",
               "MUT",
            };
        final String[] Africa_Eastern = new String[] {
               "\u092a\u0942\u0930\u094d\u0935 \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u0935\u0947\u0933",
               "EAT",
               "Eastern African Summer Time",
               "EAST",
               "Eastern Africa Time",
               "EAT",
            };
        final String[] East_Timor = new String[] {
               "\u092a\u0942\u0930\u094d\u0935 \u0924\u093f\u092e\u094b\u0930 \u0935\u0947\u0933",
               "TLT",
               "Timor-Leste Summer Time",
               "TLST",
               "Timor-Leste Time",
               "TLT",
            };
        final String[] Solomon = new String[] {
               "\u0938\u094b\u0932\u094b\u092e\u0949\u0928 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "SBT",
               "Solomon Is. Summer Time",
               "SBST",
               "Solomon Is. Time",
               "SBT",
            };
        final String[] Kosrae = new String[] {
               "\u0915\u094b\u0938\u094d\u0930\u093e\u0908 \u0935\u0947\u0933",
               "KOST",
               "Kosrae Summer Time",
               "KOSST",
               "Kosrae Time",
               "KOST",
            };
        final String[] Marshall_Islands = new String[] {
               "\u092e\u093e\u0930\u094d\u0936\u0932 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "MHT",
               "Marshall Islands Summer Time",
               "MHST",
               "Marshall Islands Time",
               "MHT",
            };
        final String[] Europe_Eastern = new String[] {
               "\u092a\u0942\u0930\u094d\u0935 \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "EET",
               "\u092a\u0942\u0930\u094d\u0935 \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "EEST",
               "\u092a\u0942\u0930\u094d\u0935 \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0935\u0947\u0933",
               "EET",
            };
        final String[] Newfoundland = new String[] {
               "\u0928\u094d\u092f\u0942 \u092b\u093e\u0909\u0902\u0921\u0932\u0902\u0921 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "NST",
               "\u0928\u094d\u092f\u0942 \u092b\u093e\u0909\u0902\u0921\u0932\u0902\u0921 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "NDT",
               "\u0928\u094d\u092f\u0942 \u092b\u093e\u0909\u0902\u0921\u0932\u0902\u0921 \u0935\u0947\u0933",
               "NT",
            };
        final String[] Afghanistan = new String[] {
               "\u0905\u092b\u0917\u093e\u0923\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "AFT",
               "Afghanistan Summer Time",
               "AFST",
               "Afghanistan Time",
               "AFT",
            };
        final String[] Hong_Kong = new String[] {
               "\u0939\u093e\u0901\u0917 \u0915\u093e\u0901\u0917 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "HKT",
               "\u0939\u093e\u0901\u0917 \u0915\u093e\u0901\u0917 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "HKST",
               "\u0939\u093e\u0901\u0917 \u0915\u093e\u0901\u0917 \u0935\u0947\u0933",
               "HKT",
            };
        final String[] Argentina_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e\u0940 \u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ART",
               "\u092a\u0936\u094d\u091a\u093f\u092e\u0940 \u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "ARST",
               "\u092a\u0936\u094d\u091a\u093f\u092e\u0940 \u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u0935\u0947\u0933",
               "ART",
            };
        final String[] Atlantic = new String[] {
               "\u0905\u091f\u0932\u093e\u0902\u091f\u093f\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AST",
               "\u0905\u091f\u0932\u093e\u0902\u091f\u093f\u0915 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "ADT",
               "\u0905\u091f\u0932\u093e\u0902\u091f\u093f\u0915 \u0935\u0947\u0933",
               "AT",
            };
        final String[] Ponape = new String[] {
               "\u092a\u094b\u0928\u0945\u092a\u0947 \u0935\u0947\u0933",
               "PONT",
               "Pohnpei Summer Time",
               "PONST",
               "Ponape Time",
               "PONT",
            };
        final String[] Bolivia = new String[] {
               "\u092c\u094b\u0932\u093f\u0935\u094d\u0939\u093f\u092f\u093e \u0935\u0947\u0933",
               "BOT",
               "Bolivia Summer Time",
               "BOST",
               "Bolivia Time",
               "BOT",
            };
        final String[] Pierre_Miquelon = new String[] {
               "\u0938\u0947\u0902\u091f \u092a\u093f\u092f\u0930 \u0906\u0923\u093f \u092e\u093f\u0915\u094d\u0935\u0947\u0932\u094b\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PMST",
               "\u0938\u0947\u0902\u091f \u092a\u093f\u092f\u0930 \u0906\u0923\u093f \u092e\u093f\u0915\u094d\u0935\u0947\u0932\u094b\u0928 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "PMDT",
               "\u0938\u0947\u0902\u091f \u092a\u093f\u092f\u0930 \u0906\u0923\u093f \u092e\u093f\u0915\u094d\u0935\u0947\u0932\u094b\u0928 \u0935\u0947\u0933",
               "PMT",
            };
        final String[] Indochina = new String[] {
               "\u0907\u0902\u0921\u094b\u091a\u093e\u092f\u0928\u093e \u0935\u0947\u0933",
               "ICT",
               "Indochina Summer Time",
               "ICST",
               "Indochina Time",
               "ICT",
            };
        final String[] Yekaterinburg = new String[] {
               "\u092f\u0947\u0915\u0924\u0930\u093f\u0928\u092c\u0930\u094d\u0917 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "YEKT",
               "\u092f\u0947\u0915\u0924\u0930\u093f\u0928\u092c\u0930\u094d\u0917 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "YEKST",
               "\u092f\u0947\u0915\u0924\u0930\u093f\u0928\u092c\u0930\u094d\u0917 \u0935\u0947\u0933",
               "YEKT",
            };
        final String[] Maldives = new String[] {
               "\u092e\u093e\u0932\u0926\u093f\u0935 \u0935\u0947\u0933",
               "MVT",
               "Maldives Summer Time",
               "MVST",
               "Maldives Time",
               "MVT",
            };
        final String[] Tahiti = new String[] {
               "\u0924\u093e\u0939\u093f\u0924\u0940 \u0935\u0947\u0933",
               "TAHT",
               "Tahiti Summer Time",
               "TAHST",
               "Tahiti Time",
               "TAHT",
            };
        final String[] Israel = new String[] {
               "\u0907\u0938\u094d\u0930\u093e\u092f\u0932 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "IST",
               "\u0907\u0938\u094d\u0930\u093e\u092f\u0932 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "IDT",
               "\u0907\u0938\u094d\u0930\u093e\u092f\u0932",
               "IT",
            };
        final String[] Indonesia_Central = new String[] {
               "\u092e\u0927\u094d\u200d\u092f \u0907\u0902\u0921\u094b\u0928\u0947\u0936\u093f\u092f\u093e \u0935\u0947\u0933",
               "WITA",
               "Central Indonesia Summer Time",
               "CIST",
               "Central Indonesia Time",
               "WITA",
            };
        final String[] Wallis = new String[] {
               "\u0935\u0949\u0932\u093f\u0938 \u0906\u0923\u093f \u092b\u0941\u091f\u0941\u0928\u093e \u0935\u0947\u0933",
               "WFT",
               "Wallis & Futuna Summer Time",
               "WFST",
               "Wallis & Futuna Time",
               "WFT",
            };
        final String[] Africa_Southern = new String[] {
               "\u0926\u0915\u094d\u0937\u093f\u0923 \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "SAST",
               "South Africa Summer Time",
               "SAST",
               "South Africa Time",
               "SAT",
            };
        final String[] Syowa = new String[] {
               "\u0938\u094d\u092f\u094b\u0935\u093e \u0935\u0947\u0933",
               "SYOT",
               "Syowa Summer Time",
               "SYOST",
               "Syowa Time",
               "SYOT",
            };
        final String[] Line_Islands = new String[] {
               "\u0932\u093e\u0907\u0928 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "LINT",
               "Line Is. Summer Time",
               "LINST",
               "Line Is. Time",
               "LINT",
            };
        final String[] Uzbekistan = new String[] {
               "\u0909\u091d\u092c\u0947\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "UZT",
               "\u0909\u091d\u092c\u0947\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "UZST",
               "\u0909\u091d\u092c\u0947\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "UZT",
            };
        final String[] Omsk = new String[] {
               "\u0913\u092e\u094d\u0938\u094d\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "OMST",
               "\u0913\u092e\u094d\u0938\u094d\u0915 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "OMSST",
               "\u0913\u092e\u094d\u0938\u094d\u0915 \u0935\u0947\u0933",
               "OMST",
            };
        final String[] Seychelles = new String[] {
               "\u0938\u0947\u0936\u0947\u0932\u094d\u0938 \u0935\u0947\u0933",
               "SCT",
               "Seychelles Summer Time",
               "SCST",
               "Seychelles Time",
               "SCT",
            };
        final String[] Uruguay = new String[] {
               "\u0909\u0930\u0941\u0917\u094d\u0935\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "UYT",
               "\u0909\u0930\u0941\u0917\u094d\u0935\u0947 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "UYST",
               "\u0909\u0930\u0941\u0917\u094d\u0935\u0947 \u0935\u0947\u0933",
               "UYT",
            };
        final String[] Nepal = new String[] {
               "\u0928\u0947\u092a\u093e\u0933 \u0935\u0947\u0933",
               "NPT",
               "Nepal Summer Time",
               "NPST",
               "Nepal Time",
               "NPT",
            };
        final String[] Mongolia = new String[] {
               "\u0909\u0932\u093e\u0928 \u092c\u093e\u091f\u094b\u0930 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ULAT",
               "\u0909\u0932\u093e\u0928 \u092c\u093e\u091f\u094b\u0930 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "ULAST",
               "\u0909\u0932\u093e\u0928 \u092c\u093e\u091f\u094b\u0930 \u0935\u0947\u0933",
               "ULAT",
            };
        final String[] America_Central = new String[] {
               "\u0915\u0947\u0902\u0926\u094d\u0930\u0940\u092f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CST",
               "\u0915\u0947\u0902\u0926\u094d\u0930\u0940\u092f \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "CDT",
               "\u0915\u0947\u0902\u0926\u094d\u0930\u0940\u092f \u0935\u0947\u0933",
               "CT",
            };
        final String[] Truk = new String[] {
               "\u091a\u0942\u0915 \u0935\u0947\u0933",
               "CHUT",
               "Chuuk Summer Time",
               "CHUST",
               "Chuuk Time",
               "CHUT",
            };
        final String[] Niue = new String[] {
               "\u0928\u094d\u092f\u0941\u090f \u0935\u0947\u0933",
               "NUT",
               "Niue Summer Time",
               "NUST",
               "Niue Time",
               "NUT",
            };
        final String[] Wake = new String[] {
               "\u0935\u0947\u0915 \u092c\u0947\u091f \u0935\u0947\u0933",
               "WAKT",
               "Wake Summer Time",
               "WAKST",
               "Wake Time",
               "WAKT",
            };
        final String[] Falkland = new String[] {
               "\u092b\u0949\u0915\u0932\u0902\u0921 \u092c\u0947\u091f\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "FKT",
               "\u092b\u0949\u0915\u0932\u0902\u0921 \u092c\u0947\u091f\u0947 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "FKST",
               "\u092b\u0949\u0915\u0932\u0902\u0921 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "FKT",
            };
        final String[] Vanuatu = new String[] {
               "\u0935\u093e\u0928\u0941\u0906\u0924\u0941 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "VUT",
               "\u0935\u093e\u0928\u0941\u0906\u0924\u0941 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "VUST",
               "\u0935\u093e\u0928\u0941\u0906\u0924\u0941 \u0935\u0947\u0933",
               "VUT",
            };
        final String[] Novosibirsk = new String[] {
               "\u0928\u094b\u0935\u094b\u0938\u093f\u092c\u093f\u0930\u094d\u0938\u094d\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "NOVT",
               "\u0928\u094b\u0935\u094b\u0938\u093f\u092c\u093f\u0930\u094d\u0938\u094d\u0915 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "NOVST",
               "\u0928\u094b\u0935\u094b\u0938\u093f\u092c\u093f\u0930\u094d\u0938\u094d\u0915 \u0935\u0947\u0933",
               "NOVT",
            };
        final String[] Singapore = new String[] {
               "\u0938\u093f\u0902\u0917\u093e\u092a\u0942\u0930 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "SRET",
               "Srednekolymsk Daylight Time",
               "SREDT",
               "Srednekolymsk Time",
               "SRET",
            };
        final String[] Azores = new String[] {
               "\u0905\u200d\u0945\u091d\u094b\u0930\u0947\u0938 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AZOT",
               "\u0905\u200d\u0945\u091d\u094b\u0930\u0947\u0938 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "AZOST",
               "\u0905\u200d\u0945\u091d\u094b\u0930\u0947\u0938 \u0935\u0947\u0933",
               "AZOT",
            };
        final String[] Apia = new String[] {
               "\u090f\u092a\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "WSST",
               "\u090f\u092a\u093f\u092f\u093e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "WSDT",
               "\u090f\u092a\u093f\u092f\u093e \u0935\u0947\u0933",
               "WST",
            };
        final String[] Bhutan = new String[] {
               "\u092d\u0942\u0924\u093e\u0928 \u0935\u0947\u0933",
               "BTT",
               "Bhutan Summer Time",
               "BTST",
               "Bhutan Time",
               "BTT",
            };
        final String[] Suriname = new String[] {
               "\u0938\u0941\u0930\u093f\u0928\u093e\u092e \u0935\u0947\u0933",
               "SRT",
               "Suriname Summer Time",
               "SRST",
               "Suriname Time",
               "SRT",
            };
        final String[] Nauru = new String[] {
               "\u0928\u0909\u0930\u0941 \u0935\u0947\u0933",
               "NRT",
               "Nauru Summer Time",
               "NRST",
               "Nauru Time",
               "NRT",
            };
        final String[] Krasnoyarsk = new String[] {
               "\u0915\u094d\u0930\u093e\u0938\u094d\u0928\u094b\u092f\u093e\u0930\u094d\u0938\u094d\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "KRAT",
               "\u0915\u094d\u0930\u093e\u0938\u094d\u0928\u094b\u092f\u093e\u0930\u094d\u0915\u094d\u0938 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "KRAST",
               "\u0915\u094d\u0930\u093e\u0938\u094d\u0928\u094b\u092f\u093e\u0930\u094d\u0938\u094d\u0915 \u0935\u0947\u0933",
               "KRAT",
            };
        final String[] Kazakhstan_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0915\u091d\u093e\u0915\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "AQTT",
               "Aqtau Summer Time",
               "AQTST",
               "Aqtau Time",
               "AQTT",
            };
        final String[] Myanmar = new String[] {
               "\u092e\u094d\u092f\u093e\u0928\u092e\u093e\u0930 \u0935\u0947\u0933",
               "MMT",
               "Myanmar Summer Time",
               "MMST",
               "Myanmar Time",
               "MMT",
            };
        final String[] Christmas = new String[] {
               "\u0916\u094d\u0930\u093f\u0938\u092e\u0938 \u092c\u0947\u091f \u0935\u0947\u0933",
               "CXT",
               "Christmas Island Summer Time",
               "CXST",
               "Christmas Island Time",
               "CIT",
            };
        final String[] Amazon = new String[] {
               "\u0905\u200d\u0945\u092e\u0947\u091d\u0949\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AMT",
               "\u0905\u200d\u0945\u092e\u0947\u091d\u0949\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "AMST",
               "\u0905\u0945\u092e\u0947\u091d\u0949\u0928 \u0935\u0947\u0933",
               "AMT",
            };
        final String[] Kazakhstan_Eastern = new String[] {
               "\u092a\u0942\u0930\u094d\u0935 \u0915\u091d\u093e\u0915\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "ALMT",
               "Alma-Ata Summer Time",
               "ALMST",
               "Alma-Ata Time",
               "ALMT",
            };
        final String[] Fiji = new String[] {
               "\u092b\u093f\u091c\u0940 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "FJT",
               "\u092b\u093f\u091c\u0940 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "FJST",
               "\u092b\u093f\u091c\u0940 \u0935\u0947\u0933",
               "FJT",
            };
        final String[] Reunion = new String[] {
               "\u0930\u093f\u092f\u0941\u0928\u093f\u092f\u0928 \u0935\u0947\u0933",
               "RET",
               "Reunion Summer Time",
               "REST",
               "Reunion Time",
               "RET",
            };
        final String[] Cocos = new String[] {
               "\u0915\u0949\u0915\u094b\u0938 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "CCT",
               "Cocos Islands Summer Time",
               "CCST",
               "Cocos Islands Time",
               "CCT",
            };
        final String[] Chatham = new String[] {
               "\u091a\u0945\u0925\u092e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CHAST",
               "\u091a\u0945\u0925\u092e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "CHADT",
               "\u091a\u0945\u0925\u092e \u0935\u0947\u0933",
               "CHAT",
            };
        final String[] Vostok = new String[] {
               "\u0935\u094d\u0939\u094b\u0938\u094d\u091f\u0949\u0915 \u0935\u0947\u0933",
               "VOST",
               "Vostok Summer Time",
               "VOSST",
               "Vostok Time",
               "VOST",
            };
        final String[] Argentina = new String[] {
               "\u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ART",
               "\u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "ARST",
               "\u0905\u0930\u094d\u091c\u0947\u0902\u091f\u093f\u0928\u093e \u0935\u0947\u0933",
               "ART",
            };
        final String[] Gambier = new String[] {
               "\u0917\u0945\u092e\u094d\u092c\u093f\u092f\u0930 \u0935\u0947\u0933",
               "GAMT",
               "Gambier Summer Time",
               "GAMST",
               "Gambier Time",
               "GAMT",
            };
        final String[] Kamchatka = new String[] {
               "\u092a\u0947\u091f\u094d\u0930\u094b\u092a\u093e\u0935\u094d\u0939\u0932\u094b\u0938\u094d\u0915- \u0915\u093e\u092e\u091a\u093e\u091f\u094d\u0938\u094d\u0915\u0940 \u092a\u094d\u0930\u092e\u093e\u0923\u0935\u0947\u0933",
               "PETT",
               "\u092a\u0947\u091f\u094d\u0930\u094b\u092a\u093e\u0935\u094d\u0939\u0932\u094b\u0938\u094d\u0915- \u0915\u093e\u092e\u091a\u093e\u091f\u094d\u0938\u094d\u0915\u0940 \u0917\u094d\u0930\u0940\u0937\u094d\u092e\u0915\u093e\u0932\u0940\u0928 \u0935\u0947\u0933",
               "PETST",
               "\u092a\u0947\u091f\u094d\u0930\u094b\u092a\u093e\u0935\u094d\u0939\u0932\u094b\u0938\u094d\u0915- \u0915\u093e\u092e\u091a\u093e\u091f\u094d\u0938\u094d\u0915\u0940 \u0935\u0947\u0933",
               "PETT",
            };
        final String[] Tuvalu = new String[] {
               "\u0924\u0941\u0935\u093e\u0932\u0942 \u0935\u0947\u0933",
               "TVT",
               "Tuvalu Summer Time",
               "TVST",
               "Tuvalu Time",
               "TVT",
            };
        final String[] Galapagos = new String[] {
               "\u0917\u0945\u0932\u093e\u092a\u093e\u0917\u094b\u0938 \u0935\u0947\u0933",
               "GALT",
               "Galapagos Summer Time",
               "GALST",
               "Galapagos Time",
               "GALT",
            };
        final String[] Macquarie = new String[] {
               "\u092e\u0945\u0915\u094d\u0935\u0947\u0930\u0940 \u092c\u0947\u091f \u0935\u0947\u0933",
               "MIST",
               "Macquarie Island Daylight Time",
               "MIDT",
               "Macquarie Island Time",
               "MIST",
            };
        final String[] Venezuela = new String[] {
               "\u0935\u094d\u0939\u0947\u0928\u0947\u091d\u0941\u090f\u0932\u093e \u0935\u0947\u0933",
               "VET",
               "Venezuela Summer Time",
               "VEST",
               "Venezuela Time",
               "VET",
            };
        final String[] Hawaii_Aleutian = new String[] {
               "\u0939\u0935\u093e\u0908-\u0905\u0932\u0942\u0936\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "HAST",
               "\u0939\u0935\u093e\u0908-\u0905\u0932\u0942\u0936\u0928 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "HADT",
               "\u0939\u0935\u093e\u0908-\u0905\u0932\u0942\u0936\u0928 \u0935\u0947\u0933",
               "HAT",
            };
        final String[] Australia_Central = new String[] {
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092e\u0927\u094d\u092f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ACST",
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092e\u0927\u094d\u092f \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "ACDT",
               "\u092e\u0927\u094d\u092f \u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u093e \u0935\u0947\u0933",
               "ACT",
            };
        final String[] America_Pacific = new String[] {
               "\u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PST",
               "\u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "PDT",
               "\u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u0935\u0947\u0933",
               "PT",
            };
        final String[] Phoenix_Islands = new String[] {
               "\u200d\u092b\u094b\u0928\u093f\u0915\u094d\u0938 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "PHOT",
               "Phoenix Is. Summer Time",
               "PHOST",
               "Phoenix Is. Time",
               "PHOT",
            };
        final String[] Turkmenistan = new String[] {
               "\u0924\u0941\u0930\u094d\u0915\u092e\u0947\u0928\u093f\u0938\u094d\u0924\u093e\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "TMT",
               "\u0924\u0941\u0930\u094d\u0915\u092e\u0947\u0928\u093f\u0938\u094d\u0924\u093e\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "TMST",
               "\u0924\u0941\u0930\u094d\u0915\u092e\u0947\u0928\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "TMT",
            };
        final String[] Europe_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "WET",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "WEST",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u092f\u0941\u0930\u094b\u092a\u093f\u092f\u0928 \u0935\u0947\u0933",
               "WET",
            };
        final String[] Cape_Verde = new String[] {
               "\u0915\u0947\u092a \u0935\u094d\u0939\u0930\u094d\u0921\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CVT",
               "\u0915\u0947\u092a \u0935\u094d\u0939\u0930\u094d\u0921\u0947 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CVST",
               "\u0915\u0947\u092a \u0935\u094d\u0939\u0930\u094d\u0921\u0947 \u0935\u0947\u0933",
               "CVT",
            };
        final String[] Norfolk = new String[] {
               "\u0928\u0949\u0930\u092b\u094b\u0915 \u092c\u0947\u091f \u0935\u0947\u0933",
               "NFT",
               "Norfolk Summer Time",
               "NFST",
               "Norfolk Time",
               "NFT",
            };
        final String[] Guyana = new String[] {
               "\u0917\u092f\u093e\u0928\u093e \u0935\u0947\u0933",
               "GYT",
               "Guyana Summer Time",
               "GYST",
               "Guyana Time",
               "GYT",
            };
        final String[] Pitcairn = new String[] {
               "\u092a\u093f\u091f\u0915\u0948\u0930\u094d\u0928 \u0935\u0947\u0933",
               "PST",
               "Pitcairn Daylight Time",
               "PDT",
               "Pitcairn Time",
               "PT",
            };
        final String[] Rothera = new String[] {
               "\u0930\u094b\u0925\u0947\u0930\u093e \u0935\u0947\u0933",
               "ROTT",
               "Rothera Summer Time",
               "ROTST",
               "Rothera Time",
               "ROTT",
            };
        final String[] Samoa = new String[] {
               "\u0938\u093e\u092e\u094b\u0906 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "SST",
               "\u0938\u093e\u092e\u094b\u0906 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "SDT",
               "\u0938\u093e\u092e\u094b\u0906 \u0935\u0947\u0933",
               "ST",
            };
        final String[] Palau = new String[] {
               "\u092a\u0932\u093e\u090a \u0935\u0947\u0933",
               "PWT",
               "Palau Summer Time",
               "PWST",
               "Palau Time",
               "PWT",
            };
        final String[] Europe_Further_Eastern = new String[] {
               "\u0905\u0917\u094d\u0930 \u092a\u0941\u0930\u094d\u0935 \u092f\u0942\u0930\u094b\u092a\u0940\u092f\u0928 \u0935\u0947\u0933",
               "MSK",
               "Moscow Daylight Time",
               "MSD",
               "Moscow Time",
               "MT",
            };
        final String[] Azerbaijan = new String[] {
               "\u0905\u091d\u0930\u092c\u0948\u091c\u093e\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AZT",
               "\u0905\u091d\u0930\u092c\u0948\u091c\u093e\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "AZST",
               "\u0905\u091d\u0930\u092c\u0948\u091c\u093e\u0928 \u0935\u0947\u0933",
               "AZT",
            };
        final String[] Mawson = new String[] {
               "\u092e\u0949\u0938\u0928 \u0935\u0947\u0933",
               "MAWT",
               "Mawson Summer Time",
               "MAWST",
               "Mawson Time",
               "MAWT",
            };
        final String[] Mexico_Pacific = new String[] {
               "\u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "MST",
               "\u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "MDT",
               "\u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u092a\u0945\u0938\u093f\u092b\u093f\u0915 \u0935\u0947\u0933",
               "MT",
            };
        final String[] Davis = new String[] {
               "\u0921\u0947\u0935\u094d\u0939\u093f\u0938 \u0935\u0947\u0933",
               "DAVT",
               "Davis Summer Time",
               "DAVST",
               "Davis Time",
               "DAVT",
            };
        final String[] Cuba = new String[] {
               "\u0915\u094d\u092f\u0942\u092c\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CST",
               "\u0915\u094d\u092f\u0942\u092c\u093e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "CDT",
               "\u0915\u094d\u092f\u0942\u092c\u093e \u0935\u0947\u0933",
               "CT",
            };
        final String[] Africa_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CAT",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CAST",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0906\u092b\u094d\u0930\u093f\u0915\u093e \u0935\u0947\u0933",
               "CAT",
            };
        final String[] GMT = new String[] {
               "\u0917\u094d\u0930\u0940\u0928\u093f\u091a \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
               "Greenwich Mean Time",
               "GMT",
            };
        final String[] Philippines = new String[] {
               "\u092b\u093f\u0932\u093f\u092a\u093e\u0907\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PHT",
               "\u092b\u093f\u0932\u093f\u092a\u093e\u0907\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "PHST",
               "\u092b\u093f\u0932\u093f\u092a\u093e\u0907\u0928 \u0935\u0947\u0933",
               "PHT",
            };
        final String[] French_Southern = new String[] {
               "\u092b\u094d\u0930\u0947\u0902\u091a \u0926\u0915\u094d\u0937\u093f\u0923 \u0906\u0923\u093f \u0905\u0902\u091f\u093e\u0930\u094d\u0915\u094d\u091f\u093f\u0915 \u0935\u0947\u0933",
               "TFT",
               "French Southern & Antarctic Lands Summer Time",
               "TFST",
               "French Southern & Antarctic Lands Time",
               "TFT",
            };
        final String[] South_Georgia = new String[] {
               "\u0926\u0915\u094d\u0937\u093f\u0923 \u091c\u0949\u0930\u094d\u091c\u093f\u092f\u093e \u0935\u0947\u0933",
               "GST",
               "South Georgia Daylight Time",
               "GDT",
               "South Georgia Time",
               "GT",
            };
        final String[] New_Caledonia = new String[] {
               "\u0928\u094d\u092f\u0942 \u0915\u0945\u0932\u0947\u0921\u094b\u0928\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "NCT",
               "\u0928\u094d\u092f\u0942 \u0915\u0945\u0932\u0947\u0921\u094b\u0928\u093f\u092f\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "NCST",
               "\u0928\u094d\u092f\u0942 \u0915\u0945\u0932\u0947\u0921\u094b\u0928\u093f\u092f\u093e \u0935\u0947\u0933",
               "NCT",
            };
        final String[] Brunei = new String[] {
               "\u092c\u094d\u0930\u0941\u0928\u0947\u0908 \u0926\u093e\u0930\u0942\u0938\u0932\u093e\u092e \u0935\u0947\u0933",
               "BNT",
               "Brunei Summer Time",
               "BNST",
               "Brunei Time",
               "BNT",
            };
        final String[] Iran = new String[] {
               "\u0907\u0930\u093e\u0923 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "IRST",
               "\u0907\u0930\u093e\u0923 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "IRDT",
               "\u0907\u0930\u093e\u0923 \u0935\u0947\u0933",
               "IRT",
            };
        final String[] Easter = new String[] {
               "\u0907\u0938\u094d\u091f\u0930 \u092c\u0947\u091f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "EAST",
               "\u0907\u0938\u094d\u091f\u0930 \u092c\u0947\u091f \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "EASST",
               "\u0907\u0938\u094d\u091f\u0930 \u092c\u0947\u091f \u0935\u0947\u0933",
               "EAST",
            };
        final String[] Mexico_Northwest = new String[] {
               "\u0935\u093e\u092f\u0935\u094d\u092f \u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PST",
               "\u0935\u093e\u092f\u0935\u094d\u092f \u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "PDT",
               "\u0935\u093e\u092f\u0935\u094d\u092f \u092e\u0947\u0915\u094d\u0938\u093f\u0915\u094b \u0935\u0947\u0933",
               "PT",
            };
        final String[] DumontDUrville = new String[] {
               "\u0921\u094d\u092f\u0941\u092e\u0949\u0928\u094d\u091f-\u0921\u094d\u092f\u0941\u0930\u094d\u0935\u093f\u0932 \u0935\u0947\u0933",
               "DDUT",
               "Dumont-d'Urville Summer Time",
               "DDUST",
               "Dumont-d'Urville Time",
               "DDUT",
            };
        final String[] Tajikistan = new String[] {
               "\u0924\u093e\u091c\u093f\u0915\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "TJT",
               "Tajikistan Summer Time",
               "TJST",
               "Tajikistan Time",
               "TJT",
            };
        final String[] Tonga = new String[] {
               "\u091f\u094b\u0902\u0917\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "TOT",
               "\u091f\u094b\u0902\u0917\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "TOST",
               "\u091f\u094b\u0902\u0917\u093e \u0935\u0947\u0933",
               "TOT",
            };
        final String[] Bangladesh = new String[] {
               "\u092c\u093e\u0902\u0917\u0932\u093e\u0926\u0947\u0936 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "BDT",
               "\u092c\u093e\u0902\u0917\u0932\u093e\u0926\u0947\u0936 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "BDST",
               "\u092c\u093e\u0902\u0917\u0932\u093e\u0926\u0947\u0936 \u0935\u0947\u0933",
               "BDT",
            };
        final String[] Peru = new String[] {
               "\u092a\u0947\u0930\u0941 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "PET",
               "\u092a\u0947\u0930\u0941 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "PEST",
               "\u092a\u0947\u0930\u0941 \u0935\u0947\u0933",
               "PET",
            };
        final String[] Greenland_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "WGT",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "WGST",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u0935\u0947\u0933",
               "WGT",
            };
        final String[] Ecuador = new String[] {
               "\u0907\u0915\u094d\u0935\u0947\u0921\u094b\u0930 \u0935\u0947\u0933",
               "ECT",
               "Ecuador Summer Time",
               "ECST",
               "Ecuador Time",
               "ECT",
            };
        final String[] Greenland_Eastern = new String[] {
               "\u092a\u0942\u0930\u094d\u0935 \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "EGT",
               "\u092a\u0942\u0930\u094d\u0935 \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "EGST",
               "\u092a\u0942\u0930\u094d\u0935 \u0917\u094d\u0930\u0940\u0928\u0932\u0901\u0921 \u0935\u0947\u0933",
               "EGT",
            };
        final String[] Gulf = new String[] {
               "\u0916\u093e\u0921\u0940 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "GST",
               "Gulf Daylight Time",
               "GDT",
               "Gulf Time",
               "GT",
            };
        final String[] Indonesia_Eastern = new String[] {
               "\u092a\u094c\u0930\u094d\u0935\u093e\u0924\u094d\u092f \u0907\u0902\u0921\u094b\u0928\u0947\u0936\u093f\u092f\u093e \u0935\u0947\u0933",
               "WIT",
               "East Indonesia Summer Time",
               "EIST",
               "East Indonesia Time",
               "WIT",
            };
        final String[] Korea = new String[] {
               "\u0915\u094b\u0930\u093f\u092f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "KST",
               "\u0915\u094b\u0930\u093f\u092f\u0928 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "KDT",
               "\u0915\u094b\u0930\u093f\u092f\u0928 \u0935\u0947\u0933",
               "KT",
            };
        final String[] Australia_Western = new String[] {
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092a\u0936\u094d\u091a\u093f\u092e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AWST",
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092a\u0936\u094d\u091a\u093f\u092e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "AWDT",
               "\u092a\u0936\u094d\u091a\u093f\u092e \u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u093e \u0935\u0947\u0933",
               "AWT",
            };
        final String[] Kyrgystan = new String[] {
               "\u0915\u093f\u0930\u0917\u093f\u0938\u094d\u0924\u093e\u0928 \u0935\u0947\u0933",
               "KGT",
               "Kirgizstan Summer Time",
               "KGST",
               "Kirgizstan Time",
               "KGT",
            };
        final String[] Indonesia_Western = new String[] {
               "\u092a\u0936\u094d\u091a\u093f\u092e\u0940 \u0907\u0902\u0921\u094b\u0928\u0947\u0936\u093f\u092f\u093e \u0935\u0947\u0933",
               "WIB",
               "West Indonesia Summer Time",
               "WIST",
               "West Indonesia Time",
               "WIB",
            };
        final String[] Australia_Eastern = new String[] {
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092a\u0942\u0930\u094d\u0935 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AEST",
               "\u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u0928 \u092a\u0942\u0930\u094d\u0935 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "AEDT",
               "\u092a\u0942\u0930\u094d\u0935 \u0911\u0938\u094d\u091f\u094d\u0930\u0947\u0932\u093f\u092f\u093e \u0935\u0947\u0933",
               "AET",
            };
        final String[] French_Guiana = new String[] {
               "\u092b\u094d\u0930\u0947\u0902\u091a \u0917\u092f\u093e\u0928\u093e \u0935\u0947\u0933",
               "GFT",
               "French Guiana Summer Time",
               "GFST",
               "French Guiana Time",
               "GFT",
            };
        final String[] Colombia = new String[] {
               "\u0915\u094b\u0932\u0902\u092c\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "COT",
               "\u0915\u094b\u0932\u0902\u092c\u093f\u092f\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "COST",
               "\u0915\u094b\u0932\u0902\u092c\u093f\u092f\u093e \u0935\u0947\u0933",
               "COT",
            };
        final String[] Chile = new String[] {
               "\u091a\u093f\u0932\u0940 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CLT",
               "\u091a\u093f\u0932\u0940 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CLST",
               "\u091a\u093f\u0932\u0940 \u0935\u0947\u0933",
               "CLT",
            };
        final String[] Gilbert_Islands = new String[] {
               "\u0917\u093f\u0932\u094d\u092c\u0930\u094d\u091f \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
               "GILT",
               "Gilbert Is. Summer Time",
               "GILST",
               "Gilbert Is. Time",
               "GILT",
            };
        final String[] America_Mountain = new String[] {
               "\u092a\u0930\u094d\u0935\u0924\u0940\u092f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "MST",
               "\u092a\u0930\u094d\u0935\u0924\u0940\u092f \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "MDT",
               "\u092a\u0930\u094d\u0935\u0924\u0940\u092f \u0935\u0947\u0933",
               "MT",
            };
        final String[] Marquesas = new String[] {
               "\u092e\u093e\u0930\u094d\u0915\u094d\u0935\u0947\u0938\u093e\u0938 \u0935\u0947\u0933",
               "MART",
               "Marquesas Summer Time",
               "MARST",
               "Marquesas Time",
               "MART",
            };
        final String[] Arabian = new String[] {
               "\u0905\u0930\u0947\u092c\u093f\u092f\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AST",
               "\u0905\u0930\u0947\u092c\u093f\u092f\u0928 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "ADT",
               "\u0905\u0930\u0947\u092c\u093f\u092f\u0928 \u0935\u0947\u0933",
               "AT",
            };
        final String[] Alaska = new String[] {
               "\u0905\u0932\u093e\u0938\u094d\u0915\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AKST",
               "\u0905\u0932\u093e\u0938\u094d\u0915\u093e \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "AKDT",
               "\u0905\u0932\u093e\u0938\u094d\u0915\u093e \u0935\u0947\u0933",
               "AKT",
            };
        final String[] Vladivostok = new String[] {
               "\u0935\u094d\u0932\u093e\u0926\u093f\u0935\u094b\u0938\u094d\u0924\u094b\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "VLAT",
               "\u0935\u094d\u0932\u093e\u0926\u093f\u0935\u094b\u0938\u094d\u0924\u094b\u0915 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "VLAST",
               "\u0935\u094d\u0932\u093e\u0926\u093f\u0935\u094b\u0938\u094d\u0924\u094b\u0915 \u0935\u0947\u0933",
               "VLAT",
            };
        final String[] Chamorro = new String[] {
               "\u091a\u093e\u092e\u094b\u0930\u094b \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "ChST",
               "Chamorro Daylight Time",
               "ChDT",
               "Chamorro Time",
               "ChT",
            };
        final String[] Irkutsk = new String[] {
               "\u0907\u0930\u094d\u0915\u0941\u0924\u094d\u0938\u0915 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "IRKT",
               "\u0907\u0930\u094d\u0915\u0941\u0924\u094d\u0938\u0915 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "IRKST",
               "\u0907\u0930\u094d\u0915\u0941\u0924\u094d\u0938\u0915 \u0935\u0947\u0933",
               "IRKT",
            };
        final String[] Georgia = new String[] {
               "\u091c\u0949\u0930\u094d\u091c\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "GET",
               "\u091c\u0949\u0930\u094d\u091c\u093f\u092f\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "GEST",
               "\u091c\u0949\u0930\u094d\u091c\u093f\u092f\u093e \u0935\u0947\u0933",
               "GET",
            };
        final String[] Tokelau = new String[] {
               "\u091f\u094b\u0915\u0947\u0932\u093e\u090a \u0935\u0947\u0933",
               "TKT",
               "Tokelau Summer Time",
               "TKST",
               "Tokelau Time",
               "TKT",
            };
        final String[] Papua_New_Guinea = new String[] {
               "\u092a\u093e\u092a\u0941\u0906 \u0928\u094d\u092f\u0942 \u0917\u093f\u0928\u0940 \u0935\u0947\u0933",
               "PGT",
               "Papua New Guinea Summer Time",
               "PGST",
               "Papua New Guinea Time",
               "PGT",
            };
        final String[] Noronha = new String[] {
               "\u092b\u0930\u094d\u0928\u093e\u0902\u0921\u094b \u0926\u0940 \u0928\u094b\u0930\u094b\u0928\u094d\u0939\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "FNT",
               "\u092b\u0930\u094d\u0928\u093e\u0902\u0921\u094b \u0926\u0940 \u0928\u094b\u0930\u094b\u0928\u094d\u0939\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "FNST",
               "\u092b\u0930\u094d\u0928\u093e\u0902\u0921\u094b \u0926\u0940 \u0928\u094b\u0930\u094b\u0928\u094d\u0939\u093e \u0935\u0947\u0933",
               "FNT",
            };
        final String[] Choibalsan = new String[] {
               "\u091a\u094b\u0908\u092c\u093e\u0932\u094d\u0938\u0928 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CHOT",
               "\u091a\u094b\u0908\u092c\u093e\u0932\u094d\u0938\u0928 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CHOST",
               "\u091a\u094b\u0908\u092c\u093e\u0932\u094d\u0938\u0928 \u0935\u0947\u0933",
               "CHOT",
            };
        final String[] Brasilia = new String[] {
               "\u092c\u094d\u0930\u093e\u091d\u093f\u0932\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "BRT",
               "\u092c\u094d\u0930\u093e\u091d\u093f\u0932\u093f\u092f\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "BRST",
               "\u092c\u094d\u0930\u093e\u091d\u093f\u0932\u093f\u092f\u093e \u0935\u0947\u0933",
               "BRT",
            };
        final String[] China = new String[] {
               "\u091a\u0940\u0928\u0940 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CST",
               "\u091a\u0940\u0928\u0940 \u0938\u0942\u0930\u094d\u092f\u092a\u094d\u0930\u0915\u093e\u0936 \u0935\u0947\u0933",
               "CDT",
               "\u091a\u0940\u0928\u0940 \u0935\u0947\u0933",
               "CT",
            };
        final String[] Armenia = new String[] {
               "\u0906\u0930\u094d\u092e\u0947\u0928\u093f\u092f\u093e \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "AMT",
               "\u0906\u0930\u094d\u092e\u0947\u0928\u093f\u092f\u093e \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "AMST",
               "\u0906\u0930\u094d\u092e\u0947\u0928\u093f\u092f\u093e \u0935\u0947\u0933",
               "AMT",
            };
        final String[] Samara = new String[] {
               "\u0938\u093e\u092e\u0930\u093e \u092a\u094d\u0930\u092e\u093e\u0923\u0935\u0947\u0933",
               "SAMT",
               "\u0938\u093e\u092e\u0930\u093e \u0917\u094d\u0930\u0940\u0937\u094d\u092e\u0915\u093e\u0932\u0940\u0928 \u0935\u0947\u0933",
               "SAMST",
               "\u0938\u092e\u093e\u0930\u093e \u0935\u0947\u0933",
               "SAMT",
            };
        final String[] India = new String[] {
               "\u092d\u093e\u0930\u0924\u0940\u092f \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "IST",
               "India Daylight Time",
               "IDT",
               "India Time",
               "IT",
            };
        final String[] Cook = new String[] {
               "\u0915\u0941\u0915 \u092c\u0947\u091f\u0947 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
               "CKT",
               "\u0915\u0941\u0915 \u092c\u0947\u091f\u0947 \u0905\u0930\u094d\u0927 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
               "CKHST",
               "\u0915\u0941\u0915 \u092c\u0947\u091f\u0947 \u0935\u0947\u0933",
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
                    "\u0917\u094d\u0930\u0940\u0928\u093f\u091a \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
                    "GMT",
                    "\u092c\u094d\u0930\u093f\u091f\u093f\u0936 \u0909\u0928\u094d\u0939\u093e\u0933\u0940 \u0935\u0947\u0933",
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
                    "\u0917\u094d\u0930\u0940\u0928\u093f\u091a \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
                    "GMT",
                    "\u0906\u092f\u0930\u093f\u0936 \u092a\u094d\u0930\u092e\u093e\u0923 \u0935\u0947\u0933",
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
