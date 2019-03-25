/*
 * Copyright (c) 1998, 2014, Oracle and/or its affiliates. All rights reserved.
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

package javax.sound.midi;

/**
 * A {@code Soundbank} contains a set of {@code Instruments} that can be loaded
 * into a {@code Synthesizer}. Note that a Java Sound {@code Soundbank} is
 * different from a MIDI bank. MIDI permits up to 16383 banks, each containing
 * up to 128 instruments (also sometimes called programs, patches, or timbres).
 * However, a {@code Soundbank} can contain 16383 times 128 instruments, because
 * the instruments within a {@code Soundbank} are indexed by both a MIDI program
 * number and a MIDI bank number (via a {@code Patch} object). Thus, a
 * {@code Soundbank} can be thought of as a collection of MIDI banks.
 * <p>
 * {@code Soundbank} includes methods that return {@code String} objects
 * containing the sound bank's name, manufacturer, version number, and
 * description. The precise content and format of these strings is left to the
 * implementor.
 * <p>
 * Different synthesizers use a variety of synthesis techniques. A common one is
 * wavetable synthesis, in which a segment of recorded sound is played back,
 * often with looping and pitch change. The Downloadable Sound (DLS) format uses
 * segments of recorded sound, as does the Headspace Engine. {@code Soundbanks}
 * and {@code Instruments} that are based on wavetable synthesis (or other uses
 * of stored sound recordings) should typically implement the
 * {@code getResources()} method to provide access to these recorded segments.
 * This is optional, however; the method can return an zero-length array if the
 * synthesis technique doesn't use sampled sound (FM synthesis and physical
 * modeling are examples of such techniques), or if it does but the implementor
 * chooses not to make the samples accessible.
 *
 * @author David Rivas
 * @author Kara Kytle
 * @see Synthesizer#getDefaultSoundbank
 * @see Synthesizer#isSoundbankSupported
 * @see Synthesizer#loadInstruments(Soundbank, Patch[])
 * @see Patch
 * @see Instrument
 * @see SoundbankResource
 */
public interface Soundbank {

    /**
     * Obtains the name of the sound bank.
     *
     * @return a {@code String} naming the sound bank
     */
    String getName();

    /**
     * Obtains the version string for the sound bank.
     *
     * @return a {@code String} that indicates the sound bank's version
     */
    String getVersion();

    /**
     * Obtains a {@code string} naming the company that provides the sound bank.
     *
     * @return the vendor string
     */
    String getVendor();

    /**
     * Obtains a textual description of the sound bank, suitable for display.
     *
     * @return a {@code String} that describes the sound bank
     */
    String getDescription();

    /**
     * Extracts a list of non-Instrument resources contained in the sound bank.
     *
     * @return an array of resources, excluding instruments. If the sound bank
     *         contains no resources (other than instruments), returns an array
     *         of length 0.
     */
    SoundbankResource[] getResources();

    /**
     * Obtains a list of instruments contained in this sound bank.
     *
     * @return an array of the {@code Instruments} in this {@code SoundBank}. If
     *         the sound bank contains no instruments, returns an array of
     *         length 0.
     * @see Synthesizer#getLoadedInstruments
     * @see #getInstrument(Patch)
     */
    Instrument[] getInstruments();

    /**
     * Obtains an {@code Instrument} from the given {@code Patch}.
     *
     * @param  patch a {@code Patch} object specifying the bank index and
     *         program change number
     * @return the requested instrument, or {@code null} if the sound bank
     *         doesn't contain that instrument
     * @see #getInstruments
     * @see Synthesizer#loadInstruments(Soundbank, Patch[])
     */
    Instrument getInstrument(Patch patch);
}
