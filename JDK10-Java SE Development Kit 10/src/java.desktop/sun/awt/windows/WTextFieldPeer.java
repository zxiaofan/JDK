/*
 * Copyright (c) 1996, 2013, Oracle and/or its affiliates. All rights reserved.
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

package sun.awt.windows;

import java.awt.*;
import java.awt.peer.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.im.InputMethodRequests;

final class WTextFieldPeer extends WTextComponentPeer implements TextFieldPeer {

    // WComponentPeer overrides

    @Override
    public Dimension getMinimumSize() {
        FontMetrics fm = getFontMetrics(((TextField)target).getFont());
        return new Dimension(fm.stringWidth(getText()) + 24,
                             fm.getHeight() + 8);
    }

    @Override
    @SuppressWarnings("deprecation")
    public boolean handleJavaKeyEvent(KeyEvent e) {
        switch (e.getID()) {
           case KeyEvent.KEY_TYPED:
               if ((e.getKeyChar() == '\n') && !e.isAltDown() && !e.isControlDown()) {
                    postEvent(new ActionEvent(target, ActionEvent.ACTION_PERFORMED,
                                              getText(), e.getWhen(), e.getModifiers()));
                    return true;
               }
           break;
        }
        return false;
    }

    // TextFieldPeer implementation

    @Override
    public native void setEchoChar(char echoChar);

    @Override
    public Dimension getPreferredSize(int cols) {
        return getMinimumSize(cols);
    }

    @Override
    public Dimension getMinimumSize(int cols) {
        FontMetrics fm = getFontMetrics(((TextField)target).getFont());
        return new Dimension(fm.charWidth('0') * cols + 24, fm.getHeight() + 8);
    }

    @Override
    public InputMethodRequests getInputMethodRequests() {
        return null;
    }

    // Toolkit & peer internals

    WTextFieldPeer(TextField target) {
        super(target);
    }

    @Override
    native void create(WComponentPeer parent);

    @Override
    void initialize() {
        TextField tf = (TextField)target;
        if (tf.echoCharIsSet()) {
            setEchoChar(tf.getEchoChar());
        }
        super.initialize();
    }
}
