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
 * Provides user interface objects that combine two or more look and feels. When
 * a component asks for its UI, this look and feel returns a multiplexing UI
 * that handles all communications with both the default look and feel and one
 * or more auxiliary look and feels. For example, if a user combines an
 * auxiliary audio look and feel with the Motif look and feel, the
 * {@code JButton.getUI} method would return an instance of
 * {@code MultiButtonUI}, which would handle both a {@code MotifButtonUI} and an
 * {@code AudioButtonUI}.
 * <p>
 * For more information, see
 * <a href="doc-files/multi_tsc.html" target="_top">
 *     Using the Multiplexing Look and Feel.</a>
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
package javax.swing.plaf.multi;
