/*
 * Copyright (c) 2016, 2018, Oracle and/or its affiliates. All rights reserved.
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

package jdk.jfr.consumer;

import static jdk.jfr.internal.EventInstrumentation.FIELD_DURATION;

import java.io.IOException;
import java.util.List;

import jdk.jfr.EventType;
import jdk.jfr.ValueDescriptor;
import jdk.jfr.internal.consumer.RecordingInput;

/**
 * Parses an event and returns a {@link RecordedEvent}.
 *
 */
final class EventParser extends Parser {
    private final Parser[] parsers;
    private final EventType eventType;
    private final TimeConverter timeConverter;
    private final boolean hasDuration;
    private final List<ValueDescriptor> valueDescriptors;

    EventParser(TimeConverter timeConverter, EventType type, Parser[] parsers) {
        this.timeConverter = timeConverter;
        this.parsers = parsers;
        this.eventType = type;
        this.hasDuration = type.getField(FIELD_DURATION) != null;
        this.valueDescriptors = type.getFields();
    }

    @Override
    public Object parse(RecordingInput input) throws IOException {
        Object[] values = new Object[parsers.length];
        for (int i = 0; i < parsers.length; i++) {
            values[i] = parsers[i].parse(input);
        }
        Long startTicks = (Long) values[0];
        long startTime = timeConverter.convertTimestamp(startTicks);
        if (hasDuration) {
            long durationTicks = (Long) values[1];
            long endTime = timeConverter.convertTimestamp(startTicks + durationTicks);
            return new RecordedEvent(eventType, valueDescriptors, values, startTime, endTime, timeConverter);
        } else {
            return new RecordedEvent(eventType, valueDescriptors, values, startTime, startTime, timeConverter);
        }
    }
}
