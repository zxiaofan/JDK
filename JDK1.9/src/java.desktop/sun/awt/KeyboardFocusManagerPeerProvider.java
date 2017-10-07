/*
 * Copyright (c) 2007, 2012, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt;

import java.awt.peer.KeyboardFocusManagerPeer;

/**
 * {@link KeyboardFocusManagerPeerProvider} is required to be implemented by
 * the currently used {@link java.awt.Toolkit} instance. In order to initialize
 * {@link java.awt.KeyboardFocusManager}, a singleton instance of {@link KeyboardFocusManagerPeer}
 * is needed. To obtain that instance, the {@link #getKeyboardFocusManagerPeer}
 * method of the current toolkit is called.
 */
public interface KeyboardFocusManagerPeerProvider {

    /**
     * Gets a singleton KeyboardFocusManagerPeer instance.
     */
    KeyboardFocusManagerPeer getKeyboardFocusManagerPeer();
}
