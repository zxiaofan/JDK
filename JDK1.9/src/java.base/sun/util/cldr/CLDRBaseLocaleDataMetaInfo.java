/*
 * Copyright (c) 2012, 2017, Oracle and/or its affiliates. All rights reserved.
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

package sun.util.cldr;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import sun.util.locale.provider.LocaleProviderAdapter;
import sun.util.locale.provider.LocaleDataMetaInfo;

public class CLDRBaseLocaleDataMetaInfo implements LocaleDataMetaInfo {
    private static final Map<String, String> resourceNameToLocales = new HashMap<>();
    private static final Map<Locale, String[]> parentLocalesMap = new HashMap<>();

    static {

        resourceNameToLocales.put("CurrencyNames",
              " en en-US");
        resourceNameToLocales.put("AvailableLocales",
              " en en-US en-US-POSIX");
        parentLocalesMap.put(Locale.forLanguageTag("es-419"),
             new String[] {
                 "", "es-AR", "es-BO", "es-BR", "es-CL", "es-CO", "es-CR", "es-CU", 
                 "es-DO", "es-EC", "es-GT", "es-HN", "es-MX", "es-NI", "es-PA", "es-PE", 
                 "es-PR", "es-PY", "es-SV", "es-US", "es-UY", "es-VE", 
             });
        resourceNameToLocales.put("CalendarData",
              " en-US");
        resourceNameToLocales.put("FormatData",
              " en en-US en-US-POSIX");
        resourceNameToLocales.put("LocaleNames",
              " en en-US");
        resourceNameToLocales.put("TimeZoneNames",
              " en en-US");
        parentLocalesMap.put(Locale.ROOT,
             new String[] {
                 "", "az-Arab", "az-Cyrl", "bm-Nkoo", "bs-Cyrl", "en-Dsrt", "en-Shaw", 
                 "ha-Arab", "iu-Latn", "mn-Mong", "ms-Arab", "pa-Arab", "shi-Latn", 
                 "sr-Latn", "uz-Arab", "uz-Cyrl", "vai-Latn", "yue-Hans", "zh-Hant", 
             });
        parentLocalesMap.put(Locale.forLanguageTag("en-001"),
             new String[] {
                 "", "en-150", "en-AG", "en-AI", "en-AU", "en-BB", "en-BE", "en-BM", 
                 "en-BS", "en-BW", "en-BZ", "en-CA", "en-CC", "en-CK", "en-CM", "en-CX", 
                 "en-CY", "en-DG", "en-DM", "en-ER", "en-FJ", "en-FK", "en-FM", "en-GB", 
                 "en-GD", "en-GG", "en-GH", "en-GI", "en-GM", "en-GY", "en-HK", "en-IE", 
                 "en-IL", "en-IM", "en-IN", "en-IO", "en-JE", "en-JM", "en-KE", "en-KI", 
                 "en-KN", "en-KY", "en-LC", "en-LR", "en-LS", "en-MG", "en-MO", "en-MS", 
                 "en-MT", "en-MU", "en-MW", "en-MY", "en-NA", "en-NF", "en-NG", "en-NR", 
                 "en-NU", "en-NZ", "en-PG", "en-PH", "en-PK", "en-PN", "en-PW", "en-RW", 
                 "en-SB", "en-SC", "en-SD", "en-SG", "en-SH", "en-SL", "en-SS", "en-SX", 
                 "en-SZ", "en-TC", "en-TK", "en-TO", "en-TT", "en-TV", "en-TZ", "en-UG", 
                 "en-VC", "en-VG", "en-VU", "en-WS", "en-ZA", "en-ZM", "en-ZW", 
             });
        parentLocalesMap.put(Locale.forLanguageTag("zh-Hant-HK"),
             new String[] {
                 "", "zh-Hant-MO", 
             });
        parentLocalesMap.put(Locale.forLanguageTag("pt-PT"),
             new String[] {
                 "", "pt-AO", "pt-CH", "pt-CV", "pt-GQ", "pt-GW", "pt-LU", "pt-MO", 
                 "pt-MZ", "pt-ST", "pt-TL", 
             });
        parentLocalesMap.put(Locale.forLanguageTag("en-150"),
             new String[] {
                 "", "en-AT", "en-CH", "en-DE", "en-DK", "en-FI", "en-NL", "en-SE", 
                 "en-SI", 
             });
    }


    @Override
    public LocaleProviderAdapter.Type getType() {
        return LocaleProviderAdapter.Type.CLDR;
    }


    @Override
    public String availableLanguageTags(String category) {
        return resourceNameToLocales.getOrDefault(category, "");
    }


    public Map<Locale, String[]> parentLocales() {
        return parentLocalesMap;
    }
}