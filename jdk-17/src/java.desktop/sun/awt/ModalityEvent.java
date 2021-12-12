/*
 * Copyright (c) 2003, 2011, Oracle and/or its affiliates. All rights reserved.
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

import java.awt.*;

/**
 * Event object describing changes in AWT modality
 */
@SuppressWarnings("serial")
public class ModalityEvent extends AWTEvent implements ActiveEvent {

    public static final int MODALITY_PUSHED = 1300;
    public static final int MODALITY_POPPED = 1301;

    private ModalityListener listener;

    public ModalityEvent(Object source, ModalityListener listener, int id) {
        super(source, id);
        this.listener = listener;
    }

    public void dispatch() {
        switch(getID()) {
            case MODALITY_PUSHED:
                listener.modalityPushed(this);
                break;

            case MODALITY_POPPED:
                listener.modalityPopped(this);
                break;

            default:
                throw new Error("Invalid event id.");
        }
    }

}
