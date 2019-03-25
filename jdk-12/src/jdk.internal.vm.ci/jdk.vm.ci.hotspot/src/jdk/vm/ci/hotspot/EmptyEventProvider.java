/*
 * Copyright (c) 2014, Oracle and/or its affiliates. All rights reserved.
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
package jdk.vm.ci.hotspot;

/**
 * An empty implementation for {@link EventProvider}. This implementation is used when no logging is
 * requested.
 */
final class EmptyEventProvider implements EventProvider {

    static InternalError shouldNotReachHere() {
        throw new InternalError("should not reach here");
    }

    @Override
    public CompilationEvent newCompilationEvent() {
        return new EmptyCompilationEvent();
    }

    static class EmptyCompilationEvent implements CompilationEvent {
        @Override
        public void commit() {
            throw shouldNotReachHere();
        }

        @Override
        public boolean shouldWrite() {
            // Events of this class should never been written.
            return false;
        }

        @Override
        public void begin() {
        }

        @Override
        public void end() {
        }

        @Override
        public void setMethod(String method) {
            throw shouldNotReachHere();
        }

        @Override
        public void setCompileId(int compileId) {
            throw shouldNotReachHere();
        }

        @Override
        public void setCompileLevel(int compileLevel) {
            throw shouldNotReachHere();
        }

        @Override
        public void setSucceeded(boolean succeeded) {
            throw shouldNotReachHere();
        }

        @Override
        public void setIsOsr(boolean isOsr) {
            throw shouldNotReachHere();
        }

        @Override
        public void setCodeSize(int codeSize) {
            throw shouldNotReachHere();
        }

        @Override
        public void setInlinedBytes(int inlinedBytes) {
            throw shouldNotReachHere();
        }
    }

    @Override
    public CompilerFailureEvent newCompilerFailureEvent() {
        return new EmptyCompilerFailureEvent();
    }

    static class EmptyCompilerFailureEvent implements CompilerFailureEvent {
        @Override
        public void commit() {
            throw shouldNotReachHere();
        }

        @Override
        public boolean shouldWrite() {
            // Events of this class should never been written.
            return false;
        }

        @Override
        public void setCompileId(int compileId) {
            throw shouldNotReachHere();
        }

        @Override
        public void setMessage(String message) {
            throw shouldNotReachHere();
        }
    }

}
