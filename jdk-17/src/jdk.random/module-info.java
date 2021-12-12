/*
 * Copyright (c) 2020, Oracle and/or its affiliates. All rights reserved.
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

import jdk.internal.util.random.RandomSupport;

/**
 * Defines implementations of the
 * {@linkplain java.util.random.RandomGenerator RandomGenerator Interface}.
 *
 * @provides jdk.random.L128X1024MixRandom
 * @provides jdk.random.L128X128MixRandom
 * @provides jdk.random.L128X256MixRandom
 * @provides jdk.random.L32X64MixRandom
 * @provides jdk.random.L64X1024MixRandom
 * @provides jdk.random.L64X128MixRandom
 * @provides jdk.random.L64X128StarStarRandom
 * @provides jdk.random.L64X256MixRandom
 * @provides jdk.random.Xoroshiro128PlusPlus
 * @provides jdk.random.Xoshiro256PlusPlus
 *
 * @use java.util.random.RandomGenerator
 * @use jdk.internal.util.random.RandomSupport
 *
 * @moduleGraph
 * @since 16
 */
module jdk.random {
    exports jdk.random to
            java.base;

    provides java.util.random.RandomGenerator with
        jdk.random.L32X64MixRandom,
        jdk.random.L64X128MixRandom,
        jdk.random.L64X128StarStarRandom,
        jdk.random.L64X256MixRandom,
        jdk.random.L64X1024MixRandom,
        jdk.random.L128X128MixRandom,
        jdk.random.L128X256MixRandom,
        jdk.random.L128X1024MixRandom,
        jdk.random.Xoroshiro128PlusPlus,
        jdk.random.Xoshiro256PlusPlus;
}
