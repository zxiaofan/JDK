/*
 * Copyright (c) 2003, 2018, Oracle and/or its affiliates. All rights reserved.
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

package sun.security.rsa;

import java.util.Map;

/**
 * Defines the entries of the SunRsaSign provider.
 *
 * @author  Andreas Sterbenz
 */
public final class SunRsaSignEntries {

    private SunRsaSignEntries() {
        // empty
    }

    public static void putEntries(Map<Object, Object> map) {

        // main algorithms
        map.put("KeyFactory.RSA",
                "sun.security.rsa.RSAKeyFactory$Legacy");
        map.put("KeyPairGenerator.RSA",
                "sun.security.rsa.RSAKeyPairGenerator$Legacy");
        map.put("Signature.MD2withRSA",
                "sun.security.rsa.RSASignature$MD2withRSA");
        map.put("Signature.MD5withRSA",
                "sun.security.rsa.RSASignature$MD5withRSA");
        map.put("Signature.SHA1withRSA",
                "sun.security.rsa.RSASignature$SHA1withRSA");
        map.put("Signature.SHA224withRSA",
                "sun.security.rsa.RSASignature$SHA224withRSA");
        map.put("Signature.SHA256withRSA",
                "sun.security.rsa.RSASignature$SHA256withRSA");
        map.put("Signature.SHA384withRSA",
                "sun.security.rsa.RSASignature$SHA384withRSA");
        map.put("Signature.SHA512withRSA",
                "sun.security.rsa.RSASignature$SHA512withRSA");
        map.put("Signature.SHA512/224withRSA",
                "sun.security.rsa.RSASignature$SHA512_224withRSA");
        map.put("Signature.SHA512/256withRSA",
                "sun.security.rsa.RSASignature$SHA512_256withRSA");

        map.put("KeyFactory.RSASSA-PSS",
                "sun.security.rsa.RSAKeyFactory$PSS");
        map.put("KeyPairGenerator.RSASSA-PSS",
                "sun.security.rsa.RSAKeyPairGenerator$PSS");
        map.put("Signature.RSASSA-PSS",
                "sun.security.rsa.RSAPSSSignature");
        map.put("AlgorithmParameters.RSASSA-PSS",
                "sun.security.rsa.PSSParameters");

        // attributes for supported key classes
        String rsaKeyClasses = "java.security.interfaces.RSAPublicKey" +
                "|java.security.interfaces.RSAPrivateKey";
        map.put("Signature.MD2withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.MD5withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA1withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA224withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA256withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA384withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA512withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA512/224withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.SHA512/256withRSA SupportedKeyClasses", rsaKeyClasses);
        map.put("Signature.RSASSA-PSS SupportedKeyClasses", rsaKeyClasses);

        // aliases
        map.put("Alg.Alias.KeyFactory.1.2.840.113549.1.1",     "RSA");
        map.put("Alg.Alias.KeyFactory.OID.1.2.840.113549.1.1", "RSA");

        map.put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1",     "RSA");
        map.put("Alg.Alias.KeyPairGenerator.OID.1.2.840.113549.1.1", "RSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.2",     "MD2withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.2", "MD2withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.4",     "MD5withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.4", "MD5withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.5",     "SHA1withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.5", "SHA1withRSA");
        map.put("Alg.Alias.Signature.1.3.14.3.2.29",            "SHA1withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.14",     "SHA224withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.14", "SHA224withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.11",     "SHA256withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.11", "SHA256withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.12",     "SHA384withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.12", "SHA384withRSA");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.13",     "SHA512withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.13", "SHA512withRSA");
        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.15",     "SHA512/224withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.15", "SHA512/224withRSA");
        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.16",     "SHA512/256withRSA");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.16", "SHA512/256withRSA");

        map.put("Alg.Alias.KeyFactory.1.2.840.113549.1.1.10",     "RSASSA-PSS");
        map.put("Alg.Alias.KeyFactory.OID.1.2.840.113549.1.1.10", "RSASSA-PSS");

        map.put("Alg.Alias.KeyPairGenerator.1.2.840.113549.1.1.10",     "RSASSA-PSS");
        map.put("Alg.Alias.KeyPairGenerator.OID.1.2.840.113549.1.1.10", "RSASSA-PSS");

        map.put("Alg.Alias.Signature.1.2.840.113549.1.1.10",     "RSASSA-PSS");
        map.put("Alg.Alias.Signature.OID.1.2.840.113549.1.1.10", "RSASSA-PSS");

        map.put("Alg.Alias.AlgorithmParameters.1.2.840.113549.1.1.10",     "RSASSA-PSS");
        map.put("Alg.Alias.AlgorithmParameters.OID.1.2.840.113549.1.1.10", "RSASSA-PSS");
    }
}
