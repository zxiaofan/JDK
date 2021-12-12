/*
 * Copyright (c) 1999, 2018, Oracle and/or its affiliates. All rights reserved.
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
 * Supplies interfaces for service providers to implement when offering new MIDI
 * devices, MIDI file readers and writers, or sound bank readers.
 *
 * <h2>Related Documentation</h2>
 * For more information on using Java Sound see:
 * <ul>
 *   <li><a href="https://docs.oracle.com/javase/tutorial/sound/">
 *   The Java Sound Tutorial</a>
 * </ul>
 * Please note: In the {@code javax.sound.midi.spi} APIs, a {@code null}
 * reference parameter to methods is incorrect unless explicitly documented on
 * the method as having a meaningful interpretation. Usage to the contrary is
 * incorrect coding and may result in a run time exception either immediately or
 * at some later time. {@code NullPointerException} is an example of typical and
 * acceptable run time exception for such cases.
 *
 * @since 1.3
 */
package javax.sound.midi.spi;
