/*
 * Copyright (c) 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.prism;

/**
 * A tagging interface to be implemented by any Graphics that
 * supports printing.
 * <p>
 * This maybe useful to know that you are printing but its initial purpose
 * is that it should be used to decide whether to do things like caching.
 * <p>
 * Existing code that does caching of shapes, textures
 * or other resources that assumes there is only ever a single
 * destination, and so cache an object that can only be used with
 * a specific graphics pipeline.
 * <p>
 * So if a Graphics is tagged with this interface, do not do cache
 * lookup, nor store in a cache.
 */
public interface PrinterGraphics {
}
