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

package sun.security.util;

import java.security.InvalidKeyException;
import javax.crypto.SecretKey;

/**
 * Special interface for additional MessageDigestSpi method(s).
 */
public interface MessageDigestSpi2 {

    /**
     * Updates the digest using the specified key.
     * This is used for SSL 3.0 only, we may deprecate and remove the support
     * of this in the future
     *
     * @param key  the key whose value is to be digested.
     */
    void engineUpdate(SecretKey key) throws InvalidKeyException;
}
