/*
 * %W% %E%
 *
 * Copyright (c) 2006, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package java.awt.peer;

import java.awt.Dimension;

/**
 * The peer interfaces are intended only for use in porting
 * the AWT. They are not intended for use by application
 * developers, and developers should not implement peers
 * nor invoke any of the peer methods directly on the peer
 * instances.
 */
public interface TextFieldPeer extends TextComponentPeer {
    void setEchoChar(char echoChar);
    Dimension getPreferredSize(int columns);
    Dimension getMinimumSize(int columns);

    /**
     * DEPRECATED:  Replaced by setEchoChar(char echoChar).
     */
    void setEchoCharacter(char c);

    /**
     * DEPRECATED:  Replaced by getPreferredSize(int).
     */
    Dimension preferredSize(int cols);

    /**
     * DEPRECATED:  Replaced by getMinimumSize(int).
     */
    Dimension minimumSize(int cols);
}
