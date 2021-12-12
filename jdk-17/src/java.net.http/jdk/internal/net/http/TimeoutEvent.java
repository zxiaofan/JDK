/*
 * Copyright (c) 2015, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.internal.net.http;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Timeout event notified by selector thread. Executes the given handler if
 * the timer not canceled first.
 *
 * Register with {@link HttpClientImpl#registerTimer(TimeoutEvent)}.
 *
 * Cancel with {@link HttpClientImpl#cancelTimer(TimeoutEvent)}.
 */
abstract class TimeoutEvent implements Comparable<TimeoutEvent> {

    private static final AtomicLong COUNTER = new AtomicLong();
    // we use id in compareTo to make compareTo consistent with equals
    // see TimeoutEvent::compareTo below;
    private final long id = COUNTER.incrementAndGet();
    private final Duration duration;
    private final Instant deadline;

    TimeoutEvent(Duration duration) {
        this.duration = duration;
        deadline = Instant.now().plus(duration);
    }

    public abstract void handle();

    public Instant deadline() {
        return deadline;
    }

    @Override
    public int compareTo(TimeoutEvent other) {
        if (other == this) return 0;
        // if two events have the same deadline, but are not equals, then the
        // smaller is the one that was created before (has the smaller id).
        // This is arbitrary and we don't really care which is smaller or
        // greater, but we need a total order, so two events with the
        // same deadline cannot compare == 0 if they are not equals.
        final int compareDeadline = this.deadline.compareTo(other.deadline);
        if (compareDeadline == 0 && !this.equals(other)) {
            long diff = this.id - other.id; // should take care of wrap around
            if (diff < 0) return -1;
            else if (diff > 0) return 1;
            else assert false : "Different events with same id and deadline";
        }
        return compareDeadline;
    }

    @Override
    public String toString() {
        return "TimeoutEvent[id=" + id + ", duration=" + duration
                + ", deadline=" + deadline + "]";
    }
}
