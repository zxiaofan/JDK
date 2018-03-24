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
package sun.util.cldr;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import sun.util.locale.provider.LocaleDataMetaInfo;
import sun.util.locale.provider.LocaleProviderAdapter;

public class CLDRBaseLocaleDataMetaInfo implements LocaleDataMetaInfo {
    private static final Map<String, String> resourceNameToLocales = new HashMap<>();
    private static final Map<Locale, String[]> parentLocalesMap = new HashMap<>();

    static {
        resourceNameToLocales.put("AvailableLocales",
              " en en-US en-US-POSIX");
        parentLocalesMap.put(Locale.forLanguageTag("es-419"),
             new String[] {
                 "", "es-AR", "es-BO", "es-BR", "es-CL", "es-CO", "es-CR", "es-CU", 
                 "es-DO", "es-EC", "es-GT", "es-HN", "es-MX", "es-NI", "es-PA", "es-PE", 
                 "es-PR", "es-PY", "es-SV", "es-US", "es-UY", "es-VE", 
             });
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

    private static class TZShortIDMapHolder {
        static final Map<String, String> tzShortIDMap = new HashMap<>();
        static {
            tzShortIDMap.put("fmksa", "Pacific/Kosrae");
            tzShortIDMap.put("ruyks", "Asia/Yakutsk");
            tzShortIDMap.put("ltvno", "Europe/Vilnius");
            tzShortIDMap.put("caydq", "America/Dawson_Creek");
            tzShortIDMap.put("brsao", "America/Sao_Paulo Brazil/East");
            tzShortIDMap.put("pwror", "Pacific/Palau");
            tzShortIDMap.put("chzrh", "Europe/Zurich");
            tzShortIDMap.put("svsal", "America/El_Salvador");
            tzShortIDMap.put("vistt", "America/St_Thomas America/Virgin");
            tzShortIDMap.put("ruikt", "Asia/Irkutsk");
            tzShortIDMap.put("gpmsb", "America/Marigot");
            tzShortIDMap.put("aruaq", "America/Argentina/San_Juan");
            tzShortIDMap.put("sesto", "Europe/Stockholm");
            tzShortIDMap.put("uymvd", "America/Montevideo");
            tzShortIDMap.put("mxmty", "America/Monterrey");
            tzShortIDMap.put("esmad", "Europe/Madrid");
            tzShortIDMap.put("grath", "Europe/Athens");
            tzShortIDMap.put("aqcas", "Antarctica/Casey");
            tzShortIDMap.put("bjptn", "Africa/Porto-Novo");
            tzShortIDMap.put("cayda", "America/Dawson");
            tzShortIDMap.put("pnpcn", "Pacific/Pitcairn");
            tzShortIDMap.put("ruovb", "Asia/Novosibirsk");
            tzShortIDMap.put("mxhmo", "America/Hermosillo");
            tzShortIDMap.put("sjlyr", "Arctic/Longyearbyen Atlantic/Jan_Mayen");
            tzShortIDMap.put("uztas", "Asia/Tashkent");
            tzShortIDMap.put("aqddu", "Antarctica/DumontDUrville");
            tzShortIDMap.put("camon", "America/Moncton");
            tzShortIDMap.put("usome", "America/Nome");
            tzShortIDMap.put("uasip", "Europe/Simferopol");
            tzShortIDMap.put("vnsgn", "Asia/Saigon Asia/Ho_Chi_Minh");
            tzShortIDMap.put("nimga", "America/Managua");
            tzShortIDMap.put("joamm", "Asia/Amman");
            tzShortIDMap.put("rwkgl", "Africa/Kigali");
            tzShortIDMap.put("etadd", "Africa/Addis_Ababa");
            tzShortIDMap.put("kgfru", "Asia/Bishkek");
            tzShortIDMap.put("iddjj", "Asia/Jayapura");
            tzShortIDMap.put("cayek", "America/Rankin_Inlet");
            tzShortIDMap.put("sbhir", "Pacific/Guadalcanal");
            tzShortIDMap.put("mzmpm", "Africa/Maputo");
            tzShortIDMap.put("rugdx", "Asia/Magadan");
            tzShortIDMap.put("canpg", "America/Nipigon");
            tzShortIDMap.put("brrbr", "America/Rio_Branco America/Porto_Acre Brazil/Acre");
            tzShortIDMap.put("est5edt", "EST5EDT");
            tzShortIDMap.put("cobog", "America/Bogota");
            tzShortIDMap.put("aiaxa", "America/Anguilla");
            tzShortIDMap.put("cayev", "America/Inuvik");
            tzShortIDMap.put("hntgu", "America/Tegucigalpa");
            tzShortIDMap.put("ptlis", "Europe/Lisbon Portugal");
            tzShortIDMap.put("gugum", "Pacific/Guam");
            tzShortIDMap.put("cynic", "Asia/Nicosia Europe/Nicosia");
            tzShortIDMap.put("tglfw", "Africa/Lome");
            tzShortIDMap.put("auhba", "Australia/Hobart Australia/Tasmania");
            tzShortIDMap.put("gldkshvn", "America/Danmarkshavn");
            tzShortIDMap.put("sgsin", "Asia/Singapore Singapore");
            tzShortIDMap.put("usphx", "America/Phoenix US/Arizona");
            tzShortIDMap.put("szqmn", "Africa/Mbabane");
            tzShortIDMap.put("mkskp", "Europe/Skopje");
            tzShortIDMap.put("pgraw", "Pacific/Bougainville");
            tzShortIDMap.put("pkkhi", "Asia/Karachi");
            tzShortIDMap.put("umjon", "Pacific/Johnston");
            tzShortIDMap.put("ssjub", "Africa/Juba");
            tzShortIDMap.put("glthu", "America/Thule");
            tzShortIDMap.put("iodga", "Indian/Chagos");
            tzShortIDMap.put("brfen", "America/Noronha Brazil/DeNoronha");
            tzShortIDMap.put("glgoh", "America/Godthab");
            tzShortIDMap.put("jmkin", "America/Jamaica Jamaica");
            tzShortIDMap.put("aumel", "Australia/Melbourne Australia/Victoria");
            tzShortIDMap.put("auldh", "Australia/Lord_Howe Australia/LHI");
            tzShortIDMap.put("bqkra", "America/Kralendijk");
            tzShortIDMap.put("somgq", "Africa/Mogadishu");
            tzShortIDMap.put("mrnkc", "Africa/Nouakchott");
            tzShortIDMap.put("capnt", "America/Pangnirtung");
            tzShortIDMap.put("auldc", "Australia/Lindeman");
            tzShortIDMap.put("azbak", "Asia/Baku");
            tzShortIDMap.put("cnurc", "Asia/Urumqi Asia/Kashgar");
            tzShortIDMap.put("shshn", "Atlantic/St_Helena");
            tzShortIDMap.put("gtgua", "America/Guatemala");
            tzShortIDMap.put("nglos", "Africa/Lagos");
            tzShortIDMap.put("rukra", "Asia/Krasnoyarsk");
            tzShortIDMap.put("pfgmr", "Pacific/Gambier");
            tzShortIDMap.put("yeade", "Asia/Aden");
            tzShortIDMap.put("caybx", "America/Blanc-Sablon");
            tzShortIDMap.put("cahal", "America/Halifax Canada/Atlantic");
            tzShortIDMap.put("caycb", "America/Cambridge_Bay");
            tzShortIDMap.put("cfbgf", "Africa/Bangui");
            tzShortIDMap.put("thbkk", "Asia/Bangkok");
            tzShortIDMap.put("lccas", "America/St_Lucia");
            tzShortIDMap.put("usanc", "America/Anchorage US/Alaska");
            tzShortIDMap.put("rsbeg", "Europe/Belgrade");
            tzShortIDMap.put("aqdav", "Antarctica/Davis");
            tzShortIDMap.put("uslax", "America/Los_Angeles US/Pacific US/Pacific-New");
            tzShortIDMap.put("mxmzt", "America/Mazatlan Mexico/BajaSur");
            tzShortIDMap.put("tkfko", "Pacific/Fakaofo");
            tzShortIDMap.put("unk", "Etc/Unknown");
            tzShortIDMap.put("usboi", "America/Boise");
            tzShortIDMap.put("tcgdt", "America/Grand_Turk");
            tzShortIDMap.put("gygeo", "America/Guyana");
            tzShortIDMap.put("dzalg", "Africa/Algiers");
            tzShortIDMap.put("usmoc", "America/Kentucky/Monticello");
            tzShortIDMap.put("altia", "Europe/Tirane");
            tzShortIDMap.put("jesth", "Europe/Jersey");
            tzShortIDMap.put("nlams", "Europe/Amsterdam");
            tzShortIDMap.put("mmrgn", "Asia/Rangoon");
            tzShortIDMap.put("kygec", "America/Cayman");
            tzShortIDMap.put("djjib", "Africa/Djibouti");
            tzShortIDMap.put("bbbgi", "America/Barbados");
            tzShortIDMap.put("zmlun", "Africa/Lusaka");
            tzShortIDMap.put("esceu", "Africa/Ceuta");
            tzShortIDMap.put("mxchi", "America/Chihuahua");
            tzShortIDMap.put("nzcht", "Pacific/Chatham NZ-CHAT");
            tzShortIDMap.put("tvfun", "Pacific/Funafuti");
            tzShortIDMap.put("slfna", "Africa/Freetown");
            tzShortIDMap.put("usmnm", "America/Menominee");
            tzShortIDMap.put("inccu", "Asia/Calcutta Asia/Kolkata");
            tzShortIDMap.put("plwaw", "Europe/Warsaw Poland");
            tzShortIDMap.put("aqsyw", "Antarctica/Syowa");
            tzShortIDMap.put("arbue", "America/Buenos_Aires America/Argentina/Buenos_Aires");
            tzShortIDMap.put("mykul", "Asia/Kuala_Lumpur");
            tzShortIDMap.put("rusred", "Asia/Srednekolymsk");
            tzShortIDMap.put("mxtij", "America/Tijuana America/Ensenada Mexico/BajaNorte");
            tzShortIDMap.put("hrzag", "Europe/Zagreb");
            tzShortIDMap.put("itrom", "Europe/Rome");
            tzShortIDMap.put("papty", "America/Panama");
            tzShortIDMap.put("gqssg", "Africa/Malabo");
            tzShortIDMap.put("cuhav", "America/Havana Cuba");
            tzShortIDMap.put("mnuln", "Asia/Ulaanbaatar Asia/Ulan_Bator");
            tzShortIDMap.put("brpvh", "America/Porto_Velho");
            tzShortIDMap.put("gblon", "Europe/London Europe/Belfast GB GB-Eire");
            tzShortIDMap.put("gwoxb", "Africa/Bissau");
            tzShortIDMap.put("kipho", "Pacific/Enderbury");
            tzShortIDMap.put("ttpos", "America/Port_of_Spain");
            tzShortIDMap.put("ommct", "Asia/Muscat");
            tzShortIDMap.put("lrmlw", "Africa/Monrovia");
            tzShortIDMap.put("imdgs", "Europe/Isle_of_Man");
            tzShortIDMap.put("npktm", "Asia/Katmandu Asia/Kathmandu");
            tzShortIDMap.put("robuh", "Europe/Bucharest");
            tzShortIDMap.put("rukuf", "Europe/Samara");
            tzShortIDMap.put("muplu", "Indian/Mauritius");
            tzShortIDMap.put("aubne", "Australia/Brisbane Australia/Queensland");
            tzShortIDMap.put("mqfdf", "America/Martinique");
            tzShortIDMap.put("aueuc", "Australia/Eucla");
            tzShortIDMap.put("mlbko", "Africa/Bamako Africa/Timbuktu");
            tzShortIDMap.put("audrw", "Australia/Darwin Australia/North");
            tzShortIDMap.put("asppg", "Pacific/Pago_Pago Pacific/Samoa US/Samoa");
            tzShortIDMap.put("lkcmb", "Asia/Colombo");
            tzShortIDMap.put("lvrix", "Europe/Riga");
            tzShortIDMap.put("lbbey", "Asia/Beirut");
            tzShortIDMap.put("sdkrt", "Africa/Khartoum");
            tzShortIDMap.put("aganu", "America/Antigua");
            tzShortIDMap.put("frpar", "Europe/Paris");
            tzShortIDMap.put("cmdla", "Africa/Douala");
            tzShortIDMap.put("kwkwi", "Asia/Kuwait");
            tzShortIDMap.put("jptyo", "Asia/Tokyo Japan");
            tzShortIDMap.put("kitrw", "Pacific/Tarawa");
            tzShortIDMap.put("cayyn", "America/Swift_Current");
            tzShortIDMap.put("sttms", "Africa/Sao_Tome");
            tzShortIDMap.put("metgd", "Europe/Podgorica");
            tzShortIDMap.put("bddac", "Asia/Dhaka Asia/Dacca");
            tzShortIDMap.put("cator", "America/Toronto Canada/Eastern");
            tzShortIDMap.put("cgbzv", "Africa/Brazzaville");
            tzShortIDMap.put("tldil", "Asia/Dili");
            tzShortIDMap.put("jeruslm", "Asia/Jerusalem Asia/Tel_Aviv Israel");
            tzShortIDMap.put("gsgrv", "Atlantic/South_Georgia");
            tzShortIDMap.put("usyak", "America/Yakutat");
            tzShortIDMap.put("brbvb", "America/Boa_Vista");
            tzShortIDMap.put("utc", "Etc/GMT Etc/GMT+0 Etc/GMT-0 Etc/GMT0 Etc/Greenwich Etc/UCT Etc/UTC Etc/Universal Etc/Zulu GMT GMT+0 GMT-0 GMT0 Greenwich UCT UTC Universal Zulu");
            tzShortIDMap.put("cdfih", "Africa/Kinshasa");
            tzShortIDMap.put("veccs", "America/Caracas");
            tzShortIDMap.put("bmbda", "Atlantic/Bermuda");
            tzShortIDMap.put("dmdom", "America/Dominica");
            tzShortIDMap.put("mtmla", "Europe/Malta");
            tzShortIDMap.put("idjkt", "Asia/Jakarta");
            tzShortIDMap.put("gaza", "Asia/Gaza");
            tzShortIDMap.put("mwblz", "Africa/Blantyre");
            tzShortIDMap.put("msmni", "America/Montserrat");
            tzShortIDMap.put("pyasu", "America/Asuncion");
            tzShortIDMap.put("khpnh", "Asia/Phnom_Penh");
            tzShortIDMap.put("aubhq", "Australia/Broken_Hill Australia/Yancowinna");
            tzShortIDMap.put("artuc", "America/Argentina/Tucuman");
            tzShortIDMap.put("cayxy", "America/Whitehorse Canada/Yukon");
            tzShortIDMap.put("lytip", "Africa/Tripoli Libya");
            tzShortIDMap.put("basjj", "Europe/Sarajevo");
            tzShortIDMap.put("knbas", "America/St_Kitts");
            tzShortIDMap.put("smsai", "Europe/San_Marino");
            tzShortIDMap.put("cnsha", "Asia/Shanghai Asia/Chongqing Asia/Chungking Asia/Harbin PRC");
            tzShortIDMap.put("arctc", "America/Catamarca America/Argentina/Catamarca America/Argentina/ComodRivadavia");
            tzShortIDMap.put("lavte", "Asia/Vientiane");
            tzShortIDMap.put("fmpni", "Pacific/Ponape Pacific/Pohnpei");
            tzShortIDMap.put("tzdar", "Africa/Dar_es_Salaam");
            tzShortIDMap.put("ruvog", "Europe/Volgograd");
            tzShortIDMap.put("ghacc", "Africa/Accra");
            tzShortIDMap.put("deber", "Europe/Berlin");
            tzShortIDMap.put("bfoua", "Africa/Ouagadougou");
            tzShortIDMap.put("prsju", "America/Puerto_Rico");
            tzShortIDMap.put("auper", "Australia/Perth Australia/West");
            tzShortIDMap.put("cayzf", "America/Yellowknife");
            tzShortIDMap.put("mnhvd", "Asia/Hovd");
            tzShortIDMap.put("sydam", "Asia/Damascus");
            tzShortIDMap.put("ecgye", "America/Guayaquil");
            tzShortIDMap.put("eetll", "Europe/Tallinn");
            tzShortIDMap.put("braux", "America/Araguaina");
            tzShortIDMap.put("nrinu", "Pacific/Nauru");
            tzShortIDMap.put("ugkla", "Africa/Kampala");
            tzShortIDMap.put("zajnb", "Africa/Johannesburg");
            tzShortIDMap.put("cayzs", "America/Coral_Harbour America/Atikokan");
            tzShortIDMap.put("mxmam", "America/Matamoros");
            tzShortIDMap.put("totbu", "Pacific/Tongatapu");
            tzShortIDMap.put("htpap", "America/Port-au-Prince");
            tzShortIDMap.put("uslui", "America/Louisville America/Kentucky/Louisville");
            tzShortIDMap.put("dkcph", "Europe/Copenhagen");
            tzShortIDMap.put("usden", "America/Denver America/Shiprock Navajo US/Mountain");
            tzShortIDMap.put("cccck", "Indian/Cocos");
            tzShortIDMap.put("eheai", "Africa/El_Aaiun");
            tzShortIDMap.put("hkhkg", "Asia/Hong_Kong Hongkong");
            tzShortIDMap.put("usdet", "America/Detroit US/Michigan");
            tzShortIDMap.put("ptpdl", "Atlantic/Azores");
            tzShortIDMap.put("sndkr", "Africa/Dakar");
            tzShortIDMap.put("ustel", "America/Indiana/Tell_City");
            tzShortIDMap.put("pfnhv", "Pacific/Marquesas");
            tzShortIDMap.put("pelim", "America/Lima");
            tzShortIDMap.put("silju", "Europe/Ljubljana");
            tzShortIDMap.put("usind", "America/Indianapolis America/Fort_Wayne America/Indiana/Indianapolis US/East-Indiana");
            tzShortIDMap.put("bzbze", "America/Belize");
            tzShortIDMap.put("eslpa", "Atlantic/Canary");
            tzShortIDMap.put("brssa", "America/Bahia");
            tzShortIDMap.put("aedxb", "Asia/Dubai");
            tzShortIDMap.put("aqrot", "Antarctica/Rothera");
            tzShortIDMap.put("vavat", "Europe/Vatican");
            tzShortIDMap.put("arush", "America/Argentina/Ushuaia");
            tzShortIDMap.put("afkbl", "Asia/Kabul");
            tzShortIDMap.put("arcor", "America/Cordoba America/Argentina/Cordoba America/Rosario");
            tzShortIDMap.put("vcsvd", "America/St_Vincent");
            tzShortIDMap.put("usnyc", "America/New_York US/Eastern");
            tzShortIDMap.put("fkpsy", "Atlantic/Stanley");
            tzShortIDMap.put("usndnsl", "America/North_Dakota/New_Salem");
            tzShortIDMap.put("uswlz", "America/Indiana/Winamac");
            tzShortIDMap.put("gigib", "Europe/Gibraltar");
            tzShortIDMap.put("brstm", "America/Santarem");
            tzShortIDMap.put("bymsq", "Europe/Minsk");
            tzShortIDMap.put("aqplm", "Antarctica/Palmer");
            tzShortIDMap.put("uaiev", "Europe/Kiev");
            tzShortIDMap.put("kmyva", "Indian/Comoro");
            tzShortIDMap.put("egcai", "Africa/Cairo Egypt");
            tzShortIDMap.put("mxoji", "America/Ojinaga");
            tzShortIDMap.put("dosdq", "America/Santo_Domingo");
            tzShortIDMap.put("sxphi", "America/Lower_Princes");
            tzShortIDMap.put("kicxi", "Pacific/Kiritimati");
            tzShortIDMap.put("bolpb", "America/La_Paz");
            tzShortIDMap.put("mvmle", "Indian/Maldives");
            tzShortIDMap.put("mxmex", "America/Mexico_City Mexico/General");
            tzShortIDMap.put("ushnl", "Pacific/Honolulu US/Hawaii");
            tzShortIDMap.put("casjf", "America/St_Johns Canada/Newfoundland");
            tzShortIDMap.put("nzakl", "Pacific/Auckland Antarctica/South_Pole NZ");
            tzShortIDMap.put("mst7mdt", "MST7MDT");
            tzShortIDMap.put("mncoq", "Asia/Choibalsan");
            tzShortIDMap.put("ptfnc", "Atlantic/Madeira");
            tzShortIDMap.put("auadl", "Australia/Adelaide Australia/South");
            tzShortIDMap.put("armdz", "America/Mendoza America/Argentina/Mendoza");
            tzShortIDMap.put("pmmqc", "America/Miquelon");
            tzShortIDMap.put("ruchita", "Asia/Chita");
            tzShortIDMap.put("ytmam", "Indian/Mayotte");
            tzShortIDMap.put("mxmid", "America/Merida");
            tzShortIDMap.put("caiql", "America/Iqaluit");
            tzShortIDMap.put("mxcun", "America/Cancun");
            tzShortIDMap.put("ummdy", "Pacific/Midway");
            tzShortIDMap.put("arrgl", "America/Argentina/Rio_Gallegos");
            tzShortIDMap.put("utcw10", "Etc/GMT+10 HST");
            tzShortIDMap.put("brern", "America/Eirunepe");
            tzShortIDMap.put("utcw11", "Etc/GMT+11");
            tzShortIDMap.put("utcw12", "Etc/GMT+12");
            tzShortIDMap.put("wfmau", "Pacific/Wallis");
            tzShortIDMap.put("lsmsu", "Africa/Maseru");
            tzShortIDMap.put("brmao", "America/Manaus Brazil/West");
            tzShortIDMap.put("cdfbm", "Africa/Lubumbashi");
            tzShortIDMap.put("nawdh", "Africa/Windhoek");
            tzShortIDMap.put("bebru", "Europe/Brussels");
            tzShortIDMap.put("kzaau", "Asia/Aqtau");
            tzShortIDMap.put("twtpe", "Asia/Taipei ROC");
            tzShortIDMap.put("utcw05", "Etc/GMT+5 EST");
            tzShortIDMap.put("utcw06", "Etc/GMT+6");
            tzShortIDMap.put("fihel", "Europe/Helsinki");
            tzShortIDMap.put("iedub", "Europe/Dublin Eire");
            tzShortIDMap.put("utcw07", "Etc/GMT+7 MST");
            tzShortIDMap.put("utcw08", "Etc/GMT+8");
            tzShortIDMap.put("utcw09", "Etc/GMT+9");
            tzShortIDMap.put("utcw01", "Etc/GMT+1");
            tzShortIDMap.put("pgpom", "Pacific/Port_Moresby");
            tzShortIDMap.put("utcw02", "Etc/GMT+2");
            tzShortIDMap.put("utcw03", "Etc/GMT+3");
            tzShortIDMap.put("utcw04", "Etc/GMT+4");
            tzShortIDMap.put("bgsof", "Europe/Sofia");
            tzShortIDMap.put("usknx", "America/Indiana/Knox America/Knox_IN US/Indiana-Starke");
            tzShortIDMap.put("bsnas", "America/Nassau");
            tzShortIDMap.put("clipc", "Pacific/Easter Chile/EasterIsland");
            tzShortIDMap.put("clscl", "America/Santiago Chile/Continental");
            tzShortIDMap.put("aqmaw", "Antarctica/Mawson");
            tzShortIDMap.put("isrey", "Atlantic/Reykjavik Iceland");
            tzShortIDMap.put("cathu", "America/Thunder_Bay");
            tzShortIDMap.put("fotho", "Atlantic/Faeroe Atlantic/Faroe");
            tzShortIDMap.put("ncnou", "Pacific/Noumea");
            tzShortIDMap.put("idpnk", "Asia/Pontianak");
            tzShortIDMap.put("nenim", "Africa/Niamey");
            tzShortIDMap.put("cagoo", "America/Goose_Bay");
            tzShortIDMap.put("uauzh", "Europe/Uzhgorod");
            tzShortIDMap.put("mhkwa", "Pacific/Kwajalein Kwajalein");
            tzShortIDMap.put("livdz", "Europe/Vaduz");
            tzShortIDMap.put("ruuus", "Asia/Sakhalin");
            tzShortIDMap.put("brmcz", "America/Maceio");
            tzShortIDMap.put("zwhre", "Africa/Harare");
            tzShortIDMap.put("careb", "America/Resolute");
            tzShortIDMap.put("rukhndg", "Asia/Khandyga");
            tzShortIDMap.put("careg", "America/Regina Canada/East-Saskatchewan Canada/Saskatchewan");
            tzShortIDMap.put("rupkc", "Asia/Kamchatka");
            tzShortIDMap.put("arsla", "America/Argentina/Salta");
            tzShortIDMap.put("mykch", "Asia/Kuching");
            tzShortIDMap.put("tjdyu", "Asia/Dushanbe");
            tzShortIDMap.put("cafne", "America/Fort_Nelson");
            tzShortIDMap.put("fjsuv", "Pacific/Fiji");
            tzShortIDMap.put("pfppt", "Pacific/Tahiti");
            tzShortIDMap.put("bibjm", "Africa/Bujumbura");
            tzShortIDMap.put("aqmcm", "Antarctica/McMurdo");
            tzShortIDMap.put("usmtm", "America/Metlakatla");
            tzShortIDMap.put("uzskd", "Asia/Samarkand");
            tzShortIDMap.put("cacfq", "America/Creston");
            tzShortIDMap.put("ecgps", "Pacific/Galapagos");
            tzShortIDMap.put("ruvvo", "Asia/Vladivostok");
            tzShortIDMap.put("aqtrl", "Antarctica/Troll");
            tzShortIDMap.put("usjnu", "America/Juneau");
            tzShortIDMap.put("cawnp", "America/Winnipeg Canada/Central");
            tzShortIDMap.put("kpfnj", "Asia/Pyongyang");
            tzShortIDMap.put("kzkzo", "Asia/Qyzylorda");
            tzShortIDMap.put("wsapw", "Pacific/Apia");
            tzShortIDMap.put("uswsq", "America/Indiana/Petersburg");
            tzShortIDMap.put("gncky", "Africa/Conakry");
            tzShortIDMap.put("usxul", "America/North_Dakota/Beulah");
            tzShortIDMap.put("rukgd", "Europe/Kaliningrad");
            tzShortIDMap.put("tfpfr", "Indian/Kerguelen");
            tzShortIDMap.put("utce10", "Etc/GMT-10");
            tzShortIDMap.put("utce11", "Etc/GMT-11");
            tzShortIDMap.put("mpspn", "Pacific/Saipan");
            tzShortIDMap.put("utce12", "Etc/GMT-12");
            tzShortIDMap.put("utce13", "Etc/GMT-13");
            tzShortIDMap.put("arirj", "America/Argentina/La_Rioja");
            tzShortIDMap.put("aumqi", "Antarctica/Macquarie");
            tzShortIDMap.put("utce14", "Etc/GMT-14");
            tzShortIDMap.put("ckrar", "Pacific/Rarotonga");
            tzShortIDMap.put("arjuj", "America/Jujuy America/Argentina/Jujuy");
            tzShortIDMap.put("aqvos", "Antarctica/Vostok");
            tzShortIDMap.put("momfm", "Asia/Macau Asia/Macao");
            tzShortIDMap.put("ussit", "America/Sitka");
            tzShortIDMap.put("rudyr", "Asia/Anadyr");
            tzShortIDMap.put("aolad", "Africa/Luanda");
            tzShortIDMap.put("adalv", "Europe/Andorra");
            tzShortIDMap.put("caedm", "America/Edmonton Canada/Mountain");
            tzShortIDMap.put("utce07", "Etc/GMT-7");
            tzShortIDMap.put("aukns", "Australia/Currie");
            tzShortIDMap.put("utce08", "Etc/GMT-8");
            tzShortIDMap.put("utce09", "Etc/GMT-9");
            tzShortIDMap.put("caffs", "America/Rainy_River");
            tzShortIDMap.put("awaua", "America/Aruba");
            tzShortIDMap.put("utce01", "Etc/GMT-1");
            tzShortIDMap.put("utce02", "Etc/GMT-2");
            tzShortIDMap.put("utce03", "Etc/GMT-3");
            tzShortIDMap.put("utce04", "Etc/GMT-4");
            tzShortIDMap.put("utce05", "Etc/GMT-5");
            tzShortIDMap.put("utce06", "Etc/GMT-6");
            tzShortIDMap.put("gfcay", "America/Cayenne");
            tzShortIDMap.put("irthr", "Asia/Tehran Iran");
            tzShortIDMap.put("qadoh", "Asia/Qatar");
            tzShortIDMap.put("usoea", "America/Indiana/Vincennes");
            tzShortIDMap.put("ruoms", "Asia/Omsk");
            tzShortIDMap.put("uaozh", "Europe/Zaporozhye");
            tzShortIDMap.put("iqbgw", "Asia/Baghdad");
            tzShortIDMap.put("fimhq", "Europe/Mariehamn");
            tzShortIDMap.put("caglb", "America/Glace_Bay");
            tzShortIDMap.put("czprg", "Europe/Prague");
            tzShortIDMap.put("ruunera", "Asia/Ust-Nera");
            tzShortIDMap.put("erasm", "Africa/Asmera Africa/Asmara");
            tzShortIDMap.put("pst8pdt", "PST8PDT");
            tzShortIDMap.put("cvrai", "Atlantic/Cape_Verde");
            tzShortIDMap.put("mgtnr", "Indian/Antananarivo");
            tzShortIDMap.put("atvie", "Europe/Vienna");
            tzShortIDMap.put("bnbwn", "Asia/Brunei");
            tzShortIDMap.put("gpbbr", "America/Guadeloupe");
            tzShortIDMap.put("srpbm", "America/Paramaribo");
            tzShortIDMap.put("btthi", "Asia/Thimphu Asia/Thimbu");
            tzShortIDMap.put("ancur", "America/Curacao");
            tzShortIDMap.put("fmtkk", "Pacific/Truk Pacific/Chuuk Pacific/Yap");
            tzShortIDMap.put("galbv", "Africa/Libreville");
            tzShortIDMap.put("crsjo", "America/Costa_Rica");
            tzShortIDMap.put("cst6cdt", "CST6CDT");
            tzShortIDMap.put("ausyd", "Australia/Sydney Australia/ACT Australia/Canberra Australia/NSW");
            tzShortIDMap.put("kzura", "Asia/Oral");
            tzShortIDMap.put("krsel", "Asia/Seoul ROK");
            tzShortIDMap.put("nfnlk", "Pacific/Norfolk");
            tzShortIDMap.put("rumow", "Europe/Moscow W-SU");
            tzShortIDMap.put("skbts", "Europe/Bratislava");
            tzShortIDMap.put("gpsbh", "America/St_Barthelemy");
            tzShortIDMap.put("scmaw", "Indian/Mahe");
            tzShortIDMap.put("tdndj", "Africa/Ndjamena");
            tzShortIDMap.put("bhbah", "Asia/Bahrain");
            tzShortIDMap.put("mcmon", "Europe/Monaco");
            tzShortIDMap.put("hebron", "Asia/Hebron");
            tzShortIDMap.put("mxpvr", "America/Bahia_Banderas");
            tzShortIDMap.put("gmbjl", "Africa/Banjul");
            tzShortIDMap.put("brbel", "America/Belem");
            tzShortIDMap.put("kzakx", "Asia/Aqtobe");
            tzShortIDMap.put("brcgr", "America/Campo_Grande");
            tzShortIDMap.put("cavan", "America/Vancouver Canada/Pacific");
            tzShortIDMap.put("vgtov", "America/Tortola");
            tzShortIDMap.put("usndcnt", "America/North_Dakota/Center");
            tzShortIDMap.put("mxstis", "America/Santa_Isabel");
            tzShortIDMap.put("phmnl", "Asia/Manila");
            tzShortIDMap.put("idmak", "Asia/Makassar Asia/Ujung_Pandang");
            tzShortIDMap.put("kenbo", "Africa/Nairobi");
            tzShortIDMap.put("brcgb", "America/Cuiaba");
            tzShortIDMap.put("hubud", "Europe/Budapest");
            tzShortIDMap.put("amevn", "Asia/Yerevan");
            tzShortIDMap.put("gdgnd", "America/Grenada");
            tzShortIDMap.put("arluq", "America/Argentina/San_Luis");
            tzShortIDMap.put("ruyek", "Asia/Yekaterinburg");
            tzShortIDMap.put("tmasb", "Asia/Ashgabat Asia/Ashkhabad");
            tzShortIDMap.put("usaeg", "America/Indiana/Marengo");
            tzShortIDMap.put("tntun", "Africa/Tunis");
            tzShortIDMap.put("runoz", "Asia/Novokuznetsk");
            tzShortIDMap.put("lulux", "Europe/Luxembourg");
            tzShortIDMap.put("mdkiv", "Europe/Chisinau Europe/Tiraspol");
            tzShortIDMap.put("trist", "Europe/Istanbul Asia/Istanbul Turkey");
            tzShortIDMap.put("nuiue", "Pacific/Niue");
            tzShortIDMap.put("brrec", "America/Recife");
            tzShortIDMap.put("kzala", "Asia/Almaty");
            tzShortIDMap.put("globy", "America/Scoresbysund");
            tzShortIDMap.put("debsngn", "Europe/Busingen");
            tzShortIDMap.put("uschi", "America/Chicago US/Central");
            tzShortIDMap.put("vuvli", "Pacific/Efate");
            tzShortIDMap.put("brfor", "America/Fortaleza");
            tzShortIDMap.put("cxxch", "Indian/Christmas");
            tzShortIDMap.put("noosl", "Europe/Oslo");
            tzShortIDMap.put("ciabj", "Africa/Abidjan");
            tzShortIDMap.put("bwgbe", "Africa/Gaborone");
            tzShortIDMap.put("mhmaj", "Pacific/Majuro");
            tzShortIDMap.put("macas", "Africa/Casablanca");
            tzShortIDMap.put("usadk", "America/Adak America/Atka US/Aleutian");
            tzShortIDMap.put("saruh", "Asia/Riyadh");
            tzShortIDMap.put("usinvev", "America/Indiana/Vevay");
            tzShortIDMap.put("gggci", "Europe/Guernsey");
            tzShortIDMap.put("rereu", "Indian/Reunion");
            tzShortIDMap.put("getbs", "Asia/Tbilisi");
            tzShortIDMap.put("umawk", "Pacific/Wake");
        }
    }

    @Override
    public LocaleProviderAdapter.Type getType() {
        return LocaleProviderAdapter.Type.CLDR;
    }

    @Override
    public String availableLanguageTags(String category) {
        return resourceNameToLocales.getOrDefault(category, "");
    }

    @Override
    public Map<String, String> tzShortIDs() {
        return TZShortIDMapHolder.tzShortIDMap;
    }

    public Map<Locale, String[]> parentLocales() {
        return parentLocalesMap;
    }
}