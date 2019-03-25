/*
 * Copyright (c) 1998, 2017, Oracle and/or its affiliates. All rights reserved.
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
 * Provides classes for creating and modifying images. Images are processed
 * using a streaming framework that involves an image producer, optional image
 * filters, and an image consumer. This framework makes it possible to
 * progressively render an image while it is being fetched and generated.
 * Moreover, the framework allows an application to discard the storage used by
 * an image and to regenerate it at any time. This package provides a number of
 * image producers, consumers, and filters that you can configure for your image
 * processing needs.
 *
 * @since 1.0
 */
package java.awt.image;
