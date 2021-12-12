/*
 * Copyright (c) 2003, 2019, Oracle and/or its affiliates. All rights reserved.
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
package java.security.interfaces;

import java.math.BigInteger;
import java.security.PrivateKey;

/**
 * The interface to an elliptic curve (EC) private key.
 *
 * @author Valerie Peng
 *
 *
 * @see PrivateKey
 * @see ECKey
 *
 * @since 1.5
 */
public interface ECPrivateKey extends PrivateKey, ECKey {
   /**
    * The class fingerprint that is set to indicate
    * serialization compatibility.
    *
    * @deprecated A {@code serialVersionUID} field in an interface is
    * ineffectual. Do not use; no replacement.
    */
    @Deprecated
    @SuppressWarnings("serial")
    @java.io.Serial
    static final long serialVersionUID = -7896394956925609184L;

    /**
     * Returns the private value S.
     * @return the private value S.
     */
    BigInteger getS();
}
