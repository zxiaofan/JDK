/*
 * Copyright (c) 1998, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Provides classes and interfaces for key specifications and algorithm
 * parameter specifications.
 *
 * <p>A key specification is a transparent representation of the key material
 * that constitutes a key. A key may be specified in an algorithm-specific
 * way, or in an algorithm-independent encoding format (such as ASN.1).
 * This package contains key specifications for DSA public and private keys,
 * RSA public and private keys, PKCS #8 private keys in DER-encoded format,
 * and X.509 public and private keys in DER-encoded format.
 *
 * <p>An algorithm parameter specification is a transparent representation
 * of the sets of parameters used with an algorithm. This package contains
 * an algorithm parameter specification for parameters used with the
 * DSA algorithm.
 *
 * <h2>Package Specification</h2>
 *
 * <ul>
 *   <li>PKCS #1: RSA Cryptography Specifications, Version 2.2 (RFC 8017)</li>
 *   <li>PKCS #8: Private-Key Information Syntax Standard,
 *     Version 1.2, November 1993</li>
 *   <li>Federal Information Processing Standards Publication (FIPS PUB) 186:
 *     Digital Signature Standard (DSS)</li>
 * </ul>
 *
 * <h2>Related Documentation</h2>
 *
 * For documentation that includes information about algorithm parameter
 * and key specifications, please see:
 * <ul>
 *   <li> {@extLink security_guide_jca
 *       Java Cryptography Architecture (JCA) Reference Guide}</li>
 *   <li> {@extLink security_guide_impl_provider
 *       How to Implement a Provider in the Java Cryptography Architecture}</li>
 * </ul>
 *
 * @since 1.2
 */
package java.security.spec;
