/*
 * Copyright (c) 2014, 2015, Oracle and/or its affiliates. All rights reserved.
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
 * Provides {@link java.nio.charset.Charset charsets} that
 * are not in {@code java.base} (mostly double byte and IBM charsets).
 *
 * @provides java.nio.charset.spi.CharsetProvider
 *
 * @moduleGraph
 * @since 9
 */
module jdk.charsets {
    provides java.nio.charset.spi.CharsetProvider with
        sun.nio.cs.ext.ExtendedCharsets;
}
