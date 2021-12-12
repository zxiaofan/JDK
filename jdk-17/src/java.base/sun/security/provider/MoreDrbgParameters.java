/*
 * Copyright (c) 2016, 2019, Oracle and/or its affiliates. All rights reserved.
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

import java.io.IOException;
import java.io.Serializable;
import java.security.DrbgParameters;
import java.security.SecureRandomParameters;

/**
 * Exported and non-exported parameters that can be used by DRBGs.
 */
public class MoreDrbgParameters implements SecureRandomParameters, Serializable {

    @java.io.Serial
    private static final long serialVersionUID = 9L;

    final transient EntropySource es;

    final String mech;
    final String algorithm;
    final boolean usedf;
    final int strength;
    final DrbgParameters.Capability capability;

    // The following 2 fields will be reassigned in readObject and
    // thus cannot be final
    byte[] nonce;
    byte[] personalizationString;

    /**
     * Creates a new {@code MoreDrbgParameters} object.
     *
     * @param es the {@link EntropySource} to use. If set to {@code null},
     *           a default entropy source will be used.
     * @param mech mech name. If set to {@code null}, the one in
     *             securerandom.drbg.config is used. This argument is ignored
     *             when passing to HashDrbg/HmacDrbg/CtrDrbg.
     * @param algorithm the requested algorithm to use. If set to {@code null},
     *                  the algorithm will be decided by strength.
     * @param nonce the nonce to use. If set to {@code null},
     *              a nonce will be assigned.
     * @param usedf whether a derivation function should be used
     * @param config a {@link DrbgParameters.Instantiation} object
     */
    public MoreDrbgParameters(EntropySource es, String mech,
                              String algorithm, byte[] nonce, boolean usedf,
                              DrbgParameters.Instantiation config) {
        this.mech = mech;
        this.algorithm = algorithm;
        this.es = es;
        this.nonce = (nonce == null) ? null : nonce.clone();
        this.usedf = usedf;

        this.strength = config.getStrength();
        this.capability = config.getCapability();
        this.personalizationString = config.getPersonalizationString();
    }

    @Override
    public String toString() {
        return mech + "," + algorithm + "," + usedf + "," + strength
                + "," + capability + "," + personalizationString;
    }

    @java.io.Serial
    private void readObject(java.io.ObjectInputStream s)
            throws IOException, ClassNotFoundException {
        s.defaultReadObject();
        if (nonce != null) {
            nonce = nonce.clone();
        }
        if (personalizationString != null) {
            personalizationString = personalizationString.clone();
        }
        if (capability == null) {
            throw new IllegalArgumentException("Input data is corrupted");
        }
    }
}
