/*
 * Copyright (c) 2000, 2003, Oracle and/or its affiliates. All rights reserved.
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

import java.util.List;
import java.util.Map;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Represents non-concrete (that is, native or abstract) methods.
 * Private to MethodImpl.
 */
public class NonConcreteMethodImpl extends MethodImpl {

    private Location location = null;

    NonConcreteMethodImpl(VirtualMachine vm,
                          ReferenceTypeImpl declaringType,
                          long ref,
                          String name, String signature,
                          String genericSignature, int modifiers) {

        // The generic signature is set when this is created
        super(vm, declaringType, ref, name, signature,
              genericSignature, modifiers);
    }

    public Location location() {
        if (isAbstract()) {
            return null;
        }
        if (location == null) {
            location = new LocationImpl(vm, this, -1);
        }
        return location;
    }

    public List<Location> allLineLocations(String stratumID,
                                 String sourceName) {
        return new ArrayList<Location>(0);
    }

    public List<Location> allLineLocations(SDE.Stratum stratum,
                                 String sourceName) {
        return new ArrayList<Location>(0);
    }

    public List<Location> locationsOfLine(String stratumID,
                                String sourceName,
                                int lineNumber) {
        return new ArrayList<Location>(0);
    }

    public List<Location> locationsOfLine(SDE.Stratum stratum,
                                String sourceName,
                                int lineNumber) {
        return new ArrayList<Location>(0);
    }

    public Location locationOfCodeIndex(long codeIndex) {
        return null;
    }

    public List<LocalVariable> variables() throws AbsentInformationException {
        throw new AbsentInformationException();
    }

    public List<LocalVariable> variablesByName(String name) throws AbsentInformationException {
        throw new AbsentInformationException();
    }

    public List<LocalVariable> arguments() throws AbsentInformationException {
        throw new AbsentInformationException();
    }

    public byte[] bytecodes() {
        return new byte[0];
    }

    int argSlotCount() throws AbsentInformationException {
        throw new InternalException("should not get here");
    }
}
