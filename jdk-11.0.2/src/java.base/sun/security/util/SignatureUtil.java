/*
 * Copyright (c) 2018, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.security.*;
import java.security.spec.*;
import sun.security.util.ObjectIdentifier;
import sun.security.x509.AlgorithmId;
import sun.security.rsa.RSAUtil;

/**
 * Utility class for Signature related operations. Currently used by various
 * internal PKI classes such as sun.security.x509.X509CertImpl,
 * sun.security.pkcs.SignerInfo, for setting signature parameters.
 *
 * @since   11
 */
public class SignatureUtil {

    // Utility method of creating an AlgorithmParameters object with
    // the specified algorithm name and encoding
    private static AlgorithmParameters createAlgorithmParameters(String algName,
            byte[] paramBytes) throws ProviderException {

        try {
            AlgorithmParameters result =
                AlgorithmParameters.getInstance(algName);
            result.init(paramBytes);
            return result;
        } catch (NoSuchAlgorithmException | IOException e) {
            throw new ProviderException(e);
        }
    }

    private static AlgorithmParameterSpec getParamSpec(String sigName,
            AlgorithmParameters params)
            throws InvalidAlgorithmParameterException, ProviderException {

        if (params == null) return null;

        if (sigName.toUpperCase().indexOf("RSA") == -1) {
            throw new ProviderException
                 ("Unrecognized algorithm for signature parameters " +
                  sigName);
        }
        // AlgorithmParameters.getAlgorithm() may returns oid if it's
        // created during DER decoding. Convert to use the standard name
        // before passing it to RSAUtil
        String alg = params.getAlgorithm();
        if (alg.equalsIgnoreCase(sigName) || alg.indexOf(".") != -1) {
            try {
                params = createAlgorithmParameters(sigName,
                    params.getEncoded());
            } catch (IOException e) {
                throw new ProviderException(e);
            }
        }
        return RSAUtil.getParamSpec(params);
    }

    // Special method for setting the specified parameter bytes into the
    // specified Signature object as signature parameters.
    public static void specialSetParameter(Signature sig, byte[] paramBytes)
            throws InvalidAlgorithmParameterException, ProviderException {

        AlgorithmParameters params = null;
        if (paramBytes != null) {
            String sigName = sig.getAlgorithm();
            params = createAlgorithmParameters(sigName, paramBytes);
        }
        specialSetParameter(sig, params);
    }

    // Special method for setting the specified AlgorithmParameter object
    // into the specified Signature object as signature parameters.
    public static void specialSetParameter(Signature sig,
            AlgorithmParameters params)
            throws InvalidAlgorithmParameterException, ProviderException {

        String sigName = sig.getAlgorithm();
        if (params != null) {
            sig.setParameter(getParamSpec(sigName, params));
        } else {
            try {
                sig.setParameter(null);
            } catch (UnsupportedOperationException e) {
                // ignore for maintaining backward compatibility
            }
        }
    }
}
