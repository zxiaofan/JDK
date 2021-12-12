/*
 * Copyright (c) 2005, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.mscapi;

import java.lang.ref.Cleaner;
import java.security.ProviderException;
import java.security.SecureRandomSpi;

/**
 * Native PRNG implementation for Windows using the Microsoft Crypto API.
 *
 * @since 1.6
 */

public final class PRNG extends SecureRandomSpi
    implements java.io.Serializable {

    private static final long serialVersionUID = 4129268715132691532L;

    /*
     * The CryptGenRandom function fills a buffer with cryptographically random
     * bytes.
     */
    private static native byte[] generateSeed(long ctxt, int length, byte[] seed);
    private static native long getContext();
    private static native void releaseContext(long ctxt);
    private static final Cleaner CLEANER = Cleaner.create();

    private transient long ctxt;

    private static class State implements Runnable {
        private final long ctxt;

        State(long ctxt) {
            this.ctxt = ctxt;
        }

        @Override
        public void run() {
            releaseContext(ctxt);
        }
    }
    /**
     * Creates a random number generator.
     */
    public PRNG() {
        ctxt = getContext();
        CLEANER.register(this, new State(ctxt));
    }

    /**
     * Reseeds this random object. The given seed supplements, rather than
     * replaces, the existing seed. Thus, repeated calls are guaranteed
     * never to reduce randomness.
     *
     * @param seed the seed.
     */
    @Override
    protected synchronized void engineSetSeed(byte[] seed) {
        if (seed != null) {
            generateSeed(ctxt, -1, seed);
        }
    }

    /**
     * Generates a user-specified number of random bytes.
     *
     * @param bytes the array to be filled in with random bytes.
     */
    @Override
    protected synchronized void engineNextBytes(byte[] bytes) {
        if (bytes != null) {
            if (generateSeed(ctxt, 0, bytes) == null) {
                throw new ProviderException("Error generating random bytes");
            }
        }
    }

    /**
     * Returns the given number of seed bytes.  This call may be used to
     * seed other random number generators.
     *
     * @param numBytes the number of seed bytes to generate.
     *
     * @return the seed bytes.
     */
    @Override
    protected synchronized byte[] engineGenerateSeed(int numBytes) {
        byte[] seed = generateSeed(ctxt, numBytes, null);

        if (seed == null) {
            throw new ProviderException("Error generating seed bytes");
        }
        return seed;
    }

    private void readObject(java.io.ObjectInputStream s)
            throws java.io.IOException, ClassNotFoundException
    {
        s.defaultReadObject();
        ctxt = getContext();
        CLEANER.register(this, new State(ctxt));
    }
}
