/*
 * Copyright (c) 2004, 2012, Oracle and/or its affiliates. All rights reserved.
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
 * THIS FILE WAS MODIFIED BY SUN MICROSYSTEMS, INC.
 */

package com.sun.xml.internal.fastinfoset.algorithm;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.List;
import com.sun.xml.internal.org.jvnet.fastinfoset.EncodingAlgorithmException;
import com.sun.xml.internal.fastinfoset.CommonResourceBundle;


/**
 * An encoder for handling Short values.  Suppports the builtin SHORT encoder.
 *
 * @author Alan Hudson
 * @author Paul Sandoz
 */
public class ShortEncodingAlgorithm extends IntegerEncodingAlgorithm {

    public final int getPrimtiveLengthFromOctetLength(int octetLength) throws EncodingAlgorithmException {
        if (octetLength % SHORT_SIZE != 0) {
            throw new EncodingAlgorithmException(CommonResourceBundle.getInstance().
                    getString("message.lengthNotMultipleOfShort", new Object[]{Integer.valueOf(SHORT_SIZE)}));
        }

        return octetLength / SHORT_SIZE;
    }

    public int getOctetLengthFromPrimitiveLength(int primitiveLength) {
        return primitiveLength * SHORT_SIZE;
    }

    public final Object decodeFromBytes(byte[] b, int start, int length) throws EncodingAlgorithmException {
        short[] data = new short[getPrimtiveLengthFromOctetLength(length)];
        decodeFromBytesToShortArray(data, 0, b, start, length);

        return data;
    }

    public final Object decodeFromInputStream(InputStream s) throws IOException {
        return decodeFromInputStreamToShortArray(s);
    }


    public void encodeToOutputStream(Object data, OutputStream s) throws IOException {
        if (!(data instanceof short[])) {
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.dataNotShortArray"));
        }

        final short[] idata = (short[])data;

        encodeToOutputStreamFromShortArray(idata, s);
    }


    public final Object convertFromCharacters(char[] ch, int start, int length) {
        final CharBuffer cb = CharBuffer.wrap(ch, start, length);
        final List shortList = new ArrayList();

        matchWhiteSpaceDelimnatedWords(cb,
                new WordListener() {
            public void word(int start, int end) {
                String iStringValue = cb.subSequence(start, end).toString();
                shortList.add(Short.valueOf(iStringValue));
            }
        }
        );

        return generateArrayFromList(shortList);
    }

    public final void convertToCharacters(Object data, StringBuffer s) {
        if (!(data instanceof short[])) {
            throw new IllegalArgumentException(CommonResourceBundle.getInstance().getString("message.dataNotShortArray"));
        }

        final short[] idata = (short[])data;

        convertToCharactersFromShortArray(idata, s);
    }


    public final void decodeFromBytesToShortArray(short[] sdata, int istart, byte[] b, int start, int length) {
        final int size = length / SHORT_SIZE;
        for (int i = 0; i < size; i++) {
            sdata[istart++] = (short) (((b[start++] & 0xFF) << 8) |
                    (b[start++] & 0xFF));
        }
    }

    public final short[] decodeFromInputStreamToShortArray(InputStream s) throws IOException {
        final List shortList = new ArrayList();
        final byte[] b = new byte[SHORT_SIZE];

        while (true) {
            int n = s.read(b);
            if (n != 2) {
                if (n == -1) {
                    break;
                }

                while(n != 2) {
                    final int m = s.read(b, n, SHORT_SIZE - n);
                    if (m == -1) {
                        throw new EOFException();
                    }
                    n += m;
                }
            }

            final int i = ((b[0] & 0xFF) << 8) |
                    (b[1] & 0xFF);
            shortList.add(Short.valueOf((short)i));
        }

        return generateArrayFromList(shortList);
    }


    public final void encodeToOutputStreamFromShortArray(short[] idata, OutputStream s) throws IOException {
        for (int i = 0; i < idata.length; i++) {
            final int bits = idata[i];
            s.write((bits >>> 8) & 0xFF);
            s.write(bits & 0xFF);
        }
    }

    public final void encodeToBytes(Object array, int astart, int alength, byte[] b, int start) {
        encodeToBytesFromShortArray((short[])array, astart, alength, b, start);
    }

    public final void encodeToBytesFromShortArray(short[] sdata, int istart, int ilength, byte[] b, int start) {
        final int iend = istart + ilength;
        for (int i = istart; i < iend; i++) {
            final short bits = sdata[i];
            b[start++] = (byte)((bits >>> 8) & 0xFF);
            b[start++] = (byte)(bits & 0xFF);
        }
    }


    public final void convertToCharactersFromShortArray(short[] sdata, StringBuffer s) {
        final int end = sdata.length - 1;
        for (int i = 0; i <= end; i++) {
            s.append(Short.toString(sdata[i]));
            if (i != end) {
                s.append(' ');
            }
        }
    }


    public final short[] generateArrayFromList(List array) {
        short[] sdata = new short[array.size()];
        for (int i = 0; i < sdata.length; i++) {
            sdata[i] = ((Short)array.get(i)).shortValue();
        }

        return sdata;
    }
}
