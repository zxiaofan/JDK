/*
 * Copyright (c) 2007, 2013, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.media.sound;

import javax.sound.midi.Patch;

/**
 * A extended patch object that has isPercussion function.
 * Which is necessary to identify percussion instruments
 * from melodic instruments.
 *
 * @author Karl Helgason
 */
public final class ModelPatch extends Patch {

    private boolean percussion = false;

    public ModelPatch(int bank, int program) {
        super(bank, program);
    }

    public ModelPatch(int bank, int program, boolean percussion) {
        super(bank, program);
        this.percussion = percussion;
    }

    public boolean isPercussion() {
        return percussion;
    }
}
