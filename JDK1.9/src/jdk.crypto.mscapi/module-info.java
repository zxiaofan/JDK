/*
 * Copyright (c) 2014, 2017, Oracle and/or its affiliates. All rights reserved.
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

/**
 * Provides the implementation of the SunMSCAPI security provider.
 *
 * @provides java.security.Provider
 * @moduleGraph
 * @since 9
 */
module jdk.crypto.mscapi {
    provides java.security.Provider with sun.security.mscapi.SunMSCAPI;
}

