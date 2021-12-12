/*
 * Copyright (c) 2015, 2020, Oracle and/or its affiliates. All rights reserved.
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
 * This package comprises the interfaces and classes used to define the
 * signing mechanism used by the {@code jarsigner} tool.
 * <p>
 * Clients may override the default signing mechanism of the {@code jarsigner}
 * tool by supplying an alternative implementation of
 * {@link com.sun.jarsigner.ContentSigner}.
 *
 * The classes in this package have been deprecated and will be removed in
 * a future release. New classes should not be added to this package.
 * Use the {@link jdk.security.jarsigner.JarSigner} API to sign JAR files.
 */

package com.sun.jarsigner;
