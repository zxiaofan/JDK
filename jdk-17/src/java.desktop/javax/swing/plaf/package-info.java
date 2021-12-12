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
 * Provides one interface and many abstract classes that Swing uses to provide
 * its pluggable look-and-feel capabilities. Its classes are subclassed and
 * implemented by look and feel UIs such as Basic and the Java look and feel
 * (Metal). This package is only used by developers who cannot create a new
 * look and feel by subclassing existing look-and-feel components (such as those
 * provided by the {@code javax.swing.plaf.basic} and
 * {@code javax.swing.plaf.metal} packages).
 * <p>
 * <strong>Note:</strong>
 * Most of the Swing API is <em>not</em> thread safe. For details, see
 * <a
 * href="https://docs.oracle.com/javase/tutorial/uiswing/concurrency/index.html"
 * target="_top">Concurrency in Swing</a>,
 * a section in
 * <em><a href="https://docs.oracle.com/javase/tutorial/"
 * target="_top">The Java Tutorial</a></em>.
 *
 * @since 1.2
 * @serial exclude
 */
package javax.swing.plaf;
