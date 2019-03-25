/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * HPACK (Header Compression for HTTP/2) implementation conforming to
 * <a href="https://tools.ietf.org/html/rfc7541">RFC&nbsp;7541</a>.
 *
 * <p> Headers can be decoded and encoded by {@link jdk.internal.net.http.hpack.Decoder}
 * and {@link jdk.internal.net.http.hpack.Encoder} respectively.
 *
 * <p> Instances of these classes are not safe for use by multiple threads.
 */
package jdk.internal.net.http.hpack;
