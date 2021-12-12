/*
 * Copyright (c) 2020, 2021, Oracle and/or its affiliates. All rights reserved.
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
package sun.security.provider;

/*
 * The SHAKE256 extendable output function.
 */
public final class SHAKE256 extends SHA3 {
    public SHAKE256(int d) {
        super("SHAKE256", d, (byte) 0x1F, 64);
    }

    public void update(byte in) {
        engineUpdate(in);
    }
    public void update(byte[] in, int off, int len) {
        engineUpdate(in, off, len);
    }

    public byte[] digest() {
        return engineDigest();
    }

    public void reset() {
        engineReset();
    }
}
