/*
 * Copyright (c) 2011, 2019, Oracle and/or its affiliates. All rights reserved.
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
package java.nio.charset;

/**
 * Constant definitions for the standard {@link Charset charsets}. These
 * charsets are guaranteed to be available on every implementation of the Java
 * platform.
 *
 * @see <a href="Charset.html#standard">Standard Charsets</a>
 * @since 1.7
 */
public final class StandardCharsets {

    // To avoid accidental eager initialization of often unused Charsets
    // from happening while the VM is booting up, which may delay
    // initialization of VM components, we should generally avoid depending
    // on this class from elsewhere in java.base.

    private StandardCharsets() {
        throw new AssertionError("No java.nio.charset.StandardCharsets instances for you!");
    }

    /**
     * Seven-bit ASCII, also known as ISO646-US, also known as the
     * Basic Latin block of the Unicode character set.
     */
    public static final Charset US_ASCII = sun.nio.cs.US_ASCII.INSTANCE;

    /**
     * ISO Latin Alphabet {@literal No. 1}, also known as ISO-LATIN-1.
     */
    public static final Charset ISO_8859_1 = sun.nio.cs.ISO_8859_1.INSTANCE;

    /**
     * Eight-bit UCS Transformation Format.
     */
    public static final Charset UTF_8 = sun.nio.cs.UTF_8.INSTANCE;

    /**
     * Sixteen-bit UCS Transformation Format, big-endian byte order.
     */
    public static final Charset UTF_16BE = new sun.nio.cs.UTF_16BE();

    /**
     * Sixteen-bit UCS Transformation Format, little-endian byte order.
     */
    public static final Charset UTF_16LE = new sun.nio.cs.UTF_16LE();

    /**
     * Sixteen-bit UCS Transformation Format, byte order identified by an
     * optional byte-order mark.
     */
    public static final Charset UTF_16 = new sun.nio.cs.UTF_16();
}
