/*
 * Copyright (c) 2015, Oracle and/or its affiliates. All rights reserved.
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
 */
package jdk.vm.ci.code;

/**
 * Represents a location where a value can be stored. This can be either a {@link Register} or a
 * stack slot.
 */
public final class Location {

    public final Register reg;
    public final int offset;

    private Location(Register reg, int offset) {
        this.reg = reg;
        this.offset = offset;
    }

    /**
     * Create a {@link Location} for a register.
     */
    public static Location register(Register reg) {
        return new Location(reg, 0);
    }

    /**
     * Create a {@link Location} for a vector subregister.
     *
     * @param reg the {@link Register vector register}
     * @param offset the offset in bytes into the vector register
     */
    public static Location subregister(Register reg, int offset) {
        return new Location(reg, offset);
    }

    /**
     * Create a {@link Location} for a stack slot.
     */
    public static Location stack(int offset) {
        return new Location(null, offset);
    }

    public boolean isRegister() {
        return reg != null;
    }

    public boolean isStack() {
        return reg == null;
    }

    @Override
    public String toString() {
        String regName;
        if (isRegister()) {
            regName = reg.name + ":";
        } else {
            regName = "stack:";
        }
        return regName + offset;
    }
}
