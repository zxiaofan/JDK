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

import jdk.vm.ci.hotspot.EmptyEventProvider.EmptyCompilationEvent;
import jdk.vm.ci.hotspot.EmptyEventProvider.EmptyCompilerFailureEvent;

/**
 * Service-provider class for logging compiler related events.
 */
public interface EventProvider {

    /**
     * Creates and returns an empty implementation for {@link EventProvider}. This implementation
     * can be used when no logging is requested.
     */
    static EventProvider createEmptyEventProvider() {
        return new EmptyEventProvider();
    }

    /**
     * Creates and returns an empty implementation for {@link CompilationEvent}.
     */
    static CompilationEvent createEmptyCompilationEvent() {
        return new EmptyCompilationEvent();
    }

    /**
     * Creates and returns an empty implementation for {@link CompilationEvent}.
     */
    static CompilerFailureEvent createEmptyCompilerFailureEvent() {
        return new EmptyCompilerFailureEvent();
    }

    /**
     * An instant event is an event that is not considered to have taken any time.
     */
    public interface InstantEvent {
        /**
         * Commits the event.
         */
        void commit();

        /**
         * Determines if this particular event instance would be committed to the data stream right
         * now if application called {@link #commit()}. This in turn depends on whether the event is
         * enabled and possible other factors.
         *
         * @return if this event would be committed on a call to {@link #commit()}.
         */
        boolean shouldWrite();
    }

    /**
     * Timed events describe an operation that somehow consumes time.
     */
    public interface TimedEvent extends InstantEvent {
        /**
         * Starts the timing for this event.
         */
        void begin();

        /**
         * Ends the timing period for this event.
         */
        void end();
    }

    /**
     * Creates a new {@link CompilationEvent}.
     *
     * @return a compilation event
     */
    CompilationEvent newCompilationEvent();

    /**
     * A compilation event.
     */
    public interface CompilationEvent extends TimedEvent {
        void setMethod(String method);

        void setCompileId(int compileId);

        void setCompileLevel(int compileLevel);

        void setSucceeded(boolean succeeded);

        void setIsOsr(boolean isOsr);

        void setCodeSize(int codeSize);

        void setInlinedBytes(int inlinedBytes);
    }

    /**
     * Creates a new {@link CompilerFailureEvent}.
     *
     * @return a compiler failure event
     */
    CompilerFailureEvent newCompilerFailureEvent();

    /**
     * A compiler failure event.
     */
    public interface CompilerFailureEvent extends InstantEvent {
        void setCompileId(int compileId);

        void setMessage(String message);
    }
}
