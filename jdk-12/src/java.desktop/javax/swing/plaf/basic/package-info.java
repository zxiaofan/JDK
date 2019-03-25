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
 * Provides user interface objects built according to the Basic look and feel.
 * The Basic look and feel provides default behavior used by many look and feel
 * packages. It contains components, layout managers, events, event listeners,
 * and adapters. You can subclass the classes in this package to create your own
 * customized look and feel.
 * <p>
 * These classes are designed to be used while the corresponding
 * {@code LookAndFeel} class has been installed
 * (<code>UIManager.setLookAndFeel(new <i>XXX</i>LookAndFeel())</code>).
 * Using them while a different {@code LookAndFeel} is installed may produce
 * unexpected results, including exceptions. Additionally, changing the
 * {@code LookAndFeel} maintained by the {@code UIManager} without updating the
 * corresponding {@code ComponentUI} of any {@code JComponent}s may also produce
 * unexpected results, such as the wrong colors showing up, and is generally not
 * encouraged.
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
package javax.swing.plaf.basic;
