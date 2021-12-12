/*
 * Copyright (c) 2008, 2021, Oracle and/or its affiliates. All rights reserved.
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
 */

package sun.nio.cs.ext;

import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import sun.nio.cs.StandardCharsets;
import sun.nio.cs.SingleByte;
import sun.nio.cs.HistoricallyNamedCharset;
import static sun.nio.cs.CharsetMapping.*;

public class IBM1129 extends Charset implements HistoricallyNamedCharset
{
    public IBM1129() {
        super("x-IBM1129", ExtendedCharsets.aliasesFor("x-IBM1129"));
    }

    public String historicalName() {
        return "Cp1129";
    }

    public boolean contains(Charset cs) {
        return (cs instanceof IBM1129);
    }

    public CharsetDecoder newDecoder() {
        return new SingleByte.Decoder(this, Holder.b2c, false, false);
    }

    public CharsetEncoder newEncoder() {
        return new SingleByte.Encoder(this, Holder.c2b, Holder.c2bIndex, false);
    }

    private static class Holder {
        private static final String b2cTable = 
        "\u0080\u0081\u0082\u0083\u0084\u0085\u0086\u0087" +      // 0x80 - 0x87
        "\u0088\u0089\u008A\u008B\u008C\u008D\u008E\u008F" +      // 0x88 - 0x8f
        "\u0090\u0091\u0092\u0093\u0094\u0095\u0096\u0097" +      // 0x90 - 0x97
        "\u0098\u0099\u009A\u009B\u009C\u009D\u009E\u009F" +      // 0x98 - 0x9f
        "\u00A0\u00A1\u00A2\u00A3\u00A4\u00A5\u00A6\u00A7" +      // 0xa0 - 0xa7
        "\u0153\u00A9\u00AA\u00AB\u00AC\u00AD\u00AE\u00AF" +      // 0xa8 - 0xaf
        "\u00B0\u00B1\u00B2\u00B3\u0178\u00B5\u00B6\u00B7" +      // 0xb0 - 0xb7
        "\u0152\u00B9\u00BA\u00BB\u00BC\u00BD\u00BE\u00BF" +      // 0xb8 - 0xbf
        "\u00C0\u00C1\u00C2\u0102\u00C4\u00C5\u00C6\u00C7" +      // 0xc0 - 0xc7
        "\u00C8\u00C9\u00CA\u00CB\u0300\u00CD\u00CE\u00CF" +      // 0xc8 - 0xcf
        "\u0110\u00D1\u0309\u00D3\u00D4\u01A0\u00D6\u00D7" +      // 0xd0 - 0xd7
        "\u00D8\u00D9\u00DA\u00DB\u00DC\u01AF\u0303\u00DF" +      // 0xd8 - 0xdf
        "\u00E0\u00E1\u00E2\u0103\u00E4\u00E5\u00E6\u00E7" +      // 0xe0 - 0xe7
        "\u00E8\u00E9\u00EA\u00EB\u0301\u00ED\u00EE\u00EF" +      // 0xe8 - 0xef
        "\u0111\u00F1\u0323\u00F3\u00F4\u01A1\u00F6\u00F7" +      // 0xf0 - 0xf7
        "\u00F8\u00F9\u00FA\u00FB\u00FC\u01B0\u20AB\u00FF" +      // 0xf8 - 0xff
        "\u0000\u0001\u0002\u0003\u0004\u0005\u0006\u0007" +      // 0x00 - 0x07
        "\b\t\n\u000B\f\r\u000E\u000F" +      // 0x08 - 0x0f
        "\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017" +      // 0x10 - 0x17
        "\u0018\u0019\u001A\u001B\u001C\u001D\u001E\u001F" +      // 0x18 - 0x1f
        "\u0020\u0021\"\u0023\u0024\u0025\u0026\'" +      // 0x20 - 0x27
        "\u0028\u0029\u002A\u002B\u002C\u002D\u002E\u002F" +      // 0x28 - 0x2f
        "\u0030\u0031\u0032\u0033\u0034\u0035\u0036\u0037" +      // 0x30 - 0x37
        "\u0038\u0039\u003A\u003B\u003C\u003D\u003E\u003F" +      // 0x38 - 0x3f
        "\u0040\u0041\u0042\u0043\u0044\u0045\u0046\u0047" +      // 0x40 - 0x47
        "\u0048\u0049\u004A\u004B\u004C\u004D\u004E\u004F" +      // 0x48 - 0x4f
        "\u0050\u0051\u0052\u0053\u0054\u0055\u0056\u0057" +      // 0x50 - 0x57
        "\u0058\u0059\u005A\u005B\\\u005D\u005E\u005F" +      // 0x58 - 0x5f
        "\u0060\u0061\u0062\u0063\u0064\u0065\u0066\u0067" +      // 0x60 - 0x67
        "\u0068\u0069\u006A\u006B\u006C\u006D\u006E\u006F" +      // 0x68 - 0x6f
        "\u0070\u0071\u0072\u0073\u0074\u0075\u0076\u0077" +      // 0x70 - 0x77
        "\u0078\u0079\u007A\u007B\u007C\u007D\u007E\u007F" ;      // 0x78 - 0x7f


        private static final char[] b2c = b2cTable.toCharArray();
        private static final char[] c2b = new char[0x500];
        private static final char[] c2bIndex = new char[0x100];

        static {
            char[] b2cMap = b2c;
            char[] c2bNR = null;
            // non-roundtrip c2b only entries
        c2bNR = new char[188];
        c2bNR[0] = 0x21; c2bNR[1] = 0xff01;
        c2bNR[2] = 0x22; c2bNR[3] = 0xff02;
        c2bNR[4] = 0x23; c2bNR[5] = 0xff03;
        c2bNR[6] = 0x24; c2bNR[7] = 0xff04;
        c2bNR[8] = 0x25; c2bNR[9] = 0xff05;
        c2bNR[10] = 0x26; c2bNR[11] = 0xff06;
        c2bNR[12] = 0x27; c2bNR[13] = 0xff07;
        c2bNR[14] = 0x28; c2bNR[15] = 0xff08;
        c2bNR[16] = 0x29; c2bNR[17] = 0xff09;
        c2bNR[18] = 0x2a; c2bNR[19] = 0xff0a;
        c2bNR[20] = 0x2b; c2bNR[21] = 0xff0b;
        c2bNR[22] = 0x2c; c2bNR[23] = 0xff0c;
        c2bNR[24] = 0x2d; c2bNR[25] = 0xff0d;
        c2bNR[26] = 0x2e; c2bNR[27] = 0xff0e;
        c2bNR[28] = 0x2f; c2bNR[29] = 0xff0f;
        c2bNR[30] = 0x30; c2bNR[31] = 0xff10;
        c2bNR[32] = 0x31; c2bNR[33] = 0xff11;
        c2bNR[34] = 0x32; c2bNR[35] = 0xff12;
        c2bNR[36] = 0x33; c2bNR[37] = 0xff13;
        c2bNR[38] = 0x34; c2bNR[39] = 0xff14;
        c2bNR[40] = 0x35; c2bNR[41] = 0xff15;
        c2bNR[42] = 0x36; c2bNR[43] = 0xff16;
        c2bNR[44] = 0x37; c2bNR[45] = 0xff17;
        c2bNR[46] = 0x38; c2bNR[47] = 0xff18;
        c2bNR[48] = 0x39; c2bNR[49] = 0xff19;
        c2bNR[50] = 0x3a; c2bNR[51] = 0xff1a;
        c2bNR[52] = 0x3b; c2bNR[53] = 0xff1b;
        c2bNR[54] = 0x3c; c2bNR[55] = 0xff1c;
        c2bNR[56] = 0x3d; c2bNR[57] = 0xff1d;
        c2bNR[58] = 0x3e; c2bNR[59] = 0xff1e;
        c2bNR[60] = 0x3f; c2bNR[61] = 0xff1f;
        c2bNR[62] = 0x40; c2bNR[63] = 0xff20;
        c2bNR[64] = 0x41; c2bNR[65] = 0xff21;
        c2bNR[66] = 0x42; c2bNR[67] = 0xff22;
        c2bNR[68] = 0x43; c2bNR[69] = 0xff23;
        c2bNR[70] = 0x44; c2bNR[71] = 0xff24;
        c2bNR[72] = 0x45; c2bNR[73] = 0xff25;
        c2bNR[74] = 0x46; c2bNR[75] = 0xff26;
        c2bNR[76] = 0x47; c2bNR[77] = 0xff27;
        c2bNR[78] = 0x48; c2bNR[79] = 0xff28;
        c2bNR[80] = 0x49; c2bNR[81] = 0xff29;
        c2bNR[82] = 0x4a; c2bNR[83] = 0xff2a;
        c2bNR[84] = 0x4b; c2bNR[85] = 0xff2b;
        c2bNR[86] = 0x4c; c2bNR[87] = 0xff2c;
        c2bNR[88] = 0x4d; c2bNR[89] = 0xff2d;
        c2bNR[90] = 0x4e; c2bNR[91] = 0xff2e;
        c2bNR[92] = 0x4f; c2bNR[93] = 0xff2f;
        c2bNR[94] = 0x50; c2bNR[95] = 0xff30;
        c2bNR[96] = 0x51; c2bNR[97] = 0xff31;
        c2bNR[98] = 0x52; c2bNR[99] = 0xff32;
        c2bNR[100] = 0x53; c2bNR[101] = 0xff33;
        c2bNR[102] = 0x54; c2bNR[103] = 0xff34;
        c2bNR[104] = 0x55; c2bNR[105] = 0xff35;
        c2bNR[106] = 0x56; c2bNR[107] = 0xff36;
        c2bNR[108] = 0x57; c2bNR[109] = 0xff37;
        c2bNR[110] = 0x58; c2bNR[111] = 0xff38;
        c2bNR[112] = 0x59; c2bNR[113] = 0xff39;
        c2bNR[114] = 0x5a; c2bNR[115] = 0xff3a;
        c2bNR[116] = 0x5b; c2bNR[117] = 0xff3b;
        c2bNR[118] = 0x5c; c2bNR[119] = 0xff3c;
        c2bNR[120] = 0x5d; c2bNR[121] = 0xff3d;
        c2bNR[122] = 0x5e; c2bNR[123] = 0xff3e;
        c2bNR[124] = 0x5f; c2bNR[125] = 0xff3f;
        c2bNR[126] = 0x60; c2bNR[127] = 0xff40;
        c2bNR[128] = 0x61; c2bNR[129] = 0xff41;
        c2bNR[130] = 0x62; c2bNR[131] = 0xff42;
        c2bNR[132] = 0x63; c2bNR[133] = 0xff43;
        c2bNR[134] = 0x64; c2bNR[135] = 0xff44;
        c2bNR[136] = 0x65; c2bNR[137] = 0xff45;
        c2bNR[138] = 0x66; c2bNR[139] = 0xff46;
        c2bNR[140] = 0x67; c2bNR[141] = 0xff47;
        c2bNR[142] = 0x68; c2bNR[143] = 0xff48;
        c2bNR[144] = 0x69; c2bNR[145] = 0xff49;
        c2bNR[146] = 0x6a; c2bNR[147] = 0xff4a;
        c2bNR[148] = 0x6b; c2bNR[149] = 0xff4b;
        c2bNR[150] = 0x6c; c2bNR[151] = 0xff4c;
        c2bNR[152] = 0x6d; c2bNR[153] = 0xff4d;
        c2bNR[154] = 0x6e; c2bNR[155] = 0xff4e;
        c2bNR[156] = 0x6f; c2bNR[157] = 0xff4f;
        c2bNR[158] = 0x70; c2bNR[159] = 0xff50;
        c2bNR[160] = 0x71; c2bNR[161] = 0xff51;
        c2bNR[162] = 0x72; c2bNR[163] = 0xff52;
        c2bNR[164] = 0x73; c2bNR[165] = 0xff53;
        c2bNR[166] = 0x74; c2bNR[167] = 0xff54;
        c2bNR[168] = 0x75; c2bNR[169] = 0xff55;
        c2bNR[170] = 0x76; c2bNR[171] = 0xff56;
        c2bNR[172] = 0x77; c2bNR[173] = 0xff57;
        c2bNR[174] = 0x78; c2bNR[175] = 0xff58;
        c2bNR[176] = 0x79; c2bNR[177] = 0xff59;
        c2bNR[178] = 0x7a; c2bNR[179] = 0xff5a;
        c2bNR[180] = 0x7b; c2bNR[181] = 0xff5b;
        c2bNR[182] = 0x7c; c2bNR[183] = 0xff5c;
        c2bNR[184] = 0x7d; c2bNR[185] = 0xff5d;
        c2bNR[186] = 0x7e; c2bNR[187] = 0xff5e;

            SingleByte.initC2B(b2cMap, c2bNR, c2b, c2bIndex);
        }
    }
}
