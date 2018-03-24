/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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
package java.security;

/**
 * A marker interface for parameters used in various {@code SecureRandom}
 * methods.
 * <p>
 * Some {@code SecureRandom} implementations might require additional
 * operational parameters. Objects of classes which implement this interface
 * can be passed to those implementations that support them.
 *
 * @see DrbgParameters
 * @since 9
 */
public interface SecureRandomParameters {
}
