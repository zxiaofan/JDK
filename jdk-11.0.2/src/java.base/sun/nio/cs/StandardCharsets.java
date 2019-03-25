/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
 *
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

// -- This file was mechanically generated: Do not edit! -- //

package sun.nio.cs;

import java.nio.charset.Charset;
import java.nio.charset.spi.CharsetProvider;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import jdk.internal.vm.annotation.Stable;
import sun.security.action.GetPropertyAction;

public class StandardCharsets extends CharsetProvider {

    static String[] aliases_US_ASCII() { return new String[] {
            "iso-ir-6",
            "ANSI_X3.4-1986",
            "ISO_646.irv:1991",
            "ASCII",
            "ISO646-US",
            "us",
            "IBM367",
            "cp367",
            "csASCII",
            "default",
            "646",
            "iso_646.irv:1983",
            "ANSI_X3.4-1968",
            "ascii7",
        };

    }

    static String[] aliases_UTF_8() { return new String[] {
            "UTF8",
            "unicode-1-1-utf-8",
        };

    }

    static String[] aliases_CESU_8() { return new String[] {
            "CESU8",
            "csCESU-8",
        };

    }

    static String[] aliases_UTF_16() { return new String[] {
            "UTF_16",
            "utf16",
            "unicode",
            "UnicodeBig",
        };

    }

    static String[] aliases_UTF_16BE() { return new String[] {
            "UTF_16BE",
            "ISO-10646-UCS-2",
            "X-UTF-16BE",
            "UnicodeBigUnmarked",
        };

    }

    static String[] aliases_UTF_16LE() { return new String[] {
            "UTF_16LE",
            "X-UTF-16LE",
            "UnicodeLittleUnmarked",
        };

    }

    static String[] aliases_UTF_16LE_BOM() { return new String[] {
            "UnicodeLittle",
        };

    }

    static String[] aliases_UTF_32() { return new String[] {
            "UTF_32",
            "UTF32",
        };

    }

    static String[] aliases_UTF_32LE() { return new String[] {
            "UTF_32LE",
            "X-UTF-32LE",
        };

    }

    static String[] aliases_UTF_32BE() { return new String[] {
            "UTF_32BE",
            "X-UTF-32BE",
        };

    }

    static String[] aliases_UTF_32LE_BOM() { return new String[] {
            "UTF_32LE_BOM",
            "UTF-32LE-BOM",
        };

    }

    static String[] aliases_UTF_32BE_BOM() { return new String[] {
            "UTF_32BE_BOM",
            "UTF-32BE-BOM",
        };

    }

    static String[] aliases_ISO_8859_1() { return new String[] {
            "iso-ir-100",
            "ISO_8859-1",
            "latin1",
            "l1",
            "IBM819",
            "cp819",
            "csISOLatin1",
            "819",
            "IBM-819",
            "ISO8859_1",
            "ISO_8859-1:1987",
            "ISO_8859_1",
            "8859_1",
            "ISO8859-1",
        };

    }

    static String[] aliases_ISO_8859_2() { return new String[] {
            "iso8859_2",
            "8859_2",
            "iso-ir-101",
            "ISO_8859-2",
            "ISO_8859-2:1987",
            "ISO8859-2",
            "latin2",
            "l2",
            "ibm912",
            "ibm-912",
            "cp912",
            "912",
            "csISOLatin2",
        };

    }

    static String[] aliases_ISO_8859_4() { return new String[] {
            "iso8859_4",
            "iso8859-4",
            "8859_4",
            "iso-ir-110",
            "ISO_8859-4",
            "ISO_8859-4:1988",
            "latin4",
            "l4",
            "ibm914",
            "ibm-914",
            "cp914",
            "914",
            "csISOLatin4",
        };

    }

    static String[] aliases_ISO_8859_5() { return new String[] {
            "iso8859_5",
            "8859_5",
            "iso-ir-144",
            "ISO_8859-5",
            "ISO_8859-5:1988",
            "ISO8859-5",
            "cyrillic",
            "ibm915",
            "ibm-915",
            "cp915",
            "915",
            "csISOLatinCyrillic",
        };

    }

    static String[] aliases_ISO_8859_7() { return new String[] {
            "iso8859_7",
            "8859_7",
            "iso-ir-126",
            "ISO_8859-7",
            "ISO_8859-7:1987",
            "ELOT_928",
            "ECMA-118",
            "greek",
            "greek8",
            "csISOLatinGreek",
            "sun_eu_greek",
            "ibm813",
            "ibm-813",
            "813",
            "cp813",
            "iso8859-7",
        };

    }

    static String[] aliases_ISO_8859_9() { return new String[] {
            "iso8859_9",
            "8859_9",
            "iso-ir-148",
            "ISO_8859-9",
            "ISO_8859-9:1989",
            "ISO8859-9",
            "latin5",
            "l5",
            "ibm920",
            "ibm-920",
            "920",
            "cp920",
            "csISOLatin5",
        };

    }

    static String[] aliases_ISO_8859_13() { return new String[] {
            "iso8859_13",
            "8859_13",
            "iso_8859-13",
            "ISO8859-13",
        };

    }

    static String[] aliases_ISO_8859_15() { return new String[] {
            "ISO_8859-15",
            "Latin-9",
            "csISO885915",
            "8859_15",
            "ISO-8859-15",
            "ISO8859_15",
            "ISO8859-15",
            "IBM923",
            "IBM-923",
            "cp923",
            "923",
            "LATIN0",
            "LATIN9",
            "L9",
            "csISOlatin0",
            "csISOlatin9",
            "ISO8859_15_FDIS",
        };

    }

    static String[] aliases_ISO_8859_16() { return new String[] {
            "iso-ir-226",
            "ISO_8859-16:2001",
            "ISO_8859-16",
            "latin10",
            "l10",
            "csISO885916",
        };

    }

    static String[] aliases_KOI8_R() { return new String[] {
            "koi8_r",
            "koi8",
            "cskoi8r",
        };

    }

    static String[] aliases_KOI8_U() { return new String[] {
            "koi8_u",
        };

    }

    static String[] aliases_MS1250() { return new String[] {
            "cp1250",
            "cp5346",
        };

    }

    static String[] aliases_MS1251() { return new String[] {
            "cp1251",
            "cp5347",
            "ansi-1251",
        };

    }

    static String[] aliases_MS1252() { return new String[] {
            "cp1252",
            "cp5348",
            "ibm-1252",
            "ibm1252",
        };

    }

    static String[] aliases_MS1253() { return new String[] {
            "cp1253",
            "cp5349",
        };

    }

    static String[] aliases_MS1254() { return new String[] {
            "cp1254",
            "cp5350",
        };

    }

    static String[] aliases_MS1257() { return new String[] {
            "cp1257",
            "cp5353",
        };

    }

    static String[] aliases_IBM437() { return new String[] {
            "cp437",
            "ibm437",
            "ibm-437",
            "437",
            "cspc8codepage437",
            "windows-437",
        };

    }

    static String[] aliases_IBM737() { return new String[] {
            "cp737",
            "ibm737",
            "ibm-737",
            "737",
        };

    }

    static String[] aliases_IBM775() { return new String[] {
            "cp775",
            "ibm775",
            "ibm-775",
            "775",
        };

    }

    static String[] aliases_IBM850() { return new String[] {
            "cp850",
            "ibm-850",
            "ibm850",
            "850",
            "cspc850multilingual",
        };

    }

    static String[] aliases_IBM852() { return new String[] {
            "cp852",
            "ibm852",
            "ibm-852",
            "852",
            "csPCp852",
        };

    }

    static String[] aliases_IBM855() { return new String[] {
            "cp855",
            "ibm-855",
            "ibm855",
            "855",
            "cspcp855",
        };

    }

    static String[] aliases_IBM857() { return new String[] {
            "cp857",
            "ibm857",
            "ibm-857",
            "857",
            "csIBM857",
        };

    }

    static String[] aliases_IBM858() { return new String[] {
            "cp858",
            "ccsid00858",
            "cp00858",
            "858",
            "PC-Multilingual-850+euro",
        };

    }

    static String[] aliases_IBM862() { return new String[] {
            "cp862",
            "ibm862",
            "ibm-862",
            "862",
            "csIBM862",
            "cspc862latinhebrew",
        };

    }

    static String[] aliases_IBM866() { return new String[] {
            "cp866",
            "ibm866",
            "ibm-866",
            "866",
            "csIBM866",
        };

    }

    static String[] aliases_IBM874() { return new String[] {
            "cp874",
            "ibm874",
            "ibm-874",
            "874",
        };

    }

    static String[] aliases_Big5() { return new String[] {
            "csBig5",
        };

    }

    static String[] aliases_EUC_TW() { return new String[] {
            "euc_tw",
            "euctw",
            "cns11643",
            "EUC-TW",
        };

    }

    static String[] aliases_Big5_HKSCS() { return new String[] {
            "Big5_HKSCS",
            "big5hk",
            "big5-hkscs",
            "big5hkscs",
        };

    }

    static String[] aliases_Big5_Solaris() { return new String[] {
            "Big5_Solaris",
        };

    }

    static String[] aliases_GBK() { return new String[] {
            "windows-936",
            "CP936",
        };

    }

    static String[] aliases_GB18030() { return new String[] {
            "gb18030-2000",
        };

    }

    static String[] aliases_EUC_CN() { return new String[] {
            "gb2312",
            "gb2312-80",
            "gb2312-1980",
            "euc-cn",
            "euccn",
            "x-EUC-CN",
            "EUC_CN",
        };

    }

    static String[] aliases_SJIS() { return aliases_SJIS; }

    static String[] aliases_SJIS = new String[] {
            "sjis",
            "shift_jis",
            "shift-jis",
            "ms_kanji",
            "x-sjis",
            "csShiftJIS",
        };

    static String[] aliases_MS932() { return aliases_MS932; }

    static String[] aliases_MS932 = new String[] {
            "MS932",
            "windows-932",
            "csWindows31J",
        };

    static String[] aliases_JIS_X_0201() { return new String[] {
            "JIS0201",
            "JIS_X0201",
            "X0201",
            "csHalfWidthKatakana",
        };

    }

    static String[] aliases_JIS_X_0208() { return new String[] {
            "JIS0208",
            "JIS_C6226-1983",
            "iso-ir-87",
            "x0208",
            "JIS_X0208-1983",
            "csISO87JISX0208",
        };

    }

    static String[] aliases_JIS_X_0212() { return new String[] {
            "JIS0212",
            "jis_x0212-1990",
            "x0212",
            "iso-ir-159",
            "csISO159JISX02121990",
        };

    }

    static String[] aliases_EUC_JP() { return new String[] {
            "euc_jp",
            "eucjis",
            "eucjp",
            "Extended_UNIX_Code_Packed_Format_for_Japanese",
            "csEUCPkdFmtjapanese",
            "x-euc-jp",
            "x-eucjp",
        };

    }

    static String[] aliases_EUC_JP_LINUX() { return new String[] {
            "euc_jp_linux",
            "euc-jp-linux",
        };

    }

    static String[] aliases_EUC_JP_Open() { return new String[] {
            "EUC_JP_Solaris",
            "eucJP-open",
        };

    }

    static String[] aliases_PCK() { return new String[] {
            "pck",
        };

    }

    static String[] aliases_EUC_KR() { return new String[] {
            "euc_kr",
            "ksc5601",
            "euckr",
            "ks_c_5601-1987",
            "ksc5601-1987",
            "ksc5601_1987",
            "ksc_5601",
            "csEUCKR",
            "5601",
        };

    }

    static String[] aliases_Johab() { return new String[] {
            "ksc5601-1992",
            "ksc5601_1992",
            "ms1361",
            "johab",
        };

    }

    static String[] aliases_ISO_8859_3() { return new String[] {
            "iso8859_3",
            "8859_3",
            "ISO_8859-3:1988",
            "iso-ir-109",
            "ISO_8859-3",
            "ISO8859-3",
            "latin3",
            "l3",
            "ibm913",
            "ibm-913",
            "cp913",
            "913",
            "csISOLatin3",
        };

    }

    static String[] aliases_ISO_8859_6() { return new String[] {
            "iso8859_6",
            "8859_6",
            "iso-ir-127",
            "ISO_8859-6",
            "ISO_8859-6:1987",
            "ISO8859-6",
            "ECMA-114",
            "ASMO-708",
            "arabic",
            "ibm1089",
            "ibm-1089",
            "cp1089",
            "1089",
            "csISOLatinArabic",
        };

    }

    static String[] aliases_ISO_8859_8() { return new String[] {
            "iso8859_8",
            "8859_8",
            "iso-ir-138",
            "ISO_8859-8",
            "ISO_8859-8:1988",
            "ISO8859-8",
            "cp916",
            "916",
            "ibm916",
            "ibm-916",
            "hebrew",
            "csISOLatinHebrew",
        };

    }

    static String[] aliases_ISO_8859_11() { return new String[] {
            "iso-8859-11",
            "iso8859_11",
        };

    }

    static String[] aliases_TIS_620() { return new String[] {
            "tis620",
            "tis620.2533",
        };

    }

    static String[] aliases_JIS_X_0208_Solaris() { return null; }

    static String[] aliases_JIS_X_0212_Solaris() { return null; }

    private static final class Aliases
        extends sun.util.PreHashedMap<String>
    {

        private static final int ROWS = 1024;
        private static final int SIZE = 333;
        private static final int SHIFT = 0;
        private static final int MASK = 0x3ff;

        private Aliases() {
            super(ROWS, SIZE, SHIFT, MASK);
        }

        protected void init(Object[] ht) {
            ht[1] = new Object[] { "csisolatin0", "iso-8859-15" };
            ht[2] = new Object[] { "x0208", "x-jis0208",
                         new Object[] { "csisolatin1", "iso-8859-1" } };
            ht[3] = new Object[] { "csisolatin2", "iso-8859-2" };
            ht[4] = new Object[] { "csisolatin3", "iso-8859-3" };
            ht[5] = new Object[] { "csisolatin4", "iso-8859-4" };
            ht[6] = new Object[] { "csisolatin5", "iso-8859-9" };
            ht[10] = new Object[] { "csisolatin9", "iso-8859-15" };
            ht[19] = new Object[] { "unicodelittle", "x-utf-16le-bom" };
            ht[23] = new Object[] { "ksc5601-1987", "euc-kr" };
            ht[24] = new Object[] { "iso646-us", "us-ascii" };
            ht[25] = new Object[] { "jis_x0208-1983", "x-jis0208",
                         new Object[] { "iso_8859-7:1987", "iso-8859-7" } };
            ht[26] = new Object[] { "912", "iso-8859-2" };
            ht[27] = new Object[] { "913", "iso-8859-3",
                         new Object[] { "x0212", "jis_x0212-1990" } };
            ht[28] = new Object[] { "914", "iso-8859-4" };
            ht[29] = new Object[] { "915", "iso-8859-5" };
            ht[30] = new Object[] { "916", "iso-8859-8" };
            ht[35] = new Object[] { "latin10", "iso-8859-16" };
            ht[49] = new Object[] { "ksc5601-1992", "x-johab" };
            ht[55] = new Object[] { "ibm-1252", "windows-1252",
                         new Object[] { "920", "iso-8859-9" } };
            ht[58] = new Object[] { "923", "iso-8859-15" };
            ht[86] = new Object[] { "csisolatincyrillic", "iso-8859-5",
                         new Object[] { "8859_1", "iso-8859-1" } };
            ht[87] = new Object[] { "8859_2", "iso-8859-2" };
            ht[88] = new Object[] { "8859_3", "iso-8859-3" };
            ht[89] = new Object[] { "8859_4", "iso-8859-4" };
            ht[90] = new Object[] { "813", "iso-8859-7",
                         new Object[] { "8859_5", "iso-8859-5" } };
            ht[91] = new Object[] { "8859_6", "iso-8859-6" };
            ht[92] = new Object[] { "8859_7", "iso-8859-7" };
            ht[93] = new Object[] { "8859_8", "iso-8859-8" };
            ht[94] = new Object[] { "8859_9", "iso-8859-9" };
            ht[95] = new Object[] { "iso_8859-1:1987", "iso-8859-1" };
            ht[96] = new Object[] { "819", "iso-8859-1" };
            ht[98] = new Object[] { "5601", "euc-kr" };
            ht[106] = new Object[] { "unicode-1-1-utf-8", "utf-8" };
            ht[121] = new Object[] { "ecma-114", "iso-8859-6",
                         new Object[] { "x-utf-16le", "utf-16le" } };
            ht[125] = new Object[] { "ecma-118", "iso-8859-7" };
            ht[127] = new Object[] { "ks_c_5601-1987", "euc-kr" };
            ht[129] = new Object[] { "eucjis", "euc-jp" };
            ht[134] = new Object[] { "asmo-708", "iso-8859-6",
                         new Object[] { "koi8_r", "koi8-r" } };
            ht[135] = new Object[] { "euc-jp-linux", "x-euc-jp-linux" };
            ht[137] = new Object[] { "koi8_u", "koi8-u" };
            ht[141] = new Object[] { "cp912", "iso-8859-2" };
            ht[142] = new Object[] { "cp913", "iso-8859-3" };
            ht[143] = new Object[] { "euc_tw", "x-euc-tw",
                         new Object[] { "cp914", "iso-8859-4" } };
            ht[144] = new Object[] { "cp915", "iso-8859-5" };
            ht[145] = new Object[] { "cp916", "iso-8859-8" };
            ht[151] = new Object[] { "jis0201", "jis_x0201" };
            ht[158] = new Object[] { "jis0208", "x-jis0208" };
            ht[164] = new Object[] { "x-eucjp", "euc-jp" };
            ht[170] = new Object[] { "cp920", "iso-8859-9" };
            ht[172] = new Object[] { "arabic", "iso-8859-6" };
            ht[173] = new Object[] { "cp923", "iso-8859-15" };
            ht[177] = new Object[] { "utf_32le_bom", "x-utf-32le-bom" };
            ht[183] = new Object[] { "jis0212", "jis_x0212-1990" };
            ht[185] = new Object[] { "iso_8859-8:1988", "iso-8859-8" };
            ht[192] = new Object[] { "utf_16be", "utf-16be" };
            ht[199] = new Object[] { "cspc8codepage437", "ibm437",
                         new Object[] { "ansi-1251", "windows-1251" } };
            ht[205] = new Object[] { "cp813", "iso-8859-7" };
            ht[207] = new Object[] { "cp936", "gbk" };
            ht[211] = new Object[] { "850", "ibm850",
                         new Object[] { "cp819", "iso-8859-1" } };
            ht[213] = new Object[] { "852", "ibm852" };
            ht[216] = new Object[] { "pck", "x-pck",
                         new Object[] { "855", "ibm855" } };
            ht[217] = new Object[] { "cswindows31j", "windows-31j" };
            ht[218] = new Object[] { "857", "ibm857",
                         new Object[] { "iso-ir-6", "us-ascii" } };
            ht[219] = new Object[] { "858", "ibm00858",
                         new Object[] { "737", "x-ibm737" } };
            ht[221] = new Object[] { "euc-tw", "x-euc-tw" };
            ht[225] = new Object[] { "csascii", "us-ascii" };
            ht[242] = new Object[] { "ms932", "windows-31j",
                         new Object[] { "ibm1252", "windows-1252" } };
            ht[244] = new Object[] { "862", "ibm862" };
            ht[248] = new Object[] { "866", "ibm866" };
            ht[253] = new Object[] { "x-utf-32be", "utf-32be" };
            ht[254] = new Object[] { "iso_8859-2:1987", "iso-8859-2" };
            ht[259] = new Object[] { "unicodebig", "utf-16" };
            ht[269] = new Object[] { "iso8859_15_fdis", "iso-8859-15" };
            ht[277] = new Object[] { "874", "x-ibm874" };
            ht[280] = new Object[] { "unicodelittleunmarked", "utf-16le" };
            ht[281] = new Object[] { "ibm-1089", "iso-8859-6" };
            ht[283] = new Object[] { "iso8859_1", "iso-8859-1" };
            ht[284] = new Object[] { "iso8859_2", "iso-8859-2" };
            ht[285] = new Object[] { "iso8859_3", "iso-8859-3",
                         new Object[] { "csiso885915", "iso-8859-15" } };
            ht[286] = new Object[] { "csiso885916", "iso-8859-16",
                         new Object[] { "iso8859_4", "iso-8859-4" } };
            ht[287] = new Object[] { "iso8859_5", "iso-8859-5" };
            ht[288] = new Object[] { "iso8859_6", "iso-8859-6" };
            ht[289] = new Object[] { "iso8859_7", "iso-8859-7" };
            ht[290] = new Object[] { "iso8859_8", "iso-8859-8" };
            ht[291] = new Object[] { "iso8859_9", "iso-8859-9" };
            ht[294] = new Object[] { "ibm912", "iso-8859-2" };
            ht[295] = new Object[] { "ibm913", "iso-8859-3" };
            ht[296] = new Object[] { "ibm914", "iso-8859-4" };
            ht[297] = new Object[] { "ibm915", "iso-8859-5" };
            ht[298] = new Object[] { "ibm916", "iso-8859-8" };
            ht[305] = new Object[] { "iso_8859-13", "iso-8859-13" };
            ht[307] = new Object[] { "iso_8859-15", "iso-8859-15" };
            ht[308] = new Object[] { "iso_8859-16", "iso-8859-16" };
            ht[312] = new Object[] { "greek8", "iso-8859-7",
                         new Object[] { "646", "us-ascii" } };
            ht[318] = new Object[] { "ms_kanji", "shift_jis" };
            ht[321] = new Object[] { "ibm-912", "iso-8859-2" };
            ht[322] = new Object[] { "ibm-913", "iso-8859-3",
                         new Object[] { "csiso87jisx0208", "x-jis0208" } };
            ht[323] = new Object[] { "ibm920", "iso-8859-9",
                         new Object[] { "ibm-914", "iso-8859-4" } };
            ht[324] = new Object[] { "ibm-915", "iso-8859-5" };
            ht[325] = new Object[] { "ibm-916", "iso-8859-8",
                         new Object[] { "l1", "iso-8859-1" } };
            ht[326] = new Object[] { "cp850", "ibm850",
                         new Object[] { "ibm923", "iso-8859-15",
                             new Object[] { "l2", "iso-8859-2" } } };
            ht[327] = new Object[] { "l3", "iso-8859-3",
                         new Object[] { "cyrillic", "iso-8859-5" } };
            ht[328] = new Object[] { "cp852", "ibm852",
                         new Object[] { "l4", "iso-8859-4" } };
            ht[329] = new Object[] { "l5", "iso-8859-9" };
            ht[331] = new Object[] { "cp855", "ibm855" };
            ht[333] = new Object[] { "cp857", "ibm857",
                         new Object[] { "l9", "iso-8859-15" } };
            ht[334] = new Object[] { "cp858", "ibm00858",
                         new Object[] { "cp737", "x-ibm737" } };
            ht[336] = new Object[] { "iso_8859_1", "iso-8859-1" };
            ht[339] = new Object[] { "koi8", "koi8-r" };
            ht[341] = new Object[] { "775", "ibm775" };
            ht[345] = new Object[] { "iso_8859-9:1989", "iso-8859-9" };
            ht[350] = new Object[] { "eucjp-open", "x-eucjp-open",
                         new Object[] { "euccn", "gb2312",
                             new Object[] { "ibm-920", "iso-8859-9" } } };
            ht[352] = new Object[] { "1089", "iso-8859-6" };
            ht[353] = new Object[] { "ibm-923", "iso-8859-15" };
            ht[358] = new Object[] { "ibm813", "iso-8859-7" };
            ht[359] = new Object[] { "cp862", "ibm862" };
            ht[363] = new Object[] { "cp866", "ibm866" };
            ht[364] = new Object[] { "ibm819", "iso-8859-1" };
            ht[378] = new Object[] { "ansi_x3.4-1968", "us-ascii" };
            ht[385] = new Object[] { "ibm-813", "iso-8859-7" };
            ht[391] = new Object[] { "ibm-819", "iso-8859-1" };
            ht[392] = new Object[] { "cp874", "x-ibm874" };
            ht[393] = new Object[] { "extended_unix_code_packed_format_for_japanese", "euc-jp" };
            ht[405] = new Object[] { "iso-ir-100", "iso-8859-1" };
            ht[406] = new Object[] { "iso-ir-101", "iso-8859-2" };
            ht[408] = new Object[] { "437", "ibm437" };
            ht[410] = new Object[] { "iso-ir-226", "iso-8859-16" };
            ht[414] = new Object[] { "iso-ir-109", "iso-8859-3",
                         new Object[] { "iso_8859-3:1988", "iso-8859-3" } };
            ht[417] = new Object[] { "iso-8859-11", "x-iso-8859-11" };
            ht[421] = new Object[] { "iso-8859-15", "iso-8859-15" };
            ht[422] = new Object[] { "csiso159jisx02121990", "jis_x0212-1990" };
            ht[428] = new Object[] { "latin0", "iso-8859-15" };
            ht[429] = new Object[] { "latin1", "iso-8859-1" };
            ht[430] = new Object[] { "latin2", "iso-8859-2" };
            ht[431] = new Object[] { "latin3", "iso-8859-3" };
            ht[432] = new Object[] { "latin4", "iso-8859-4" };
            ht[433] = new Object[] { "latin5", "iso-8859-9" };
            ht[436] = new Object[] { "iso-ir-110", "iso-8859-4" };
            ht[437] = new Object[] { "latin9", "iso-8859-15" };
            ht[438] = new Object[] { "ansi_x3.4-1986", "us-ascii" };
            ht[442] = new Object[] { "x-euc-cn", "gb2312" };
            ht[443] = new Object[] { "utf-32be-bom", "x-utf-32be-bom" };
            ht[449] = new Object[] { "sjis", "shift_jis" };
            ht[455] = new Object[] { "euc_jp_linux", "x-euc-jp-linux" };
            ht[456] = new Object[] { "cp775", "ibm775" };
            ht[468] = new Object[] { "ibm1089", "iso-8859-6" };
            ht[471] = new Object[] { "shift_jis", "shift_jis" };
            ht[473] = new Object[] { "iso-ir-126", "iso-8859-7" };
            ht[474] = new Object[] { "iso-ir-127", "iso-8859-6" };
            ht[479] = new Object[] { "ibm850", "ibm850" };
            ht[481] = new Object[] { "ibm852", "ibm852" };
            ht[484] = new Object[] { "ibm855", "ibm855" };
            ht[486] = new Object[] { "ibm857", "ibm857" };
            ht[487] = new Object[] { "ibm737", "x-ibm737" };
            ht[502] = new Object[] { "x-sjis", "shift_jis",
                         new Object[] { "utf_16le", "utf-16le" } };
            ht[506] = new Object[] { "iso-ir-138", "iso-8859-8",
                         new Object[] { "ibm-850", "ibm850" } };
            ht[508] = new Object[] { "ibm-852", "ibm852" };
            ht[511] = new Object[] { "ibm-855", "ibm855" };
            ht[512] = new Object[] { "ibm862", "ibm862" };
            ht[513] = new Object[] { "ibm-857", "ibm857" };
            ht[514] = new Object[] { "ibm-737", "x-ibm737" };
            ht[516] = new Object[] { "ibm866", "ibm866" };
            ht[520] = new Object[] { "unicodebigunmarked", "utf-16be" };
            ht[523] = new Object[] { "cp437", "ibm437" };
            ht[524] = new Object[] { "utf16", "utf-16" };
            ht[526] = new Object[] { "windows-932", "windows-31j" };
            ht[530] = new Object[] { "windows-936", "gbk" };
            ht[533] = new Object[] { "iso-ir-144", "iso-8859-5" };
            ht[537] = new Object[] { "iso-ir-148", "iso-8859-9" };
            ht[539] = new Object[] { "ibm-862", "ibm862" };
            ht[543] = new Object[] { "ibm-866", "ibm866" };
            ht[545] = new Object[] { "ibm874", "x-ibm874" };
            ht[550] = new Object[] { "ksc_5601", "euc-kr" };
            ht[555] = new Object[] { "big5hkscs", "big5-hkscs" };
            ht[563] = new Object[] { "x-utf-32le", "utf-32le" };
            ht[569] = new Object[] { "eucjp", "euc-jp",
                         new Object[] { "iso-ir-159", "jis_x0212-1990" } };
            ht[572] = new Object[] { "ibm-874", "x-ibm874" };
            ht[573] = new Object[] { "iso_8859-4:1988", "iso-8859-4" };
            ht[576] = new Object[] { "gb18030-2000", "gb18030" };
            ht[577] = new Object[] { "default", "us-ascii" };
            ht[582] = new Object[] { "utf32", "utf-32" };
            ht[583] = new Object[] { "pc-multilingual-850+euro", "ibm00858" };
            ht[588] = new Object[] { "elot_928", "iso-8859-7" };
            ht[590] = new Object[] { "csisolatinhebrew", "iso-8859-8" };
            ht[591] = new Object[] { "cshalfwidthkatakana", "jis_x0201" };
            ht[593] = new Object[] { "csisolatingreek", "iso-8859-7" };
            ht[598] = new Object[] { "csibm857", "ibm857" };
            ht[602] = new Object[] { "euckr", "euc-kr" };
            ht[609] = new Object[] { "ibm775", "ibm775" };
            ht[617] = new Object[] { "cp1250", "windows-1250" };
            ht[618] = new Object[] { "cp1251", "windows-1251" };
            ht[619] = new Object[] { "cp1252", "windows-1252" };
            ht[620] = new Object[] { "cp1253", "windows-1253" };
            ht[621] = new Object[] { "cp1254", "windows-1254" };
            ht[624] = new Object[] { "csibm862", "ibm862",
                         new Object[] { "cp1257", "windows-1257" } };
            ht[628] = new Object[] { "csibm866", "ibm866",
                         new Object[] { "cesu8", "cesu-8" } };
            ht[630] = new Object[] { "iso8859_11", "x-iso-8859-11" };
            ht[631] = new Object[] { "euc_cn", "gb2312" };
            ht[632] = new Object[] { "iso8859_13", "iso-8859-13" };
            ht[634] = new Object[] { "iso8859_15", "iso-8859-15",
                         new Object[] { "utf_32be", "utf-32be" } };
            ht[635] = new Object[] { "utf_32be_bom", "x-utf-32be-bom" };
            ht[636] = new Object[] { "ibm-775", "ibm775" };
            ht[654] = new Object[] { "cp00858", "ibm00858" };
            ht[661] = new Object[] { "x-euc-jp", "euc-jp" };
            ht[669] = new Object[] { "8859_13", "iso-8859-13" };
            ht[670] = new Object[] { "us", "us-ascii" };
            ht[671] = new Object[] { "8859_15", "iso-8859-15" };
            ht[676] = new Object[] { "ibm437", "ibm437" };
            ht[679] = new Object[] { "cp367", "us-ascii" };
            ht[685] = new Object[] { "cns11643", "x-euc-tw" };
            ht[686] = new Object[] { "iso-10646-ucs-2", "utf-16be" };
            ht[694] = new Object[] { "big5_hkscs", "big5-hkscs" };
            ht[702] = new Object[] { "euc_jp_solaris", "x-eucjp-open" };
            ht[703] = new Object[] { "ibm-437", "ibm437" };
            ht[709] = new Object[] { "euc-cn", "gb2312" };
            ht[710] = new Object[] { "iso8859-13", "iso-8859-13" };
            ht[712] = new Object[] { "iso8859-15", "iso-8859-15" };
            ht[731] = new Object[] { "iso-ir-87", "x-jis0208" };
            ht[732] = new Object[] { "iso_8859-5:1988", "iso-8859-5" };
            ht[733] = new Object[] { "ksc5601", "euc-kr",
                         new Object[] { "unicode", "utf-16" } };
            ht[760] = new Object[] { "big5hk", "big5-hkscs" };
            ht[768] = new Object[] { "greek", "iso-8859-7" };
            ht[771] = new Object[] { "ms1361", "x-johab" };
            ht[774] = new Object[] { "ascii7", "us-ascii" };
            ht[781] = new Object[] { "iso8859-1", "iso-8859-1" };
            ht[782] = new Object[] { "iso8859-2", "iso-8859-2" };
            ht[783] = new Object[] { "iso8859-3", "iso-8859-3",
                         new Object[] { "cskoi8r", "koi8-r" } };
            ht[784] = new Object[] { "jis_x0201", "jis_x0201",
                         new Object[] { "iso8859-4", "iso-8859-4" } };
            ht[785] = new Object[] { "iso8859-5", "iso-8859-5" };
            ht[786] = new Object[] { "iso8859-6", "iso-8859-6" };
            ht[787] = new Object[] { "iso8859-7", "iso-8859-7" };
            ht[788] = new Object[] { "iso8859-8", "iso-8859-8" };
            ht[789] = new Object[] { "iso8859-9", "iso-8859-9" };
            ht[804] = new Object[] { "johab", "x-johab" };
            ht[813] = new Object[] { "ccsid00858", "ibm00858" };
            ht[818] = new Object[] { "cspc862latinhebrew", "ibm862" };
            ht[827] = new Object[] { "tis620.2533", "tis-620" };
            ht[832] = new Object[] { "ibm367", "us-ascii" };
            ht[834] = new Object[] { "iso_8859-1", "iso-8859-1" };
            ht[835] = new Object[] { "iso_8859-2", "iso-8859-2",
                         new Object[] { "x-utf-16be", "utf-16be" } };
            ht[836] = new Object[] { "iso_8859-3", "iso-8859-3",
                         new Object[] { "sun_eu_greek", "iso-8859-7" } };
            ht[837] = new Object[] { "iso_8859-16:2001", "iso-8859-16",
                         new Object[] { "iso_8859-4", "iso-8859-4" } };
            ht[838] = new Object[] { "iso_8859-5", "iso-8859-5" };
            ht[839] = new Object[] { "iso_8859-6", "iso-8859-6" };
            ht[840] = new Object[] { "gb2312-80", "gb2312",
                         new Object[] { "cspcp852", "ibm852",
                             new Object[] { "iso_8859-7", "iso-8859-7" } } };
            ht[841] = new Object[] { "iso_8859-8", "iso-8859-8",
                         new Object[] { "ksc5601_1987", "euc-kr",
                             new Object[] { "shift-jis", "shift_jis" } } };
            ht[842] = new Object[] { "iso_8859-9", "iso-8859-9" };
            ht[843] = new Object[] { "cspcp855", "ibm855" };
            ht[845] = new Object[] { "cp1089", "iso-8859-6" };
            ht[846] = new Object[] { "windows-437", "ibm437" };
            ht[849] = new Object[] { "ascii", "us-ascii" };
            ht[850] = new Object[] { "euc_jp", "euc-jp" };
            ht[863] = new Object[] { "cscesu-8", "cesu-8" };
            ht[867] = new Object[] { "ksc5601_1992", "x-johab" };
            ht[880] = new Object[] { "gb2312-1980", "gb2312" };
            ht[881] = new Object[] { "utf8", "utf-8" };
            ht[883] = new Object[] { "euc_kr", "euc-kr" };
            ht[886] = new Object[] { "euctw", "x-euc-tw" };
            ht[890] = new Object[] { "iso_8859-6:1987", "iso-8859-6" };
            ht[891] = new Object[] { "csisolatinarabic", "iso-8859-6" };
            ht[893] = new Object[] { "gb2312", "gb2312" };
            ht[895] = new Object[] { "hebrew", "iso-8859-8" };
            ht[896] = new Object[] { "iso_646.irv:1983", "us-ascii" };
            ht[907] = new Object[] { "l10", "iso-8859-16" };
            ht[909] = new Object[] { "cp5346", "windows-1250" };
            ht[910] = new Object[] { "cp5347", "windows-1251" };
            ht[911] = new Object[] { "cp5348", "windows-1252" };
            ht[912] = new Object[] { "cp5349", "windows-1253" };
            ht[918] = new Object[] { "tis620", "tis-620" };
            ht[925] = new Object[] { "iso_646.irv:1991", "us-ascii" };
            ht[929] = new Object[] { "big5_solaris", "x-big5-solaris" };
            ht[933] = new Object[] { "csbig5", "big5" };
            ht[934] = new Object[] { "cp5350", "windows-1254" };
            ht[936] = new Object[] { "big5-hkscs", "big5-hkscs" };
            ht[937] = new Object[] { "cp5353", "windows-1257" };
            ht[944] = new Object[] { "latin-9", "iso-8859-15",
                         new Object[] { "utf_32le", "utf-32le" } };
            ht[956] = new Object[] { "jis_x0212-1990", "jis_x0212-1990" };
            ht[957] = new Object[] { "utf_16", "utf-16" };
            ht[962] = new Object[] { "csshiftjis", "shift_jis" };
            ht[984] = new Object[] { "cseucpkdfmtjapanese", "euc-jp",
                         new Object[] { "jis_c6226-1983", "x-jis0208" } };
            ht[993] = new Object[] { "cspc850multilingual", "ibm850" };
            ht[1002] = new Object[] { "cseuckr", "euc-kr" };
            ht[1009] = new Object[] { "utf-32le-bom", "x-utf-32le-bom" };
            ht[1015] = new Object[] { "utf_32", "utf-32" };
            ht[1019] = new Object[] { "x0201", "jis_x0201" };
        }

    }

    private static final class Classes
        extends sun.util.PreHashedMap<String>
    {

        private static final int ROWS = 64;
        private static final int SIZE = 63;
        private static final int SHIFT = 0;
        private static final int MASK = 0x3f;

        private Classes() {
            super(ROWS, SIZE, SHIFT, MASK);
        }

        protected void init(Object[] ht) {
            ht[0] = new Object[] { "ibm862", "IBM862" };
            ht[1] = new Object[] { "euc-kr", "EUC_KR" };
            ht[2] = new Object[] { "windows-31j", "MS932" };
            ht[3] = new Object[] { "x-pck", "PCK" };
            ht[4] = new Object[] { "ibm866", "IBM866",
                         new Object[] { "utf-16le", "UTF_16LE" } };
            ht[5] = new Object[] { "tis-620", "TIS_620",
                         new Object[] { "utf-32", "UTF_32" } };
            ht[6] = new Object[] { "windows-1250", "MS1250" };
            ht[7] = new Object[] { "windows-1251", "MS1251" };
            ht[8] = new Object[] { "x-big5-solaris", "Big5_Solaris",
                         new Object[] { "windows-1252", "MS1252",
                             new Object[] { "utf-32be", "UTF_32BE" } } };
            ht[9] = new Object[] { "x-jis0208", "JIS_X_0208",
                         new Object[] { "windows-1253", "MS1253" } };
            ht[10] = new Object[] { "windows-1254", "MS1254" };
            ht[11] = new Object[] { "gb18030", "GB18030",
                         new Object[] { "utf-16", "UTF_16" } };
            ht[12] = new Object[] { "x-iso-8859-11", "ISO_8859_11" };
            ht[13] = new Object[] { "windows-1257", "MS1257" };
            ht[14] = new Object[] { "utf-16be", "UTF_16BE" };
            ht[15] = new Object[] { "x-johab", "Johab" };
            ht[16] = new Object[] { "jis_x0201", "JIS_X_0201",
                         new Object[] { "iso-8859-1", "ISO_8859_1" } };
            ht[17] = new Object[] { "iso-8859-2", "ISO_8859_2" };
            ht[18] = new Object[] { "iso-8859-3", "ISO_8859_3",
                         new Object[] { "x-euc-tw", "EUC_TW",
                             new Object[] { "utf-8", "UTF_8" } } };
            ht[19] = new Object[] { "x-eucjp-open", "EUC_JP_Open",
                         new Object[] { "iso-8859-4", "ISO_8859_4" } };
            ht[20] = new Object[] { "iso-8859-5", "ISO_8859_5" };
            ht[21] = new Object[] { "iso-8859-6", "ISO_8859_6" };
            ht[22] = new Object[] { "x-ibm874", "IBM874",
                         new Object[] { "iso-8859-7", "ISO_8859_7" } };
            ht[23] = new Object[] { "iso-8859-8", "ISO_8859_8",
                         new Object[] { "shift_jis", "SJIS" } };
            ht[24] = new Object[] { "iso-8859-9", "ISO_8859_9" };
            ht[28] = new Object[] { "x-ibm737", "IBM737" };
            ht[31] = new Object[] { "ibm850", "IBM850" };
            ht[32] = new Object[] { "euc-jp", "EUC_JP" };
            ht[33] = new Object[] { "ibm852", "IBM852",
                         new Object[] { "ibm775", "IBM775" } };
            ht[34] = new Object[] { "us-ascii", "US_ASCII" };
            ht[35] = new Object[] { "iso-8859-13", "ISO_8859_13" };
            ht[36] = new Object[] { "ibm855", "IBM855",
                         new Object[] { "ibm437", "IBM437" } };
            ht[37] = new Object[] { "iso-8859-15", "ISO_8859_15" };
            ht[38] = new Object[] { "ibm857", "IBM857",
                         new Object[] { "iso-8859-16", "ISO_8859_16",
                             new Object[] { "x-utf-32le-bom", "UTF_32LE_BOM" } } };
            ht[39] = new Object[] { "ibm00858", "IBM858" };
            ht[40] = new Object[] { "big5-hkscs", "Big5_HKSCS" };
            ht[44] = new Object[] { "x-utf-16le-bom", "UTF_16LE_BOM" };
            ht[47] = new Object[] { "cesu-8", "CESU_8" };
            ht[48] = new Object[] { "gbk", "GBK",
                         new Object[] { "x-utf-32be-bom", "UTF_32BE_BOM" } };
            ht[53] = new Object[] { "big5", "Big5" };
            ht[56] = new Object[] { "koi8-r", "KOI8_R" };
            ht[59] = new Object[] { "koi8-u", "KOI8_U" };
            ht[60] = new Object[] { "x-euc-jp-linux", "EUC_JP_LINUX",
                         new Object[] { "jis_x0212-1990", "JIS_X_0212" } };
            ht[61] = new Object[] { "gb2312", "EUC_CN" };
            ht[62] = new Object[] { "utf-32le", "UTF_32LE" };
        }

    }

    private static final class Cache
        extends sun.util.PreHashedMap<Charset>
    {

        private static final int ROWS = 64;
        private static final int SIZE = 63;
        private static final int SHIFT = 0;
        private static final int MASK = 0x3f;

        private Cache() {
            super(ROWS, SIZE, SHIFT, MASK);
        }

        protected void init(Object[] ht) {
            ht[0] = new Object[] { "ibm862", null };
            ht[1] = new Object[] { "euc-kr", null };
            ht[2] = new Object[] { "windows-31j", null };
            ht[3] = new Object[] { "x-pck", null };
            ht[4] = new Object[] { "ibm866", null,
                         new Object[] { "utf-16le", null } };
            ht[5] = new Object[] { "tis-620", null,
                         new Object[] { "utf-32", null } };
            ht[6] = new Object[] { "windows-1250", null };
            ht[7] = new Object[] { "windows-1251", null };
            ht[8] = new Object[] { "x-big5-solaris", null,
                         new Object[] { "windows-1252", null,
                             new Object[] { "utf-32be", null } } };
            ht[9] = new Object[] { "x-jis0208", null,
                         new Object[] { "windows-1253", null } };
            ht[10] = new Object[] { "windows-1254", null };
            ht[11] = new Object[] { "gb18030", null,
                         new Object[] { "utf-16", null } };
            ht[12] = new Object[] { "x-iso-8859-11", null };
            ht[13] = new Object[] { "windows-1257", null };
            ht[14] = new Object[] { "utf-16be", null };
            ht[15] = new Object[] { "x-johab", null };
            ht[16] = new Object[] { "jis_x0201", null,
                         new Object[] { "iso-8859-1", null } };
            ht[17] = new Object[] { "iso-8859-2", null };
            ht[18] = new Object[] { "iso-8859-3", null,
                         new Object[] { "x-euc-tw", null,
                             new Object[] { "utf-8", null } } };
            ht[19] = new Object[] { "x-eucjp-open", null,
                         new Object[] { "iso-8859-4", null } };
            ht[20] = new Object[] { "iso-8859-5", null };
            ht[21] = new Object[] { "iso-8859-6", null };
            ht[22] = new Object[] { "x-ibm874", null,
                         new Object[] { "iso-8859-7", null } };
            ht[23] = new Object[] { "iso-8859-8", null,
                         new Object[] { "shift_jis", null } };
            ht[24] = new Object[] { "iso-8859-9", null };
            ht[28] = new Object[] { "x-ibm737", null };
            ht[31] = new Object[] { "ibm850", null };
            ht[32] = new Object[] { "euc-jp", null };
            ht[33] = new Object[] { "ibm852", null,
                         new Object[] { "ibm775", null } };
            ht[34] = new Object[] { "us-ascii", null };
            ht[35] = new Object[] { "iso-8859-13", null };
            ht[36] = new Object[] { "ibm855", null,
                         new Object[] { "ibm437", null } };
            ht[37] = new Object[] { "iso-8859-15", null };
            ht[38] = new Object[] { "ibm857", null,
                         new Object[] { "iso-8859-16", null,
                             new Object[] { "x-utf-32le-bom", null } } };
            ht[39] = new Object[] { "ibm00858", null };
            ht[40] = new Object[] { "big5-hkscs", null };
            ht[44] = new Object[] { "x-utf-16le-bom", null };
            ht[47] = new Object[] { "cesu-8", null };
            ht[48] = new Object[] { "gbk", null,
                         new Object[] { "x-utf-32be-bom", null } };
            ht[53] = new Object[] { "big5", null };
            ht[56] = new Object[] { "koi8-r", null };
            ht[59] = new Object[] { "koi8-u", null };
            ht[60] = new Object[] { "x-euc-jp-linux", null,
                         new Object[] { "jis_x0212-1990", null } };
            ht[61] = new Object[] { "gb2312", null };
            ht[62] = new Object[] { "utf-32le", null };
        }

    }


    // Maps canonical names to class names
    private @Stable Map<String,String> classMap;

    // Maps alias names to canonical names
    private @Stable Map<String,String> aliasMap;

    // Maps canonical names to cached instances
    private @Stable Map<String,Charset> cache;

    private static final String packagePrefix = "sun.nio.cs.";

    public StandardCharsets() {
    }

    private String canonicalize(String csn) {
        String acn = aliasMap().get(csn);
        return (acn != null) ? acn : csn;
    }

    private Map<String,String> aliasMap() {
        Map<String,String> map = aliasMap;
        if (map == null) {
            aliasMap = map = new Aliases();
        }
        return map;
    }

    private Map<String,String> classMap() {
        Map<String,String> map = classMap;
        if (map == null) {
            classMap = map = new Classes();
        }
        return map;
    }

    private Map<String,Charset> cache() {
        Map<String,Charset> map = cache;
        if (map == null) {
            map = new Cache();
            map.put("utf-8", UTF_8.INSTANCE);
            map.put("iso-8859-1", ISO_8859_1.INSTANCE);
            map.put("us-ascii", US_ASCII.INSTANCE);
            map.put("utf-16", java.nio.charset.StandardCharsets.UTF_16);
            map.put("utf-16be", java.nio.charset.StandardCharsets.UTF_16BE);
            map.put("utf-16le", java.nio.charset.StandardCharsets.UTF_16LE);
            cache = map;
        }
        return map;
    }

    // Private ASCII-only version, optimized for interpretation during startup
    //
    private static String toLower(String s) {
        int n = s.length();
        boolean allLower = true;
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i);
            if (((c - 'A') | ('Z' - c)) >= 0) {
                allLower = false;
                break;
            }
        }
        if (allLower)
            return s;
        StringBuilder sb = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i);
            if (((c - 'A') | ('Z' - c)) >= 0)
                sb.append((char)(c + 0x20));
            else
                sb.append((char)c);
        }
        return sb.toString();
    }

    private Charset lookup(String charsetName) {
        init();

        // By checking these built-ins we can avoid initializing Aliases,
        // Classes and Cache eagerly during bootstrap.
        //
        // Initialization of java.nio.charset.StandardCharsets should be
        // avoided here to minimize time spent in System.initPhase1, as it
        // may delay initialization of performance critical VM subsystems.
        String csn;
        if (charsetName.equals("UTF-8")) {
            return UTF_8.INSTANCE;
        } else if (charsetName.equals("US-ASCII")) {
            return US_ASCII.INSTANCE;
        } else if (charsetName.equals("ISO-8859-1")) {
            return ISO_8859_1.INSTANCE;
        } else {
            csn = canonicalize(toLower(charsetName));
        }

        // Check cache first
        Charset cs = cache().get(csn);
        if (cs != null)
            return cs;

        // Do we even support this charset?
        String cln = classMap().get(csn);
        if (cln == null)
            return null;

        // Instantiate the charset and cache it
        try {
            @SuppressWarnings("deprecation")
            Object o = Class.forName(packagePrefix + cln,
                                     true,
                                     this.getClass().getClassLoader()).newInstance();
            return cache(csn, (Charset)o);
        } catch (ClassNotFoundException |
                 IllegalAccessException |
                 InstantiationException x) {
            return null;
        }
    }

    private Charset cache(String csn, Charset cs) {
        cache().put(csn, cs);
        return cs;
    }

    public final Charset charsetForName(String charsetName) {
        synchronized (this) {
            return lookup(charsetName);
        }
    }

    public final Iterator<Charset> charsets() {
        Set<String> charsetNames;
        synchronized (this) {
            init();
            // Ensure initialized in synchronized block
            charsetNames = classMap().keySet();
            aliasMap();
            cache();
        }
        return new Iterator<Charset>() {

                Iterator<String> i = charsetNames.iterator();

                public boolean hasNext() {
                    return i.hasNext();
                }

                public Charset next() {
                    String csn = i.next();
                    return lookup(csn);
                }

                public void remove() {
                    throw new UnsupportedOperationException();
                }

            };
    }

    private boolean initialized = false;

    /*   provider the sun.nio.cs.map property fir sjis/ms932 mapping hack
     */
    private void init() {
        if (initialized)
            return;
        if (!jdk.internal.misc.VM.isBooted())
            return;
        initialized = true;

        String map = GetPropertyAction.privilegedGetProperty("sun.nio.cs.map");
        if (map != null) {
            Map<String,String> aliasMap = aliasMap();
            Map<String,String> classMap = classMap();
            String[] maps = map.split(",");
            for (int i = 0; i < maps.length; i++) {
                if (maps[i].equalsIgnoreCase("Windows-31J/Shift_JIS")) {
                    // if we dont have both sjis and ms932, do nothing
                    if (classMap.get("shift_jis") == null ||
                        classMap.get("windows-31j") == null) {
                        break;
                    }
                    aliases_MS932 = new String[] {
                        "MS932",        // JDK historical
                        "windows-932",
                        "csWindows31J",
                        "shift-jis",
                        "ms_kanji",
                        "x-sjis",
                        "csShiftJIS",
                        // This alias takes precedence over the actual
                        // Shift_JIS charset itself since aliases are always
                        // resolved first, before looking up canonical names.
                        "shift_jis"
                    };
                    aliases_SJIS = new String[] { "sjis" };

                    for (String alias : aliases_MS932) {
                        aliasMap.put(toLower(alias), "windows-31j");
                    }
                    cache().put("shift_jis", null);
                    break;
                }
            }
        }
    }

}
