/*
 * Copyright (c) 1996, 2014, Oracle and/or its affiliates. All rights reserved.
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
import java.awt.im.InputMethodRequests;


final class WTextAreaPeer extends WTextComponentPeer implements TextAreaPeer {

    // WComponentPeer overrides

    @Override
    public Dimension getMinimumSize() {
        return getMinimumSize(10, 60);
    }

    // TextAreaPeer implementation

    @Override
    public void insert(String text, int pos) {
        replaceRange(text, pos, pos);
    }

    @Override
    public native void replaceRange(String text, int start, int end);

    @Override
    public Dimension getPreferredSize(int rows, int cols) {
        return getMinimumSize(rows, cols);
    }

    @Override
    public Dimension getMinimumSize(int rows, int cols) {
        FontMetrics fm = getFontMetrics(((TextArea)target).getFont());
        return new Dimension(fm.charWidth('0') * cols + 20, fm.getHeight() * rows + 20);
    }

    @Override
    public InputMethodRequests getInputMethodRequests() {
           return null;
    }

    // Toolkit & peer internals

    WTextAreaPeer(TextArea target) {
        super(target);
    }

    @Override
    native void create(WComponentPeer parent);
}
