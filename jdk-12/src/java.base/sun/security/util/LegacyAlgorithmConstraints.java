/*
 * Copyright (c) 2015, 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.security.AlgorithmParameters;
import java.security.CryptoPrimitive;
import java.security.Key;
import java.util.Set;
import static sun.security.util.AbstractAlgorithmConstraints.getAlgorithms;

/**
 * Algorithm constraints for legacy algorithms.
 */
public class LegacyAlgorithmConstraints extends AbstractAlgorithmConstraints {

    // the known security property, jdk.tls.legacyAlgorithms
    public static final String PROPERTY_TLS_LEGACY_ALGS =
            "jdk.tls.legacyAlgorithms";

    private final String[] legacyAlgorithms;

    public LegacyAlgorithmConstraints(String propertyName,
            AlgorithmDecomposer decomposer) {
        super(decomposer);
        legacyAlgorithms = getAlgorithms(propertyName);
    }

    @Override
    public final boolean permits(Set<CryptoPrimitive> primitives,
            String algorithm, AlgorithmParameters parameters) {
        return checkAlgorithm(legacyAlgorithms, algorithm, decomposer);
    }

    @Override
    public final boolean permits(Set<CryptoPrimitive> primitives, Key key) {
        return true;
    }

    @Override
    public final boolean permits(Set<CryptoPrimitive> primitives,
            String algorithm, Key key, AlgorithmParameters parameters) {
        return checkAlgorithm(legacyAlgorithms, algorithm, decomposer);
    }

}
