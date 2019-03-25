/*
 * Copyright (c) 2012, Oracle and/or its affiliates. All rights reserved.
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


package org.graalvm.compiler.debug;

import static org.graalvm.compiler.debug.DebugCloseable.VOID_CLOSEABLE;

import java.util.concurrent.TimeUnit;

import jdk.internal.vm.compiler.collections.Pair;

final class TimerKeyImpl extends AccumulatedKey implements TimerKey {
    static class FlatTimer extends AbstractKey implements TimerKey {
        private TimerKeyImpl accm;

        FlatTimer(String nameFormat, Object nameArg1, Object nameArg2) {
            super(nameFormat, nameArg1, nameArg2);
        }

        @Override
        protected String createName(String format, Object arg1, Object arg2) {
            return super.createName(format, arg1, arg2) + FLAT_KEY_SUFFIX;
        }

        @Override
        public String toHumanReadableFormat(long value) {
            return valueToString(value);
        }

        @Override
        public TimeUnit getTimeUnit() {
            return accm.getTimeUnit();
        }

        @Override
        public DebugCloseable start(DebugContext debug) {
            return accm.start(debug);
        }

        @Override
        public Pair<String, String> toCSVFormat(long value) {
            return TimerKeyImpl.toCSVFormatHelper(value);
        }

        @Override
        public TimerKey doc(String doc) {
            throw new IllegalArgumentException("Cannot set documentation for derived key " + getName());
        }

        @Override
        public String getDocName() {
            return null;
        }
    }

    TimerKeyImpl(String nameFormat, Object nameArg1, Object nameArg2) {
        super(new FlatTimer(nameFormat, nameArg1, nameArg2), nameFormat, nameArg1, nameArg2);
        ((FlatTimer) flat).accm = this;
    }

    @Override
    public DebugCloseable start(DebugContext debug) {
        if (debug.isTimerEnabled(this)) {
            Timer result = new Timer(this, debug);
            debug.currentTimer = result;
            return result;
        } else {
            return VOID_CLOSEABLE;
        }
    }

    public static String valueToString(long value) {
        return String.format("%d.%d ms", value / 1000000, (value / 100000) % 10);
    }

    @Override
    public TimerKey getFlat() {
        return (FlatTimer) flat;
    }

    @Override
    public String toHumanReadableFormat(long value) {
        return valueToString(value);
    }

    @Override
    public TimeUnit getTimeUnit() {
        return TimeUnit.NANOSECONDS;
    }

    final class Timer extends CloseableCounter implements DebugCloseable {
        final DebugContext debug;

        Timer(AccumulatedKey counter, DebugContext debug) {
            super(debug, debug.currentTimer, counter);
            this.debug = debug;
        }

        @Override
        public void close() {
            super.close();
            debug.currentTimer = parent;
        }

        @Override
        protected long getCounterValue() {
            return TimeSource.getTimeNS();
        }

    }

    @Override
    public Pair<String, String> toCSVFormat(long value) {
        return toCSVFormatHelper(value);
    }

    static Pair<String, String> toCSVFormatHelper(long value) {
        return Pair.create(Long.toString(value / 1000), "us");
    }

    @Override
    public TimerKey doc(String doc) {
        setDoc(doc);
        return this;
    }
}
