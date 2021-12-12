/*
 * Copyright (c) 2016, 2020, Oracle and/or its affiliates. All rights reserved.
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

import java.security.Key;
import java.util.Date;
import java.util.Set;

/**
 * This interface contains parameters for checking against constraints that
 * extend past the publicly available parameters in
 * java.security.AlgorithmConstraints.
 */
public interface ConstraintsParameters {

    /**
     * Returns true if a certificate chains back to a trusted JDK root CA.
     */
    boolean anchorIsJdkCA();

    /**
     * Returns the set of keys that should be checked against the
     * constraints, or an empty set if there are no keys to be checked.
     */
    Set<Key> getKeys();

    /**
     * Returns the date that should be checked against the constraints, or
     * null if not set.
     */
    Date getDate();

    /**
     * Returns the Validator variant.
     */
    String getVariant();

    /**
     * Returns an extended message used in exceptions. See
     * DisabledAlgorithmConstraints for usage.
     */
    String extendedExceptionMsg();
}
