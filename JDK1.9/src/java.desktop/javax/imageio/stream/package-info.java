/*
 * Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * A package of the Java Image I/O API dealing with low-level I/O from files and
 * streams.
 * <p>
 * The {@code ImageInputStream} interface unifies streaming and file-based
 * operations. An abstract base class, {@code ImageInputStreamImpl} is provided
 * to simplify writing a new {@code ImageInputStream} class. Concrete
 * implementation classes ({@code FileImageInputStream},
 * {@code FileCacheImageInputStream}, and {@code MemoryCacheImageInputStream})
 * are provided that allow input to come from a {@code File} or
 * {@code InputStream} with or without the use of a temporary cache file.
 * <p>
 * The {@code ImageOutputStream} interface performs an analogous function for
 * output. An abstract base class, {@code ImageOutputStreamImpl} is provided,
 * along with concrete implementation classes ({@code FileImageOutputStream},
 * {@code FileCacheImageOutputStream}, and {@code MemoryCacheImageOutputStream})
 * are provided that allow output to go to a {@code File} or
 * {@code OutputStream} with or without the use of a temporary cache file.
 * <p>
 * The {@code IIOByteBuffer} class provides an alternative way to perform reads
 * of sequences of bytes that reduces the amount of internal data copying.
 *
 * @since 1.4
 */
package javax.imageio.stream;
