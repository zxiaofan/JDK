/*
 * Copyright (c) 1999, 2014, Oracle and/or its affiliates. All rights reserved.
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

import java.util.EventListener;

/**
 * The {@code ControllerEventListener} interface should be implemented by
 * classes whose instances need to be notified when a {@link Sequencer} has
 * processed a requested type of MIDI control-change event. To register a
 * {@code ControllerEventListener} object to receive such notifications, invoke
 * the
 * {@link Sequencer#addControllerEventListener(ControllerEventListener, int[])
 * addControllerEventListener} method of {@code Sequencer}, specifying the types
 * of MIDI controllers about which you are interested in getting control-change
 * notifications.
 *
 * @author Kara Kytle
 * @see MidiChannel#controlChange(int, int)
 */
public interface ControllerEventListener extends EventListener {

    /**
     * Invoked when a {@link Sequencer} has encountered and processed a
     * control-change event of interest to this listener. The event passed in is
     * a {@code ShortMessage} whose first data byte indicates the controller
     * number and whose second data byte is the value to which the controller
     * was set.
     *
     * @param  event the control-change event that the sequencer encountered in
     *         the sequence it is processing
     * @see Sequencer#addControllerEventListener(ControllerEventListener, int[])
     * @see MidiChannel#controlChange(int, int)
     * @see ShortMessage#getData1
     * @see ShortMessage#getData2
     */
    void controlChange(ShortMessage event);
}
