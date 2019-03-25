/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

/**
 * An interface of a source of entropy input.
 *
 * @since 9
 */
public interface EntropySource {
    /**
     * Returns a byte array containing entropy.
     * <p>
     * This maps to the {@code Get_entropy_input} function defined in
     * Section 9 of NIST SP 800-90Ar1.
     *
     * @param minEntropy minimum entropy required, in bytes
     * @param minLength minimum length of output, in bytes
     * @param maxLength maximum length of output, in bytes
     * @param pr whether prediction resistance is required
     * @return the byte array containing entropy
     */
    byte[] getEntropy(int minEntropy, int minLength, int maxLength, boolean pr);
}
