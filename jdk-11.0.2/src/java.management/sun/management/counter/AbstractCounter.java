/*
 * Copyright (c) 2003, 2004, Oracle and/or its affiliates. All rights reserved.
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

package sun.management.counter;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 */
public abstract class AbstractCounter implements Counter {

    String name;
    Units units;
    Variability variability;
    int flags;
    int vectorLength;

    // Flags defined in hotspot implementation
    class Flags {
        static final int SUPPORTED = 0x1;
    }

    protected AbstractCounter(String name, Units units,
                              Variability variability, int flags,
                              int vectorLength) {
        this.name = name;
        this.units = units;
        this.variability = variability;
        this.flags = flags;
        this.vectorLength = vectorLength;
    }

    protected AbstractCounter(String name, Units units,
                              Variability variability, int flags) {
        this(name, units, variability, flags, 0);
    }

    /**
     * Returns the name of the Performance Counter
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the Units for this Performance Counter
     */
    public Units getUnits() {
        return units;
    }

    /**
     * Returns the Variability for this performance Object
     */
    public Variability getVariability() {
        return variability;
    }

    /**
     * Return true if this performance counter is a vector
     */
    public boolean isVector() {
        return vectorLength > 0;
    }

    /**
     * return the length of the vector
     */
    public int getVectorLength() {
        return vectorLength;
    }

    public boolean isInternal() {
        return (flags & Flags.SUPPORTED) == 0;
    }

    /**
     * return the flags associated with the counter.
     */
    public int getFlags() {
        return flags;
    }

    public abstract Object getValue();

    public String toString() {
        String result = getName() + ": " + getValue() + " " + getUnits();
        if (isInternal()) {
            return result + " [INTERNAL]";
        } else {
            return result;
        }
    }

    private static final long serialVersionUID = 6992337162326171013L;

}
