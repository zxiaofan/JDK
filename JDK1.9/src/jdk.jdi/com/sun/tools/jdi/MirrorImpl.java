/*
 * Copyright (c) 1998, 2011, Oracle and/or its affiliates. All rights reserved.
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

package com.sun.tools.jdi;

import com.sun.jdi.*;
import java.util.Collection;
import java.util.Iterator;

abstract class MirrorImpl extends Object implements Mirror {

    protected VirtualMachineImpl vm;

    MirrorImpl(VirtualMachine aVm) {
        super();

        // Yes, its a bit of a hack. But by doing it this
        // way, this is the only place we have to change
        // typing to substitute a new impl.
        vm = (VirtualMachineImpl)aVm;
    }

    public VirtualMachine virtualMachine() {
        return vm;
    }

    public boolean equals(Object obj) {
        if ((obj != null) && (obj instanceof Mirror)) {
            Mirror other = (Mirror)obj;
            return vm.equals(other.virtualMachine());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return vm.hashCode();
    }

    /**
     * Throw NullPointerException on null mirror.
     * Throw VMMismatchException on wrong VM.
     */
    void validateMirror(Mirror mirror) {
        if (!vm.equals(mirror.virtualMachine())) {
            throw new VMMismatchException(mirror.toString());
        }
    }

    /**
     * Allow null mirror.
     * Throw VMMismatchException on wrong VM.
     */
    void validateMirrorOrNull(Mirror mirror) {
        if ((mirror != null) && !vm.equals(mirror.virtualMachine())) {
            throw new VMMismatchException(mirror.toString());
        }
    }

    /**
     * Throw NullPointerException on null mirrors.
     * Throw VMMismatchException on wrong VM.
     */
    void validateMirrors(Collection<? extends Mirror> mirrors) {
        Iterator<? extends Mirror> iter = mirrors.iterator();
        while (iter.hasNext()) {
            MirrorImpl mirror = (MirrorImpl)iter.next();
            if (!vm.equals(mirror.vm)) {
                throw new VMMismatchException(mirror.toString());
            }
        }
    }
    /**
     * Allow null mirrors.
     * Throw VMMismatchException on wrong VM.
     */
    void validateMirrorsOrNulls(Collection<? extends Mirror> mirrors) {
        Iterator<? extends Mirror> iter = mirrors.iterator();
        while (iter.hasNext()) {
            MirrorImpl mirror = (MirrorImpl)iter.next();
            if ((mirror != null) && !vm.equals(mirror.vm)) {
                throw new VMMismatchException(mirror.toString());
            }
        }
    }
}
