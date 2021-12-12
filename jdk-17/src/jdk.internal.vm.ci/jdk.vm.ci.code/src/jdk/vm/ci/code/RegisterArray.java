/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
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

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * An immutable ordered list of registers. Only required because Java lacks immutable arrays.
 */
public final class RegisterArray implements Iterable<Register> {

    private final Register[] registers;
    private int hash;

    public RegisterArray(Register... registers) {
        this.registers = registers;
    }

    public RegisterArray(Collection<Register> registers) {
        this.registers = registers.toArray(new Register[registers.size()]);
    }

    /**
     * Gets the number of registers.
     */
    public int size() {
        return registers.length;
    }

    /**
     * Gets the register at a given index.
     *
     * @param index the index of the register to retrieve
     */
    public Register get(int index) {
        return registers[index];
    }

    public void addTo(Collection<Register> collection) {
        collection.addAll(Arrays.asList(registers));
    }

    /**
     * Gets an immutable view of the registers as a list.
     */
    public List<Register> asList() {
        return Collections.unmodifiableList(Arrays.asList(registers));
    }

    /**
     * Gets a copy of the registers as an array.
     */
    public Register[] toArray() {
        return registers.clone();
    }

    @Override
    public Iterator<Register> iterator() {
        return Arrays.asList(registers).iterator();
    }

    @Override
    public int hashCode() {
        if (hash == 0 && registers.length > 0) {
            hash = Arrays.hashCode(registers);
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RegisterArray) {
            return Arrays.equals(registers, ((RegisterArray) obj).registers);
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(registers);
    }
}
