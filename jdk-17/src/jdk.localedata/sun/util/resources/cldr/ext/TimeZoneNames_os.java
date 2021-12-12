/*
 * Copyright (c) 2012, 2021, Oracle and/or its affiliates. All rights reserved.
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
 * Copyright (c) 1991-2020 Unicode, Inc. All rights reserved.
 * Distributed under the Terms of Use in https://www.unicode.org/copyright.html.
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of the Unicode data files and any associated documentation
 * (the "Data Files") or Unicode software and any associated documentation
 * (the "Software") to deal in the Data Files or Software
 * without restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, and/or sell copies of
 * the Data Files or Software, and to permit persons to whom the Data Files
 * or Software are furnished to do so, provided that either
 * (a) this copyright and permission notice appear with all copies
 * of the Data Files or Software, or
 * (b) this copyright and permission notice appear in associated
 * Documentation.
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

public class TimeZoneNames_os extends TimeZoneNamesBundle {
    @Override
    protected final Object[][] getContents() {
        final String[] GMT = new String[] {
               "\u0413\u0440\u0438\u043d\u0432\u0438\u0447\u044b \u0440\u04d5\u0441\u0442\u04d5\u043c\u0431\u0438\u0441 \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Moscow = new String[] {
               "\u041c\u04d5\u0441\u043a\u0443\u044b\u0439\u044b \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u041c\u04d5\u0441\u043a\u0443\u044b\u0439\u044b \u0441\u04d5\u0440\u0434\u044b\u0433\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u041c\u04d5\u0441\u043a\u0443\u044b\u0439\u044b \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
            };
        final String[] Georgia = new String[] {
               "\u0413\u0443\u044b\u0440\u0434\u0437\u044b\u0441\u0442\u043e\u043d\u044b \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0413\u0443\u044b\u0440\u0434\u0437\u044b\u0441\u0442\u043e\u043d\u044b \u0441\u04d5\u0440\u0434\u044b\u0433\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0413\u0443\u044b\u0440\u0434\u0437\u044b\u0441\u0442\u043e\u043d\u044b \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
            };
        final String[] EMPTY_ZONE = new String[] {
               "",
               "",
               "",
               "",
               "",
               "",
            };
        final String[] Europe_Central = new String[] {
               "\u0410\u0441\u0442\u04d5\u0443\u043a\u043a\u0430\u0433 \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0410\u0441\u0442\u04d5\u0443\u043a\u043a\u0430\u0433 \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u04d5\u0440\u0434\u044b\u0433\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0410\u0441\u0442\u04d5\u0443\u043a\u043a\u0430\u0433 \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
            };
        final String[] Europe_Eastern = new String[] {
               "\u0421\u043a\u04d5\u0441\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0421\u043a\u04d5\u0441\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u04d5\u0440\u0434\u044b\u0433\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u0421\u043a\u04d5\u0441\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
            };
        final String[] Europe_Western = new String[] {
               "\u041d\u044b\u0433\u044a\u0443\u044b\u043b\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u0442\u0430\u043d\u0434\u0430\u0440\u0442\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u041d\u044b\u0433\u044a\u0443\u044b\u043b\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0441\u04d5\u0440\u0434\u044b\u0433\u043e\u043d \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
               "\u041d\u044b\u0433\u044a\u0443\u044b\u043b\u04d5\u043d \u0415\u0432\u0440\u043e\u043f\u04d5\u0439\u0430\u0433 \u0440\u04d5\u0441\u0442\u04d5\u0433",
               "",
            };
        final Object[][] data = new Object[][] {
            { "Europe/Paris", Europe_Central },
            { "GMT", GMT },
            { "Europe/Bucharest", Europe_Eastern },
            { "UTC", EMPTY_ZONE },
            { "ART", Europe_Eastern },
            { "ECT", Europe_Central },
            { "Etc/GMT", GMT },
            { "Asia/Gaza", Europe_Eastern },
            { "Asia/Amman", Europe_Eastern },
            { "Africa/Lome", GMT },
            { "Asia/Beirut", Europe_Eastern },
            { "Asia/Hebron", Europe_Eastern },
            { "Europe/Kiev", Europe_Eastern },
            { "Europe/Oslo", Europe_Central },
            { "Europe/Riga", Europe_Eastern },
            { "Europe/Rome", Europe_Central },
            { "Africa/Accra", GMT },
            { "Africa/Cairo", Europe_Eastern },
            { "Africa/Ceuta", Europe_Central },
            { "Africa/Dakar", GMT },
            { "Africa/Tunis", Europe_Central },
            { "Asia/Nicosia", Europe_Eastern },
            { "Asia/Tbilisi", Georgia },
            { "Europe/Malta", Europe_Central },
            { "Europe/Minsk", Moscow },
            { "Europe/Sofia", Europe_Eastern },
            { "Europe/Vaduz", Europe_Central },
            { "Africa/Bamako", GMT },
            { "Africa/Banjul", GMT },
            { "Africa/Bissau", GMT },
            { "Asia/Damascus", Europe_Eastern },
            { "Europe/Athens", Europe_Eastern },
            { "Europe/Berlin", Europe_Central },
            { "Europe/Dublin", GMT },
            { "Europe/Jersey", GMT },
            { "Europe/Lisbon", Europe_Western },
            { "Europe/London", GMT },
            { "Europe/Madrid", Europe_Central },
            { "Europe/Monaco", Europe_Central },
            { "Europe/Moscow", Moscow },
            { "Europe/Prague", Europe_Central },
            { "Europe/Skopje", Europe_Central },
            { "Europe/Tirane", Europe_Central },
            { "Europe/Vienna", Europe_Central },
            { "Europe/Warsaw", Europe_Central },
            { "Europe/Zagreb", Europe_Central },
            { "Europe/Zurich", Europe_Central },
            { "Africa/Abidjan", GMT },
            { "Africa/Algiers", Europe_Central },
            { "Africa/Conakry", GMT },
            { "Africa/Tripoli", Europe_Eastern },
            { "Europe/Andorra", Europe_Central },
            { "Europe/Belfast", GMT },
            { "Europe/Tallinn", Europe_Eastern },
            { "Europe/Vatican", Europe_Central },
            { "Europe/Vilnius", Europe_Eastern },
            { "Africa/Freetown", GMT },
            { "Africa/Monrovia", GMT },
            { "Africa/Sao_Tome", GMT },
            { "Africa/Timbuktu", GMT },
            { "Atlantic/Canary", Europe_Western },
            { "Atlantic/Faeroe", Europe_Western },
            { "Europe/Belgrade", Europe_Central },
            { "Europe/Brussels", Europe_Central },
            { "Europe/Budapest", Europe_Central },
            { "Europe/Busingen", Europe_Central },
            { "Europe/Chisinau", Europe_Eastern },
            { "Europe/Guernsey", GMT },
            { "Europe/Helsinki", Europe_Eastern },
            { "Europe/Sarajevo", Europe_Central },
            { "Europe/Uzhgorod", Europe_Eastern },
            { "Antarctica/Troll", GMT },
            { "Atlantic/Madeira", Europe_Western },
            { "Europe/Amsterdam", Europe_Central },
            { "Europe/Gibraltar", Europe_Central },
            { "Europe/Ljubljana", Europe_Central },
            { "Europe/Mariehamn", Europe_Eastern },
            { "Europe/Podgorica", Europe_Central },
            { "Europe/Stockholm", Europe_Central },
            { "Africa/Nouakchott", GMT },
            { "Europe/Bratislava", Europe_Central },
            { "Europe/Copenhagen", Europe_Central },
            { "Europe/Luxembourg", Europe_Central },
            { "Europe/San_Marino", Europe_Central },
            { "Europe/Simferopol", Moscow },
            { "Europe/Zaporozhye", Europe_Eastern },
            { "Africa/Ouagadougou", GMT },
            { "Atlantic/Jan_Mayen", Europe_Central },
            { "Atlantic/Reykjavik", GMT },
            { "Atlantic/St_Helena", GMT },
            { "Europe/Isle_of_Man", GMT },
            { "Europe/Kaliningrad", Europe_Eastern },
            { "Arctic/Longyearbyen", Europe_Central },
            { "America/Danmarkshavn", GMT },
            { "timezone.excity.Etc/Unknown", "\u041d\u04d5\u0437\u043e\u043d\u0433\u04d5" },
            { "timezone.excity.Asia/Tbilisi", "\u0422\u0431\u0438\u043b\u0438\u0441" },
            { "timezone.excity.Europe/Minsk", "\u041c\u0438\u043d\u0441\u043a" },
            { "timezone.excity.Europe/Moscow", "\u041c\u04d5\u0441\u043a\u0443\u044b" },
        };
        return data;
    }
}
