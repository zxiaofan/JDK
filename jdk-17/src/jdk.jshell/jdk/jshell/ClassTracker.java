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
 *
 *
 */
package jdk.jshell;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;
import jdk.jshell.spi.ExecutionControl.ClassBytecodes;

/**
 * Tracks the state of a class.
 */
class ClassTracker {

    private final HashMap<String, ClassInfo> map;

    ClassTracker() {
        this.map = new HashMap<>();
    }

    /**
     * Associates a class name, class bytes (current and loaded).
     */
    class ClassInfo {

        // The name of the class
        private final String className;

        // The corresponding compiled class bytes when a load or redefine
        // is started.  May not be the loaded bytes.  May be null.
        private byte[] currentBytes;

        // The class bytes successfully loaded/redefined into the remote VM.
        private byte[] loadedBytes;

        private ClassInfo(String className) {
            this.className = className;
        }

        String getClassName() {
            return className;
        }

        byte[] getLoadedBytes() {
            return loadedBytes;
        }

        byte[] getCurrentBytes() {
            return currentBytes;
        }

        void setCurrentBytes(byte[] bytes) {
            this.currentBytes = bytes;
        }

        void setLoadedBytes(byte[] bytes) {
            this.loadedBytes = bytes;
        }

        boolean isLoaded() {
            return loadedBytes != null;
        }

        boolean isCurrent() {
            return Arrays.equals(currentBytes, loadedBytes);
        }

        ClassBytecodes toClassBytecodes() {
            return new ClassBytecodes(className, currentBytes);
        }

            @Override
        public boolean equals(Object o) {
            return o instanceof ClassInfo
                    && ((ClassInfo) o).className.equals(className);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this.className);
        }
    }

    void markLoaded(ClassBytecodes[] cbcs) {
        for (ClassBytecodes cbc : cbcs) {
            get(cbc.name()).setLoadedBytes(cbc.bytecodes());
        }
    }

    void markLoaded(ClassBytecodes[] cbcs, boolean[] isLoaded) {
        for (int i = 0; i < cbcs.length; ++i) {
            if (isLoaded[i]) {
                ClassBytecodes cbc = cbcs[i];
                get(cbc.name()).setLoadedBytes(cbc.bytecodes());
            }
        }
    }

    // Map a class name to the current compiled class bytes.
    void setCurrentBytes(String className, byte[] bytes) {
        ClassInfo ci = get(className);
        ci.setCurrentBytes(bytes);
    }

    // Lookup the ClassInfo by class name, create if it does not exist.
    ClassInfo get(String className) {
        return map.computeIfAbsent(className, ClassInfo::new);
    }
}
