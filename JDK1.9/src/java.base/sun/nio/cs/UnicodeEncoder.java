/*
 * Copyright (c) 2000, 2010, Oracle and/or its affiliates. All rights reserved.
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

package sun.nio.cs;

import java.nio.*;
import java.nio.charset.*;

/**
 * Base class for different flavors of UTF-16 encoders
 */
public abstract class UnicodeEncoder extends CharsetEncoder {

    protected static final char BYTE_ORDER_MARK = '\uFEFF';
    protected static final char REVERSED_MARK = '\uFFFE';

    protected static final int BIG = 0;
    protected static final int LITTLE = 1;

    private int byteOrder;      /* Byte order in use */
    private boolean usesMark;   /* Write an initial BOM */
    private boolean needsMark;

    protected UnicodeEncoder(Charset cs, int bo, boolean m) {
        super(cs, 2.0f,
              // Four bytes max if you need a BOM
              m ? 4.0f : 2.0f,
              // Replacement depends upon byte order
              ((bo == BIG)
               ? new byte[] { (byte)0xff, (byte)0xfd }
               : new byte[] { (byte)0xfd, (byte)0xff }));
        usesMark = needsMark = m;
        byteOrder = bo;
    }

    private void put(char c, ByteBuffer dst) {
        if (byteOrder == BIG) {
            dst.put((byte)(c >> 8));
            dst.put((byte)(c & 0xff));
        } else {
            dst.put((byte)(c & 0xff));
            dst.put((byte)(c >> 8));
        }
    }

    private final Surrogate.Parser sgp = new Surrogate.Parser();

    protected CoderResult encodeLoop(CharBuffer src, ByteBuffer dst) {
        int mark = src.position();

        if (needsMark && src.hasRemaining()) {
            if (dst.remaining() < 2)
                return CoderResult.OVERFLOW;
            put(BYTE_ORDER_MARK, dst);
            needsMark = false;
        }
        try {
            while (src.hasRemaining()) {
                char c = src.get();
                if (!Character.isSurrogate(c)) {
                    if (dst.remaining() < 2)
                        return CoderResult.OVERFLOW;
                    mark++;
                    put(c, dst);
                    continue;
                }
                int d = sgp.parse(c, src);
                if (d < 0)
                    return sgp.error();
                if (dst.remaining() < 4)
                    return CoderResult.OVERFLOW;
                mark += 2;
                put(Character.highSurrogate(d), dst);
                put(Character.lowSurrogate(d), dst);
            }
            return CoderResult.UNDERFLOW;
        } finally {
            src.position(mark);
        }
    }

    protected void implReset() {
        needsMark = usesMark;
    }

    public boolean canEncode(char c) {
        return ! Character.isSurrogate(c);
    }
}
